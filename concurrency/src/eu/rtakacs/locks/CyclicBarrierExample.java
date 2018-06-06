package eu.rtakacs.locks;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

	  private static class Task1 implements Runnable {
	    CyclicBarrier barrier;
	    
	    Task1(CyclicBarrier barrier) {
	      this.barrier = barrier;
	    }
	    
	    @Override
	    public void run() {
	      System.out.println("Starting Task1.");
	      try {
	        Thread.sleep(2000);
	        System.out.println("Task1 has finisched its work, waiting for others.");
	        barrier.await();
	      } catch (InterruptedException | BrokenBarrierException e) {
	        e.printStackTrace();
	      } 
	      System.out.println("Completing Task1.");
	    }
	  }
	  
	  private static class Task2 implements Runnable {
	    CyclicBarrier barrier;
	    
	    Task2(CyclicBarrier barrier) {
	      this.barrier = barrier;
	    }
	    
	    @Override
	    public void run() {
	      System.out.println("Starting Task2.");
	      try {
	        Thread.sleep(3000);
	        System.out.println("Task2 has finisched its work, waiting for others.");
	        barrier.await();
	      } catch (InterruptedException | BrokenBarrierException e) {
	        e.printStackTrace();
	      }
	      System.out.println("Completing Task2.");
	    }
	  }
	  
	  private static class BarrierTask implements Runnable{

		@Override
		public void run() {
			System.out.println("BarrierTask running from CyclicBarrier.");
		}

	  }
	  
	  public static void main(String[] args) {
	    CyclicBarrier barrier = new CyclicBarrier(3, new BarrierTask());
	    Thread t1 = new Thread(new Task1(barrier));
	    Thread t2 = new Thread(new Task2(barrier));
	    
	    System.out.println("Starting both tasks at " + LocalDateTime.now());
	    t1.start();
	    t2.start();
	    
	    try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	    
	    System.out.println("Ending both tasks at " + LocalDateTime.now());
	  }
	}
