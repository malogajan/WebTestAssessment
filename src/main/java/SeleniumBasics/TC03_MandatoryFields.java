import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TC03_MandatoryFields {
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
        driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("");

        //Enter Password
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys("");

        //Click on Register Button
        driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
        //Validate Invalid Email
        String FirstName = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[2]/div[2]/div[2]/span[2]/span")).getText();
        String LastName = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[2]/div[2]/div[3]/span[2]/span")).getText();
        String errorMSG = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[2]/div[2]/div[2]/span[2]/span")).getText();
        String Password = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[3]/div[2]/div[1]/span[2]/span")).getText();
        String CPassword = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[3]/div[2]/div[2]/span[2]/span")).getText();

        // Declare the message title
        String expectedEmails = "Email is required.";
        String expectedFirstNameMSG = "First name is required.";
        String expectedLastNameMSG = "Last name is required.";
        String expectedPasswordMSG = "Password is required.";
        String expectedCPasswordMSG = "Password is required.";

//        Assert.assertTrue(FirstName.contains(expectedFirstNameMSG));
//            System.out.println("Pass:" + expectedFirstNameMSG);


        if(errorMSG.equals(expectedEmails)) {
            System.out.println("Pass: " + expectedEmails);
        }
        else{
            System.out.println("Failed: " + expectedEmails);

        }
        if(FirstName.equals(expectedFirstNameMSG)) {
            System.out.println("Pass: " + expectedFirstNameMSG);
        }
        else{
            System.out.println("Failed: " + expectedFirstNameMSG);

        }
        if(LastName.equals(expectedLastNameMSG)) {
            System.out.println("Pass: " + expectedLastNameMSG);
        }
        else{
            System.out.println("Failed: " + expectedLastNameMSG);

        }
        if(Password.equals(expectedPasswordMSG)) {
            System.out.println("Pass: " + expectedPasswordMSG);
        }
        else{
            System.out.println("Failed: " + expectedPasswordMSG);

        }
        if(CPassword.equals(expectedCPasswordMSG)) {
            System.out.println("Pass: " + expectedCPasswordMSG);
        }
            else{
                System.out.println("Failed: " + expectedCPasswordMSG);
        }
        //wait 10 sec
        Thread.sleep(3000);
        driver.manage().deleteAllCookies();
        //close browser/ Application
        driver.close();
    }
}
