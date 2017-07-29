/* $(document).ready(function () {
    var aMenuOneLi = $("#accordion-291805 > .accordion-group");
    var aMenuTwo = $(".accordion-body");
    $("#accordion-291805 > .accordion-group > .accordion-heading").each(function (i) {
        $(this).click(function () {
            if ($(aMenuTwo[i]).css("display") == "block") {
                $(aMenuTwo[i]).slideUp(300);
                $(this).removeClass("accordion_menu_active")
            } else {
                for (var j = 0; j < aMenuTwo.length; j++) {
                    $(aMenuTwo[j]).slideUp(300);
                    $(this).removeClass("accordion_menu_active");
                }
                $(aMenuTwo[i]).slideDown(300);
                $(this).addClass("accordion_menu_active")
            }
        });
    });
}); */

$(function(){
	$(".accordion-toggle").bind("click", leftOneMenuClick);
	$(".accordion-inner").bind("click", leftTwoMenuClick);
	$(".header-menu").bind("click", headerMenuClick);
	$(".center-menu").bind("click", centerMenuClick);
	
});

function leftOneMenuClick(){
	$(".accordion-heading").removeClass("accordion_menu_active");
 	$(this).parent().addClass("accordion_menu_active");
};

function leftTwoMenuClick(){
	$(".accordion-inner").removeClass("accordion_inner_active");
 	$(this).addClass("accordion_inner_active");
};

function headerMenuClick(){
	$(".header-menu").removeClass("header-menu_active");
 	$(this).addClass("header-menu_active");
};

function centerMenuClick(){
	$(".center-menu").removeClass("center-menu_active");
 	$(this).addClass("center-menu_active");
};