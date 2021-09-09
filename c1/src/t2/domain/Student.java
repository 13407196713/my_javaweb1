package t2.domain;

public class Student {
    private int sid;
    private String sname;
    private String age;
    private String course;
    public Student() {
        super();
    }
    public Student(int sid, String sname, String age, String course) {
        super();
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.course = course;
    }

    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    @Override
    public String toString() {
        return "Student [id=" + sid + ", sname=" + sname + ", age=" + age + ", course=" + course + "]";
    }
}
