package university;
import java.lang.Float;

public class Student implements Comparable<Object> {
	private String name;
	private String surname;
	private int id;
	private int totCorsiSeguiti;
	private Course corsiSeguiti[];
	private Exam votiEsami[];
	private int totVotiEsami;
	private float avg;
	
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
		totVotiEsami=0;
		votiEsami=new Exam[MAX_CORSI_STD];
		avg=0;
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
	
	public int getTotVoti() {
		return this.totVotiEsami;
	}
	
	public int getTotSeguiti() {
		return totCorsiSeguiti;
	}
	
	public float getAvg() {
		return avg;
	}
	
	public void addCorso(Course toAdd) {
		corsiSeguiti[totCorsiSeguiti]=toAdd;
		
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
	
	public void addExam(Course c, int grade) {
		this.votiEsami[this.totVotiEsami]=new Exam(grade, c);
		this.totVotiEsami++;
		avg=0;
		for(int i=0 ; i<this.totVotiEsami ; i++) {
			avg+=this.votiEsami[i].getPoints();
		}
		avg/=this.totVotiEsami;
	}

	public float getScore() {
		if(totCorsiSeguiti==0)
			return 0;
		return avg + (((float)totVotiEsami/totCorsiSeguiti)*10);
	}
	
	@Override
	public int compareTo(Object o) {
		return -((Float)this.getScore()).compareTo(((Float)((Student) o).getScore()));
	}
}
