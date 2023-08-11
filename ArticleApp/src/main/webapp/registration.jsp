<!DOCTYPE html>
<html>
<head>
    <title>Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        h2 {
            text-align: center;
        }
        .row {
            display: flex;
            justify-content: center;
        }
        .col-6 {
            width: 50%;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-control {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            display: inline-block;
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <h2>Registration Form</h2>
    <div class="row">
        <div class="col-6">
            <form action="<%=request.getContextPath()%>/register" method="post">
                <div class="form-group">
                    <label for="name">First Name:</label>
                    <input type="text" class="form-control" id="name" placeholder="First Name" name="name" required>
                </div>
                <div class="form-group">
                    <label for="surname">Last Name:</label>
                    <input type="text" class="form-control" id="surname" placeholder="Last Name" name="surname" required>
                </div>
                <div class="form-group">
                    <label for="username">User Name:</label>
                    <input type="text" class="form-control" id="username" placeholder="User Name" name="username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
                </div>
                <button type="submit">Submit</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
