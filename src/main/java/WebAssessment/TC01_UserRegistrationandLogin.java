package WebAssessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TC01_UserRegistrationandLogin {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int boundedInt = random.nextInt(1000);

   //Browser driver exe
 System.setProperty("webdriver.gecko.driver","C:\\Users\\jan.seopa\\Downloads\\geckodriver-v0.35.0-win64\\geckodriver.exe");

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
        driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys(new CharSequence[]{"Seopa" + boundedInt });
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(new CharSequence[]{boundedInt+ "malogajan@gmail.com" });

        //Enter Password
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("PKR@PKR");
        driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys("PKR@PKR");

        //Click on Register Button
        driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();

//  //Select Date of Birth
//        WebElement DOB=driver.findElement(By.xpath("//*[@id=\"days\"]"));
//        Select oSelect=new Select(DOB);
//        oSelect.selectByValue("4");

//        driver.findElement(By.xpath("//*[@id=\"months\"]")).sendKeys("June");
//       driver.findElement(By.xpath("//*[@id=\"years\"]")).sendKeys("1992");
//
  //Click on Register Button
//        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();
        String userText=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]\n")).getText();

        //Validate that user has created
        if(userText.contains("Your Registration Completed")) {
            System.out.println("User Verified,Test case Passed");
        }
        else {
            System.out.println("User Verification Failed,Test case Failed");
        }
//        //Email Already Exist
//        String exists=driver.findElement(By.linkText("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[1]/div/ul/li")).getText();
//
//        if(exists.contains("exists")) {
//            System.out.println("The specified email already exists");
//        }
//        else {
//            System.out.println("Please provide different email to register or continue to login");
//        }
  //wait 10 sec
  Thread.sleep(3000);
  driver.manage().deleteAllCookies();
  //close browser
        driver.close();
    }
}

