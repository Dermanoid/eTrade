<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head >
        <title>შესვლა</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="public/css/style.css">
    </head>
    <body class="LoginBody">
        <div>
            <form  class="LoginForm" action="LoginServlet" method="post">
                <h4 style="margin-bottom: -10px"> მომხმარებლის სახელი  </h4> <br>
                <input type="text" name="username" /> <br>
                <h4 style="margin-bottom: -13px; margin-top: 6px"> პაროლი </h4> <br>
                <input type="password" name="password" /> <br>
                <a href="register.html"> რეგისტრაცია </a>
                <input class="LoginSubmit" style="margin-top: 6px; margin-left: 3px" name="submit"  type="submit" value="შესვლა" />
            </form>
        </div>
        <%
            if (request.getAttribute("incorrectPassword") != null && request.getAttribute("incorrectPassword") == Boolean.TRUE) {
                out.write("<h4 class=\"notCorrectUsername\">  სახელი ან პაროლი არასწორია !!! </h4>");
            }
        %>
    </body>
</html>