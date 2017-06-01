<%-- 
    Document   : Test
    Created on : Mar 30, 2017, 5:13:23 PM
    Author     : User
--%>



<%@page import="ge.mziuri.test.dao.UserDAOImpl"%>
<%@page import="ge.mziuri.test.dao.UserDAO"%>
<%@page import="ge.mziuri.test.dao.ResultsDAO"%>
<%@page import="ge.mziuri.test.dao.ResultsDAOImpl"%>
<%@page import="ge.mziuri.test.model.Result"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="ge.mziuri.test.model.Test"%>
<%@page import="ge.mziuri.test.model.Contest"%>
<%@page import="ge.mziuri.test.dao.TestDAO"%>
<%@page import="ge.mziuri.test.dao.TestDAOImpl"%>
<%@page import="java.util.Date"%>
<%@page import="ge.mziuri.test.dao.ContestDAOImpl"%>
<%@page import="ge.mziuri.test.dao.ContestDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="public/css/contestinfo.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ContestInfo</title>
    </head>
    <body>
        <div>
            <%
                if (request.getParameter("contestId") != null) {
                    int ContestId = Integer.parseInt(request.getParameter("contestId"));
                    Cookie ContestIdCookie = new Cookie("contest_id", request.getParameter("contestId"));
                    response.addCookie(ContestIdCookie);
                    Cookie TestNumberCookie = new Cookie("TestNumber", "0");
                    response.addCookie(TestNumberCookie);
                    Cookie pointsCookie = new Cookie("Points", "0");
                    response.addCookie(pointsCookie);
                    ContestDAO contestDAO = new ContestDAOImpl();
                    UserDAO userDAO = new UserDAOImpl();
                    TestDAO testDAO = new TestDAOImpl();
                    ResultsDAO resultsDAO = new ResultsDAOImpl();
                    Contest contest = contestDAO.getContestbyId(ContestId);
                    long CurrentDateInMills = new Date().getTime() ;
                    long DatabaseDateInMills = contest.getDate().getTime() + contest.getCurrentTime().getTime();
                    long Duration = contest.getDuration()*1000;
                    Test firsttest = testDAO.getQuestionByContestId(ContestId).get(0);
                    out.write(" კონტესტის სახელი " + contest.getName() + "<br>"
                            + "კონტესტის დაწღების თარიღი " + contest.getDate() + "<br>"
                            + "კონტესტის დაწყების დრო " + contest.getCurrentTime() + "<br>"
                            + "კონტესტის ხანგრძლივობა " + contest.getDuration() / 60 + "  წუთი" + "<br> <br>"
                                    );
                    if (DatabaseDateInMills <= CurrentDateInMills && CurrentDateInMills < (DatabaseDateInMills + Duration )) {
                        if ((firsttest.getType().name().equals("SINGLE_ANSWER") == true)) {
                            out.write("<a href=\"OneAnsTestServlet\">" + "კონტესტის დაწყება" + "</a> <br>");
                        }
                        if ((firsttest.getType().name().equals("OPEN") == true)) {
                            out.write("<a href=\"OpenAnsTestServlet\">" + "კონტესტის დაწყება" + "</a> <br>");
                        }
                        if ((firsttest.getType().name().equals("MULTIPLE_ANSWER") == true)) {
                            out.write("<a href=\"MultiAnsTestServlet\">" + "კონტესტის დაწყება" + "</a> <br>");
                        }
                    } else if (CurrentDateInMills > (DatabaseDateInMills + Duration)) {
                        out.write("კონტესტი დამთავრებულია!"+"<br>"+"<br>");
                    } else if (CurrentDateInMills < DatabaseDateInMills) {
                        out.write("კონტესტი ჯერ არ დაწყებულა"+ "<br>" +"<br>");
                    }
                    out.write("<table>" + "<tr>"
                            + "<th>RANK </th>"
                            + "<th>Username </th>"
                            + "<th>Points </th>"
                            + "</tr>");
                    List<Result> results = new ArrayList<>();
                    results = resultsDAO.getResultByContestId(ContestId);
                    for (int i = 0; i < results.size(); i++) {
                        String username = results.get(i).getUser().getUsername();
                        int point = results.get(i).getPoint();
                        out.write("<tr>" + "<td>"+(i+1)+"</td>" + "<td>"+username+"</td>" + "<td>"+point+"</td>");
                    }
                }
            %>
        </div>
    </body>
</html>