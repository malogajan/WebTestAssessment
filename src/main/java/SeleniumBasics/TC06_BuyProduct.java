import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC06_BuyProduct {
    public static void main(String[] args) throws InterruptedException, SQLException {
        //Browser driver exe
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\jan.seopa\\Downloads\\geckodriver-v0.35.0-win64\\geckodriver.exe");

        //Open Application
        WebDriver driver = new FirefoxDriver();
        String URL = "https://demowebshop.tricentis.com/";

        // Open Browser and Maximize it
        driver.get(URL);
        driver.manage().window().maximize();
        // Initialise Actions class object
        Actions actions=new Actions(driver);
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(4000, TimeUnit.MILLISECONDS);

        //Click on Sign in
        driver.findElement(By.linkText("Log in")).click();
        //Login
        driver.findElement(By.xpath("//*[@id=\"Email\"]\n")).sendKeys("malogajan92@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"Password\"]\n")).sendKeys("0787246@Jm");
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();

        //Select Product
        WebElement ComputersTab = driver.findElement(By.linkText("COMPUTERS"));
        WebElement DesktopTab=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/ul/li[1]/a"));
        actions.moveToElement(ComputersTab).moveToElement(DesktopTab).click().perform();
        Thread.sleep(2000);
        // Get Product Name
        String ProductName=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[6]/div/div[2]/h2/a\n")).getText();
        System.out.println(ProductName);

        //driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]")).sendKeys(ProductName);
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[6]/div/div[2]/h2/a\n")).click();

        // Get Name of Searched Product
        //String SearchResultProductname=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div/div/div[2]/h2/a")).getText();

        //Change quantity by 2
        driver.findElement(By.xpath("//*[@id=\"addtocart_75_EnteredQuantity\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"addtocart_75_EnteredQuantity\"]")).sendKeys("2");
        //Select Processor
        driver.findElement(By.xpath("//*[@id=\"product_attribute_75_5_31_96\"]\n")).click();
        //Select RAM/ HDD
        //WebElement CheckBox = driver.findElement(By.xpath("//*[@id=\"product_attribute_75_8_35_108\"]"));
        //Select oSelect = new Select(CheckBox);
        //oSelect.selectByVisibleText("Office Suite");

        //Select Checkbox
        driver.findElement(By.xpath("//*[@id=\"product_attribute_75_8_35_108\"]")).click();

        //Click on add to cart
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-75\"]")).click();

        //Click on proceed
        driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")).click();
        System.out.println(By.id("termsofservice"));
        //Agree terms&Conditions
        driver.findElement(By.xpath("//*[@id=\"termsofservice\"]")).click();

        //Click on checkout button to proceed without selecting terms and conditions
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        //Close the alert dialog box
        //driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[2]/div[2]/div[2]")).click();


        //Click on checkout button to proceed
//        try {
//            WebElement Checkout = driver.findElement(By.xpath("//*[@id=\"termsofservice\"]\n"));
//            actions.click(Checkout);
//        } catch (UnhandledAlertException f) {
//            try {
//                Alert alert = driver.switchTo().alert();
//                String alertText = alert.getText();
//                System.out.println("Alert data: " + alertText);
//                alert.accept();
//            } catch (NoAlertPresentException e) {
//                e.printStackTrace();
//            }
//        }
        //driver.findElement(By.xpath("//*[@id=\"termsofservice\"]\n")).click();

        //Billing Address
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_FirstName\"]\n")).sendKeys("Jan");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_LastName\"]\n")).sendKeys("Seopa");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_Email\"]\n")).sendKeys("malogajan92@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_Company\"]\n")).sendKeys("Qmart");
        // Select
        WebElement Country = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]"));
        Select tSelect = new Select(Country);
        tSelect.selectByVisibleText("South Africa");

        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_City\"]\n")).sendKeys("Midrand");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_Address1\"]\n")).sendKeys("45 Bougan Villa");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_ZipPostalCode\"]\n")).sendKeys("1632");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_PhoneNumber\"]\n")).sendKeys("0787246765");

        //Click on Continue to checkout
        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/input")).click();

        //Click on continue button to check out
        driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")).click();
        //Confirm Shipping Methods
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")).click();
        //Confirm Payment Method
        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click();
        //Confirm Payment Information
        driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")).click();
        //Confirm the Order
        driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")).click();

        //Get Text
        String ConfirmationText = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong\n']")).getText();

        String actualMSG = "Your order has been successfully processed!";
        // Verify that Product is ordered
        if (ConfirmationText.contains(actualMSG)) {
            System.out.println("Pass:"+ actualMSG);
        } else {
            System.out.println("Failed:Order Not Successfull");

        }
    }
}
