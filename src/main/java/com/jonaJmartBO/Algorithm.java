package com.jonaJmartBO;

import java.util.*;
import java.util.stream.Collectors;

public class Algorithm{
	
	private Algorithm() {}
	
	public static <T> List<T> collect (T [] array, T value) {
		  List<T> alist = new ArrayList<T>();
	        for (T u: array) {
	            if(u.equals(value)) {
	            	alist.add(u);
	            }
	        }
	        return alist;
	}
	
	public static <T> List<T> collect (Iterable <T> iterable, T value) {
		  List<T> alist = new ArrayList<T>();
	        for (T u: iterable) {
	            if(u.equals(value)) {
	                alist.add(u);
	            }
	        }
	        return alist;
	}
	
	public static <T> List<T> collect (Iterator <T> iterator, T value) {
		  List<T> alist = new ArrayList<T>();
	        while(iterator.hasNext()) {
	            T u = iterator.next();
	            if(u.equals(value)) {
	                alist.add(u);
	            }
	        }
	        return alist;
	}
	
	public static <T> List<T> collect (T [] array, Predicate <T> pred) {
		List<T> list = new ArrayList<T>();
        for (T u: array) {
            if(pred.predicate(u)) {
                list.add(u);
            }
        }
        return list;
	}
	
	public static <T>List<T> collect (Iterable <T> iterable, Predicate <T> pred) {
		 List<T> alist = new ArrayList<T>();
	        for (T u: iterable) {
	            if(pred.predicate(u)) {
	                alist.add(u);
	            }
	        }
	        return alist;
	}
	
	public static <T> List<T> collect (Iterator <T> iterator, Predicate <T> pred) {
		  List<T> alist = new ArrayList<T>();
	        while(iterator.hasNext()) {
	            T u = iterator.next();
	            if(pred.predicate(u)) {
	                alist.add(u);
	            }
	        }
	        return alist;
	}
	
	public static <T> int count (T [] array, T value) {
		final Iterator<T> c = Arrays.stream(array).iterator();
		return count(c,value);
	}
	
	public static <T> int count (Iterable <T> iterable, T value) {
		final Iterator <T> c = iterable.iterator();
		return count(c,value);
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
	
	public static <T extends Comparable<? super T>> T max(T[] array)
    {
        T max= null;
        
        for (T c : array) {
        	if(c.compareTo(max) >= 0)
            {
                max = c;
            }
    		else {
    			max = max;
    		}
        }
		
        return max;
    }
	
	
	public static <T extends Comparable<? super T>> T min(T[] array)
	{
	    T min = null;
	    
	    for (T u : array) {
	    	if(u.compareTo(min) <= 0)
	        {
	            min = u;
	        }
			else {
				min = min;
			}
	    }
		
	    return min;
	}

	public static <T extends Comparable<? super T>> T max(T[] array, Comparator<? super T> comparator)
	{
	    T max = null;
	    
	    for (T u : array) {
	    	if(comparator.compare(u, max) >= 0)
	        {
	            max = u;
	        }
			else {
				max = max;
			}
	    }
	    return max;
	}

	public static <T extends Comparable<? super T>> T min(T[] array, Comparator<? super T> comparator)
	{
	    T min = null;
	    
	    for (T u : array) {
	    	if(comparator.compare(u, min) <= 0)
	        {
	    		min = u;
	        }
			else {
				min = min;
			}
	    }
		
	    return min;
	}

	public static <T extends Comparable<? super T>> T max(Iterable<T> iterable)
    {
		final Iterator <T> u  = iterable.iterator();
		T max = null;
        while(u.hasNext()) {
        	if (u.next().compareTo(max) >= 0)
        	{
        		max = u.next();
        	}
        }
		
        return max;
    }
	
	public static <T extends Comparable<? super T>> T min(Iterable<T> iterable)
	{
		final Iterator <T> u  = iterable.iterator();
		T min = null;
	    while(u.hasNext()) {
	    	if (u.next().compareTo(min) <= 0)
	    	{
	    		min = u.next();
	    	}
	    }
		
	    return min;
	}

	public static <T extends Comparable<? super T>> T max(Iterable<T> iterable, Comparator<? super T> comparator)
    {
		final Iterator <T> u  = iterable.iterator();
		T max = null;
        while(u.hasNext()) {
        	if (comparator.compare(u.next(), max) >= 0)
        	{
        		max = u.next();
        	}
        }
		
        return max;
    }
	
	public static <T extends Comparable<? super T>> T min(Iterable<T> iterable, Comparator<? super T> comparator)
	{
		final Iterator <T> u  = iterable.iterator();
		T min = null;
	    while(u.hasNext()) {
	    	if (comparator.compare(u.next(), min) <= 0)
	    	{
	    		min = u.next();
	    	}
	    }
		
	    return min;
	}

	public static <T extends Comparable<? super T>> T max(Iterator <T> iterator)
	{
	    T max = null;
	    while(iterator.hasNext()) {
	    	if(iterator.next().compareTo(max) >= 0) {
	    		
	    	}
	    }
	    return max;
	}

	public static <T extends Comparable<? super T>> T min(Iterator <T> iterator)
	{
	    T min= null;
	    while(iterator.hasNext()) {
	    	if(iterator.next().compareTo(min) >= 0) {
	    		
	    	}
	    }
	    return min;
	}

	public static <T extends Comparable<? super T>> T max(T first, T  second, Comparator<? super T> comparator)
    {
        T max;
		if(comparator.compare(first, second) >= 0)
        {
            max = first;
        }
		else {
			max = second;
		}
        return max;
    }
	
	public static <T extends Comparable<? super T>> T min(T first, T  second, Comparator<? super T> comparator)
	{
	    T min;
		if(comparator.compare(first, second) >= 0)
	    {
			min = first;
	    }
		else {
			min = second;
		}
	    return min;
	}

	public static <T extends Comparable<? super T>> T max(Iterator <T> iterator, Comparator<? super T> comparator)
    {
        T max = null;
        while(iterator.hasNext()) {
        	if(comparator.compare(iterator.next(), max)>= 0) {
        		
        	}
        }
        return max;
    }
	
	public static <T extends Comparable<? super T>> T min(Iterator <T> iterator, Comparator<? super T> comparator)
    {
        T min = null;
        while(iterator.hasNext()) {
        	if(comparator.compare(iterator.next(), min)>= 0) {
        		
        	}
        }
        return min;
    }
	
	public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred){
        //Convert array to List
        List<T> newList = new ArrayList<>();
        for(T t : array){
            newList.add(t);
        }
        try{
            List<T> filteredList = newList.stream().filter(pred::predicate).collect(Collectors.toList());
            int endIndex = (page * pageSize) + pageSize;
            if(endIndex > filteredList.size()){
                endIndex = filteredList.size();
            }
            return filteredList.subList((page * pageSize), endIndex);
        }catch (Exception e){
            return newList.subList(0 ,0);
        }
    }
    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred){
        //Convert array to List
        List<T> newList = new ArrayList<>();
        for(T t : iterable){
            newList.add(t);
        }
        try{
            List<T> filteredList = newList.stream().filter(pred::predicate).collect(Collectors.toList());
            int endIndex = (page * pageSize) + pageSize;
            if(endIndex > filteredList.size()){
                endIndex = filteredList.size();
            }
            return filteredList.subList((page * pageSize), endIndex);
        }catch (Exception e){
            return newList.subList(0 ,0);
        }
    }
    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred){
        //Convert array to List
        List<T> newList = new ArrayList<>();
        while(iterator.hasNext()){
            newList.add(iterator.next());
        }
        try{
            List<T> filteredList = newList.stream().filter(pred::predicate).collect(Collectors.toList());
            int endIndex = (page * pageSize) + pageSize;
            if(endIndex > filteredList.size()){
                endIndex = filteredList.size();
            }
            return filteredList.subList((page * pageSize), endIndex);
        }catch (Exception e){
            return newList.subList(0 ,0);
        }
    }
}

