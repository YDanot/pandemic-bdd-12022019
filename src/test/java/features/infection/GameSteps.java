package features.infection;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import game.Game;
import org.assertj.core.api.Assertions;

public class GameSteps {

    private Game game;

    public GameSteps(Game game) {
        this.game = game;
    }

    @And("^the game should be lost$")
    public void theGameShouldBeLost() throws Throwable {
        Assertions.assertThat(game.isLost()).isTrue();
    }

}
