//star
$(document).ready(function(){
    var stepW = 30;
    var description_0 = new Array("教练相关知识理解差，教学表达不清晰。","教练相关知识理解一般，教学表达不够清晰。","教练对相关知识清楚，教学表达相对清晰。","教练相关知识比较充分，教学比较清晰。","教练相关知识比较充分，教学比较清晰。");
    var description_1 = new Array("教练服务态度差，没有耐心。","教练服务态度偏差，不够有耐心。","教练服务态度一般，讲解相对清楚。","教练服务态度比较好，比较耐心。","教练服务态度很好，很有耐心。");
    var description_2 = new Array("教练教学不符合国家规范。","教练教学基本符合国家规范。","教练教学一般符合国家规范。","教练教学很符合国家规范。","教练教学很符合国家规范。");
    var score = new Array("1分","2分","3分","4分","5分");
    var stars_0 = $("#star_0 > li");
    var show_0 = $("#showb_0");
    var score_text_0 = $("#score_0");
    var descr_text_0 = $("#description_0");
    star_0(show_0,stars_0,description_0,score,stepW,score_text_0,descr_text_0);
    var stars_1 = $("#star_1 > li");
    var show_1 = $("#showb_1");
    var score_text_1 = $("#score_1");
    var descr_text_1 = $("#description_1");
    star_0(show_1,stars_1,description_1,score,stepW,score_text_1,descr_text_1);
    var stars_2 = $("#star_2 > li");
    var show_2 = $("#showb_2");
    var score_text_2 = $("#score_2");
    var descr_text_2 = $("#description_2");
    star_0(show_2,stars_2,description_2,score,stepW,score_text_2,descr_text_2);
});
function star_0(show,stars,description,score,stepW,score_text,descr_text){
	var descriptionTemp = "";
    var scoreTemp = "";
    show.css("width",0);
    stars.each(function(i){
        $(stars[i]).click(function(e){
            var n = i+1;
            show.css({"width":stepW*n});
            descriptionTemp = description[i];
            scoreTemp = score[i];
            $(this).find('a').blur();
            return stopDefault(e);
            return descriptionTemp;
            return scoreTemp;
        });
    });
    stars.each(function(i){
        $(stars[i]).hover(
            function(){
            	score_text.text(score[i]);
            	descr_text.text(description[i]);
            },
            function(){
                if(descriptionTemp != null){
                	score_text.text(scoreTemp);
                   descr_text.text(descriptionTemp);
                }
                	 
                else{
                	score_text.text(scoreTemp);
                	$(".description").text(" ");
                } 
                    
            }
        );
    });
}

function stopDefault(e){
    if(e && e.preventDefault)
           e.preventDefault();
    else
           window.event.returnValue = false;
    return false;
};
