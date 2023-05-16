package testNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class class01 {
    @AfterTest
    public void tc3() {
    	System.out.println("I should run after execution of all the tests");
    }
	@Test
	public void tc1() {
		 System.out.println("tc1==done");
	}
	
	@Test
	public void tc2() {
		System.err.println("tc2==done");
	}
	@BeforeTest
	public void tc4() {
		System.out.println("I should run before all the tests execution");
	}
	@Test(enabled = false)
	public void containBug() {
		 System.out.println(" ** It contains bug ** ");
	}
	@BeforeSuite
	public void tc() {
		System.out.println("I should run before all tests executed at the suite level");
	}
}
