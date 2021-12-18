package com.jonaJmartBO.controller;
import com.jonaJmartBO.Algorithm;
import com.jonaJmartBO.Predicate;
import com.jonaJmartBO.dbjson.JsonTable;
import com.jonaJmartBO.dbjson.Serializable;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Jona
 * @version 18/12/21
 */

@RestController
public interface BasicGetController<T extends Serializable> {
    
	//melakukan get berdasarkan page yang diinginkan
	/**
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/page")
    default @ResponseBody List<T> getPage(@RequestParam(defaultValue="1") int page, @RequestParam(defaultValue="5") int pageSize){
        return Algorithm.<T>paginate(getJsonTable(),page,pageSize,e -> true);
    }
	
	//melakukan get id
    /**
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    default T getById(@PathVariable int id){
        return Algorithm.<T>find(getJsonTable(),(e) -> e.id == id);
    }

    /**
     * @return
     */
    public abstract JsonTable<T> getJsonTable();
}
	
