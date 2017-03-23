<%-- 
    Document   : CreateMultiAnsTest
    Created on : Mar 18, 2017, 2:53:42 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>რამდენიმე პასუხიანი ტესტი</title>
    </head>
    <body>
        <form action="CreateMultiAnsTestServlet" method="post">
            <input type="text" style="width:800px; height:100px; font-size:20px" placeholder="შეიტანეთ კითხვა" name="question" /> <br> <br> 
            <input type="checkbox" name="CorrectAns" value="1" checked>
            <input type="text" style="width:400px; height:50px;" placeholder="სავარაუდო პასუხი " name="1" /> <br> <br> 
            <input type="checkbox" name="CorrectAns" value="2" >
            <input type="text" style="width:400px; height:50px; " placeholder="სავარაუდო პასუხი "  name="2" /> <br> <br> 
            <input type="checkbox" name="CorrectAns" value="3" >
            <input type="text" style="width:400px; height:50px; " placeholder="სავარაუდო პასუხი(არა სავალდებულო) " name="3" /> <br> <br> 
            <input type="checkbox" name="CorrectAns" value="4" >
            <input type="text" style="width:400px; height:50px; " placeholder="სავარაუდო პასუხი(არა სავალდებულო) " name="4" /> <br> <br> 
            <input type="checkbox" name="CorrectAns" value="5" >
            <input type="text" style="width:400px; height:50px; " placeholder="სავარაუდო პასუხი(არა სავალდებულო) " name="5" /> <br> <br> 
            <input type="checkbox" name="CorrectAns" value="6" >
            <input type="text" style="width:400px; height:50px; " placeholder="სავარაუდო პასუხი(არა სავალდებულო) " name="6" /> <br> <br>
            <input type="submit" value="დამატება" />
        </form>
    </body>
</html>
 