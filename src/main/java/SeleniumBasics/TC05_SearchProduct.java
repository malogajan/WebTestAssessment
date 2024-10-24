import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class TC05_SearchProduct {
    public static void main(String[] args) throws InterruptedException{
        //Browser driver exe
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\jan.seopa\\Downloads\\geckodriver-v0.35.0-win64\\geckodriver.exe");

        //Open Application
        WebDriver driver=new FirefoxDriver();
        String URL="https://demowebshop.tricentis.com/";

        // Open Browser and Maximize it
        driver.get(URL);
        driver.manage().window().maximize();

        // Initialise Actions class object
        Actions actions=new Actions(driver);
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        //Select Product
        WebElement ComputerTab=driver.findElement(By.linkText("COMPUTERS"));
        WebElement DesktopTab=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/ul/li[1]/a"));
        actions.moveToElement(ComputerTab).moveToElement(DesktopTab).click().perform();
        Thread.sleep(2000);

        // Get Product Name
        String ProductName=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[6]/div/div[2]/h2/a")).getText();
        System.out.println(ProductName);
        driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]")).sendKeys(ProductName);
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[3]/form/input[2]")).click();

        // Get Name of Searched Product
        String SearchResultProductname=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div/div/div[2]/h2/a")).getText();

        // Verify that correct Product is displaying after search
        if(ProductName.equalsIgnoreCase(SearchResultProductname)) {
            System.out.println("Results Matched;Test Case Passed");
        }else{
            System.out.println("Results NotMatched;Test Case Failed");
        }

        //wait 10 sec
        Thread.sleep(3000);
        driver.manage().deleteAllCookies();
        //close browser
        driver.close();
    }
}
