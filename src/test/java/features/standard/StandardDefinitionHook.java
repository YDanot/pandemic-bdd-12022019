package features.standard;

import cucumber.api.java.Before;
import game.Game;

public class StandardDefinitionHook {

    private final Game game;

    public StandardDefinitionHook(Game game) {
        this.game = game;
    }

    @Before("~@occidental")
    public void occidental() throws Throwable {
        new StandardDefinitionSteps(game).theOccidentInitialSubNetwork();
    }
}
