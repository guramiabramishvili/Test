<%-- 
    Document   : createcontest
    Created on : Mar 11, 2017, 3:43:01 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Contest</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="createcontestForm">
            <form action="CreateContestServlet" name="createcontestForm" method="post">>
                სახელი       : <input type="text" name="name"/> <br>
                თარიღი       : <input type="date" name="date"/> <br>
                დრო          : <input type="time" name="time" /> <br>
                ხანგრძლივობა  : <input type=number name="duration" /> <br>
                 
                <input type=submit value="გაგრძელება" />
            </form>
        </div>

    </body>
</html>