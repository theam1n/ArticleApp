<style>

    body {
        margin: 0;
        padding: 0;
    }

    .navbar {
        background-color: darkorange;
        display: flex;
        align-items: center;
        justify-content: space-between;
        padding: 10px;
    }

    .navbar-brand {
        font-size: 24px;
        color: white;
        text-decoration: none;
        padding: 10px;
    }

    .navbar-nav {
        display: flex;
        align-items: center;
        list-style: none;
        margin: 0;
        padding: 0;
        height: 24px;
    }

    .nav-item {
        padding: 5px;
    }

    .nav-link {
        color: white;
        text-decoration: none;
    }

    .nav-link:hover {
        text-decoration: underline;
    }
</style>

<header>
    <nav class="navbar">
        <div>
            <a href="#" class="navbar-brand">Article App</a>
        </div>
        <% String name = (String) session.getAttribute("name"); %>
        <% if (name != null) { %>
        <ul class="navbar-nav">
            <li class="nav-item">
                <h3 style="color: white"><%= name %></h3>
            </li>
            <li class="nav-item">
                <a href="<%= request.getContextPath() %>/logout" class="nav-link">Logout</a>
            </li>
        </ul>
        <% } %>
    </nav>
</header>
