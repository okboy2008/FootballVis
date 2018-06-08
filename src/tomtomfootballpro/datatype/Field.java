/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tomtomfootballpro.datatype;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wangyu
 */
public class Field {
    private Coordinate pointA;
    private Coordinate pointB;
    private Coordinate pointC;
    private Coordinate pointD;
    private Coordinate pointArelative = new Coordinate(0,0);
    private Coordinate pointBrelative = new Coordinate(100,0);
    private Coordinate pointCrelative = new Coordinate(100,100);
    private Coordinate pointDrelative = new Coordinate(0, 100);
    
    public Field(Coordinate a, Coordinate b, Coordinate c, Coordinate d) {
        pointA = a;
        pointB = b;
        pointC = c;
        pointD = d;
    }
    
    public boolean isCoordinateInField(Coordinate coord) {
        int i, j = 0;
        List<Coordinate> range = new ArrayList<>();
        range.add(pointA);
        range.add(pointB);
        range.add(pointC);
        range.add(pointD);
        int vectorSize = range.size();
        boolean crosses = false;

        // If we cross the polygon an odd number of times, then the point is within the polygon
        for (i = 0, j = vectorSize - 1; i < vectorSize; j = i++)
        {
            double polyLat1 = range.get(i).getLatitude();
            double polyLon1 = range.get(i).getLongitude();
            double polyLat2 = range.get(j).getLatitude();
            double polyLon2 = range.get(j).getLongitude();
            double pointLat = coord.getLatitude();
            double pointLon = coord.getLongitude();

            if (((polyLat1 > pointLat) != (polyLat2 > pointLat)) &&
                (pointLon < (polyLon2 - polyLon1) * (pointLat - polyLat1) / (polyLat2 -  polyLat1) + polyLon1))
            {
                crosses = !crosses;
            }
        }

        return crosses;
    }
    
    public boolean isCoordinateInFieldRelative(Coordinate coord) {
        int i, j = 0;
        List<Coordinate> range = new ArrayList<>();
        range.add(pointArelative);
        range.add(pointBrelative);
        range.add(pointCrelative);
        range.add(pointDrelative);
        int vectorSize = range.size();
        boolean crosses = false;

        // If we cross the polygon an odd number of times, then the point is within the polygon
        for (i = 0, j = vectorSize - 1; i < vectorSize; j = i++)
        {
            double polyLat1 = range.get(i).getLatitude();
            double polyLon1 = range.get(i).getLongitude();
            double polyLat2 = range.get(j).getLatitude();
            double polyLon2 = range.get(j).getLongitude();
            double pointLat = coord.getLatitude();
            double pointLon = coord.getLongitude();

            if (((polyLat1 > pointLat) != (polyLat2 > pointLat)) &&
                (pointLon < (polyLon2 - polyLon1) * (pointLat - polyLat1) / (polyLat2 -  polyLat1) + polyLon1))
            {
                crosses = !crosses;
            }
        }

        return crosses;
    }

    public Coordinate getPointA() {
        return pointA;
    }

    public void setPointA(Coordinate pointA) {
        this.pointA = pointA;
    }

    public Coordinate getPointB() {
        return pointB;
    }

    public void setPointB(Coordinate pointB) {
        this.pointB = pointB;
    }

    public Coordinate getPointC() {
        return pointC;
    }

    public void setPointC(Coordinate pointC) {
        this.pointC = pointC;
    }

    public Coordinate getPointD() {
        return pointD;
    }

    public void setPointD(Coordinate pointD) {
        this.pointD = pointD;
    }
    
    
}
