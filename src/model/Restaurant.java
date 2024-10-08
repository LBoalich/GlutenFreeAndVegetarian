package model;

/* Abstract Restaurant class */
public abstract class Restaurant {
    /* Attributes */
    private String name;
    private String website;
    private String address;
    private String phone;
    private String category;
    private String neighborhood;
    private int lowPrice;
    private int highPrice;
    private boolean hasSpecials;
    private boolean hasMidDayClose;
    private Hours hoursOpened;

    /* Constructors */
    protected Restaurant() {};

    protected Restaurant(String name, String website, String address, String phone, String category, String neighborhood, int lowPrice, int highPrice, boolean hasSpecials, boolean hasMidDayClose, Hours hoursOpened) {
        this.name = name;
        this.website = website;
        this.address = address;
        this.phone = phone;
        this.category = category;
        this.neighborhood = neighborhood;
        this.lowPrice = lowPrice;
        this.highPrice = highPrice;
        this.hasSpecials = hasSpecials;
        this.hasMidDayClose = hasMidDayClose;
        this.hoursOpened = hoursOpened;
    };

    /* Getters */
    public String getName() {
        return this.name;
    }
    
    public String getWebsite() {
        return this.website;
    }
    
    public String getAddress() {
        return this.address;
    }

    public String getPhone() {
        return this.phone;
    }
    
    public String getCategory() {
        return this.category;
    }
    
    public String getNeighborhood() {
        return this.neighborhood;
    }
    
    public int getLowPrice() {
        return this.lowPrice;
    }
    
    public int getHighPrice() {
        return this.highPrice; 
    }
    
    public boolean getHasSpecials() {
        return this.hasSpecials; 
    }

    public boolean getHasMidDayClose() {
        return this.hasMidDayClose;
    }
    
    public Hours getHoursOpened() {
        return this.hoursOpened; 
    }

    /* Setters */
    public void setName(String name) {
        this.name = name;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    
    public void setLowPrice(int lowPrice) {
        this.lowPrice = lowPrice;
    }
    
    public void setHighPrice(int highPrice) {
        this.highPrice = highPrice; 
    }
    
    public void setHasSpecials(boolean hasSpecials) {
        this.hasSpecials = hasSpecials; 
    }

    public void setHasMidDayClose(boolean hasMidDayClose) {
        this.hasMidDayClose = hasMidDayClose;
    }
    
    public void setHoursOpened(Hours hoursOpened) {
        this.hoursOpened = hoursOpened; 
    }

    // String method
    @Override
    public String toString() {
        // Create string builder for the restaurant
        StringBuilder restaurant = new StringBuilder();
        // Add name
        restaurant.append("\n" + name + "\n");
        // Add category
        restaurant.append("\nCategory: " + category);
        // Add price range
        restaurant.append("\nPrice Range: $" + lowPrice + " - $" + highPrice);
        // Add website
        restaurant.append("\nWebsite: " + website);
        // Add phone
        restaurant.append("\nPhone: " + phone);
        // Add neighborhood
        restaurant.append("\nNeighborhood: " + neighborhood);
        // Add address
        restaurant.append("\nAddress: " + address);
        // Add hours
        restaurant.append("\n" + hoursOpened.toString());
        // Return string representation of restaurant
        return restaurant.toString();
    }
}
