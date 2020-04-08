package university;

public class Exam {
	private int points;
	private Course course;
	
	public Exam(int grade, Course Crs) {
		points=grade;
		course=Crs;
	}
	
	public int getPoints() {
		return points;
	}
}
