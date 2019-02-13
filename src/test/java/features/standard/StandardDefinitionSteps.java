import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import features.Network;
import game.Game;
import infection.CityName;
import org.assertj.core.api.Assertions;

import static infection.CityName.*;

public class StandardDefinitionSteps {

    private Game game;

    public StandardDefinitionSteps(Game game) {
        this.game = game;
    }


    @Given("^the occident initial sub-network$")
    public void theOccidentInitialSubNetwork() throws Throwable {
        Network network = createCities(PARIS, LONDON, MADRID, ESSEN, MILAN, ALGIERS, NEW_YORK);

        network.addLink(PARIS, LONDON);
        network.addLink(PARIS, MADRID);
        network.addLink(PARIS, ESSEN);
        network.addLink(PARIS, MILAN);
        network.addLink(PARIS, ALGIERS);
        network.addLink(LONDON, ESSEN);
        network.addLink(LONDON, MADRID);
        network.addLink(ALGIERS, MADRID);
        network.addLink(MILAN, ESSEN);
    }

    private Network createCities(CityName... cityNames) {
        Network network = new Network();
        for (CityName cityName : cityNames) {
            network.addCity(cityName);
        }
        return network;
    }

    @Then("^the network should be:$")
    public void theNetworkShouldBe(Network network) throws Throwable {
        Assertions.assertThat(game.network()).isEqualTo(network);
    }
}
