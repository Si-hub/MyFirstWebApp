package WebApp;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        // Spark will run on port 8080
        port(8080);

        get("/greet", (request, response) -> {
            // Show something
            return "Hello Welcome to my first App! ";
        });

        get("/greet/:username", (request, response) -> {
            // Show something
            return "Hello " + request.params(":username");
        });

        get("/greet/:username/language/:language", (request, response) -> {
            // Show something
            return null;
        });

        post("/greet",(request,response)->{
            if(request.queryParams("username").equals("username")){
                 return    "Hello" + request.queryParams("username");
            }else{
               return  "Hello!";
            }

        });

        get("/hello", (req, res) -> {
            return "";
        });


        post("/hello", (req, res) -> {
            return "";
        });
    }



}