package Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Course implements Comparable<Course> {

    private String courseName;
    private int assignedClassroom;
    public Teacher teacher;
    public List<Student> studentListByCourse;
    public List<Student> foundStudentInList = new ArrayList<>();
    private int id;
    private static int counter = 1;

    public Course() {
    }

    public Course(String courseName, int assignedClassroom, Teacher teacher, List<Student> studentListByCourse) {
        this.courseName = courseName;
        this.assignedClassroom = assignedClassroom;
        this.teacher = teacher;
        this.studentListByCourse = studentListByCourse;
        this.id = counter;
        this.counter++;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getAssignedClassroom() {
        return assignedClassroom;
    }

    public void setAssignedClassroom(int assignedClassroom) {
        this.assignedClassroom = assignedClassroom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentListByCourse() {
        return studentListByCourse;
    }

    public void setStudentListByCourse(List<Student> studentListByCourse) {
        this.studentListByCourse = studentListByCourse;
    }

    public int getId() {
        return id;
    }

    public List<Course> courseInitialization(Teacher fullTimeTeacher, Teacher partTimeTeacher ,List<Student> students){
        List<Course> courseListInit = new ArrayList<>();
        courseListInit.add( new Course("Math", 201, fullTimeTeacher,
                new ArrayList<Student>(Arrays.asList(students.get(0), students.get(1)))));
        courseListInit.add( new Course("Biology", 101, partTimeTeacher,
                new ArrayList<Student>(Arrays.asList(students.get(1), students.get(2)))));
        courseListInit.add( new Course("English", 303, partTimeTeacher,
                new ArrayList<Student>(Arrays.asList(students.get(2), students.get(3)))));
        courseListInit.add( new Course("Science", 505, fullTimeTeacher,
                new ArrayList<Student>(Arrays.asList(students.get(3), students.get(4)))));
        courseListInit.add( new Course("Design", 404, partTimeTeacher,
                new ArrayList<Student>(Arrays.asList(students.get(4), students.get(5)))));
        return courseListInit;
    }

    public String addStudentToExistingCourse(List<Course> courseList, String courseNameInput,Student studentToAdd){
        Course foundCourse;
        for (Course course: courseList) {
            if (course.getCourseName().equals(courseNameInput)){
                foundCourse = course;
                foundCourse.studentListByCourse.add(studentToAdd);
                return "Student was added to course " + courseNameInput;
            }
        }
        return "Student was not added to the indicated course. Type the correct course name";
    }

    public Teacher addTeacherToCourse(List<Teacher> teacherList, int id){
        Teacher foundTeacher = null;
        for (Teacher teacher:teacherList){
            if (teacher.getId() == id){
                foundTeacher = teacher;
            }
        }
        return foundTeacher;
    }

    public List<Student> addStudentToCourse(List<Student> studentList, int id){
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id){
                foundStudentInList.add(studentList.get(i));
            }
        }
        return foundStudentInList;
    }

    @Override
    public int compareTo(Course o) {
        return this.getCourseName().compareTo(o.getCourseName());
    }
}

