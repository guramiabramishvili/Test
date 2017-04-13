<%@page import="ge.mziuri.test.dao.ContestDAOImpl"%>
<%@page import="ge.mziuri.test.dao.ContestDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ერთ პასუხიანი ტესტი</title>
    </head>
    <body>
         <%
                        ContestDAO contestDAO=new ContestDAOImpl();
//                        for(int i=0;i<contestDAO.getAllContest().size();i++) {
//                            out.write("<a href=\"Test.jsp?contestId=" + i +"\">" + i + ")" + 
//                                    contestDAO.getAllContest().get(i).getName() + "</a> <br>");
           //             }
                    %>
        <form action="CreateOneAnsTestServlet" method="post">
            <input type="text" style="width:800px; height:100px; font-size:20px" placeholder="შეიტანეთ კითხვა" name="question" /> <br> <br> 
            <input type="radio" name="CorrectAns" value="1" checked>
            <input type="text" style="width:400px; height:50px;" placeholder="სავარაუდო პასუხი " name="1" /> <br> <br> 
            <input type="radio" name="CorrectAns" value="2" >
            <input type="text" style="width:400px; height:50px; " placeholder="სავარაუდო პასუხი "  name="2" /> <br> <br> 
            <input type="radio" name="CorrectAns" value="3" >
            <input type="text" style="width:400px; height:50px; " placeholder="სავარაუდო პასუხი(არა სავალდებულო) " name="3" /> <br> <br> 
            <input type="radio" name="CorrectAns" value="4" >
            <input type="text" style="width:400px; height:50px; " placeholder="სავარაუდო პასუხი(არა სავალდებულო) " name="4" /> <br> <br> 
            <input type="radio" name="CorrectAns" value="5" >
            <input type="text" style="width:400px; height:50px; " placeholder="სავარაუდო პასუხი(არა სავალდებულო) " name="5" /> <br> <br> 
            <input type="radio" name="CorrectAns" value="6" >
            <input type="text" style="width:400px; height:50px; " placeholder="სავარაუდო პასუხი(არა სავალდებულო) " name="6" /> <br> <br>
            <input type="submit" value="გაგრძელება" />
        </form>
    </body>
</html>
