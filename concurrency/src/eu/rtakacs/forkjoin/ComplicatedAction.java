package eu.rtakacs.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ComplicatedAction extends RecursiveAction {

	private static final long serialVersionUID = -9189489857138352998L;

	int[] ia;
	int from;
	int to;

	public ComplicatedAction(int[] ia, int from, int to) {
		this.ia = ia;
		this.from = from;
		this.to = to;
	}

	protected void compute() {
		if (from == to) {
			// Update the value using logic implemented somewhere else.             
			ia[from] = UtilityClass.utilityMethod(ia[from]);
		} else {
			int mid = (from + to) / 2;
			ComplicatedAction newtask1 = new ComplicatedAction(ia, from, mid);
			ComplicatedAction newtask2 = new ComplicatedAction(ia, mid + 1, to);

			//1. form of invoking new tasks 
			//invokeAll(newtask1, newtask2);
			
			//2. form of invoking new tasks
			newtask2.fork();
			newtask1.compute();
			newtask2.join();
		}
	}

	public static void main(String[] args) {
		int ia[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		ForkJoinPool fjp = new ForkJoinPool();
		ComplicatedAction st = new ComplicatedAction(ia, 0, 6);
		fjp.invoke(st);
		System.out.print("New Array Values = ");
		for (int i : ia)
			System.out.print(i + " ");
	}
}

class UtilityClass {
	public static int utilityMethod(int x) {
		return x + 1;
	}
}