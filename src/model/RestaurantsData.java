package model;

public class RestaurantsData {
    // Create restaurants 
    public static Restaurants restaurants = populateRestaurants();

    public RestaurantsData() {
        restaurants = populateRestaurants();
    }

    // Get restaurants
    public Restaurants getRestaurants() {
        return restaurants;
    }
     
    /* Method to populate restaurants */
    public static Restaurants populateRestaurants() {
        // Create sanctuary bistro
        Restaurant sanctuaryBistro = createSanctuaryBistro();
        // Create sante
        Restaurant sante = createSante();
        // Create bar one
        Restaurant barOne = createBarOne();
        //Create restaurants
        Restaurants restaurants = new Restaurants(sanctuaryBistro);
        // Add restaruants
        restaurants.addRestaurant(sante);
        restaurants.addRestaurant(barOne);
        // Return restaurants
        return restaurants;
    }

    /* Method to make sanctuary bistro */
    public static Restaurant createSanctuaryBistro() {
        /* Create variables to hold sanctuary bistro info */
        String name = "Sanctuary Bistro";
        String website = "sanctuarybistro.com";
        String address = "6414 Rea Road C2,\nCharlotte, NC 28277";
        String phone = "980-335-0980"; 
        String category = "Vegan";
        String neighborhood = "Piper Glen";
        int lowPrice = 15;
        int highPrice = 22;
        boolean hasSpecials = false;
        boolean hasMidDayClose = true;
        HoursMidDayClose hours = new HoursMidDayClose();

        /* Add data to hours */
        // Sunday
        hours.setSunday(false);
        // Monday
        hours.setMonday(false);
        // Tuesday
        hours.setTuesday(false);
        // Wednesday
        hours.setWednesdayMidDayClose(true);
        hours.setWednesdayOpen("11:30 AM");
        hours.setWednesdayMidClose("3:00 AM");
        hours.setWednesdayMidOpen("5:30 PM");
        hours.setWednesdayClose("9:00 PM");
        // Thursday
        hours.setThursdayMidDayClose(true);
        hours.setThursdayOpen("11:30 AM");
        hours.setThursdayMidClose("3:00 PM");
        hours.setThursdayMidOpen("5:30 PM");
        hours.setThursdayClose("9:00 PM");
        // Friday
        hours.setFridayMidDayClose(true);
        hours.setFridayOpen("11:30 AM");
        hours.setFridayMidClose("3:00 PM");
        hours.setFridayMidOpen("5:30 PM");
        hours.setFridayClose("9:00 PM");
        // Saturday
        hours.setSaturdayMidDayClose(true);
        hours.setSaturdayOpen("10:00 AM");
        hours.setSaturdayMidClose("3:00 PM");
        hours.setSaturdayMidOpen("5:30 PM");
        hours.setSaturdayClose("9:00 PM");

        // Create sanctuary bistro 
        RestaurantNoSpecials sactuaryBistro = new RestaurantNoSpecials(name, website, address, phone, category, neighborhood, lowPrice, highPrice, hasSpecials, hasMidDayClose, hours);

        // return the restaraunt
        return sactuaryBistro;
    }

    /* Method to make sante */
    public static Restaurant createSante() {
        /* Create variables to hold sanctuary bistro info */
        String name = "Sante";
        String website = "santeofmatthews.com";
        String address = "165 N Trade St\nMatthews, NC 28105";
        String phone = "704-845-1899"; 
        String category = "Fine Dining";
        String neighborhood = "Matthews";
        int lowPrice = 18;
        int highPrice = 45;
        boolean hasSpecials = false;
        boolean hasMidDayClose = false;
        HoursNoMidDayClose hours = new HoursNoMidDayClose();

        /* Add data to hours */
        // Sunday
        hours.setSunday(false);
        // Monday
        hours.setMonday(false);
        // Tuesday
        hours.setTuesday(true);
        hours.setTuesdayOpen("5:00 PM");
        hours.setTuesdayClose("9:00 PM"); // Wednesday
        hours.setWednesday(true);
        hours.setWednesdayOpen("5:00 PM");
        hours.setWednesdayClose("9:00 PM");
        // Thursday
        hours.setThursday(true);
        hours.setThursdayOpen("5:00 PM");
        hours.setThursdayClose("9:00 PM");
        // Friday
        hours.setFriday(true);
        hours.setFridayOpen("5:00 PM");
        hours.setFridayClose("10:00 PM");
        // Saturday
        hours.setSaturday(true);
        hours.setSaturdayOpen("5:00 PM");
        hours.setSaturdayClose("10:00 PM");

        // Create sante
        RestaurantNoSpecials sante = new RestaurantNoSpecials(name, website, address, phone, category, neighborhood, lowPrice, highPrice, hasSpecials, hasMidDayClose, hours);
        // Return sante
        return sante;
    }

    /* Method to make bar one */
    public static Restaurant createBarOne() {
        /* Create Bar One variables */
        String name = "Bar One Lounge";
        String website = "baronelounge.com";
        String address = "6815 Phillips Place Court\nCharlotte, NC 28210";
        String phone = "980-880-4801"; 
        String category = "Cocktail Bar";
        String neighborhood = "South Park";
        int lowPrice = 16;
        int highPrice = 40;
        boolean hasSpecials = true;
        boolean hasMidDayClose = false;
        HoursNoMidDayClose hours = new HoursNoMidDayClose();
        Specials specials = new Specials();

         /* Add data to hours */
        // Sunday
        hours.setSundayOpen("12:00 PM");
        hours.setSundayClose("10:00 PM");
        // Monday
        hours.setMondayOpen("12:00 PM");
        hours.setMondayClose("11:00 PM");
        // Tuesday
        hours.setTuesdayOpen("12:00 PM");
        hours.setTuesdayClose("11:00 PM");
        // Wednesday
        hours.setWednesdayOpen("12:00 PM");
        hours.setWednesdayClose("11:00 PM");
        // Thursday
        hours.setThursdayOpen("12:00 PM");
        hours.setThursdayClose("11:00 PM");
        // Friday
        hours.setFridayOpen("12:00 PM");
        hours.setFridayClose("2:00 AM");
        // Saturday
        hours.setSaturdayOpen("12:00 PM");
        hours.setSaturdayClose("2:00 AM");

        /* Add data to specials */
        // Sunday
        specials.setSunday(false);
        // Monday
        specials.setMonday(false);
        // Tuesday
        specials.setTuesday(false);
        // Wednesday
        specials.setWednesdayOpen("10:00 AM");
        specials.setWednesdayClose("10:00 PM");
        // Thursday
        specials.setThursday(false);
        // Friday
        specials.setFriday(false);
        // Saturday
        specials.setSaturday(false);

        // Create bar one
        Restaurant barOne = new RestaurantHasSpecials(name, website, address, phone, category, neighborhood, lowPrice, highPrice, hasSpecials, hasMidDayClose, hours, specials);

        // Return bar one
        return barOne;
    }   
}
