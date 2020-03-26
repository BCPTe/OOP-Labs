package university;

/**
 * This class represents a university education system.
 * 
 * It manages students and courses.
 *
 */
public class University {
	String name;
	String rector;
	private int totStudents;
	Student studenti[];
	private int totCourses;
	static Course corsi[];
	
	
	private final static int MAX_STUDENTI=1000;
	private final static int MAX_CORSI=50;
	
	/**
	 * Constructor
	 * @param name name of the university
	 */
	public University(String name){
		this.name=name;
		totStudents=0;
		studenti=new Student[MAX_STUDENTI];
		totCourses=0;
		corsi=new Course[MAX_CORSI];
	}
	
	/**
	 * Getter for the name of the university
	 * @return name of university
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Defines the rector for the university
	 * 
	 * @param first
	 * @param last
	 */
	public void setRector(String first, String last){
		rector=first + " " + last;
	}
	
	/**
	 * Retrieves the rector of the university
	 * 
	 * @return
	 */
	public String getRector(){
		return rector;
	}
	
	/**
	 * Enroll a student in the university
	 * 
	 * @param first first name of the student
	 * @param last last name of the student
	 * @return
	 */
	public int enroll(String first, String last){
		
		studenti[totStudents]=new Student(first, last, totStudents);
		totStudents++;
		
		return studenti[totStudents-1].getMatricola();
	}
	
	/**
	 * Retrieves the information for a given student
	 * 
	 * @param id the id of the student
	 * @return information about the student
	 */
	public String student(int id){
		return studenti[id-10000].StdToString();
	}
	
	/**
	 * Activates a new course with the given teacher
	 * 
	 * @param title title of the course
	 * @param teacher name of the teacher
	 * @return the unique code assigned to the course
	 */
	public int activate(String title, String teacher){

		corsi[totCourses]=new Course(title, teacher, totCourses);
		totCourses++;
		
		return corsi[totCourses-1].getCode();
	}
	
	/**
	 * Retrieve the information for a given course
	 * 
	 * @param code unique code of the course
	 * @return information about the course
	 */
	public String course(int code){
		return corsi[10-code].CourseToString();
	}
	
	/**
	 * Register a student to attend a course
	 * @param studentID id of the student
	 * @param courseCode id of the course
	 */
	public void register(int studentID, int courseCode){
		studenti[studentID-10000].addCorso(courseCode);
		getCorso(courseCode).addStdToCourse(studenti[studentID-10000]);
	}
	
	public static Course getCorso(int code) {
		return corsi[code-10];
	}
	
	/**
	 * Retrieve a list of attendees
	 * 
	 * @param courseCode unique id of the course
	 * @return list of attendees separated by "\n"
	 */
	public String listAttendees(int courseCode){
		return corsi[courseCode-10].getIscritti();
	}

	/**
	 * Retrieves the study plan for a student
	 * 
	 * @param studentID id of the student
	 * @return list of courses the student is registered for
	 */
	public String studyPlan(int studentID){
		return studenti[studentID-10000].getCourses();
	}
}
