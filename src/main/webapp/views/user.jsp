<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="vi">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
            href="https://fonts.googleapis.com/css2?family=Poor+Story&family=Roboto:ital,wght@1,300;1,400;1,500&display=swap"
            rel="stylesheet">
    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/style.css">
</head>

<body>
<header>
    <nav class="navbar navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand">Navbar</a>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1"
                        data-bs-toggle="dropdown" aria-expanded="false">
                    ${sessionScope.userName}
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                    <li><a class="dropdown-item" href="/user/user-profile/${sessionScope.memberID}">User Profile</a>
                    </li>
                    <li><a class="dropdown-item" href="/logout/logout-user">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<main>
    <section>
        <div class="row" style="min-height: 100vh;">
            <div class="col-3 bg-light" style="padding-right: 0;">
                <nav class="navbar navbar-light navbar__left" style="padding-top: 0;">
                    <ul class="" style="list-style-type: none;">
                        <li><a style="background-color: #ccc; font-size: 16px;" class="navbar-brand" href="/">View Contents</a></li>
                        <li><a style="font-size: 16px;" class="navbar-brand" href="/content">Form Content</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-9">
                <div class="wrapper">
                    <h2>View Content</h2>
                    <hr>
                    <div>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Title</th>
                                    <th scope="col">Brief</th>
                                    <th scope="col">Created Date</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% int i = 0; %>
                                <c:forEach items="${listContent}" var="content">
                                    <tr>
                                        <th scope="row"><%  i++; %></th>
                                        <td>${content.getTitle()}</td>
                                        <td>${content.getBrief()}</td>
                                        <td>${content.getCreateDate()}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<footer>
    <!-- place footer here -->
</footer>
<!-- Bootstrap JavaScript Libraries -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
        integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">
</script>
</body>

</html>