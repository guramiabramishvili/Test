package ge.mziuri.test.dao;

import ge.mziuri.test.metainfo.DatabaseMetaInfo;
import ge.mziuri.test.model.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
                correctAnswers = correctAnswers + test.getAnswerIndexes().get(i) + SPLITTER;
                if (i != test.getAnswerIndexes().size() - 1) {
                    correctAnswers = correctAnswers + SPLITTER;
                }
            }
            String openQuestionsAnswers = "";
            for (int i = 0; i < test.getOpenquestionanswer().size(); i++) {
                openQuestionsAnswers = openQuestionsAnswers + test.getOpenquestionanswer().get(i) + SPLITTER;
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
        }
    }
}
