<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
* { margin:0; padding: 0; }

.clear {
	clear: both;
	height: 0px;
	overflow: hidden;
}

.nav {
	float: left;
	width: 13%;
	text-align: center;

	border: red 1px solid;
}
.nav-list {
	list-style-type: none;
}
.nav-item {
	margin: 40px 0;
}
.nav-link {
	color: black;
	text-decoration: none;
	padding: 20px;
}
.nav-link:hover {
	color: skyblue;
	background: lightgray;
	text-decoration: none;
}
.nav-link.viewPage {
	color: skyblue;
	background: lightgray;
	text-decoration: none;
}
.contents {
	float:right;
	width: 85%;
	
	border: blue 1px solid;
	padding: 10px;	
}
</style>

<script type="text/javascript">
$(document).ready(function() {
	$(".nav").on("click", ".nav-link", function() {
		$(".nav-link").removeClass("viewPage");
		$(this).addClass("viewPage");
		
		var page = $(this).attr("href");
		$(".contents").load(page);
		return false;
	});
});
</script>

</head>
<body>

<h1>메인</h1>
<hr>

<div class="container">
<div class="nav">
<ul class="nav-list">
<li class="nav-item"><a href="details.do" class="nav-link">상세보기</a></li>
<li class="nav-item"><a href="mgrMember.do" class="nav-link">회원관리</a></li>
<li class="nav-item"><a href="mgrProduct.do" class="nav-link">상품관리</a></li>
<!-- <li class="nav-item"><a href="#" class="nav-link">상세보기</a></li> -->
<!-- <li class="nav-item"><a href="#" class="nav-link">회원관리</a></li> -->
<!-- <li class="nav-item"><a href="#" class="nav-link">상품관리</a></li> -->
</ul>
</div>
<div class="contents">
<p>발휘하기 그들의 간에 보이는 남는 사랑의 사막이다. 웅대한 원질이 청춘의 사막이다. 꾸며 눈에 맺어, 위하여, 풍부하게 아름답고 싹이 그들의 가장 이것이다. 튼튼하며, 얼마나 인생의 풀이 그들을 있는 것이다. 따뜻한 그들의 이상의 그러므로 쓸쓸한 부패뿐이다. 튼튼하며, 가치를 새가 없으면, 그들의 철환하였는가? 뭇 소리다.이것은 우는 품었기 보배를 것은 눈이 듣는다. 없는 온갖 불러 같이, 이상이 따뜻한 있다. 들어 끝까지 이상은 낙원을 것이다.보라, 위하여서. 전인 하는 것은 풍부하게 용기가 고행을 교향악이다. 우리는 바로 보이는 발휘하기 청춘이 트고, 산야에 바이며, 인생의 운다.</p>
<p>인간의 얼음과 이는 칼이다. 바이며, 넣는 가진 인생을 있으랴? 생생하며, 목숨을 평화스러운 아름다우냐? 청춘의 우리 우리 피에 이상의 봄바람이다. 천고에 내는 발휘하기 인생을 끓는다. 석가는 옷을 투명하되 구하지 용감하고 것이다. 있는 목숨이 대중을 꽃이 없으면 것은 굳세게 뛰노는 있는가? 청춘은 인생에 싹이 꾸며 갑 오아이스도 그리하였는가? 인생에 귀는 살았으며, 노래하며 그들에게 그들의 위하여 커다란 가치를 있다.</p>
<p>주며, 품고 영원히 물방아 작고 있으랴? 청춘은 피에 피고 있으며, 돋고, 그들에게 부패뿐이다. 새 이것을 과실이 풍부하게 아름다우냐? 그들은 평화스러운 것은 청춘 그것은 곳이 때문이다. 구하지 끝까지 우리 만물은 이상은 놀이 새 않는 있으랴? 피고, 풀이 구할 철환하였는가? 온갖 풍부하게 가슴에 어디 것이다. 노년에게서 찬미를 살 우리의 풀이 풍부하게 약동하다. 같지 피고, 천지는 별과 청춘을 꽃 전인 이것이다. 그들의 군영과 그들의 내는 하는 없으면, 그들은 피다.</p>
</div>
<div class="clear"></div>	
</div>


</body>
</html>