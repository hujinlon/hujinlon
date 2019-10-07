package factory;
public interface TVFactory{
	public TV produceTV();
}
public class HaierTVFactory implement TVFactory{
	public TV produceTV() {
		return new HaierTV();
	}
}
public class HisenseTVFactory implement TVFactory{
	public TV produceTV() {
		return new HisenseTV();
	}
}