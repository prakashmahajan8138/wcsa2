package testpackage;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Flib;
import pagepackage.Homepage;
import pagepackage.LoginPage;

public class TestActiTimeCreateUser extends BaseTest {
	
	@Test
	public void createUser() throws InterruptedException, IOException
	{
	LoginPage lp = new LoginPage(driver);
	Flib flib=new Flib();
	lp.invalidLoginActiTime(flib.readPropertyFile(PROP_PATH, "username"), flib.readPropertyFile(PROP_PATH, "password"));
	
	new Homepage(driver).logoutActitime();
		
	}

}
