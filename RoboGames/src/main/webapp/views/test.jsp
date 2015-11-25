<!DOCTYPE html>

<!-- /**
	FineTune - Responsive Creative Portfolio Template
 	Copyright (c) 2012, Subramanian 

	Author: Subramanian
    Profile: themeforest.net/user/FMedia/
	
    Version: 1.0.0
	Release Date: 02 November 2012
**/ -->	

    <html lang="en"> 
    
    <head>

	<!-- Basic Page Needs
  ================================================== -->
	<meta charset="utf-8">
	<title>FineTune - Responsive Creative Portfolio Template</title>
	<meta name="description" content="">
	<meta name="author" content="">

	<!-- Mobile Specific Metas
  ================================================== -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	<!-- CSS
  ================================================== --> 
  
  <!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->


	<!-- Favicons
	================================================== -->
	<link rel="shortcut icon" href="images/favicon.ico">
	<link rel="apple-touch-icon" href="images/apple-touch-icon.png">
	<link rel="apple-touch-icon" sizes="72x72" href="images/apple-touch-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="114x114" href="images/apple-touch-icon-114x114.png">
  	
    <!-- Included CSS files 
	================================================== -->
    
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>
    
  	<link rel="stylesheet" type="text/css"  href="css/main.min.css">
	<link rel="stylesheet" type="text/css"  href="css/base.min.css">
    <link rel="stylesheet" type="text/css"  href="css/color.css">
	<link rel="stylesheet" type="text/css"  href="css/skeleton.min.css">
	<link rel="stylesheet" type="text/css"  href="css/jquery.fancybox-1.3.4.min.css" media="screen" />
    <link rel="stylesheet" type="text/css"  href="css/flexslider.min.css" media="screen" />


    <!-- Included javascript files 
	================================================== -->
    
    
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <!--[if !IE]><!-->
	<script src="js/ios6-timers.js"></script> 
    <!--<![endif]-->
	<script type="text/javascript" src="js/custom.min.js"></script>
    <script type="text/javascript" src="js/jquery.vegas.min.js" ></script>   
	<script type="text/javascript" src="js/jquery.fancybox-1.3.4.min.js"></script>  
    <script type="text/javascript" src="js/jquery.isotope.min.js" ></script>  
    <script type="text/javascript" src="js/jquery.flexslider.min.js"></script>
    <script type="text/javascript" src="js/jquery.jscrollpane.min.js"></script>
    <script type="text/javascript" src="js/jquery.slider.min.js"></script>
    <script type="text/javascript" src="js/main-fm.min.js"></script>  

    <script>

		
		/* Site Main plug-in initilize */
		
		$(document).ready(function(){
			
			jQuery(function($){
				$("body").mainFm({
			/*	
			Set page background for each page. Just add the image path on variables src(Desktop size image) and src_small(Mobile size image). 
			Add those variables as per number of pages, If you need to remove the page background, just remove the src value and leave it blank.
			Ex: {src : '', src_small : ''} 
			Each page background can be add one by one as per page level. 
			First you need to add all main pages than after subpage background will be added in sequence
			Don't leave any page, it will affect the page order
			
			 */
					pageBackground 	: [	
					
						{ src : 'images/background//background1.jpg', src_small : 'images/background//background1_s.jpg'},   // Main Page 			- Home
						{ src : 'images/background//background2.jpg', src_small : 'images/background//background2_s.jpg'},   //						- About us	
						{ src : '', src_small : ''},   															   			 //						- Portfolio
						{ src : '', src_small : ''},															   			 //						- Gallery
						{ src : 'images/background//background4.jpg', src_small : 'images/background//background4_s.jpg'},   //						- News
						{ src : '', src_small : ''},															  			 //						- Blog
						{ src : 'images/background//background5.jpg', src_small : 'images/background//background5_s.jpg'},   //						- Feature					
						{ src : 'images/background//background6.jpg', src_small : 'images/background//background6_s.jpg'},   //						- Contact us
						
						
						{ src : 'images/background//background3.jpg', src_small : 'images/background//background3_s.jpg'},   // Subpage(Portfolio)	- Portfolio column 5
						{ src : 'images/background//background11.jpg', src_small : 'images/background//background11_s.jpg'}, //						- Portfolio column 1
						{ src : 'images/background//background12.jpg', src_small : 'images/background//background12_s.jpg'}, //						- Portfolio single project
						{ src : 'images/background//background13.jpg', src_small : 'images/background//background13_s.jpg'}, //						- Portfolio column 4
						{ src : 'images/background//background14.jpg', src_small : 'images/background//background14_s.jpg'}, //						- Portfolio column 3
						{ src : 'images/background//background15.jpg', src_small : 'images/background//background15_s.jpg'}, //						- Portfolio column 2
						
						{ src : 'images/background//background7.jpg', src_small : 'images/background//background7_s.jpg'},   // Subpage(Gallery)	- Full screen
						{ src : 'images/background//background8.jpg', src_small : 'images/background//background8_s.jpg'},   //						- Isotope
						{ src : 'images/background//background9.jpg', src_small : 'images/background//background9_s.jpg'},   //						- Slideshow
											
						{ src : 'images/background//background10.jpg', src_small : 'images/background//background10_s.jpg'}, // Subpage(Blog)		- All post 
						{ src : 'images/background//background10.jpg', src_small : 'images/background//background10_s.jpg'}, //						- Single page
						{ src : '', src_small : ''} 															   			 //						- White Theme
					],
					
				/* set whether it's an one page or separate page file, if it's set false, the template works like a separate page version*/
					onePage : true,
					
				/* Set the opening page. 
					leave it blank value if you need to show the home page as a opening page*/
					homePage : "",
				
				/* Set background overlay patter */							
					backgroundOverlay 	: 'images/background_overlay.png',
					
				/* set pageHolder height, if you need to set all the page height in liquid and not align to center,
				just set value "100%" to the below 2 varaibles */	
					pageHolderHeight_desktop : 420,
					pageHolderHeight_ipad : 380,
					
				/* Full screen gallery options for autoplay and slideshow delay time*/
					galleryAutoplay : "true",
					gallerySlideshowDelay : 1.5,
				/* Full screen gallery default image resize types. Options are fill/fit/none */
					galleryImageResize : "fill",
					
				/* FlexSlider slideshow speed */
					slideshowSpeed : 5000
					
				});
			});

			
			
/* Home page Slider */			
			$(function(){
				$(".slider1").fmMainSlider({ 
					pageBgResize:true, 			// Boolean: It used to resize the height of the background as per the slider height
					slideNumber : true, 		// Boolean: Create slide number
					playPause : true, 			// Boolean: Create play pause button
					nextPreviousButton : true, 	// Boolean: Create next button
					autoplay : true, 			// Boolean: Enable auto play
					slideshowDelayTime : 2.5, 	// Integer: slideshow delay time
					mouse_drag : true 			// Boolean: Enable mouse drag action
				});
			});
	
				
/* portfolio Slider */	
			
			
			// portfolio column 5	
			$(function(){
				$(".slider2").fmMainSlider({ 
					pageBgResize:false, 		// Boolean: It used to resize the height of the background as per the slider height
					slideNumber : true, 		// Boolean: Create slide number
					playPause : false,			// Boolean: Create play pause button
					nextPreviousButton : true,	// Boolean: Create next button
					autoplay : false,			// Boolean: Enable auto play
					mouse_drag : true,			// Boolean: Enable mouse drag action
					numberOfthumbnails : 10     // Integer: set number of thumbnail show on each slide
				});
			});
			
			
			// portfolio column 4	
			$(function(){
				$(".slider4").fmMainSlider({ 
					pageBgResize:false, 		// Boolean: It used to resize the height of the background as per the slider height
					slideNumber : true, 		// Boolean: Create slide number
					playPause : false,			// Boolean: Create play pause button
					nextPreviousButton : true,	// Boolean: Create next button
					autoplay : false,			// Boolean: Enable auto play
					mouse_drag : true,			// Boolean: Enable mouse drag action
					numberOfthumbnails : 8      // Integer: set number of thumbnail show on each slide
				});
			});
			
			
			// portfolio column 3	
			$(function(){
				$(".slider5").fmMainSlider({ 
					pageBgResize:false, 		// Boolean: It used to resize the height of the background as per the slider height
					slideNumber : true, 		// Boolean: Create slide number
					playPause : false,			// Boolean: Create play pause button
					nextPreviousButton : true,	// Boolean: Create next button
					autoplay : false,			// Boolean: Enable auto play
					mouse_drag : true,			// Boolean: Enable mouse drag action
					numberOfthumbnails : 6      // Integer: set number of thumbnail show on each slide
				});
			});
			
			// portfolio column 2	
			$(function(){
				$(".slider6").fmMainSlider({ 
					pageBgResize:false, 		// Boolean: It used to resize the height of the background as per the slider height
					slideNumber : true, 		// Boolean: Create slide number
					playPause : false,			// Boolean: Create play pause button
					nextPreviousButton : true,	// Boolean: Create next button
					autoplay : false,			// Boolean: Enable auto play
					mouse_drag : true,			// Boolean: Enable mouse drag action
					numberOfthumbnails : 4      // Integer: set number of thumbnail show on each slide
				});
			});
			
			// portfolio column 1	
			$(function(){
				$(".slider7").fmMainSlider({ 
					pageBgResize:false, 		// Boolean: It used to resize the height of the background as per the slider height
					slideNumber : true, 		// Boolean: Create slide number
					playPause : false,			// Boolean: Create play pause button
					nextPreviousButton : true,	// Boolean: Create next button
					autoplay : false,			// Boolean: Enable auto play
					mouse_drag : true,			// Boolean: Enable mouse drag action
					numberOfthumbnails : 2      // Integer: set number of thumbnail show on each slide
				});
			});
			
			// portfolio single project	
			$(function(){
				$(".slider8").fmMainSlider({ 
					pageBgResize:false, 		// Boolean: It used to resize the height of the background as per the slider height
					slideNumber : true, 		// Boolean: Create slide number
					playPause : false,			// Boolean: Create play pause button
					nextPreviousButton : true,	// Boolean: Create next button
					autoplay : false,			// Boolean: Enable auto play
					mouse_drag : true,			// Boolean: Enable mouse drag action
					numberOfthumbnails : 1      // Integer: set number of thumbnail show on each slide
				});
			});
			

				
/* News Slider */			
			$(function(){
				$(".slider3").fmMainSlider({ 
					pageBgResize:true,			// Boolean: It used to resize the height of the background as per the slider height
					slideNumber : true, 		// Boolean: Create slide number
					playPause : false,			// Boolean: Create play pause button
					nextPreviousButton : true,	// Boolean: Create next button
					autoplay : false,			// Boolean: Enable auto play
					mouse_drag : true,			// Boolean: Enable mouse drag action
					numberOfthumbnails : 5		// Integer: set number of thumbnail show on each slide
				});
			});
			
			
			
/* Remove google map. This map will add when page display */
			$(".page").find('#mapWrapper').each(function(){
				$(this).data('map', $(this).children(':first-child'));
				if(!$.browser.msie){
					$(this).children(':first-child').remove();
				}
			});
			
			
/* Initialize Gallery - isotope */
			$(function(){
			  
			  var $container = $('#gallery_isotope_1');
			  var $optionSets = $('#options .option-set'),
				  $optionLinks = $optionSets.find('a');
		
			  $optionLinks.click(function(){
				var $this = $(this);
				
				// don't proceed if already selected
				if ( $this.hasClass('selected') ) {
				  return false;
				}
				var $optionSet = $this.parents('.option-set');
				$optionSet.find('.selected').removeClass('selected');
				$this.addClass('selected');
		  
				// make option object dynamically, i.e. { filter: '.my-filter-class' }
				   var options = {},
					  key = $optionSet.attr('data-option-key'),
					  value = $this.attr('data-option-value');
				  // parse 'false' as false boolean
				  value = value === 'false' ? false : value;
				  options[ key ] = value;
				  if ( key === 'layoutMode' && typeof changeLayoutMode === 'function' ) {
					// changes in layout modes need extra logic
					changeLayoutMode( $this, options )
				  } else {
					// otherwise, apply new options
					$container.isotope( options );
				  }
				
				return false;
			  });
			  
			});
						
// Email submit action			
			$("#email_submit").click(function() { 
									
				$('#reply_message').removeClass();
				$('#reply_message').html('')
				var regEx = "";	 
								
				// validate Name				
				var name = $("input#name").val();  
				regEx=/^[A-Za-z .'-]+$/; 
				if (name == "" || name == "Name"  || !regEx.test(name)) { 
					$("input#name").val(''); 
					$("input#name").focus();  
					return false;  
				}
				
				// validate Email						  
				var email = $("input#email").val();  
				regEx=/^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}$/;											
				if (email == "" || email == "Email" || !regEx.test(email)) { 
					$("input#email").val(''); 
					$("input#email").focus();  
					return false;  
				}  
				
				// validate comment			
				var comments = $("textarea#comments").val(); 
				if (comments == "" || comments == "Comments..." || comments.length < 2) { 
					$("textarea#comments").val(''); 
					$("textarea#comments").focus();  
					return false;  
				}  
									
				var dataString = 'name='+ $("input#name").val() + '&email=' + $("input#email").val() + '&comments=' + $("textarea#comments").val();									
				$('#reply_message').addClass('email_loading');
				
				// Send form data to mailer.php 
				$.ajax({
					type: "POST",
					url: "mailer.php",
					data: dataString,
					success: function() {
						$('#reply_message').removeClass('email_loading');
						$('#reply_message').addClass('list3');
						$('#reply_message').html("Mail sent sucessfully")
						.hide()
						.fadeIn(1500);
							}
						});
				return false;
				
			});	
		});
			
	</script>

    
</head>
<body >


<!--
Site main frame begin
Note: Don't edit main frame, except comment area
-->



<div class="mobile_header menuBg_color" >
    	<!-- Place your logo here. The src is used to add the logo for ipad portrait view and data-src-small use to add logo for mobile device -->
        <div class="alignLeft ">
 			<a href="#!home"><img src="images/logo_ipad_portrait.png" data-src-small="images/logo_s.png" alt="logo text"></a>
        </div>
        
        <div class="mobile_topContact" ><h6 ><span class="list1 menuBg_color">011-258-3569</span></h6></div>
        
        <div id="mobile_nav"> 
        	<div class="menuBg_color">OPEN MENU </div> 
            <div class="menuBg_color">CLOSE MENU</div>
        </div>    
      
</div>

            
<div class="mainHeader" style="z-index:99999"   >

	<div class="logo" >
    	<!-- Place your logo here. The src is used to add logo for desktop view and data-src-small use to add logo for mobile device -->
 		<a href="#!home"><img src="images/logo.png" data-src-small="images/logo_s.png" alt="logo text"></a>
    </div>
    
    <div class="header"  >
    	<div class=" headerContent" >
        
        	<div class="nav" >
               	<ul>
                	<!--  Add require site page navigation -->                    
                    <li><a href="#!home">HOME</a></li> 
                    <li><a href="#!aboutus">ABOUT US</a></li>
                    <li><a href="#">PORTFOLIO</a> 
                    	<!-- Sub menu -->
                    	<ul>
                        	<li><a href="#!portfolio">Column 5</a></li>
                            <li><a href="#!portfolio_column1">Column 1</a></li>
                            <li><a href="#!portfolio_single">One items</a></li>
                            <li><a href="#!portfolio_column4">Column 4</a></li>
                            <li><a href="#!portfolio_column3">Column 3</a></li>
                            <li><a href="#!portfolio_column2">Column 2</a></li>
                        </ul>
                    </li>
                    <li><a href="#">gallery</a>
                    	<!-- Sub menu -->
                    	<ul>
                        	<li><a href="#!fullscreen_gallery">Full screen</a></li>
                            <li><a href="#!isotope">Isotope</a></li>
                            <li><a href="#!slideshow">Slideshow</a></li>
                        </ul>
                    </li>
                    <li><a href="#!news">NEWS</a></li>
                    <li><a href="#">Blog</a>
                    	<!-- Sub menu -->
                    	<ul>
                        	<li><a href="#!blog">All post</a></li>
                        	<li><a href="blog.html">single page</a></li>
                            <li><a href="../White version_one page/index.html">White Theme</a></li>
                        </ul>
                    </li>
                    <li><a href="#!features">FEATURES</a></li>
                    <li><a href="#!contactus" class="last">CONTACT US</a></li>                                      
                </ul>
             </div>
             
        </div>
	</div>
  
    
    <div class="footer" >
    		<div class=""><h6 class="bottomText"><span class="list1">011-258-3569</span></h6></div> 
    		<div class=""><h6 class="bottomText">Copyright © 2012 FMedia</h6></div>
            <!-- Social network web page link  -->
            <div >
                <ul class="social_bookmarks noMargin">                 
                  <li class="twitter noMargin"><a >Follow us on Twitter</a></li>
                  <li class="facebook noMargin"><a >Join our Facebook Group</a></li>
                  <li class="gplus noMargin"><a >Join me on Google Plus</a></li>
                  <li class="linkedin noMargin"><a >Add me on Linkedin</a></li>
                  <li class="rss noMargin"><a >RSS</a></li>
                </ul>
            </div>
            <div class="separator_mini"></div>  
	</div>

</div> 

    
<div id="bodyContent"  >

	<!-- Portfolio/News full details content are load in backArea id div  -->
	<div id="backArea"></div>
    
	<div class="contentWarp container" >
    <!-- Page content are loaded inside the pageHolder div  -->
		 <div class="pageHolder" ></div>        
	</div>

</div>


<!-- End site main frame -->


<!-- 
Begin Page content
 
Note: mobile_spacing class is used to add spacing arround the content in mobile device not in desktop,
if you remove the mobile_spacing class, the layout design doesn't effect in desktop it only effect in mobile device
 -->
  
<div class="container"  >

<!-- Home page -->
                
<div class="page sixteen columns" data-id="!home" >
    <div class="pgContent" >
                     
        <div class="slider1 fmSlider" >  
                       
          	<div class="fmSlides sixteen columns">
					
				<!--Note : On each slide, if you add the class fmSlider_animate, than each div inside the slide will make animate.
                The circular object, portfolio frame images action are written in custom.js file near // Home page slider items, comment line
                 -->


				<!-- slide 1 -->
                    
				<div class="columns alpha fmSlider_animate" >                     
					<div>
                    
                        <div class="five columns alpha offset-by-one">
                            <img src="images/home_slider/home_img1.png" alt="home_img" class="scale-with-grid" />
                        </div>  
                               
                        <div class="nine columns alpha">
							<div> <h1 class="large_font title_light light_color">Perfect Template</h1> </div>
							<div> <h4 class="extraBold"><span class="textBackground">for creative, fashion & corporate website</span></h4></div>
							<div class="separator_mini"></div> 
                        </div>     
                                                     
                        <div class="seven columns alpha" >
                        	<p><span class="tiny_font">We group of consectetur are a small adipiscing elit. Integer commodo tristique odio, quis fringilla ligula aliquet ut. Maecenas sed justo varius velit imperdiet bibendum. commodo tristique odio. quis fringilla ligula aliquet ut. Maecenas sed justo varius velit imperdiet bibendum. </span></p>
                                <br/>
                        </div> 
                         
					</div>
				</div>
                    
                    
            	<!-- slide 2 -->
                    
            	<div class="columns alpha fmSlider_animate" >                     
					<div> 
                    
                        <div class="three columns alpha offset-by-two">
                            <img src="images/home_slider/home_img2.png" alt="home_img" class="scale-with-grid" />
                        </div>  
                               
                        <div class="ten columns alpha">
							<h2 class="title_light" >I am John Charter a creative designer</h2>
							<div class="separator_mini"></div> 
                        </div>     
                                                     
                        <div class="ten columns alpha" >
							<p><span class="tiny_font">We group of consectetur are a small adipiscing elit. Integer commodo tristique odio, quis fringilla ligula aliquet ut. Maecenas sed justo varius velit imperdiet bibendum. commodo tristique odio. quis fringilla ligula aliquet ut. Maecenas sed justo varius velit imperdiet bibendum. </span></p>
							<p><span class="tiny_font">Loperm we group of consectetur are a small adipiscing elit. Integer commodo tristique odio, quis fringilla ligula aliquet ut. Maecenas sed justo varius velit imperdiet bibendum. commodo tristique odio. quis fringilla ligula aliquet ut. Maecenas sed justo varius velit imperdiet bibendum.</span></p>
                                <br/>
                        </div> 
                                
                        <div class="ten columns alpha">
                            <div class="alignRight right_spacing"><img  src="images/home_slider/home_img3.png" align="home image" /> </div>
                        </div>
                        
					</div>
				</div>
                
				
                <!-- slide 3 -->
                   
				<div class="sixteen columns alpha fmSlider_animate" >
					<div class="mobile_spacing">
                       
						<div class="circle_holder">  
							<a href="#!portfolio" class="no_decor">
								<div class="circle" >
									<div class="circle_mask">
										<img src="images/home_slider/home_img9.jpg" class="scale_fill circular_mask_img"  >  
									</div>
									<div class="circle_border"> </div>
									<div class="separator_mini"></div> 
									<div class="circle_description" ><span><strong>Portfolio</strong></span></div>
								</div> 
							</a>
						</div>
                             
						<div class="circle_holder">  
							<a  href="#!fullscreen_gallery" class="no_decor">
								<div class="circle" >
									<div class="circle_mask">
										<img src="images/home_slider/home_img10.jpg" class="scale_fill circular_mask_img"  >  
									</div>
									<div class="circle_border"> </div>
									<div class="separator_mini"></div> 
									<div class="circle_description"><span><strong>Gallery</strong></span></div>
								</div>
							</a>
						</div>
                            
						<div class="circle_holder">  
							<a  href="#!news" class="no_decor">
								<div class="circle" >
									<div class="circle_mask">
										<img src="images/home_slider/home_img11.jpg" class="scale_fill circular_mask_img"  >  
									</div>
									<div class="circle_border"> </div>
									<div class="separator_mini"></div> 
									<div class="circle_description"><span><strong>News</strong></span></div>
								</div>
							</a>
						</div>
                            
						<div class="circle_holder">  
							<a  href="#!contactus" class="no_decor">
								<div class="circle">
									<div class="circle_mask">
										<img src="images/home_slider/home_img12.jpg" class="scale_fill circular_mask_img"  >  
									</div>
									<div class="circle_border"> </div>
                                         
									<div class="separator_mini"></div> 
									<div class="circle_description"><span><strong>Contact us</strong></span></div>
								</div>
							</a>
						</div>
                            
					</div>
				</div>
                
                
                
					
				<!-- slide 4 -->
                    
				<div class="columns alpha fmSlider_animate" >
                	<div>
                            
						<div class="sixteen columns alpha ">
							<h1 class="title_light" >Check out our latest projects</h1>
                           	<div class="separator_mini"></div>
						</div>
						
                        
                        <div class="photo_holder">
							 <a href="#portfolio?p=0" class="img_skew_normal img_skew1" >
								<div class="photo_bg">
									<span class="photo_reflect"></span>
									<h6 class="title_light prjTitle" ><strong>project 1</strong></h6>
									<img src="images/home_slider/home_img4.jpg" alt="home_img" class="scale-with-grid" />
								
                                </div>
							</a>
						</div>
                           
						 <div class="photo_holder">
							<a href="#portfolio?p=1" class="img_skew_normal img_skew2" >
								<div class="photo_bg ">
									<span class="photo_reflect"></span>
									<h6 class="title_light prjTitle" ><strong>project 2</strong></h6>
									<img src="images/home_slider/home_img5.jpg" alt="home_img" class="scale-with-grid" />
								</div>
							</a>
						</div>
                           
						<div class="photo_holder">
							<a href="#portfolio?p=2" class="img_skew_normal img_skew3" >
								<div class="photo_bg ">
									<span class="photo_reflect"></span>
									<h6 class="title_light prjTitle" ><strong>project 3</strong></h6>
									<img src="images/home_slider/home_img6.jpg" alt="home_img" class="scale-with-grid" />
								</div>
							</a>
						</div>
                           
						<div class="photo_holder">
							<a href="#portfolio?p=3" class="img_skew_normal img_skew1" >
								<div class="photo_bg ">
									<span class="photo_reflect"></span>
									<h6 class="title_light prjTitle" ><strong>project 4</strong></h6>
									<img src="images/home_slider/home_img7.jpg" alt="home_img" class="scale-with-grid" />
								</div>
							</a>
						</div> 
                            
						<div class="photo_holder">
							<a href="#portfolio?p=4" class="img_skew_normal img_skew2" >
								<div class="photo_bg ">
									<span class="photo_reflect"></span>
									<h6 class="title_light prjTitle" ><strong>project 5</strong></h6>
									<img src="images/home_slider/home_img8.jpg" alt="home_img" class="scale-with-grid" />
								</div>
							</a>
						</div>
                           
                           
						<div class="photo_holder">
							<a href="#portfolio?p=5" class="img_skew_normal img_skew3" >
								<div class="photo_bg">
									<span class="photo_reflect"></span>
									<h6 class="title_light prjTitle" ><strong>project 6</strong></h6>
									<img src="images/home_slider/home_img13.jpg" alt="home_img" class="scale-with-grid" />
								</div>
							</a>
						</div>
                           
						<div class="photo_holder">
							<a href="#portfolio?p=6" class="img_skew_normal img_skew1" >
								<div class="photo_bg">
									<span class="photo_reflect"></span>
									<h6 class="title_light prjTitle" ><strong>project 7</strong></h6>
									<img src="images/home_slider/home_img14.jpg" alt="home_img" class="scale-with-grid" />
								</div>
							</a>
						</div>
                        
                	</div>            
				</div>
                    
                    
				<!-- slide 5 -->
                    
				<div class="sixteen columns alpha fmSlider_animate" >
					<div class="mobile_spacing">
                    
						<div class="sixteen columns alpha">
							<h1 class="title_light" >Our Clients</h1>
						</div>
						<div class="thumb_small" ><img  src="images/home_slider/client1.png" class="fsThumb-scale" alt="Wonder" /></div>
						<div class="thumb_small" ><img  src="images/home_slider/client2.png" class="fsThumb-scale" alt="Wonder" /></div>
						<div class="thumb_small" ><img  src="images/home_slider/client4.png" class="fsThumb-scale" alt="Wonder" /></div>
						<div class="thumb_small" ><img  src="images/home_slider/client3.png" class="fsThumb-scale" alt="Wonder" /></div>
						<div class="thumb_small" ><img  src="images/home_slider/client1.png" class="fsThumb-scale" alt="Wonder" /></div>
						<div class="thumb_small" ><img  src="images/home_slider/client2.png" class="fsThumb-scale" alt="Wonder" /></div>
						<div class="thumb_small" ><img  src="images/home_slider/client3.png" class="fsThumb-scale" alt="Wonder" /></div>
						<div class="thumb_small" ><img  src="images/home_slider/client4.png" class="fsThumb-scale" alt="Wonder" /></div>
						<div class="thumb_small" ><img  src="images/home_slider/client1.png" class="fsThumb-scale" alt="Wonder" /></div>
						<div class="thumb_small" ><img  src="images/home_slider/client3.png" class="fsThumb-scale" alt="Wonder" /></div>
						<div class="thumb_small" ><img  src="images/home_slider/client2.png" class="fsThumb-scale" alt="Wonder" /></div>
						<div class="separator_mini"></div> 
                        
					</div>
				</div>
              
              <!-- End slides -->
                  
			</div>
		</div>
         
    </div>
</div>

<!-- End Home page -->                 



            	
<!-- About US page -->
                
<div class="page" data-id="!aboutus" >
    <div class="pgContent" >
                        
        <div class="mobile_spacing">
            <h1 class="title_light">About Us</h1>
        </div>
                            
        <div class="separator_mini"></div> 

        <div class="scroll-pane full_size">
        <!-- Below content are placed inside the Scrollbar -->
        
        	 <div class="fifteen columns alpha" >
                <div class="mobile_spacing">
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam.</p>
                    <hr>
                 </div>
            </div>
            
            
            <div class="five columns alpha">
				<div class="mobile_spacing">
                
                    <h4>My Team</h4>
					<br/>
                                                                             
					<div class="row" > 
						<span class="smallImg " > <img class="border1" src="images/team_img1.jpg" alt="Wonder" /></span>                
						<h5 class="title title_bottomspace">Aline marke</h5>
						consectetur adipiscing elit ligula
					</div>
                                                                            
					<div >
						<span class="smallImg " ><img class="border1" src="images/team_img2.jpg" alt="Wonder" /></span>
						<h5 class="title title_bottomspace">Nissa revane</h5>
						Maecenas sed justo varius sed justo
					</div> 
                    
					<hr>
                   
				</div>
			</div>
        
        
        	<div class="nine columns alpha  offset-by-one" >
                <div class="mobile_spacing">
                
                    <!-- Tab Navigation Begin -->       
                    <ul class="tabs">
                        <li><a href="#skill" class="active" >Skill</a></li>
                        <li><a href="#demo_video">Video</a></li>
                        <li><a href="#strategy">Strategy</a></li>
                    </ul>
                                            
                    <!-- Tab Content -->                      
                    <ul class="tabs-content">
                    
						<li id="skill" class="active" >
                        	<div class="seven columns alpha ">
                                <div class="mobile_right_spacing">
                                	<br>
                                	<div class="graph_container">
                                        <ul>
                                            <li data-level="80%" ><a></a> <span>WEB DESIGN </span></li>
                                            <li data-level="60%"><a></a> <span>jquery</span></li>
                                            <li data-level="70%"><a></a> <span>Layout Design</span></li>
                                            <li data-level="90%"><a></a> <span>Wordpress</span></li>
                                            <li data-level="50%" class="last"><a></a> <span>SEO</span></li>
                                        </ul>
                                        <hr>
                                        <hr>
                                	</div>
                               </div>
							</div>
                        </li>              
                                                
                                                
						<li id="demo_video"> 
                        	<div class="tabVideo">
                                <div class="addVideo" data-width="100%" data-height="220px" data-autoplay="false" data-url="http://vimeo.com/45778774" > </div>	
                             </div>
						</li>                  
                              
                                                
                        <li id="strategy">
							<div class="nine columns alpha ">
                                <div class="mobile_right_spacing">
                                    <h5 class="title_uppercase" >Our strength</h5>
                                    <br>
                                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo.</p>
                                </div>
                            </div>
                           
                            <div class="nine columns alpha">
                                <div class="mobile_right_spacing">
                                    <p><span class="smallImg " ><img  class="border1" src="images/team_img3.jpg" alt="Wonder" /></span>Consectetuer ipsum dolor sit amet, lorem adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo.</p>
                                </div>
                            </div>
                        </li>
                                            
                    </ul>                                               
                    <!-- End Tab Example -->
                    
                    <hr>
                    <hr>
                                       
                </div>           
            </div>
                      
                                                
			<div class="fifteen columns alpha">
				<div class="mobile_spacing">
               		<h3 class="title_light">Our Services</h3> 
                    <hr>  
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam. lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim.</p>          
				</div>
			</div>  
                       
           <div class="separator_mini"></div> 
                                
            <div class="eight columns alpha" >
                <div class="mobile_spacing">
                    <img src="images/about_image.png" class="scale-with-grid" alt="about image" />
                </div>
            </div>
            
                          
            <div class="six columns offset-by-one alpha" > 
                <div class="mobile_spacing">
                    <img class="img-align-left" src="images/about_icon1.png" alt="about image" />
                    <h4 class="title_uppercase">Professional Design</h4><br/>
                    <img class="img-align-left" src="images/about_icon2.png" alt="about image" />
                    <h4 class="title_uppercase">Implement New Idea</h4><br/>
                    <img class="img-align-left" src="images/about_icon3.png" alt="about image" />
                    <h4 class="title_uppercase">Business profitable</h4><br/>
                    <img class="img-align-left" src="images/about_icon4.png" alt="about image" />
                    <h4 class="title_uppercase">Client satisfaction</h4><br/>
                </div>
            </div>  
                         
        <!-- End Scrollbar -->                  
        </div>
        
        <div class="separator_mini"></div> 
            
    </div>
</div>

<!-- End About US page -->




<!-- Portfolio page 

	This portfolio page plug-in initialize code is placed on header area. 
    You can see it near the comment line // portfolio column 5

-->

                
<div class="page sixteen columns" data-id="!portfolio" >                	
    <div class="pgContent" >
    
        <!-- slider -->          
        <div class="slider2 fmSlider fixedHeight" >  
          	<div class="fmSlides sixteen columns" >
            
            	<!-- project 1 -->
				<div class="fmSliderNode" >
                	
                    <!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb1.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
                    
                     <!-- project Name -->
					<div class="projName" ><h6><span>	Project 1 	</span></h6></div>
                     <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Default style - Mini description about project</em>	</span></h6></div>
                 
                 	<!-- project full details -->
					<div class="fullDetails" >
                    	
                        <!-- project image slide show -->
                    	<div class="projImgs">
                        	<div class="flexSlideshow" >
                        		<ul class="slides"> 
                                    <li><a  class="lazyload" href="images/portfolio/image1.jpg" data-src-small="images/portfolio/image1_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image2.jpg" data-src-small="images/portfolio/image2_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image3.jpg" data-src-small="images/portfolio/image3_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image4.jpg" data-src-small="images/portfolio/image4_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image5.jpg" data-src-small="images/portfolio/image5_s.jpg" title="Some text">image</a></li>
                            	</ul>
							</div>
						</div>
                        
                        <!-- project description -->
                        <div class="projDetails scroll-pane" >
						  	<div class="detail_spacing">
                            
                            	<h2 class="title_light">Project title 1 </h2>
                                
                                <strong>Date:</strong> October 2012 <br>
                                <strong>Client:</strong> Nikey Company <br>
                                <strong>Skills:</strong> Branding <br><br>
                                <strong>Software use</strong><br>
                                
                                <ul>
                                	<li class="list4">jQuery</li><br>
                                    <li class="list4">CSS3</li><br>
                                    <li class="list4">Flash</li><br>
                                	<li class="list4">wordpress</li>
                                </ul>
                                
                                <p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
 <strong>Live Url:</strong>  <a class="underLine"><em>Nikey Company</em></a>
 
 							</div >
                        </div>
                        
                    </div>
				</div>

				
                <!-- project 2 -->
                <div class="fmSliderNode"  >
                	
                     <!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb2.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					
                    <!-- project Name -->
                    <div class="projName" ><h6><span>	Project 2 	</span></h6></div>
                    <!-- project full details -->
					<div class="miniDesc" ><h6><span>	<em>Another style - Mini description about project</em>	</span></h6></div>
                
                	<!-- project full details -->
                    <div class="fullDetails" >
						<div class="container" >

							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
                                
									<h2 class="title_light">Project title 2 - <em>another style</em></h2>
         
									<div class="separator_mini"></div> 
                                    
                                    <!-- project image slide show -->
									<div class="flexSlideshow fixedSize" >
										<ul class="slides"> 
											<li><a  class="lazyload" href="images/slideshow/image4.jpg" data-src-small="images/slideshow/image4_s.jpg" title="Some text">image</a></li>
											<li><a  class="lazyload" href="images/slideshow/image3.jpg" data-src-small="images/slideshow/image3_s.jpg" title="Some text">image</a></li>
											<li><a  class="lazyload" href="images/slideshow/image1.jpg" data-src-small="images/slideshow/image1_s.jpg" title="Some text">image</a></li>
											<li><a  class="lazyload" href="images/slideshow/image2.jpg" data-src-small="images/slideshow/image2_s.jpg" title="Some text">image</a></li>
										</ul>
									</div>
                                
									<div class="separator_mini"></div> 
                                            
									<strong>Date:</strong> October 2012 <br>
									<strong>Client:</strong> Mapiya Company <br>
									<strong>Skills:</strong> Branding <br><br>
									<strong>Software use</strong><br>
                                    
									<ul>
										<li class="list4">jQuery</li><br>
										<li class="list4">CSS3</li><br>
										<li class="list4">nocss</li><br>
										<li class="list4">wordpress</li>
									</ul>
									
                                    <p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.	</p>
									
                                    <p>Ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
             						<strong>Live Url:</strong>  <a class="underLine"><em>Mapiya Company</em></a>

									<div class="separator_mini"></div> 
                                        
								</div> 
							</div>  
                        </div>
                        
                    </div>
                    
				</div>
                
                                            
                <!-- project 3 -->
                <div class="fmSliderNode"  >
                
                	<!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb3.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					
                    <!-- project Name -->
                    <div class="projName" ><h6><span>	Project 3 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Image only - Mini project description</em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                    	<!-- project image slide show -->
                    	<div class="projImgs" >
                        	<div class="flexSlideshow" >
                        		<ul class="slides">
                               		<li><a  class="lazyload" href="images/portfolio/image6.jpg" data-src-small="images/portfolio/image6_s.jpg" title="Some text">image</a></li>
                                	<li><a  class="lazyload" href="images/portfolio/image8.jpg" data-src-small="images/portfolio/image8_s.jpg" title="Some text">image</a></li> 
                                    <li><a  class="lazyload" href="images/portfolio/image9.jpg" data-src-small="images/portfolio/image9_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image2.jpg" data-src-small="images/portfolio/image2_s.jpg" title="Some text">image</a></li>
                            	</ul>
                             </div>
                        </div>
                    </div>
                    
				</div> 
                                 
                <!-- project 4 -->
                <div class="fmSliderNode"  >
                
                	<!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb4.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					
                    <!-- project Name -->
                    <div class="projName" ><h6><span>	Project 4 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Video & Text - Mini project description</em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                    	<!-- project video -->
                     	<div class="projImgs" style="position:relative; float:left; overflow:hidden">
                        	<div class="addVideo" data-width="100%" data-height="100%" data-autoplay="false" data-url="http://vimeo.com/45778774" ></div>
                        </div>
                         
                         <!-- project details -->  
                         <div class="projDetails scroll-pane" >
                         	<div class="detail_spacing">
                            
                         		<h2 class="title_light">Project title 4</h2>
                                    
                         		<strong>Date:</strong> October 2012 <br>
                         		<strong>Client:</strong> Mapiya Company <br>
                         		<strong>Skills:</strong> Branding <br><br>
                         		<strong>Software use</strong><br>
                         		<ul>
                         			<li class="list4">jQuery</li><br>
                         			<li class="list4">CSS3</li><br>
                         			<li class="list4">nocss</li><br>
                         			<li class="list4">wordpress</li>
                         		</ul>
                                
                         		<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>	

     							<strong>Live Url:</strong>  <a class="underLine"><em>Mapiya Company</em></a>
     
                         	</div >
						</div>
                    </div>
                    
				</div>
                
                <!-- project 5 -->
                <div class="fmSliderNode"  >
                	<!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb6.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					<!-- project Name -->
                    <div class="projName" ><h6><span>	Project 5 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Video only - Mini project description</em>	</span></h6></div>
                    <!-- project full details -->
                    <div class="fullDetails noMargin">
                    	<!-- Video -->
                    	<div class="projImgs" >
                        	<div class="addVideo" data-width="100%" data-height="100%" data-autoplay="false" data-url="http://vimeo.com/45778774" ></div>
                        </div>
                    </div>
				</div>
                
                
                <!-- project 6 -->
                <div class="fmSliderNode"  >
                
                	<!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb11.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					
                    <!-- project Name -->
                    <div class="projName" ><h6><span>	Project 6 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Small description about project</em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                        <!-- project image slide show -->
                    	<div class="projImgs" >
                        	<div class="flexSlideshow" >
                        		<ul class="slides"> 
                                    <li><a  class="lazyload" href="images/portfolio/image4.jpg" data-src-small="images/portfolio/image4_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image12.jpg" data-src-small="images/portfolio/image12_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image13.jpg" data-src-small="images/portfolio/image13_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image8.jpg" data-src-small="images/portfolio/image8_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image9.jpg" data-src-small="images/portfolio/image9_s.jpg" title="Some text">image</a></li>
                            	</ul>
							</div>
						</div>
                        
                        <!-- project description -->
                        <div class="projDetails scroll-pane" >
						  	<div class="detail_spacing">
                            	<h2 class="title_light">Project title 6</h2>
                                
                                <strong>Date:</strong> October 2012 <br>
                                <strong>Client:</strong> Mapiya Company <br>
                                <strong>Skills:</strong> Branding <br><br>
                                <strong>Software use</strong><br>
                                <ul>
                                	<li class="list4">jQuery</li><br>
                                    <li class="list4">CSS3</li><br>
                                    <li class="list4">Skeleton</li><br>
                                	<li class="list4">Wordpress</li>
                                </ul>
                                Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.	<hr>
 <strong>Live Url:</strong>  <a class="underLine"><em>Mapiya Company</em></a>
 							</div >
                        </div>
                    </div>
                    
				</div> 
                
                <!-- project 7 -->
                <div class="fmSliderNode"  >
                	<!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb10.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
                    
					<!-- project Name -->
                    <div class="projName" ><h6><span>	Project 7 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Small description about project</em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails">
                    
                    	<!-- project image slide show -->
                    	<div class="projImgs">
                        	<div class="flexSlideshow">
                        		<ul class="slides"> 
                                    <li><a  class="lazyload" href="images/portfolio/image9.jpg" data-src-small="images/portfolio/image9_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image13.jpg" data-src-small="images/portfolio/image13_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image7.jpg" data-src-small="images/portfolio/image7_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image12.jpg" data-src-small="images/portfolio/image13_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image6.jpg" data-src-small="images/portfolio/image6_s.jpg" title="Some text">image</a></li>
                            	</ul>
							</div>
						</div>
                        
                        <!-- project description -->
                        <div class="projDetails scroll-pane" >
						  	<div class="detail_spacing">
                            
                            	<h2 class="title_light">Project title 7</h2>
                                
                                <strong>Date:</strong> October 2012 <br>
                                <strong>Client:</strong> Mapiya Company <br>
                                <strong>Skills:</strong> Branding <br><br>
                                <strong>Software use</strong><br>
                                
                                <ul>
                                	<li class="list4">jQuery</li><br>
                                    <li class="list4">CSS3</li><br>
                                    <li class="list4">Skeleton</li><br>
                                	<li class="list4">Wordpress</li>
                                </ul>
                                
                                <p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                
                                <p>Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.  Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
                                
                                <p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                
								<strong>Live Url:</strong>  <a class="underLine"><em>Mapiya Company</em></a>
                                
 							</div >
                        </div>
                    </div>
                    
				</div>                            
                
                <div class="fmSliderNode"  >
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb6.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					
                    <div class="projName" ><h6><span>	Project 8 	</span></h6></div>
					<div class="miniDesc" ><h6><span>	<em>Youtube video only - Mini description</em>	</span></h6></div>
                    
                     <div class="fullDetails noMargin" style="clear:both; position:relative; overflow:hidden; width:100%">
                    	<div class="projImgs" style="position:relative; float:left; overflow:hidden">
                        	<div class="addVideo" data-width="100%" data-height="100%" data-autoplay="false" data-url="http://www.youtube.com/watch?v=QVd_QZ3ZlM8" ></div>
                        </div>
                    </div>
                    
				</div> 
                
                
                <!-- project 8 -->
                <div class="fmSliderNode"  >
                
                	<!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb8.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
                    <!-- project Name -->
					<div class="projName" ><h6><span>	Project 9 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Youtube video & Text - Mini description </em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                     	
                        <!-- project video -->
                     	<div class="projImgs" >
							<div class="addVideo" data-width="100%" data-height="100%" data-autoplay="false" data-url="http://www.youtube.com/watch?v=QVd_QZ3ZlM8" ></div>
                        </div>
                        
                        <!-- project description -->
                        <div class="projDetails scroll-pane" >
                        	<div class="detail_spacing">
                            
                        		<h2 class="title_light">Project title 9</h2>
                                    
                        		<strong>Date:</strong> October 2012 <br>
                        		<strong>Client:</strong> Mapiya Company <br>
                        		<strong>Skills:</strong> Branding <br><br>
                        		<strong>Software use</strong><br>
                                
                        		<ul>
                        			<li class="list4">jQuery</li><br>
                        			<li class="list4">CSS3</li><br>
                        			<li class="list4">nocss</li><br>
                        			<li class="list4">wordpress</li>
                        		</ul>
                        		
                               <p> Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                               
     							<strong>Live Url:</strong>  <a class="underLine"><em>Mapiya Company</em></a>
                                
							</div >
                        </div>
                    </div>
                    
				</div>
                
                
                <!-- project 9 -->
                <div class="fmSliderNode" >
                
                	<!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb9.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
                    <!-- project Name -->
					<div class="projName" ><h6><span>	Project 10 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Small description about project</em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                        <div class="container" >
                        
							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
                                	
                                    <h2 class="title_light">Project title 10 </h2>
                                    
                                    <div class="separator_mini"></div> 
                                    
                                    <div class="large_image">
										<a  class="lazyload scale-with-grid" href="images/portfolio/image11.jpg" data-src-small="images/portfolio/image11_s.jpg" title="Some text">image</a>
                                    </div>  
                                        
									<div class="separator_mini"></div> 
                                    
                                    
									<strong>Date:</strong> September 2012 <br>
                                    <strong>Client:</strong> Mapiya Company <br>
                                    <strong>Skills:</strong> Branding <br><br>
                                    <strong>Software use</strong><br>
                                    <ul>
                                        <li class="list4">jQuery</li><br>
                                        <li class="list4">CSS3</li><br>
                                        <li class="list4">nocss</li><br>
                                        <li class="list4">wordpress</li>
                                    </ul>
                                                    
									<div class="separator_mini"></div> 
                                
                                	<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                    
                                	<p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                
 									<strong>Author:</strong>  <a class="underLine"><em>Aderson</em></a>
                                    
									<div class="separator_mini"></div> 
                                    
								</div> 
							</div>
                                
                        </div>
                    </div>
                    
				</div> 
                
                
                <!-- project 10 -->
                <div class="fmSliderNode"  >
                	<!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb6.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					<!-- project Name -->
                    <div class="projName" ><h6><span>	Project 11 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Video with cover image -Style 2 </em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                        <div class="container" >

							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
                                	
                                    <h2 class="title_light">Project title 11 </h2>
                                             
									<div class="separator_mini"></div>
                                     
                      				<!-- project video with cover image -->
                                    <div class="addVideo video_content" data-url="http://www.youtube.com/watch?v=_1NGnVLDPog" >
										<div class="video_hover"></div>
										<img class="scale-with-grid" src="images/video_img1.jpg" />
									</div>
                                    
                                   <div class="separator_mini"></div> 
                                    
									<strong>Date:</strong> September 2012 <br>
                                    <strong>Client:</strong> Mapiya Company <br>
                                    <strong>Skills:</strong> Branding <br><br>
                                    <strong>Software use</strong><br>
                                    
                                    <ul>
                                        <li class="list4">jQuery</li><br>
                                        <li class="list4">CSS3</li><br>
                                        <li class="list4">nocss</li><br>
                                        <li class="list4">wordpress</li>
                                    </ul>
                                                    
									<div class="separator_mini"></div> 
                                
                                	<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                               
 									<strong>Author:</strong>  <a class="underLine"><em>Aderson</em></a>
                                    
									<div class="separator_mini"></div> 
                                    
								</div> 
							</div>
                                
                        </div>
                    </div>
                    
				</div>                            
                
                
                <!-- project 11 -->
                <div class="fmSliderNode"  >
                	
                    <!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb8.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
                    <!-- project Name -->
					<div class="projName" ><h6><span>	Project 12 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Video with Text - Style 3</em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                        <div class="container" >

							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
                                	
                                    <h2 class="title_light">Project title 12 </h2>
                                             
									<div class="separator_mini"></div> 
									
                                    <!-- project video -->
                                    <div class="video_content" >
										<div class="addVideo" data-width="100%" data-height="100%" data-autoplay="false" data-url="http://www.youtube.com/watch?v=_1NGnVLDPog" ></div>
                                    </div>
                                    
                                   <div class="separator_mini"></div> 
                                    
									<strong>Date:</strong> September 2012 <br>
                                    <strong>Client:</strong> Mapiya Company <br>
                                    <strong>Skills:</strong> Branding <br><br>
                                    <strong>Software use</strong><br>
                                    <ul>
                                        <li class="list4">jQuery</li><br>
                                        <li class="list4">CSS3</li><br>
                                        <li class="list4">nocss</li><br>
                                        <li class="list4">wordpress</li>
                                    </ul>
                                                    
									<div class="separator_mini"></div> 
                               
 									<strong>Author:</strong>  <a class="underLine"><em>Aderson</em></a>
                                    
									<div class="separator_mini"></div> 
                                    
								</div> 
							</div>
                                
                        </div>
                    </div>
                    
				</div> 
                
                
                <!-- project 12 -->
                <div class="fmSliderNode"  >
                	
                    <!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb5.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					<!-- project Name -->
                    <div class="projName" ><h6><span>	Project 13 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Image slideshow - Mini description</em>	</span></h6></div>
                    <!-- project full details -->
                    <div class="fullDetails" >
                    	<!-- project image slide show -->
                    	<div class="projImgs">
                        	<div class="flexSlideshow" >
                        		<ul class="slides">
                               		<li><a  class="lazyload" href="images/portfolio/image5.jpg" data-src-small="images/portfolio/image5_s.jpg" title="Some text">image</a></li>
                                	<li><a  class="lazyload" href="images/portfolio/image8.jpg" data-src-small="images/portfolio/image8_s.jpg" title="Some text">image</a></li> 
                                    <li><a  class="lazyload" href="images/portfolio/image6.jpg" data-src-small="images/portfolio/image6_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image2.jpg" data-src-small="images/portfolio/image2_s.jpg" title="Some text">image</a></li>
                            	</ul>
                             </div>
                        </div>
                    </div>
                    
				</div>
                
                <!-- project 13 -->
                <div class="fmSliderNode"  >
                
                	<!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb4.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					<!-- project Name -->
                    <div class="projName" ><h6><span>	Project 14 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Text only - Mini description</em>	</span></h6></div>
                    <!-- project full details -->
                    <div class="fullDetails" >
                        <div class="container" >

							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
                                	
                                    <h2 class="title_light">Project title 14 </h2>
                                    
                                    <div class="separator_mini"></div> 
                                    <!-- project single image -->
                                    <div class="large_image">
										<a  class="lazyload scale-with-grid" href="images/portfolio/image10.jpg" data-src-small="images/portfolio/image10_s.jpg" title="Some text">image</a>
                                    </div>      
                                      
									<div class="separator_mini"></div> 
                                    
									<strong>Date:</strong> September 2012 <br>
                                    <strong>Client:</strong> Mapiya Company <br>
                                    <strong>Skills:</strong> Branding <br><br>
                                    <strong>Software use</strong><br>
                                    
                                    <ul>
                                        <li class="list4">jQuery</li><br>
                                        <li class="list4">CSS3</li><br>
                                        <li class="list4">nocss</li><br>
                                        <li class="list4">wordpress</li>
                                    </ul>
                                                    
									<div class="separator_mini"></div> 
                                
                                	<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                	<p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
 									
                                    <strong>Live Url:</strong>  <a class="underLine"><em>Aderson</em></a>
                                    
									<div class="separator_mini"></div>
                                     
								</div> 
							</div>
                                
                        </div>
                    </div>
                    
				</div>                         
				
               	<!-- End projects -->
                  
			</div>
        </div>
    
    </div>
</div>

<!-- End Portfolio page -->
 
 
 
 
<!-- Portfolio 4 column 

	This portfolio page plug-in initialize code is placed on header area. 
    You can see it near the comment line  // portfolio column 4 

-->


<div class="page sixteen columns" data-id="!portfolio_column4" >                	
    <div class="pgContent" >
    
        <!-- slider -->          
        <div class="slider4 fmSlider fixedHeight" >  
          	<div class="fmSlides sixteen columns" >
            
            	<!-- project 1 -->
				<div class="fmSliderNode projCol4" >
                	
                    <!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb1.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
                    
                     <!-- project Name -->
					<div class="projName" ><h6><span>	Project 1 	</span></h6></div>
                     <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Default style - Mini description about project</em>	</span></h6></div>
                 
                 	<!-- project full details -->
					<div class="fullDetails" >
                    	
                        <!-- project image slide show -->
                    	<div class="projImgs">
                        	<div class="flexSlideshow" >
                        		<ul class="slides"> 
                                    <li><a  class="lazyload" href="images/portfolio/image1.jpg" data-src-small="images/portfolio/image1_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image2.jpg" data-src-small="images/portfolio/image2_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image3.jpg" data-src-small="images/portfolio/image3_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image4.jpg" data-src-small="images/portfolio/image4_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image5.jpg" data-src-small="images/portfolio/image5_s.jpg" title="Some text">image</a></li>
                            	</ul>
							</div>
						</div>
                        
                        <!-- project description -->
                        <div class="projDetails scroll-pane" >
						  	<div class="detail_spacing">
                            
                            	<h2 class="title_light">Project title 1 </h2>
                                
                                <strong>Date:</strong> October 2012 <br>
                                <strong>Client:</strong> Nikey Company <br>
                                <strong>Skills:</strong> Branding <br><br>
                                <strong>Software use</strong><br>
                                
                                <ul>
                                	<li class="list4">jQuery</li><br>
                                    <li class="list4">CSS3</li><br>
                                    <li class="list4">Flash</li><br>
                                	<li class="list4">wordpress</li>
                                </ul>
                                
                                <p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
 <strong>Live Url:</strong>  <a class="underLine"><em>Nikey Company</em></a>
 
 							</div >
                        </div>
                        
                    </div>
				</div>

				
                <!-- project 2 -->
                <div class="fmSliderNode projCol4"  >
                	
                     <!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb2.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					
                    <!-- project Name -->
                    <div class="projName" ><h6><span>	Project 2 	</span></h6></div>
                    <!-- project full details -->
					<div class="miniDesc" ><h6><span>	<em>Another style - Mini description about project</em>	</span></h6></div>
                
                	<!-- project full details -->
                    <div class="fullDetails" >
						<div class="container" >

							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
                                
									<h2 class="title_light">Project title 2 - <em>another style</em></h2>
         
									<div class="separator_mini"></div> 
                                    
                                    <!-- project image slide show -->
									<div class="flexSlideshow fixedSize" >
										<ul class="slides"> 
											<li><a  class="lazyload" href="images/slideshow/image4.jpg" data-src-small="images/slideshow/image4_s.jpg" title="Some text">image</a></li>
											<li><a  class="lazyload" href="images/slideshow/image3.jpg" data-src-small="images/slideshow/image3_s.jpg" title="Some text">image</a></li>
											<li><a  class="lazyload" href="images/slideshow/image1.jpg" data-src-small="images/slideshow/image1_s.jpg" title="Some text">image</a></li>
											<li><a  class="lazyload" href="images/slideshow/image2.jpg" data-src-small="images/slideshow/image2_s.jpg" title="Some text">image</a></li>
										</ul>
									</div>
                                
									<div class="separator_mini"></div> 
                                            
									<strong>Date:</strong> October 2012 <br>
									<strong>Client:</strong> Mapiya Company <br>
									<strong>Skills:</strong> Branding <br><br>
									<strong>Software use</strong><br>
                                    
									<ul>
										<li class="list4">jQuery</li><br>
										<li class="list4">CSS3</li><br>
										<li class="list4">nocss</li><br>
										<li class="list4">wordpress</li>
									</ul>
									
                                    <p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.	</p>
									
                                    <p>Ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
             						<strong>Live Url:</strong>  <a class="underLine"><em>Mapiya Company</em></a>

									<div class="separator_mini"></div> 
                                        
								</div> 
							</div>  
                        </div>
                        
                    </div>
                    
				</div>
                
                                            
                <!-- project 3 -->
                <div class="fmSliderNode projCol4"  >
                
                	<!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb3.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					
                    <!-- project Name -->
                    <div class="projName" ><h6><span>	Project 3 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Image only - Mini project description</em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                    	<!-- project image slide show -->
                    	<div class="projImgs" >
                        	<div class="flexSlideshow" >
                        		<ul class="slides">
                               		<li><a  class="lazyload" href="images/portfolio/image6.jpg" data-src-small="images/portfolio/image6_s.jpg" title="Some text">image</a></li>
                                	<li><a  class="lazyload" href="images/portfolio/image8.jpg" data-src-small="images/portfolio/image8_s.jpg" title="Some text">image</a></li> 
                                    <li><a  class="lazyload" href="images/portfolio/image9.jpg" data-src-small="images/portfolio/image9_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image2.jpg" data-src-small="images/portfolio/image2_s.jpg" title="Some text">image</a></li>
                            	</ul>
                             </div>
                        </div>
                    </div>
                    
				</div> 
                                 
                <!-- project 4 -->
                <div class="fmSliderNode projCol4"  >
                
                	<!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb4.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					
                    <!-- project Name -->
                    <div class="projName" ><h6><span>	Project 4 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Video & Text - Mini project description</em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                    	<!-- project video -->
                     	<div class="projImgs" style="position:relative; float:left; overflow:hidden">
                        	<div class="addVideo" data-width="100%" data-height="100%" data-autoplay="false" data-url="http://vimeo.com/45778774" ></div>
                        </div>
                         
                         <!-- project details -->  
                         <div class="projDetails scroll-pane" >
                         	<div class="detail_spacing">
                            
                         		<h2 class="title_light">Project title 4</h2>
                                    
                         		<strong>Date:</strong> October 2012 <br>
                         		<strong>Client:</strong> Mapiya Company <br>
                         		<strong>Skills:</strong> Branding <br><br>
                         		<strong>Software use</strong><br>
                         		<ul>
                         			<li class="list4">jQuery</li><br>
                         			<li class="list4">CSS3</li><br>
                         			<li class="list4">nocss</li><br>
                         			<li class="list4">wordpress</li>
                         		</ul>
                                
                         		<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>	

     							<strong>Live Url:</strong>  <a class="underLine"><em>Mapiya Company</em></a>
     
                         	</div >
						</div>
                    </div>
                    
				</div>
                
                <!-- project 5 -->
                <div class="fmSliderNode projCol4"  >
                	<!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb6.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					<!-- project Name -->
                    <div class="projName" ><h6><span>	Project 5 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Video only - Mini project description</em>	</span></h6></div>
                    <!-- project full details -->
                    <div class="fullDetails noMargin">
                    	<!-- Video -->
                    	<div class="projImgs" >
                        	<div class="addVideo" data-width="100%" data-height="100%" data-autoplay="false" data-url="http://vimeo.com/45778774" ></div>
                        </div>
                    </div>
				</div>
                
                
                <!-- project 6 -->
                <div class="fmSliderNode projCol4"  >
                
                	<!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb11.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					
                    <!-- project Name -->
                    <div class="projName" ><h6><span>	Project 6 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Small description about project</em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                        <!-- project image slide show -->
                    	<div class="projImgs" >
                        	<div class="flexSlideshow" >
                        		<ul class="slides"> 
                                    <li><a  class="lazyload" href="images/portfolio/image4.jpg" data-src-small="images/portfolio/image4_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image12.jpg" data-src-small="images/portfolio/image12_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image13.jpg" data-src-small="images/portfolio/image13_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image8.jpg" data-src-small="images/portfolio/image8_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image9.jpg" data-src-small="images/portfolio/image9_s.jpg" title="Some text">image</a></li>
                            	</ul>
							</div>
						</div>
                        
                        <!-- project description -->
                        <div class="projDetails scroll-pane" >
						  	<div class="detail_spacing">
                            	<h2 class="title_light">Project title 6</h2>
                                
                                <strong>Date:</strong> October 2012 <br>
                                <strong>Client:</strong> Mapiya Company <br>
                                <strong>Skills:</strong> Branding <br><br>
                                <strong>Software use</strong><br>
                                <ul>
                                	<li class="list4">jQuery</li><br>
                                    <li class="list4">CSS3</li><br>
                                    <li class="list4">Skeleton</li><br>
                                	<li class="list4">Wordpress</li>
                                </ul>
                                Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.	<hr>
 <strong>Live Url:</strong>  <a class="underLine"><em>Mapiya Company</em></a>
 							</div >
                        </div>
                    </div>
                    
				</div> 
                
                <!-- project 7 -->
                <div class="fmSliderNode projCol4"  >
                	<!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb10.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
                    
					<!-- project Name -->
                    <div class="projName" ><h6><span>	Project 7 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Small description about project</em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails">
                    
                    	<!-- project image slide show -->
                    	<div class="projImgs">
                        	<div class="flexSlideshow">
                        		<ul class="slides"> 
                                    <li><a  class="lazyload" href="images/portfolio/image9.jpg" data-src-small="images/portfolio/image9_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image13.jpg" data-src-small="images/portfolio/image13_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image7.jpg" data-src-small="images/portfolio/image7_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image12.jpg" data-src-small="images/portfolio/image13_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image6.jpg" data-src-small="images/portfolio/image6_s.jpg" title="Some text">image</a></li>
                            	</ul>
							</div>
						</div>
                        
                        <!-- project description -->
                        <div class="projDetails scroll-pane" >
						  	<div class="detail_spacing">
                            
                            	<h2 class="title_light">Project title 7</h2>
                                
                                <strong>Date:</strong> October 2012 <br>
                                <strong>Client:</strong> Mapiya Company <br>
                                <strong>Skills:</strong> Branding <br><br>
                                <strong>Software use</strong><br>
                                
                                <ul>
                                	<li class="list4">jQuery</li><br>
                                    <li class="list4">CSS3</li><br>
                                    <li class="list4">Skeleton</li><br>
                                	<li class="list4">Wordpress</li>
                                </ul>
                                
                                <p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                
                                <p>Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.  Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
                                
                                <p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                
								<strong>Live Url:</strong>  <a class="underLine"><em>Mapiya Company</em></a>
                                
 							</div >
                        </div>
                    </div>
                    
				</div>                            
                
                <div class="fmSliderNode projCol4"  >
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb6.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					
                    <div class="projName" ><h6><span>	Project 8 	</span></h6></div>
					<div class="miniDesc" ><h6><span>	<em>Youtube video only - Mini description</em>	</span></h6></div>
                    
                     <div class="fullDetails noMargin" style="clear:both; position:relative; overflow:hidden; width:100%">
                    	<div class="projImgs" style="position:relative; float:left; overflow:hidden">
                        	<div class="addVideo" data-width="100%" data-height="100%" data-autoplay="false" data-url="http://www.youtube.com/watch?v=QVd_QZ3ZlM8" ></div>
                        </div>
                    </div>
                    
				</div> 
                
                
                <!-- project 8 -->
                <div class="fmSliderNode projCol4"  >
                
                	<!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb8.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
                    <!-- project Name -->
					<div class="projName" ><h6><span>	Project 9 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Youtube video & Text - Mini description </em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                     	
                        <!-- project video -->
                     	<div class="projImgs" >
							<div class="addVideo" data-width="100%" data-height="100%" data-autoplay="false" data-url="http://www.youtube.com/watch?v=QVd_QZ3ZlM8" ></div>
                        </div>
                        
                        <!-- project description -->
                        <div class="projDetails scroll-pane" >
                        	<div class="detail_spacing">
                            
                        		<h2 class="title_light">Project title 9</h2>
                                    
                        		<strong>Date:</strong> October 2012 <br>
                        		<strong>Client:</strong> Mapiya Company <br>
                        		<strong>Skills:</strong> Branding <br><br>
                        		<strong>Software use</strong><br>
                                
                        		<ul>
                        			<li class="list4">jQuery</li><br>
                        			<li class="list4">CSS3</li><br>
                        			<li class="list4">nocss</li><br>
                        			<li class="list4">wordpress</li>
                        		</ul>
                        		
                               <p> Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                               
     							<strong>Live Url:</strong>  <a class="underLine"><em>Mapiya Company</em></a>
                                
							</div >
                        </div>
                    </div>
                    
				</div>
                
                
                <!-- project 9 -->
                <div class="fmSliderNode projCol4" >
                
                	<!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb9.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
                    <!-- project Name -->
					<div class="projName" ><h6><span>	Project 10 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Small description about project</em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                        <div class="container" >
                        
							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
                                	
                                    <h2 class="title_light">Project title 10 </h2>
                                    
                                    <div class="separator_mini"></div> 
                                    
                                    <div class="large_image">
										<a  class="lazyload scale-with-grid" href="images/portfolio/image11.jpg" data-src-small="images/portfolio/image11_s.jpg" title="Some text">image</a>
                                    </div>  
                                        
									<div class="separator_mini"></div> 
                                    
                                    
									<strong>Date:</strong> September 2012 <br>
                                    <strong>Client:</strong> Mapiya Company <br>
                                    <strong>Skills:</strong> Branding <br><br>
                                    <strong>Software use</strong><br>
                                    <ul>
                                        <li class="list4">jQuery</li><br>
                                        <li class="list4">CSS3</li><br>
                                        <li class="list4">nocss</li><br>
                                        <li class="list4">wordpress</li>
                                    </ul>
                                                    
									<div class="separator_mini"></div> 
                                
                                	<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                    
                                	<p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                
 									<strong>Author:</strong>  <a class="underLine"><em>Aderson</em></a>
                                    
									<div class="separator_mini"></div> 
                                    
								</div> 
							</div>
                                
                        </div>
                    </div>
                    
				</div> 
                
                
                <!-- project 10 -->
                <div class="fmSliderNode projCol4"  >
                	<!-- project thumbnail -->
					<div class="projThumb_small slider_nav">
						<img  src="images/portfolio/thumb6.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					<!-- project Name -->
                    <div class="projName" ><h6><span>	Project 11 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Video with cover image -Style 2 </em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                        <div class="container" >

							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
                                	
                                    <h2 class="title_light">Project title 11 </h2>
                                             
									<div class="separator_mini"></div>
                                     
                      				<!-- project video with cover image -->
                                    <div class="addVideo video_content" data-url="http://www.youtube.com/watch?v=_1NGnVLDPog" >
										<div class="video_hover"></div>
										<img class="scale-with-grid" src="images/video_img1.jpg" />
									</div>
                                    
                                   <div class="separator_mini"></div> 
                                    
									<strong>Date:</strong> September 2012 <br>
                                    <strong>Client:</strong> Mapiya Company <br>
                                    <strong>Skills:</strong> Branding <br><br>
                                    <strong>Software use</strong><br>
                                    
                                    <ul>
                                        <li class="list4">jQuery</li><br>
                                        <li class="list4">CSS3</li><br>
                                        <li class="list4">nocss</li><br>
                                        <li class="list4">wordpress</li>
                                    </ul>
                                                    
									<div class="separator_mini"></div> 
                                
                                	<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                               
 									<strong>Author:</strong>  <a class="underLine"><em>Aderson</em></a>
                                    
									<div class="separator_mini"></div> 
                                    
								</div> 
							</div>
                                
                        </div>
                    </div>
                    
				</div>                            

                     
				
               	<!-- End projects -->
                  
			</div>
        </div>
    
    </div>
</div>


<!-- End Portfolio 4 column -->




<!-- Portfolio 3 column 

	This portfolio page plug-in initialize code is placed on header area. 
    You can see it near the comment line  // portfolio column 3 

-->



<div class="page sixteen columns" data-id="!portfolio_column3" >                	
    <div class="pgContent" >
    
        <!-- slider -->          
        <div class="slider5 fmSlider fixedHeight" >  
          	<div class="fmSlides sixteen columns" >
            
            
            	<!-- project 1 -->
				<div class="fmSliderNode projCol3" >
                	
                    <!-- project thumbnail -->
					<div class="projThumb_medium slider_nav">
						<img  src="images/portfolio/thumb12.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
                    
                     <!-- project Name -->
					<div class="projName" ><h6><span>	Project 1 	</span></h6></div>
                     <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Default style - Mini description about project</em>	</span></h6></div>
                 
                 	<!-- project full details -->
					<div class="fullDetails" >
                    	
                        <!-- project image slide show -->
                    	<div class="projImgs">
                        	<div class="flexSlideshow" >
                        		<ul class="slides"> 
                                    <li><a  class="lazyload" href="images/portfolio/image1.jpg" data-src-small="images/portfolio/image1_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image2.jpg" data-src-small="images/portfolio/image2_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image3.jpg" data-src-small="images/portfolio/image3_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image4.jpg" data-src-small="images/portfolio/image4_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image5.jpg" data-src-small="images/portfolio/image5_s.jpg" title="Some text">image</a></li>
                            	</ul>
							</div>
						</div>
                        
                        <!-- project description -->
                        <div class="projDetails scroll-pane" >
						  	<div class="detail_spacing">
                            
                            	<h2 class="title_light">Project title 1 </h2>
                                
                                <strong>Date:</strong> October 2012 <br>
                                <strong>Client:</strong> Nikey Company <br>
                                <strong>Skills:</strong> Branding <br><br>
                                <strong>Software use</strong><br>
                                
                                <ul>
                                	<li class="list4">jQuery</li><br>
                                    <li class="list4">CSS3</li><br>
                                    <li class="list4">Flash</li><br>
                                	<li class="list4">wordpress</li>
                                </ul>
                                
                                <p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
 <strong>Live Url:</strong>  <a class="underLine"><em>Nikey Company</em></a>
 
 							</div >
                        </div>
                        
                    </div>
				</div>

				
                <!-- project 2 -->
                <div class="fmSliderNode projCol3"  >
                	
                     <!-- project thumbnail -->
					<div class="projThumb_medium slider_nav">
						<img  src="images/portfolio/thumb13.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					
                    <!-- project Name -->
                    <div class="projName" ><h6><span>	Project 2 	</span></h6></div>
                    <!-- project full details -->
					<div class="miniDesc" ><h6><span>	<em>Another style - Mini description about project</em>	</span></h6></div>
                
                	<!-- project full details -->
                    <div class="fullDetails" >
						<div class="container" >

							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
                                
									<h2 class="title_light">Project title 2 - <em>another style</em></h2>
         
									<div class="separator_mini"></div> 
                                    
                                    <!-- project image slide show -->
									<div class="flexSlideshow fixedSize" >
										<ul class="slides"> 
											<li><a  class="lazyload" href="images/slideshow/image4.jpg" data-src-small="images/slideshow/image4_s.jpg" title="Some text">image</a></li>
											<li><a  class="lazyload" href="images/slideshow/image3.jpg" data-src-small="images/slideshow/image3_s.jpg" title="Some text">image</a></li>
											<li><a  class="lazyload" href="images/slideshow/image1.jpg" data-src-small="images/slideshow/image1_s.jpg" title="Some text">image</a></li>
											<li><a  class="lazyload" href="images/slideshow/image2.jpg" data-src-small="images/slideshow/image2_s.jpg" title="Some text">image</a></li>
										</ul>
									</div>
                                
									<div class="separator_mini"></div> 
                                            
									<strong>Date:</strong> October 2012 <br>
									<strong>Client:</strong> Mapiya Company <br>
									<strong>Skills:</strong> Branding <br><br>
									<strong>Software use</strong><br>
                                    
									<ul>
										<li class="list4">jQuery</li><br>
										<li class="list4">CSS3</li><br>
										<li class="list4">nocss</li><br>
										<li class="list4">wordpress</li>
									</ul>
									
                                    <p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.	</p>
									
                                    <p>Ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
             						<strong>Live Url:</strong>  <a class="underLine"><em>Mapiya Company</em></a>

									<div class="separator_mini"></div> 
                                        
								</div> 
							</div>  
                        </div>
                        
                    </div>
                    
				</div>
                
                                            
                <!-- project 3 -->
                <div class="fmSliderNode projCol3"  >
                
                	<!-- project thumbnail -->
					<div class="projThumb_medium slider_nav">
						<img  src="images/portfolio/thumb14.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					
                    <!-- project Name -->
                    <div class="projName" ><h6><span>	Project 3 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Image only - Mini project description</em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                    	<!-- project image slide show -->
                    	<div class="projImgs" >
                        	<div class="flexSlideshow" >
                        		<ul class="slides">
                               		<li><a  class="lazyload" href="images/portfolio/image6.jpg" data-src-small="images/portfolio/image6_s.jpg" title="Some text">image</a></li>
                                	<li><a  class="lazyload" href="images/portfolio/image8.jpg" data-src-small="images/portfolio/image8_s.jpg" title="Some text">image</a></li> 
                                    <li><a  class="lazyload" href="images/portfolio/image9.jpg" data-src-small="images/portfolio/image9_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image2.jpg" data-src-small="images/portfolio/image2_s.jpg" title="Some text">image</a></li>
                            	</ul>
                             </div>
                        </div>
                    </div>
                    
				</div> 
                                 
                <!-- project 4 -->
                <div class="fmSliderNode projCol3"  >
                
                	<!-- project thumbnail -->
					<div class="projThumb_medium slider_nav">
						<img  src="images/portfolio/thumb15.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					
                    <!-- project Name -->
                    <div class="projName" ><h6><span>	Project 4 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Video & Text - Mini project description</em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                    	<!-- project video -->
                     	<div class="projImgs" style="position:relative; float:left; overflow:hidden">
                        	<div class="addVideo" data-width="100%" data-height="100%" data-autoplay="false" data-url="http://vimeo.com/45778774" ></div>
                        </div>
                         
                         <!-- project details -->  
                         <div class="projDetails scroll-pane" >
                         	<div class="detail_spacing">
                            
                         		<h2 class="title_light">Project title 4</h2>
                                    
                         		<strong>Date:</strong> October 2012 <br>
                         		<strong>Client:</strong> Mapiya Company <br>
                         		<strong>Skills:</strong> Branding <br><br>
                         		<strong>Software use</strong><br>
                         		<ul>
                         			<li class="list4">jQuery</li><br>
                         			<li class="list4">CSS3</li><br>
                         			<li class="list4">nocss</li><br>
                         			<li class="list4">wordpress</li>
                         		</ul>
                                
                         		<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>	

     							<strong>Live Url:</strong>  <a class="underLine"><em>Mapiya Company</em></a>
     
                         	</div >
						</div>
                    </div>
                    
				</div>
                
                <!-- project 5 -->
                <div class="fmSliderNode projCol3"  >
                	<!-- project thumbnail -->
					<div class="projThumb_medium slider_nav">
						<img  src="images/portfolio/thumb16.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					<!-- project Name -->
                    <div class="projName" ><h6><span>	Project 5 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Video only - Mini project description</em>	</span></h6></div>
                    <!-- project full details -->
                    <div class="fullDetails noMargin">
                    	<!-- Video -->
                    	<div class="projImgs" >
                        	<div class="addVideo" data-width="100%" data-height="100%" data-autoplay="false" data-url="http://vimeo.com/45778774" ></div>
                        </div>
                    </div>
				</div>
                
                
                <!-- project 6 -->
                <div class="fmSliderNode projCol3"  >
                
                	<!-- project thumbnail -->
					<div class="projThumb_medium slider_nav">
						<img  src="images/portfolio/thumb11.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					
                    <!-- project Name -->
                    <div class="projName" ><h6><span>	Project 6 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Small description about project</em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                        <!-- project image slide show -->
                    	<div class="projImgs" >
                        	<div class="flexSlideshow" >
                        		<ul class="slides"> 
                                    <li><a  class="lazyload" href="images/portfolio/image4.jpg" data-src-small="images/portfolio/image4_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image12.jpg" data-src-small="images/portfolio/image12_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image13.jpg" data-src-small="images/portfolio/image13_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image8.jpg" data-src-small="images/portfolio/image8_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image9.jpg" data-src-small="images/portfolio/image9_s.jpg" title="Some text">image</a></li>
                            	</ul>
							</div>
						</div>
                        
                        <!-- project description -->
                        <div class="projDetails scroll-pane" >
						  	<div class="detail_spacing">
                            	<h2 class="title_light">Project title 6</h2>
                                
                                <strong>Date:</strong> October 2012 <br>
                                <strong>Client:</strong> Mapiya Company <br>
                                <strong>Skills:</strong> Branding <br><br>
                                <strong>Software use</strong><br>
                                <ul>
                                	<li class="list4">jQuery</li><br>
                                    <li class="list4">CSS3</li><br>
                                    <li class="list4">Skeleton</li><br>
                                	<li class="list4">Wordpress</li>
                                </ul>
                                Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.	<hr>
 <strong>Live Url:</strong>  <a class="underLine"><em>Mapiya Company</em></a>
 							</div >
                        </div>
                    </div>
                    
				</div> 
                
                <!-- project 7 -->
                <div class="fmSliderNode projCol3"  >
                	<!-- project thumbnail -->
					<div class="projThumb_medium slider_nav">
						<img  src="images/portfolio/thumb10.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
                    
					<!-- project Name -->
                    <div class="projName" ><h6><span>	Project 7 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Small description about project</em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails">
                    
                    	<!-- project image slide show -->
                    	<div class="projImgs">
                        	<div class="flexSlideshow">
                        		<ul class="slides"> 
                                    <li><a  class="lazyload" href="images/portfolio/image9.jpg" data-src-small="images/portfolio/image9_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image13.jpg" data-src-small="images/portfolio/image13_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image7.jpg" data-src-small="images/portfolio/image7_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image12.jpg" data-src-small="images/portfolio/image13_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image6.jpg" data-src-small="images/portfolio/image6_s.jpg" title="Some text">image</a></li>
                            	</ul>
							</div>
						</div>
                        
                        <!-- project description -->
                        <div class="projDetails scroll-pane" >
						  	<div class="detail_spacing">
                            
                            	<h2 class="title_light">Project title 7</h2>
                                
                                <strong>Date:</strong> October 2012 <br>
                                <strong>Client:</strong> Mapiya Company <br>
                                <strong>Skills:</strong> Branding <br><br>
                                <strong>Software use</strong><br>
                                
                                <ul>
                                	<li class="list4">jQuery</li><br>
                                    <li class="list4">CSS3</li><br>
                                    <li class="list4">Skeleton</li><br>
                                	<li class="list4">Wordpress</li>
                                </ul>
                                
                                <p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                
                                <p>Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.  Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
                                
                                <p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                
								<strong>Live Url:</strong>  <a class="underLine"><em>Mapiya Company</em></a>
                                
 							</div >
                        </div>
                    </div>
                    
				</div>                            
                
                <!-- project 8 -->
                <div class="fmSliderNode projCol3"  >
					<div class="projThumb_medium slider_nav">
						<img  src="images/portfolio/thumb16.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					
                    <div class="projName" ><h6><span>	Project 8 	</span></h6></div>
					<div class="miniDesc" ><h6><span>	<em>Youtube video only - Mini description</em>	</span></h6></div>
                    
                     <div class="fullDetails noMargin" style="clear:both; position:relative; overflow:hidden; width:100%">
                    	<div class="projImgs" style="position:relative; float:left; overflow:hidden">
                        	<div class="addVideo" data-width="100%" data-height="100%" data-autoplay="false" data-url="http://www.youtube.com/watch?v=QVd_QZ3ZlM8" ></div>
                        </div>
                    </div>
                    
				</div> 
                
                
                <!-- project 9 -->
                <div class="fmSliderNode projCol3"  >
                
                	<!-- project thumbnail -->
					<div class="projThumb_medium slider_nav">
						<img  src="images/portfolio/thumb8.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
                    <!-- project Name -->
					<div class="projName" ><h6><span>	Project 9 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Youtube video & Text - Mini description </em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                     	
                        <!-- project video -->
                     	<div class="projImgs" >
							<div class="addVideo" data-width="100%" data-height="100%" data-autoplay="false" data-url="http://www.youtube.com/watch?v=QVd_QZ3ZlM8" ></div>
                        </div>
                        
                        <!-- project description -->
                        <div class="projDetails scroll-pane" >
                        	<div class="detail_spacing">
                            
                        		<h2 class="title_light">Project title 9</h2>
                                    
                        		<strong>Date:</strong> October 2012 <br>
                        		<strong>Client:</strong> Mapiya Company <br>
                        		<strong>Skills:</strong> Branding <br><br>
                        		<strong>Software use</strong><br>
                                
                        		<ul>
                        			<li class="list4">jQuery</li><br>
                        			<li class="list4">CSS3</li><br>
                        			<li class="list4">nocss</li><br>
                        			<li class="list4">wordpress</li>
                        		</ul>
                        		
                               <p> Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                               
     							<strong>Live Url:</strong>  <a class="underLine"><em>Mapiya Company</em></a>
                                
							</div >
                        </div>
                    </div>
                    
				</div>
                
                
                <!-- project 10 -->
                <div class="fmSliderNode projCol3" >
                
                	<!-- project thumbnail -->
					<div class="projThumb_medium slider_nav">
						<img  src="images/portfolio/thumb9.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
                    <!-- project Name -->
					<div class="projName" ><h6><span>	Project 10 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Small description about project</em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                        <div class="container" >
                        
							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
                                	
                                    <h2 class="title_light">Project title 10 </h2>
                                    
                                    <div class="separator_mini"></div> 
                                    
                                    <div class="large_image">
										<a  class="lazyload scale-with-grid" href="images/portfolio/image11.jpg" data-src-small="images/portfolio/image11_s.jpg" title="Some text">image</a>
                                    </div>  
                                        
									<div class="separator_mini"></div> 
                                    
                                    
									<strong>Date:</strong> September 2012 <br>
                                    <strong>Client:</strong> Mapiya Company <br>
                                    <strong>Skills:</strong> Branding <br><br>
                                    <strong>Software use</strong><br>
                                    <ul>
                                        <li class="list4">jQuery</li><br>
                                        <li class="list4">CSS3</li><br>
                                        <li class="list4">nocss</li><br>
                                        <li class="list4">wordpress</li>
                                    </ul>
                                                    
									<div class="separator_mini"></div> 
                                
                                	<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                    
                                	<p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                
 									<strong>Author:</strong>  <a class="underLine"><em>Aderson</em></a>
                                    
									<div class="separator_mini"></div> 
                                    
								</div> 
							</div>
                                
                        </div>
                    </div>
                    
				</div> 
                
                
                <!-- project 11 -->
                <div class="fmSliderNode projCol3"  >
                	<!-- project thumbnail -->
					<div class="projThumb_medium slider_nav">
						<img  src="images/portfolio/thumb16.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					<!-- project Name -->
                    <div class="projName" ><h6><span>	Project 11 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Video with cover image -Style 2 </em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                        <div class="container" >

							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
                                	
                                    <h2 class="title_light">Project title 11 </h2>
                                             
									<div class="separator_mini"></div>
                                     
                      				<!-- project video with cover image -->
                                    <div class="addVideo video_content" data-url="http://www.youtube.com/watch?v=_1NGnVLDPog" >
										<div class="video_hover"></div>
										<img class="scale-with-grid" src="images/video_img1.jpg" />
									</div>
                                    
                                   <div class="separator_mini"></div> 
                                    
									<strong>Date:</strong> September 2012 <br>
                                    <strong>Client:</strong> Mapiya Company <br>
                                    <strong>Skills:</strong> Branding <br><br>
                                    <strong>Software use</strong><br>
                                    
                                    <ul>
                                        <li class="list4">jQuery</li><br>
                                        <li class="list4">CSS3</li><br>
                                        <li class="list4">nocss</li><br>
                                        <li class="list4">wordpress</li>
                                    </ul>
                                                    
									<div class="separator_mini"></div> 
                                
                                	<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                               
 									<strong>Author:</strong>  <a class="underLine"><em>Aderson</em></a>
                                    
									<div class="separator_mini"></div> 
                                    
								</div> 
							</div>
                                
                        </div>
                    </div>
                    
				</div>                            

                     
				
               	<!-- End projects -->
                  
			</div>
        </div>
    
    </div>
</div>



<!-- End Portfolio 3 column -->





<!-- Portfolio 2 column 

	This portfolio page plug-in initialize code is placed on header area. 
    You can see it near the comment line  // portfolio column 2 

-->


<div class="page sixteen columns" data-id="!portfolio_column2" >                	
    <div class="pgContent" >
    
        <!-- slider -->          
        <div class="slider6 fmSlider fixedHeight" >  
          	<div class="fmSlides sixteen columns" >
            
            	<!-- project 1 -->
				<div class="fmSliderNode projCol2" >
                	
                    <!-- project thumbnail -->
					<div class="projThumb_medium slider_nav">
						<img  src="images/portfolio/thumb12.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
                    
                     <!-- project Name -->
					<div class="projName" ><h6><span>	Project 1 	</span></h6></div>
                     <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Default style - Mini description about project</em>	</span></h6></div>
                 
                 	<!-- project full details -->
					<div class="fullDetails" >
                    	
                        <!-- project image slide show -->
                    	<div class="projImgs">
                        	<div class="flexSlideshow" >
                        		<ul class="slides"> 
                                    <li><a  class="lazyload" href="images/portfolio/image1.jpg" data-src-small="images/portfolio/image1_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image2.jpg" data-src-small="images/portfolio/image2_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image3.jpg" data-src-small="images/portfolio/image3_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image4.jpg" data-src-small="images/portfolio/image4_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image5.jpg" data-src-small="images/portfolio/image5_s.jpg" title="Some text">image</a></li>
                            	</ul>
							</div>
						</div>
                        
                        <!-- project description -->
                        <div class="projDetails scroll-pane" >
						  	<div class="detail_spacing">
                            
                            	<h2 class="title_light">Project title 1 </h2>
                                
                                <strong>Date:</strong> October 2012 <br>
                                <strong>Client:</strong> Nikey Company <br>
                                <strong>Skills:</strong> Branding <br><br>
                                <strong>Software use</strong><br>
                                
                                <ul>
                                	<li class="list4">jQuery</li><br>
                                    <li class="list4">CSS3</li><br>
                                    <li class="list4">Flash</li><br>
                                	<li class="list4">wordpress</li>
                                </ul>
                                
                                <p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
 <strong>Live Url:</strong>  <a class="underLine"><em>Nikey Company</em></a>
 
 							</div >
                        </div>
                        
                    </div>
				</div>

				
                <!-- project 2 -->
                <div class="fmSliderNode projCol2"  >
                	
                     <!-- project thumbnail -->
					<div class="projThumb_medium slider_nav">
						<img  src="images/portfolio/thumb13.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					
                    <!-- project Name -->
                    <div class="projName" ><h6><span>	Project 2 	</span></h6></div>
                    <!-- project full details -->
					<div class="miniDesc" ><h6><span>	<em>Another style - Mini description about project</em>	</span></h6></div>
                
                	<!-- project full details -->
                    <div class="fullDetails" >
						<div class="container" >

							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
                                
									<h2 class="title_light">Project title 2 - <em>another style</em></h2>
         
									<div class="separator_mini"></div> 
                                    
                                    <!-- project image slide show -->
									<div class="flexSlideshow fixedSize" >
										<ul class="slides"> 
											<li><a  class="lazyload" href="images/slideshow/image4.jpg" data-src-small="images/slideshow/image4_s.jpg" title="Some text">image</a></li>
											<li><a  class="lazyload" href="images/slideshow/image3.jpg" data-src-small="images/slideshow/image3_s.jpg" title="Some text">image</a></li>
											<li><a  class="lazyload" href="images/slideshow/image1.jpg" data-src-small="images/slideshow/image1_s.jpg" title="Some text">image</a></li>
											<li><a  class="lazyload" href="images/slideshow/image2.jpg" data-src-small="images/slideshow/image2_s.jpg" title="Some text">image</a></li>
										</ul>
									</div>
                                
									<div class="separator_mini"></div> 
                                            
									<strong>Date:</strong> October 2012 <br>
									<strong>Client:</strong> Mapiya Company <br>
									<strong>Skills:</strong> Branding <br><br>
									<strong>Software use</strong><br>
                                    
									<ul>
										<li class="list4">jQuery</li><br>
										<li class="list4">CSS3</li><br>
										<li class="list4">nocss</li><br>
										<li class="list4">wordpress</li>
									</ul>
									
                                    <p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.	</p>
									
                                    <p>Ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
             						<strong>Live Url:</strong>  <a class="underLine"><em>Mapiya Company</em></a>

									<div class="separator_mini"></div> 
                                        
								</div> 
							</div>  
                        </div>
                        
                    </div>
                    
				</div>
                
                                            
                <!-- project 3 -->
                <div class="fmSliderNode projCol2"  >
                
                	<!-- project thumbnail -->
					<div class="projThumb_medium slider_nav">
						<img  src="images/portfolio/thumb14.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					
                    <!-- project Name -->
                    <div class="projName" ><h6><span>	Project 3 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Image only - Mini project description</em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                    	<!-- project image slide show -->
                    	<div class="projImgs" >
                        	<div class="flexSlideshow" >
                        		<ul class="slides">
                               		<li><a  class="lazyload" href="images/portfolio/image6.jpg" data-src-small="images/portfolio/image6_s.jpg" title="Some text">image</a></li>
                                	<li><a  class="lazyload" href="images/portfolio/image8.jpg" data-src-small="images/portfolio/image8_s.jpg" title="Some text">image</a></li> 
                                    <li><a  class="lazyload" href="images/portfolio/image9.jpg" data-src-small="images/portfolio/image9_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image2.jpg" data-src-small="images/portfolio/image2_s.jpg" title="Some text">image</a></li>
                            	</ul>
                             </div>
                        </div>
                    </div>
                    
				</div> 
                                 
                <!-- project 4 -->
                <div class="fmSliderNode projCol2"  >
                
                	<!-- project thumbnail -->
					<div class="projThumb_medium slider_nav">
						<img  src="images/portfolio/thumb15.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					
                    <!-- project Name -->
                    <div class="projName" ><h6><span>	Project 4 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Video & Text - Mini project description</em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                    	<!-- project video -->
                     	<div class="projImgs" style="position:relative; float:left; overflow:hidden">
                        	<div class="addVideo" data-width="100%" data-height="100%" data-autoplay="false" data-url="http://vimeo.com/45778774" ></div>
                        </div>
                         
                         <!-- project details -->  
                         <div class="projDetails scroll-pane" >
                         	<div class="detail_spacing">
                            
                         		<h2 class="title_light">Project title 4</h2>
                                    
                         		<strong>Date:</strong> October 2012 <br>
                         		<strong>Client:</strong> Mapiya Company <br>
                         		<strong>Skills:</strong> Branding <br><br>
                         		<strong>Software use</strong><br>
                         		<ul>
                         			<li class="list4">jQuery</li><br>
                         			<li class="list4">CSS3</li><br>
                         			<li class="list4">nocss</li><br>
                         			<li class="list4">wordpress</li>
                         		</ul>
                                
                         		<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>	

     							<strong>Live Url:</strong>  <a class="underLine"><em>Mapiya Company</em></a>
     
                         	</div >
						</div>
                    </div>
                    
				</div>
                
                <!-- project 5 -->
                <div class="fmSliderNode projCol2"  >
                	<!-- project thumbnail -->
					<div class="projThumb_medium slider_nav">
						<img  src="images/portfolio/thumb16.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					<!-- project Name -->
                    <div class="projName" ><h6><span>	Project 5 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Video only - Mini project description</em>	</span></h6></div>
                    <!-- project full details -->
                    <div class="fullDetails noMargin">
                    	<!-- Video -->
                    	<div class="projImgs" >
                        	<div class="addVideo" data-width="100%" data-height="100%" data-autoplay="false" data-url="http://vimeo.com/45778774" ></div>
                        </div>
                    </div>
				</div>
                
                
                <!-- project 6 -->
                <div class="fmSliderNode projCol2"  >
                
                	<!-- project thumbnail -->
					<div class="projThumb_medium slider_nav">
						<img  src="images/portfolio/thumb11.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					
                    <!-- project Name -->
                    <div class="projName" ><h6><span>	Project 6 	</span></h6></div>
                    <!-- project mini description -->
					<div class="miniDesc" ><h6><span>	<em>Small description about project</em>	</span></h6></div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                        <!-- project image slide show -->
                    	<div class="projImgs" >
                        	<div class="flexSlideshow" >
                        		<ul class="slides"> 
                                    <li><a  class="lazyload" href="images/portfolio/image4.jpg" data-src-small="images/portfolio/image4_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image12.jpg" data-src-small="images/portfolio/image12_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image13.jpg" data-src-small="images/portfolio/image13_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image8.jpg" data-src-small="images/portfolio/image8_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image9.jpg" data-src-small="images/portfolio/image9_s.jpg" title="Some text">image</a></li>
                            	</ul>
							</div>
						</div>
                        
                        <!-- project description -->
                        <div class="projDetails scroll-pane" >
						  	<div class="detail_spacing">
                            	<h2 class="title_light">Project title 6</h2>
                                
                                <strong>Date:</strong> October 2012 <br>
                                <strong>Client:</strong> Mapiya Company <br>
                                <strong>Skills:</strong> Branding <br><br>
                                <strong>Software use</strong><br>
                                <ul>
                                	<li class="list4">jQuery</li><br>
                                    <li class="list4">CSS3</li><br>
                                    <li class="list4">Skeleton</li><br>
                                	<li class="list4">Wordpress</li>
                                </ul>
                                Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.	<hr>
 <strong>Live Url:</strong>  <a class="underLine"><em>Mapiya Company</em></a>
 							</div >
                        </div>
                    </div>
                    
				</div> 
                
				
               	<!-- End projects -->
                  
			</div>
        </div>
    
    </div>
</div>


<!-- End Portfolio 2 column portfolio --> 
 
 
 
 
<!-- Portfolio 1 column 

	This portfolio page plug-in initialize code is placed on header area. 
    You can see it near the comment line  // portfolio column 1 
    
-->


<div class="page sixteen columns" data-id="!portfolio_column1" >                	
    <div class="pgContent" >
    
        <!-- slider -->          
        <div class="slider7 fmSlider fixedHeight" >  
          	<div class="fmSlides sixteen columns" >
            
            	<!-- project 1 -->
				<div class="fmSliderNode projCol1" >
                	
                    <!-- project thumbnail -->
                    <div class="projCol1" >
                    
                        <div class="projCol3 slider_nav" >
                            <div class="projThumb_medium border3" >
                                <img  src="images/portfolio/thumb12.jpg" class="scale_fill" alt="Wonder" />
                                <div class="overlay detail"></div>
                            </div>
                        </div>
                        
                        <div class="proCol1Des">
                        	<h3>Project 1</h3>
                            <p>Aorem rusum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
     						<strong>Live Url:</strong>  <a class="underLine"><em>Nikey Company</em></a>
     						<a class="alignRight" href="#portfolio_column1?p=0"><span class="button small">More Details</span></a>
                        </div>
                    </div>
                    
                    
                 	<!-- project full details -->
					<div class="fullDetails" >
                    	
                        <!-- project image slide show -->
                    	<div class="projImgs">
                        	<div class="flexSlideshow" >
                        		<ul class="slides"> 
                                    <li><a  class="lazyload" href="images/portfolio/image1.jpg" data-src-small="images/portfolio/image1_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image2.jpg" data-src-small="images/portfolio/image2_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image3.jpg" data-src-small="images/portfolio/image3_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image4.jpg" data-src-small="images/portfolio/image4_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image5.jpg" data-src-small="images/portfolio/image5_s.jpg" title="Some text">image</a></li>
                            	</ul>
							</div>
						</div>
                        
                        <!-- project description -->
                        <div class="projDetails scroll-pane" >
						  	<div class="detail_spacing">
                            
                            	<h2 class="title_light">Project title 1 </h2>
                                
                                <strong>Date:</strong> October 2012 <br>
                                <strong>Client:</strong> Nikey Company <br>
                                <strong>Skills:</strong> Branding <br><br>
                                <strong>Software use</strong><br>
                                
                                <ul>
                                	<li class="list4">jQuery</li><br>
                                    <li class="list4">CSS3</li><br>
                                    <li class="list4">Flash</li><br>
                                	<li class="list4">wordpress</li>
                                </ul>
                                
                                <p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
 <strong>Live Url:</strong>  <a class="underLine"><em>Nikey Company</em></a>
 
 							</div >
                        </div>
                        
                    </div>
                    
                     <hr>
                    
				</div>
				
                
				
                <!-- project 2 -->
                <div class="fmSliderNode projCol1"  >
                	

                    <!-- project thumbnail -->
                    <div class="projCol1" >
                    
                        <div class="projCol3 slider_nav" >
                            <div class="projThumb_medium border3">
                                <img  src="images/portfolio/thumb13.jpg" class="scale_fill" alt="Wonder" />
                                <div class="overlay detail"></div>
                            </div>
                        </div>
                        
                         <div class="proCol1Des">
                        	<h3>Project 2</h3>
                            <p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
     						<strong>Live Url:</strong>  <a class="underLine"><em>Mapiya Company</em></a>
     						<a class="alignRight" href="#portfolio_column1?p=1"><span class="button small">More Details</span></a>
                        </div>
                    </div>
                    
                	<!-- project full details -->
                    <div class="fullDetails" >
						<div class="container" >

							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
                                
									<h2 class="title_light">Project title 2 - <em>another style</em></h2>
         
									<div class="separator_mini"></div> 
                                    
                                    <!-- project image slide show -->
									<div class="flexSlideshow fixedSize" >
										<ul class="slides"> 
											<li><a  class="lazyload" href="images/slideshow/image4.jpg" data-src-small="images/slideshow/image4_s.jpg" title="Some text">image</a></li>
											<li><a  class="lazyload" href="images/slideshow/image3.jpg" data-src-small="images/slideshow/image3_s.jpg" title="Some text">image</a></li>
											<li><a  class="lazyload" href="images/slideshow/image1.jpg" data-src-small="images/slideshow/image1_s.jpg" title="Some text">image</a></li>
											<li><a  class="lazyload" href="images/slideshow/image2.jpg" data-src-small="images/slideshow/image2_s.jpg" title="Some text">image</a></li>
										</ul>
									</div>
                                
									<div class="separator_mini"></div> 
                                            
									<strong>Date:</strong> October 2012 <br>
									<strong>Client:</strong> Mapiya Company <br>
									<strong>Skills:</strong> Branding <br><br>
									<strong>Software use</strong><br>
                                    
									<ul>
										<li class="list4">jQuery</li><br>
										<li class="list4">CSS3</li><br>
										<li class="list4">nocss</li><br>
										<li class="list4">wordpress</li>
									</ul>
									
                                    <p>Quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.	</p>
									
                                    <p>Ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
             						<strong>Live Url:</strong>  <a class="underLine"><em>Mapiya Company</em></a>

									<div class="separator_mini"></div> 
                                        
								</div> 
							</div>  
                        </div>
                        
                    </div>
                    
				</div>
                
                                            
                <!-- project 3 -->
                <div class="fmSliderNode projCol1"  >
                
                	<!-- project thumbnail -->
                    <div class="projCol1" >
                    
                        <div class="projCol3 slider_nav" >
                            <div class="projThumb_medium border3">
                                <img  src="images/portfolio/thumb15.jpg" class="scale_fill" alt="Wonder" />
                                <div class="overlay detail"></div>
                            </div>
                        </div>
                        
                         <div class="proCol1Des">
                        	<h3>Project 3</h3>
                            <p>Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum.</p>
     						<strong>Live Url:</strong>  <a class="underLine"><em>Luma Company</em></a>
     						<a class="alignRight" href="#portfolio_column1?p=2"><span class="button small">More Details</span></a>
                        </div>
                    </div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                    	<!-- project image slide show -->
                    	<div class="projImgs" >
                        	<div class="flexSlideshow" >
                        		<ul class="slides">
                               		<li><a  class="lazyload" href="images/portfolio/image6.jpg" data-src-small="images/portfolio/image6_s.jpg" title="Some text">image</a></li>
                                	<li><a  class="lazyload" href="images/portfolio/image8.jpg" data-src-small="images/portfolio/image8_s.jpg" title="Some text">image</a></li> 
                                    <li><a  class="lazyload" href="images/portfolio/image9.jpg" data-src-small="images/portfolio/image9_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image2.jpg" data-src-small="images/portfolio/image2_s.jpg" title="Some text">image</a></li>
                            	</ul>
                             </div>
                        </div>
                    </div>
                    
                     <hr>
                     
				</div> 
                                 
                <!-- project 4 -->
                <div class="fmSliderNode projCol1"  >
                
                	<!-- project thumbnail -->
                    <div class="projCol1" >
                    
                        <div class="projCol3 slider_nav" >
                            <div class="projThumb_medium border3">
                                <img  src="images/portfolio/thumb16.jpg" class="scale_fill" alt="Wonder" />
                                <div class="overlay detail"></div>
                            </div>
                        </div>
                        
                         <div class="proCol1Des">
                        	<h3>Project 4</h3>
                            <p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
     						<strong>Live Url:</strong>  <a class="underLine"><em>Detro Company</em></a>
     						<a class="alignRight" href="#portfolio_column1?p=3"><span class="button small">More Details</span></a>
                        </div>
                    </div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                    	<!-- project video -->
                     	<div class="projImgs" style="position:relative; float:left; overflow:hidden">
                        	<div class="addVideo" data-width="100%" data-height="100%" data-autoplay="false" data-url="http://vimeo.com/45778774" ></div>
                        </div>
                         
                         <!-- project details -->  
                         <div class="projDetails scroll-pane" >
                         	<div class="detail_spacing">
                            
                         		<h2 class="title_light">Project title 4</h2>
                                    
                         		<strong>Date:</strong> October 2012 <br>
                         		<strong>Client:</strong> Mapiya Company <br>
                         		<strong>Skills:</strong> Branding <br><br>
                         		<strong>Software use</strong><br>
                         		<ul>
                         			<li class="list4">jQuery</li><br>
                         			<li class="list4">CSS3</li><br>
                         			<li class="list4">nocss</li><br>
                         			<li class="list4">wordpress</li>
                         		</ul>
                                
                         		<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>	

     							<strong>Live Url:</strong>  <a class="underLine"><em>Fuma Company</em></a>
     
                         	</div >
						</div>
                    </div>
                    
				</div>
                
                <!-- project 5 -->
                <div class="fmSliderNode projCol1"  >
                	
                    <!-- project thumbnail -->
                    <div class="projCol1" >
                    
                        <div class="projCol3 slider_nav" >
                            <div class="projThumb_medium border3">
                                <img  src="images/portfolio/thumb16.jpg" class="scale_fill" alt="Wonder" />
                                <div class="overlay detail"></div>
                            </div>
                        </div>
                        
                         <div class="proCol1Des">
                        	<h3>Project 5</h3>
                            <p>Labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
     						<strong>Live Url:</strong>  <a class="underLine"><em>Fuma Company</em></a>
     						<a class="alignRight" href="#portfolio_column1?p=4"><span class="button small">More Details</span></a>
                        </div>
                    </div>
                    
                    <!-- project full details -->
                    <div class="fullDetails noMargin">
                    	<!-- Video -->
                    	<div class="projImgs" >
                        	<div class="addVideo" data-width="100%" data-height="100%" data-autoplay="false" data-url="http://vimeo.com/45778774" ></div>
                        </div>
                    </div>
                    
                    <hr>
                    
				</div>
                
				
               	<!-- End projects -->
                  
			</div>
        </div>
    
    </div>
</div>


<!-- End portfolio 1 column -->


 
 
<!-- Portfolio single project 

	This portfolio page plug-in initialize code is placed on header area. 
    You can see it near the comment line // portfolio single project

-->


<div class="page sixteen columns" data-id="!portfolio_single" >                	
    <div class="pgContent" >
    
        <!-- slider -->          
        <div class="slider8 fmSlider fixedHeight" >  
          	<div class="fmSlides sixteen columns" >
            
            	<!-- project 1 -->
				<div class="fmSliderNode projCol0" >
				
                	<!-- project thumbnail -->
					<div class="proSingle slider_nav" >
						<div class="projThumb_middle">
							<img  src="images/portfolio/thumb17.jpg" class="scale_fit" alt="Wonder" />
							<div class="overlay detail"></div>
						</div>
					</div>
                    
                    <!-- project mini description -->
					<div class="proDes">
                        <h3>Project 1</h3>
                         <p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
     					<strong>Live Url:</strong>  <a class="underLine"><em>Nikey Company</em></a>
     					<a class="alignRight" href="#portfolio_single?p=0"><span class="button small">More Details</span></a>
					</div>
                    
                    
                 	<!-- project full details -->
					<div class="fullDetails" >
                    	
                        <!-- project image slide show -->
                    	<div class="projImgs">
                        	<div class="flexSlideshow" >
                        		<ul class="slides"> 
                                    <li><a  class="lazyload" href="images/portfolio/image1.jpg" data-src-small="images/portfolio/image1_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image2.jpg" data-src-small="images/portfolio/image2_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image3.jpg" data-src-small="images/portfolio/image3_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image4.jpg" data-src-small="images/portfolio/image4_s.jpg" title="Some text">image</a></li>
                                    <li><a  class="lazyload" href="images/portfolio/image5.jpg" data-src-small="images/portfolio/image5_s.jpg" title="Some text">image</a></li>
                            	</ul>
							</div>
						</div>
                        
                        <!-- project description -->
                        <div class="projDetails scroll-pane" >
						  	<div class="detail_spacing">
                            
                            	<h2 class="title_light">Project title 1 </h2>
                                
                                <strong>Date:</strong> October 2012 <br>
                                <strong>Client:</strong> Nikey Company <br>
                                <strong>Skills:</strong> Branding <br><br>
                                <strong>Software use</strong><br>
                                
                                <ul>
                                	<li class="list4">jQuery</li><br>
                                    <li class="list4">CSS3</li><br>
                                    <li class="list4">Flash</li><br>
                                	<li class="list4">wordpress</li>
                                </ul>
                                
                                <p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
 <strong>Live Url:</strong>  <a class="underLine"><em>Nikey Company</em></a>
 
 							</div >
                        </div>
                        
                    </div>
                    
                     <hr>
                    
				</div>
				
                
				
                <!-- project 2 -->
                <div class="fmSliderNode projCol0"  >
                	
					<h2 class="title_light">Project 2 - <em>Title text</em></h2>
                    <br/>
                    <!-- project thumbnail -->
					<div class="proSingle slider_nav" >
						<div class="projThumb_middle">
							<img  src="images/portfolio/thumb18.jpg" class="scale_fit" alt="Wonder" />
							<div class="overlay detail"></div>
						</div>
					</div>
                    
                    <!-- project mini description -->
					<div class="proDes">
                         <p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
     					<strong>Live Url:</strong>  <a class="underLine"><em>HealthOur Company</em></a>
     					<a class="alignRight" href="#portfolio_single?p=1"><span class="button small">More Details</span></a>
					</div>
                    
                	<!-- project full details -->
                    <div class="fullDetails" >
						<div class="container" >

							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
                                
									<h2 class="title_light">Project title 2 - <em>another style</em></h2>
         
									<div class="separator_mini"></div> 
                                    
                                    <!-- project image slide show -->
									<div class="flexSlideshow fixedSize" >
										<ul class="slides"> 
											<li><a  class="lazyload" href="images/slideshow/image4.jpg" data-src-small="images/slideshow/image4_s.jpg" title="Some text">image</a></li>
											<li><a  class="lazyload" href="images/slideshow/image3.jpg" data-src-small="images/slideshow/image3_s.jpg" title="Some text">image</a></li>
											<li><a  class="lazyload" href="images/slideshow/image1.jpg" data-src-small="images/slideshow/image1_s.jpg" title="Some text">image</a></li>
											<li><a  class="lazyload" href="images/slideshow/image2.jpg" data-src-small="images/slideshow/image2_s.jpg" title="Some text">image</a></li>
										</ul>
									</div>
                                
									<div class="separator_mini"></div> 
                                            
									<strong>Date:</strong> October 2012 <br>
									<strong>Client:</strong> Mapiya Company <br>
									<strong>Skills:</strong> Branding <br><br>
									<strong>Software use</strong><br>
                                    
									<ul>
										<li class="list4">jQuery</li><br>
										<li class="list4">CSS3</li><br>
										<li class="list4">nocss</li><br>
										<li class="list4">wordpress</li>
									</ul>
									
                                    <p>Quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.	</p>
									
                                    <p>Ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
             						<strong>Live Url:</strong>  <a class="underLine"><em>HealthOur Company</em></a>

									<div class="separator_mini"></div> 
                                        
								</div> 
							</div>  
                        </div>
                        
                    </div>
                    
				</div>
                
                                            
                <!-- project 3 -->
                <div class="fmSliderNode projCol0"  >
                
                	<!-- project thumbnail -->
					<div class="proSingle slider_nav" >
						<div class="projThumb_middle">
							<img  src="images/portfolio/thumb19.jpg" class="scale_fit" alt="Wonder" />
							<div class="overlay detail"></div>
						</div>
					</div>
                        
					<div class="proDes">
                        <h3>Project 3</h3>
                         <p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
     					<strong>Live Url:</strong>  <a class="underLine"><em>videoWorld Company</em></a>
     					<a class="alignRight" href="#portfolio_single?p=2"><span class="button small">More Details</span></a>
					</div>
                    
                    <!-- project full details -->
                    <div class="fullDetails" >
                    	<!-- project video -->
                     	<div class="projImgs" style="position:relative; float:left; overflow:hidden">
                        	<div class="addVideo" data-width="100%" data-height="100%" data-autoplay="false" data-url="http://vimeo.com/45778774" ></div>
                        </div>
                         
                         <!-- project details -->  
                         <div class="projDetails scroll-pane" >
                         	<div class="detail_spacing">
                            
                         		<h2 class="title_light">Project title 3</h2>
                                    
                         		<strong>Date:</strong> October 2012 <br>
                         		<strong>Client:</strong> Mapiya Company <br>
                         		<strong>Skills:</strong> Branding <br><br>
                         		<strong>Software use</strong><br>
                         		<ul>
                         			<li class="list4">jQuery</li><br>
                         			<li class="list4">CSS3</li><br>
                         			<li class="list4">nocss</li><br>
                         			<li class="list4">wordpress</li>
                         		</ul>
                                
                         		<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>	

     							<strong>Live Url:</strong>  <a class="underLine"><em>videoWorld Company</em></a>
     
                         	</div >
						</div>
                    </div>
                    
                     <hr>
                     
				</div>
                
				
               	<!-- End projects -->
                  
			</div>
        </div>
    
    </div>
</div>



<!-- End portfolio single project  --> 




 
 <!-- Full screen Gallery page -->
                
<div class="page sixteen columns" data-id="!fullscreen_gallery" >
    <div class="pgContent" >
      
    	 <div class="scroll-pane full_size" >
         <!-- Below content are placed inside the Scrollbar -->
                
                <!-- 
                	The fs_gallery class is used to identify this gallery to main plugin if you need to add more than one gallery
                	just copy and past the below div to another page that's all.
                -->
                
				<div class="fs_gallery_wrap fs_gallery" >
                	<div class="fs_thumbs">
                    
                    	<!-- 
                        	Each fsThumb div contain large image, thumbnail image, and animated text
                        	The data-src attribute used to load High resolution image for desktop 
                            The data-src-small attribute used to load Low resolution image for mobile device
                            The data-imgResize attribute is used to set the image resize type. The options are fill / fit / none
                            	fill- The image resize to cover over the browser window
                                fit - The image resize to fit inside the browser window
                                none - The image can't be resize just show the original size
                            Below the fsThumb div the thumbnail image and caption text is added
                         -->
                          
                        <div class="fsThumb" data-src="images/gallery/image1.jpg" data-src-small="images/gallery/image1_s.jpg" data-imgResize="" >
                        	<img  src="images/gallery/thumb1.jpg" class="fsThumb-scale" alt="Wonder" />
                            <div class="fs_caption caption_style3"> 
                            	<div> <h2 class="title_light"><span> FineTune - Responsive Template</span></h2></div>
                                <div> <h3><span>for creative, portfolio & corporate website</span></h3></div>
                            </div>
                        </div>
                         
                        <div class="fsThumb" data-src="images/gallery/image2.jpg" data-src-small="images/gallery/image2_s.jpg" data-imgResize=""  >
                        	<img  src="images/gallery/thumb2.jpg" class="fsThumb-scale" alt="Wonder" />
                            <div class="fs_caption caption_style3"> 
                            	<div> <h2 class="title_light"><span>Perfect Portfolio with detail page</span></h2></div>
                            	<div> <h2 class="title_light"><span>News, Isotope, Full screen gallery</span></h2></div>
                            	<div> <h2 class="title_light"><span>Support Touch drag and much more</span></h2></div>
                            </div>
                        </div>
                        
                     	<div class="fsThumb" data-src="images/gallery/image3.jpg" data-src-small="images/gallery/image3_s.jpg" data-imgResize="" >
                        	<img  src="images/gallery/thumb3.jpg" class="fsThumb-scale" alt="Wonder" />
                            <div class="fs_caption caption_style4"> 
                            	<div> <h1 class="title_light"><span>High & Low resolution image</span></h1></div>
                            	<div> <h3><span>for Desktop & Mobile device</span></h3></div>
                            </div>
                        </div>
                        
                                                
                         <div class="fsThumb" data-src="images/gallery/image4.jpg" data-src-small="images/gallery/image4_s.jpg" data-imgResize=""  >
                        	<img  src="images/gallery/thumb4.jpg" class="fsThumb-scale" alt="Wonder" />
                            <div class="fs_caption caption_style3"> 
                            	<div> <h1 class="large_font title_light light_color"><span>Black / White version</span></h1></div>
                                <div> <h1 class="title_light light_color"><span>Changing to any color easily</span></h1></div>
                            </div>
                        </div>
                        
                        <div class="fsThumb" data-src="images/gallery/image5.jpg" data-src-small="images/gallery/image5_s.jpg" data-imgResize="" >
                        	<img  src="images/gallery/thumb5.jpg" class="fsThumb-scale" alt="Wonder" />
                            <div class="fs_caption caption_style3"> 
								<div> <h1 class="large_font title_light"><span>Simple look and contrast</span></h1></div>
							</div>
                               
                        </div>
                        
                        <div class="fsThumb" data-src="images/gallery/image6.jpg" data-src-small="images/gallery/image6_s.jpg" data-imgResize="" >
                        	<img  src="images/gallery/thumb6.jpg" class="fsThumb-scale" alt="Wonder" />
                            <div class="fs_caption caption_style4"> 
                            	<div> <h1 class="large_font title_light light_color text_shadow">Cross browser capability</h1></div>
                                <div> <h1 class="large_font title_light light_color text_shadow">Best look in iPad</h1></div>
                                <div> <h1 class="large_font title_light light_color text_shadow">Easy to edit</h1></div>
                            </div>
							
                        </div>

                        
                         <div class="fsThumb" data-src="images/gallery/image7.jpg" data-src-small="images/gallery/image7_s.jpg" data-imgResize="" >
                        	<img  src="images/gallery/thumb7.jpg" class="fsThumb-scale" alt="Wonder" />
                            <div class="fs_caption caption_style6"> 
                            	<div> <h1 class="title_light"><span>Complete Responsive</span></h1></div>
                                <div> <h3 class="title_light"><span>Set background image for each page</span></h3></div>
                            </div>
                        </div>
                        
                        <div class="fsThumb" data-src="images/gallery/image4.jpg" data-src-small="images/gallery/image4_s.jpg" data-imgResize="" >
                        	<img  src="images/gallery/thumb4.jpg" class="fsThumb-scale" alt="Wonder" />
                            <div class="fs_caption caption_style4"> 
                            	<div> <h1 class="title_light"><span>Full Screen Gallery</span></h1></div>
                            	<div> <h1 class="title_light"><span>with clean text Animation</span></h1></div>
                            	<div> <h1 class="title_light"><span>Use more than one gallery page</span></h1></div>
                            </div>
                        </div>
                        
                        <div class="fsThumb" data-src="images/gallery/image2.jpg" data-src-small="images/gallery/image2_s.jpg" data-imgResize="" >
                        	<img  src="images/gallery/thumb2.jpg" class="fsThumb-scale" alt="Wonder" />
                            <div class="fs_caption caption_style2"> 
                            	<div> <h3 class="title_light">3 variation Blog with separate page</h3></div>
                                <div> <h6>Easy to add single blog post separate page. <br>Integer commodo quis fringilla ligula aliquet ut. Maecenas sed justo varius velit imperdiet bibendum. commodo tristique odio.</h6></div>
                            </div>
                        </div>
                        
                        <div class="fsThumb" data-src="images/gallery/image6.jpg" data-src-small="images/gallery/image6_s.jpg" data-imgResize="" >
                        	<img  src="images/gallery/thumb6.jpg" class="fsThumb-scale" alt="Wonder" />
                            <div class="fs_caption caption_style2"> 
                            	<div> <h4 class="strong">Complete Help document and All PSD files are included in download file</h4></div>
                                <div> <h6>Integer commodo quis fringilla ligula aliquet ut. Maecenas sed justo varius velit imperdiet bibendum. commodo tristique odio. quis fringilla ligula aliquet ut. Maecenas sed justo varius velit.</h6></div>
                            </div>
                        </div> 
                        
            		</div>
                </div>
            
		</div>
        
        <div class="separator_mini"></div>
        
    </div>
</div>

<!-- End Full screen Gallery page -->



 
<!-- Isotope Gallery page -->
                
<div class="page sixteen columns" data-id="!isotope" >                	
    <div class="pgContent" >
     
		<div class="alignLeft" >
            <div class=" mobile_spacing">
                <h1 class="title_light">Category Gallery</h1>
            </div> 
        </div>
        
        <div class="isotope_option" >   
        	<div class=" mobile_spacing">                                  
                <section id="options" class="clearfix" >
                    <ul id="filters" class="option-set clearfix" data-option-key="filter">
                         <!-- Add portfolio category -->                          
                        <li><a href="#filter" data-option-value="*" class="selected" ><div class="catName">ALL</div></a></li>
                        <li><a href="#filter" data-option-value=".web"> <div class="catName">WEB</div> </a></li>
                        <li><a href="#filter" data-option-value=".art"> <div class="catName">LOGO</div></a></li>
                        <li><a href="#filter" data-option-value=".seo"> <div class="catName">SEO</div></a></li>
                    </ul>
                </section>
            </div>
        </div>  
                 
	
                            
		<div class="separator_mini"></div>
                
                                           
        <div class="scroll-pane full_size"  style="overflow-x:hidden" >
         <!-- Below content are placed inside the Scrollbar -->
	    
            <div id="gallery_isotope_1" class="isotope_items clearfix" style="overflow-x:hidden" >
            	<!-- The title text on the <a> tag is show inside the thumbnail image. 
                	 The text on the img_text class div is show on the popup area  -->
            
                <div class="item web" >
                    <a rel="example_group" title="Text display over thumbnail <br> with mask animation" href="images/isotope/image1.jpg" data-src-small="images/isotope/image1_s.jpg" class="type2"  >
                        <div class="img_text">
                        	<h3 class="title_light">This text show on popup box with nice fade animation.</h3>
                        </div>
                        <img src="images/isotope/thumb1.jpg" alt="Wonder" />
                    </a>
                </div>
                             
                <div class="item web" >
                    <a rel="example_group" title="Nice slide animation" href="http://www.youtube.com/watch?v=_1NGnVLDPog" class="type3" >
                        <div class="img_text">
                        	<em>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer commodo tristique odio</em>
                        </div>
                        <img   src="images/isotope/thumb2.jpg" alt="Wonder" />
                  </a>
                </div>
                                        
                <div class="item web" >
                    <a rel="example_group" href="http://player.vimeo.com/video/35160025" class="type3" >
                        <div class="img_text"></div>
                        <img   src="images/isotope/thumb3.jpg" alt="Wonder" />
                    </a>
                </div>
                                              
                <div class="item web" >
                    <a rel="example_group" href="images/isotope/image4.jpg" class="type2" >
                        <div class="img_text"></div>
                        <img   src="images/isotope/thumb4.jpg" alt="Wonder" />
                    </a>
                </div>
                                              
                <div class="item web" >
                    <a rel="example_group" href="images/isotope/image5.jpg" data-src-small="images/isotope/image5_s.jpg" class="type2" >
                        <div class="img_text"></div>
                        <img   src="images/isotope/thumb5.jpg" alt="Wonder" />
                    </a>
                </div>
                
                <div class="item web" >
                    <a rel="example_group" title="Text display over thumbnail <br> with mask animation" href="images/isotope/image1.jpg" data-src-small="images/isotope/image1_s.jpg" class="type2"  >
                        <div class="img_text">
                        	<h3 class="title_light">This text show on popup box with nice fade animation.</h3>
                        </div>
                        <img src="images/isotope/thumb1.jpg" alt="Wonder" />
                    </a>
                </div>
                             
                <div class="item web" >
                    <a rel="example_group" title="Nice slide animation" href="images/isotope/image2.jpg" data-src-small="images/isotope/image2_s.jpg" class="type2" >
                        <div class="img_text">
                        	<em>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer commodo tristique odio</em>
                        </div>
                        <img   src="images/isotope/thumb2.jpg" alt="Wonder" />
                  </a>
                </div>
                                        
                <div class="item web" >
                    <a rel="example_group" href="images/isotope/image3.jpg" data-src-small="images/isotope/image3_s.jpg" class="type2" >
                        <div class="img_text"></div>
                        <img   src="images/isotope/thumb3.jpg" alt="Wonder" />
                    </a>
                </div>
                                              
                <div class="item art" >
                    <a rel="example_group" href="images/isotope/image1.jpg" data-src-small="images/isotope/image1_s.jpg" class="type2" >
                        <div class="img_text"></div>
                        <img   src="images/isotope/thumb1.jpg" alt="Wonder" />
                    </a>
                </div>
                                              
                <div class="item art" >
                    <a rel="example_group" href="images/isotope/image2.jpg" data-src-small="images/isotope/image2_s.jpg" class="type2" >
                        <div class="img_text"></div>
                        <img   src="images/isotope/thumb2.jpg" alt="Wonder" />
                    </a>
                </div>
                                              
                <div class="item art" >
                    <a rel="example_group" href="images/isotope/image3.jpg" data-src-small="images/isotope/image3_s.jpg" class="type2" >
                        <div class="img_text"></div>
                        <img   src="images/isotope/thumb3.jpg" alt="Wonder" />
                    </a>
                </div>
                                              
                <div class="item seo" >
                    <a rel="example_group" href="images/isotope/image4.jpg" data-src-small="images/isotope/image4_s.jpg" class="type2" >
                        <div class="img_text"></div>
                        <img   src="images/isotope/thumb4.jpg" alt="Wonder" />
                    </a>
                </div>
                                              
                <div class="item seo" >
                    <a rel="example_group" href="images/isotope/image5.jpg" data-src-small="images/isotope/image5_s.jpg" class="type2" >
                        <div class="img_text"></div>
                        <img   src="images/isotope/thumb5.jpg" alt="Wonder" />
                    </a>
                </div>
            
            </div>
    	</div>
        <!-- End Scrollbar -->                 
       
       <div class="separator_mini"></div>
                       
      </div>                       
</div>

<!-- End Isotope gallery page -->
 
 
  
 <!-- Slide show page -->
                
<div class="page" data-id="!slideshow" >
    <div class="pgContent">
                        
       
        <!-- Below content are placed inside the Scrollbar -->
        
            <div class="mobile_spacing" >
                <!--     Flexslider    -->
                <div id="flexslider-container" >
                    <div class="flexslider" >  
                        <ul class="slides">
                        
                            <li>
                                <img src="images/slideshow/image1.jpg" alt="solidaire" />
                                <p class="flex-caption">Captions and cupcakes. Winning combination.</p>
                             </li>
                             
                             <li>
                                <img src="images/slideshow/image2.jpg" alt="solidaire" />
                                <p class="flex-caption">caption goes here adipiscing elit</p>
                            </li>
                                                    
                            <li>
                                <img src="images/slideshow/image3.jpg" alt="solidaire" />
                            </li>
                                                    
                            <li>
                                <img src="images/slideshow/image4.jpg" alt="solidaire" />
                            </li> 
                                           
                        </ul>                 
                    </div>
                </div>       
             </div>
             
        <!-- End Scrollbar -->    
       
       <div class="separator_mini"></div>       
    
    </div>   
</div>

<!-- End Slide show page -->
              




<!-- News page -->
                
<div class="page sixteen columns" data-id="!news" >                	
    <div class="pgContent" >
    
		<!-- slider -->          
        <div class="slider3 fmSlider" >  
          	<div class="fmSlides sixteen columns" >
            
            	<!-- News 1 -->
				<div class="fmSliderNode"  >
                	<!-- News thumbnail -->
					<div class="projThumb_large slider_nav">
						<img  src="images/news/thumb1.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
                    
                    <!-- News Name -->
					<div class="newsName" >
                    	<h6><span class="title_uppercase">	News title text 1	</span><br/>	
							<span><strong>Date: </strong><em>17/09/2012</em></span>	
						</h6>
					</div>
                    
                    <!-- News mini description -->
					<div class="miniDesc" ><h6><span>	<em>Small description about recent news</em>	</span></h6></div>
                 	
                    <!-- News full details -->
                    <div class="fullDetails" >
						<div class="container" >

							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
									<h2 class="title_light">News title 1 </h2>
									<strong>Date: </strong><em>17/09/2012</em>
                                                    
									<div class="separator_mini"></div>
                                     
                                    <!-- News single image -->
                                    <div class="large_image">
										<a  class="lazyload scale-with-grid" href="images/news/image1.jpg" data-src-small="images/news/image1_s.jpg" title="Some text">image</a>
                                    </div>   
                                    
									<div class="separator_mini"></div> 
                                
                                	<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                	<p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
									<div class="separator_mini"></div> 
								</div> 
							</div>
                            
                            <div class="ten columns alpha proPadLef" >
                                <div class="mobile_spacing" >
                                    <h4>Easy to add content</h4>
                                    <blockquote>
                                        <p>Blockquote style example It stands out, but is awesome. Lorem ipsum dolor tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                        <cite>Dave Gamache, Skeleton Creator</cite>
                                    </blockquote>
                                    
                                </div>
                            </div>
                                        
                            <div class="five columns alpha proPadLef" >
                                <div class="mobile_spacing" >
                                    <h4>Clean design</h4>
                                    <p>We also provide consectetur adipiscing elit. Lorem ipsum dolor sit a m et, consectetuer adipiscing elit.</p>
                                </div>
                            </div>           
                            
                           <div class="separator_mini"></div> 
                           
                           <div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
                           			<p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Ncididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                           		</div>
                           </div> 
                           
                           <div class="separator_mini"></div> 
                           
                           <!-- social link -->
                           <div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
                                    <ul class="social_bookmarks noMargin alignRight">
                                        <li class="twitter noMargin"><a>Follow us on Twitter</a></li>
                                        <li class="facebook noMargin"><a>Join our Facebook Group</a></li>
                                        <li class="gplus noMargin"><a>Join me on Google Plus</a></li>
                                        <li class="linkedin noMargin"><a>Add me on Linkedin</a></li>
                                        <li class="rss noMargin"><a>RSS</a></li>
                                    </ul>
                                    
									<strong>Author:</strong>  <a class="underLine"><em>Neam</em></a>
									<hr> 
                                    <div class="separator_mini"></div> 
                                </div>
                           </div> 
                                
                        </div>
                    </div>
                    
				</div>

				<!-- News 2 -->
                <div class="fmSliderNode"  >
                
                	<!-- News thumbnail -->
					<div class="projThumb_large slider_nav">
						<img  src="images/news/thumb2.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					
                    <!-- News Name -->
                    <div class="newsName" >
                    	<h6><span class="title_uppercase">	News title text 2	</span><br/>	
							<span><strong>Date: </strong><em>10/08/2012</em></span>	
						</h6>
					</div>
                    <!-- News mini description -->
					<div class="miniDesc" ><h6><span>	<em>Small description about recent news</em>	</span></h6></div>
                    
                    <!-- News full details -->
                    <div class="fullDetails" >
						<div class="container" >

							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
									<h2 class="title_light">News title 2 </h2>
									<strong>Date: </strong><em>15/07/2012</em>
                                                    
									<div class="separator_mini"></div> 
                                    
                                    <!-- News image slideshow -->
                                    <div class="large_image">
                                    	<div class="flexSlideshow fixedSize" >
                                            <ul class="slides">
                                                <li><a  class="lazyload" href="images/slideshow/image2.jpg" data-src-small="images/slideshow/image2_s.jpg" title="Some text">image</a></li>
                                                <li><a  class="lazyload" href="images/slideshow/image4.jpg" data-src-small="images/slideshow/image4_s.jpg" title="Some text">image</a></li> 
                                                <li><a  class="lazyload" href="images/slideshow/image3.jpg" data-src-small="images/slideshow/image3_s.jpg" title="Some text">image</a></li>
                                                <li><a  class="lazyload" href="images/slideshow/image1.jpg" data-src-small="images/slideshow/image1_s.jpg" title="Some text">image</a></li>
                                            </ul>
                                         </div>
                                    </div>   
                                    
									<div class="separator_mini"></div> 
                                
                                	<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                	<p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                    
                                     <p><span class="smallImg " ><img  class="border1" src="images/team_img2.jpg" alt="Wonder" /></span>Consectetuer ipsum dolor sit amet, lorem adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo.</p>
                                     
                                     <p>Tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                     
 									<strong>Author:</strong>  <a class="underLine"><em>Cleark</em></a>
									<div class="separator_mini"></div> 
                                    
								</div> 
							</div>
                                
                        </div>
                    </div>
                    
				</div>
                
                                            
                <!-- News 3 -->
                <div class="fmSliderNode"  >
                
                	<!-- News thumbnail -->
					<div class="projThumb_large slider_nav">
						<img  src="images/news/thumb3.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					<!-- News Name -->
                    <div class="newsName" >
                    	<h6><span class="title_uppercase">	News title text 3	</span><br/>	
							<span><strong>Date: </strong><em>07/08/2012</em></span>	
						</h6>
					</div>
                    <!-- News mini description -->
					<div class="miniDesc" ><h6><span>	<em>Small description about recent news</em>	</span></h6></div>
                    
                    <!-- News full details -->
                    <div class="fullDetails" style="clear:both; position:relative; overflow:hidden; width:100%">
						<div class="container" style=" margin: 0 auto; padding: 0 background-color:#9C3 "  >

							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
									<h2 class="title_light">News title 3 </h2>
									<strong>Date: </strong><em>17/09/2012</em>
                                                    
									<div class="separator_mini"></div> 
									
                                    <div class="large_image">
                                    	<a  class="lazyload scale-with-grid" href="images/news/image3.jpg" data-src-small="images/news/image3_s.jpg" title="Some text">image</a>
                                    </div>
                                        
									<div class="separator_mini"></div> 
                                
                                	<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                
                                	<blockquote>
                                        <p>Blockquote style example It stands out, but is awesome. Lorem ipsum dolor tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                        <cite>Dave Gamache, Skeleton Creator</cite>
                                    </blockquote>
                                    
                                    <p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat</p>
                                    
 									<strong>Author:</strong>  <a class="underLine"><em>Neam</em></a>
                                    
									<div class="separator_mini"></div> 
                                    
								</div> 
							</div>
                                
                        </div>
                    </div>
                    
				</div> 
                
                                     
                <!-- News 4 -->
                <div class="fmSliderNode"  >
                	<!-- News thumbnail -->
					<div class="projThumb_large slider_nav">
						<img  src="images/news/thumb4.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
					<!-- News Name -->
                    <div class="newsName" >
                    	<h6><span class="title_uppercase">	News title text 4	</span><br/>	
							<span><strong>Date: </strong><em>01/08/2012</em></span>	
						</h6>
					</div>
                    <!-- News mini description -->
					<div class="miniDesc" ><h6><span>	<em>Small description about recent news</em>	</span></h6></div>
                    
                    <!-- News full details -->
                    <div class="fullDetails" >
						<div class="container" >

							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
									<h2 class="title_light">News title 4 </h2>
									<strong>Date: </strong><em>17/09/2012</em>
                                                    
									<div class="separator_mini"></div> 
									
                                    <!-- News single image -->
                                    <div class="large_image">
                                    	<a  class="lazyload scale-with-grid" href="images/news/image4.jpg" data-src-small="images/news/image4_s.jpg" title="Some text">image</a>
                                    </div>
                                            
									<div class="separator_mini"></div> 
                                
                                	<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip.</p>
                                    
                                	<p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                    
									<strong>Author:</strong>  <a class="underLine"><em>Neam</em></a>
                                    
									<div class="separator_mini"></div> 
                                    
								</div> 
							</div>
                                
                        </div>
                    </div>
				</div>
                
                
                <!-- News 5 -->
                <div class="fmSliderNode"  >
                	<!-- News thumbnail -->
					<div class="projThumb_large slider_nav">
						<img  src="images/news/thumb5.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
                     <!-- News Name -->
                    <div class="newsName" >
                    	<h6><span class="title_uppercase">	News title text 5	</span><br/>	
							<span><strong>Date: </strong><em>12/07/2012</em></span>	
						</h6>
					</div>
                    <!-- News mini description -->
					<div class="miniDesc" ><h6><span>	<em>Small description about recent news</em>	</span></h6></div>
                    
                    <!-- News full details -->
                    <div class="fullDetails" >
						<div class="container" >

							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
									<h2 class="title_light">News title 5 </h2>
									<strong>Date: </strong><em>17/09/2012</em>
                                                    
									<div class="separator_mini"></div> 
									
                                     <!-- News single image -->
                                    <div class="large_image">
                                   		<a  class="lazyload scale-with-grid" href="images/news/image5.jpg" data-src-small="images/news/image5_s.jpg" title="Some text">image</a>
                                    </div>
                                          
									<div class="separator_mini"></div> 
                                
                                	<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                	
                                    <p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                	
                                    <p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
									
                                    <strong>Author:</strong>  <a class="underLine"><em>Neam</em></a>
                                    
									<div class="separator_mini"></div> 
                                    
								</div> 
							</div>
                                
                        </div>
                    </div>
                    
				</div>
                
                <!-- News 6 -->
                <div class="fmSliderNode"  >
                	<!-- News thumbnail -->
					<div class="projThumb_large slider_nav">
						<img  src="images/news/thumb3.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
                     <!-- News Name -->
                    <div class="newsName" >
                    	<h6><span class="title_uppercase">	News title text 6	</span><br/>	
							<span><strong>Date: </strong><em>17/09/2012</em></span>	
						</h6>
					</div>
                     <!-- News mini description -->
					<div class="miniDesc" ><h6><span>	<em>Small description about recent news</em>	</span></h6></div>
                    
                    <!-- News full details -->
                    <div class="fullDetails" >
						<div class="container" >

							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
									<h2 class="title_light">News title 6 </h2>
									<strong>Date: </strong><em>17/09/2012</em>
                                                    
									<div class="separator_mini"></div> 
                                    
                                    <!-- News single image -->
                                    <div class="large_image">
										<a  class="lazyload scale-with-grid" href="images/news/image3.jpg" data-src-small="images/news/image3_s.jpg" title="Some text">image</a>
                                    </div>
                                             
									<div class="separator_mini"></div> 
                                
                                	<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                    
									<strong>Author:</strong>  <a class="underLine"><em>Neam</em></a>
                                    
									<div class="separator_mini"></div> 
                                    
								</div> 
							</div>
                                
                        </div>
                    </div>
                    
				</div> 
                
                <!-- News 7 -->
                <div class="fmSliderNode"  >
                	<!-- News thumbnail -->
					<div class="projThumb_large slider_nav">
						<img  src="images/news/thumb2.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
                    <!-- News Name -->
					<div class="newsName" >
                    	<h6><span class="title_uppercase">	News title text 7	</span><br/>	
							<span><strong>Date: </strong><em>05/06/2012</em></span>	
						</h6>
					</div>
                    <!-- News mini description -->
					<div class="miniDesc" ><h6><span>	<em>Small description about recent news</em>	</span></h6></div>
                    
                     <!-- News full details -->
                    <div class="fullDetails" >
						<div class="container" >

							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
									<h2 class="title_light">News title 7 </h2>
									<strong>Date: </strong><em>17/09/2012</em>
                                                    
									<div class="separator_mini"></div> 
                                    
                                    <!-- News single image -->
                                    <div class="large_image">
										<a  class="lazyload scale-with-grid" href="images/news/image6.jpg" data-src-small="images/news/image6_s.jpg" title="Some text">image</a>
                                    </div>
                                        
									<div class="separator_mini"></div> 
                                
                                	<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                	<p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
									
                                    <strong>Author:</strong>  <a class="underLine"><em>Neam</em></a>
                                    
									<div class="separator_mini"></div> 
                                    
								</div> 
							</div>
                                
                        </div>
                    </div>
                    
				</div> 
                                
                <!-- News 8 -->
                <div class="fmSliderNode"  >
                	<!-- News thumbnail -->
					<div class="projThumb_large slider_nav">
						<img  src="images/news/thumb4.jpg" class="scale_fill" alt="Wonder" />
						<div class="overlay detail"></div>
					</div>
                     <!-- News Name -->
					<div class="newsName" >
                    	<h6><span class="title_uppercase">	News title text 8	</span><br/>	
							<span><strong>Date: </strong><em>25/05/2012</em></span>	
						</h6>
					</div>
                    <!-- News mini description -->
					<div class="miniDesc" ><h6><span>	<em>Small description about recent news</em>	</span></h6></div>
                    
                     <!-- News full details -->
                    <div class="fullDetails" >
						<div class="container" >

							<div class="fifteen columns alpha proPadLef" >
								<div class="mobile_spacing">
									<h2 class="title_light">News title 8 </h2>
									<strong>Date: </strong><em>17/09/2012</em>
                                                    
									<div class="separator_mini"></div> 
                                    
                                    <!-- News single image -->
                                    <div class="large_image">
										<a  class="lazyload scale-with-grid" href="images/news/image4.jpg" data-src-small="images/news/image4_s.jpg" title="Some text">image</a>
                                    </div>   
                                     
									<div class="separator_mini"></div> 
                                
                                	<p>Eorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                	
                                    <p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                	
                                    <p>nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                    
									<strong>Author:</strong>  <a class="underLine"><em>Neam</em></a>
                                    
									<div class="separator_mini"></div> 
                                    
								</div> 
							</div>
                                
                        </div>
                    </div>
                    
				</div>
               
           	<!-- End News items -->
                
			</div>
        </div>
    
    </div>
</div>

<!-- End News page -->




<!-- Blog page -->
                
<div class="page" data-id="!blog" >
     <div class="pgContent">
     
		
        <!-- If you need to show the blog content inside the scroll bar, just enable the below div. the Scroll bar will
        added automatically -->
        
        <!--
        <div class="separator_mini"></div> 
        <div class="scroll-pane full_size">
        -->

        
<!-- Three variation of blog post -->
  
		<div class="fifteen columns alpha" >
			<div class="mobile_spacing" >
				<h1 class="title_light">Latest from blog</h1>
                <h4 class="title_italic">3 variation blog post</h4>
				<hr>
			</div>
		</div>
        
        <hr> 
       
		<!-- Blog post variation one-->
        <div class="fifteen columns alpha" >
			<div class="mobile_spacing" >
            	<!-- Title text-->
            	<h3 class="title_uppercase title_light">
                	<a class="normal" href="blog.html" target="_self">Separate page for blog</a>
                </h3>
                <br> 
                <!-- Blog date -->
				<div class="blog_date alignLeft dark_color">
                        14<br>
                        Jul
				</div>
              	<!-- Blog post Author and data -->
				<a class=" list_hover "><span class="list7"> Aline marke</span></a>
                <a class=" list_hover"><span class="list8"> 70 comments</span></a>
                <a class=" list_hover"><span class="list10"> 45</span></a>
                <br>
                <!-- Social network link -->
                <ul class="social_bookmarks noMargin">
					<li class="twitter noMargin"><a title="twitter" >Follow us on Twitter</a></li>
 					<li class="facebook noMargin"><a title="Facebook" >Join our Facebook Group</a></li>
					<li class="gplus noMargin"><a title="Google Plus" >Join me on Google Plus</a></li>
					<li class="rss noMargin"><a title="RSS" >RSS</a></li>
					<li class="digg noMargin"><a title="Digg" >Digg</a></li>
				</ul>
			</div>
		</div>  
        <!-- Post content area -->
        <div class="offset-by-two eleven columns alpha"   >
			<div class="mobile_spacing" >
                
				<div class="post_image  border2 dark_border">
					<a  href="blog.html" target="_self">
                    	<img class="scale-with-grid" src="images/post_1.jpg" />
                        <div class="overlay link"></div>
                  	</a>
				</div>
                
				<br>
                
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer commodo tristique odio, Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                <p> Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum. vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi nam liber.</p>
                
				<a href="blog.html" target="_self" ><span class="alignLeft button">Continue reading</span></a>               
				<hr>
                
			</div>
		</div>
        

		<div class="separator_bar"></div> 
        
        
		<!-- Blog post variation Two -->
        
        <div class="fifteen columns" >
        	<!-- Title-->
        	<div class="fifteen columns alpha" >
				<div class="mobile_spacing" >
					<h3 class="title_uppercase title_light">
                		<a class="normal" href="blog.html" target="_self">Tincidunt ut laoreet dolore magna</a>
                	</h3>
                    <br>
				</div>
			</div>
        	
			<div class="five columns alpha" >
				<div class="mobile_spacing" >
                	<!-- Blog post image -->
                    <div class="medium_image img-align-left border2 dark_border">
                        <a class="single_image" title="Some text"  href="images/portfolio/image1.jpg" target="_self">
                        	<img class="scale-with-grid" src="images/post_2.jpg" />
                           	<div class="overlay zoom"></div>
                        </a>
                    </div>
                   <br>
                   <br>
                <!-- Blog date --> 
                <div class="blog_date alignLeft dark_color">
                    22<br>
                    May
                </div>
                <!-- Blog post Author and data -->
				<a class="list_hover"><span class="list7"> Aline marke</span></a>  <br >
                <a class="list_hover"><span class="list8"> 6 comments</span></a>  <br>
                <a class="list_hover"><span class="list10"> 50</span></a>
                
                <br class="clear">
                <!-- Social network link -->
                <ul class="social_bookmarks noMargin">
					<li class="twitter noMargin"><a title="twitter" >Follow us on Twitter</a></li>
 					<li class="facebook noMargin"><a title="Facebook" >Join our Facebook Group</a></li>
					<li class="gplus noMargin"><a title="Google Plus" >Join me on Google Plus</a></li>
					<li class="rss noMargin"><a title="RSS" >RSS</a></li>
					<li class="digg noMargin"><a title="Digg" >Digg</a></li>
				</ul>
                <div class="separator_mini"></div>
				</div>
			</div>
            
          	<!-- Post content area -->
			<div class="ten columns alpha" >
				<div class="mobile_spacing" >
					<p>We also provide consectetur adipiscing elit. Lorem ipsum dolor sit a m et, consectetuer adipiscing elit, sed diam nonummy nibh dolor sit a m et, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut. Lorem ipsum dolor sit a m et.</p>
                    <p>Consectetuer adipiscing elit, sed diam nonummy nibh dolor sit a m et, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut.</p> 
                    <p>volutpat consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut. Lorem ipsum dolor sit a m et consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut</p> 

                    <a href="blog.html" target="_self" ><span class="alignRight button">Continue reading</span></a>  
                                                    
				</div>
			</div>
		</div>
        
        <div class="separator_bar"></div> 
        
		<!-- Blog post variation Three -->
        <div class="three columns alpha">
			<div class="mobile_spacing" >
            	 <!-- Blog date --> 
             	<div class="blog_date alignLeft dark_color">
                	17<br>
                    Dec
				</div>
                <br class="clear">
               <!-- Blog post Author and data -->
				<a class="img-align-left list_hover" ><span class="list7" > Aline marke</span></a> <br >
				<a class="img-align-left list_hover"><span class="list8" > 276 comments</span></a> <br>
				<a class="img-align-left list_hover"><span class="list10"> 50</span></a>
                <br class="clear">
                <!-- Social network link -->
                <ul class="social_bookmarks noMargin">
					<li class="twitter noMargin"><a title="twitter" >Follow us on Twitter</a></li>
 					<li class="facebook noMargin"><a title="Facebook" >Join our Facebook Group</a></li>
					<li class="gplus noMargin"><a title="Google Plus" >Join me on Google Plus</a></li>
					<li class="rss noMargin"><a title="RSS" >RSS</a></li>
					<li class="digg noMargin"><a title="Digg" >Digg</a></li>
				</ul>
                <br class="clear">
            </div>
		</div>
        
        
		<div class="eleven columns alpha"   >
			<div class="mobile_spacing" >
            <!-- Title-->
            	<h3 class="title_uppercase title_light">
                	<a class="normal" href="blog.html" target="_self">Claritas est etiam processus dynamicus</a>
                </h3>
				<h5 class="title_italic">
                	<a class="normal" href="blog.html" target="_self">Possible to add title text</a>
                </h5>
                <hr>
                <!-- Blog post image --> 
				<div class="post_image  border2 dark_border">
					<a  href="blog.html" target="_self">
                    	<img class="scale-with-grid" src="images/post_3.jpg" />
                        <div class="overlay link"></div>
                  	</a>
				</div>
                
				<br>
                <!-- Post content area -->
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer commodo tristique odio, Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                <p> Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum. vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi nam liber.</p>
                
				<h6><a href="blog.html" target="_self" class="alignRight list_hover pad"> <strong>Continue reading</strong></a></h6>                
				<hr>
                 
			</div>
		</div> 
         
        <div class="separator_mini"></div>
           
       <!-- 
       </div>
       <div class="separator_mini"></div>
        -->
         
    
    </div>
</div>
              
                

                
<!-- Features page -->
                
<div class="page" data-id="!features" >
     <div class="pgContent">
     	
        <!--
        <div class="separator_mini"></div>
		<div class="scroll-pane full_size">
        ->
        
        <!-- Below content are placed inside the Scrollbar -->
         

         <div class="row" > <div class="bottom_spacing"></div> </div>
         
         <div class="one-third column alpha" >
			<div class="mobile_spacing" >
            	<!-- Tab Example-->
             	<h3 class="title_light">Tab</h3>
             	<br>
        		 <!-- Tab Navigation Begin -->       
                 <ul class="tabs">
                 	<!-- Set class name active to the required li tag-->
					<li><a class="active"  href="#tab1">Tab 1</a></li>
                    <li><a href="#tab2">Tab 2</a></li>
                    <li><a href="#tab3">Tab 3</a></li>
                 </ul>
                                            
                 <!-- Tab Content -->                      
                 <ul class="tabs-content">
					<!-- Set class name active to the corresponding li tag-->
                    <li id="tab1"  class="active" >
						<h5>Title text 1</h5>
                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo.</p>
                         <p>We also provide consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt. minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo.</p>
                    </li>
                        
					<li  id="tab2">
						<h5>Title 2</h5>
						<p>We also provide consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim.</p>
						<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo. </p>
					</li>
                        
					<li  id="tab3">
						<h5>Title 3</h5>
						<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo. </p>
					</li>
                        
				</ul>
        
        	</div>
        </div>
        
        
        <div class="five columns alpha" >
			<div class="mobile_spacing" >
            
            	
            	<h3 class="title_light">Accordion - Auto Hide</h3>
                <br>
                
                <!-- Start Accordion 
                The attribute data-autoHide is used to close the accordion tab automatically when the user select other tab,
                The attribute data-openFirstElement is used to open the first accordion tab when page load
                -->
       		 	<div class="accordion" data-autoHide="true" data-openFirstElement="true" >
                
                	<!-- Accordion tab -->
					<dt>
                    	<a href="" class="normal"><span class="acc_heading">
                    		<!-- Heading -->
                    		<h6><strong>Heading Text panel 1</strong></h6> 
                     	</span></a>
					</dt>
                    
                    	<dd>
                        	<span class="acc_content">
                        	<!-- Tab content -->
                            Lorem ipsum dolor sit a m et, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.<br> 
                            	set <em><span class="text_highlight">data-autoHide="true"</span></em> and <br> <em><span class="text_highlight">data-openFirstElement="true"</span></em> to the main accordion class div. 
                                Add any number of accordion on same page.
                            
                        	</span>
                        </dd>
                        
                        
                    <!-- Accordion tab -->
                    <dt>
                    	<a href="" class="normal"><span class="acc_heading">
                        	<!-- Heading -->
                    		<h6><strong>Heading Text panel 2</strong></h6> 
                        </span></a>
                    </dt>
						<dd>
                            <span class="acc_content">
                            <!-- Tab content -->
                            	Lorem ipsum dolor sit a m et, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. onec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis.
                            </span>
                        </dd>
                    
                    
                    <!-- Accordion tab -->
                    <dt>
                    	<a href="" class="normal"><span class="acc_heading">
                        	<!-- Heading -->
                    		<h6><strong>Lorem ipsum dolor sit amet 3</strong></h6> 
                        </span></a>
                    </dt>
                    	<dd>
                        	<span class="acc_content">
                            <!-- Tab content -->
                            	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer commodo tristique odio, Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus
							</span>
                        </dd>
                        
                </div>​​   
                <!-- End Accordion -->   

			</div> 
		</div> 

        
         <div class="five columns alpha" >
			<div class="mobile_spacing" >
            
            	<h3 class="title_light">Accordion - Toggle</h3>
                <br>
                 <!-- Start Accordion 
                The attribute data-autoHide is used to close the accordion tab automatically when the user select other tab,
                The attribute data-openFirstElement is used to open the first accordion tab when page load
                -->
       		 	<div class="accordion"  data-autoHide="false" data-openFirstElement="false" >
                
                	<!-- Accordion tab -->
                    <dt>
                    	<a href="" class="normal"><span class="acc_heading">
                        	<!-- Heading -->
                    		<h6><strong>Panel 1 heading text</strong></h6> 
                        </span></a>
                    </dt>
                    	<dd>
                        	<span class="acc_content">
                            	<!-- Tab content -->
                            	<p>Add any number of accordion on same page. Option to open the first tab and tab autohide by using data attribute</p>
                                 Just set <em><span class="text_highlight">data-autoHide="false"</span></em> and <br> <em><span class="text_highlight">data-openFirstElement="false"</span></em> to the main accordion class div.
                            </span>
                        </dd>
                        
                    <!-- Accordion tab -->
                    <dt>
                    	<a href="" class="normal"><span class="acc_heading">
                        	<!-- Heading -->
                    		<h6><strong>Panel 2 heading text</strong></h6> 
                        </span></a>
                    </dt>
                        <dd>
                            <span class="acc_content">
                            	<!-- Tab content -->
                            	onec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis.
                             </span>
                        </dd>
                        
                    <!-- Accordion tab -->
                    <dt>
                    	<a href="" class="normal"><span class="acc_heading">
                        	<!-- Heading -->
                    		<h6><strong>Panel 3 sample heading text</strong></h6> 
                        </span></a>
                    </dt>
                    	<dd>
                        	<span class="acc_content">
                            	<!-- Tab content -->
                            	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer commodo tristique odio, Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus
                            </span>
                        </dd>
                        
                </div>​​   
                <!-- End Accordion --> 
                   
            </div>
        </div>
                
        
        <div class="row"> <hr> </div>
		<div class="separator_bar"></div> 
		<div class="row"> <hr> </div>
        
         <!-- Video sample code-->
		<div class="fifteen columns alpha" >
			<div class="mobile_spacing" >
				<h3 class="title_light">VIDEO DEMO</h3>
				<hr>
			</div>
		</div>     
            
		<!-- Video 1 -->
		<div class="fifteen columns alpha" >
			<div class="mobile_spacing" >
            
				<h3 class="title_light">Youtube : Launch on June 2012</h3>
				<br> 
				<!-- Add video -->                         
				<div class="addVideo video_content" data-url="http://www.youtube.com/watch?v=_1NGnVLDPog" >
					<div class="video_hover"></div>
                        <img class="scale-with-grid" src="images/video_img1.jpg" />
				</div>
				<br class="clear"/>
				<hr> 
                                     
			</div>
		</div>                 
            
		<!-- Video 2 -->                    
		<div class="fifteen columns alpha" >
			<div class="mobile_spacing" >
				<h3>vimeo : Launch on May 2012</h3>
				<h6 class="title_uppercase title_italic">Video Title</h6>
				<br>  
				<!-- Add video -->
				<div class="addVideo video_content"  id="video" data-url="http://vimeo.com/35160025"> 
					<div class="video_hover"></div>
                        <img class="scale-with-grid" src="images/video_img1.jpg" />
				</div>  
                <br> 
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer commodo tristique odio, Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                <p> Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum. vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi nam liber.</p>
                
				<h6><a class="alignLeft list_hover pad"> <strong>Continue reading</strong></a></h6>            
			</div>
		</div>
		
        <div class="row"> <hr> </div>
		<div class="separator_bar"></div> 
		<div class="row"> <hr> </div>

<!-- Typography - Grid -->   
        <div class="fifteen columns" >
			<div class="mobile_spacing" >
       			<h3 class="title_light">Typography - Grid</h3>
                <div class="separator_mini"></div>
        	</div>
       </div>
       
       
<!-- four columns -->   
        <div class="fifteen columns" >
                
			<div class="four columns alpha" >
				<div class="mobile_spacing" >
					<h4>ONE FOURTH</h4>
					<p>We also provide constetur adiscing elit. Lorem ipsum dolor sit a m et, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
				</div>
			</div> 
                            
			<div class="four columns" >
				<div class="mobile_spacing" >
					<h4>ONE FOURTH</h4>
					<p>We also provide constetur adiscing elit. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
				</div>
			</div>
                        
			<div class="four columns alpha" >
				<div class="mobile_spacing" >
					<h4>ONE FOURTH</h4>
					<p>We also provide constetur adiscing elit. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
				</div>
			</div>
            <div class="three columns" >
				<div class="mobile_spacing" >
					<h4>ONE FOURTH</h4>
					<p>We also provide constetur adiscing elit. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut.</p>
				</div>
			</div>
            <hr> 
            
		</div>
             

<!-- Three columns -->                    
		<div class="fifteen columns" >
                
			<div class="five columns alpha" >
				<div class="mobile_spacing" >
					<h4>ONE THIRD</h4>
					<p>We also provide constetur adiscing elit. Lorem ipsum dolor sit a m et, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
				</div>
			</div> 
                            
			<div class="five columns" >
				<div class="mobile_spacing" >
					<h4>ONE THIRD</h4>
					<p>We also provide constetur adiscing elit. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
				</div>
			</div>
                        
			<div class="five columns alpha" >
				<div class="mobile_spacing" >
					<h4>ONE THIRD</h4>
					<p>We also provide constetur adiscing elit. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
				</div>
			</div>
            
            <hr> 
		</div>
            
            
 <!-- Two by one column --> 
            
		<div class="fifteen columns" >

			<div class="ten columns alpha" >
				<div class="mobile_spacing" >
					<h4>TWO THIRD</h4>
					<p>We also provide consectetur adipiscing elit. Lorem ipsum dolor sit a m et, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad constetur adiscing elit. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet.</p>
				</div>
			</div>
                        
            <div class="five columns alpha" >
                <div class="mobile_spacing" >
                    <h4>ONE THIRD</h4>
                    <p>We also provide consectetur adipiscing elit. Lor em ipsum dolor sit amet, consectetuer adipiscing elit, sed diam ut laoreet dolore magna aliquam erat volutpat.</p>
                </div>
            </div>           
			
            <hr> 
		</div>
            
            
<!-- one by Two column --> 		
        <div class="fifteen columns" >
        
			<div class="five columns alpha" >
				<div class="mobile_spacing" >
					<h4>ONE THIRD</h4>
					<p>We also provide consectetur adipiscing elit. Lor em ipsum dolor sit a m et, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet.</p>
				</div>
			</div>
                        
			<div class="ten columns alpha" >
				<div class="mobile_spacing" >
					<h4>TWO THIRD</h4>
					<p>We also provide consectetur adipiscing elit. Lor em ipsum dolor sit a m et, consectetuer adipiscing elit, sed diam nonummy nibh dolor sit a m et, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut.</p>                                    
				</div>
			</div>
			
            <hr> 
		</div>

            
 <!-- one by one column -->             
		<div class="fifteen columns" >
            
			<div class="seven columns alpha" >
				<div class="mobile_spacing" >
					<h4>ONE HALF</h4>
					<p>We also provide consectetur adipiscing elit. Lorem ipsum dolor sit a m et, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat consectetuer adipiscing elit, sed diam nonummy nibh ipsum.</p>
				</div>
			</div>
                        
			<div class="eight columns alpha " >
				<div class="mobile_spacing" >
					<h4>ONE HALF</h4>
					<p>We also provide consectetur adipiscing elit. Lorem ipsum dolor sit a m et, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat tincidunt ut laoreet dolore magna aliquam erat volutpat</p>
				</div>
			</div>                     
			
            <hr> 
		</div>
        
 <!-- single column -->    
        
        <div class="fifteen columns" >
			<div class="mobile_spacing" >
            	<h4>FULL WIDTH</h4>
            	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum. vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi nam liber.</p>
            </div>
        </div>  
            
		<div class="row"> <hr> </div>
		<div class="separator_bar"></div> 
		<div class="row"> <hr> </div>
        

		<div class="fifteen columns" >
                
            <!-- Heading Text -->
			<div class="five columns alpha">
                <div class="mobile_spacing" >
					<h1>Heading &lt;h1&gt;</h1>
					<h2>Heading &lt;h2&gt;</h2>
					<h3>Heading &lt;h3&gt;</h3>
					<h4>Heading &lt;h4&gt;</h4>
					<h5>Heading &lt;h5&gt;</h5>
            	    <h6>Heading &lt;h6&gt;</h6>          
					<hr>
				</div>
			</div>
            
            <!-- Heading Text Light -->  
            <div class="five columns alpha">
                <div class="mobile_spacing" >
					<h1 class="title_light">Heading light &lt;h1&gt;</h1>
					<h2 class="title_light">Heading light &lt;h2&gt;</h2>
					<h3 class="title_light">Heading light &lt;h3&gt;</h3>
					<h4 class="title_light">Heading light &lt;h4&gt;</h4>
					<h5 class="title_light">Heading light &lt;h5&gt;</h5>
					<h6 class="title_light">Heading light &lt;h6&gt;</h6>          
					<hr>
				</div>
			</div>
                
				<div class="five columns alpha">
                	<div class="mobile_spacing" >
                    	<!-- Blockquote -->
                        <blockquote>
                            <p>Blockquote style example It stands out, but is awesome. Lorem ipsum dolor</p>
                            <cite>Dave Gamache, Skeleton Creator</cite>
                        </blockquote>
                        
                        <!-- High light text -->
                        <p>Lorem ipsum <span class="text_highlight">highlight text</span> dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam.
                        <span class="text_highlight">highlight text</span> Ut wisi enim ad constetur adiscing elit. Lorem ipsum dolor sit amet
                        </p>
                	</div>       
				</div>
                
        </div>    

            
		<div class="row"> <hr> </div>
		<div class="separator_bar"></div> 
		<div class="row"> <hr> </div>
              
            
		<!-- Listed items -->
		<div class="six columns" >
			<div class="mobile_spacing" >
            	<h3 class="title_light">Listed items</h3>
                <br>
                
				<span class="list1">list1 item</span>
				<span class="list1">list1 item</span>
				<span class="list1">list1 item</span><br><br>
                
                <span class="list2">list2 item</span>
				<span class="list2">list2 item</span>
				<span class="list2">list2 item</span><br><br>
                
                <span class="list3">list3 item</span>
				<span class="list3">list3 item</span>
				<span class="list3">list3 item</span><br><br>
          
				<span class="list4">list4 item</span>
				<span class="list4">list4 item</span>
				<span class="list4">list4 item</span><br><br>
                
                <span class="list5">list5 item</span>
				<span class="list5">list5 item</span>
				<span class="list5">list5 item</span><br><br>
                
                <span class="list6">list6 item</span>
				<span class="list6">list6 item</span>
				<span class="list6">list6 item</span><br><br>
                                
				<span class="list7">list7 item</span>
				<span class="list7">list7 item</span>
				<span class="list7">list7 item</span><br><br>
                
                <span class="list8">list8 item</span>
				<span class="list8">list8 item</span>
				<span class="list8">list8 item</span><br><br>
                
                <span class="list9">list9 item</span>
				<span class="list9">list9 item</span>
				<span class="list9">list9 item</span><br><br>
                                    
				<span class="list10">list10 item</span>
				<span class="list10">list10 item</span>
				<span class="list10">list10 item</span>
				<hr> 
			</div>
		</div>  
        
        <div class="five columns alpha" >
			<div class="mobile_spacing" >
            	<!-- Button sample-->
					<h3 class="title_light">Buttons</h3>
                    <br>
					<a><span class="button small">Small Size</span></a>
                    <br>
					<a><span class="button">Normal Size</span></a>
                    <br>
					<a><span class="button medium">Medium Size</span></a>
                    <br>
					<a><span class="button large">Large Size</span></a>
                    <br>
                    <a class="normal" >Normal text link</a> 
                    <br><div  class="pad"></div>
                    <a class="text_hover alignLeft">Text link with background</a>
                    <div  class="clear pad"></div>
                    <a class="list_hover pad"> <strong>Simple button link</strong></a><br>
				<hr> 

            </div>
        </div>
        
		<div class="four columns alpha" >
			<div class="mobile_spacing" >
				<h3 class="title_light"> Social Icons set </h3>
                <br>
                <!-- Socialize icons-->
				<ul class="social_bookmarks noMargin">
					<li class="twitter noMargin"><a title="twitter" >Follow us on Twitter</a></li>
 					<li class="facebook noMargin"><a title="Facebook" >Join our Facebook Group</a></li>
					<li class="gplus noMargin"><a title="Google Plus" >Join me on Google Plus</a></li>
					<li class="linkedin noMargin"><a title="Linkedin" >Add me on Linkedin</a></li>
					<li class="rss noMargin"><a title="RSS" >RSS</a></li>
					<li class="digg noMargin"><a title="Digg" >Digg</a></li>
					<li class="delicious noMargin"><a ctitle="delicious" >delicious</a></li>
					<li class="youtube noMargin"><a title="youtube" >youtube</a></li>
					<li class="vimeo noMargin"><a title="vimeo" >vimeo</a></li>
					<li class="skype noMargin"><a title="skype" >skype</a></li>
					<li class="dribbble noMargin"><a title="dribbble" >dribbble</a></li>
					<li class="ichat noMargin"><a title="ichat" >ichat</a></li>
					<li class="deviantart noMargin"><a title="deviantart" >deviantart</a></li>
					<li class="stumbleupon noMargin"><a title="stumbleupon" >stumbleupon</a></li>
				</ul>
                <hr>
			</div> 
		</div> 
                       
		<br class="clear"/>
                   
       <!-- 
       </div> 
       <div class="separator_mini"></div>
        -->
 
 
    
    </div>
</div>

<!-- End Features page -->
                
                

                
<!-- Contact Us page -->
            
<div class="page" data-id="!contactus">
	<div class="pgContent">  
            <h3 class="title_light">Contact Us</h3>
                                    
            <div class="separator_mini"></div>
           
           <!-- First column -->   
            <div class="four columns  alpha">
                <div class="mobile_right_spacing">
                    <h4>Location</h4>             
                    <p>
                    0025 street name<br/>
                    los Angle, 23589, USA
                    <br/><br/>                      
                    Tel: 123.123.2586<br/>
                    Mob: +044-3658954869
                    <br/><br/>                    
                    Email: <a>admin@websitename.com</a> <br/>
                    </p>
                    <div class="separator_mini"></div>
                </div>
            </div>               
             
            <!-- Second column -->                     
            <div class="six columns  alpha">
                <h4>Get Direction</h4>
                <div id="mapWrapper" class="mobile_right_spacing">
                
				<iframe width="100%" height="190" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://maps.google.co.in/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Los+Angeles,+CA,+United+States&amp;aq=0&amp;oq=Los&amp;sll=51.483414,-0.082054&amp;sspn=0.092469,0.264187&amp;gl=in&amp;g=London+Borough+of+Southwark,+United+Kingdom&amp;ie=UTF8&amp;hq=&amp;hnear=Los+Angeles,+California,+United+States&amp;t=m&amp;ll=34.053228,-118.242931&amp;spn=0.021334,0.025749&amp;z=14&amp;output=embed"></iframe>
                    
                </div>                   
            </div>            
            
            <!-- Third column -->                          
            <div id="contact" class="five columns" >
                <div class="mobile_right_spacing">
                	<hr>                     
                    <form name="contact" method="post" >
                        <input type="text" value="Name" id="name" name="name"  
                        	onfocus="if(this.value == 'Name') {this.value = '';}"	
                            onblur="if (this.value == '') {this.value = 'Name';}" />
                        <input type="text" value="Email" id="email" name="email"  
                        	onfocus="if(this.value == 'Email') {this.value = '';}"  
                            onblur="if (this.value == '') {this.value = 'Email';}" />
                        <hr>                                 
                        <textarea cols="30" rows="5" id="comments" name="comments"	
                        	onfocus="if(this.value == 'Comments...') {this.value = '';}" 
                            onblur="if (this.value == '') {this.value = 'Comments...';}">Comments...</textarea>
                        <br/>                                
                        <button type="submit" id="email_submit"  class="button alignLeft">SEND</button>                                  
                        <div id="reply_message" class="email_loading" ></div>                            
                    </form>                             
                </div>
            </div> 
                          
	</div>
</div>

<!-- End Contact Us page -->

</div>

</body>
</html>