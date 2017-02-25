
package ge.mziuri.test.model;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private User user;
    private Contest contest;    
    private List<List<String>> myAnswers = new ArrayList<>();
    private int point;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    public List<List<String>> getMyAnswers() {
        return myAnswers;
    }

    public void setMyAnswers(List<List<String>> myAnswers) {
        this.myAnswers = myAnswers;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Result(User user, Contest contest, int point) {
        this.user = user;
        this.contest = contest;
        this.point = point;
    }

    public Result() {
    }
}
