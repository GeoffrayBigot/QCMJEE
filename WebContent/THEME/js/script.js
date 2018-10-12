$( document ).ready(function() {
    console.log( "ready!" );
    $("#typeQuestion").change(function(){
        if($(this).val() == "typeRadio") 
        {
             $("#typeRadio").collapse('toggle');
        }else if($(this).val() == "typeCheckbox")
		{
        	$("#typeCheckbox").collapse('toggle');
        }else if($(this).val() == "typeText")
		{
        	$("#typeText").collapse('toggle');
        }
    	
   })
   
    
    if($("#choixEpreuve").val() == "EA") 
    {
         $(".EA").removeClass('d-none');
         $(".EC").addClass('d-none');
         $(".T ").addClass('d-none');
    }    
   
   $("#choixEpreuve").change(function(){
    if($(this).val() == "EA") 
    {
         $(".EA").removeClass('d-none');
         $(".EC").addClass('d-none');
         $(".T ").addClass('d-none');
    }else if($(this).val() == "EC")
	{
    	 $(".EA").addClass('d-none');
         $(".EC").removeClass('d-none');
         $(".T ").addClass('d-none');
    }else if($(this).val() == "T ")
	{
    	 $(".EA").addClass('d-none');
         $(".EC").addClass('d-none');
         $(".T ").removeClass('d-none');
    }
   })

});

