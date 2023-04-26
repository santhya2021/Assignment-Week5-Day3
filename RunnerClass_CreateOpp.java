package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Features/CreateOppourtunity.feature",glue="steps",monochrome=true,publish=true)

 
public class RunnerClass_CreateOpp extends AbstractTestNGCucumberTests {

}
