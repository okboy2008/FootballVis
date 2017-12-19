/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tomtomfootballpro.datatype;

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
    
    public double getLongtitude() {
        return y;
    }
}
