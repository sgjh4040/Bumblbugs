


$(function() {
   $("#cardPay").click(function() {

      if ($("input[name=card_no]").val() == "") {
         alert("카드 번호를 입력하세요")
         return false;
      }
      if ($("input[name=card_pwd]").val() == "") {
         alert("카드 비밀번호를 입력하세요")
         return false;
      }
      if ($("input[name=owner_birth]").val() == "") {
         alert("생년월일을 입력하세요")
         return false;
      }
      if ($("input[name=owner_ph]").val() == "") {
         alert("핸드폰 번호를 입력하세요")
         return false;
      }
      if ($(":text").val() != "") {
         document.cardPayform.action = "ZipcodeInsertPage.jsp";
         document.cardPayform.submit();
      }

   })
})
$(function() {
   $("#zipcodeInsert").click(function() {

      if ($("input[name=d_zipcode]").val() == "") {
         alert("우편 번호를 입력하세요")
         return;
      }
      if ($("input[name=d_detail_addr]").val() == "") {
         alert("상세주소를 입력하세요")
         return;
      }
      if ($("input[name=d_ph]").val() == "") {
         alert("배송지 휴대폰 번호를 입력하세요")
         return;
      }
      if ($("input[name=d_nm]").val() == "") {
         alert("수신자 성함을 입력하세요")
         return;
      }
      document.zipcodeInsertform.submit();

   })
})


$(function() {
	
	
	
	
	$(".reviewBtn").click(function() {

		if ($(".p1_1_input").val() == "") {
			alert("제목을  입력하세요")
			return false;
		}
		if ( ($(".p1_2_input").val() == "")&& ($("#tp_img").val() == "") ) {
			alert("프로젝트 이미지를 입력하세요")
			return false;
		}
		if ($(".p1_3_input").val() == "") {
			alert("요약을 입력하세요")
			return false;
		}
		if ($(".p1_4_input").val() == "") {
			alert("카테고리를 입력하세요")
			return false;
		}
		if ($(".p1_5_input").val() == "") {
			alert("프로젝트 주소를 입력하세요")
			return false;
		}
		if ($(".p1_6_input").val() == "") {
			alert("검색용 태그를 입력하세요")
			return false;
		}
		if (($(".p1_7_input").val() == "") && ($("#tp_profile_img").val() == "")) {
			alert("프로필 이미지를 입력하세요")
			return false;
		}
		if ($(".p1_8_input").val() == "") {
			alert("진행자 이름을 작성하세요")
			return false;
		}
		if ($(".p1_9_input").val() == "") {
			alert("진행자 소개를 입력하세요")
			return false;
		}
		if ($(".p1_10_input").val() == "") {
			alert("진행자 활동를 입력하세요")
			return false;
		}
		if ($(".p2_1_input").val() == "") {
			alert("목표금액을 입력하세요")
			return false;
		}
		if ($(".p2_1_input").val() == "") {
			alert("프로젝트 마감일을 입력하세요")
			return false;
		}
		if (($(".p3_1_input").val() == "") && ($("#tp_intro_img").val() == "")) {
			alert("프로젝트 소개 영상을 입력하세요")
			return false;
		}
		
		if ($(".p4_1_input").val() == "") {
			alert("이메일주소를 입력하세요")
			return false;
		}
		if ($(".p4_2_input").val() == "") {
			alert("휴대폰번호를 입력하세요")
			return false;
		}
		if ($(".p4_3_input").val() == "") {
			alert("거래은행을 입력하세요")
			return false;
		}
		if ($(".p4_4_input").val() == "") {
			alert("예금주명을 입력하세요")
			return false;
		}
		if ($(".p4_5_input").val() == "") {
			alert("카드번호를 입력하세요")
			return false;
		}
		if ($(":text").val() != "") {
			document.insertform.action = "adminCheck.jsp";
			document.insertform.submit();
		}

	})
})

$(function() {
	$(".p1_btn1").click(function() {
		var value1 = $(".p1_1_input").val();
		var value2 = $(".p1_1_input_2").val();
		$(".p1_1_output").html("제목 : " + value1 + " 소제목 :  " + value2);
		$(".p1_1_input").toggle();
		$(".p1_1_input_2").toggle();
		$(".p1_1_output").toggle();
		$(".p1_btn1").text("수정하기");
	})
})
$(function() {
	$(".p1_btn2").click(function() {
		var value = $(".p1_2_input").val();
		$(".p1_2_input").toggle();
		$(".p1_2_output").toggle();
		$(".p1_btn2").text("수정하기");
	})
})
$(function() {
	$(".p1_btn3").click(function() {
		var value = $(".p1_3_input").val();
		$(".p1_3_output").html(value);
		$(".p1_3_input").toggle();
		$(".p1_3_output").toggle();
		$(".p1_btn3").text("수정하기");
	})
})
$(function() {
	$(".p1_btn4").click(function() {
		var value = $(".p1_4_input").val();
		$(".p1_4_output").html(value);
		$(".p1_4_input").toggle();
		$(".p1_4_output").toggle();
		$(".p1_btn4").text("수정하기");
	})
})
$(function() {
	$(".p1_btn5").click(function() {
		var value = $(".p1_5_input").val();
		$(".p1_5_output").html(value);
		$(".p1_5_input").toggle();
		$(".p1_5_output").toggle();
		$(".p1_btn5").text("수정하기");
	})
})
$(function() {
	$(".p1_btn6").click(function() {
		var value = $(".p1_6_input").val();
		$(".p1_6_output").html(value);
		$(".p1_6_input").toggle();
		$(".p1_6_output").toggle();
		$(".p1_btn6").text("수정하기");
	})
})
$(function() {
	$(".p1_btn7").click(function() {
		var value = $(".p1_7_input").val();
		$(".p1_7_output").html(value);
		$(".p1_7_input").toggle();
		$(".p1_7_output").toggle();
		$(".p1_btn7").text("수정하기");
	})
})
$(function() {
	$(".p1_btn8").click(function() {
		var value = $(".p1_8_input").val();
		$(".p1_8_output").html(value);
		$(".p1_8_input").toggle();
		$(".p1_8_output").toggle();
		$(".p1_btn8").text("수정하기");
	})
})
$(function() {
	$(".p1_btn9").click(function() {
		var value = $(".p1_9_input").val();
		$(".p1_9_output").html(value);
		$(".p1_9_input").toggle();
		$(".p1_9_output").toggle();
		$(".p1_btn9").text("수정하기");
	})
})
$(function() {
	$(".p1_btn10").click(function() {
		var value = $(".p1_10_input").val();
		$(".p1_10_output").html(value);
		$(".p1_10_input").toggle();
		$(".p1_10_output").toggle();
		$(".p1_btn10").text("수정하기");
	})
})

//---------------------------------탭메뉴----------------------------------------------------//

$(document).ready(function() {

	$('ul.tabs li').click(function() {
		var tab_id = $(this).attr('data-tab');

		$('ul.tabs li').removeClass('current');
		$('.tab-content').removeClass('current');

		$(this).addClass('current');
		$("#" + tab_id).addClass('current');
	})
})

$(document).ready(function() {

	$('.next1').click(function() {
		var tab_id = $('ul.tabs li.tab-link1').attr('data-tab');

		$('ul.tabs li.tab-link1').removeClass('current');
		$('.tc1').removeClass('current');

		$("ul.tabs li.tab-link2" + tab_id).addClass('current');
		$('.tc2').addClass('current');

		$('.tap-link2').css("backgroundColor", "#ededed");
		$('.tap-link1').css("backgroundColor", "#f6f5f5");
	})
})

$(document).ready(function() {

	$('.back2').click(function() {
		var tab_id = $('ul.tabs li.tab-link2').attr('data-tab');

		$('ul.tabs li.tab-link2').removeClass('current');
		$('.tc2').removeClass('current');

		$("ul.tabs li.tab-link1" + tab_id).addClass('current');
		$('.tc1').addClass('current');

		$('.tap-link1').css("backgroundColor", "#ededed");
		$('.tap-link2').css("backgroundColor", "#f6f5f5");
	})
})

$(document).ready(function() {

	$('.next2').click(function() {
		var tab_id = $('ul.tabs li.tab-link2').attr('data-tab');

		$('ul.tabs li.tab-link2').removeClass('current');
		$('.tc2').removeClass('current');

		$("ul.tabs li.tab-link3" + tab_id).addClass('current');
		$('.tc3').addClass('current');

		$('.tap-link3').css("backgroundColor", "#ededed");
		$('.tap-link2').css("backgroundColor", "#f6f5f5");
	})
})

$(document).ready(function() {

	$('.back3').click(function() {
		var tab_id = $('ul.tabs li.tab-link3').attr('data-tab');

		$('ul.tabs li.tab-link3').removeClass('current');
		$('.tc3').removeClass('current');

		$("ul.tabs li.tab-link2" + tab_id).addClass('current');
		$('.tc2').addClass('current');

		$('.tap-link2').css("backgroundColor", "#ededed");
		$('.tap-link3').css("backgroundColor", "#f6f5f5");
	})
})

$(document).ready(function() {

	$('.next3').click(function() {
		var tab_id = $('ul.tabs li.tab-link3').attr('data-tab');

		$('ul.tabs li.tab-link3').removeClass('current');
		$('.tc3').removeClass('current');

		$("ul.tabs li.tab-link4" + tab_id).addClass('current');
		$('.tc4').addClass('current');

		$('.tap-link4').css("backgroundColor", "#ededed");
		$('.tap-link3').css("backgroundColor", "#f6f5f5");
	})
})

$(document).ready(function() {

	$('.back4').click(function() {
		var tab_id = $('ul.tabs li.tab-link4').attr('data-tab');

		$('ul.tabs li.tab-link4').removeClass('current');
		$('.tc4').removeClass('current');

		$("ul.tabs li.tab-link3" + tab_id).addClass('current');
		$('.tc3').addClass('current');

		$('.tap-link3').css("backgroundColor", "#ededed");
		$('.tap-link4').css("backgroundColor", "#f6f5f5");
	})
})

//-----------------------------------------------------------------------//
$(function() {
	$(".p2_btn1").click(function() {
		var value = $(".p2_1_input").val();
		$(".p2_1_output").html(value + "원");
		$(".p2_1_input").toggle();
		$(".p2_1_output").toggle();
		$(".p2_btn1").text("수정하기");
	})
})

//-------------------------날짜----------------------------------//
$(function() {
	$(".p2_btn2").click(function() {
		var value = $(".p2_2_input").val();
		$(".p2_2_output").html(value);
		$(".p2_2_input").toggle();
		$(".p2_2_output").toggle();
		$(".p2_btn2").text("수정하기");

		date = new Date(value);
		var date1 = date.setDate(date.getDate() + 7);
		var date1_1 = date.setMonth(date.getMonth() + 1);

		date2 = new Date(date1);
		date3 = new Date(date1_1);
		lastdate1 = date2.getFullYear().toString();
		lastdate2 = date3.getMonth().toString();
		lastdate3 = date2.getDate().toString();

		$(".date2").html(lastdate1 + "/0" + lastdate2 + "/" + lastdate3);
		$(".date2").toggle();
		$(".date1").toggle();
	})
})

$(function() {
	$(".p2_btn4").click(function() {
		var value = $(".p2_4_input").val();
		$(".p2_4_output").html(value);
		$(".p2_4_input").toggle();
		$(".p2_4_output").toggle();
		$(".p2_btn4").text("수정하기");

	})
})

//---------------------------------------------------------------//

$(function() {
	$(".p2_btn3").click(
			function() {

				var value1 = $(".p2_3_input1").val();
				var value2 = $(".p2_3_input2").val();
				var value3 = $(".p2_3_input3").val();
				var value4 = $(".p2_3_input4").val();
				var value5 = $(".p2_3_input5").val();
				var value6 = $(".p2_3_input6").val();
				var value7 = $(".p2_3_input7").val();
				var value8 = $(".p2_3_input8").val();
				var value9 = $(".p2_3_input9").val();
				var value10 = $(".p2_3_input10").val();
				var value11 = $(".p2_3_input11").val();
				var value12 = $(".p2_3_input12").val();
				var value13 = $(".p2_3_input13").val();
				var value14 = $(".p2_3_input14").val();
				var value15 = $(".p2_3_input15").val();

				if (value1 == "") {
					alert("빈칸입력")
					return;
				} else if (value2 == "") {
					alert("빈칸입력")
				} else if (value3 == "") {
					alert("빈칸입력")
				} else if (value4 == "") {
					alert("빈칸입력")
				} else if (value5 == "") {
					alert("빈칸입력")
				} else {
					$(".p2_3_output").html(
							"선물 이름 : " + value1 + ", 최소 금액 : " + value2
									+ ", 옵션 : " + value3 + ", 수량 : " + value4
									+ ", 배송예정날짜 : " + value5 + "<br>"
									+ "선물 이름 : " + value6 + ", 최소 금액 : "
									+ value7 + ", 옵션 : " + value8 + ", 수량 : "
									+ value9 + ", 배송예정날짜 : " + value10 + "<br>"
									+ "선물 이름 : " + value11 + ", 최소 금액 : "
									+ value12 + ", 옵션 : " + value13 + ", 수량 : "
									+ value14 + ", 배송예정날짜 : " + value15
									+ "<br>");
					$(".p2_3_input1").toggle();
					$(".p2_3_input2").toggle();
					$(".p2_3_input3").toggle();
					$(".p2_3_input4").toggle();
					$(".p2_3_input5").toggle();
					$(".p2_3_input6").toggle();
					$(".p2_3_input7").toggle();
					$(".p2_3_input8").toggle();
					$(".p2_3_input9").toggle();
					$(".p2_3_input10").toggle();
					$(".p2_3_input11").toggle();
					$(".p2_3_input12").toggle();
					$(".p2_3_input13").toggle();
					$(".p2_3_input14").toggle();
					$(".p2_3_input15").toggle();
					$("b").toggle();
					$(".p2_3_output").toggle();
					$("#presentAll").toggle();
					$(".p2_btn3").text("수정하기");
					$(".btnAdd").toggle();
					$(".btnRemove").toggle();
				}
			})
})
//---------------------------------------------------------------------------//
$(function() {
	$(".p3_btn1").click(function() {
		var value = $(".p3_1_input1").val();
		$(".p3_1_output").html(value);
		$(".p3_1_input").toggle();
		$(".p3_1_output").toggle();
		$(".p3_btn1").text("수정하기");
	})
})

$(function() {
	$(".p3_btn2").click(function() {
		var value = $(".p3_2_input").val();
		$(".p3_2_output").html(value);
		$(".p3_2_input").toggle();
		$(".p3_2_output").toggle();
		$(".p3_btn2").text("수정하기");
	})
})

$(function() {
	$(".p4_btn1").click(function() {
		var value = $(".p4_1_input").val();
		$(".p4_1_output").html(value);
		$(".p4_1_input").toggle();
		$(".p4_1_output").toggle();
		$(".p4_btn1").text("수정하기");
	})
})

$(function() {
	$(".p4_btn2").click(function() {
		var value = $(".p4_2_input").val();
		$(".p4_2_output").html(value);
		$(".p4_2_input").toggle();
		$(".p4_2_output").toggle();
		$(".p4_btn2").text("수정하기");
	})
})

$(function() {
	$(".p4_btn3").click(function() {
		var value = $(".p4_3_input").val();
		$(".p4_3_output").html(value);
		$(".p4_3_input").toggle();
		$(".p4_3_output").toggle();
		$(".p4_btn3").text("수정하기");
	})
})

$(function() {
	$(".p4_btn4").click(function() {
		var value = $(".p4_4_input").val();
		$(".p4_4_output").html(value);
		$(".p4_4_input").toggle();
		$(".p4_4_output").toggle();
		$(".p4_btn4").text("수정하기");
	})
})

$(function() {
	$(".p4_btn5").click(function() {
		var value = $(".p4_5_input").val();
		$(".p4_5_output").html(value);
		$(".p4_5_input").toggle();
		$(".p4_5_output").toggle();
		$(".p4_btn5").text("수정하기");
	})
})

$(function() {
	$(".p4_btn6").click(function() {
		var value = $(".p4_6_input").val();
		$(".p4_6_output").html(value);
		$(".p4_6_input").toggle();
		$(".p4_6_output").toggle();
		$(".p4_btn6").text("수정하기");
	})
})

$(document).ready(function() {
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#blah').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	$("#imgInp").change(function() {
		readURL(this);
	});
	function readURL1(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#blah1').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	$("#imgInp1").change(function() {
		readURL1(this);
	});
	function readURL2(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.readAsDataURL(input.files[0]);
			reader.onload = function(e) {
				$('#blah2').attr('src', e.target.result);
				$('#video1').load();
			}
			
			
			
			
		}
		
	}
	
	$("#imgInp2").change(function() {
		readURL2(this);
	});
	
});

//--------오늘 날짜 출력-----//
function autoDate() {
	var tDay = new Date();
	var tMonth = tDay.getMonth() + 1;
	var tDate = tDay.getDate();
	if (tMonth < 10)
		tMonth = "0" + tMonth;
	if (tDate < 10)
		tDate = "0" + tDate;
	document.getElementById("tDate").value = tDay.getFullYear() + "-" + tMonth
			+ "-" + tDate;
}


