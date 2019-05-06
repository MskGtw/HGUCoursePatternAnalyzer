package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	int numOfStudents;
	int numOfCourses;
	Student[] students;
	Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
		
		students = initiateStudentArrayFromLines(lines);
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}

		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}

	}
	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */

	private Student[] initiateStudentArrayFromLines(String[] lines) {
		// TODO: implement this method
		int j = 0;
		
		Student[] forCompare;
		
		students = new Student[numOfStudents];
		forCompare = new Student[lines.length];
		
		for(int i =0;i<numOfStudents;i++)
			students[i] = new Student("trashValue");	
			
		for(int i =0;i<lines.length;i++) {
			
				forCompare[i] = new Student(lines[i].split(",")[1].trim());
				
					if(studentExist(students, forCompare[i])) {
						
						students[j] = new Student(lines[i].split(",")[1].trim());
						j++;
					}
					
		}
		
		return students;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
 
	private boolean studentExist(Student[] students, Student student) {
		
		for(Student std:students) {
			if((std.getName()).equals(student.getName())) {
				return false;
			}
		}
		return true;
		
	}

	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */

	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		int j = 0;
		
		Course[] forCompare;
		
		courses = new Course[numOfCourses];
		forCompare = new Course[lines.length];
		
		for(int i =0;i<numOfCourses;i++)
			courses[i] = new Course("trashValue");	
			
		for(int i =0;i<lines.length;i++) {
				forCompare[i] = new Course(lines[i].split(",")[2].trim());
					if(courseExist(courses, forCompare[i])) {
						courses[j] = new Course(lines[i].split(",")[2].trim());
						j++;
					}
					
		}
		
		return courses;
	
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */

	private boolean courseExist(Course[] courses, Course course) {
		
		for(Course crs:courses) {
			if((crs.getCourseName()).equals(course.getCourseName())) {
				return false;
			}
		}
		return true;
	}

}
