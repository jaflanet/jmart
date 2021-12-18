package com.jonaJmartBO;

/**
 * @author Jona
 * @version 18/12/21
 */

@FunctionalInterface
public interface Predicate <T> {
	public abstract boolean predicate (T arg);
}
