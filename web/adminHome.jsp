<%@page import="ge.mziuri.test.dao.UserDAOImpl"%>
<%@page import="ge.mziuri.test.dao.UserDAO"%>
<%@page import="ge.mziuri.test.model.User"%>
<%@page import="ge.mziuri.test.dao.TestDAOImpl"%>
<%@page import="ge.mziuri.test.dao.TestDAO"%>
<%@page import="ge.mziuri.test.model.Contest"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
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
        <font size="5">შექმნილი კონტესტები: <br>
        <%
            ContestDAO contestDAO = new ContestDAOImpl();
            TestDAO testDAO = new TestDAOImpl();
            RequestDispatcher rd = request.getRequestDispatcher("jsp");
            List<Contest> contests = contestDAO.getAllContest(true);
            for (int i = 0; i < contests.size(); i++) {
                out.write("<a href=\"TestType.jsp?contestId=" + contests.get(i).getId() + "\">" + (i + 1) + ")"
                        + contests.get(i).getName() + " - დაწყების დრო  " + contests.get(i).getDate() + "  "
                        + contests.get(i).getTime() + "</a> <br>");
            }
            %>   </font>
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
