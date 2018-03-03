package serializable;

import java.io.Serializable;
import java.util.Optional;

public class Car implements Serializable {
	
	private Insurance insurance;

	public Optional<Insurance> getInsuranceAsOptional() {
		return Optional.ofNullable(insurance);
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	public Insurance getInsurance(){
		return this.insurance;
	}
	
}
