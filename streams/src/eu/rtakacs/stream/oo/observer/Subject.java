package eu.rtakacs.stream.oo.observer;

public interface Subject {
	void registerObserver(Observer o);
	void notifyObservers(String tweet);
}
