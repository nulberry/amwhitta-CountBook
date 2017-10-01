package com.example.amwhitta_countbook;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Andrea on 15-09-17.
 *
 */

class Counter implements Serializable {
    private String name;
    private String date;
    private int initial;
    private int current;
    private String comment;

    // CONSTRUCTOR
    Counter(String name, int initial){
        this.name = name;
        setDate();
        this.initial = initial;
        current = initial;
        comment = "";
    }

    // BEHAVIOURS
    void increment(){ ++current; setDate();}
    void decrement(){ if (current > 0) { --current; setDate(); } }
    void reset(){ current = initial; setDate();}

    // GETTERS
    String getName(){ return name; }
    String getDate() { return date; }
    int getInitial() { return initial; }
    int getCurrent() { return current; }
    String getComment() { return comment; }

    // SETTERS
    void setName(String name){ this.name = name; }
    void setInitial(int initial){ this.initial = initial; }
    void setCurrent(int current){ this.current = current; setDate();}
    void setComment(String comment){ this.comment = comment; }
    private void setDate() {
        Date temp = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA);
        date = formatter.format(temp);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Date modified: " + date + "\n" +
                "Current count: " + Integer.toString(current);
    }
}
