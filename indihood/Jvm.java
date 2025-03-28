package indihood;

public class Jvm {
	
	String empName;
	int empId;
	char grade;
	
	
	
	public Jvm(String empName, int empId, char grade) {
		this.empName = empName;
		this.empId = empId;
		this.grade = grade;
	}

	public static void main(String[] args) {
		Jvm jvm = new Jvm("pavan",123,'A') ;
			System.out.println(jvm.empName);
			System.out.println(jvm.empId);
			System.out.println(jvm.grade);
		
	}

}
