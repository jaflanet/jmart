package jonaJmartBO;


/**
 * Write a description of class ProductRating here.
 *
 * @author (Jonathan Aurelius)
 * @version (18/9/21)
 */
public class ProductRating
{
    private long total;
    private long count;
    
    public ProductRating(){
        this.total=0;
        this.count=0;
    }
    
    public void insert(int rating){
        total = total + rating;
        count = count++;
    }
    
    public double getAverage(){
        if(count != 0) {
            return total/count;
        }
        else {
            return 0;
        }
    }
    
    public long getCount(){
        return (long) this.count;
    }
    
    public long getTotal(){
        return (long) this.total;
    }
}
    
    
