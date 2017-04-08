<%@page import="ge.mziuri.test.dao.UserDAOImpl"%>
<%@page import="ge.mziuri.test.dao.UserDAO"%>
<%@page import="ge.mziuri.test.model.User"%>
<%@page import="ge.mziuri.test.dao.ContestDAOImpl"%>
<%@page import="ge.mziuri.test.dao.ContestDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    
        <link rel="stylesheet" type="text/css" href="public/css/adminhomecss.css">
        <title> admin </title>
        <meta charset="UTF-8">
    </head>
    <body class="adminhomebody">  
        <div class="headline">მოგესალმებით ლუკა !</div>
        <div class="existingcontests">
            <font size="3">შექმნილი კონტესტები: <br>
            <%
                ContestDAO contestDAO = new ContestDAOImpl();
                for (int i = 0; i < contestDAO.getAllContest().size(); i++) {
                    out.write("<a href=\"TestType.jsp?contestId=" + i + "\">" + (i + 1) + ")"
                            + contestDAO.getAllContest().get(i).getName() + " - დაწყების დრო  " + contestDAO.getAllContest().get(i).getDate() + "  " 
                            +contestDAO.getAllContest().get(i).getTime() + "</a> <br>");
                }
            %>
        </div>
        <div  class="createcontestForm">
            <form action="CreateContestServlet" name="createcontestForm" method="post">
                სახელი: <input type="text" name="name" value="test"> <br>
                თარიღი: <input type="date" name="date" value="2016-01-01"/> <br>
                დრო: <input type="time" name="time" value="00:00"/> <br>
                ხანგრძლივობა: <input type=number name="duration" value="20"/> <br>
                <input type=submit value="გაგრძელება" />
            </form>
        </div>
    </body>
