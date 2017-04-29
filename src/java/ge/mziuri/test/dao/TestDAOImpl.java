package ge.mziuri.test.dao;

import ge.mziuri.test.metainfo.DatabaseMetaInfo;
import ge.mziuri.test.model.QuestionType;
import ge.mziuri.test.model.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDAOImpl implements TestDAO {

    private static final String SPLITTER = "#@~";

    private Connection con;

    private PreparedStatement pstmt;

    public TestDAOImpl() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(DatabaseMetaInfo.databaseURL, DatabaseMetaInfo.username, DatabaseMetaInfo.passsword);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addTest(Test test) {
        try {
            pstmt = con.prepareStatement("INSERT INTO test (question_type, question, possible_answers, correct_answer_indexes, correct_open_answers, contest_id) VALUES (?,?,?,?,?,?)");
            String answers = "";
            for (int i = 0; i < test.getAnswers().size(); i++) {
                answers = answers + test.getAnswers().get(i);
                if (i != test.getAnswers().size() - 1) {
                    answers = answers + SPLITTER;
                }
            }
            String correctAnswers = "";
            for (int i = 0; i < test.getAnswerIndexes().size(); i++) {
                correctAnswers = correctAnswers + test.getAnswerIndexes().get(i);
                if (i != test.getAnswerIndexes().size() - 1) {
                    correctAnswers = correctAnswers + SPLITTER;
                }
            }
            String openQuestionsAnswers = "";
            for (int i = 0; i < test.getOpenquestionanswer().size(); i++) {
                openQuestionsAnswers = openQuestionsAnswers + test.getOpenquestionanswer().get(i);
                if (i != test.getOpenquestionanswer().size() - 1) {
                    openQuestionsAnswers = openQuestionsAnswers + SPLITTER;
                }
            }

            pstmt.setString(1, test.getType().name());
            pstmt.setString(2, test.getQuestion());
            pstmt.setString(3, answers);
            pstmt.setString(4, correctAnswers);
            pstmt.setString(5, openQuestionsAnswers);
            pstmt.setInt(6, test.getContestid());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {}
        }
    }

    @Override
    public List<Test> getQuestionByContestId(Integer contestId)  {
        List<Test> tests = new ArrayList<>();
        
        try {
            pstmt = con.prepareCall("SELECT * FROM Test WHERE contest_id = ?;");
            pstmt.setInt(1, contestId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Test test=new Test();
                test.setId(rs.getInt("id"));
                test.setQuestion(rs.getString("question"));
                test.setContestid(rs.getInt("contest_id"));
                test.setType(QuestionType.valueOf(rs.getString("question_type")));
                String possibleAnswers = rs.getString("possible_answers");
                if (possibleAnswers != null) {
                test.setAnswers(new ArrayList<>(Arrays.asList(possibleAnswers.split(SPLITTER))));
                } else {
                    String correctOpenAnswers = rs.getString("correct_open_answers");
                    test.setOpenquestionanswer(new ArrayList<>(Arrays.asList(correctOpenAnswers.split(SPLITTER))));
                }
                String correctAnswerIndexesString = rs.getString("correct_answer_indexes");
                List<Integer> answerIndexes  = new ArrayList<>();
                for (String part : correctAnswerIndexesString.split(SPLITTER)) {
                    if (part != null && !part.isEmpty()) {
                        answerIndexes.add(Integer.parseInt(part));
                    }
                }
                test.setAnswerIndexes(answerIndexes);
                tests.add(test);
            }            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {}
        }
        return tests;
    }
}
