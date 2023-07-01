public class Student extends Person{

    private Double gpa;
    private String major;

    public Student(Long id, String name, Integer age, Double gpa, String major) {
        super(id, name, age);
        this.gpa = gpa;
        this.major = major;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
