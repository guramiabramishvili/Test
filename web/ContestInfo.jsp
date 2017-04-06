<%-- 
    Document   : Test
    Created on : Mar 30, 2017, 5:13:23 PM
    Author     : User
--%>



<%@page import="ge.mziuri.test.dao.TestDAO"%>
<%@page import="ge.mziuri.test.dao.TestDAOImpl"%>
<%@page import="java.util.Date"%>
<%@page import="ge.mziuri.test.dao.ContestDAOImpl"%>
<%@page import="ge.mziuri.test.dao.ContestDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ContestInfo</title>
    </head>
    <body>
        <div>
            <%
                if (request.getParameter("contestId") != null) {
                    int ContestId=Integer.parseInt(request.getParameter("contestId"));
                    Cookie cookie = new Cookie("contest_id", request.getParameter("contestId"));
                    response.addCookie(cookie);
                    ContestDAO contestDAO = new ContestDAOImpl();
                     TestDAO testDAO = new TestDAOImpl();
                        out.write(" კონტესტის სახელი " + contestDAO.getAllContest(true).get(ContestId).getName() + "<br>"
                                + "კონტესტის დაწღების თარიღი " + contestDAO.getAllContest(true).get(ContestId).getDate() + "<br>"
                                + "კონტესტის დაწყების დრო " + contestDAO.getAllContest(true).get(ContestId).getTime() + "<br>"
                                + "კონტესტის ხანგრძლივობა " + contestDAO.getAllContest(true).get(ContestId).getDuration()/60 +"  წუთი"+ "<br> <br>"
                                );
                        if((contestDAO.getAllContest(true).get(ContestId).getDate().getTime()/1000)<=(new Date().getTime()/1000) &&
                       (new Date().getTime()/1000)<(contestDAO.getAllContest(true).get(ContestId).getDate().getTime()/1000+contestDAO.getAllContest(true).get(ContestId).getDuration()/1000)){
                               if((testDAO.getquestionbyContest_id(ContestId).get(1).getType().name().equals("SINGLE_ANSWER")==true)){                   
                            out.write("<a href=\"OneAnsTest.jsp?contestId=" + ContestId +"\">" + "კონტესტის დაწყება" + "</a> <br>");
                        }
                                       if((testDAO.getquestionbyContest_id(ContestId).get(1).getType().name().equals("OPEN")==true)){                   
                            out.write("<a href=\"OpenAnsTest.jsp?contestId=" + ContestId +"\">" + "კონტესტის დაწყება" + "</a> <br>");
                        }
                                               if((testDAO.getquestionbyContest_id(ContestId).get(1).getType().name().equals("MULTIPLE_ANSWER")==true)){                   
                            out.write("<a href=\"MultiAnsTest.jsp?contestId=" + ContestId +"\">" + "კონტესტის დაწყება" + "</a> <br>");
                        }
                                               
                        }
                        else if( (new Date().getTime()/1000) > (contestDAO.getAllContest(true).get(ContestId).getDate().getTime() / 1000 + contestDAO.getAllContest(true).get(ContestId).getDuration()/1000))
                            out.write("კონტესტი დამთავრებულია!");
                        
                        else if( (new Date().getTime()/1000) < (contestDAO.getAllContest(true).get(ContestId).getDate().getTime()) / 1000 ) 
                            out.write("კონტესტი ჯერ არ დაწყებულა");
                }
            %>
        </div>
    </body>
</html>
