jQuery(document).ready(function($) {
  jQuery('.message a').click(function(){
   jQuery('form').animate({height: "toggle", opacity: "toggle"}, "slow");
 });
});