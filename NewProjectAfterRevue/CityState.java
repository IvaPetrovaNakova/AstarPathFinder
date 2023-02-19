package NewProjectAfterRevue;

import java.util.Objects;

public class CityState {

    public String city;

    public CityState(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return this.city;
    }

    @Override
    public boolean equals(Object obj) {
        boolean retVal = false;
        if (obj instanceof problem.State){
            problem.State ptr = (problem.State) obj;
            retVal = ptr.city.equals(this.city);
        }
        return retVal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city);
    }
}
