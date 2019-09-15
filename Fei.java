public class Fei{
	public static void main(String[] args) {
		Father.Child children=new Father().new Child();
		children.introFather();
	}

}
class Father{
    public String name="zhangjun";
       public class  Child{
              public void introFather(){ 
		System.out.println("ĞÕÃû:"+name);
		}
	}
}