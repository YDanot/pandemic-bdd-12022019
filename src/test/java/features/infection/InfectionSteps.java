package infection;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

public class InfectionSteps {

    private City paris;

    @When("^Paris gets infected$")
    public void parisGetsInfected() throws Throwable {
        paris.infect();
    }


    @Given("^(.*) infection level is (\\d+)$")
    public void parisInfectionLevelIsPreviousInfectionLevel(CityName cityName, int infectionLevel) throws Throwable {
        paris = new City(cityName);
        for (int i = 0; i < infectionLevel; i++) {
            paris.infect();
        }
    }

    @Then("^infection level of Paris should (?:be|remain at) (\\d+)$")
    public void infectionLevelOfParisShouldRemainAt(int infectionLevel) throws Throwable {
        Assertions.assertThat(paris.infectionLevel())
                .isEqualTo(infectionLevel);
    }

}
