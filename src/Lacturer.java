public class Lacturer extends Person{

    private Long salary;
    private String faculty;

    public Lacturer(Long id, String name, Integer age, Long salary, String faculty) {
        super(id, name, age);
        this.salary = salary;
        this.faculty = faculty;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
