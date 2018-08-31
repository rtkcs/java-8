package eu.rtakacs.collection;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CopyOnWriteArrayListExample {
	
	
	public static void main(String[] args) {
		
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();  
		int size = list.size();
		
		Runnable r = () -> {
			String[] ss ={"one", "two", "three" , "four", "five", "six"};
			List<String> ls  = Arrays.asList(ss);
			list.addAll(ls);
		};
		
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(r);
		
		int newSize = 0;
		for(int i =0; i<1_000_000; i++){
			if(size!=list.size()){
				newSize = list.size();
				break;
			}
		}
		
		System.out.println("CopyOnWriteArrayList size = " + size + ", newSize = " + newSize);
		
	}

}
