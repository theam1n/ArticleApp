<%@ page import="java.util.List" %>
<%@ page import="com.articleapp.model.Article" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Article Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;

        }
        .button-container {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }
        .button {
            font-size: 14px;
            padding: 8px 18px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            color: white;
            font-weight: bold;
        }
        .my-articles-btn {
            background-color: #FFA500;
        }
        .all-articles-btn {
            background-color: #0074D9;
            margin: 0 10px;
        }
        .add-article-btn {
            background-color: #2ECC40;
        }
        #hr1 {
            width: 60%;
            height: 2px;
            background-color: #000;
        }
        .article-container {
            display: none;
            text-align: center;
            margin-bottom: 20px;
            padding-bottom: 20px;
        }
        .article-content {
            text-align: left;
            padding: 10px;
            width: 500px;
            margin: 10px auto;
        }
        .article-title {
            text-align: left;
            font-weight: bold;
            font-size: 18px;
            margin-bottom: 5px;
            word-wrap: break-word;
        }
        .article-date {
            text-align: left;
            font-size: 14px;
            margin-top: 5px;
        }
        a {
            text-decoration: none;
        }

    </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="button-container">
    <input type="button" class="button my-articles-btn" id="my-articles-button" value="My Articles">
    <input type="button" class="button all-articles-btn" id="all-articles-button" value="All Articles">
    <input type="button" class="button add-article-btn" id="add-article-button" value="Add Article">
</div>

<div class="article-container" id="all-articles-container">
    <%
        List<Article> articleList = (List<Article>) request.getAttribute("allArticles");
        for (int i = articleList.size() - 1; i >= 0; i--) {
    %>
    <hr id="hr1">
    <div class="article-content">
        <div class="article-title">
            <%= articleList.get(i).getTitle() %>
        </div>
        <div class="article-content" style="border: 1px solid black; height: 200px;word-wrap: break-word;overflow: auto; ">
            <%= articleList.get(i).getArticle() %>
        </div>
        <div class="article-date">
            <%= articleList.get(i).getCreated_at(articleList.get(i).getId()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) %>
        </div>
        <% if (articleList.get(i).getUsername().equals(request.getSession().getAttribute("username"))) {%>
        <div>
            <a href="<%=request.getContextPath()%>/user/article/actions?action=edit&id=<%= articleList.get(i).getId() %>">
                <button class="button" style="background-color: royalblue">Edit</button>
            </a>
            <a href="<%=request.getContextPath()%>/user/article/actions?action=delete&id=<%= articleList.get(i).getId() %>">
                <button class="button" style="background-color: red">Delete</button>
            </a>
        </div>
        <%}%>
    </div>
    <%}%>
</div>

<div class="article-container" id="my-articles-container" style="display: none;">
    <% List<Article> articleList1 = (List<Article>) request.getAttribute("myArticles");
        for (int i = articleList1.size() - 1; i >= 0; i--) { %>

    <hr id="hr1">

    <div class="article-content">
        <div class="article-title">
            <%= articleList1.get(i).getTitle() %>
        </div>
        <div class="article-content" style="border: 1px solid black; height: 200px;word-wrap: break-word;overflow: auto; ">
            <%= articleList1.get(i).getArticle() %>
        </div>
        <div class="article-date">
            <%= articleList1.get(i).getCreated_at(articleList1.get(i).getId()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) %>
        </div>
        <div>
            <a href="<%=request.getContextPath()%>/user/article/actions?action=edit&id=<%= articleList1.get(i).getId() %>">
                <button class="button" style="background-color: royalblue">Edit</button>
            </a>
            <a href="<%=request.getContextPath()%>/user/article/actions?action=delete&id=<%= articleList1.get(i).getId() %>">
                <button class="button" style="background-color: red">Delete</button>
            </a>
        </div>
    </div>

    <% } %>
</div>

<jsp:include page="footer.jsp"></jsp:include>

<script>
    document.getElementById("all-articles-button").addEventListener("click", function() {
        document.getElementById("all-articles-container").style.display = "block";
        document.getElementById("my-articles-container").style.display = "none";
    });

    document.getElementById("my-articles-button").addEventListener("click", function() {
        document.getElementById("all-articles-container").style.display = "none";
        document.getElementById("my-articles-container").style.display = "block";
    });

    document.getElementById("add-article-button").addEventListener("click", function() {
        window.location.href = "<%=request.getContextPath()%>/user/article/actions?action=add";
    });
</script>

</body>
</html>
