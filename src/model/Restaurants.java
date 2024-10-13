package model;

/* Imports */
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Locale;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/* Restaurants class that aggregates Restaurant objects */
public class Restaurants {
    /* Attributes */
    // Restaurant tree set
    private TreeSet<Restaurant> restaurants = new TreeSet<>(new NameComparator());
    // Name tree set
    private TreeSet<String> names = new TreeSet<>(new StringComparator());
    // Category tree set
    private TreeSet<String> categories = new TreeSet<>(new StringComparator());
    // Neighborhoods tree set
    private TreeSet<String> neighborhoods = new TreeSet<>(new StringComparator());

    /* Contructors */
    public Restaurants() {};

    public Restaurants(Restaurant restaurant) {
        this.addRestaurant(restaurant);
    }

    /* Getters */
    public TreeSet<Restaurant> getRestaurants() {
        return this.restaurants;
    }

    public TreeSet<String> getNames() {
        return this.names;
    }

    public TreeSet<String> getCategories() {
        return this.categories;
    }

    public TreeSet<String> getNeighborhoods() {
        return this.neighborhoods;
    }

    /* Add Restaurant */
    public void addRestaurant(Restaurant restaurant) {
        this.restaurants.add(restaurant);
        this.names.add(restaurant.getName());
        this.categories.add(restaurant.getCategory());
        this.neighborhoods.add(restaurant.getNeighborhood());   
    }

    /* Get restaurant that matches the given name */
    public Restaurant nameMatch(String name) {
        for (Restaurant restaurant : this.restaurants) {
            if (restaurant.getName() == name) {
                return restaurant;
            }  
        }
        // Return null if no match
        return null;
    }

    /* Returns the restaurant objects whose categories are in the given restaurant categories */
    public ArrayList<Restaurant> categoryMatch(ArrayList<String> categories){
        // Create array list to hold mathced restaurants
	    ArrayList<Restaurant> categoryMatch= new ArrayList<>();
	    for (Restaurant restaurant : this.restaurants) {
		    if (categories.contains(restaurant.getCategory())) {
			    categoryMatch.add(restaurant);
            }  
        }
        if (categories.isEmpty()) {
            categoryMatch.add(null);
        }
        return categoryMatch;
    }

    /* Returns the restaurant objects whose neighborhood is in the given the neighborhoods  */
    public ArrayList<Restaurant> neighborhoodMatch(ArrayList<String> neighborhoods) {
        // Create array list to hold matching restaurants
	    ArrayList<Restaurant> neighborhoodMatch = new ArrayList<>();
	    for (Restaurant restaurant : this.restaurants) {
		    if (neighborhoods.contains(restaurant.getNeighborhood())) {
			    neighborhoodMatch.add(restaurant);
            }
	    }
        if (neighborhoodMatch.isEmpty()) {
            neighborhoodMatch.add(null);
        }
	    return neighborhoodMatch;
    }

    /* Returns the restaurants whose entrée price range are within the given price range  */
    public ArrayList<Restaurant> priceRangeMatch(int min, int max) {
        // Create array list to hold matched restaurants
	    ArrayList <Restaurant> priceRangeMatch = new ArrayList<>();
	    for (Restaurant restaurant : this.restaurants) {
		    if (min <= restaurant.getLowPrice() && max >= restaurant.getHighPrice()) {
			    priceRangeMatch.add(restaurant);
            }
	    }
        if (priceRangeMatch.isEmpty()) {
            priceRangeMatch.add(null);
        }
        return priceRangeMatch;
    }

    /* Return the restaurants that have happy hours or specials  */
    public ArrayList<Restaurant> specialsMatch() {
        // Create array list to hold matching restaurants
	    ArrayList <Restaurant> hasSpecials = new ArrayList<>();
	    for (Restaurant restaurant : this.restaurants) {
		    if (restaurant.getHasSpecials()) {
			    hasSpecials.add(restaurant);
            }
	    } 
        if (hasSpecials.isEmpty()) {
            hasSpecials.add(null);
        }  
	    return hasSpecials;
    }

    public ArrayList<Restaurant> sundayMatch() {
        // Create array list to hold matching restaurants
        ArrayList<Restaurant> dayMatch = new ArrayList<>();
        for (Restaurant restaurant : this.restaurants) {
            if (restaurant.getHoursOpened().getSunday()) {
                dayMatch.add(restaurant);
            }
        }
        return dayMatch;
    }

    public ArrayList<Restaurant> mondayMatch() {
        // Create array list to hold matching restaurants
        ArrayList<Restaurant> dayMatch = new ArrayList<>();
        for (Restaurant restaurant : this.restaurants) {
            if (restaurant.getHoursOpened().getMonday()) {
                dayMatch.add(restaurant);
            }
        }
        return dayMatch;
    }

    public ArrayList<Restaurant> tuesdayMatch() {
        // Create array list to hold matching restaurants
        ArrayList<Restaurant> dayMatch = new ArrayList<>();
        for (Restaurant restaurant : this.restaurants) {
            if (restaurant.getHoursOpened().getTuesday()) {
                dayMatch.add(restaurant);
            }
        }
        return dayMatch;
    }

    public ArrayList<Restaurant> wednesdayMatch() {
        // Create array list to hold matching restaurants
        ArrayList<Restaurant> dayMatch = new ArrayList<>();
        for (Restaurant restaurant : this.restaurants) {
            if (restaurant.getHoursOpened().getWednesday()) {
                dayMatch.add(restaurant);
            }
        }
        return dayMatch;
    }

    public ArrayList<Restaurant> thursdayMatch() {
        // Create array list to hold matching restaurants
        ArrayList<Restaurant> dayMatch = new ArrayList<>();
        for (Restaurant restaurant : this.restaurants) {
            if (restaurant.getHoursOpened().getThursday()) {
                dayMatch.add(restaurant);
            }
        }
        return dayMatch;
    }

    public ArrayList<Restaurant> fridayMatch() {
        // Create array list to hold matching restaurants
        ArrayList<Restaurant> dayMatch = new ArrayList<>();
        for (Restaurant restaurant : this.restaurants) {
            if (restaurant.getHoursOpened().getFriday()) {
                dayMatch.add(restaurant);
            }
        }
        return dayMatch;
    }

    public ArrayList<Restaurant> saturdayMatch() {
        // Create array list to hold matching restaurants
        ArrayList<Restaurant> dayMatch = new ArrayList<>();
        for (Restaurant restaurant : this.restaurants) {
            if (restaurant.getHoursOpened().getSaturday()) {
                dayMatch.add(restaurant);
            }
        }
        return dayMatch;
    }

    /* Return the restaurants that are open during the given time frames for the given days */
    public ArrayList<Restaurant> hoursMatch(Hours filterHours) {
	    ArrayList <Restaurant> hoursMatch = new ArrayList<>();
        // Get restaurants that are open on the selected days
        ArrayList<Restaurant> openDayMatch = getOpenDaysMatch(filterHours);
        // Get restraurants that are open during the given time frames ignoring mid day close
        ArrayList<Restaurant> regularHoursMatch = getRegularHoursMatch(filterHours, openDayMatch);
        // Create list to hold matched restaurants that have mid day close
        ArrayList<Restaurant> regularHoursMatchMidClose = new ArrayList<>();
        // Move restaurants that don't have mid day close to hours match and ones with mid day close to regularHoursMatchMidClose
        for (Restaurant restaurant : regularHoursMatch) {
            if (restaurant.getHasMidDayClose()) {
                // Add to regularHoursMatchMidClose
                regularHoursMatchMidClose.add(restaurant);
            }
            else{
                // Add to hours match
                hoursMatch.add(restaurant);
            }
        }
        // Get restaurants that have mid day closures but still within filter hours picked
        ArrayList<Restaurant> midDayCloseHoursMatch = getMidDayCloseHoursMatch(filterHours, regularHoursMatchMidClose);
        // Add midDayCloseHoursMatch to hourMatch
        hoursMatch.addAll(midDayCloseHoursMatch);
        // Return the restaurants that are open during the given time frames
        // If no mathces add null
        if (hoursMatch.isEmpty()) {
            hoursMatch.add(null);
        }
	    return hoursMatch;
    }

    /* Find restaurants that are open on all of the given days */
    public ArrayList<Restaurant> getOpenDaysMatch(Hours filterHours) {
        ArrayList<Restaurant> openDaysMatch = new ArrayList<>();
        // Check if restaurant open on selected day, if so add to list
        for (Restaurant restaurant : this.restaurants) {
            // Get restaurant hours
            Hours hours = restaurant.getHoursOpened();
            // When Sunday selected
            if (filterHours.getSunday()) {
                // If restaurant not open on Sunday
                if (hours.getSunday() == false) {
                    // Not a match
                    continue;
                }
            }
            // When Monday selected
            if (filterHours.getMonday()) {
                // If restaurant not open on Monday
                if (hours.getMonday() == false) {
                    // Not a match
                    continue;
                }
            }
            // When Tuesday selected
            if (filterHours.getTuesday()) {
                // If restaurant not open on Tuesday
                if (hours.getTuesday() == false) {
                    // Not a match
                    continue;
                }
            }
            // When Wednesday selected
            if (filterHours.getWednesday()) {
                // If restaurant not open on Wednesday
                if (hours.getWednesday() == false) {
                    // Not a match
                    continue;
                }
            }
            // When Thursday selected
            if (filterHours.getThursday()) {
                // If restaurant not open on Thursday
                if (hours.getThursday() == false) {
                    // Not a match
                    continue;
                }
            }
            // When Friday selected
            if (filterHours.getFriday()) {
                // If restaurant not open on Friday
                if (hours.getFriday() == false) {
                    // Not a match
                    continue;
                }
            }
            // When Saturday selected
            if (filterHours.getSaturday()) {
                // If restaurant not open on Saturday
                if (hours.getSaturday() == false) {
                    // Not a match
                    continue;
                }
            }
            // Made it to end without breaking, so a match, add to list
            openDaysMatch.add(restaurant);
        }
        // Return restaurants that are open on the same days picked in filter
        return openDaysMatch;
    }
 
    /* Find restaurant that is open during given time frames ignoring mid day close */
    public ArrayList<Restaurant> getRegularHoursMatch(Hours filterHours, ArrayList<Restaurant> restaurants) {
        ArrayList<Restaurant> regularHoursMatch = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            // Get restaurant hours opened
            Hours hours = restaurant.getHoursOpened();
            // When Sunday selected
            if (filterHours.getSunday()) {
                // If restaurant not open during selected time frame
                if (((toMilitary(filterHours.getSundayOpen())).compareTo(toMilitary(hours.getSundayOpen())) == -1) || ((toMilitary(filterHours.getSundayClose())).compareTo(toMilitary(hours.getSundayClose())) == 1)) {
                    // No Match
                    continue;
                }
            }
            // When Monday selected
            if (filterHours.getMonday()) {
                // If restaurant not open during selected time frame
                if (((toMilitary(filterHours.getMondayOpen())).compareTo(toMilitary(hours.getMondayOpen())) == -1) || ((toMilitary(filterHours.getMondayClose())).compareTo(toMilitary(hours.getMondayClose())) == 1)) {
                    // No Match
                    continue;
                }
            }
         
            // When Tuesday selected
            if (filterHours.getTuesday()) {
                // If restaurant not open during selected time frame
                if (((toMilitary(filterHours.getTuesdayOpen())).compareTo(toMilitary(hours.getTuesdayOpen())) == -1) || ((toMilitary(filterHours.getTuesdayClose())).compareTo(toMilitary(hours.getTuesdayClose())) == 1)) {
                    // No Match
                    continue;
                }
            }
            // When Wednesday selected
            if (filterHours.getWednesday()) {
                // If restaurant not open during selected time frame
                if (((toMilitary(filterHours.getWednesdayOpen())).compareTo(toMilitary(hours.getWednesdayOpen())) == -1) || ((toMilitary(filterHours.getWednesdayClose())).compareTo(toMilitary(hours.getWednesdayClose())) == 1)) {
                    // No Match
                    continue;
                }
            }
            // When Thursday selected
            if (filterHours.getThursday()) {
                // If restaurant not open during selected time frame
                if (((toMilitary(filterHours.getThursdayOpen())).compareTo(toMilitary(hours.getThursdayOpen())) == -1) || ((toMilitary(filterHours.getThursdayClose())).compareTo(toMilitary(hours.getThursdayClose())) == 1)) {
                    // No Match
                    continue;
                }
            }
             // When Friday selected
             if (filterHours.getFriday()) {
                // If restaurant not open during selected time frame
                if (((toMilitary(filterHours.getFridayOpen())).compareTo(toMilitary(hours.getFridayOpen())) == -1) || ((toMilitary(filterHours.getFridayClose())).compareTo(toMilitary(hours.getFridayClose())) == 1)) {
                    // No Match
                    continue;
                }
            }
            // When Saturday selected
            if (filterHours.getSaturday()) {
                // If restaurant not open during selected time frame
                if (((toMilitary(filterHours.getSaturdayOpen())).compareTo(toMilitary(hours.getSaturdayOpen())) == -1) || ((toMilitary(filterHours.getSaturdayClose())).compareTo(toMilitary(hours.getSaturdayClose())) == 1)) {
                    // No Match
                    continue;
                }
            }
            // Made it to end without breaking so a match, add to regularyHoursMatch
            regularHoursMatch.add(restaurant);
        }
        return regularHoursMatch;
    }

    /* Find retaurants that are open during the given hours taking into account mid day close */
    public ArrayList<Restaurant> getMidDayCloseHoursMatch(Hours filterHours, ArrayList<Restaurant> restaurants) {
        ArrayList<Restaurant> midDayCloseHoursMatch = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            // Restaurnt hours
            HoursMidDayClose hours = (HoursMidDayClose) restaurant.getHoursOpened();
            /* Check if fiter hours on given day fall completely in morning or evening hours */
            //Sunday
            if (filterHours.getSunday()) {
                if (((toMilitary(filterHours.getSundayClose())).compareTo(toMilitary(hours.getSundayMidClose())) == 1) && ((toMilitary(filterHours.getSundayOpen())).compareTo(toMilitary(hours.getSundayMidOpen())) == -1)) {
                    // No Match
                    continue;
                }
            }
            //Monday
            if (filterHours.getMonday()) {
                if (((toMilitary(filterHours.getMondayClose())).compareTo(toMilitary(hours.getMondayMidClose())) == 1) && ((toMilitary(filterHours.getMondayOpen())).compareTo(toMilitary(hours.getMondayMidOpen())) == -1)) {
                    // No Match
                    continue;
                }
            }
            //Tuesday
            if (filterHours.getTuesday()) {
                if (((toMilitary(filterHours.getTuesdayClose())).compareTo(toMilitary(hours.getTuesdayMidClose())) == 1) && ((toMilitary(filterHours.getTuesdayOpen())).compareTo(toMilitary(hours.getTuesdayMidOpen())) == -1)) {
                    // No Match
                    continue;
                }
            }
            //Wednesday
            if (filterHours.getWednesday()) {
                if (((toMilitary(filterHours.getWednesdayClose())).compareTo(toMilitary(hours.getWednesdayMidClose())) == 1) && ((toMilitary(filterHours.getWednesdayOpen())).compareTo(toMilitary(hours.getWednesdayMidOpen())) == -1)) {
                    // No Match
                    continue;
                }
            }
            //Thursday
            if (filterHours.getThursday()) {
                if (((toMilitary(filterHours.getThursdayClose())).compareTo(toMilitary(hours.getThursdayMidClose())) == 1) && ((toMilitary(filterHours.getThursdayOpen())).compareTo(toMilitary(hours.getThursdayMidOpen())) == -1)) {
                    // No Match
                    continue;
                }
            }
            //Friday
            if (filterHours.getFriday()) {
                if (((toMilitary(filterHours.getFridayClose())).compareTo(toMilitary(hours.getFridayMidClose())) == 1) && ((toMilitary(filterHours.getFridayOpen())).compareTo(toMilitary(hours.getFridayMidOpen())) == -1)) {
                    // No Match
                    continue;
                }
            }
            //Saturday
            if (filterHours.getSaturday()) {
                if (((toMilitary(filterHours.getSaturdayClose())).compareTo(toMilitary(hours.getSaturdayMidClose())) == 1) && ((toMilitary(filterHours.getSaturdayOpen())).compareTo(toMilitary(hours.getSaturdayMidOpen())) == -1)) {
                    // No Match
                    continue;
                }
            }
            // Made it through checks without breaking, so a match, add to hoursMatchMidDayClose
            midDayCloseHoursMatch.add(restaurant);
        }
        // Return matching restaurants
        return midDayCloseHoursMatch;
    }

    /* Method to convert string times to military */
    public LocalTime toMilitary(String time12Hour) {
        LocalTime military = LocalTime.parse(time12Hour, DateTimeFormatter.ofPattern("h:mm a", new Locale("en")));
        return military;
    }
}
