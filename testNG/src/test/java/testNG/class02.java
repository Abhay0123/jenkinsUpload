package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class class02 {
      
	@Test
	public void webLoginToOrangeHrm() {
		System.out.println("login to website orangehrm");
	}
	@Test
	public void webLogoutToOrangeHrm() {
		System.out.println("logout to website orangehrm");
	}
	@Test
	public void MobileloginToOrangeHrm() {
		System.out.println("login to mobile orangehrm");
	}
	@Test
	public void MobilelogoutToOrangeHrm() {
		System.out.println("logout to mobile orangehrm");
	}
	@AfterSuite
	public void tc() {
		System.out.println("I should run after all tests executed at the suite level");
	}
    @BeforeMethod
    public void beforemethod() {
		System.out.println("I should run before each method");
	}
    @AfterMethod
    public void aftermethod() {
		System.out.println("I should run after each method");
	}
}
