import university.UniversityExt;
import java.io.IOException;

public class ExampleApp {

	public static void main(String[] args) throws IOException {
		
		String universityName = "Politecnico di Torino";
		
		UniversityExt poli = new UniversityExt(universityName);
		
		poli.setRector("Guido", "Saracco");
		
		System.out.println("Rector of " + poli.getName() + " : " + poli.getRector()); // Guido Saracco
		
		int s1 = poli.enroll("Mario","Rossi");
		int s2 = poli.enroll("Giuseppe","Verdi");
		int s3 = poli.enroll("Take", "Away");
		int s4 = poli.enroll("Giorgio", "Africano");
		
		System.out.println("Enrolled students " + s1 + ", " + s2 + ", " + s3 + ", " + s4); // 10000, 10001, 10002, 10003
		System.out.println("s1 = " + poli.student(s1)); // 10000 Mario Rossi
		
		int macro = poli.activate("Macro Economics", "Paul Krugman");
		int oop = poli.activate("Object Oriented Programming", "James Gosling");
		
		System.out.println("Activated courses " + macro + " and " + oop); // 10 and 11
		//poli.register(s1, macro);
		poli.register(s2, macro);
		poli.register(s2, oop);
		poli.register(s3, macro);
		poli.register(s3, oop);
		poli.register(s4, oop);
		poli.register(s4, macro);
		
		System.out.println("List Attendes " + macro + ":\n" + poli.listAttendees(macro));
		// 10000 Mario Rossi
		// 10001 Giuseppe Verdi
		
		System.out.println("Study Plan s2:\n" + poli.studyPlan(s2));
		// 10,Macro Economics,Paul Krugman
		// 11,Object Oriented Programming,Marco Torchiano
		
		poli.exam(s2, oop, 68);
		poli.exam(s2, macro, 89);
		poli.exam(s1, oop, 55);
		poli.exam(s3, oop, 57);
		poli.exam(s4, oop, 69);
		poli.exam(s4, macro, 98);
		System.out.println(poli.studentAvg(s1));
		System.out.println(poli.studentAvg(s2));
		System.out.println(poli.studentAvg(s3));
		System.out.println(poli.studentAvg(s4));
		
		System.out.println(poli.courseAvg(macro));
		System.out.println(poli.courseAvg(oop));
		
		System.out.println("\nTop Three:\n" + poli.topThreeStudents());
	}
}
