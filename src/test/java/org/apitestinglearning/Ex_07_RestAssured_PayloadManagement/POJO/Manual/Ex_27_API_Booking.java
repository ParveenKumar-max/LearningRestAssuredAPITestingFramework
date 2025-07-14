package org.apitestinglearning.Ex_07_RestAssured_PayloadManagement.POJO.Manual;

public class Ex_27_API_Booking {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositepaid;
    private String additionalneeds;
    private BookingDates bookingDates;


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositepaid() {
        return depositepaid;
    }

    public void setDepositepaid(Boolean depositepaid) {
        this.depositepaid = depositepaid;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public BookingDates getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(BookingDates bookingDates) {
        this.bookingDates = bookingDates;
    }
}
