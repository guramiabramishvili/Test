<%@page import="ge.mziuri.test.dao.ContestDAOImpl"%>
<%@page import="ge.mziuri.test.dao.ContestDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> user </title>
      <meta charset="UTF-8">
        
    </head>
    <body>
        <div >
                    <font size="3">არსებული კონტესტები:</font> <br>
                    <%
                        ContestDAO contestDAO=new ContestDAOImpl();
                        for(int i=0;i<contestDAO.getAllContest().size();i++) {
                            out.write("<a href=\"Test.jsp?contestId=" + i +"\">" + i + ")" + 
                                    contestDAO.getAllContest().get(i).getName() + "</a> <br>");
                        }
                    %>
         
                    </div>
    </body>
</html>
