$( document ).ready(function() {
	
    $("body").on("change", "#typeQuestion", function(){
    	console.log($(this).val());
        if($(this).val() == "typeRadio"){
        	
        	$("#typeRadio").prependTo($("#accordion"));
        	$("#typeCheckbox").prependTo($("#disabled"));
        }else if($(this).val() == "typeCheckbox"){   
        	
        	$("#typeCheckbox").prependTo($("#accordion"));
        	$("#typeRadio").prependTo($("#disabled"));
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
   
   $(".rep-nb-radio").change(function(){
	   $('.rep-radio').remove();
	   
	   var nb = $(this).val();						
	   
	   for(var i = 0; i< nb; i++){
		   var nb_rep = i + 1;
		   var $html_radio = "<div class='rep-radio input-group col-6 mb-1 mt-1'>" + 
								"<div class='input-group-prepend'> " +
									"<span class='input-group-text'>"+ nb_rep +"</span>" +
								"</div>" +
								"<input type='text' class='form-control' name='rep-"+ nb_rep +"' required>" +
							"<div class='input-group-prepend'>" +
								"<div class='input-group-text'>" +
									"<input type='radio' value="+ nb_rep +" name='rep-valide-radio' required>" +
								"</div>" +
							"</div>" +
						"</div>"
		   
		   $('.container-rep-radio').append($html_radio);
	   }
   })
   
   $(".rep-nb-checkbox").change(function(){
	   $('.rep-checkbox').remove();
	   
	   var nb = $(this).val();						
	   
	   for(var i = 0; i< nb; i++){
		   var nb_rep = i + 1;
		   var $html_checkbox = "<div class='rep-checkbox input-group col-6 mb-1 mt-1'>" + 
								"<div class='input-group-prepend'> " +
									"<span class='input-group-text'>"+ nb_rep +"</span>" +
								"</div>" +
								"<input type='text' class='form-control' name='rep-"+ nb_rep +"' required>" +
							"<div class='input-group-prepend'>" +
								"<div class='input-group-text'>" +
									"<input type='checkbox' value="+ nb_rep +" name='rep-valide-"+ nb_rep +"'>" +
								"</div>" +
							"</div>" +
						"</div>"
		   
		   $('.container-rep-checkbox').append($html_checkbox);
	   }
   })

});

