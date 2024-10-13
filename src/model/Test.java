package model;
/* Test class to test Restaurant and Restaurants */

import java.time.LocalTime;
import java.util.ArrayList;

public class Test {
    // Main method
    public static void main(String[] args) {
        // Create sanctuary bistro
        Restaurant sanctuaryBistro = createSanctuaryBistro();
        // Display sanctuary bistro
        System.out.print(sanctuaryBistro.toString());
        // Create sante
        Restaurant sante = createSante();
        // Display sante
        System.out.print(sante.toString());
        // Create bar one
        Restaurant barOne = createBarOne();
        // Display bar one
        System.out.print(barOne.toString());
        // Create restaurants
        Restaurants restaurants = new Restaurants(sanctuaryBistro);
        restaurants.addRestaurant(sante);
        restaurants.addRestaurant(barOne);
        // Display restaurants
        System.out.println("Restaurants in Restaurants");
        for (Restaurant restaurant : restaurants.getRestaurants()) {
            System.out.println(restaurant.toString());
        } 
        // Display names
        System.out.println("Names in names");
        for (String name : restaurants.getNames()) {
            System.out.println(name);
        }
        //Display categories
        System.out.println("Categories in categories");
        for (String category : restaurants.getCategories()) {
            System.out.println(category);
        }
        // Display neighborhoods
        System.out.println("Nieghborhoods in neighborhoods");
        for (String neihhborhood : restaurants.getNeighborhoods()) {
            System.out.println(neihhborhood);
        }
        // Test name match
        System.out.println("Name match test");
        Restaurant nameMatch = restaurants.nameMatch("Sante");
        System.out.println(nameMatch.toString());
        Restaurant nameMatchNull = restaurants.nameMatch("Link and Pin");
        System.out.println(nameMatchNull);
        // Test category match
        System.out.println("Category match test");
        ArrayList<String> filterCategories = new ArrayList<>();
        filterCategories.add("Vegan");
        ArrayList<Restaurant> categoryMatch = restaurants.categoryMatch(filterCategories);
        for (Restaurant restaurant : categoryMatch) {
            System.out.println(restaurant.toString());
        }
        filterCategories.add("Gluten Free");
        ArrayList<Restaurant> categoryMatch2 = restaurants.categoryMatch(filterCategories);
        for (Restaurant restaurant : categoryMatch2) {
            System.out.println(restaurant.toString());
        }
        // Test neighborhood match
        System.out.println("Nieghborhood match test");
        ArrayList<String> neighborhoodFilter = new ArrayList<>();
        neighborhoodFilter.add("South Park");
        ArrayList<Restaurant> neighborhoodMatch = restaurants.neighborhoodMatch(neighborhoodFilter);
        for (Restaurant restaurant : neighborhoodMatch) {
            System.out.println(restaurant.toString());
        }
        // Test price range match
        System.out.println("Price range match test");
        ArrayList<Restaurant> priceMatch = restaurants.priceRangeMatch(12, 32);
        for (Restaurant restaurant : priceMatch) {
            System.out.println(restaurant.toString());
        }
        ArrayList<Restaurant> priceMatch2 = restaurants.priceRangeMatch(16, 50);
        for (Restaurant restaurant : priceMatch2) {
            System.out.println(restaurant.toString());
        }
        // Test has happy hour or specials
        System.out.println("Test specials match");
        ArrayList<Restaurant> specialsMatch = restaurants.specialsMatch();
        for (Restaurant restaurant : specialsMatch) {
            System.out.println(restaurant.toString());
        }
        // Test sundayMatch
        System.out.println("Test Sunday match");
        for (Restaurant restaurant : restaurants.sundayMatch()) {
            System.out.println(restaurant.getName());
        }
        // Test mondayMatch
        System.out.println("Test Monday match");
        for (Restaurant restaurant : restaurants.mondayMatch()) {
            System.out.println(restaurant.getName());
        }
        // Test tuesdayMatch
        System.out.println("Test Tuesday match");
        for (Restaurant restaurant : restaurants.tuesdayMatch()) {
            System.out.println(restaurant.getName());
        }
        // Test wednesdayMatch
        System.out.println("Test Wednesday match");
        for (Restaurant restaurant : restaurants.wednesdayMatch()) {
            System.out.println(restaurant.getName());
        }
        // Test thursdayMatch
        System.out.println("Test Thursday match");
        for (Restaurant restaurant : restaurants.thursdayMatch()) {
            System.out.println(restaurant.getName());
        }
        // Test fridayMatch
        System.out.println("Test Friday match");
        for (Restaurant restaurant : restaurants.fridayMatch()) {
            System.out.println(restaurant.getName());
        }
        // Test saturdayMatch
        System.out.println("Test Saturday match");
        for (Restaurant restaurant : restaurants.saturdayMatch()) {
            System.out.println(restaurant.getName());
        }

        // Test toMilitary method
        System.out.println("Military time test");
        LocalTime time = restaurants.toMilitary("5:00 PM");
        LocalTime time2 = restaurants.toMilitary("2:00 AM");
        System.out.println(time);
        System.out.println(time2);
        System.out.println(time.compareTo(time2));
        
        /* Test hours match */
        System.out.println("Test hours match");
        // Create Hours object to use as filter 
        Hours filterHours = new HoursNoMidDayClose();
        filterHours.setSunday(false);
        filterHours.setMonday(false);
        filterHours.setTuesday(false);
        filterHours.setWednesday(false);
        filterHours.setThursday(false);
        filterHours.setFridayOpen("12:00 PM");
        filterHours.setFridayClose("2:00 PM");
        filterHours.setSaturdayOpen("5:30 PM");
        filterHours.setSaturdayClose("9:00 PM");
        System.out.println("The filter hours are:");
        System.out.println(filterHours.toString());

        /* Test hours match 2 */
        System.out.println("Test hours match 2");
        // Create hours object
        Hours hours = new HoursNoMidDayClose();
        hours.setSunday(false);
        hours.setMonday(false);
        hours.setTuesday(false);
        hours.setWednesday(false);
        hours.setThursday(false);
        hours.setFriday(false);
        hours.setSaturday(false);
        System.out.println("The filter hours are:");
        System.out.println(hours.toString());

        // Find the matching days
        ArrayList<Restaurant> daysOpenMatch = restaurants.getOpenDaysMatch(filterHours);
        System.out.println("Open days Match");
        for (Restaurant restaurant: daysOpenMatch) {
            System.out.println(restaurant);
        }

        // Find the matching hours ignoring mid day close
        ArrayList<Restaurant> regularHoursMatch = restaurants.getRegularHoursMatch(filterHours, daysOpenMatch);
        System.out.println("Regular hours match");
        for (Restaurant restaurant : regularHoursMatch) {
            System.out.println(restaurant.toString());
        }

        // Find restaurants that match hours
        ArrayList<Restaurant> hoursMidDayCloseMatch = restaurants.hoursMatch(filterHours);
        System.out.println("Hours match given mid day close");
        for (Restaurant restaurant : hoursMidDayCloseMatch) {
            System.out.println(restaurant.toString());
        }

        // Find all matching hours
        ArrayList<Restaurant> hoursMatch = restaurants.hoursMatch(hours);
        System.out.println("Hours match test 2");
        for (Restaurant restaurant : hoursMatch) {
            System.out.println(restaurant.getName());
        }
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
        hours.setTuesdayClose("9:00 PM");
        // Wednesday
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
