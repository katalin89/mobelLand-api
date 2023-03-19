package ro.mycode.mobelLandapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.mobelLandapi.repository.MobilaRepo;

@SpringBootApplication
public class MobelLandApiApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(MobelLandApiApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(MobilaRepo mobilaRepo){
		return  args -> {

		};
	}

}
