package tomtomfootballpro.datatype;

import static tomtomfootballpro.datatype.Defines.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wangyu
 */
public class GPSItem {
    private int time;
    private int activityType;
    private int lapNumber;
    private double distance;
    private double speed;
    private int calories;
    private Coordinate coordinate;
    private double elevation;
    private int heartRate;
    
    public GPSItem() {
        time = DEFAULT_INT;
        activityType = DEFAULT_INT;
        lapNumber = DEFAULT_INT;
        calories = DEFAULT_INT;
        heartRate = DEFAULT_INT;
        distance = DEFAULT_DOUBLE;
        speed = DEFAULT_DOUBLE;
        elevation = DEFAULT_DOUBLE;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getActivityType() {
        return activityType;
    }

    public void setActivityType(int activityType) {
        this.activityType = activityType;
    }

    public int getLapNumber() {
        return lapNumber;
    }

    public void setLapNumber(int lapNumber) {
        this.lapNumber = lapNumber;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }
    
}
