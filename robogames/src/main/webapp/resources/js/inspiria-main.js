var config = {
	paths: {
		'jquery': '/js/jquery-2.1.1',
		'bootstrap': '/js/bootstrap.min',
		'metisMenu': '/js/plugins/metisMenu/jquery.metisMenu',
		'slimscroll':'/js/plugins/slimscroll/jquery.slimscroll.min',
		'flot': '/js/plugins/flot/jquery.flot',
		'flot-tooltip': '/js/plugins/flot/jquery.flot.tooltip.min',
		'flot-spline': '/js/plugins/flot/jquery.flot.spline',
		'flot-resize': "/js/plugins/flot/jquery.flot.resize",
                'flot-pie': "/js/plugins/flot/jquery.flot.pie",
                'jquery.peity': "/js/plugins/peity/jquery.peity.min",
                'jquery.steps': "/js/plugins/staps/jquery.steps.min",
                'peity': "/js/demo/peity-demo",
                'pace':"/js/plugins/pace/pace.min",
                'jquery-ui': "/js/plugins/jquery-ui/jquery-ui.min",
                'jquery-gritter': "/js/plugins/gritter/jquery.gritter.min",
                'jquery-sparkline': "/js/plugins/sparkline/jquery.sparkline.min",
                'sparkline': "/js/demo/sparkline-demo",
                'chart': "/js/plugins/chartJs/Chart.min",
		'toastr': "/js/plugins/toastr/toastr.min",
		'datatables': "/js/plugins/dataTables/jquery.dataTables",
		'datatables-bootstrap': "/js/plugins/dataTables/dataTables.bootstrap",
		'datatables-responsive': "/js/plugins/dataTables/dataTables.responsive",
		'inspinia':'/js/inspinia',
        'chosen': '/js/plugins/chosen/chosen.jquery',
        'jeditable': '/js/plugins/jeditable/jquery.jeditable'
	},
	shim: {
		'bootstrap': {
			'deps': [ 'jquery' ]
		},
		'metisMenu': {
			'deps': [ 'jquery' ]
		},
		'flot': {
			'deps': ['jquery' ]
		},
		'flot-tooltip': {
			'deps': ['flot']
		},
		'flot-resize': {
			'deps': [ 'flot' ]
		},
		'flot-spline': {
			'deps': [ 'flot' ]
		},
		'flot-pie': {
			'deps': ['flot']
		},
		'jquery.peity': { 
			'deps': ['jquery']
		},
		'peity': {
			'deps': [ 'jquery.peity' ]
		},
		'jquery-ui': {
			'deps': [ 'jquery' ]
		},
		'jquery-gritter' : {
			'deps': ['jquery' ]
		},
		'jquery-sparkline': {
			'deps': [ 'jquery' ]
		},
		'sparkline': {
			'deps': ['jquery-sparkline' ]
		}
	}
};

define([],  function () {
console.log('WST');
    require.config(config);
    return function() {
        require(['jquery','bootstrap','metisMenu'], function () {
console.log('WST 2');
            
            // MetsiMenu
            $('#side-menu').metisMenu();

            // Collapse ibox function
            $('.collapse-link').click( function() {
                var ibox = $(this).closest('div.ibox');
                var button = $(this).find('i');
                var content = ibox.find('div.ibox-content');
                content.slideToggle(200);
                button.toggleClass('fa-chevron-up').toggleClass('fa-chevron-down');
                ibox.toggleClass('').toggleClass('border-bottom');
                setTimeout(function () {
                    ibox.resize();
                    ibox.find('[id^=map-]').resize();
                }, 50);
            });

            // Close ibox function
            $('.close-link').click( function() {
                var content = $(this).closest('div.ibox');
                content.remove();
            });

            // Small todo handler
            $('.check-link').click( function(){
                var button = $(this).find('i');
                var label = $(this).next('span');
                button.toggleClass('fa-check-square').toggleClass('fa-square-o');
                label.toggleClass('todo-completed');
                return false;
            });
            
            $('.navbar-minimalize').click(function () {
                $("body").toggleClass("mini-navbar");
                SmoothlyMenu();
            });
            
            // Minimalize menu when screen is less than 768px
            $(function() {
                $(window).bind("load resize", function() {
                    if ($(this).width() < 769) {
                        $('body').addClass('body-small');
                    } else {
                        $('body').removeClass('body-small');
                    }
                });
            });
            
            fix_height();

        });
    };
});

// Full height of sidebar
function fix_height() {
    var heightWithoutNavbar = $("body > #wrapper").height() - 61;
    $(".sidebard-panel").css("min-height", heightWithoutNavbar + "px");
}
    
function SmoothlyMenu() {
    if (!$('body').hasClass('mini-navbar') || $('body').hasClass('body-small')) {
        // Hide menu in order to smoothly turn on when maximize menu
        $('#side-menu').hide();
        // For smoothly turn on menu
        setTimeout(
            function () {
                $('#side-menu').fadeIn(500);
            }, 100);
    } else if ($('body').hasClass('fixed-sidebar')){
        $('#side-menu').hide();
        setTimeout(
            function () {
                $('#side-menu').fadeIn(500);
            }, 300);
    } else {
        // Remove all inline style from jquery fadeIn function to reset menu state
        $('#side-menu').removeAttr('style');
    }
}
// Dragable panels
function WinMove() {
    var element = "[class*=col]";
    var handle = ".ibox-title";
    var connect = "[class*=col]";
    $(element).sortable(
        {
            handle: handle,
            connectWith: connect,
            tolerance: 'pointer',
            forcePlaceholderSize: true,
            opacity: 0.8,
        })
        .disableSelection();
};
