import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class TC02_NegativeScenario {
    public static void main(String[] args) throws InterruptedException {

        //Browser driver exe
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\jan.seopa\\Downloads\\geckodriver-v0.35.0-win64\\geckodriver.exe");

        //Create chrome instance
        WebDriver driver = new FirefoxDriver();

        //open application
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        //Maximize browser
        driver.manage().window().maximize();
        //Click on Sign in
        driver.findElement(By.linkText("Register")).click();
        //Select Title
        driver.findElement(By.xpath("//*[@id=\"gender-male\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys("Jan");
        driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys("Seopa");
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(".@gmail.com");

        //Enter Password
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("PKR@PKR");
        driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys("PKR@PKR");

        //Click on Register Button
        driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
        //Validate Invalid Email
        String actualMsg = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[2]/div[2]/div[4]/span[2]/span")).getText();

        String errorMsg= "Wrong email";
        //Assert.assertTrue(actualMsg.contains(errorMsg));
        if(actualMsg.equals(errorMsg)) {
           System.out.println("Pass:"+ actualMsg);
         }
       else{
          System.out.println("Test Case Failed");

       }
        //wait 10 sec
        Thread.sleep(3000);
        driver.manage().deleteAllCookies();
        //close browser
        driver.close();
        // calling flush writes everything to the log file
        //extent.flush();
    }
}
