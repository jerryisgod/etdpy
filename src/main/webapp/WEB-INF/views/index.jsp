<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>S.H SHOP</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="js/main.js"></script>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        text-align: center;
        padding: 20px;
    }
    .welcome-message {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        max-width: 600px;
        margin: 0 auto;
    }
    .welcome-message h2 {
        color: #333;
    }
</style>
</head>
<body>

<div class="welcome-message">
    <h2>歡迎來到S.H SHOP</h2>
    <p>You are now logged in!</p>
    <button type="button" onclick="location.href='login'">登出</button>
</div>

</body>
</html>
