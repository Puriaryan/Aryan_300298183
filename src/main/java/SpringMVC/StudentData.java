package SpringMVC;

import java.util.Objects;

public class StudentData {

    private static int id;
    //private int id;
    private String user;
    private String snumber;
    private String sname;
    private double gpa;

    StudentData(String snumber, String sname, double gpa) {
        this.snumber = snumber;
        this.sname = sname;
        this.gpa = gpa;
    }

    public StudentData(int i, String jammer_diaz, double gpa, boolean b) {
    }

    public StudentData(int id, String user, String num, String name, double gpa) {
    }

    public StudentData(String snumber, String sname) {
        this.snumber = snumber;
        this.sname = sname;
    }

    public StudentData(int id, String user, int snumber, String name, double gpa) {
        this.id = id;
        this.user = user;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        StudentData.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        StudentData d = (StudentData) obj;
        return id == StudentData.id;
    }

    @Override
    public String toString() {
        return "StudentRecord{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", num='" + snumber + '\'' +
                ", name=" + sname +
                ", gpa=" + gpa +
                '}';
    }
}
