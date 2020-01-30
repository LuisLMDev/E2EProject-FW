package Softtek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public void InitializeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Projects\\E2EProject\\src\\main\\java\\Softtek\\data.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        switch (browserName.toLowerCase()) {

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Projects\\E2EProject\\src\\main\\libs\\chromedriver.exe");
                WebDriver driver = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Projects\\E2EProject\\src\\main\\libs\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;

            case "edge":
                System.setProperty("webdriver.edge.driver", "C:\\Projects\\E2EProject\\src\\main\\libs\\msedgedriver.exe");
                driver = new EdgeDriver();

            default:
                System.out.println("Driver no soportado");

        }

    }

}
