package jonaJmartBO;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import com.google.gson.*;
//import com.google.gson.stream.JsonReader;
//
//
//public class Jmart{
//    class Country{
//        public String name;
//        public int population;
//        public List<String> listOfStates;
//    }
//    
//    public static void main(String[] args){
////        String filepath = "C:/Users/Jona/Desktop/KULIAH SEM 5/praktikum oop/modul 1/jmart/city.json";
////        Gson gson = new Gson();
////        try {
////            BufferedReader br = new BufferedReader(new FileReader(filepath));
////            Country input = gson.fromJson(br, Country.class);
////            System.out.println("name: " + input.name);
////            System.out.println("population: " + input.population);
////            System.out.println("states: ");
////            input.listOfStates.forEach(state -> System.out.println(state));
////        }
////        
////        catch (IOException e){
////            e.printStackTrace();
////        }
////    	System.out.println("account id:" + new Account(null, null, null, -1).id);
////    	System.out.println("account id:" + new Account(null, null, null, -1).id);
////    	System.out.println("account id:" + new Account(null, null, null, -1).id);
////
////    	System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
////    	System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
////    	System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
//    	try{
//            List<Product> list = read("C:/Users/Jona/Desktop/KULIAH SEM 5/praktikum oop/randomProductList.json");
//            List<Product> filtered = filterByPrice(list, 20000.0, 25000.0);
//            filtered.forEach(product -> System.out.println(product.price));
//        }catch (Throwable t)
//        {
//            t.printStackTrace();
//        }
//    }
//    
//    public static List<Product> filterByCategory (List<Product>list,ProductCategory category){
//    	List<Product> filtered = new ArrayList<>();
//        for (int c = 0; c < list.size(); c++) {
//            if(list.get(c).category == category) {
//                filtered.add(list.get(c));
//            }
//        }
//        return filtered;
//    }
//    
//    public static List<Product> filterByPrice (List<Product>list,double minPrice, double maxPrice){
//    	List<Product> products = new ArrayList<>();
//        for(int i = 0; i < list.size(); i++){
//            if(minPrice <= 0.0){
//                if(list.get(i).price <= maxPrice){
//                    products.add(list.get(i));
//                }
//            }else if(maxPrice <= 0.0){
//                if(list.get(i).price >= minPrice){
//                    products.add(list.get(i));
//                }
//            }else{
//                if(list.get(i).price >= minPrice && list.get(i).price <= maxPrice){
//                    products.add(list.get(i));
//                }
//            }
//        }
//        return products;
//    }
//    
//    public static List<Product> read (String filePath){
//    	List<Product> products = new ArrayList<>();
//        try{
//            Gson gson = new Gson();
//            JsonReader reader = new JsonReader(new FileReader("C:/Users/Jona/Desktop/KULIAH SEM 5/praktikum oop/randomProductList.json"));
//            reader.beginArray();
//            while(reader.hasNext()){
//                products.add(gson.fromJson(reader, Product.class));
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return products;
//    }
//    	
//}
