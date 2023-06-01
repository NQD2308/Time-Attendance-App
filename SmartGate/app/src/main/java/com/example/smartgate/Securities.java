package com.example.smartgate;

public class Securities {
    private String ID;
    private String Name;
    private String Pos;

    public Securities(String ID, String name, String pos) {
        this.ID = ID;
        Name = name;
        Pos = pos;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPos() {
        return Pos;
    }

    public void  setPos(String major) {
        this.Pos = Pos;
    }public  String toString() {

        return  this.ID + "-" + this.Name;
    }
}
