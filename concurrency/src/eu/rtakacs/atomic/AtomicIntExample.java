package eu.rtakacs.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntExample {
	
	AtomicInteger m_atomicInteger = new AtomicInteger(0);
	AtomicIntegerArray m_atomicIntegerArray = new AtomicIntegerArray(30);
	public int count = 0;
	
	public static void main(String[] args) {
		
		AtomicIntExample example = new AtomicIntExample();
		Constant constant = new Constant();
		
		Updater u1 = new Updater(example.m_atomicInteger, example.m_atomicIntegerArray,  0, constant);
		Updater u2 = new Updater(example.m_atomicInteger, example.m_atomicIntegerArray, 10, constant);
		Updater u3 = new Updater(example.m_atomicInteger, example.m_atomicIntegerArray, 20, constant);
		
		Thread t1 = new Thread(u1);
		Thread t2 = new Thread(u2);
		Thread t3 = new Thread(u3);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println(example.m_atomicIntegerArray);
		System.out.println("Constant.count = " + constant.count);

		
		
		
	}

}

class Updater implements Runnable{
	
	private AtomicInteger atomicInteger;
	private AtomicIntegerArray atomicIntegerArray;
	private int startFrom;
	private Constant constant;
	private AtomicIntegerFieldUpdater<Constant> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Constant.class, "count");
	
	Updater(AtomicInteger atomicInteger, AtomicIntegerArray atomicIntegerArray, int startFrom, Constant constant){
		this.atomicInteger = atomicInteger;
		this.atomicIntegerArray = atomicIntegerArray;
		this.startFrom = startFrom;
		this.constant = constant;
	}
	
	@Override
	public void run() {
		for(int i=this.startFrom;i<this.startFrom+10;i++) {
			int currentValue = this.atomicInteger.incrementAndGet();
			System.out.println(Thread.currentThread().getName() + " " + currentValue);
			
			this.atomicIntegerArray.set(i, currentValue);
			this.fieldUpdater.addAndGet(this.constant, currentValue);
			
			Thread.yield();
		}
	}
}

class Constant {
	public volatile int count = 0;
}
