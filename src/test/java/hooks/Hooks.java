package hooks;

import java.io.File;



import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks extends BaseClass {
	
	@Before
	public void setup(Scenario scenario) {
		System.out.println("==========Testing Started=============");
		System.out.println("Scenario Start: " +scenario.getName());
		loadConfig();
		launchBrowser();}
		
		@Before("@Smoke")
		public void beforesmoke() {
			System.out.println("==========Running Smoke Test=============");
			}
		@Before("@regression")
		public void beforeregression() {
			System.out.println("==========Running Regression Test=============");
			}
	


	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			System.out.println("Test Failed"+scenario.getName());
			String folderpath ="Extenet/screenshots";
			String imgPath = captureScreen(scenario.getName(), folderpath);
			try {
				byte[] fileContent = java.nio.file.Files.readAllBytes(new File(imgPath).toPath());
				String relativePath = "screenshots/" + new File(imgPath).getName();
				com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(relativePath);
			}
			catch(Exception e) 
			{e.getStackTrace();
			}
			System.out.println("Test Failed: " +scenario.getName());
		}
			
			else {
				System.out.println("Test Passed: " +scenario.getName());
			}
			
		
		closeBrowser();
		System.out.println("==========Testing Completed=============");
	}
}
