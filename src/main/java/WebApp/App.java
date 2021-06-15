package WebApp;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

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
            if(request.params(":language").equals("Xhosa")){
                return "Molo " + request.params("username");
            }else if(request.params(":language").equals("Sotho")){
                return "Dumela! " + request.params("username");
            }else if(request.params(":language").equals("Afrikaans")){
                return  "Halo " + request.params("username");
            }else{
               return  "Hallow!";
            }

        });

        post("/greet",(request,response)->{
            if(request.queryParams("username").isEmpty()){
                 return "Hello! ";
            }else{
                return    "Hello" + request.queryParams("username");
            }

        });

        get("/hello", (req, res) -> {

            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "hello.handlebars");

        }, new HandlebarsTemplateEngine());


        post("/hello", (req, res) -> {

            Map<String, Object> map = new HashMap<>();
            String lang = req.queryParams("language");
            String greeting = req.queryParams("username");
            String msg = new String();

            if(lang.equalsIgnoreCase("Xhosa")){
                msg = "Molo! " + greeting;
            }else if(lang.equalsIgnoreCase("Sotho")){
                msg = "Dumela! " + greeting;
            }else if(lang.equalsIgnoreCase("Afrikaans")){
                msg = "Halo! " + greeting;
            }

            // put it in the map which is passed to the template - the value will be merged into the template
            map.put("greeting", msg);

            return new ModelAndView(map, "hello.handlebars");

        }, new HandlebarsTemplateEngine());
    }



}
