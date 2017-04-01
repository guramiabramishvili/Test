<%-- 
    Document   : Test
    Created on : Mar 30, 2017, 5:13:23 PM
    Author     : User
--%>



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
                    
                        out.write(" კონტესტის სახელი " + contestDAO.getAllContest().get(ContestId).getName() + "<br>"
                                + "კონტესტის დაწღების თარიღი " + contestDAO.getAllContest().get(ContestId).getDate() + "<br>"
                                + "კონტესტის დაწყების დრო " + contestDAO.getAllContest().get(ContestId).getTime() + "<br>"
                                + "კონტესტის ხანგრძლივობა " + contestDAO.getAllContest().get(ContestId).getDuration()/60 +"  წუთი"+ "<br> <br>"
                                );
                        if((contestDAO.getAllContest().get(ContestId).getDate().getTime()/1000)<=(new Date().getTime()/1000) &&
                       (new Date().getTime()/1000)<(contestDAO.getAllContest().get(ContestId).getDate().getTime()/1000+contestDAO.getAllContest().get(ContestId).getDuration()/1000)){
                                                  
                            out.write("<a href=\"StartContest.jsp?contestId=" + ContestId +"\">" + "კონტესტის დაწყება" + "</a> <br>");
                        }
                        
                        else if( (new Date().getTime()/1000) > (contestDAO.getAllContest().get(ContestId).getDate().getTime() / 1000 + contestDAO.getAllContest().get(ContestId).getDuration()/1000))
                            out.write("კონტესტი დამთავრებულია!");
                        
                        else if( (new Date().getTime()/1000) < (contestDAO.getAllContest().get(ContestId).getDate().getTime()) / 1000 ) 
                            out.write("კონტესტი ჯერ არ დაწყებულა");
                }
            %>
        </div>
    </body>
</html>
