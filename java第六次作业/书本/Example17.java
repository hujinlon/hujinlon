public class Example17 {
	public static void main(String[] args) {
		Storage st = new Storage(); // �������ݴ洢�����
		Input input = new Input(st);	// ����Input������Storage����
		Output output = new Output(st); 	// ����Output������Storage����
		new Thread(input).start();		// �������߳�
		new Thread(output).start();		// �������߳�
	}
}
class Input implements Runnable{		    // �����߳���
	private Storage st ;
     private int num;                           // ����һ������num 
	Input(Storage st){                         // ͨ�����췽������һ��Storage����
		this.st = st;
	}
	public void run(){        
		while(true){
			st.put(num++);                   // ��num�������飬ÿ�δ����num����
		}
	}
}

class Output implements Runnable{	       //����߳���
	private Storage st ;
	Output(Storage st){
		this.st = st;
	}
	public void run(){
		while(true){
			st.get();
		}
	}
}

class Storage {
	private int[] cells = new int[10];   // ���ݴ洢����
	private int inPos, outPos;            // inPos����ʱ�����±꣬outPosȡ��ʱ�����±�
	private int count;                      // �������ȡ�����ݵ�����
	public synchronized void put(int num) {
		try {
			// ����������ݵ���cells�ĳ��ȣ����̵߳ȴ�
			while (count == cells.length) {
				this.wait();
			}
			cells[inPos] = num;          // �������з�������
			System.out.println("��cells[" + inPos + "]�з�������---" + cells[inPos]);
			inPos++;// ����Ԫ����λ�ü�1
			if (inPos == cells.length) // ����cells[9]�������ݺ��ٴ�cells[0]��ʼ
				inPos = 0;
			count++; // ÿ��һ������count��1
			this.notify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public synchronized void get() {
		try {
			while (count == 0) {          // ��� countΪ0�����̵߳ȴ�
				this.wait();
			}
			int data = cells[outPos];    // ��������ȡ������
			System.out.println("��cells[" + outPos + "]��ȡ������" + data);
			cells[outPos] = 0;            // ȡ���󣬵�ǰλ�õ�������0
			outPos++;                       // ȡ��Ԫ����λ�ü�1
			if (outPos == cells.length) // ����cells[9]ȡ�����ݺ��ٴ�cells[0]��ʼ
				outPos = 0;
			count--;                        // ÿȡ��һ��Ԫ��count��1
			this.notify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
