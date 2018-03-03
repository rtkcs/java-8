package serializable;

import java.io.Serializable;
import java.util.Optional;

public class Person  implements Serializable {

	private Car car;

	public Optional<Car> getCarAsOptional() {
		return Optional.ofNullable(car);
	}

	public void setCar(Car car) {
		this.car = car;
	}
	public Car getCar(){
		return this.car;
	}
}
