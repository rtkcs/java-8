package eu.rtakacs;

public class PersonTest {
	
	public static void main(String[] args){
		
		Insurance insurance = new Insurance();
		insurance.setName("Test Insurance");
		Car car = new Car();
		car.setInsurance(insurance);
		Person person = new Person();
		person.setCar(car);
		
		System.out.println(person.getCar().getInsurance().getName());
		System.out.println(getCarInsuranceName(person));
		System.out.println(getCarInsuranceName2(person));

	}
	
	private static String getCarInsuranceName(Person person){
		
		if(person != null){
			Car car = person.getCar();
			if(car != null){
				Insurance insurance = car.getInsurance();
				if(insurance != null)
					return insurance.getName();
			}
		}
		return "Unknown";
	}
	
	private static String getCarInsuranceName2(Person person){
		if(person == null){
			return "Unknown";
		}
		Car car = person.getCar();
		if(car == null){
			return "Unknown";
		}
		Insurance insurance = car.getInsurance();
		if(insurance == null){
			return "Unknown";
		}
		return insurance.getName();
	}
}
