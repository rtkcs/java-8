package eu.rtakacs.optional.examples;

import java.util.Optional;

import eu.rtakacs.optional.Car;
import eu.rtakacs.optional.Insurance;
import eu.rtakacs.optional.Person;

public class UsingOptional {

	public static void main(String[] args) {
		
		Car car = new Car();
		Person person = new Person();
		person.setCar(Optional.of(car));
		person.setAge(35);
		Insurance insurance = new Insurance();
		insurance.setName("Sam Smith Insurance");
		car.setInsurance(Optional.of(insurance));
		
		nullSafefindCheapestInsurance(Optional.of(person), Optional.of(car)).ifPresent(c -> {System.out.println(c.getName());});
		nullSafefindCheapestInsurance2(Optional.of(person), Optional.of(car)).ifPresent(c-> {System.out.println(c.getName());});
		
		
		//filter, traditional way
		Optional<Insurance> optInsurance = nullSafefindCheapestInsurance(Optional.of(person), Optional.of(car));
		if(optInsurance.isPresent()){
			Insurance ins = optInsurance.get();
			if(ins != null && "Super Cheap Insurance".equals(ins.getName())){
				System.out.println("OK - Insuracen find traditional way");
			}
		}
		
		//filter, in stream
		filterInsurance(optInsurance);
		filterInsurance(Optional.empty());
		
		System.out.println( getCarInsuranceName(Optional.of(person), 21) );
		
	}
	

	
	public static String getCarInsuranceName(Optional<Person> person, int minAge){
		return person.filter(p -> p.getAge() >= minAge)
					.flatMap(p -> p.getCar())
					.flatMap(c -> c.getInsurance())
					.map(i -> i.getName())
					.orElse("Unknown");
	}
	
	/**
	 * Filter insurance with stream filter.
	 * @param optInsurance
	 */
	public static void filterInsurance(Optional<Insurance> optInsurance){
		optInsurance.filter(insurance -> "Super Cheap Insurance".equals(insurance.getName()))
		.ifPresent(x -> System.out.println("OK - insurance find with filter"));
	}
		
	/**
	 * Standard imperative way.
	 * @param person
	 * @param car
	 * @return
	 */
	public static Optional<Insurance> nullSafefindCheapestInsurance(Optional<Person> person, Optional<Car> car){
		
		if(person.isPresent() && car.isPresent()){
			return Optional.of(findCheapestInsurance(person.get(), car.get()));
		} else{
			return Optional.empty();
		}
	}
	
	/**
	 * New way. Implementation without using any conditional constructs.
	 * @param person
	 * @param car
	 * @return
	 */
	public static Optional<Insurance> nullSafefindCheapestInsurance2(Optional<Person> person, Optional<Car> car){
		return person.flatMap(p-> car.map(c->findCheapestInsurance(p, c)));
	}
	
	public static Insurance findCheapestInsurance(Person person, Car car){
		Insurance ins = new Insurance();
		ins.setName("Super Cheap Insurance");
		return ins;
	}

}
