package ro.mycode.mobelLandapi.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.mobelLandapi.repository.MobilaRepo;

@SpringBootApplication
public class MobellanndApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(MobellanndApiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(MobilaRepo mobilaRepo) {
        return args -> {



            mobilaRepo.getAllDenumiri().forEach((e)->{
                System.out.println(e);
            });



        };

    }
}
