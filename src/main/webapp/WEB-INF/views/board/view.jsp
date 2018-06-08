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
	
	// 추천버튼 초기화
	if(${recommend == true}) {
		// class = "btn pull-right btn-danger"
		$("#btnRecommend")
			.toggleClass("btn-danger")
			.text("추천 취소");
	} else {
		// class = "btn pull-right btn-primary"
		$("#btnRecommend")
			.toggleClass("btn-primary")
			.text("추천");
	}
	
	// 추천 수행
	$("#btnRecommend").click(function() {
		
		$.ajax({
			type: "get"
			, url: "/board/recommend.do"
			, dataType: "json"
			, data: {
				writerid: '${sessionScope.writerid }'
				, boardno: '${board.boardno }'
			}
			, success: function(data) {
				console.log(data);
				if(data.result) {
					$("#btnRecommend")
						.text("추천 취소")
						.toggleClass("btn-primary")
						.toggleClass("btn-danger");
				} else {
					$("#btnRecommend")
						.text("추천")
						.toggleClass("btn-danger")
						.toggleClass("btn-primary");
				}
				$("#recommend").text(data.recommend);
			}
			, error: function(e) {
				console.log(e.responseText);
			}
		});
	});	
	
	// 댓글 입력
	$("#btnCommInsert").click(function() {
		// 게시글 번호.... ${board.boardno }
// 		console.log($("#commentWriter").val());
// 		console.log($("#commentContent").val());
		
		$form = $("<form>").attr({
			action: "/board/insertComment.do",
			method: "post"
		}).append(
			$("<input>").attr({
				type:"hidden",
				name:"boardNo",
				value:"${board.boardno }"
			})
		).append(
			$("<input>").attr({
				type:"hidden",
				name:"userid",
				value:"${sessionScope.writerid }"
			})
		).append(
			$("<input>").attr({
				type:"hidden",
				name:"commentWriter",
				value:$("#commentWriter").val()
			})
		).append(
			$("<textarea>")
				.attr("name", "content")
				.css("display", "none")
				.text($("#commentContent").val())
		);
		$(document.body).append($form);
		$form.submit();
	});
});

// 댓글 삭제 버튼이 눌릴 때 실행
function deleteComment(commentNo) {
	$.ajax({
		type: "post"
		, url: "/board/deleteComment.do"
		, dataType: "json"
		, data: {
			commentNo: commentNo
		}
		, success: function(data){
			
			if(data.success) {
				// tr 자체가 삭제
				$("[data-commentno='"+commentNo+"']").remove();
// 				$("[data-commentno='"+commentNo+"']").html("삭제된 댓글입니다.");
			} else {
				alert("댓글 삭제 실패");
			}
		}
		, error: function() {
			console.log("error");
		}
	});
}
</script>

</head>
<body>

<div class="container">
<div>
<h1 class="pull-left">게시글 상세보기</h1>
<button id="btnRecommend" class="btn pull-right">추천</button>
</div>
<div class="clearfix"></div>
<hr>

<!-- 상세보기 영역 -->
<div>
글번호 : ${view.boardno }<br>
글제목 : ${view.title }<br>
아이디 : ${view.writerid }<br>
이름 : ${view.writer }<br>
본문 : ${k.content }<br>
조회수 : ${view.hit }<br>
추천수 : <span id="recommend">${view.recommend }</span><br>
작성일 : <fmt:formatDate value="${view.writtendate }"
				pattern="yy-MM-dd HH:mm:ss" /><br>
</div>	<!-- 상세보기 영역 end -->

<!-- 버튼 영역 -->
<div class="text-center">
	<a href="/board/list.do"><button>목록</button></a>
	<c:if test="${writerid eq view.writerid }">
		<a href="/board/update.do?boardno=${view.boardno }"><button>수정</button></a>
		<a href="/board/delete.do?boardno=${view.boardno }"><button>삭제</button></a>
	</c:if>
</div>	<!-- 버튼 영역 end -->

<!-- 댓글 처리 -->
<div>

<hr>
<!-- 댓글 입력 -->
<div class="form-inline text-center">
	<input type="text" size="7" class="form-control"
		id="commentWriter"
		value="${sessionScope.writernick }" readonly="readonly"/>
	<textarea rows="3" cols="60"
		class="form-control" id="commentContent"></textarea>
	<button id="btnCommInsert" class="btn">입력</button>
</div>	<!-- 댓글 입력 end -->

<!-- 댓글 리스트 -->
<table class="table table-striped table-hover table-condensed">
<thead>
<tr>
	<th>번호</th>
	<th>작성자</th>
	<th>댓글</th>
	<th>작성일</th>
	<th></th>
</tr>
</thead>
<tbody>
<c:forEach items="${commentList }" var="comment">
<tr data-commentno="${comment.commentNo }">
	<td>${comment.rnum }</td>
	<td>${comment.commentWriter }</td>
	<td>${comment.content }</td>
	<td>
		<fmt:formatDate value="${comment.writtenDate }"
			pattern="yy-MM-dd hh:mm:ss" />
	</td>
	<td>
		<c:if test="${sessionScope.writerid eq comment.userid }">
		<button class="btn btn-default"
			onclick="deleteComment(${comment.commentNo });">삭제</button>
		</c:if>
	</td>
	
</tr>
</c:forEach>
</tbody>
</table>	<!-- 댓글 리스트 end -->

</div>	<!-- 댓글 처리 end -->

</div>	<!-- container end -->

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>
