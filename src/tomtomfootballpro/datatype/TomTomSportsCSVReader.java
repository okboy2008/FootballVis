/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tomtomfootballpro.datatype;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author wangyu
 */
public class TomTomSportsCSVReader {
    private String path;
    
    public TomTomSportsCSVReader(String path) {
        this.path = path;
    }
    
    public void readTest(){
        Reader in;
        try {
            in = new FileReader(path);
            Iterable<CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(in);
            for (CSVRecord record : records) {
                if (record.get(Defines.CSV_COLUMN_ACTIVITY_TYPE).equalsIgnoreCase(Defines.CSV_EOR)) {
                    System.out.println("last record reached");
                    break;
                }
                String time = record.get(Defines.CSV_COLUMN_TIME);
                System.out.println("read time = " + time);
            }
        } catch (Exception ex) {
            Logger.getLogger(TomTomSportsCSVReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
