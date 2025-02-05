package test;
import static io.restassured.RestAssured.given;
import static io.restassured.path.xml.XmlPath.CompatibilityMode.HTML;
import static org.junit.Assert.assertEquals;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class Steps {

    @Managed
    WebDriver driver; //using serenity for chrome driver

    // Extent Report
    private static ExtentReports extent;
    private static ExtentTest test;

    static {
        // Setting Extent Report Path
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("target/extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Given("verify Html")
    public void verifyHtml() throws IOException {
        test = extent.createTest("verify Html Test").assignCategory("Regression").pass("verify Html Test Started");
        driver.get("https://www.tutorialspoint.com/about/about_careers.htm");

        test.assignAuthor("Selenium Test");





        //extract HTML response from endpoint
        Response r = given()
                .when()
                .get("https://www.tutorialspoint.com/about/about_careers.htm")
                .then().contentType(ContentType.HTML).extract()
                .response();

        String responseBody = r.getBody().asPrettyString();

        // Convert XML body to string
        XmlPath p = new XmlPath(HTML, responseBody);

        // Obtain HTML page title
        String pageTitle = p.getString("html.head.title");
        System.out.println("Page Title: " + pageTitle);
        // Verify title with assertion
        try {
            assertEquals(pageTitle, "Latest Job Openings");
            test.pass("Title verified successfully"); // adding log in extent report
            MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build();
            test.pass("details", mediaModel);
        } catch (AssertionError e) {
            test.fail("Title verification failed"); // adding log in extent report
        }

        driver.quit();
        extent.flush();

        // Print Extent Report paths
        System.out.println("[INFO]   - Full Report: file://" + System.getProperty("user.dir") + "/target/extent.html");
    }
}