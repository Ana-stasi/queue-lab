package boilerplate;

import com.google.gson.Gson;
import model.entity.Student;
import model.entity.Subject;
import model.service.*;
import spark.ResponseTransformer;

import java.util.ArrayList;

import static spark.Spark.after;
import static spark.Spark.get;

//todo понять какие запросы должны быть(/user, /login, /subjects....)
//todo решить в каком виде мы будем возвращать данные с dao что бы конвертировать в json
//todo решить что-то с ГРЕБУЧИМИ КУКИ
//МОЛИТЬСЯ БОГУ

public class Application {

    private static ResponseTransformer toJson = new Gson()::toJson;

    public static void main(String... args) {
        get("/", (request, response) -> "Greetings!", toJson);

        get("/account/api/subjects", (request, response) -> {
            return new SubjectService().getSubject(new Student(
                        "1", "Анастасія", "Лапа", "is8113"));}
                        , toJson);



        get("/info/bars", (request, response) -> {
            return new BarService().getBars();
        }, toJson);

        get("/info/developers", (request, response) -> {
            return new DeveloperService().getDevelopers();
        }, toJson);

        get("/queue/api/queue", (request, response) -> {
            return new QueueService().getQueue(new Student("1", "Анастасія", "Лапа",
                    "is8113"), new Subject("Групова динаміка і комунікації"));
            }, toJson);


        get("/subjects/api/options", (request, response) -> {
            return new OptionService().getOptions();
            }, toJson);

        after((request, response) -> {
            // For security reasons do not forget to change "*" to url
            response.header("Access-Control-Allow-Origin", "*");
            response.type("application/json");
        });
    }

}


