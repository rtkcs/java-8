package eu.rtakacs.le;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

class Data{
	int value;
	public Data(int x) {
		this.value = x;
	}
	public String toString() {
		return "" + this.value;
	}
}

class Filter{
	public boolean test(Data d) {
		return d.value ==0;
	}
}

public class PredicateTest2 {
	
	public static void filterData(List<Data> dataList, Filter f) {
		Iterator<Data> i = dataList.iterator();
		while(i.hasNext()) {
			if(f.test(i.next())) {
				i.remove();
			}
		}
	}
	
	public static void filterData2(List<Data> dataList, Predicate<Data> p) {
		Iterator<Data> i = dataList.iterator();
		while(i.hasNext()) {
			if(p.test(i.next())) {
				i.remove();
			}
		}
	}
	
	public static void main(String[] args) {
		List<Data> al = new ArrayList<>();
		Data d = new Data(1);
		al.add(d);
		d = new Data(2);
		al.add(d);
		d = new Data(0);
		al.add(d);
		
//		filterData(al, new Filter());
		filterData2(al, p -> p.value==0);
		System.out.println(al);
		
		
	}

}
