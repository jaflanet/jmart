package jonaJmartBO;


/**
 * Write a description of class FileParser here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface FileParser
{
    public boolean read(String content);
    
    default Object write() {
        return null;   
    }
    
    public static Object newInstance(String content) {
        return null;
    }
}
