package eu.rtakacs.optional.examples;

import java.util.Optional;

public class OptionalUtility {

	public static Optional<Byte> stringToByte(String s){
		try{
			return Optional.of(Byte.parseByte(s));
		}catch(NumberFormatException e){
			return Optional.empty();
		}
	}	
	
	public static Optional<Short> stringToShort(String s){
		try{
			return Optional.of(Short.parseShort(s));
		}catch(NumberFormatException e){
			return Optional.empty();
		}
	}

	public static Optional<Integer> stringToInt(String s){
		try{
			return Optional.of(Integer.parseInt(s));
		}catch(NumberFormatException e){
			return Optional.empty();
		}
	}
	
	public static Optional<Long> stringToLong(String s){
		try{
			return Optional.of(Long.parseLong(s));
		}catch(NumberFormatException e){
			return Optional.empty();
		}
	}
	
	public static Optional<Float> stringToFloat(String s){
		try{
			return Optional.of(Float.parseFloat(s));
		}catch(NumberFormatException e){
			return Optional.empty();
		}
	}
	
	public static Optional<Double> stringToDouble(String s){
		try{
			return Optional.of(Double.parseDouble(s));
		}catch(NumberFormatException e){
			return Optional.empty();
		}
	}

	public static Optional<Boolean> stringToBoolean(String s){
		try{
			return Optional.of(Boolean.parseBoolean(s));
		}catch(NumberFormatException e){
			return Optional.empty();
		}
	}	
}
