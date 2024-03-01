<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="board.DAO" %>
<%@ page import="board.DTO" %>

<!-- JDBC 드라이버 로드 -->
<%
Class.forName("com.mysql.jdbc.Driver");
%>

<!-- 데이터베이스 연결 -->
<%
String url = "jdbc:mysql://localhost:3306/board";
String username = "root";
String password = "admin";
Connection conn = DriverManager.getConnection(url, username, password);

//PreparedStatement 객체 생성
PreparedStatement pstmt = null;
ResultSet rs = null;
%>


<html>
<head>
<title>게시판</title>
<link rel="stylesheet" href="style.css">

</head>
<body>
<div id="container"><!-- --이 페이지의 전체 레이아웃 container -->
<header>
	<h1>Title</h1> <!-- --타이틀, 이후 include로 나눌 예정-->
	
	<select name="menu"><!-- --사이트의 메뉴, 햄버거 메뉴보다 간단하리라 생각하여 select를 선택 -->
		<option value="">로그인</option>
		<option value="">회원가입</option>
		<option value="">게시판</option>
		<option value="">링크</option>
	</select>
</header>

    <!-- 데이터베이스에서 데이터 출력 -->
<div id="contents">
 <% 
        String sql = "select * from board";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        while (rs.next()) {
        %>

			
			<!-- ---모든 이름은 앞에 클래스명이나 용도명을 쓰고 뒤에 name, title 등을 붙임 -->
			<!-- --DB : number, title, content, id, name--------->

    <div class="article">
        <div class="articleTitle"><%= rs.getString("title") %></div>
        <div class="articleUserName"><%= rs.getString("name") %>
       <!-- - <button>수정</button> 
        <button>삭제</button>- --> 
        </div>
        <div class="articleContent"><%= rs.getString("content") %></div>
        
        
    </div><!-- article end -->
	
	    <% 
    }
    %>


	<div id="write">
	<form action="writeAction.jsp"><br/>
  <input type="text" id="writeName" name="writeName" value="이름">
  <input type="text" id="writeTitle" name="writeTitle" value="제목">
   <input type="text" id="writeContent" name="writeContent" value="내용">
  <input type="submit" value="Submit">
</form>
	</div><!--writing---------------------- end -->


	
</div><!-- -contents -->
<footer><h2>FOOTER</h2></footer><!-- --footer, 이후 include로 나눌 예정-->


</div><!-- ----container end -->
</body>
</html>