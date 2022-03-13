import br.com.json.formatter.model.Order;
import br.com.json.formatter.model.Product;
import br.com.json.formatter.model.User;
import br.com.json.formatter.service.CreateEntity;
import br.com.json.formatter.service.ProcessElementsFile;
import br.com.json.formatter.service.ReadingFile;
import br.com.json.formatter.service.SeparatingElementsFile;

import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        String path = "./src/fileData.txt";
        if(args != null && args.length > 0) {
            path = args[0];
        }
        ReadingFile readingFile = new ReadingFile();
        var linesFile= readingFile.readingFile(path);
        SeparatingElementsFile separeElements = new SeparatingElementsFile();
        Map<String, String> elementSepared = new HashMap<>();
        for(var line : linesFile){
            elementSepared = separeElements.separatingElements(line);
            ProcessElementsFile processElements = new ProcessElementsFile();
            var elementProcessed = processElements.processingElements(elementSepared);
            CreateEntity create = new CreateEntity();
            var createdEntity= create.createEntity(elementProcessed);
            User newUser = (User) createdEntity.get("user");
            Order newOrder = (Order) createdEntity.get("order");
            Product newProduct = (Product) createdEntity.get("product");
            System.out.println("USER PROCESSING NAME = " + newUser.getName());
            System.out.println("user_id = " + newUser.getId());
            System.out.println("order_id = " + newUser.getOrders().get(0).getId());
            System.out.println("order_total = " + newUser.getOrders().get(0).getTotal());
            System.out.println("order_date = " + newUser.getOrders().get(0).getDate());
            System.out.println("product_id = " + newUser.getOrders().get(0).getProducts().get(0).getId());
            System.out.println("product_id = " + newUser.getOrders().get(0).getProducts().get(0).getValue());

            System.out.println("-----------------||---------------------");

        }


        System.out.println("There is no file path...");
    }





}
