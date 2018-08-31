package eu.rtakacs.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ComplicatedTask extends RecursiveTask<Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8397758696482806857L;
	int[] ia;
	int from;
	int to;
	
	public ComplicatedTask(int[] ia, int from, int to) {
		this.ia = ia;
		this.from = from;
		this.to = to;
	}
	
	@Override
	protected Integer compute() {
		
		if(from==to) {
			return transform(ia[from]);
		} else if(from+1==to){
			return transform(ia[from]) + transform(ia[to]);
		}else {
			int mid = (from+to)/2;
			ComplicatedTask newtask1 = new ComplicatedTask(ia, from, mid);
			ComplicatedTask newtask2 = new ComplicatedTask(ia, mid+1, to);
			
			newtask1.fork();
			int x = newtask2.compute();
			int y = newtask1.join();
			return x+y;
		}
	}
	
	public int transform(int ii){
		return ii*2;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7};
		int result = 0;
		
		ComplicatedTask ct = new ComplicatedTask(arr, 0, arr.length-1);
		ForkJoinPool fjp = ForkJoinPool.commonPool();
		
		result = fjp.invoke(ct);
		System.out.println("Result (invoke) = " + result);
		ForkJoinTask<Integer> fjt =  fjp.submit(ct);
		
		try {
			result = fjt.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("Result (submit) = " + result);
	}
	

}
