public class Example01 {
	public static void main(String[] args) {
		MyThread ti=new MyThread();
                                new Thread(ti,"张三").start();
		new Thread(ti,"李四").start();
	}
}
class MyThread extends Thread{
	public void run() {
		Thread th=Thread.currentThread();
		String th_name=th.getName();
		System.out.println(th_name);
	}
}