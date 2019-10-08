package factory;
import factory.*;
public class HaierTVFactory implement TVFactory{
	public TV produceTV() {
		return new HaierTV();
	}
}