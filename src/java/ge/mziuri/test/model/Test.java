
package ge.mziuri.test.model;

import java.util.ArrayList;
import java.util.List;

public class Test {
    
    private int id;
    private QuestionType type;
    private String question;
    private List<String> answers = new ArrayList<String>();
    private List<Integer> answerIndexes = new ArrayList<Integer>();
    private List<String> openquestionanswer = new ArrayList<String>();
    private int contestid;
    public int getId() {
        return id;
    }

    public int getContestid() {
        return contestid;
    }

    public void setContestid(int contestid) {
        this.contestid = contestid;
    }

    public Test(int contestid) {
        this.contestid = contestid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public List<Integer> getAnswerIndexes() {
        return answerIndexes;
    }

    public void setAnswerIndexes(List<Integer> answerIndexes) {
        this.answerIndexes = answerIndexes;
    }

    public List<String> getOpenquestionanswer() {
        return openquestionanswer;
    }

    public void setOpenquestionanswer(List<String> openquestionanswer) {
        this.openquestionanswer = openquestionanswer;
    }

    public Test(int id, QuestionType type, String question) {
        this.id = id;
        this.type = type;
        this.question = question;
    }

    public Test() {
    }


    
}
