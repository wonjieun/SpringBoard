<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	$("#btnWrite").click(function() {
		location.href="/board/write.do";
	});
	
	$("#btnSearch").click(function() {
		location.href="/board/list.do?search="+$("#search").val();
	});

	// 선택체크 삭제
	$("#btnDelete").click(function() {
		// 선택된 체크박스
		var $checkboxes
		 = $("input:checkbox[name='checkRow']:checked");
		
		//방법1
		// 체크된 대상들을 하나씩 꺼내서 문자열로 합치기
// 		var names = "";
// 		var len = $checkboxes.length;
// 		$checkboxes.each( function(idx) {
// 			names += $(this).val();
			
// 			if( len-1 != idx ) {
// 				names += ",";
// 			}
// 		});
// 		console.log(names);
	
		//방법2
		// 체크된 대상들을 map으로 만들고 map을 문자열로 만들기
		var map = $checkboxes.map(function() {
			return $(this).val();
		});
		var names = map.get().join(",");
		console.log("names : " + names);

// 		console.log( "map:" + map );	// 맵
// 		console.log( "map->array : " + map.get() );	// 맵->배열
// 		console.log( "array tostring : " + map.get().join(",") ); // toString
		
		// 전송 폼
		var $form = $("<form>")
			.attr("action", "/board/deleteList.do")
			.attr("method", "post")
			.append(
				$("<input>")
					.attr("type", "hidden")
					.attr("name", "names")
					.attr("value", names)
			);
		$(document.body).append($form);
		$form.submit();
	
	});
});

// 전체 체크/해제
function checkAll() {
	// checkbox들
	var $checkboxes=$("input:checkbox[name='checkRow']");

	// checkAll 체크상태 (true:전체선택, false:전체해제)
	var check_status = $("#checkAll").is(":checked");
	
	if( check_status ) {
		// 전체 체크박스를 checked로 바꾸기
		$checkboxes.each(function() {
			this.checked = true;	
		});
	} else {
		// 전체 체크박스를 checked 해제하기
		$checkboxes.each(function() {
			this.checked = false;	
		});
	}
}
</script>

<style type="text/css">
table, th {
	text-align: center;
}
</style>

</head>
<body>

<div class="container">

<h1 class="pull-left">게시판 리스트</h1>
<c:choose>
	<c:when test="${empty login }">
		<a href="/member/login.do"><button class="btn pull-right">로그인</button></a>
	</c:when>
	<c:otherwise>
		<div class="pull-right">
			<c:out value="${writernick }" />님 환영합니다
			<a href="/member/logout.do"><button class="btn btn-warning">로그아웃</button></a>
		</div>
	</c:otherwise>
</c:choose>

<div class="clearfix"></div>
<hr>
<span class="pull-right">total : ${paging.totalCount }</span>
<div class="clearfix"></div>
<table class="table table-striped table-hover">
<thead>
	<tr>
		<th>
			<input type="checkbox" id="checkAll"
			 onclick="checkAll();" />
		</th>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>조회수</th>
		<th>추천수</th>
		<th>작성일</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${list }" var="i">
	<tr>
		<td><input type="checkbox"
			name="checkRow" value="${i.boardno }" /></td>
		<td>${i.boardno }</td>
		<td><a href="/board/view.do?boardno=${i.boardno }">${i.title }</a></td>
		<td>${i.writer }</td>
		<td>${i.hit }</td>
		<td>${i.recommend }</td>
		<td>
			<fmt:formatDate value="${i.writtendate }"
				pattern="yy-MM-dd HH:mm:ss" />
		</td>
	</tr>
</c:forEach>
</tbody>
</table>

<button id="btnDelete"
	class="btn btn-warning pull-left">삭제</button>
	
<button id="btnWrite" class="btn pull-right">글쓰기</button>

<div class="form-inline text-center">
	<input class="form-control" type="text" id="search" />
	<button id="btnSearch" class="btn">검색</button>
</div> 

<div class="clearfix"></div>

<jsp:include page="/WEB-INF/views/util/paging.jsp" />
<%-- <jsp:include page="../util/paging.jsp" /> --%>

</div>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

</body>
</html>










