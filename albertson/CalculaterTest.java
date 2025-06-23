package albertson;



//Question:- write Unit Test for a method int dd(int a , int b) using J Unit

public class Calculater {
	public int add(int a, int b) {
		return a+b;
	}
}


public class CalculaterTest {
	@Test
	public void tesAdd() {
		Calculater calculater = new Calculater();
		int result = calculater.add(2, 3);
		assertEqual(5,result);
	}
}



