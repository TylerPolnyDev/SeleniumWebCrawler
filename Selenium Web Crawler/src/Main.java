import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        System.out.println("- SWebCrawler Start -");

        System.out.println("creating chrome driver");

        String email = "tyler.polny.developer@gmail.com";
        String password = "Ferret^2001";
        String jobTitle = "back end developer -Engineer -Senior -ruby -Android -WordPress -stack $40,000 - $90,000";
        String jobLocation = "remote";

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Sierra\\IdeaProjects\\LibraryRepository\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        System.out.println("calling indeed sign in page");
        driver.get("https://secure.indeed.com/");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("Page Title:\n"+title);

        System.out.println("Logging in");
        driver.findElement(By.id("ifl-InputFormField-3")).sendKeys(email + Keys.ENTER);
        WebElement passwordFallback = new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.elementToBeClickable(By.id("auth-page-google-password-fallback")));
        passwordFallback.click();
        driver.findElement(By.id("ifl-InputFormField-166")).sendKeys(password + Keys.ENTER);

        System.out.println("Waiting for user input...");
        WebElement findJob = new WebDriverWait(driver,Duration.ofMinutes(2))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("FindJobs")));
        findJob.click();

        System.out.println("Setting up search");
        driver.findElement(By.id("text-input-what")).sendKeys(jobTitle + Keys.TAB + jobLocation + Keys.ENTER);
        driver.navigate().to(driver.getCurrentUrl()+"&fromage=14");

        System.out.println("Returning results");
        //WebElement resultsList = driver.findElement(By.className("jobsearch-ResultsList"));
        //System.out.println(resultsList.getText());

        System.out.println("applying to first job listing");
        WebElement ApplyButton = driver.findElement(By.id("indeedApplyButton"));
        ApplyButton.click();


















        System.out.println("- SWebCrawler Finish -");

    }

}