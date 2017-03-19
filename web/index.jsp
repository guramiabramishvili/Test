<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>შესვლის გვერდი</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="public/css/style.css">
    </head>
    <body class="indexPageBody"> 
        <div class="loginForm">        
            <form action="LoginServlet" method="post">
                <input type="text" placeholder="მომხ.სახელი" name="username" /> <br>
                <input type="password" placeholder="პაროლი" name="password" /> <br>
                <input type="submit" value="შესვლა" />
                <a href="register.jsp" style="color: #0099ff"> რეგისტრაცია </a>
                <%
                    if (request.getAttribute("authorizationFailed") != null && request.getAttribute("authorizationFailed") == Boolean.TRUE) {
                        out.write("<p style=\"color:red;\">სახელი ან პაროლი არასწორია!<p>");
                    }
                    %>
            </form>
        </div>
    </body>
</html>
