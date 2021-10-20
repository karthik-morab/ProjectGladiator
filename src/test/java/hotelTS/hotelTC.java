package hotelTS;


import hotel.*;
import com.url.*;
 
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
 
public class hotelTC extends Base {
    @Test(priority = 1)
    public void Url1() {
    	logger=report.createTest("URL test");
    	logger.info("Starting the web application");
    	Url u =new Url();
    	HotelElements e = new HotelElements(driver);
    	String site = u.getUrl(); //getting url
        driver.manage().window().maximize(); //maximizing window 
        driver.get(site);//visiting url
        logger.pass("success");
    
    }
 
    @Test(priority = 2, dependsOnMethods = "Url1", description = "Without entering Location")
    public void withoutEnteringLocation() throws Exception {
        HotelElements e = new HotelElements(driver);
        logger=report.createTest("Testcase Without entering Location");
    	logger.info("Starting the web application");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //wait statement
        logger.info("click on hotel");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        e.clickHotel(); //click on hotels tab
        logger.info("click on search button");
        e.searchHotels(); //click on search
        String a = e.checkErr1(); //checking error message
        Assert.assertEquals(a, "Enter Location"); //comparing statements
        logger.pass("ERROR: Please Enter Location");
    
    }


    @Test(priority = 3, dependsOnMethods = "withoutEnteringLocation", description = "Testing Search page with no rooms")
    public void testingSearchPageWithNoRooms() throws Exception {
    	logger=report.createTest("Testing Search page with no rooms");
    	logger.info("Starting the web application");
        HotelElements e = new HotelElements(driver);
        HotelCredentials cred = new HotelCredentials();
        String num = cred.location();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 
        e.setLocation(num); //setting destination
 
        e.clickGuest(); //enter number of guests
        String s = e.roomMin(); //checking error message
        Assert.assertEquals(s, "Minimum 1 is required"); //comparing status
        logger.pass("ERROR: Minimum 1 is required");
        
 
    }
 
    @Test(priority = 4, dependsOnMethods = "testingSearchPageWithNoRooms", description = "Testing Search page with no adults")
    public void testingSearchPageWithNoAdults() throws Exception {
    	logger=report.createTest("Testing Search page with no adults");
    	logger.info("Starting the web application");
        HotelElements e = new HotelElements(driver);
 
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 
        String s = e.adultMin(); //checking error message
        Assert.assertEquals(s, "Minimum 1 adult is required"); //comparing statements
        logger.pass("ERROR: Minimum 1 adult is required");
    }

 
    @Test(priority = 5, dependsOnMethods = "testingSearchPageWithNoAdults", description = "Testing Search page with max rooms")
    public void testingSearchPageWithMaxRooms() throws Exception {
        HotelElements e = new HotelElements(driver);
        logger=report.createTest("Testing Search page with max rooms");
    	logger.info("Starting the web application");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 
        String s = e.roomMax(); //checking error message
        Thread.sleep(2000); //pausing thread
        Assert.assertEquals(s, "Max allowed upto 8"); //comparing statements
        logger.pass("ERROR: Max allowed upto 8");
    }
    @Test(priority = 6, dependsOnMethods = "testingSearchPageWithMaxRooms", description = "Testing Search page with more than 16 adults")
    public void testingSearchPageWithMoreThan16Adults() throws Exception {
        HotelElements e = new HotelElements(driver);
        logger=report.createTest("Testing Search page with more than 16 adults");
    	logger.info("Starting the web application");
 
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 
        String s = e.adultMax(); //checking error message
        Assert.assertEquals(s, "Max allowed upto 16");
        logger.pass("ERROR: Max allowed upto 16");//comparing statements
 
    }
 
    @Test(priority = 7, dependsOnMethods = "testingSearchPageWithMoreThan16Adults", description = "child limit")
    public void childLimit() throws Exception {
        HotelElements e = new HotelElements(driver);
        logger=report.createTest("child limit");
    	logger.info("Starting the web application");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 
        String s = e.childMin(); //checking error message
        Assert.assertEquals(s, "Not allowed"); //comparing statements
        logger.pass("ERROR: Not allowed");//comparing statements
    }
 
    @Test(priority = 8, dependsOnMethods = "childLimit", description = "Testing Search page with valid details")
    public void testingSearchPageWithValidDetails() throws Exception {
    	 logger=report.createTest("Testing Search page with valid details");
     	logger.info("Starting the web application");
        HotelElements e = new HotelElements(driver);
 
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 
        e.clickDate(); //select date button
        e.enterCheckInDate(); //enter check in date
        e.enterCheckOutDate(); //enter checkout date
        
       e.clickGuest(); //enter number of guests
        e.clickDone(); //click done button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        e.searchHotels(); //click on search hotels button
        Assert.assertTrue(driver.getCurrentUrl().contains("find-hotels-in"));
        logger.pass("Success");
    }
 
    @Test(priority = 9, dependsOnMethods = "testingSearchPageWithValidDetails", description = "Booking Hotel without entering First or Middle Name")
    public void bookHotelWithNoName() throws Exception {
    	logger=report.createTest("Booking Hotel without entering First or Middle Name");
      	logger.info("Starting the web application");
        HotelElements e = new HotelElements(driver);
        HotelBooking n = new HotelBooking(driver);
 
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 
        e.selectHotel(); //select hotel
        e.clickviewroomopt(); //click on view room
        e.clickSelectHotel(); //click on select button
        n.clickproceed(); //click on proceed button
        boolean x = e.checkErr2(); //check error
        Assert.assertTrue(x); //verifying presence
        logger.pass("Success");
 
    }

    @Test(priority = 10, dependsOnMethods = "bookHotelWithNoName", description = "Booking Hotel with invalid email")
    public void bookHotelWithInvalidEmail() throws Exception {
    	logger=report.createTest("Booking Hotel with invalid email");
      	logger.info("Starting the web application");
        HotelElements e = new HotelElements(driver);
        HotelBooking n = new HotelBooking(driver);
        HotelCredentials cred = new HotelCredentials();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 
        n.enterFName(cred.validFirstName()); //enter first name
        n.enterLName(cred.validLastName()); //enter last name
        n.enterMobileNo(cred.validNumber()); //enter mobile number
        n.enterEmail(cred.invalidEmail()); //enter email id
        n.dropdown(cred.selectTitle()); //select title from dropdown
        n.clickproceed(); //click on proceed button
 
        boolean x = e.checkErr3(); //checking error element 
        Assert.assertTrue(x); //verifying presence
        logger.pass("Success");
 
    }
 
    @Test(priority = 11, dependsOnMethods = "bookHotelWithInvalidEmail", description = "Booking Hotel with invalid Number")
    public void bookHotelWithValidEmail() throws Exception {
    	logger=report.createTest("Booking Hotel with invalid Number");
      	logger.info("Starting the web application");
        HotelElements e = new HotelElements(driver);
        HotelBooking n = new HotelBooking(driver);
        HotelCredentials cred = new HotelCredentials();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 
        n.enterFName(cred.validFirstName()); //enter first name
        n.enterLName(cred.validLastName());//enter last name
        n.enterMobileNo(cred.invalidLongNum());//enter number
        n.enterEmail(cred.validEmail());//enter email id
        n.dropdown(cred.selectTitle());//select title from dropdown 
        n.clickproceed(); //click on proceed
        boolean x = e.checkErr4(); //checking error statement
        Assert.assertTrue(x); //verifying presence
        logger.pass("Success");
 
    }
 
    @Test(priority = 12, dependsOnMethods = "bookHotelWithValidEmail", description = "Booking Hotel with all valid details")
    public void bookHotelWithValidDetails() throws Exception {
    	logger=report.createTest("Booking Hotel with invalid Number");
      	logger.info("Starting the web application");
        HotelBooking n = new HotelBooking(driver);
        HotelCredentials cred = new HotelCredentials();
        
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 
        n.enterFName(cred.validFirstName()); //enter first name
        n.enterLName(cred.validLastName()); //enter last name
        n.enterMobileNo(cred.validNumber()); //enter mobile number
        n.enterEmail(cred.validEmail()); //enter email id
        n.dropdown(cred.selectTitle());//selecct title from dropdown
        n.clickproceed(); //click on proceed
        Assert.assertTrue(driver.getCurrentUrl().contains("nhotel-booking")); //verifying webpage
        logger.pass("Success");
    }
 
}