package infection;

public class City {

    private CityName cityName;
    private int infectionLevel = 0;

    public CityName cityName() {
        return cityName;
    }

    public City(CityName cityName) {
        this.cityName = cityName;
    }

    public void infect() {
        if (infectionLevel < 3) {
            infectionLevel++;
        }
    }

    public int infectionLevel() {
        return infectionLevel;
    }
}
