package tests;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utility.ConfigRead;

public class BaseTest {
    
    
    WebDriver driver;
    Actions act;
    ConfigRead conf;
    Logger log;
    LoginPage lp;
    //public LoginPage lp;
    
    @BeforeTest
    public void launchApp() throws Exception {

        
        //log file
        
        log = Logger.getLogger("NOP Comm Login Module");
        PropertyConfigurator.configure(".\\testData\\log4j.properties");
        
        
        

        //Create an Object Config
        
        conf = new ConfigRead();
        
        log.info("launching chrome browser.");
        
        
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();   //session get created
        
        
        
        //create an Object of Action class
        
        act = new Actions(driver);
        lp = new LoginPage(driver);
        
        
        
        driver.manage().window().maximize();
        log.info("launching application: " + conf.getNOPComm());
        driver.get(conf.getNOPComm());

    }

    @AfterTest
    public void closingApp() throws Exception {

        Thread.sleep(5000);
        driver.close();
        log.info("chrome browser closed.");
        
    }
    

}
