package xiaoshou;
import xiaoshou.*;
import java.util.Random;
public class Hu {
    public static void main(String[] args){
    	Random r=new Random();
      Storage st=new Storage();
      Input input=new Input(st);
      Output output =new Output(st);
      new Thread(input).start();
      new Thread(output).start();
    }
}
