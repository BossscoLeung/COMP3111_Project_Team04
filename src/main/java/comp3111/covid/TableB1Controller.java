package comp3111.covid;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

/**
 * Building on the sample skeleton for 'TableB1.fxml' Controller Class generated by SceneBuilder
 */

public class TableB1Controller{

    @FXML
    private TableColumn<DeathsDataB1, String> ColumnCountry;

    @FXML
    private TableColumn<DeathsDataB1, String> ColumnDeaths;

    @FXML
    private TableColumn<DeathsDataB1, String> ColumnDeaths1M;

    @FXML
    private TableView<DeathsDataB1> TableB1;
    
    @FXML
    private Text TitleB1;
    
    /**
     * 
     * @param DataList The ObservableList of DeathsDataB1 type containing the data points to be shown in the table
     * @param date The date interested
     */
    
    public void showTable(ObservableList<DeathsDataB1> DataList, String date) {
    	
    	this.ColumnCountry.setCellValueFactory(new PropertyValueFactory<DeathsDataB1, String>("country"));
    	this.ColumnDeaths.setCellValueFactory(new PropertyValueFactory<DeathsDataB1, String>("totalDeath"));
    	this.ColumnDeaths1M.setCellValueFactory(new PropertyValueFactory<DeathsDataB1, String>("totalDeathPer1M"));
    	
    	TableB1.setItems(DataList);
    	TitleB1.setText("Number of Confirmed COVID-19 Deaths as of " + date);
    }

}


