import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.concurrent.TimeUnit;

//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
public class ExtentReport {
    ExtentSparkReporter extentSparkReporter;
    static ExtentReports extentReports;
    static ExtentTest extentTest;

    @BeforeTest
    public void startReporter() {
        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);


        //configuration items to change the look and feel
        //add content, manage tests etc
        extentSparkReporter.config().setDocumentTitle("Simple Automation Report");
        extentSparkReporter.config().setReportName("Test Report");
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

    @AfterMethod
    public static void main(String[] args) throws InterruptedException {

        // creates a toggle for the given test, adds all log events under it
        ExtentReports extent = new ExtentReports();
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

        // log(Status, details)
        test.log(Status.INFO, "This step open the firefox (Pass, details)");
        //Browser driver exe
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\jan.seopa\\Downloads\\geckodriver-v0.35.0-win64\\geckodriver.exe");

        //Create chrome instance
        WebDriver driver = new FirefoxDriver();
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");

        test.log(Status.PASS, "URL Opened Successfully (Pass, details)");
        //open application
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        test.log(Status.PASS, "The Application Maximized (Pass, details)");
        //Maximize browser
        driver.manage().window().maximize();
        //Click on Sign in
        driver.findElement(By.linkText("Register")).click();
        //Select Title
        driver.findElement(By.xpath("//*[@id=\"gender-male\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys("Jan");
        driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys("Seopa");
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(".@gmail.com");
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
        //Enter Password
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("PKR@PKR");
        driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys("PKR@PKR");

        //Click on Register Button
        driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
        //Validate Invalid Email
        String actualMsg = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[2]/div[2]/div[4]/span[2]/span")).getText();
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
        String errorMsg = "Wrong email";
        //Assert.assertTrue(actualMsg.contains(errorMsg));
        if (actualMsg.equals(errorMsg)) {
            System.out.println("Pass:" + actualMsg);

        } else {
            System.out.println("Test Case Failed");
        }
        //wait 10 sec
        Thread.sleep(3000);
        driver.manage().deleteAllCookies();
        //close browser
        driver.close();
        //to write or update test information to the reporter
        extent.flush();
    }
    }




