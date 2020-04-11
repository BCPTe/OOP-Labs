package university;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
import java.util.Arrays;

public class UniversityExt extends University {
	private Student topThree[];
	Logger logger = Logger.getLogger("University");

	public UniversityExt(String name) throws IOException{
		super(name);
		topThree=new Student[3];
		for(int i=0 ; i<3 ; i++)
			topThree[i]=new Student(null, null, -1);
		FileHandler handler = new FileHandler("university.txt");
		
		handler.setFormatter(new SimpleFormatter());
		logger.addHandler(handler);
		
		// Example of logging
		logger.info("Creating extended university object");
	}
	
	public void exam(int studentID, int courseID, int grade) {
		Student s=studenti[studentID-10000];
		Course c=corsi[courseID-10];
		s.addExam(c, grade);
		c.F5avg(grade);
		
		logger.info("Student " + studentID + " took an exam in course " + courseID + " with grade " + grade);
	}

	/**
	 * Retrieves the avg of the student
	 * @param studentID id of the student 
	 * @return a string with the studentID and the avg
	 */
	public String studentAvg(int studentID) {
		Student s=studenti[studentID-10000];
		
		if(s.getTotVoti()==0) 
			return "Student " + studentID + " " + "hasn't taken any exams";
		
		return "Student " + studentID + ": " + s.getAvg();
	}
	
	/**
	 * Retrieves the avg of the course
	 * @param courseID id of the course
	 * @return a string with the NAME of the course and the avg
	 */
	public String courseAvg(int courseID) {
		Course c=corsi[courseID-10];
		if(c.getTotExaminated()==0)
			return "No student has taken the exam in " + c.getTitle();
		
		return "The average for the course " + c.getTitle() + " is: " + c.getAvg();
	}
	
	public String topThreeStudents() {
		Student tmp[]=new Student[MAX_STUDENTI];
		for(int i=0 ; i<totStudents ; i++)
			tmp[i]=studenti[i];
		Arrays.sort(tmp, 0, totStudents);
		
		StringBuffer str=new StringBuffer();
		for(int i=0 ; i<3 ; i++) {
			if(tmp[i]!=null)
				str.append(tmp[i].getFullName() + ": " + tmp[i].getScore() + "\n");
			else
				str.append("NONE\n");
		}
		
		return str.toString();
	}
	
	@Override
	public int enroll(String first, String last){
		
		studenti[totStudents]=new Student(first, last, totStudents);
		totStudents++;
		
		logger.info("New student enrolled: " + studenti[totStudents-1].getMatricola() + " " + studenti[totStudents-1].getFullName());
		
		return studenti[totStudents-1].getMatricola();
	}
	
	@Override
	public int activate(String title, String teacher){

		corsi[totCourses]=new Course(title, teacher, totCourses);
		totCourses++;
		
		logger.info("New course activated: " + corsi[totCourses-1].getCode() + " " + corsi[totCourses-1].getTitle());
		
		return corsi[totCourses-1].getCode();
	}
	
	@Override
	public void register(int studentID, int courseCode){
		studenti[studentID-10000].addCorso(getCorso(courseCode));
		getCorso(courseCode).addStdToCourse(studenti[studentID-10000]);
		
		logger.info("Student " + studentID + " signed up for course " + courseCode);
	}
}
