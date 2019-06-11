// Class to create a car object

package com.example.week2day1_hw;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable {
    // Car object has following attributes
    private String Year, Make, Model, Color, EngineSize, TransmissionType;

    public Car() {

    }

    public Car(String year, String make, String model, String color, String engineSize, String transmissionType) {
        this.Year = year;
        this.Make = make;
        this.Model = model;
        this.Color = color;
        this.EngineSize = engineSize;
        this.TransmissionType = transmissionType;
    }

    // useful for displaying in a textview
    public String toString(){
        String s = this.Year + "\n" + this.Make + "\n" + this.Model + "\n" + this.Color + "\n" +
                this.EngineSize + "\n" + this.TransmissionType;
        return s;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getEngineSize() {
        return EngineSize;
    }

    public void setEngineSize(String engineSize) {
        EngineSize = engineSize;
    }

    public String getTransmissionType() {
        return TransmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        TransmissionType = transmissionType;
    }

    protected Car(Parcel in) {
        Year = in.readString();
        Make = in.readString();
        Model = in.readString();
        Color = in.readString();
        EngineSize = in.readString();
        TransmissionType = in.readString();
    }
    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
            //return null;
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[0];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Year);
        dest.writeString(Make);
        dest.writeString(Model);
        dest.writeString(Color);
        dest.writeString(EngineSize);
        dest.writeString(TransmissionType);
    }
}
