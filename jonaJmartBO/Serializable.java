package jonaJmartBO;
import java.util.*;
/**
 * Write a description of class Recognizable here.
 *
 * @author Jonathan Aurelius
 * @version 02/11/21
 */

public class Serializable implements Comparable <Serializable>
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap <>();
    
    protected Serializable(){
    	 Class counterId = getClass();
         if(mapCounter.get(counterId) == null){
             mapCounter.put(counterId,0);
         }
         else {
             mapCounter.put(counterId, mapCounter.get(counterId) + 1);
         }
         this.id =mapCounter.get(counterId);
    }
    
    public boolean equals (Object object){
        if(object instanceof Serializable == true) {
            Serializable recognizable = (Serializable) object;
            if(recognizable.id == this.id) {
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    
    public boolean equals (Serializable other) {
        if(other.id == this.id) {
            return true;
        }
        else{
            return false;
        }
    }
    
    public static <T extends Serializable> int setClosingId (Class<T> clazz,int id ) {
    	 mapCounter.replace(clazz.getClass(), id);
         return mapCounter.get(clazz.getClass());
    }
    
    public static <T extends Serializable> int getClosingId (Class<T> clazz) {
    	return mapCounter.get(clazz.getClass());
    }
    
    @Override
    public int compareTo(Serializable other) {
    	return Integer.compare(id,other.id);
    }
    
}
