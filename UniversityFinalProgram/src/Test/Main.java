package Test;

import Data.*;

import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static University myUniversity = new University();
    static Course myCourse = new Course();
    static Student myStudent = new Student();

    public static void main(String[] args) {
        myUniversity.listInitialization();
        String optionToContinue;
        do {
            System.out.println("Welcome to the " + myUniversity.getUniversityName());
            System.out.println("---------------------------------------------------");
            System.out.println("Select an option to proceed with the Operation");
            System.out.println("1. Add a new student" + "\n" +
                    "2. Add a new professor" + "\n" +
                    "3. Add a new course" + "\n" +
                    "4. Print all professors data" + "\n" +
                    "5. Print all courses" + "\n" +
                    "6. Print courses by student" + "\n" +
                    "7. Close Program" + "\n");
            System.out.println("Input the process you want to follow");
            int option = sc.nextInt();
            sc.nextLine();

            if(option == 1){
                Student myStudent = addStudent();
                myUniversity.setStudentList(myStudent);
                System.out.println("Search the courses available to add the new student");
                printCourseList();
                System.out.println("Which course do you want to assign the student to?");
                sc.nextLine();
                String courseOption = sc.nextLine();
                System.out.println(myCourse.addStudentToExistingCourse(myUniversity.courseList, courseOption, myStudent));
            }else if(option == 2){
                try {
                    myUniversity.setTeacherList(addTeacher());
                    System.out.println("Teacher created at the university");
                }catch (Exception e){
                    System.out.println("Teacher was not created at the university");
                }
            }else if(option == 3){
                try {
                    myUniversity.setCourseList(addCourse());
                    System.out.println("Student added to the university");
                }catch (Exception e){
                    System.out.println("Student was not added to the university");
                }
            }else if(option == 4){
                printTeacherList();
            }else if(option == 5){
                printCoursesDataAlphabetically();
            }else if(option == 6){
                printCoursesByStudentId();
                sc.nextLine();
            }else if (option == 7){
                System.exit(0);
            }else{
                System.out.println("Option not available");
            }

            System.out.println("\n" + "Do you want to continue? Y/N");
            optionToContinue = sc.nextLine().toUpperCase(Locale.ROOT);
        }while (optionToContinue.equals("Y"));
    }

    public static Student addStudent(){
        Student newStudent;
        System.out.println("Add student's first name");
        String firstName = sc.nextLine();
        System.out.println("Add students's last name");
        String lastName = sc.nextLine();
        System.out.println("How old is the student?");
        int age = sc.nextInt();
        newStudent = new Student(firstName, lastName, age);
        return newStudent;
    }

    public static Teacher addTeacher(){
        Teacher newTeacher = null;
        System.out.println("Add professor's first name");
        String firstName = sc.nextLine();
        System.out.println("Add professor's last name");
        String lastName = sc.nextLine();
        System.out.println("What is the base salary?");
        double baseSalary = sc.nextDouble();
        sc.nextLine();
        System.out.println("Is she/he a full time professor? Y/N");
        String isFullTime = sc.nextLine().toUpperCase(Locale.ROOT);
        boolean isFullTimeCast = false;
        double yearsOfExperience = 0;
        double hoursPerWeek = 0;
        if (isFullTime.equals("Y")){
            isFullTimeCast = true;
            System.out.println("How many years of experience does the professor have?");
            yearsOfExperience = sc.nextDouble();
            newTeacher = new FullTimeTeacher(firstName, lastName, baseSalary, isFullTimeCast, yearsOfExperience);
        }else if(isFullTime.equals("N")){
            isFullTimeCast = false;
            System.out.println("How many hours a week does the professor work?");
            hoursPerWeek = sc.nextDouble();
            newTeacher = new PartTimeTeacher(firstName, lastName, baseSalary, isFullTimeCast, hoursPerWeek);
        }else{
            System.out.println("Option not supported");
        }
        sc.nextLine();
        return newTeacher;
    }

    public static Course addCourse(){
        Course newCourse;
        System.out.println("What is the name of the course");
        String name = sc.nextLine();
        String nameCapitalized = name.substring(0, 1).toUpperCase(Locale.ROOT) + name.substring(1);
        System.out.println("What is the assigned classroom number?");
        int assignedClassroom = sc.nextInt();
        sc.nextLine();
        System.out.println("Select the teacher you want to assign to this course");
        printTeacherList();
        System.out.println("Type the professor's ID");
        int professorID = sc.nextInt();
        System.out.println("Select the students you want to be in this course");
        printStudentList();
        System.out.println("How many students will be added to this course");
        int studentNumber = sc.nextInt();
        int i = 0;
        while (i < studentNumber){
            System.out.println("Type the student Id");
            int id = sc.nextInt();
            myCourse.addStudentToCourse(myUniversity.studentList, id);
            i++;
        }
        sc.nextLine();
        newCourse = new Course(nameCapitalized, assignedClassroom, myCourse.addTeacherToCourse(myUniversity.teacherList, professorID),
                myCourse.foundStudentInList);
        return newCourse;
    }

    public static void printTeacherList(){
        System.out.format("%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID","First Name", "Last Name", "Base salary", "Full Time", "Salary");
        for (int i = 0; i < myUniversity.getTeacherList(myUniversity.teacherList).size(); i++) {
            System.out.format("%-15s%-15s%-15s%-15s%-15s%-15s\n", myUniversity.getTeacherList(myUniversity.teacherList).get(i).getId(),myUniversity.getTeacherList(myUniversity.teacherList).get(i).getFirstName(),
                    myUniversity.getTeacherList(myUniversity.teacherList).get(i).getLastName(), myUniversity.getTeacherList(myUniversity.teacherList).get(i).getBaseSalary(),
                    myUniversity.getTeacherList(myUniversity.teacherList).get(i).isFulltime(), myUniversity.getTeacherList(myUniversity.teacherList).get(i).getSalary());
        }
    }

    public static void printStudentList(){
        System.out.format("%-25s%-25s%-25s%-25s\n", "Student Id", "Student First Name", "Student Last Name", "Student Age");
        for (int i = 0; i < myUniversity.getStudentList(myUniversity.studentList).size(); i++) {
            System.out.format("%-25s%-25s%-25s%-25s\n", myUniversity.getStudentList(myUniversity.studentList).get(i).getId(),
                    myUniversity.getStudentList(myUniversity.studentList).get(i).getFirstName(), myUniversity.getStudentList(myUniversity.studentList).get(i).getLastName(),
                    myUniversity.getStudentList(myUniversity.studentList).get(i).getAge());
        }
    }

    public static void printCourseList(){
        System.out.format("%-15s%-15s%-15s\n", "Course", "Classroom", "Teacher");
        for (int i = 0; i < myUniversity.getCourseList(myUniversity.courseList).size(); i++) {
            System.out.format("%-15s%-15s%-15s\n", myUniversity.getCourseList(myUniversity.courseList).get(i).getCourseName(),
                    myUniversity.getCourseList(myUniversity.courseList).get(i).getAssignedClassroom(),
                    myUniversity.getCourseList(myUniversity.courseList).get(i).getTeacher().getFirstName() + " " +
                            myUniversity.getCourseList(myUniversity.courseList).get(i).getTeacher().getLastName());
        }
    }

    public static void printCoursesDataAlphabetically(){
        System.out.println("See the courses in alphabetical orden");
        Collections.sort(myUniversity.courseList);
        System.out.format("%-15s%-15s%-15s%-15s\n", "ID","Course", "Classroom", "Teacher");
        for (int i = 0; i < myUniversity.courseList.size(); i++) {
            System.out.format("%-15s%-15s%-15s%-15s\n", myUniversity.courseList.get(i).getId(),myUniversity.courseList.get(i).getCourseName(),
                                    myUniversity.courseList.get(i).getAssignedClassroom(),
                                    myUniversity.courseList.get(i).getTeacher().getFirstName() + " "
                                    + myUniversity.courseList.get(i).getTeacher().getLastName());
        }
        System.out.println("Type the course ID to see its data");
        int courseId = sc.nextInt();
        if (myUniversity.searchCourseData(courseId).getId() == courseId){
            System.out.format("%-15s%-15s%-15s\n","Course", "Classroom", "Teacher");
            System.out.format("%-15s%-15s%-15s\n",myUniversity.searchCourseData(courseId).getCourseName(),
                    myUniversity.searchCourseData(courseId).getAssignedClassroom(), myUniversity.searchCourseData(courseId).getTeacher().getFirstName() + " " +
                            myUniversity.searchCourseData(courseId).getTeacher().getLastName());
            System.out.format("%-15s%-15s%15s\n", "student Id", "Student Name", "Age");
            for (int i = 0; i < myUniversity.searchCourseData(courseId).getStudentListByCourse().size(); i++) {
                System.out.format("%-15s%-15s%15s\n", myUniversity.searchCourseData(courseId).getStudentListByCourse().get(i).getId(),
                        myUniversity.searchCourseData(courseId).getStudentListByCourse().get(i).getFirstName() + " " +
                                myUniversity.searchCourseData(courseId).getStudentListByCourse().get(i).getLastName(),
                                myUniversity.searchCourseData(courseId).getStudentListByCourse().get(i).getAge());
                    }
            sc.nextLine();
        }else{
            System.out.println("Course was not found. Try another ID");
            sc.nextLine();
        }
    }

    public static void printCoursesByStudentId(){
        System.out.println("Select the student to see her/his course");
        printStudentList();
        System.out.println("Type the student ID");
        int studentId = sc.nextInt();
        myStudent.getAllCourseListById(myUniversity.courseList,studentId);
        System.out.format("%-15s%-15s%-15s\n", "Course", "Classroom", "Teacher");
        for (int i = 0; i < myStudent.foundCourse.size(); i++) {
            System.out.format("%-15s%-15s%-15s\n", myStudent.foundCourse.get(i).getCourseName(),
                    myStudent.foundCourse.get(i).getAssignedClassroom(),
                    myStudent.foundCourse.get(i).getTeacher().getFirstName() + " "
                            + myStudent.foundCourse.get(i).getTeacher().getLastName());
        }
    }
}
