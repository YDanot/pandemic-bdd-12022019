package features.infection;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import game.Game;
import infection.City;
import infection.CityName;
import org.assertj.core.api.Assertions;

public class InfectionSteps {

    private City paris;
    private Game game;

    public InfectionSteps(Game game) {
        this.game = game;
    }

    @When("^PARIS gets infected$")
    public void parisGetsInfected() throws Throwable {
        infect(paris);
    }


    @Given("^(.*) infection level is (\\d+)$")
    public void parisInfectionLevelIsPreviousInfectionLevel(CityName cityName, int infectionLevel) throws Throwable {
        paris = new City(cityName);
        for (int i = 0; i < infectionLevel; i++) {
            infect(paris);
        }
    }

    private void infect(City city) {
        game.infect(city);
    }

    @Then("^infection level of PARIS should (?:be|remain at) (\\d+)$")
    public void infectionLevelOfPARISShouldRemainAt(int infectionLevel) throws Throwable {
        Assertions.assertThat(paris.infectionLevel())
                .isEqualTo(infectionLevel);
    }

    @And("^the cities should have the following infection levels:$")
    public void theCitiesShouldHaveTheFollowingInfectionLevels() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
