<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.plantshop.cart.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 품목 삭제</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");

// DB처리 - cart 테이블의 수량 수정
String uid = request.getParameter("uid"); // uid를 이용하여 유저에 맞는 카트를 찾음
int pid = Integer.parseInt(request.getParameter("pid"));  // pid를 이용하여 제거

String pageNum = request.getParameter("pageNum");
String category = "";
String searchPname = "";

// 검색을 위함
if(request.getParameter("category") != null && !request.getParameter("category").equals("")) {
	category = request.getParameter("category");
}

if(request.getParameter("searchPname") != null && !request.getParameter("searchPname").equals("")) {
	searchPname = request.getParameter("searchPname");
}

CartDBBean cartDBBean = CartDBBean.getInstance();
int check = cartDBBean.deleteCart(uid, pid);

if(check > 0) { // 품목 삭제 성공
	out.print("<script>location.href='cart_list.jsp?pageNum=" + pageNum + "&category=" + category + "&searchPname=" + searchPname + "'</script>");
} else { // 품목 삭제 실패
	out.print("<script>alert('품목 삭제에 실패하였습니다.'); history.back();</script>");
}
%>
</body>
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       