import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TC04_IncorrectPassword {
        public static void main (String[]args) throws InterruptedException {

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
            driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys("Marko");
            driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("Jck@gmail.com");

            //Enter Password
            driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("567");
            driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys("++D");

            //Click on Register Button
            driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
            //Validate Invalid Email
            String Password = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[3]/div[2]/div[1]/span[2]/span")).getText();
            String CPassword = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[3]/div[2]/div[2]/span[2]/span")).getText();


            String expectedPasswordMSG1 = "The password should have at least 6 characters.";
            String expectedCPasswordMSG2 = "The password and confirmation password do not match.";

            //Assert.assertTrue(FirstName.contains(errorMsg));

            if(Password.equals(expectedPasswordMSG1)) {
                System.out.println("Pass: " + expectedPasswordMSG1);
            }
            else{
                System.out.println("Failed: " + expectedPasswordMSG1);

            }
            if(CPassword.equals(expectedCPasswordMSG2)) {
                System.out.println("Pass: " + expectedCPasswordMSG2);
            }
            else{
                System.out.println("Failed: " + expectedCPasswordMSG2);
            }
                //wait 10 sec
                Thread.sleep(3000);
                driver.manage().deleteAllCookies();
                //close browser
                driver.close();
            }
}
