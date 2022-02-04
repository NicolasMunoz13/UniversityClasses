package Data;

public class PartTimeTeacher extends Teacher {

    private double hoursPerWeek;

    public PartTimeTeacher() {
    }

    public PartTimeTeacher(String firstName, String lastName, double baseSalary, boolean isFullTime, double hoursPerWeek) {
        super(firstName, lastName, baseSalary, isFullTime);
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public double getSalary() {
        return getBaseSalary() * hoursPerWeek;
    }

    public Teacher ParTimeTeacherInit(){
        Teacher partTimeTeacher = new PartTimeTeacher("Ellie",  "Simpson", 700, false, 10);
        return partTimeTeacher;
    }
}
