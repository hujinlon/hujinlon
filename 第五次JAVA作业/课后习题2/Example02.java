public class Example02 {
    public static void main(String[] args) {
		new Thread(new Zu()).start();
                     for(int i=1;i<=100;i++)
                            System.out.println("main");
	}
}
class Zu implements Runnable{
	public void run() {
		for(int i=1;i<=50;i++){
				System.out.println("new");
		}
}
}