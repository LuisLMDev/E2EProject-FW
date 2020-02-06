package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;

    public WebDriver InitializeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src\\main\\java\\resources\\data.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        String url = prop.getProperty("url");

        switch (browserName.toLowerCase()) {

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Projects\\E2EProject-FW\\src\\main\\libs\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.get(url);
                driver.manage().window().maximize();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Projects\\E2EProject-FW\\src\\main\\libs\\geckodriver.exe");
                driver = new FirefoxDriver();
                driver.get(url);
                driver.manage().window().maximize();
                break;

            case "edge":
                System.setProperty("webdriver.edge.driver", "C:\\Projects\\E2EProject-FW\\src\\main\\libs\\msedgedriver.exe");
                driver = new EdgeDriver();
                driver.get(url);
                driver.manage().window().maximize();
                break;

            default:
                System.out.println("Driver no soportado");
                break;

        }

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return driver;

    }


}
