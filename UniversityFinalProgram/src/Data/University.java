package Data;

import java.util.*;

public class University {

    private String universityName = "University of Technology";
    public List<Teacher> teacherList;
    public List<Student> studentList;
    public List<Course> courseList;

    public University(){
        teacherList = new ArrayList<>();
        studentList = new ArrayList<>();
        courseList = new ArrayList<>();
    }

    public String getUniversityName() {
        return universityName;
    }

    public void listInitialization(){
        FullTimeTeacher fullTimeTeacher = new FullTimeTeacher();
        PartTimeTeacher partTimeTeacher = new PartTimeTeacher();
        Student student = new Student();
        Course course = new Course();
        teacherList.add(fullTimeTeacher.FullTimeTeacherInit());
        teacherList.add(partTimeTeacher.ParTimeTeacherInit());
        studentList.addAll(student.studentInitialization());
        courseList.addAll(course.courseInitialization(teacherList.get(0), teacherList.get(1),studentList));
    }

    public void setTeacherList(Teacher teacher){
        this.teacherList.add(teacher);
    }

    public List<Teacher> getTeacherList(List<Teacher> teacherList){
        return teacherList;
    }

    public void setStudentList(Student student){
        try {
            this.studentList.add(student);
            System.out.println("Student added to the university");
        }catch(Exception e) {
            System.out.println("Student was not added at the university");
        }
    }

    public List<Student> getStudentList(List<Student> studentList){
        return studentList;
    }

    public void setCourseList(Course course){
        this.courseList.add(course);
    }

    public List<Course> getCourseList(List<Course> courseList){
        return courseList;
    }

    public Course searchCourseData(int id){
        Course foundCourse = new Course();
        for (Course course:this.courseList) {
            if (course.getId() == id){
                foundCourse = course;
            }
        }
        return foundCourse;
    }

}
