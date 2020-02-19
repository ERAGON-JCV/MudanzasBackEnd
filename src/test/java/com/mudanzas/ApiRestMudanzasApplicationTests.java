package com.mudanzas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TestDataBaseConfiguration.class })
@SpringBootTest(properties = "spring.datasource.url=jdbc:mysql://localhost/trazastest?serverTimezone= GMT-5:00")
public class ApiRestMudanzasApplicationTests {

	//private DirectrizControlDeTrazas controlDeTrazas;

	@Test		
	public void contextLoads() {

		

	}

}
