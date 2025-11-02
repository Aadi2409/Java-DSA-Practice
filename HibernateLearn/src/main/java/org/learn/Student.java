package org.learn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private int roll_no;
    private String sName;
    private int sAge;

    public int getsAge() {
        return sAge;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public String getsName() {
        return sName;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll_no=" + roll_no +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                '}';
    }
}
