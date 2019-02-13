package features;

import infection.City;
import infection.CityName;

import java.util.*;
import java.util.stream.Collectors;

public class Network {

    private final Set<Link> links = new HashSet<>();
    public final Map<CityName, City> cityMap = new HashMap<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Network)) return false;
        Network network = (Network) o;
        return Objects.equals(links, network.links) &&
                Objects.equals(cityMap, network.cityMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(links, cityMap);
    }

    public void addLink(CityName cityName1, CityName cityName2) {
        links.add(new Link(cityName1, cityName2));
    }

    public City addCity(CityName name) {
        return cityMap.put(name, new City(name));
    }

    @Override
    public String toString() {
        return "Network{" +
                "links=" + links +
                ", cityMap=" + cityMap +
                '}';
    }

    public Set<CityName> citiesLinkedTo(CityName cityName) {
        return links.stream()
                .filter(l -> l.contains(cityName))
                .map(l -> l.other(cityName).orElseThrow(SingleCityInLinkException::new)).collect(Collectors.toSet());
    }

    public boolean areLinked(CityName cityName, CityName cityName2) {
        return links.stream()
                .filter(l -> l.contains(cityName)).anyMatch(l -> l.contains(cityName2));
    }

    public City get(CityName cityName) {
        return cityMap.get(cityName);
    }

    private class Link {
        private final Set<CityName> cityNames = new HashSet<>();

        private Link(CityName cityName1, CityName cityName2) {
            assertCitiesNotNull(cityName1, cityName2);
            cityNames.add(cityName1);
            cityNames.add(cityName2);
        }

        private void assertCitiesNotNull(CityName cityName1, CityName cityName2) {
            if (cityName1 == null || cityName2 == null) {
                throw new NullPointerException("city " + (cityName1 == null ? "1" : "2") + " must be defined");
            }
        }

        private boolean contains(CityName cityName) {
            return cityNames.contains(cityName);
        }

        private Optional<CityName> other(CityName cityName) {
            if (!cityNames.contains(cityName)) {
                return Optional.empty();
            }
            return cityNames.stream().filter(c -> !c.equals(cityName)).findFirst();

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Link)) return false;
            Link link = (Link) o;
            return Objects.equals(cityNames, link.cityNames);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cityNames);
        }

        @Override
        public String toString() {
            return "Link{" +
                    "cityNames=" + cityNames +
                    '}';
        }
    }

    private class SingleCityInLinkException extends RuntimeException {
    }
}
