class Single{
	private static Single INSTANCE=new Single();
	private Single() {}
	public static Single getInstance() {
		return INSTANCE;
	}
}
public class Dan {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
      Single s1=Single.getInstance();
      Single s2=Single.getInstance();   
      System.out.println(s1==s2);
	}

}
