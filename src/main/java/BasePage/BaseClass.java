package BasePage;



import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;





public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	
	
	
	public void loadConfig() {
		try {
			prop = new Properties();
			FileInputStream fis= new FileInputStream("C:\\Pavan_Project\\Workspace\\CucumberFramework\\src\\main\\resources\\config\\config.properties");
			prop.load(fis);
		}
		catch(Exception e){
			e.printStackTrace();

		}
	}



	public void launchBrowser() 
	{
		
		
		
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Browser not found");
		}

		driver.manage().window().maximize();
		int implicitWait = Integer.parseInt(prop.getProperty("implicitWait"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		driver.get(prop.getProperty("url"));

	}

	public void initPageFactory(Object page) {
		PageFactory.initElements(driver, page);
	}
	public String captureScreen(String testName,String folderpPath) {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			String path = folderpPath+"/"+testName+".png";
			File dest = new File(path);
			 dest.getParentFile().mkdir();
			Files.copy(src.toPath(),dest.toPath());
			return path;
		}
		catch(Exception e) 
		{e.getStackTrace();
		return null;}
		 
	}

	public void closeBrowser() 
	{
		if(driver!=null) {
			driver.quit();
		}
	}



}
