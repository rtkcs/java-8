package serializable;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Optional;

public class PersonTest {

	public static void main(String[] args) {
		
		Insurance insurance = new Insurance();
		insurance.setName("Optional Seriazilable Insurance");
		Car car = new Car();
		car.setInsurance(insurance);
		
		Person person = new Person();
		person.setCar(car);
		Optional<Person> optPerson = Optional.of(person);
		
		System.out.println(getCarInsuranceName(optPerson));

		serialize(person);
		serializeXml(person);
	}
	
	//chaining Optional object with flat map     
	private static String getCarInsuranceName(Optional<Person> person){
		return person.flatMap(Person::getCarAsOptional)
					 .flatMap(Car::getInsuranceAsOptional)
					 .map(Insurance::getName)
					 .orElse("Unknown");
	}
	
	private static void serialize(Person person){
		try(FileOutputStream fos = new FileOutputStream("Optional-person.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(person);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void serializeXml(Person person){
		try(FileOutputStream fos = new FileOutputStream("Optional-person.xml");
			BufferedOutputStream oos = new BufferedOutputStream(fos);
			XMLEncoder xe = new XMLEncoder(oos)	){
			
			xe.writeObject(person);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
