

$(document).ready(function(){
	// 카테고리 탭 매뉴 js
    $('ul.category_tab li').click(function(){
        var category_id = $(this).attr('data-tab');

        $('ul.category_tab li').removeClass('current');
        $('.category_section').removeClass('current');

        $(this).addClass('current');
        $("#"+category_id).addClass('current');
    })
	
    showNo=0;
    slide = null; 

    //5초단위 컨트롤 로직
     pr_next = function(){
         if(showNo <$(".pr .ph").length-1){
             showNo ++;
         }else{
             showNo=0;
         }
         $(".pr .ph").fadeOut(500);
         $(".pr .ph:eq("+showNo+")").fadeIn(500);
         $(".header-PJ_title").fadeOut(500);
         $(".header-PJ_title:eq("+showNo+")").fadeIn(500);
         
         slide = setTimeout("pr_next()",5000);
     }
     
     
     //다음 뒤로 버튼 컨트롤러
     $(".pr .next").click(function(){
         clearTimeout(slide);
         pr_next();
     });
     $(".pr .prev").click(function(){
         clearTimeout(slide);
         if(showNo>0){
             showNo--;
         }else{
             showNo = $(".pr .ph").length-1;
         }
         $(".pr .ph").fadeOut(500);
         $(".pr .ph:eq("+showNo+")").fadeIn(500);
         $(".pr .control_box img").each(function(){
             $(this).attr("src", $(this).attr("src").replace("_on.png", ".png"));
         });
         $(".pr .control_box img:eq("+showNo+")").attr("src",$(".pr .control_box img:eq("+showNo+")").attr("src").replace(".png","_on.png"))
         slide = setTimeout("pr_next()", 5000);
     });
      // 운형 버튼 눌렀을때.
      $(".pr .control_box img").mouseover(function(){
         if (showNo!=$(".pr .control_box img").index($(this))){
             clearTimeout(slide)
             showNo=$(".pr .control_box img").index($(this))
             $(".pr .control_box img").each(function(){
                 $(this).attr("src",$(this).attr("src").replace("_on.png",".png"))
             });              
             $(".pr .ph").fadeOut(500)
             $(".pr .ph:eq("+showNo+")").fadeIn(500)
             $(".header-PJ_title").fadeOut(500);
         $(".header-PJ_title:eq("+showNo+")").fadeIn(500);
             $(".pr .control_box img:eq("+showNo+")").attr("src",$(".pr .control_box img:eq("+showNo+")").attr("src").replace(".png","_on.png"))
             slide=setTimeout("pr_next()",5000)
         }
     });
      

  	
	window.onload = pr_next;

   
});


