
package ge.mziuri.test.model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;



public class Contest implements Serializable {
    
    private int id;
    private String name;
    private Date date;
    private Time time;
    private int duration;  //წამებში 
 //   private List<Test> tests = new ArrayList<>();
   // private List<Result> results = new ArrayList<>();

    public Contest() {
    }

    public Contest(int id, String name, Date date, Time time, int duration) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }



   
}
