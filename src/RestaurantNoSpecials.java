/* RestaurantNoSpecials class extends Restaurant */
public class RestaurantNoSpecials extends Restaurant {
    // String attribute stating there are no specials
    final private static String SPECIALS = "This restaurant does not offer specials.";

    /* Constructors */
    RestaurantNoSpecials(){
	    super();
    }

    RestaurantNoSpecials(String name, String website, String address, String phone, String category, String neighborhood, int lowPrice, int highPrice, boolean hasSpecials, boolean hasMidDayClose, Hours hoursOpened) {
        super(name, website, address, phone, category, neighborhood, lowPrice, highPrice, hasSpecials, hasMidDayClose, hoursOpened);
    }

    // Get the specials string
    public String getSpecials(){
        return SPECIALS;
    }
    
    // String representation of the restaurant
    @Override
    public String toString() {
        // Create string builder to hold restaurant info
        StringBuilder restaurant = new StringBuilder(super.toString());
        // And the specials string
        restaurant.append("\n" + SPECIALS + "\n\n");
        // Return the string representation of the restaurant
        return restaurant.toString();
    }
}
