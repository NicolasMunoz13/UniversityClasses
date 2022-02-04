package Data;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private int id;
    private static int counter = 1;
    public List<Course> foundCourse;

    public Student() {
    }

    public Student(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.id = counter;
        this.counter++;
    }

    public int getId() {
        return id;
    }

    public List<Student> studentInitialization(){
        List<Student> studentListInit = new ArrayList<>();
        studentListInit.add(new Student("Andrew", "Sal", 20));
        studentListInit.add(new Student("Mary", "Camp", 21));
        studentListInit.add(new Student("Gwen", "Cacs",19));
        studentListInit.add(new Student("Tobey", "Roeth",22));
        studentListInit.add(new Student("Tom", "Car",22));
        studentListInit.add(new Student("Ned", "Bent",20));
        return studentListInit;
    }

    public List<Course> getAllCourseListById(List<Course> courseList, int id){
        foundCourse = new ArrayList<>();
        for (int i = 0; i < courseList.size(); i++) {
            for (int j = 0; j < courseList.get(i).studentListByCourse.size(); j++) {
                if (courseList.get(i).studentListByCourse.get(j).getId() == id){
                    foundCourse.add(courseList.get(i));
                }
            }
        }
        return foundCourse;
    }
}
