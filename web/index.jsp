
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head  >

        <title>შესვლა</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="public/css/style.css">
    <style>
		body {
    		background-color: CornflowerBlue;
		}
	</style>
	</head>
    <style>
        .IndBodyForm{
     // Background space
     
        }
       
        </style>
    <body class='IndBodyForm' >

        <div class="LoginForm"  style="background-color: AliceBlue;">
            <form action="LoginServlet" method="post">
                <input type="text" name="username" /> <br>
                <input type="password" name="password" /> <br>
                <a href="register.html"> რეგისტრაცია </a>
                <input  type="submit" value="შესვლა" />
            </form>
        </div>
        <%
            if (request.getAttribute("incorrectPassword") != null && request.getAttribute("incorrectPassword") == Boolean.TRUE) {
                out.write("<h4 class=\"notCorrectUsername\">  სახელი ან პაროლი არასწორია !!! </h4>");
            }
        %>

    </body>
</html>
