package mavenier;

class EvenAdd implements Runnable{
	private int max;
	private Printer print;
	private boolean isEvenNumber;
	
	EvenAdd(Printer print,int max,boolean isEvenNumber) {
		this.print = print;
		this.max = max;
		this.isEvenNumber = isEvenNumber;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int number = isEvenNumber ? 2 : 1;
		while (number <= max) {
			if(isEvenNumber) {
				print.printEven(number);
			}else {
				print.printOdd(number);
			}
			number += 2;
		}
		
	}
	
	
	
	
}

class Printer{
	private boolean isOdd = false;

	synchronized void printEven(int number) {
		// TODO Auto-generated method stub
		while (!isOdd) {
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread even "+ number);
		isOdd =false;
		notifyAll();
	}

	synchronized void printOdd(int number) {
		// TODO Auto-generated method stub
		while (isOdd) {
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread odd "+ number);
		isOdd =true;
		notifyAll();
		
	}
	
}

public class EvenAddNumbers_usingThreads_MultithredProgram {
	
	static int MAX = 10;
	public static void main(String[] args) {
		Printer print = new Printer();
		Thread t1 = new Thread(new EvenAdd(print,MAX,false));
		Thread t2 = new Thread(new EvenAdd(print,MAX,true));
		
		t1.start();
		t2.start();
	}

}
