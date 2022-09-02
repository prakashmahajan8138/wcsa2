package testpackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Flib;
import pagepackage.LoginPage; 

public class TestActiTimeInvalid extends BaseTest
{
	
	@Test
	public void invalidLogin() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		LoginPage lp = new LoginPage(driver);
		Flib flib = new Flib();
		int rc = flib.getRowCount(EXCEL_PATH, "invalidcreds");
		for(int i=0;i<=rc;i++)
		{
		lp.invalidLoginActiTime(flib.readExcelData(EXCEL_PATH, "invalidcreds", i, 0), flib.readExcelData(EXCEL_PATH, "invalidcreds", i,0));
	
		}
		
	}
}
