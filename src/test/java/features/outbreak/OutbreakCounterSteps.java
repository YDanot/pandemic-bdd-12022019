package features.outbreak;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import features.Network;
import game.Game;
import org.assertj.core.api.Assertions;

public class OutbreakCounterSteps {

    private OutbreakCounter outbreakCounter;

    public OutbreakCounterSteps(OutbreakCounter outbreakCounter) {
        this.outbreakCounter = outbreakCounter;
    }


    @And("^outbreak counter is (\\d+)$")
    public void outbreakCounterIs(int outbreakCounter) throws Throwable {
        for (int i = 0; i < outbreakCounter; i++) {
            this.outbreakCounter.increase();
        }
    }

    @Then("^the outbreak counter should be (\\d+)$")
    public void theOutbreakCounterShouldBe(int outbreakCounter) throws Throwable {
        Assertions.assertThat(this.outbreakCounter.counter()).isEqualTo(outbreakCounter);
    }
}
