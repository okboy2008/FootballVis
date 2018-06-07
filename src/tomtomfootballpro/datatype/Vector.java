/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tomtomfootballpro.datatype;

import static java.lang.Math.sqrt;

/**
 *
 * @author wangyu
 */
public class Vector {
    private Coordinate startPoint;
    private Coordinate endPoint;
    private double x;
    private double y;
    private double length;
    
    public Vector(Coordinate startPoint, Coordinate endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        x = this.endPoint.getX() - this.startPoint.getX();
        y = this.endPoint.getY() - this.startPoint.getY();
        length = sqrt(x * x + y * y);
    }

    public Coordinate getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Coordinate startPoint) {
        this.startPoint = startPoint;
    }

    public Coordinate getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Coordinate endPoint) {
        this.endPoint = endPoint;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    
}
