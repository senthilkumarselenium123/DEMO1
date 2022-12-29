package com.testng;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import com.code.App;

public class NewTest {
	
  @Parameters("Browser")	
  @Test 
  public void f(String lBrowser) {
	  if(lBrowser.equals("CHROME"))
	  {
		App.sample3();
	  }else
	  {
		  App.sample3();
		  App.sample3();
	  }
  }
  
  @Test
  public void f() {
		  App.sample3();
  }
}
