<%-- 
    Document   : CreateOneAnsTest
    Created on : Mar 18, 2017, 2:53:20 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ერთ პასუხიანი ტესტი</title>
    </head>
    <body>
        <form>
            <input type="text" style="width:800px; height:100px; font-size:20px" placeholder="შეიტანეთ კითხვა" name="question" /> <br> <br> 
            <input type="radio" name="CorrectAns" value="Ans1" checked>
            <input type="text" style="width:400px; height:50px;" placeholder="სავარაუდო პასუხი " name="Ans1" /> <br> <br> 
            <input type="radio" name="CorrectAns" value="Ans2" >
            <input type="text" style="width:400px; height:50px; " placeholder="სავარაუდო პასუხი "  name="Ans2" /> <br> <br> 
            <input type="radio" name="CorrectAns" value="Ans3" >
            <input type="text" style="width:400px; height:50px; " placeholder="სავარაუდო პასუხი(არა სავალდებულო) " name="Ans3" /> <br> <br> 
            <input type="radio" name="CorrectAns" value="Ans4" >
            <input type="text" style="width:400px; height:50px; " placeholder="სავარაუდო პასუხი(არა სავალდებულო) " name="Ans4" /> <br> <br> 
            <input type="radio" name="CorrectAns" value="Ans5" >
            <input type="text" style="width:400px; height:50px; " placeholder="სავარაუდო პასუხი(არა სავალდებულო) " name="Ans5" /> <br> <br> 
            <input type="radio" name="CorrectAns" value="Ans6" >
            <input type="text" style="width:400px; height:50px; " placeholder="სავარაუდო პასუხი(არა სავალდებულო) " name="Ans6" /> <br> <br>
            <input type="submit" value="გაგრძელება" />
        </form>
    </body>
</html>
