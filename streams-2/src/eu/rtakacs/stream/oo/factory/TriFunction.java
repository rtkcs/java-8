package eu.rtakacs.stream.oo.factory;

public interface TriFunction<T,U,V,R> {
	R apply(T t, U u, V v);
}
