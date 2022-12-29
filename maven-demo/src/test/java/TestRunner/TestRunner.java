package TestRunner;

import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;		

@RunWith(Cucumber.class)				
@CucumberOptions(features="C:\\Users\\infok\\eclipse-workspace\\maven-demo\\Features\\MyTest.feature",glue={"src.test.java.StepDefinition"},monochrome = true,
dryRun=false)						
public class TestRunner 				
{		

}