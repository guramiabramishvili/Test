<%-- 
    Document   : TestType
    Created on : Mar 15, 2017, 3:32:17 PM
    Author     : lortkipanidze
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>აირჩიეთ ტესტის ტიპი</title>
    </head>
    <body>
        <div class="TestTypeForm">
            <form action="TestTypeServlet" method="post">
                <input type="radio" name="testType" value="oneAns" checked>ერთპასუხიანი ტესტი<br>
                <input type="radio" name="testType" value="multiAns">რამდენიმეპასუხიანი ტესტი<br>
                <input type="radio" name="testType" value="open">ღია შეკითხვა<br>
                <input type="submit" value="გაგრძელება" />
                <a href="adminHome.jsp">მთავარ გვერდზე დაბრუნება</a>

            </form>

    </div>
</body>
</html>