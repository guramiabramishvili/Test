package ge.mziuri.test.model;



public class Result {

    private User user;
    private Contest contest;
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
