/* Imports */
import java.util.Comparator;

public class NameComparator implements Comparator<Restaurant> {
    @Override
    public int compare(Restaurant restaurant1, Restaurant restaurant2) {
        return (restaurant1.getName()).compareTo(restaurant2.getName());
    }
}
