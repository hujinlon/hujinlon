package factory;
import car.Audi;
import car.Car;

public class AudiFactory implements Factory{

		public Car proudctCar() {
		
		return new Audi();
	}  
}
 