package eu.rtakacs.optional;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PersonTest {

	public static void main(String[] args) {
		
		Car car = new Car();
		//empty optional
		Optional<Car> optCar = Optional.empty();
		//optional from non null
		Optional<Car> optCarNonNull = Optional.of(car);
		//optional from null, car coult be null
		Optional<Car> optCarFromNull = Optional.ofNullable(car);
		
		Insurance insurance = new Insurance();
		insurance.setName("Optional Insurance");
		Optional optInsurance = Optional.of(insurance);
		car.setInsurance(optInsurance);
		
		Person person = new Person();
		person.setCar(Optional.of(car));
		Optional<Person> optPerson = Optional.of(person);
		
		//chaining Optional object with flat map
		
		//does not compile
		//The method map(Function<? super Optional<Car>,? extends U>) in the type Optional<Optional<Car>> is not applicable for the arguments (Car::getInsurance)
		//Optional<String> name = optPerson.map(Person::getCar).map(Car::getInsurance).map(Insurance::getName);
		System.out.println(getCarInsuranceName(optPerson));
		System.out.println( printCarInsuranceName(optPerson) );
		serialize(optPerson);
		
	}
	
	private static String getCarInsuranceName(Optional<Person> person){
		return person.flatMap(Person::getCar)
					 .flatMap(Car::getInsurance)
					 .map(Insurance::getName)
					 .orElse("Unknown");
	}
	private static String printCarInsuranceName(Optional<Person> person){
		Consumer<String> consumer = new Consumer<String>(){ public void accept(String s){
			System.out.println("Insurance name printed from Consumer: " + s);
		}};
		person.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).ifPresent(consumer);
		person.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).ifPresent(s-> System.out.println("Insurance name printed from Consumer2:" + s));
		
		person.get().getCar().get().getInsurance().get().setName(null);
		Supplier<String> supplier = new Supplier<String>(){ public String get(){
			System.out.println("From Supplier2: No name");
			return "From Supplier2: No name";}};
		Supplier<String> supplier2 = () -> {System.out.println("From Supplier: No name"); return "From Supplier: No name";}; 
		String s = person.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElseGet(supplier);
		s = person.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElseGet(supplier2);
		return s;
	}
	
	//java.io.NotSerializableException: java.util.Optional
	private static void serialize(Optional<Person> person){
		try(FileOutputStream fos = new FileOutputStream("Optional-person.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(person);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
