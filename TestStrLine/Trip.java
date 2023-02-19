package TestStrLine;

public class Trip implements Comparable<Trip> {
    private final City fromCity;
    private City toCity;
    private int travelDistance;

    /**
     * Class constructor
     * @param fromCity starting point
     * @param toCity ending point
     * @param travelDistance distance between
     */
    public Trip(
            City fromCity,
            City toCity,
            int travelDistance
    ) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.travelDistance = travelDistance;
    }

    /**
     * Gives the City departed from
     *
     * @return City
     */
    public City getFromCity() {
        return fromCity;
    }

    /**
     * Gives the City destination
     *
     * @return City
     */
    public City getToCity() {
        return toCity;
    }

    public int getTravelDistance() {
        return travelDistance;
    }

    /**
     * Checks if two cities are equal.
     * They are equal if they both are duplicated trips
     * Guarantee the root to be the city starting from
     *
     * @param city get current city
     * @return True if they are equal. False otherwise
     */
    public City sameCity(City city) {
        if (city.cityName.equals(fromCity.cityName)) {
            return toCity;
        } else if (city.cityName.equals(toCity.cityName)) {
            return fromCity;
        } else {
            return null;
        }
    }

    /**
     * Checks if two trips are equal.
     * They are equal if they both are duplicated trips.
     *
     * @param path to be compared
     * @return True if they are equal. False otherwise
     */
    @Override
    public int compareTo(Trip path) {
        double temp = travelDistance - path.travelDistance;
        if (temp > 0) {
            temp = 1;
        } else if (temp < 0) {
            temp = -1;
        }
        return (int) temp;
    }

    @Override
    public String toString() {
        return fromCity.getCityName() + " -> "
                + toCity.getCityName()
                + " (Travel Distance: " + getTravelDistance() + " )";
    }
}

