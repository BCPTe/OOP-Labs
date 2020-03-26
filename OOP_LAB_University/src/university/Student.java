package university;

public class Student {
	String name;
	String surname;
	int id;
	private int totCorsiSeguiti;
	Course corsiSeguiti[];
	
	private final static int MAX_CORSI_STD=25;
	
	/**
	 * Add a student in the current University
	 * @param first first name
	 * @param last surname
	 * @param i id
	 */
	public Student(String first, String last, int i) {
		name=first;
		surname=last;
		id=10000+i;
		totCorsiSeguiti=0;
		corsiSeguiti=new Course[MAX_CORSI_STD];
	}
	
	public int getMatricola() {
		return id;
	}
	
	public String getFullName() {
		return name + " " + surname;
	}
	
	public String StdToString() {
		return id + " " + name + " " + surname;
	}
	
	public void addCorso(int code) {
		corsiSeguiti[totCorsiSeguiti]=University.getCorso(code);
		
		totCorsiSeguiti++;
	}
	
	public String getCourses() {
		StringBuffer str=new StringBuffer();
		
		for(Course c : corsiSeguiti) {
			if(c==null)
				break;
			str.append(c.CourseToString() + "\n");
		}
		
		return str.toString();
	}

}
