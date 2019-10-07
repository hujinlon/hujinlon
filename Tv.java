package tv;
public abstract class Tv{
	public abstract void play();
}
public class HaierTv extends Tv{
	public void play() {
		System.out.println("This is HaierTv.");
	}
}
public class HisenseTv extends Tv{
	public void play() {
		System.out.println("This is HisenseTv.");
	}
}