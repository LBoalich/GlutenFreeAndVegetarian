package model;

/* Specials class extends Hours */
public class Specials extends Hours {
    /* Constructors */
    public Specials() {
        super();
    }

    public Specials(String sundayOpen, String sundayClose, String mondayOpen, String mondayClose, String tuesdayOpen, String tuesdayClose, String wednesdayOpen, String wednesdayClose, String thursdayOpen, String thursdayClose, String fridayOpen, String fridayClose, String saturdayOpen, String saturdayClose) {
        super(sundayOpen, sundayClose, mondayOpen, mondayClose, tuesdayOpen, tuesdayClose, wednesdayOpen, wednesdayClose, thursdayOpen, thursdayClose, fridayOpen, fridayClose, saturdayOpen, saturdayClose);
    }

    // String method
    @Override
    public String toString() {
        // Create hours that there are specials string builder
        StringBuilder hours = new StringBuilder("\nSpecials\n\n");
        
        // Add Sunday specials
        if (super.getSunday() == true) {
            hours.append("Sunday: " + super.getSundayOpen() + " to " + super.getSundayClose() + "\n");
        }
      
        // Add Monday specials
        if (super.getMonday() == true) {
            hours.append("Monday: " + super.getMondayOpen() + " to " + super.getMondayClose() + "\n");
        }

        // Add Tuesday specials
        if (super.getTuesday() == true) {
            hours.append("Tuesday: " + super.getTuesdayOpen() + " to " + super.getTuesdayClose() + "\n");
        }

        // Add Wednesday specials
        if (super.getWednesday() == true) {
            hours.append("Wednesday: " + super.getWednesdayOpen() + " to " + super.getWednesdayClose() + "\n");
        }

        // Add Thursday specials
        if (super.getThursday() == true) {
            hours.append("Thursday: " + super.getThursdayOpen() + " to " + super.getThursdayClose() + "\n");
        }

        // Add Friday specials
        if (super.getFriday() == true) {
            hours.append("Friday: " + super.getFridayOpen() + " to " + super.getFridayClose() + "\n");
        }

        // Add Saturday specials
        if (super.getSaturday() == true) {
            hours.append("Saturday: " + super.getSaturdayOpen() + " to " + super.getSaturdayClose() + "\n");
        }
        // Return hours that there are specials
        return hours.toString();
    }
}
