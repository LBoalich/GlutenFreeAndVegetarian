/* Abstract MidDayClose class extends hours */
public abstract class MidDayClose extends Hours {
    /* Attributes defualt set to false meaning the restaurent doesn't close between lunch and dinner */
    private boolean sundayMidDayClose = false;
    private boolean mondayMidDayClose = false;
    private boolean tuesdayMidDayClose = false;
    private boolean wednesdayMidDayClose = false;
    private boolean thursdayMidDayClose = false;
    private boolean fridayMidDayClose = false;
    private boolean saturdayMidDayClose = false;

    /* Constructors */
    protected MidDayClose() {
        super();
    }

    protected MidDayClose(boolean sundayMidDayClose, boolean mondayMidDayClose, boolean tuesdayMidDayClose, boolean wednesdayMidDayClose, boolean thursdayMidDayClose, boolean fridayMidDayClose, boolean saturdayMidDayClose) {
        super();
        this.sundayMidDayClose = sundayMidDayClose;
        this.mondayMidDayClose = mondayMidDayClose;
        this.tuesdayMidDayClose = tuesdayMidDayClose;
        this.wednesdayMidDayClose = wednesdayMidDayClose;
        this.thursdayMidDayClose = thursdayMidDayClose;
        this.fridayMidDayClose = fridayMidDayClose;
        this.saturdayMidDayClose = saturdayMidDayClose;
    }

    protected MidDayClose(String sundayOpen, String sundayClose, String mondayOpen, String mondayClose, String tuesdayOpen, String tuesdayClose, String wednesdayOpen, String wednesdayClose, String thursdayOpen, String thursdayClose, String fridayOpen, String fridayClose, String saturdayOpen, String saturdayClose, boolean sundayMidDayClose, boolean mondayMidDayClose, boolean tuesdayMidDayClose, boolean wednesdayMidDayClose, boolean thursdayMidDayClose, boolean fridayMidDayClose, boolean saturdayMidDayClose) {
        super(sundayOpen, sundayClose, mondayOpen, mondayClose, tuesdayOpen, tuesdayClose, wednesdayOpen, wednesdayClose, thursdayOpen, thursdayClose, fridayOpen, fridayClose, saturdayOpen, saturdayClose);
        this.sundayMidDayClose = sundayMidDayClose;
        this.mondayMidDayClose = mondayMidDayClose;
        this.tuesdayMidDayClose = tuesdayMidDayClose;
        this.wednesdayMidDayClose = wednesdayMidDayClose;
        this.thursdayMidDayClose = thursdayMidDayClose;
        this.fridayMidDayClose = fridayMidDayClose;
        this.saturdayMidDayClose = saturdayMidDayClose;
    }

    protected MidDayClose(boolean sunday, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday,  boolean saturday, String sundayOpen, String sundayClose, String mondayOpen, String mondayClose, String tuesdayOpen, String tuesdayClose, String wednesdayOpen, String wednesdayClose, String thursdayOpen, String thursdayClose, String fridayOpen, String fridayClose, String saturdayOpen, String saturdayClose, boolean sundayMidDayClose, boolean mondayMidDayClose, boolean tuesdayMidDayClose, boolean wednesdayMidDayClose, boolean thursdayMidDayClose, boolean fridayMidDayClose, boolean saturdayMidDayClose) {
        super(sunday, monday, tuesday, wednesday, thursday, friday, saturday, sundayOpen, sundayClose, mondayOpen, mondayClose, tuesdayOpen, tuesdayClose, wednesdayOpen, wednesdayClose, thursdayOpen, thursdayClose, fridayOpen, fridayClose, saturdayOpen, saturdayClose);
        this.sundayMidDayClose = sundayMidDayClose;
        this.mondayMidDayClose = mondayMidDayClose;
        this.tuesdayMidDayClose = tuesdayMidDayClose;
        this.wednesdayMidDayClose = wednesdayMidDayClose;
        this.thursdayMidDayClose = thursdayMidDayClose;
        this.fridayMidDayClose = fridayMidDayClose;
        this.saturdayMidDayClose = saturdayMidDayClose;
    }

    /* Getters */
    public boolean getSundayMidDayClose() {
        return this.sundayMidDayClose;
    }

    public boolean getMondayMidDayClose() {
        return this.mondayMidDayClose;
    }

    public boolean getTuesdayMidDayClose() {
        return this.tuesdayMidDayClose;
    }

    public boolean getWednesdayMidDayClose() {
        return this.wednesdayMidDayClose;
    }

    public boolean getThursdayMidDayClose() {
        return this.thursdayMidDayClose;
    }

    public boolean getFridayMidDayClose() {
        return this.fridayMidDayClose;
    }

    public boolean getSaturdayMidDayClose() {
        return this.saturdayMidDayClose;
    }

    /* Setters */
    public void setSundayMidDayClose(boolean sunday) {
        this.sundayMidDayClose = sunday;
    }

    public void setMondayMidDayClose(boolean monday) {
        this.mondayMidDayClose = monday;
    }

    public void setTuesdayMidDayClose(boolean tuesday) {
        this.tuesdayMidDayClose = tuesday;
    }

    public void setWednesdayMidDayClose(boolean wednesday) {
        this.wednesdayMidDayClose = wednesday;
    }

    public void setThursdayMidDayClose(boolean thursday) {
        this.thursdayMidDayClose = thursday;
    }

    public void setFridayMidDayClose(boolean friday) {
        this.fridayMidDayClose = friday;
    }

    public void setSaturdayMidDayClose(boolean saturday) {
        this.saturdayMidDayClose = saturday;
    }
}
