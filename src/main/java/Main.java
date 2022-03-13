import br.com.json.formatter.controller.ResponseToJson;

public class Main {

    public static void main(String[] args) {
        String path = "./src/fileDataTest.txt";
        if(args != null && args.length > 0) {
            path = args[0];
        }
        ResponseToJson response = new ResponseToJson();
        var jsonUser = response.responseJson(path);
        System.out.println(jsonUser);

    }
}
