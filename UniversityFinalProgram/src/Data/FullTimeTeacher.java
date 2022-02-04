package Data;

public class FullTimeTeacher extends Teacher {

    private double yearsOfExperience;

    public FullTimeTeacher() {
    }

    public FullTimeTeacher(String firstName, String lastName, double baseSalary, boolean isFullTime, double yearsOfExperience) {
        super(firstName, lastName, baseSalary, isFullTime);
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public double getSalary() {
        return (getBaseSalary() + (getBaseSalary() * 1.1)) * yearsOfExperience;
    }

    public Teacher FullTimeTeacherInit(){
        Teacher fullTimeTeacher= new FullTimeTeacher("Joel", "March", 500, true, 1);
        return fullTimeTeacher;
    }


}
