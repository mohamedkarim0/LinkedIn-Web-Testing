package stepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(features = "ReopenJobOfferFeature",
				 glue= {"stepDefinitions"})

public class ReopenJobOfferTestRunner {

}
