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
public class Activity {
    private Field field;
    private List<GPSItem> gpsList;
    private List<GPSItem> coordinateList;
    private boolean isXreversed = false;
    private boolean isYreversed = false;
    
    public Activity() {
        gpsList = new ArrayList<>();
    }
    
    public Activity(Coordinate a, Coordinate b, Coordinate c, Coordinate d) {
        field = new Field(a, b, c, d);
        gpsList = new ArrayList<>();
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public List<GPSItem> getGpsList() {
        return gpsList;
    }

    public void setGpsList(List<GPSItem> gpsList) {
        this.gpsList = gpsList;
    }

    public List<GPSItem> getCoordinateList() {
        return coordinateList;
    }

    public void setCoordinateList(List<GPSItem> coordinateList) {
        this.coordinateList = coordinateList;
    }
    
    private Vector generateBaseVector() {
        return new Vector(field.getPointA(), field.getPointB());
    }
    
    public void convertCoordinates() {
        coordinateList = new ArrayList<>();
        Vector base = generateBaseVector();
        if (base.getX() < 0) {
            if (base.getY() < 0) {
                // reverse both x and y
                isXreversed = true;
                isYreversed = true;
                // reverse vector first
                base.reverseX();
                base.reverseY();
                // reverse all coordinates
                for (GPSItem item : gpsList) {
                    GPSItem convertedItem = new GPSItem(item);
                    convertedItem.getCoordinate().reverseXCoordinate();
                    convertedItem.getCoordinate().reverseYCoordinate();
                    Vector height = new Vector(field.getPointB(), field.getPointC());
                    Coordinate origin = new Coordinate(field.getPointA());
                    origin.reverseXCoordinate();
                    origin.reverseYCoordinate();
                    convertedItem.getCoordinate().convertAndNormalizeCoordinate(origin, base, base.getLength(), height.getLength());
                    coordinateList.add(convertedItem);  
                }
            } else {
                // reverse x
                isXreversed = true;
                // reverse vector first
                base.reverseX();
                // reverse all coordinates
                for (GPSItem item : gpsList) {
                    GPSItem convertedItem = new GPSItem(item);
                    convertedItem.getCoordinate().reverseXCoordinate();
                    Vector height = new Vector(field.getPointB(), field.getPointC());
                    Coordinate origin = new Coordinate(field.getPointA());
                    origin.reverseXCoordinate();
                    convertedItem.getCoordinate().convertAndNormalizeCoordinate(origin, base, base.getLength(), height.getLength());
                    coordinateList.add(convertedItem);  
                }
            }
        } else {
            if (base.getY() < 0) {
                // reverse y
                isYreversed = true;
                // reverse vector first
                base.reverseY();
                // reverse all coordinates
                for (GPSItem item : gpsList) {
                    GPSItem convertedItem = new GPSItem(item);
                    convertedItem.getCoordinate().reverseYCoordinate();
                    Vector height = new Vector(field.getPointB(), field.getPointC());
                    Coordinate origin = new Coordinate(field.getPointA());
                    origin.reverseYCoordinate();
                    convertedItem.getCoordinate().convertAndNormalizeCoordinate(origin, base, base.getLength(), height.getLength());
                    coordinateList.add(convertedItem);  
                }
            } else {
                // do not reverse, just copy
                for (GPSItem item : gpsList) {
                    GPSItem convertedItem = new GPSItem(item);
                    Vector height = new Vector(field.getPointB(), field.getPointC());
                    convertedItem.getCoordinate().convertAndNormalizeCoordinate(field.getPointA(), base, base.getLength(), height.getLength());
                    coordinateList.add(convertedItem);  
                }
            }
                
        }
    }
}
