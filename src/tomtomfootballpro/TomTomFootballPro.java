/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tomtomfootballpro;

import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tomtomfootballpro.datatype.Activity;
import tomtomfootballpro.datatype.Coordinate;
import tomtomfootballpro.datatype.GPSItem;
import tomtomfootballpro.datatype.TomTomSportsCSVReader;
import tomtomfootballpro.datatype.TomTomSportsTCXReader;

/**
 *
 * @author wangyu
 */
public class TomTomFootballPro extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        //TomTomSportsCSVReader reader = new TomTomSportsCSVReader("/home/wangyu/Downloads/fit-20171217T143715.csv");
        //reader.readTest();
        
        
        Coordinate a = new Coordinate(51.437157, 5.407560);
        Coordinate b = new Coordinate(51.436985, 5.407988);
        Coordinate c = new Coordinate(51.437255, 5.408255);
        Coordinate d = new Coordinate(51.437431, 5.407888);
        Activity activity = new Activity(a, b, c, d);
        TomTomSportsTCXReader reader2 = new TomTomSportsTCXReader("/home/wangyu/Downloads/fit-20180107T141411.tcx");
        // reader2.readTest();
        activity.setGpsList(reader2.generateGPSItemList());
        activity.convertCoordinates();
        System.out.println("-------GPSItem List size: " + activity.getGpsList().size());
        int count = 0;
        for(GPSItem item:activity.getGpsList()) {
            if (!activity.getField().isCoordinateInField(item.getCoordinate())) {
                ++count;
                //System.out.println("index " + activity.getGpsList().indexOf(item) + " coordinate x: " + item.getCoordinate().getX() + " y: " + item.getCoordinate().getY() + " is not in Field");
            }
        }
        int count1 = 0;
        for(GPSItem item:activity.getCoordinateList()) {
            if (!activity.getField().isCoordinateInFieldRelative(item.getCoordinate())) {
                ++count1;
                System.out.println("index " + activity.getCoordinateList().indexOf(item) + " coordinate x: " + item.getCoordinate().getX() + " y: " + item.getCoordinate().getY() + " is not in Field");
            }
        }
        System.out.println(count + " original coordinates are not in field...");
        System.out.println(count1 + " coordinates are not in field...");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
