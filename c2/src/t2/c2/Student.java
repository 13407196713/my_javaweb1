package t2.c2;

public class Student {
    private Integer sid;
    private String sname;
    private Integer age;
    private String course;

    public Student() {
        super();
    }

    public Integer getSid(){return sid;}
    public void setSid(Integer sid){this.sid = sid;}
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }

    public String toString(){
        return "sid = " + sid + ", sname = " + sname + ", age = " + age + ", course = " + course;
    }
}
