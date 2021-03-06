package eu.daiad.web.model.message;

import org.joda.time.DateTime;

public class ReceiverAccount{

    private int accountId;
    private String username;
    private String lastName;
    private DateTime acknowledgedOn;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DateTime getAcknowledgedOn() {
        return acknowledgedOn;
    }

    public void setAcknowledgedOn(DateTime acknowledgedOn) {
        this.acknowledgedOn = acknowledgedOn;
    }

}
