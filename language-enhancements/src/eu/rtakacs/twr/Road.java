package eu.rtakacs.twr;

import java.io.IOException;

public class Road implements AutoCloseable {

	String name = null;

	public Road(String name) throws IOException {
		this.name = name;
		if ("D2".equals(name)) {
//			throw new IOException("Exception by opening D2");
		}
		System.out.println(name + " opened");
	}

	public String read() throws IOException {
		return "";
	}

	@Override
	public void close() throws Exception {
		System.out.println("Closing road " + this.name);
		throw new RuntimeException("RTE while closing " + this.name);

	}

	public static void main(String[] args) throws Exception{

		try (Road d1 = new Road("D1"); Road d2 = new Road("D2"); Road d3 = new Road("D3")) {
			throw new Exception("Exceptin in main");
		}
//		catch(Exception e){
//			System.out.println("------------------ inside catch");
//			System.out.println(e);
//			if(e.getStackTrace()!=null && e.getSuppressed().length>0){
//				System.out.println("Supressed Exceptions: ");
//				for(Throwable t : e.getSuppressed()){
//					System.out.println(t);
//				}
//			} else{
//				System.out.println("There is no supressed exception");
//			}
//		}
//		finally{
//			System.out.println("------------------ inside finally");
//		}

	}

}
