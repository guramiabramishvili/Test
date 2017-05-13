<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="public/css/TestType.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>აირჩიეთ ტესტის ტიპი</title>
    </head>
    <body class=TestTypeBody>
        <div class="TestTypeDiv">
            <form class="TestTypeForm" action="TestTypeServlet" method="post">
                <input type="radio" name="testType" value="oneAns" checked>ერთპასუხიანი ტესტი <br>
                <input type="radio" name="testType" value="multiAns">რამდენიმეპასუხიანი ტესტი <br>
                <input type="radio" name="testType" value="open">ღია შეკითხვა <br>
                <button id="button" type="submit">გაგრძელება</button>
                <a href="adminHome.jsp">მთავარ გვერდზე დაბრუნება</a>

            </form>
        </div>
    </body>
</html>