package indihood;

public class GarbageColletor {
	public static void main(String[] args) {
		System.out.println("prog Starts");
		
		for(int i=0; i<10000; i++) {
			GarbageColletor garbageColletor = new GarbageColletor();
		}
		
		System.out.println("Requesting G C");
		System.gc();
		System.out.println("End of program.");
		
		
		
	}

	public void finalize() {
		System.out.println("Garbage Collector is destroying an object...");
	}

}
