package university;

import java.util.logging.Logger;
import java.util.Arrays;

public class UniversityExt extends University {
	private Student topThree[];
	private final static Logger logger = Logger.getLogger("University");

	public UniversityExt(String name) {
		super(name);
		topThree=new Student[3];
		for(int i=0 ; i<3 ; i++)
			topThree[i]=new Student(null, null, -1);
		// Example of logging
		logger.info("Creating extended university object");
	}
	
	public void exam(int studentID, int courseID, int grade) {
		Student s=studenti[studentID-10000];
		Course c=corsi[courseID-10];
		s.addExam(c, grade);
		c.F5avg(grade);
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
		for(int i=0 ; i<3 ; i++) 
			str.append(tmp[i].getFullName() + ": " + tmp[i].getScore() + "\n");
		
		return str.toString();
	}
}
