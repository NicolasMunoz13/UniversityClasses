package Data;


public abstract class Teacher extends Person{

    private double baseSalary;
    private boolean isFulltime;
    private int id;
    private static int counter = 1;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, double baseSalary, boolean isFulltime) {
        super(firstName, lastName);
        this.baseSalary = baseSalary;
        this.isFulltime = isFulltime;
        this.id = counter;
        this.counter++;
    }

    public boolean isFulltime() {
        return isFulltime;
    }

    public void setFulltime(boolean fulltime) {
        isFulltime = fulltime;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getId() {
        return id;
    }


    public abstract double getSalary();
}
