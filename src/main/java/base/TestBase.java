package base;

import java.time.Duration;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {
	
	protected static WebDriver driver;

	public static Properties envConfig;

	//WebDriverWait wait;

	

 

 

	//BROWSER value fetched from POM with Chrome being the default value 

	private static final String BROWSER = "Chrome";

	

		

	//Automation suite setup method to configure and instantiate a particular browser

	@BeforeSuite

    public void suiteSetup() throws Exception {

		

		//Browser configuration - can add more browsers and remote driver here

		if (BROWSER.equals("Firefox")) {

			

         }

		else if (BROWSER.equals("Chrome")) {

			

			  System.setProperty("webdriver.chrome.driver", "C:\\Users\\jubil\\OneDrive\\Desktop\\Selenium\\TestingNew\\chromedriver.exe");
			driver = new ChromeDriver();             

         }

		 else if (BROWSER.equals("IE")) {

		

         }

		 else {

             throw new RuntimeException("Browser type unsupported");

         }




//Setting implicit wait

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		

		driver.manage().window().maximize();

		

		//Setting WebDriverWait with max timeout value of 20 seconds

		

 

		//Environment specific properties file loading

		InputStream configFile = new FileInputStream(System.getProperty("user.dir") + 

				"\\src\\main\\java\\config\\properties"  +  ".properties");	

		

		envConfig = new Properties();

		envConfig.load(configFile);

	

	}

 

	

	@BeforeMethod()

    public void loadBaseUrl(Method method) {

		

        driver.get(envConfig.getProperty("baseUrl"));

        

    }
}
