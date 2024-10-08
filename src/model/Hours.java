package model;

/* Abstract Hours class extends DaysOpen */
public abstract class Hours extends DaysOpen {
    /* Attributes defualt set to null */
    private String sundayOpen = null;
    private String sundayClose = null;
    private String mondayOpen = null;
    private String mondayClose = null;
    private String tuesdayOpen = null;
    private String tuesdayClose = null;
    private String wednesdayOpen = null;
    private String wednesdayClose = null;
    private String thursdayOpen = null;
    private String thursdayClose = null;
    private String fridayOpen = null;
    private String fridayClose = null;
    private String saturdayOpen = null;
    private String saturdayClose = null;

    /* Constructors */
    protected Hours() {
        super();
    };

    protected Hours(String sundayOpen, String sundayClose, String mondayOpen, String mondayClose, String tuesdayOpen, String tuesdayClose, String wednesdayOpen, String wednesdayClose, String thursdayOpen, String thursdayClose, String fridayOpen, String fridayClose, String saturdayOpen, String saturdayClose) {
        super();
        this.sundayOpen = sundayOpen;
        this.sundayClose = sundayClose;
        this.mondayOpen = mondayOpen;
        this.mondayClose = mondayClose;
        this.tuesdayOpen = tuesdayOpen;
        this.tuesdayClose = tuesdayClose;
        this.wednesdayOpen = wednesdayOpen;
        this.wednesdayClose = wednesdayClose;
        this.thursdayOpen = thursdayOpen;
        this.thursdayClose = thursdayClose;
        this.fridayOpen = fridayOpen;
        this.fridayClose =fridayClose;
        this.saturdayOpen = saturdayOpen;
        this.saturdayClose = saturdayClose;
    }

    protected Hours(boolean sunday, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday,  boolean saturday, String sundayOpen, String sundayClose, String mondayOpen, String mondayClose, String tuesdayOpen, String tuesdayClose, String wednesdayOpen, String wednesdayClose, String thursdayOpen, String thursdayClose, String fridayOpen, String fridayClose, String saturdayOpen, String saturdayClose) {
        super(sunday, monday, tuesday, wednesday, thursday, friday, saturday);
        this.sundayOpen = sundayOpen;
        this.sundayClose = sundayClose;
        this.mondayOpen = mondayOpen;
        this.mondayClose = mondayClose;
        this.tuesdayOpen = tuesdayOpen;
        this.tuesdayClose = tuesdayClose;
        this.wednesdayOpen = wednesdayOpen;
        this.wednesdayClose = wednesdayClose;
        this.thursdayOpen = thursdayOpen;
        this.thursdayClose = thursdayClose;
        this.fridayOpen = fridayOpen;
        this.fridayClose =fridayClose;
        this.saturdayOpen = saturdayOpen;
        this.saturdayClose = saturdayClose;
    }

    /* Getters */
    public String getSundayOpen() {
        return this.sundayOpen;
    }

    public String getSundayClose() {
        return this.sundayClose;
    }

    public String getMondayOpen() {
        return this.mondayOpen;
    }

    public String getMondayClose() {
        return this.mondayClose;
    }

    public String getTuesdayOpen() {
        return this.tuesdayOpen;
    }

    public String getTuesdayClose() {
        return this.tuesdayClose;
    }

    public String getWednesdayOpen() {
        return this.wednesdayOpen;
    }

    public String getWednesdayClose() {
        return this.wednesdayClose;
    }

    public String getThursdayOpen() {
        return this.thursdayOpen;
    }

    public String getThursdayClose() {
        return this.thursdayClose;
    }

    public String getFridayOpen() {
        return this.fridayOpen;
    }

    public String getFridayClose() {
        return this.fridayClose;
    }

    public String getSaturdayOpen() {
        return this.saturdayOpen;
    }

    public String getSaturdayClose() {
        return this.saturdayClose;
    }

    /* Setters */
    public void setSundayOpen(String sundayOpen) {
        this.sundayOpen = sundayOpen;
    }

    public void setSundayClose(String sundayClose) {
        this.sundayClose = sundayClose;
    }

    public void setMondayOpen(String mondayOpen) {
        this.mondayOpen = mondayOpen;
    }

    public void setMondayClose(String mondayClose) {
        this.mondayClose = mondayClose;
    }

    public void setTuesdayOpen(String tuesdayOpen) {
        this.tuesdayOpen = tuesdayOpen;
    }

    public void setTuesdayClose(String tuesdayClose) {
        this.tuesdayClose = tuesdayClose;
    }

    public void setWednesdayOpen(String wednesdayOpen) {
        this.wednesdayOpen = wednesdayOpen;
    }

    public void setWednesdayClose(String wednesdayClose) {
        this.wednesdayClose = wednesdayClose;
    }

    public void setThursdayOpen(String thursdayOpen) {
        this.thursdayOpen = thursdayOpen;
    }

    public void setThursdayClose(String thursdayClose) {
        this.thursdayClose = thursdayClose;
    }

    public void setFridayOpen(String fridayOpen) {
        this.fridayOpen = fridayOpen;
    }

    public void setFridayClose(String fridayClose) {
        this.fridayClose = fridayClose;
    }

    public void setSaturdayOpen(String saturdayOpen) {
        this.saturdayOpen = saturdayOpen;
    }

    public void setSaturdayClose(String saturdayClose) {
        this.saturdayClose = saturdayClose;
    }

    // Abstract string method
    @Override
    public abstract String toString();
}
