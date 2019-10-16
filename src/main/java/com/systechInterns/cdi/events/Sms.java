package com.systechInterns.cdi.events;

public class Sms {
    public String status;

    public String getStatus() {
        return status;
    }

    public String setStatus(String status) {
        this.status = status;
        return status;
    }

    @Override
    public String toString() {
        return "Sms{" +
                "status='" + status + '\'' +
                '}';
    }
}
