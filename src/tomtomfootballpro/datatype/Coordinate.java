/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tomtomfootballpro.datatype;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

/**
 *
 * @author wangyu
 */
public class Coordinate {
    private double x;
    private double y;
    
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getLatitude() {
        return x;
    }
    
    public double getLongitude() {
        return y;
    }
    
    public void setNewOrigin(Coordinate origin) {
        x = x - origin.getX();
        y = y - origin.getY();
    }
    
    // convert current coordinate to a new coordinate system 
    // using origin-second as x axis
    public void convertCoordinate(Coordinate origin, Coordinate second) {
        Coordinate tmp = new Coordinate(second.getX(), second.getY());
        tmp.setNewOrigin(origin);
        setNewOrigin(origin);
        
        double longEdge = sqrt(tmp.getX() * tmp.getX() + 
                          tmp.getY() * tmp.getY());
        double cosineA = tmp.getX() / longEdge;
        double sineA = tmp.getY() / longEdge;
        System.out.println("x: " + tmp.getX() + ", y: " + tmp.getY() + ", longedge: " + longEdge +
                ", cosA: " + cosineA + ", sinA: " + sineA);
        double oldX = x;
        x = x * cosineA + y * sineA;
        y = y * cosineA - oldX * sineA;
    }
    
    public void convertCoordinate(Coordinate origin, Coordinate second, double width, double height) {
        Coordinate tmp = new Coordinate(second.getX(), second.getY());
        tmp.setNewOrigin(origin);
        setNewOrigin(origin);
        
        double longEdge = sqrt(tmp.getX() * tmp.getX() + 
                          tmp.getY() * tmp.getY());
        double cosineA = tmp.getX() / longEdge;
        double sineA = tmp.getY() / longEdge;
        System.out.println("x: " + tmp.getX() + ", y: " + tmp.getY() + ", longedge: " + longEdge +
                ", cosA: " + cosineA + ", sinA: " + sineA);
        System.out.println("newY: " + (y * cosineA - x * sineA) + ", height: " + height);
        double oldX = x;
        x = (x * cosineA + y * sineA) / width * 100;
        y = (y * cosineA - oldX * sineA) / height * 100;
        System.out.println("y: " + y + ", height: " + height);
    }
    
    public void reverseXCoordinate() {
        x = -x;
    }
    
    public void reverseYCoordinate() {
        y = -y;
    }
}
