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
    	console.log($(this).val());
   })
});