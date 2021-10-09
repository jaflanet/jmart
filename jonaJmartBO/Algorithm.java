package jonaJmartBO;

import java.util.*;

public class Algorithm{
	
	private Algorithm() {}
	
	public static <T> int count (T [] array, T value) {
		final Iterator<T> c = Arrays.stream(array).iterator();
		return count(c,value);
	}
	
	public static <T> int count (Iterable <T> iterable, T value) {
		final Iterator <T> a = iterable.iterator();
		return count(a,value);
	}
	
	public static <T> int count (Iterator <T> iterator, T value) {
		final Predicate <T> pred = value::equals;
		return count(iterator,pred);
	}
	
	public static <T> int count (T [] array, Predicate <T> pred) {
		final Iterator<T> c = Arrays.stream(array).iterator();
		return count(c,pred);
	}
	
	public static <T> int count (Iterable <T> iterable, Predicate <T> pred) {
		final Iterator <T> c = iterable.iterator();
		return count(c,pred);
	}
	
	public static <T> int count (Iterator <T> iterator, Predicate <T> pred) {
		return count(iterator,pred);
	}
	
	public static <T> boolean exists (T [] array, T value) {
		final Iterator<T> c = Arrays.stream(array).iterator();
		return exists(c,value);
	}
	
	public static <T> boolean exists (Iterable <T> iterable, T value) {
		final Iterator <T> c = iterable.iterator();
		return exists(c,value);
	}
	
	public static <T> boolean exists (Iterator <T> iterator, T value) {
		final Predicate <T> pred = value::equals;
		return exists(iterator,pred);
	}
	
	public static <T> boolean exists (T [] array, Predicate <T> pred) {
		final Iterator<T> c = Arrays.stream(array).iterator();
		return exists(c,pred);
	}
	
	public static <T> boolean exists (Iterable <T> iterable, Predicate <T> pred) {
		final Iterator <T> c = iterable.iterator();
		return exists(c,pred);
	}
	
	public static <T> boolean exists (Iterator <T> iterator, Predicate <T> pred) {
		return exists(iterator,pred);
	}
	
	public static <T> T find (T [] array, T value) {
		final Iterator<T> c = Arrays.stream(array).iterator();
		return find(c,value);
	}
	
	public static <T> T find (Iterable <T> iterable, T value) {
		final Iterator <T> c = iterable.iterator();
		return find(c,value);
	}
	
	public static <T> T find (Iterator <T> iterator, T value) {
		final Predicate <T> pred = value::equals;
		return find(iterator,pred);
	}
	
	public static <T> T find (T [] array, Predicate <T> pred) {
		final Iterator<T> c = Arrays.stream(array).iterator();
		return find(c,pred);
	}
	
	public static <T> T find (Iterable <T> iterable, Predicate <T> pred) {
		final Iterator <T> c = iterable.iterator();
		return find(c,pred);
	}
	
	public static <T> T find (Iterator <T> iterator, Predicate <T> pred) {
		return find(iterator,pred);
	}
	
	public static <T extends Comparable<? super T>> T max (T first, T second) {
		if (first.compareTo(second) > 0) {
			return first;
		}
		else {
			return second;
		}
	}
	
	public static <T extends Comparable<? super T>> T min (T first, T second) {
		if (first.compareTo(second) < 0) {
			return first;
		}
		else {
			return second;
		}
	}
}

