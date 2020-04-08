package university;

public class Course {
	private String title;
	private String teacher;
	private int code;
	private int totIscritti;
	private Student iscritti[];
	private float examinated[];
	private int totExaminated;
	
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
		this.examinated=new float[MAX_STD_CORSO];
		this.totExaminated=0;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getTitle() {
		return title;
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
	
	public int getTotExaminated() {
		return this.totExaminated;
	}
	
	public void F5avg(int grade) {
		this.examinated[this.totExaminated]=grade;
		this.totExaminated++;
	}
	
	public float getAvg() {
		float avg=0;
		for(int i=0 ; i<this.totExaminated ; i++)
			avg+=this.examinated[i];
		avg/=this.totExaminated;
		
		return avg;
	}
}
