package eu.rtakacs.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
	
	private final ReentrantLock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		
		ReentrantLockExample example = new ReentrantLockExample();
		example.lock.lock();
		try{
			
			System.out.println( "lock.isHeldByCurrentThread() = " + example.lock.isHeldByCurrentThread());
			System.out.println( "lock.getHoldCount() = " + example.lock.getHoldCount());
			example.lock.lock();
			System.out.println( "lock.getHoldCount() = " + example.lock.getHoldCount());
			System.out.println( "lock.isLocked() = " + example.lock.isLocked());
			System.out.println( "lock.hasQueuedThreads() = " + example.lock.hasQueuedThreads());
			System.out.println( "lock.isFair() = " + example.lock.isFair());
//			System.out.println( " = " + example.lock.);
//			System.out.println( " = " + example.lock.);
//			System.out.println( " = " + example.lock.);
			
		} finally{
			example.lock.unlock();
			System.out.println( "lock.getHoldCount() = " + example.lock.getHoldCount());
			example.lock.unlock();
			System.out.println( "lock.getHoldCount() = " + example.lock.getHoldCount());
		}
	}

}
