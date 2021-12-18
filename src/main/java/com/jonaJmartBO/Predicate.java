package com.jonaJmartBO;

@FunctionalInterface
public interface Predicate <T> {
	public abstract boolean predicate (T arg);
}
