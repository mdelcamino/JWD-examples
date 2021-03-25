package com.udacity.jdnd.c1.review;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class ReviewApplicationTests {
	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	private SignupPage signuppage;

	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void afterAll() {
		driver.quit();
	}
/*	@BeforeEach
	public void beforeEach() {
		driver.get("http://localhost:" + port + "/signup");
		signuppage = new SignupPage(driver);
	}
*/

	@Test
	//El usuario se registra en signup, se loga en login y envía un mensaje
	public void testUserSignupLoginAndSubmitMessage(){
		String username="caa";
		String password="123";
		String message="Testing sending my first message";
		String surname="MyName";
		String lastname="MyLastName-son";

		//Se registra
		driver.get("http://localhost:" + port + "/signup");
		signuppage = new SignupPage(driver);
		signuppage.signup(username, password, surname, lastname);

		//Se loga
		driver.get("http://localhost:" + port + "/login");
		LoginPage loginpage= new LoginPage(driver);
		loginpage.login(username, password);

		// Envia un mensaje
		driver.get("http://localhost:" + port + "/chat");
		ChatPage chatpage= new ChatPage(driver);
		//chatpage.chat(username, messsage);

	}



}
