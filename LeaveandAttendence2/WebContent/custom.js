$(function() {
	
	// show/hide login panel by clicking on .login_button
	$('.login_button').click(function() {
		$('.login_panel').toggleClass('hidden');
	});
	
	// hide login panel by clicking on .close_button
	$('.close_login').click(function() {
		$('.login_panel').addClass('hidden');
	});
	
	// prevent default clicking event within the login panel
	$('.login_panel').click(function(event) {
		event.preventDefault();
	});
	
	//show dropdown when the mouse is moved over the list element that contains the sub_panel	
	var cus_dropdown_sel = $('ul#gen_navigation li').find('.sub_panel').parent();
	
	var panWidth = 0;
  
	$(cus_dropdown_sel).hover(function(){
		
		panWidth = $(this).width() + 40; 
		$('.sub_panel').css('width', panWidth); //cross-browser control for the width of the sub_panel	
        $(this).addClass('dropdown_hover'); // add the 'dropdown_hover' class to make visible the list item of the navigation menu
        $(this).find('.sub_panel').stop(true, true).fadeTo(200, 1); // show the panel
    
    }, function(){
    
        $(this).removeClass('dropdown_hover'); // remove 'dropdown_hover' class
        $(this).find('.sub_panel').hide(); // hide the panel
		panWidth = 0; // reset width
    
    });

});