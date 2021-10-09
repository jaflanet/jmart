package jonaJmartBO;


/**
 * Write a description of class Recognizable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Recognizable implements Comparable <Recognizable>
{
    public final int id;
    
    protected Recognizable(int id){
    this.id = id;
    }
    
    public boolean equals (Object object){
        if(object instanceof Recognizable == true) {
            Recognizable recognizable = (Recognizable) object;
            if(recognizable.id == this.id) {
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    
    public boolean equals (Recognizable recognizable) {
        if(recognizable.id == this.id) {
            return true;
        }
        else{
            return false;
        }
    }
    
    public static <T extends Recognizable> int setClosingId (Class<T> clazz,int id ) {
    	return 0;
    }
    
    public static <T extends Recognizable> int getClosingId (Class<T> clazz) {
    	return 0;
    }
    
    @Override
    public int compareTo(Recognizable other) {
    	return Integer.compare(id,other.id);
    }
    
}
