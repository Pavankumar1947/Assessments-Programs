package indihood;



class Car {
    String brand;
    int speed;

    void display() {
        System.out.println("Brand: " + brand + ", Speed: " + speed);
    }
}

public class ClasasObject {
	public static void main(String[] args) {
		System.out.println("pavan");
		Car car = new Car();
		car.speed=250;
		car.brand="PUSHPA";
		car.display();
	}

}
