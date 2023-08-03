package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	static {
		FileInputStream file;
		try {
			file = new FileInputStream("user.dir" + "/Salesforceregistration/src/test/java/resources/env.properties");
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public void BrowserSetup() {
		String browser = prop.getProperty("browser");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();

		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		} else if (browser.equals("safari")) {
			WebDriverManager.safaridriver().setup();
		}

	}

	public void UrlLaunch() {
		driver.get(prop.getProperty("url"));
	}

	public void CloseBrowser() {
		driver.close();

	}

	public WebElement ExplicitWait(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

	}

}
