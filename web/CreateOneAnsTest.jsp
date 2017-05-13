<%@page import="ge.mziuri.test.dao.ContestDAOImpl"%>
<%@page import="ge.mziuri.test.dao.ContestDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="public/css/createtest.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ერთ პასუხიანი ტესტი</title>
    </head>
  <body class=testbody>
      <div>
        <form class=testform action="CreateMultiAnsTestServlet" method="post">
            <input  id="q0" type="text" style="width:600px; height:100px;" placeholder="შეიტანეთ კითხვა" name="question" /> <br> <br> 
            <input  type="radio" name="CorrectAns" value="1" checked>
            <input  type="text" placeholder="სავარაუდო პასუხი " name="1" /> <br> <br> 
            <input  type="radio" name="CorrectAns" value="2" >
            <input  type="text" placeholder="სავარაუდო პასუხი "  name="2" /> <br> <br> 
            <input  type="radio" name="CorrectAns" value="3" >
            <input  type="text" placeholder="სავარაუდო პასუხი(არა სავალდებულო) " name="3" /> <br> <br> 
            <input  type="radio" name="CorrectAns" value="4" >
            <input  type="text"  placeholder="სავარაუდო პასუხი(არა სავალდებულო) " name="4" /> <br> <br> 
            <input  type="radio" name="CorrectAns" value="5" >
            <input  type="text" placeholder="სავარაუდო პასუხი(არა სავალდებულო) " name="5" /> <br> <br> 
            <input type="radio" name="CorrectAns" value="6" >
            <input type="text" placeholder="სავარაუდო პასუხი(არა სავალდებულო) " name="6" /> <br> <br>
            <button id="b" type="submit">დამატება</button>
        </form>
        </div>
    </body>
</html>
