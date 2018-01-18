package eu.rtakacs.twr;

public class Device /*implements AutoCloseable*/{
	
	public Device(){
		System.out.println("Device opened");
	}
	
	public void close(){
		System.out.println("Device closed");
	}
	
	public static void main(String[] args){
		try(Device d = new Device()){	//Unresolved compilation problem: 
										//The resource type Device does not implement java.lang.AutoCloseable
			
		}
	}
}
