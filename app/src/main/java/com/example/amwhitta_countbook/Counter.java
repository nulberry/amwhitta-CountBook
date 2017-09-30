package com.example.amwhitta_countbook;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Andrea on 15-09-17.
 */

public class Counter implements Serializable {
    private String name;
    private String date;
    private int initial;
    private int current;
    private String comment;

    // CONSTRUCTOR
    public Counter(String name, int initial){
        this.name = name;
        setDate();
        this.initial = initial;
        current = initial;
        comment = "";
    }

    // BEHAVIOURS
    public void increment(){ ++current; }
    public void decrement(){ --current; }
    public void reset(){ current = initial; }

    // GETTERS
    public String getName(){ return name; }
    public String getDate() { return date; }
    public int getInitial() { return initial; }
    public int getCurrent() { return current; }
    public String getComment() { return comment; }

    // SETTERS
    public void setName(String name){ this.name = name; }
    public void setInitial(int initial){ this.initial = initial; }
    public void setCurrent(int current){ this.current = current; }
    public void setComment(String comment){ this.comment = comment; }
    public void setDate() {
        Date temp = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        date = formatter.format(temp);
    }

    @Override
    public String toString() {
        return name;
    }

}
