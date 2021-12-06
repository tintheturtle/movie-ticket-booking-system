package com.system;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validator {

    public boolean validDate(String date) {
        try {
            new SimpleDateFormat("DD/mm/yyyy").parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public boolean validTime(String time) {
        try {
            new SimpleDateFormat("HH:mm").parse(time);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
