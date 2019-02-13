package game;

import features.Network;
import features.outbreak.OutbreakCounter;
import infection.City;

public class Game {

    private final OutbreakCounter outbreakCounter;
    private final Network network;

    public Game(OutbreakCounter outbreakCounter, Network network) {
        this.outbreakCounter = outbreakCounter;
        this.network = network;
    }

    public void infect(City city) {
        city.infect(outbreakCounter);
    }

    public boolean isLost() {
        return outbreakCounter.counter() >= 8;
    }

    public Network network() {
        return network;
    }
}
