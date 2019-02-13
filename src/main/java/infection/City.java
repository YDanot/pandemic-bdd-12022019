package infection;

import features.outbreak.OutbreakCounter;

import java.util.Objects;

public class City {

    private CityName cityName;
    private int infectionLevel = 0;

    public CityName cityName() {
        return cityName;
    }

    public City(CityName cityName) {
        this.cityName = cityName;
    }

    public void infect(OutbreakCounter outbreakCounter) {
        if (infectionLevel < 3) {
            infectionLevel++;
        }else{
            outbreakCounter.increase();
        }
    }

    public int infectionLevel() {
        return infectionLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return infectionLevel == city.infectionLevel &&
                cityName == city.cityName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName, infectionLevel);
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName=" + cityName +
                ", infectionLevel=" + infectionLevel +
                '}';
    }
}
