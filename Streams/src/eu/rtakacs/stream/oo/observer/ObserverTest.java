package eu.rtakacs.stream.oo.observer;

import eu.rtakacs.stream.helper.Helper;

public class ObserverTest {

	public static void main(String[] args) {
		
		Helper.print("Observer");
		Feed f = new Feed();
		f.registerObserver(new NYTimes());
		f.registerObserver(new Guardian());
		f.registerObserver(new LeMonde());
		
		
		
		//
		//--- Observer using lambda expressions
		//
		Helper.print("Observer using lambda expressions");
		f.registerObserver((String s) -> {
			if(s!=null && s.contains("money")) {
				System.out.println("NY Times observer with lambda: " + s);
			}
			
		});
		
		f.registerObserver((String s) -> {
			if(s!=null && s.contains("queen")) {
				System.out.println("London news with lambda observer: " + s);
			}
		});
		
		
		f.notifyObservers("The queen said her favorite wine is for no money.");
	}

}
