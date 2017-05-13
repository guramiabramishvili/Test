<%@page import="ge.mziuri.test.model.Test"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="ge.mziuri.test.dao.TestDAO"%>
<%@page import="ge.mziuri.test.dao.TestDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ერთ პასუხიანი ტესტი</title>
    </head>
    <body class="testbody">
        <form action="OneAnsTestServlet" method="get">
     <%
                TestDAO testDAO = new TestDAOImpl();

                int contestid = 0;
                int questionNumber = 0;
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("contest_id")) {
                            contestid = Integer.parseInt(cookie.getValue());
                        }
                    }
                    for (Cookie cookie1 : cookies) {
                        if (cookie1.getName().equals("TestNumber")) {
                            questionNumber = Integer.parseInt(cookie1.getValue());
                        }
                    }
                }
                List<Test> tests = testDAO.getQuestionByContestId(contestid);
                String question = tests.get(questionNumber).getQuestion();
                %>
                                
            <input type="text" id="q0" style="width:800px; height:100px;"  value="<%=question%>" name="question" readonly /> <br> <br> 
                 <%
                List<String> answers=tests.get(questionNumber).getAnswers();
                
                for(int i=0;i<answers.size();i++){
                  out.write("<input type=\"radio\" name=\"answer\" value=\"" + i + "\" >");
                  out.write("<input type=\"text\"   name=\"" + i + "\" value=\"" + answers.get(i) + "\" \" readonly \" /> <br> <br> ");
                }

            %>                    
              <button id="b" type="submit">გაგრძელება</button>
        </form>
    </body>
</html>
