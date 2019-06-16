<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<video width="300" height="200" controls autoplay preload>
<source src="Bumblbugimg/sample.mp4"type="video/mp4">

</video>




<form method="post" name="insertform" action="InsertProject/readystorage.jsp"  enctype="multipart/form-data">
<input type="file" name="pj_img" ">
<input type="file" name="profile_img"  >
<input type="file" class="p3_1_input" name="pj_intro_video">
<button type="submit"></button>
</form>
</body>
</html>