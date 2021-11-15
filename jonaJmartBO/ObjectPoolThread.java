package jonaJmartBO;
import java.util.*;
import java.util.function.Function;

public class ObjectPoolThread<T> extends Thread {
	
	private boolean exitSignal;
	private Vector<T> objectPool;
	Function <T,Boolean> routine;
	
	public ObjectPoolThread (String name, Function<T, Boolean> routine) {
		  super(name);
	      this.routine = routine;
	}
	
	public ObjectPoolThread (Function<T, Boolean> routine) {
		 this.routine = routine;
	}
	
	public synchronized void add (T object) {
		objectPool.add(object);
	}
	
	public synchronized void exit () {
		   exitSignal = true;
	}
	
	@Override
	public void run () {
		while(!exitSignal){
            try{
                synchronized(this){
                    for(T loop : objectPool){
                        routine.apply(loop);
                    }
                    try{
                        this.wait();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }

            }catch(Exception e){
                e.printStackTrace();
            }
	}
	}
	
	public int size () {
		 return objectPool.size();
	}

}
