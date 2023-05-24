package com.nuke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
       SpringApplication.run(Main.class, args);
    }
    @GetMapping("/greet")
    public GreetResponse greet(){
        GreetResponse greetResponse =  new GreetResponse(
                "Hello",
                List.of("Java","PHP","JavaScript"),
                new Person("Nelson Sammy",30,1000_000.00)
        );
        return greetResponse;
    }
    record Person (String name,int age,double savings){

    }
    record GreetResponse(
            String greet,
            List<String> favProgrammingLanguages,
            Person person
    ){}
}
