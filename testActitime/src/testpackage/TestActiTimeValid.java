package testpackage;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import pagepackage.LoginPage;
import generic.Flib;
public class TestActiTimeValid extends BaseTest{
	
	
	@Test
	public void Login() throws InterruptedException, IOException
	{
		
		LoginPage lp = new LoginPage(driver);
		Flib flib = new Flib();
		String validUsername = flib.readPropertyFile(PROP_PATH, "username");
		String validPassword = flib.readPropertyFile(PROP_PATH, "password");
		
		lp.validLoginActiTime(validUsername, validPassword);
		
		
		
		
	}

}
