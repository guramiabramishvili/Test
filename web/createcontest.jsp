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
                სახელი       : <input type="text" name="name" value="test"> <br>
                თარიღი       : <input type="date" name="date" value="2016-01-01"/> <br>
                დრო          : <input type="time" name="time" value="00:00"/> <br>
                ხანგრძლივობა  : <input type=number name="duration" value="20"/> <br>
                 
                <input type=submit value="გაგრძელება" />
            </form>
        </div>

    </body>
</html>
