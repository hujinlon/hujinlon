package factory;
import car.Benz;
import car.Car;

public class BenzFactory implements Factory{
	public Car proudctCar() {		
		return new Benz();
	}
}
 