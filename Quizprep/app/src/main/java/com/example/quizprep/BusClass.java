package com.example.quizprep;
//business classes NEVER refer to UI
public class BusClass {
    private String busText = "Hello from Bus";

    public String getBusText(){return this.busText;}
}
