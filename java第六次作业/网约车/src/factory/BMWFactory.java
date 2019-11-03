package factory;
import car.BMW;
import car.Car;

public class BMWFactory implements Factory{
	public Car proudctCar() {		
		return new BMW();
	}
}
 