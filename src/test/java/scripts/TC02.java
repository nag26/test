package scripts;

import org.testng.annotations.Test;

import config.StartBrowser;
import reuse.BusinessFunctions;

public class TC02 extends StartBrowser {
  @Test
  public void SaveMiddleName() throws Exception 
  {
	  BusinessFunctions bf = new BusinessFunctions();
	  bf.login();
	  Thread.sleep(1000);
	  bf.midlename();
	  bf.logout();
  }
}
