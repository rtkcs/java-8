package eu.rtakacs.forkjoin;

import java.util.concurrent.RecursiveAction;

public class RecursiveActionExample extends RecursiveAction{

	int start;
	int stop;
	int[] values;
	public static int THRESHOLD = 3;
	
	public RecursiveActionExample(int start, int stop, int[] values) {
		this.start = start;
		this.stop = stop;
		this.values = values;
	}
	

	@Override
	protected void compute() {
		if(start + THRESHOLD < stop) {
			RecursiveActionExample rae1 = new RecursiveActionExample(stop - THRESHOLD, stop, values);
			RecursiveActionExample rae2 = new RecursiveActionExample(start, stop - THRESHOLD, values);
			
			rae1.fork();
			rae2.compute();
			rae1.join();
			
		} else {
			int sum = 0;
			for(int i=start; i<stop; i++) {
				sum = sum + values[i];
			}
			System.out.println(sum);
		}
		
	}
	
	
	public static void main(String[] args) {
		int[] arrInt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		RecursiveActionExample example = new RecursiveActionExample(0, 10, arrInt);
		example.compute();

	}

}
