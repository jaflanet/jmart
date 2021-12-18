package com.jonaJmartBO;

/**
 * @author Jona
 * @version 18/12/21
 */

public class Pair <T,U>{
	public T first;
	public U second;
	
	public Pair(){};
	
	public Pair(T first, U second) {
		this.first = first ;
		this.second = second;
	}
}
