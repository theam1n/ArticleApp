<%@ page import="com.articleapp.model.Article" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Article Edit</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .form-container {
            text-align: center;
            max-width: 600px;
            margin: 0 auto;
        }

        .form-row {
            display: flex;
            align-items: center;
            margin-bottom: 15px;
        }

        .form-label {
            flex-basis: 60px;
            text-align: left;
        }

        .form-input {
            flex: 1;
            padding: 5px;
        }

        .form-heading {
            text-align: center;
        }

        .form-submit {
            margin-top: 20px;
            text-align: center;
        }

        .form-submit input[type="submit"] {
            background-color: #FF6B81;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }

    </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="form-container">
    <div class="form-heading">
        <h1>Article Form</h1>
    </div>
    <% Article article = (Article) request.getAttribute("article"); %>
    <% if (article != null){%>
    <form action="<%=request.getContextPath()%>/user/article/actions?action=update&id=<%=article.getId()%>" method="post">
            <%}%>

            <% if (article == null){%>
        <form action="<%=request.getContextPath()%>/user/article/actions?action=insert" method="post">
            <%}%>

            <div class="form-row">
                <label class="form-label" for="title">Title:</label>
                <input class="form-input" type="text" <%if (article != null){%> value="<%=article.getTitle()%>" <%}%> name="title" id="title" required/>
            </div>

            <div class="form-row">
                <label class="form-label" for="article">Article:</label>
                <textarea class="form-input" name="article" id="article" rows="10" cols="50" required><% if (article != null) { %><%= article.getArticle() %><% } %></textarea>
            </div>

            <div class="form-submit">
                <input type="submit" value="Submit"/>
            </div>
        </form>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
