package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.HoursNoMidDayClose;
import model.Restaurant;
import model.RestaurantsData;
import java.util.ArrayList;

// Class needs updated to track hours for each day of the week
public class HoursGui {
    public static final String[] HOURS_ARRAY = {"12:00 AM", "12:30 AM", "1:00 AM", "1:30 AM", "2:00 AM", "2:30 AM", "3:00 AM", "3:30 AM", "4:00 AM", "4:30 AM", "5:00 AM", "5:30 AM", "6:00 AM", "6:30 AM", "7:00 AM", "7:30 AM", "8:00 AM", "8:30 AM", "9:00 AM", "9:30 AM", "10:00 AM", "10:30 AM", "11:00 AM", "11:30 AM", "12:00 PM", "12:30 PM", "1:00 PM", "1:30 PM", "2:00 PM", "2:30 PM", "3:00 PM", "3:30 PM", "4:00 PM", "4:30 PM", "5:00 PM", "5:30 PM", "6:00 PM", "6:30 PM", "7:00 PM", "7:30 PM", "8:00 PM", "8:30 PM", "9:00 PM", "9:30 PM", "10:00 PM", "10:30 PM", "11:00 PM", "11:30 PM"};
    private VBox paneHours;
    private Sunday sunday;
    private Monday monday;
    private Tuesday tuesday;
    private Wednesday wednesday;
    private Thursday thursday;
    private Friday friday;
    private Saturday saturday;
    private ArrayList<Restaurant> hoursMatches = new ArrayList<>();

    public HoursGui() {
        hours();
    }

    public VBox getHoursPane() {
        return this.paneHours;
    }

    public ArrayList<Restaurant> getHoursMatches() {
        // Clear previous matches
        hoursMatches.clear();

        // If no selctions made no need to look for matches, return cleared hours matches list
        if (!sunday.getSundaySelected() && !monday.getMondaySelected() && !tuesday.getTuesdaySelected() && !wednesday.getWednesdaySelected() && !thursday.getThursdaySelected() && !friday.getFridaySelected() && !saturday.getSaturdaySelected()) {
            return this.hoursMatches;
        }

        // Create list to track open only on certain day
        ArrayList<Restaurant> onlyDayMatch = new ArrayList<>();
        // Create hours no mid day close object
        HoursNoMidDayClose hours = new HoursNoMidDayClose();
        /* Get matches for each day */
        // Sunday
        // If selections made
        if (sunday.getSundaySelected()) {
            String sundayOpen = sunday.getSundayOpen();
            String sundayClose = sunday.getSundayClose();
            // If sunday open or close null get day matches
            if (sundayOpen == null || sundayClose == null) {
                onlyDayMatch.addAll(RestaurantsData.RESTAURANTS.sundayMatch());
                // Can't search this day based on hours, set to close to prevent error
                hours.setSunday(false);
            }
            else {
                //Set sunday hours
                hours.setSundayOpen(sundayOpen);
                hours.setSundayClose(sundayClose);
            }
        } 
        // Set day to closed
        else {
            hours.setSunday(false);
        }
        // Monday
        // If selections made
        if (monday.getMondaySelected()) {
            String mondayOpen = monday.getMondayOpen();
            String mondayClose = monday.getMondayClose();
            // If open or close null get day matches
            if (mondayOpen == null || mondayClose == null) {
                // Can't search this day based on hours, set to close to prevent error
                hours.setMonday(false);
                // If only day match empty
                if (onlyDayMatch.isEmpty()) {
                    // Add all
                    onlyDayMatch.addAll(RestaurantsData.RESTAURANTS.mondayMatch());
                }
                else {
                    // Add only restaurants from both
                    onlyDayMatch.retainAll(RestaurantsData.RESTAURANTS.mondayMatch());
                    // If emtpy no results add null to hours match and return
                    if (onlyDayMatch.isEmpty()) {
                        this.hoursMatches.add(null);
                        return this.hoursMatches;
                    }
                }
            }
            else {
                // Set hours
                hours.setMondayOpen(monday.getMondayOpen());
                hours.setMondayClose(monday.getMondayClose());
            }
        } 
        // Set day to closed
        else {
            hours.setMonday(false);
        }
        // Tuesday
        // If selections made
        if (tuesday.getTuesdaySelected()) {
            String tuesdayOpen = tuesday.getTuesdayOpen();
            String tuesdayClose = tuesday.getTuesdayClose();
            // If open or close null get day matches
            if (tuesdayOpen == null || tuesdayClose == null) {
                // Can't search this day based on hours, set to close to prevent error
                hours.setTuesday(false);
                // If only day match empty
                if (onlyDayMatch.isEmpty()) {
                    // Add all
                    onlyDayMatch.addAll(RestaurantsData.RESTAURANTS.tuesdayMatch());
                }
                else {
                    // Add only restaurants from both
                    onlyDayMatch.retainAll(RestaurantsData.RESTAURANTS.tuesdayMatch());
                    // If emtpy no results add null to hours match and return
                    if (onlyDayMatch.isEmpty()) {
                        this.hoursMatches.add(null);
                        return this.hoursMatches;
                    }
                }
            }
            else {
                // Set hours
                hours.setTuesdayOpen(tuesday.getTuesdayOpen());
                hours.setTuesdayClose(tuesday.getTuesdayClose());
            }
        } 
        // Set day to closed
        else {
            hours.setTuesday(false);
        }
        // Wednesday
        // If selections made
        if (wednesday.getWednesdaySelected()) {
            String wednesdayOpen = wednesday.getWednesdayOpen();
            String wednesdayClose = wednesday.getWednesdayClose();
            // If open or close null get day matches
            if (wednesdayOpen == null || wednesdayClose == null) {
                // Can't search this day based on hours, set to close to prevent error
                hours.setWednesday(false);
                // If only day match empty
                if (onlyDayMatch.isEmpty()) {
                    // Add all
                    onlyDayMatch.addAll(RestaurantsData.RESTAURANTS.wednesdayMatch());
                }
                else {
                    // Add only restaurants from both
                    onlyDayMatch.retainAll(RestaurantsData.RESTAURANTS.wednesdayMatch());
                    // If emtpy no results add null to hours match and return
                    if (onlyDayMatch.isEmpty()) {
                        this.hoursMatches.add(null);
                        return this.hoursMatches;
                    }
                }
            }
            else {
                // Set hours
                hours.setWednesdayOpen(wednesday.getWednesdayOpen());
                hours.setWednesdayClose(wednesday.getWednesdayClose());
            }
        } 
        // Set day to closed
        else {
            hours.setWednesday(false);
        }
        // Thursday
        // If selections made
        if (thursday.getThursdaySelected()) {
            String thursdayOpen = thursday.getThursdayOpen();
            String thursdayClose = thursday.getThursdayClose();
            // If open or close null get day matches
            if (thursdayOpen == null || thursdayClose == null) {
                // Can't search this day based on hours, set to close to prevent error
                hours.setThursday(false);
                // If only day match empty
                if (onlyDayMatch.isEmpty()) {
                    // Add all
                    onlyDayMatch.addAll(RestaurantsData.RESTAURANTS.thursdayMatch());
                }
                else {
                    // Add only restaurants from both
                    onlyDayMatch.retainAll(RestaurantsData.RESTAURANTS.thursdayMatch());
                    // If emtpy no results add null to hours match and return
                    if (onlyDayMatch.isEmpty()) {
                        this.hoursMatches.add(null);
                        return this.hoursMatches;
                    }
                }
            }
            else {
                // Set hours
                hours.setThursdayOpen(thursday.getThursdayOpen());
                hours.setThursdayClose(thursday.getThursdayClose());
            }
        } 
        // Set day to closed
        else {
            hours.setThursday(false);
        }
        // Friday
        // If selections made
        if (friday.getFridaySelected()) {
            String fridayOpen = friday.getFridayOpen();
            String fridayClose = friday.getFridayClose();
            // If open or close null get day matches
            if (fridayOpen == null || fridayClose == null) {
                // Can't search this day based on hours, set to close to prevent error
                hours.setFriday(false);
                // If only day match empty
                if (onlyDayMatch.isEmpty()) {
                    // Add all
                    onlyDayMatch.addAll(RestaurantsData.RESTAURANTS.fridayMatch());
                }
                else {
                    // Add only restaurants from both
                    onlyDayMatch.retainAll(RestaurantsData.RESTAURANTS.fridayMatch());
                    // If emtpy no results add null to hours match and return
                    if (onlyDayMatch.isEmpty()) {
                        this.hoursMatches.add(null);
                        return this.hoursMatches;
                    }
                }
            }
            else {
                // Set hours
                hours.setFridayOpen(friday.getFridayOpen());
                hours.setFridayClose(friday.getFridayClose());
            }
        } 
        // Set day to closed
        else {
            hours.setFriday(false);
        }
        // Saturday
        // If selections made
        if (saturday.getSaturdaySelected()) {
            String saturdayOpen = saturday.getSaturdayOpen();
            String saturdayClose = saturday.getSaturdayClose();
            // If open or close null get day matches
            if (saturdayOpen == null || saturdayClose == null) {
                // Can't search this day based on hours, set to close to prevent error
                hours.setSaturday(false);
                // If only day match empty
                if (onlyDayMatch.isEmpty()) {
                    // Add all
                    onlyDayMatch.addAll(RestaurantsData.RESTAURANTS.saturdayMatch());
                }
                else {
                    // Add only restaurants from both
                    onlyDayMatch.retainAll(RestaurantsData.RESTAURANTS.saturdayMatch());
                    // If emtpy no results add null to hours match and return
                    if (onlyDayMatch.isEmpty()) {
                        this.hoursMatches.add(null);
                        return this.hoursMatches;
                    }
                }
            }
            else {
                // Set hours
                hours.setSaturdayOpen(saturday.getSaturdayOpen());
                hours.setSaturdayClose(saturday.getSaturdayClose());
            }
        } 
        // Set day to closed
        else {
            hours.setSaturday(false);
        }
        // Get matches for selected open and close hours
        ArrayList<Restaurant> currentMatches = RestaurantsData.RESTAURANTS.hoursMatch(hours);
        // If either null add null to hoursMatches and return
        if (onlyDayMatch.contains(null) || currentMatches.contains(null)) {
            this.hoursMatches.add(null);
            return this.hoursMatches;
        }
        else if (onlyDayMatch.isEmpty()) {
            // Only days not selected, return hours matches
            this.hoursMatches.addAll(currentMatches);
            return this.hoursMatches;
        }
        else if (currentMatches.isEmpty()) {
            // No hours filter used, return only day matches
            this.hoursMatches.addAll(onlyDayMatch);
            return this.hoursMatches;
        }
        else {
            // Retain only restaurants from both
            currentMatches.retainAll(onlyDayMatch);
            // If current matches emtpy, add null to hours matches and return
            if (currentMatches.isEmpty()) {
                this.hoursMatches.add(null);
                return this.hoursMatches;
            }
            else {
                // Matches exist, add to hours matches and return
                this.hoursMatches.addAll(currentMatches);
                return this.hoursMatches;
            }
        }   
    }

    private void hours() {
        // Create days
        sunday = new Sunday();
        monday = new Monday();
        tuesday = new Tuesday();
        wednesday = new Wednesday();
        thursday = new Thursday();
        friday = new Friday();
        saturday = new Saturday();

        // Create hours vbox
        paneHours = new VBox(10);
        
        // Create hours label
        Label lbHours = new Label("Open Hours");

        /* Hours Pane */
        // Add hours label and hbox to vbox
        paneHours.getChildren().addAll(lbHours, sunday.getSundayPane(), monday.getMondayPane() , tuesday.getTuesdayPane(), wednesday.getWednesdayPane(), thursday.getThursdayPane(), friday.getFridayPane(), saturday.getSaturdayPane());
        // Set alignment
        paneHours.setAlignment(Pos.CENTER);
    }

    public void clearHours() {
        this.sunday.clearSunday();
        this.monday.clearMonday();
        this.tuesday.clearTuesday();
        this.wednesday.clearWednesday();
        this.thursday.clearThursday();
        this.friday.clearFriday();
        this.saturday.clearSaturday();
    }
}
