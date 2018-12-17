$(document).ready(function(){
    $('.hai').click(function(){
        $('.overlay',this).toggleClass('fullHeight');
		$('.glyphicon',this).toggleClass("glyphicon-chevron-up").toggleClass("glyphicon-chevron-down");
		 $(this).next('.showimage').show();
	
    })
})
