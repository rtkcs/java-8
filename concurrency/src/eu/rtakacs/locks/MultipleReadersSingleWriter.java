package eu.rtakacs.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MultipleReadersSingleWriter {
	
	private final List<String> list = new ArrayList<>();
	
	private final ReadWriteLock rwl = new ReentrantReadWriteLock();
	private final Lock rLock = rwl.readLock();
	private final Lock wLock = rwl.writeLock();
	
	public String read() {
		rLock.lock();
		try {
			
			if(list.isEmpty()) {
				System.out.println("----Reading null");
				return null;
			}
			String s = list.remove(0);
			System.out.println("-Reading " + s);
			return s;
			
		}finally {
			rLock.unlock();
		}
	}
	
	public void write(String data) {
		wLock.lock();
		try {
			System.out.println("Written " + data);
			list.add(data);
		}finally {
			wLock.unlock();
		}
	}
	
	
	public static void main(String[] args) {
		
		MultipleReadersSingleWriter mrsw = new MultipleReadersSingleWriter();
		
		Runnable r1 = () -> {mrsw.write("one");};
		Runnable r2 = () -> {mrsw.write("two");};
		Runnable r3 = () -> {mrsw.write("three");};
		
		Runnable r4 = () -> {mrsw.read();};
		Runnable r5 = () -> {mrsw.read();};
		Runnable r6 = () -> {mrsw.read();};
		Runnable r7 = () -> {mrsw.read();};
		Runnable r8 = () -> {mrsw.read();};
		
		ExecutorService service = Executors.newCachedThreadPool();
		service.submit(r1);
		service.submit(r2);
		service.submit(r3);
		service.submit(r4);
		service.submit(r5);
		service.submit(r6);
		service.submit(r7);
		service.submit(r8);
		
		
		mrsw.write("first");
		mrsw.write("second");
		mrsw.write("third");
		
		mrsw.read();
		mrsw.read();
		mrsw.read();
	}
}


