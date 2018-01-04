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
        
        TomTomSportsCSVReader reader = new TomTomSportsCSVReader("/home/wangyu/Downloads/fit-20171217T143715.csv");
        reader.readTest();
        
        TomTomSportsTCXReader reader2 = new TomTomSportsTCXReader("/home/wangyu/Downloads/fit-20171217T143715.tcx");
        reader2.readTest();
        List<GPSItem> list = reader2.generateGPSItemList();
        System.out.println("-------GPSItem List size: " + list.size() );
        for (GPSItem i:list) {
            System.out.println("-------------------------------");
            System.out.println("time: " + i.getTime());
            System.out.println("latitude: " + i.getCoordinate().getLatitude() + " longtitude: " + i.getCoordinate().getLongtitude());
            System.out.println("elevation: " + i.getElevation());
            System.out.println("distance: " + i.getDistance());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
