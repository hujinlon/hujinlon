package main;

import car.Car;
import factory.Factory;
import xml.ReadXMLUitilcar;

class Input implements Runnable {
	private Storage st;
	private int num;  

	Input(Storage st) { 
		this.st = st;
	}

	public void run() {
		while (num<5) {
			st.put();
			num++;
		}
	}
}

class Output implements Runnable { 
	private Storage st;
int num;
	Output(Storage st) {
		this.st = st;
	}

	public void run() {
		while (num<5) {
			st.get();
			num++;
			
		}
	}

}

class Storage {
	private Car[] cells = new Car[10];

	public void chu() {
		Factory carFactroy = (Factory) ReadXMLUitilcar.getBrandName();
		 int i;
		for (i = 0; i < 10; i++) {
			cells[i] = carFactroy.proudctCar();
		}

	}

	private int inPos, outPos,count;

	public synchronized void put() {
		try {
			while(count==cells.length) {
				this.wait();
			}
			System.out.println("车辆" + inPos + "，" + cells[inPos].toString() + "入库");
			inPos++;
			if (inPos == cells.length) 
				inPos = 0;
			count++; 
			this.notify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized void get() {
		try {
			while (outPos == inPos) {
				this.wait();
			}
			System.out.println("车辆" + outPos + "," + cells[outPos].toString() + " 出库。计算费率 " + cells[outPos].fei());
			outPos += 1; 
			if (outPos == cells.length) 
				outPos = 0;
			count--; 
			this.notify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}