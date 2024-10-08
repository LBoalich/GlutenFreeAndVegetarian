package model;

/* RestaurantHasSpecials class extends Restaurant */
public class RestaurantHasSpecials extends Restaurant{
    // specials attribute
    private Hours specials;

    /* Constructors */
    public RestaurantHasSpecials(){
	    super();
    }

    public RestaurantHasSpecials(String name, String website, String address, String phone, String category, String neighborhood, int lowPrice, int highPrice, boolean hasSpecials, boolean hasMidDayClose, Hours hoursOpened, Hours specials) {
        super(name, website, address, phone, category, neighborhood, lowPrice, highPrice, hasSpecials, hasMidDayClose, hoursOpened);
        this.specials = specials;
    }

    // Get the specials
    public Hours getSpecials(){
        return this.specials;
    }
    
    // String representation of the restaurant including when there are specails
    @Override
    public String toString() {
        // Create string builder to hold restaurant info 
        StringBuilder restaurant = new StringBuilder(super.toString());
        // Add string that says when the restaurant has specials
        restaurant.append("\n" + specials.toString() + "\n");
        // Return the string representation of the restaurant
        return restaurant.toString();
    } 
}
