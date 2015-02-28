<div id="cb_mes" style="display:none;"><p></p><input type="button" value="Submit Anyway" class="cb_but cb_submit_anyway">&nbsp;&nbsp;<input type="button" value="OK" class="cb_but cb_close"></div>

<script>

var v_excl_weekend = "[@wek]";
v_excl_weekend  = v_weekend.toLowerCase();
var v_mes = "";

var v_apt = "[@calcfield:1]";
var v_wek = "[@calcfield:2]";

if (v_excl_weekend == "yes")
{
//if there is appointment in weekend
if(v_wek)
{
v_mes = v_mes + "Appointment exist in weekend.\n";
}
}
//if there are appointments in changed schedule
if(v_apt)
{
v_mes = v_mes + "Appointment exist".
}


if(v_mes)
{
	$("#cb_mes p").html(v_mes);
	$("#cb_mes").css("display","block");
}
else
{
	window.parent.autosubmit();
	
}


//Close popup
$('.cb_close').click(function(e){
                   e.preventDefault();
                   if(window.parent.jQuery.fancybox){
                                   window.parent.jQuery.fancybox.close();
                   }else{
                                  window.location.replace(document.referrer);
                   }
   });
   
 $('.cb_submit_anyway').click(function(e){
                   e.preventDefault();  
				   window.parent.autosubmit();
   });

</script>