package model;

/* Imports */
import java.util.Comparator;

public class NameComparator implements Comparator<Restaurant> {
    @Override
    public int compare(Restaurant restaurant1, Restaurant restaurant2) {
        if (restaurant1 == null && restaurant2 == null) {
            return 0;
        }
        else if (restaurant1 == null) {
            return -1;
        }
        else if (restaurant2 == null) {
            return 1;
        }
        else {
            return (restaurant1.getName()).compareTo(restaurant2.getName());
        
        }
    }
}
