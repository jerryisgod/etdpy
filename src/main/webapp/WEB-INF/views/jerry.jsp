<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>S.H SHOP</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
     <style>
        .left-column {
            background-color: red; /* 紅色背景 */
            height: 100vh; /* 高度佔滿整個視口 */
        }
        .right-column {
            background-color: red; /* 紅色背景 */
            height: 100vh; /* 高度佔滿整個視口 */
        }
          .middle-column {
            height: 100vh; /* 高度佔滿整個視口 */
            display: flex;
            justify-content: center; /* 水平居中 */
            align-items: center; /* 垂直居中 */
        }
        .form-container {
            width: 100%;
            max-width: 400px; /* 最大寬度 */
        }
        
    </style>
</head>
<body>
        <div class="container-fluid">
        <div class="row">
            <div class="col-md-2 d-none d-md-block left-column">
                <!-- 左側欄位內容 -->
                <h3>左側欄位</h3>
                <p>這是左側欄位的內容。</p>
            </div>
            <div class="col-md-8 col-12 middle-column text-center">
            <form action="/index" method="post" class="form-container">
						<div class="loginform2">
							<div>
								<span class="item">帳號</span> <input name="muid" type="text"
									class="l_id" value="" tabindex="1">
							</div>
							<br>
							<div>
								<span class="item">密碼</span> <input name="mpassword"
									type="password" class="l_id" value="" tabindex="2">
							</div>
							<p id="ac-error" class="error-msg" role="alert"></p>
						</div>
						<div class="loginbutton" >
							<button type="submit" class="loginbtn">
							<img  id="loginImage" src="images/ANAL.jpg" width="100" height="100" alt="登入">
							</button>
						</div>
					</form>
            </div>
            <div class="col-md-2 d-none d-md-block right-column">
                <!-- 右側欄位內容 -->
                <h3>右側欄位</h3>
                <p>這是右側欄位的內容。</p>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>

