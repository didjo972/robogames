/**
	FineTune - Responsive Creative Portfolio Template
 	Copyright (c) 2012, Subramanian 

	Author: Subramanian
    Profile: themeforest.net/user/FMedia/
	
    Version: 1.0.0
	Release Date: 02 November 2012
	
**/



(function( $ ){	

	function fmMainSlider(selector, params){
		// default variables
		var defaults = $.extend({}, { 
			pageBgResize : true,
			slideshowDelayTime : 2.5,
			slideNumber : undefined,
			nextPreviousButton : true,
			playPause : false,
			autoplay : true,
			mouse_drag : true,
			numberOfthumbnails : undefined
		} , params);
		
		// Initialize required variables and objects
		var self = this;
		self.pageBgResize = defaults.pageBgResize;
		self.delaySec = defaults.slideshowDelayTime;
		self.plaPau = defaults.playPause;
		self.nexPreBtn  = defaults.nextPreviousButton;
		self.numThum =  defaults.numberOfthumbnails
		self.spd = 0;
		self.ele = [];
		self.cur = 0;
		self.pre = 0;
		self.slideshow = defaults.autoplay;
		self.resetSlideshow = defaults.autoplay;
		self.pauseNow = false;
		self.finishPlay = false;
		self.IE_old = $.browser.msie;
		self.ssInt;
		self.ssChk;
		
		self.loadNew = true;
		
		self.selEle = $(selector);

		if(selector.length == 0)
		return
		
		var allSlides = self.selEle.find(".fmSlides");
		
		if(self.IE_old){
			allSlides.css({"overflow-x":"hidden"});
		}
		
		/* Create a navigation */
		if(defaults.slideNumber || self.nexPreBtn || self.plaPau){
			self.selEle.prepend('<div class="navigations"  ></div>');
			self.navHold = self.selEle.children(":first-child")
		}
		
		/* Add slide number if required */
		if(defaults.slideNumber){
			self.navHold.prepend('<div class="fmslider_sliderNumber"> <span id="sliderNumber"></span>/ <span id="totalSlides" ></span> </div>');
			self.num = self.selEle.find("#sliderNumber");
			self.numOfSlides = self.selEle.find("#totalSlides");
		}
		 
		/* Store all slides on Array */
		if(!isNaN(self.numThum)){
			var sl =  allSlides;
			var aa = 0;
			var ss = [];
			 
			sl.children().each(function(){
				ss.push($(this));
			});
			 
			var kz = [];
			ff = 0;
			  
			sl.append('<div class="columns alpha fmSlider_animate" ><div class="mobile_spacing"></div></div>');
			var ns = sl.children(":last-child").children(":first-child"); 
			 
			for(var jj=0; jj<ss.length; jj++){
				if(ff < self.numThum ){
					ff++;
					(ns).append(ss[jj]);
				 }else{
					ff = 1;
					sl.append('<div class="columns alpha fmSlider_animate" ><div class="mobile_spacing"></div></div>');
					ns = sl.children(":last-child").children(":first-child");
					(ns).append(ss[jj]);
				}
			 }
		 }

		
		self.allSlideHolder = self.selEle.find(".fmSlides");
		 
		self.allSlideHolder.children().each(function(){
				$(this).css({"opacity":0, "left": self.selEle.width()});
				self.ele.push($(this));
			}
		)
		
		if(self.numOfSlides){
			self.numOfSlides.text(self.ele.length);
		}

		self.ele[self.ele.length-1].css({"opacity":0, "left": -self.ele[self.ele.length-1].width()});
		self.cur = self.ele.length;
		
		/* Play Pause Button */
		if(self.plaPau){
			self.navHold.prepend('<div  class="fmSlider_plaPau" ><div  class="fmSlider_plaPau_inner"> <div class="fmSlider_plaPau_icon"> </div></div></div>');
			self.plaPau = self.navHold.children(":first-child");
			
			self.plaPau.each(function(){
				var selor = $(this);	
				selor.click(function(){
					if(!self.slideshow){
						self.plaPau.children(":first-child").children(":first-child").css({"right" : "-40px"});
						self.slideshow = true;
						self.Start();
						
					}else{
						self.plaPau.children(":first-child").children(":first-child").css({"right" : "0px"});
						self.slideshow = false;
						self.Pause();
					}
				});
			});
			
			if(!self.slideshow){
				self.plaPau.children(":first-child").children(":first-child").css({"right" : "0px"});
			}
		}
		
		
		/* Next Previous Button */
		if(self.nexPreBtn){
			self.navHold.prepend(' <div class="next_previous_btn">  <a class="alignRight next_btn" ></a> <a class="alignRight previous_btn" ></a> </div>');
			self.npBtn = self.navHold.children(":first-child");
			self.navHold.hide();
			if(isTouch){
				self.npBtn.find(".next_btn").removeClass("enableTransition"); 
				self.npBtn.find(".previous_btn").removeClass("enableTransition"); 
			}else{
				self.npBtn.find("a.next_btn").addClass("enableTransition"); 
				self.npBtn.find("a.previous_btn").addClass("enableTransition"); 
			}
			
			self.npBtn.find(".next_btn").click(function(){
				self.Next();
			});
			
			self.npBtn.find(".previous_btn").click(function(){
				self.Previous();
			});
		}
		
		self.allSlideHolder.bind('mouseover mouseup mouseleave', function() {
			self.Pause();
		});
		
		self.allSlideHolder.bind('mouseout', function() {
			if(self.slideshow){
				self.slideshowDelay();
			}
		});
		
		
		
		// slide Drag Coding
	
		var tm;
		var tmArr=[];
		var tmMovChk;
		var tmRevMov = false;
		var bgDrgPos = 0;
		var strDrg = false;
		self.drgPosDir = 0;
		
		var mainCon = self.selEle;
		self.moveItem = self.allSlideHolder;
		
		/* Add Mouse cursor */
		if(defaults.mouse_drag ){
			if(!this.hasTouch) {
				self.moveItem.addClass("fm_drag-cursor");
				self.moveItem.bind('mousedown', function() {		
					tmRevMov = false;
					self.moveItem.removeClass("fm_drag-cursor");
					self.moveItem.addClass("fm_draging-cursor");
					mouseDragInit();
				});
			}
			
			// Start to drag using below functionv
			var dragStart = function(){
				if(tch != tch_){
					strDrg = true;
					thClick = false;
				}
				self.moveItem.stop();
				tm = Math.round(Math.abs(Number(tch_)-Number(tch)))< 101? 
				Math.round(Math.abs(Number(tch_)-Number(tch))) : Math.round(100 + Math.abs(100-(Math.abs(Number(tch_)-Number(tch))))*.2);
				
				if(self.finishPlay){
					if((Number(tch_) > Number(tch))){
						self.moveItem.css({"left":Number(tm)+"px"});
					}else{
						self.moveItem.css({"left":-Number(tm)+"px"});
					}
				}
			};
			
			// Stop drag using below function, The next and previous slide will start here
			var dragStop = function(){
				 
				if(Number(tch) != Number(tch_) && self.finishPlay){
					if(Number(tch) > Number(tch_) ){
	
						if(((Number(tch) - Number(tch_)) > 50 || tmMovChk>5) && !tmRevMov){
							self.moveItem.stop();
							if (!$.browser.msie){
								self.moveItem.animate({"left":Number(-tm-(mainCon.width()*.36))+"px", "opacity":0},300, function(){ dragFinish(); } );
							}else{
								self.moveItem.animate({"left":Number(-tm-(mainCon.width()*.36))-self.moveItem.width()+"px"},300, function(){ dragFinish(); } );
							}
							self.drgPosDir = 1;
							
						}else{
							self.moveItem.stop();
							self.moveItem.animate({"left":"0px"});
						}
						
					}else{
						
						if(((Number(tch_)-Number(tch)) > 50 || tmMovChk>5) && !tmRevMov){
							self.moveItem.stop();
							if (!$.browser.msie){
								self.moveItem.animate({"left":Number(tm+(mainCon.width()*.36))+"px", "opacity":0},300, function(){ dragFinish(); } );
							}else{	
								self.moveItem.animate({"left":Number(tm+(mainCon.width()*.36))+self.moveItem.width()+"px"},300, function(){ dragFinish(); });
							}
							self.drgPosDir = -1;
						}else{
							self.moveItem.stop();
							self.moveItem.animate({"left":"0px"});
						}
					}
				}
				tm = 0;
			};
			
			// Mousedown event for drag
			
			var mouseDragInit = function(){	
	
				$(document).bind('mousedown.fmDragEvent', function(e) {
					tch = tch_ = Math.abs(e.clientX);
					tmArr = [];
					tmArr.push(tch);
					
					bgDrgPos = parseInt(self.moveItem.css("left"));
					
					$(document).bind('mousemove.fmDragEvent', function(e) {
						tmRevMov = tch_ > Math.abs(e.clientX) ? (Number(tch) > Number(tch_)) ? false:true : (Number(tch) < Number(tch_)) ? false : true;
						tch_ = Math.abs(e.clientX);
						tmArr.push(tch_);
						tmMovChk = Math.abs((tmArr[tmArr.length-1]-tmArr[tmArr.length-2]));
						dragStart();



						return false;
					});
					
					return false;
				});
				
				$(document).bind('mouseup.fmDragEvent', function() {
					strDrg = tch != tch_ ? false : true;
					$(document).unbind('mousedown.fmDragEvent');
					$(document).unbind('mouseleave.fmDragEvent');
					$(document).unbind('mousemove.fmDragEvent');
					$(document).unbind('mouseup.fmDragEvent');	
					
					self.moveItem.removeClass("fm_draging-cursor");
					self.moveItem.addClass("fm_drag-cursor");
	
					dragStop();
					return false;
				});
				
				
				$(document).bind('mouseleave.fmDragEvent', function() {
					strDrg = false;
					$(document).unbind('mousedown.fmDragEvent');
					$(document).unbind('mouseleave.fmDragEvent');
					$(document).unbind('mousemove.fmDragEvent');
					$(document).unbind('mouseup.fmDragEvent');	
					
					self.moveItem.removeClass("fm_draging-cursor");
					self.moveItem.addClass("fm_drag-cursor");
					
					return false;
				});
			};
	
			
			// Touch screen Enable
			
			var touEle = self.moveItem;
			var tch = 0;
			var tch_ = 0;
			var tchY = 0;
			var tchY_ = 0;
			
			try {
				document.createEvent('TouchEvent');
				
				$(touEle).each(function() {
					this.ontouchstart = function(e) {
							touchStart(e);
							return true;
						};
					this.ontouchend = function(e) {
						touchEnd();
						return true;
					};	
					
					this.ontouchmove = function(e) {
						touchMove(e);
						if(!isMobile){
							e.preventDefault();
							e.stopPropagation();
							return false;
						}
					};
					
					this.find('.nonDraggable').bind("mousedown", function(e) {				
						e.stopImmediatePropagation();
					});	
				});
				
				
				
			} catch (e) {
				// Nothing to do
			}
					
						
			var touchStart = function(e) {
				tch = tch_ = Math.abs(e.clientX);
				tmArr = [];
				tmArr.push(tch);
				self.moveItem.stop();
				bgDrgPos = parseInt(self.moveItem.css("left"));
				tch = tch_ =  e.targetTouches[0].clientX;
				
				tchY = tchY_ = e.targetTouches[0].clientY;
			};
				 
			var touchEnd = function() {
				dragStop();
				if(Math.abs(tchY - tchY_) > 100){
					self.moveItem.stop();
					self.moveItem.css({"left":0+"px", "opacity":1});
				}
			};
	
			var touchMove = function(e) {
				tchY_ = e.targetTouches[0].clientY;
				if(Math.abs(tchY - tchY_) < 100){
					tmRevMov = tch_ > Math.abs(e.targetTouches[0].clientX) ? (Number(tch) > Number(tch_)) ? false:true : (Number(tch) < Number(tch_)) ? false : true;
					tch_ = Math.abs(e.targetTouches[0].clientX);
					tmArr.push(tch_);
					tmMovChk = Math.abs((tmArr[tmArr.length-1]-tmArr[tmArr.length-2]));
					dragStart();
				}else{
					self.moveItem.stop();
					self.moveItem.css({"left":0+"px", "opacity":1});
				}
			};
			
			var dragFinish = function(){
				if(Math.abs(tchY - tchY_) < 100){
					self.moveItem.stop();
					self.moveItem.css({"left":0+"px", "opacity":1});
					if(self.finishPlay){
						self.spd = 0;
						$(self.ele[self.cur]).css({"opacity":0, "left":$(self.selEle).width()} );
						if(self.drgPosDir<0){
							self.Previous();
						}else{
							self.Next();
						}
					}
				}else{
					self.moveItem.stop();
					self.moveItem.css({"left":0+"px", "opacity":1});
				}
			}
			
			// Drag coding end
		}
	}
	

	fmMainSlider.prototype = {
		
		/* start the slide animation */
		Start : function(){	
			var self = this;
			
				self.finishPlay = false;
				self.pauseNow = false;
				self.cur = self.ele.length > self.cur+1? self.cur+1 : 0;
				var dir = self.drgPosDir != 0? self.drgPosDir : 1;
				
				$(".contentWarp").css({"height" : $(".contentWarp").height()});
				if(self.navHold && self.loadNew){
					self.loadNew = false;
					self.navHold.delay(1000).fadeIn();
				}
				
				if($(self.ele[self.pre]).hasClass('fmSlider_animate') && !isMobile && !self.IE_old){
					var sel1 = $(self.ele[self.pre]).children(":first-child").children();
					var kk2 = self.drgPosDir == 0 && !isMobile ? 5*sel1.length : 0;
					var kk = dir>0 ? 0: sel1.length;
					sel1.each(function(){
						$(this).stop();
						kk = dir > 0 ? kk+1 : kk-1;
						$(this).delay(20*kk).animate({"left":550*(-dir)},1000,"easeInOutQuart");
					})
				}
				
				$(self.ele[self.pre]).stop();
				
				$(self.ele[self.pre]).delay(kk2).animate({"opacity":0, "left":-$(self.ele[self.pre]).width()}, self.spd ,"easeInOutQuart",function(){
					
					for(var ii=0; ii<self.ele.length; ii++){
						$(self.ele[ii]).css({"left": $(self.selEle).width(),"position": "absolute", "visibility":"hidden", "top":"-10000px"});
					}
					self.moveItem.stop();
					self.moveItem.css({"left":0+"px", "opacity":1});
					$(self.ele[self.cur]).css({"position": "relative", "visibility":"visible", "top":"0"});

					
						if(isMobileChk  && !self.pageBgResize){
							$(".pageHolder").css({"height" : "auto"});
							$(".pageHolder .page").css({"height" : "auto"});
							$(".contentWarp").css({"height" : "auto"});
						}else{
							if(self.pageBgResize){
								$("body").mainFm('pageBgRepos'); 
							}
						}
					
					
					self.spd = 1000;
					self.pre = self.cur;
					if(self.drgPosDir<0){	
						$(self.ele[self.cur]).css({"left": -$(self.ele[self.cur]).width()}) 
					};
					
					if(self.num){
						$(self.num).text(self.cur+1);
					}
					
					if($(self.ele[self.cur]).hasClass('fmSlider_animate')){
						var sel2 = $(self.ele[self.cur]).children(":first-child").children();
						sel2.each(function(){
							$(this).stop();
							if(!isMobile &&  !self.IE_old){
								$(this).css({"left":(550*dir)+"px","opacity":"0"});
								self.spd  = 0;
							}else{
								$(this).css({"left":"0px","opacity":"1"});
							}
						})
					}

					self.drgPosDir = 0;
					self.allSlideHolder.stop();
					self.allSlideHolder.css({"opacity": 1, "left":0});
					$(self.ele[self.cur]).stop();
					
					if($(self.ele[self.cur]).hasClass('fmSlider_animate') && !isMobile  && !self.IE_old){
						sel2.each(function(){
							$(this).css({"visibility":"hidden"});
						})
					}
						
					$(self.ele[self.cur]).animate({"opacity": 1, "left":0},self.spd,"easeInOutQuart",function(){
						if($(self.ele[self.cur]).hasClass('fmSlider_animate') && !isMobile  && !self.IE_old){
							var kk = dir>0 ? 0: sel2.length;
							sel2.each(function(){
								$(this).stop();
								kk = dir > 0 ? kk+1 : kk-1;
								$(this).css({"visibility":"visible"})
									   .delay(50*(kk)).animate({"left":"0px","opacity":1, "visibility":"visible"},1000,"easeInOutQuart");
							
							})
						}
						
						self.spd = 1000;
						self.finishPlay = true;
						if(self.slideshow && !self.pauseNow){
							self.slideshowDelay();
						}
					});
					
						
				});
		},
		
		/* Slide show delay */
		slideshowDelay : function(){
			var self = this;
			clearInterval(self.ssChk);
			self.ssChk = setInterval(function(){
				if(self.finishPlay){
					clearInterval(self.ssChk);
					self.ssInt = setInterval(function(){
						clearInterval(self.ssInt);	
						self.Start();
					}, 1500*self.delaySec)
				}
			}, 50)
		},
		
		/* Previous slide action */
		Previous: function(){
			var self = this;
			if(self.finishPlay){
				clearInterval(self.ssChk);
				clearInterval(self.ssInt);
				self.cur = self.cur-2 < -1 ? self.ele.length-2 : self.cur-2;
				self.Start();
			}
		},
		
		/* Next slide action */
		Next: function(){
			var self = this;
			if(self.finishPlay){
				clearInterval(self.ssChk);
				clearInterval(self.ssInt);
				self.Start();
			}
		},
		
		/* Pause slide action */
		Pause : function(){
			var self = this;
			self.pauseNow  = true;
			clearInterval(self.ssChk);
			clearInterval(self.ssInt);
		},
		
		/* Stop slide action */
		Stop : function(){
			var self = this;
			clearInterval(self.ssChk);
			clearInterval(self.ssInt);
			self.cur = self.ele.length-1;
			self.pre = 0;
			self.spd = 0;
			self.finishPlay = false;
			self.slideshow = false;
			self.loadNew = true;
			if(self.navHold){ self.navHold.hide(); }
			for(var ii=0; ii<self.ele.length; ii++){
				$(self.ele[ii]).stop();
				$(self.ele[ii]).css({"opacity":0, "left": $(self.selEle).width(),"position": "absolute"});
			}
			$(self.ele[0]).css({"left": $(self.selEle).width(),"position": "relative"});
			if(self.num){
				$(self.num).text(1);
			}
		},
		
		/* Restart the slider */
		ReStart : function(){
			var self = this;
			self.Stop();
			self.slideshow = self.resetSlideshow;
			if(self.plaPau){
				if(self.resetSlideshow){
					self.plaPau.children(":first-child").children(":first-child").css({"right" : "-40px"});
				}else{
					self.plaPau.children(":first-child").children(":first-child").css({"right" : "0px"});
				}
			}
			clearInterval(self.ssChk);
				clearInterval(self.ssInt);
			self.Start();
		},
		
		/* Resume the slider if it pause */
		Resume: function(){
			var self = this;
			if(self.finishPlay && self.slideshow){
				clearInterval(self.ssChk);
				clearInterval(self.ssInt);
				self.slideshowDelay();
			}
		}
		
		
		
			
	};

	/*  Initizlize and create the slider plug-in */
	$.fn.fmMainSlider = function(params) {
		var $fm = $(this);
		var instance = $fm.data('GBInstance');
		if (!instance) {
			if (typeof params === 'object' || !params){
				return $fm.data('GBInstance',  new fmMainSlider($fm, params));	
			}
		} else {
			if (instance[params]) {					
				return instance[params].apply(instance, Array.prototype.slice.call(arguments, 1));
			}
		}
	};
	
	
})( jQuery );
