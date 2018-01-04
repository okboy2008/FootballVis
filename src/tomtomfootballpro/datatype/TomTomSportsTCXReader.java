/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tomtomfootballpro.datatype;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

/**
 *
 * @author wangyu
 */
public class TomTomSportsTCXReader {
    private String path;
    private Document document;
    
    public TomTomSportsTCXReader(String path) {
        this.path = path;
        try {
            document = parse(path);
        } catch (DocumentException ex) {
            Logger.getLogger(TomTomSportsTCXReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public XPath createXPath(String namespace, String url, String keyword) {
        if (namespace == null) {
            namespace = "tomtom";
        }
        if (url == null) {
            url = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2";
        }
        Map map = new HashMap();  
        map.put(namespace, url);  
        XPath xpath = document.createXPath("//" + namespace + ":" + keyword);  
        xpath.setNamespaceURIs(map);
        return xpath;
    }
    
    public Document parse(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
    }
    
    public Document parse(String path) throws DocumentException {
        Document document = null;
        try {
            //File file = new File(path);
            SAXReader reader = new SAXReader();
            document = reader.read(path);
        } catch (Exception ex) {
            Logger.getLogger(TomTomSportsCSVReader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (document == null) {
                System.out.println("document is null...");
            }
            return document;
        }
        
    }
    
    public List<Node> getAllNodesByPath(String path) {
        return createXPath(null, null, path).selectNodes(document);
    }
    
    public List<GPSItem> generateGPSItemList() {
        List<GPSItem> list = new ArrayList();
        List<Node> positions = getAllNodesByPath("Trackpoint");
        System.out.println("number of trackpoint is " + positions.size());
        for(Node n:positions) {
            GPSItem newItem = new GPSItem();
            
            // time
            newItem.setTime(positions.indexOf(n));
            
            // position
            Element position = ((Element)n).element("Position");
            Element latitude = position.element("LatitudeDegrees");
            Element longtitude = position.element("LongitudeDegrees");
            newItem.setCoordinate(new Coordinate(Double.parseDouble(latitude.getText()), 
                    Double.parseDouble(longtitude.getText())));
            
            // elevation
            Element elevation = ((Element)n).element("AltitudeMeters");
            newItem.setElevation(Double.parseDouble(elevation.getText()));
            
            // distance
            Element distance = ((Element)n).element("DistanceMeters");
            newItem.setDistance(Double.parseDouble(distance.getText()));
            
            // add item to list
            list.add(newItem);
        }
        return list;
    }
    
    public void readTest() {
        List<Node> positions = getAllNodesByPath("Trackpoint");
        System.out.println("number of trackpoint is " + positions.size());
        for(Node n:positions) {
            Element position = ((Element)n).element("Position");
            Element latitude = position.element("LatitudeDegrees");
            Element longtitude = position.element("LongitudeDegrees");
            
            Element distance = ((Element)n).element("DistanceMeters");
            System.out.println("latitude: " + latitude.getText() + " longtitude: " + longtitude.getText() 
            + " distance: " + distance.getText());
        }
    }
}
