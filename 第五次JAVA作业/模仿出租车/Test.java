public class Test {
    public static void main(String[] args) {
		Taxi ti=new Taxi();
		new Thread(ti,"���⳵1").start();
		new Thread(ti,"���⳵2").start();
		new Thread(ti,"���⳵3").start();
		new Thread(ti,"���⳵4").start();
		new Thread(ti,"���⳵5").start();
	}
}
class Taxi implements Runnable{
	private int people=100;
	public void run() {
		while (true) {
			if(people>0) {
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"���ڷ��۵�"+people--+"��Ʊ");
			}
		}
	}
}
