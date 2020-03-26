package university;

public class Course {
	String title;
	String teacher;
	int code;
	private int totIscritti;
	Student iscritti[];
	
	private final static int MAX_STD_CORSO=100;
	
	/**
	 * Add a course in the current University
	 * @param title title of the course
	 * @param teacher	teacher of the course
	 * @param code code of the course
	 */
	public Course(String title, String teacher, int code) {
		this.title=title;
		this.teacher=teacher;
		this.code=10+code;
		this.totIscritti=0;
		this.iscritti=new Student[MAX_STD_CORSO];
	}
	
	public int getCode() {
		return code;
	}
	
	public String CourseToString() {
		return code + "," + title + "," + teacher;
	}
	
	public void addStdToCourse(Student std) {
		this.iscritti[totIscritti]=std;
		totIscritti++;
	}
	
	public String getIscritti() {
		StringBuffer str=new StringBuffer();
		
		for(Student s : iscritti) {
			if(s==null)
				break;
			str.append(s.getMatricola() + " " + s.getFullName() + "\n");
		}
		
		return str.toString();
	}
}
