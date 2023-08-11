<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Article App</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .welcome-text {
            font-size: 34px;
            margin-bottom: 20px;
        }

        .buttons-container {
            display: flex;
            flex-direction: row;
            align-items: center;
            margin-bottom: 230px;
        }

        .buttons-container button.login {
            background-color: orange;
        }

        .buttons-container button.signup {
            background-color: blue;
        }

        .buttons-container button {
            margin: 0 10px;
            padding: 10px 20px;
            font-size: 24px;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <div class="welcome-text">Welcome to Article App</div>

    <div class="buttons-container">
        <a href="login.jsp"><button class="login">Login</button></a>
        <a href="registration.jsp"><button class="signup">SignUp</button></a>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
