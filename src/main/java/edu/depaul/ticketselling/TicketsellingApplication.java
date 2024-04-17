package edu.depaul.ticketselling;

import edu.depaul.ticketselling.database.TestModel;
import edu.depaul.ticketselling.database.TestModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TicketsellingApplication {

	@Autowired
	private TestModelService testModelService;

	public static void main(String[] args) {
		SpringApplication.run(TicketsellingApplication.class, args);
	}
	@Bean
	CommandLineRunner runner() {
		return args -> {
			var test = new TestModel("hey", "john doe", 5);
			testModelService.save(test);
			List<TestModel> bro = testModelService.findAll();
			System.out.println(bro);
		};
	}
}
