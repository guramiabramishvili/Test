<%@page import="ge.mziuri.test.dao.TestDAOImpl"%>
<%@page import="ge.mziuri.test.dao.TestDAO"%>
<%@page import="ge.mziuri.test.model.Contest"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="ge.mziuri.test.dao.ContestDAOImpl"%>
<%@page import="ge.mziuri.test.dao.ContestDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> admin </title>
      <meta charset="UTF-8">
        
    </head>
    <body>
        <div >
                    <font size="3">შექმნილი კონტესტები:</font> <br>
                    <%
                         ContestDAO contestDAO = new ContestDAOImpl();
                TestDAO testDAO = new TestDAOImpl();
                RequestDispatcher rd = request.getRequestDispatcher("jsp");
                List<Contest> contests = contestDAO.getAllContest(true);
                for (int i = 0; i < contests.size(); i++) {
                    out.write("<a href=\"TestType.jsp?contestId=" + contests.get(i).getId() + "\">" + i + ")"
                            + contests.get(i).getName() + "</a> <br>");
                        }
                    %>
            <a href="createcontest.jsp">ახალი კონტესტის შექმნა</a> <br>
                    </div>
    </body>
</html>

