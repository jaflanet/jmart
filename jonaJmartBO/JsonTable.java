package jonaJmartBO;
import java.util.Collections;
import java.util.Vector;
import java.io.*;
import java.lang.reflect.Array;

import com.google.gson.*;
import com.google.gson.stream.*;

public class JsonTable<T> extends Vector{

	public final String filepath;
	private static final Gson gson = new Gson();
	
	 public JsonTable(Class<T> clazz, String filepath) throws IOException{
		 this.filepath = filepath;
	        try{
	            Class<T[]> array = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
	            T[] hasil = JsonTable.readJson(array, filepath);
	            Collections.addAll(this, hasil);
	        }
	        catch(FileNotFoundException e){
	            File file = new File(filepath);
	        }
	 }
	public static <T> T readJson (Class<T> clazz, String filepath) throws FileNotFoundException{
		final JsonReader read = new JsonReader(new FileReader(filepath));
        return gson.fromJson(read, clazz);
	}
	
	public void writeJson () throws IOException{
		writeJson(this,this.filepath);
	}
	
	 public static void writeJson(Object object, String filepath) throws IOException {
		  final FileWriter fileWriter = new FileWriter(filepath);
		  fileWriter.write(gson.toJson(object));
		  fileWriter.close();
		 }
}
