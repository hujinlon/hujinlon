public class Example03 {
    public static void main(String[] args) {
		Teacher ti=new Teacher();
		new Thread(ti,"老师1").start();
		new Thread(ti,"老师2").start();
		new Thread(ti,"老师3").start();
	}
}
class Teacher implements Runnable{
	public void run() {
		for(int i=1;i<=80;i++){
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"正在发放第"+i+"本作业");
		}
}
}