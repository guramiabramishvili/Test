<%-- 
    Document   : register
    Created on : Mar 11, 2017, 3:50:06 PM
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>შესვლის გვერდი</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="public/css/style.css">
    </head>
    <body>
        <div class="registerForm">
            <form action="RegisterServlet" name="registerForm" method="post">
                სახელი:     <input type="text" name="firstname"/> <br>
                გვარი:      <input type="text" name="lastname" /> <br>
                მომ. სახ. : <input type="text" name="username" /> <br>
                ელ-ფოსტა : <input type="text" name="email" /> <br>
                პაროლი:   <input type="password" name="password" /> <br>
                <input type="submit" value="რეგისტრაცია" />
            </form>
            <%
                    if (request.getAttribute("registrationFailed") != null && request.getAttribute("registrationFailed") == Boolean.TRUE) {
                        out.write("<p style=\"color:red;\">ასეთი მომხმარებელი უკვე არსებობს<p>");
                    }
                    %>
        </div>
    </body>
</html>
