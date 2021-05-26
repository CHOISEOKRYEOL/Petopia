<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<title>추천</title>
</head>
<body>
<c:if test="${result eq 'success'}">
<script>
var e = document.getElementById("reco")
e.addEventListener("click", function(e) {
  alert("게시물을 추천하였습니다!"));
});

  /* swal({
  title: "댓글 추천 완료!",
  text: "You clicked the button!",
  icon: "success"
  button: true
  closeOnClickOutside : false
  })
  .then((willDelete) => {
    if (willDelete) {
      swal("Poof! Your imaginary file has been deleted!", {
        icon: "success",
      });
    } else {
      swal("Your imaginary file is safe!");
    }
  }); */
  <!-- .then(value) => {
    case "확인" :
      location.href = 'detail?stateNo='+ ${myTownBoard.bigAddress.no} + '&cityNo=' + ${myTownBoard.smallAddress.no} + '&no=' + ${myTownBoard.no}
  }); -->
    <!-- 게시물을 추천하였습니다! -->
</script>
</c:if>
<c:if test="${result eq 'fail'}">
<script>
var e = document.getElementById("reco")
e.addEventListener("click", function(e) {
  alert("이미 추천한 게시물입니다!"));
});
  /* swal({
  title: "이미 추천한 게시물 입니다!",
  text: "You clicked the button!",
  icon: "warning"
  }); */
    <!-- 이미 추천한 게시물입니다! -->
</script>
</c:if>
</body>
</html>