package comp3111.covid;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.DatePicker;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.impl.entity.LaxContentLengthStrategy;
import org.controlsfx.control.CheckComboBox;
import edu.duke.FileResource;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Building on the sample skeleton for 'ui.fxml' Controller Class generated by SceneBuilder 
 */
public class Controller implements Initializable{    
    // Task Zero controller
	    @FXML
	    private Tab tabTaskZero;
	
	    @FXML
	    private TextField textfieldISO;
	
	    @FXML
	    private Button buttonConfirmedDeaths;
	
	    @FXML
	    private TextField textfieldDataset;
	
	    @FXML
	    private Button buttonRateOfVaccination;
	
	    @FXML
	    private Button buttonConfirmedCases;
	
	    @FXML
	    private Tab tabReport1;
	
	    @FXML
	    private Tab tabReport2;
	
	    @FXML
	    private Tab tabReport3;
	
	    @FXML
	    private Tab tabApp1;
	
	    @FXML
	    private Tab tabApp2;
	
	    @FXML
	    private Tab tabApp3;
	
	    @FXML
	    private TextArea textAreaConsole;
	    
	    
    // Task A controller
	    @FXML
	    private DatePicker EndDatePickerA2;
		
		@FXML
	    private TextArea PreviewSelectedCountriesBoxA2;
		
		@FXML
	    private Button PreviewSelectedCountriesButtonA2;
		
	    @FXML
	    private Button buttonCommendableFeaturesA;

	    @FXML
	    private DatePicker StartDatePickerA2;

	    @FXML
	    private Button buttonConfirmedCaseChart;
	    
	    @FXML
	    private Button PreviewSelectedCountriesButtonA1;

	    @FXML
	    private TextArea PreviewSelectedCountriesBoxA1;
	    
	    @FXML
	    private DatePicker DatePickerA1;
		
	    @FXML
	    private Button buttonConfirmedCaseTable;
	    
	    @FXML
	    private CheckComboBox<String> checkComboBoxA1;
	    
	    @FXML
	    private CheckComboBox<String> checkComboBoxA2;
    
    // Task B controller
	
    // Task C controller

	    
	    
    /**
     * Initialize the scene
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	// Task A init
			// create a country list
				String Dataset = textfieldDataset.getText();
				final ObservableList<String> CountryList = FXCollections.observableArrayList();
				FileResource fr = new FileResource("dataset/" + Dataset);
		
				for (CSVRecord rec : fr.getCSVParser(true)) {
					String location = rec.get("location");
					if (!CountryList.contains(location)) {
						CountryList.add(location);
					}
				}
				checkComboBoxA1.getItems().addAll(CountryList);
				checkComboBoxA2.getItems().addAll(CountryList);
			
			// set the valid date input between Mar 1, 2020 and July 20, 2021
				LocalDate minDate = LocalDate.of(2020, 3, 1);
				LocalDate maxDate = LocalDate.of(2021, 7, 20);
				DatePickerA1.setDayCellFactory(d ->
				           new DateCell() {
				               @Override public void updateItem(LocalDate item, boolean empty) {
				                   super.updateItem(item, empty);
				                   setDisable(item.isAfter(maxDate) || item.isBefore(minDate));
				               }});
				DatePickerA1.setValue(minDate);
				StartDatePickerA2.setDayCellFactory(d ->
		           new DateCell() {
		               @Override public void updateItem(LocalDate item, boolean empty) {
		                   super.updateItem(item, empty);
		                   setDisable(item.isAfter(maxDate.plusDays(-1)) || item.isBefore(minDate));
		               }});
				StartDatePickerA2.setValue(minDate);
				EndDatePickerA2.setDayCellFactory(d ->
		           new DateCell() {
		               @Override public void updateItem(LocalDate item, boolean empty) {
		                   super.updateItem(item, empty);
		                   setDisable(item.isAfter(maxDate) || item.isBefore(minDate.plusDays(1)));
		               }});
				EndDatePickerA2.setValue(minDate.plusDays(1));
		
		// Task B init
				
		// Task C init
		
    }

    
    
    
    /**
     *  Task Zero
     *  To be triggered by the "Confirmed Cases" button on the Task Zero Tab 
     *  
     */
    @FXML
    void doConfirmedCases(ActionEvent event) {
    	String iDataset = textfieldDataset.getText();
    	String iISO = textfieldISO.getText();
    	String oReport = DataAnalysis.getConfirmedCases(iDataset, iISO);
    	textAreaConsole.setText(oReport);
    }

  
    /**
     *  Task Zero
     *  To be triggered by the "Confirmed Deaths" button on the Task Zero Tab
     *  
     */
    @FXML
    void doConfirmedDeaths(ActionEvent event) {
    	String iDataset = textfieldDataset.getText();
    	String iISO = textfieldISO.getText();
    	String oReport = DataAnalysis.getConfirmedDeaths(iDataset, iISO);
    	textAreaConsole.setText(oReport);
    }

  
    /**
     *  Task Zero
     *  To be triggered by the "Rate of Vaccination" button on the Task Zero Tab
     *  
     */
    @FXML
    void doRateOfVaccination(ActionEvent event) {
    	String iDataset = textfieldDataset.getText();
    	String iISO = textfieldISO.getText();
    	String oReport = DataAnalysis.getRateOfVaccination(iDataset, iISO);
    	textAreaConsole.setText(oReport);
    }  
    
    
    /**
     *  Task A1
     *  To be triggered by the "Preview Selected Countries" button on the Table A Tab
     *  
     */
    @FXML
    void doPreviewSelectedCountriesA1(ActionEvent event) {
    	ObservableList<String> list = checkComboBoxA1.getCheckModel().getCheckedItems();
    	String oReport = "";
    	for (Object obj: list) {
    		oReport += String.format("%s\n", obj);
    	}
    	PreviewSelectedCountriesBoxA1.setText(oReport);
    	
    }
    
    /**
     *  Task A1
     *  To be triggered by the "Generate table for confirmed cases" button on the Table A Tab
     *  
     */
    @FXML
    void doConfirmedCaseTable(ActionEvent event) {
    	// get input
    	ObservableList<String> list = checkComboBoxA1.getCheckModel().getCheckedItems();
    	LocalDate intersetedDate = DatePickerA1.getValue();
    	String FormattedDate = intersetedDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
    	String dataset = textfieldDataset.getText();

    	// not selected any country
    	if (list.isEmpty()) {
    		textAreaConsole.setText("Please select country of interest!");
    		return;
    	}

    	String oReport = TaskA.generateTableA1(dataset, list, intersetedDate);
		textAreaConsole.setText(oReport);
		
		ObservableList<CountryA1> tableList = FXCollections.observableArrayList();
		for (String obj: list) {
    		tableList.add(new CountryA1(dataset, obj, FormattedDate));
    	}

		try {		
			TableA1Controller tableA1Controller = new TableA1Controller(intersetedDate, tableList);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/TableA1.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Table A1");
			loader.setController(tableA1Controller);
			stage.setScene(new Scene((VBox) loader.load()));
			stage.show();
		} catch(Exception e) {
			return;
		}
    }
	    
    /**
     *  Task A2
     *  To be triggered by the "Preview Selected Countries" button on the Chart A Tab
     *  
     */
    @FXML
    void doPreviewSelectedCountriesA2(ActionEvent event) {
    	ObservableList<String> list = checkComboBoxA2.getCheckModel().getCheckedItems();
    	String oReport = "";
    	for (Object obj: list) {
    		oReport += String.format("%s\n", obj);
    	}
    	PreviewSelectedCountriesBoxA2.setText(oReport);
    }
    
    /**
     *  Task A2
     *  To be triggered when selected the starting date on the Chart A Tab
     *  
     */
    @FXML
    void doRestrictDateA2(ActionEvent event) {
    	// set the valid date input between Mar 1, 2020 and July 20, 2021
		LocalDate minDate = StartDatePickerA2.getValue();
		LocalDate maxDate = LocalDate.of(2021, 7, 20);
		EndDatePickerA2.setDayCellFactory(d ->
		           new DateCell() {
		               @Override public void updateItem(LocalDate item, boolean empty) {
		                   super.updateItem(item, empty);
		                   setDisable(item.isAfter(maxDate) || item.isBefore(minDate.plusDays(1)));
		               }});
		if(EndDatePickerA2.getValue().isBefore(minDate.plusDays(1))) {
			EndDatePickerA2.setValue(minDate.plusDays(1));
		}
    }
    
    /**
     *  Task A2
     *  To be triggered by the "Generate chart of confirmed cases per 1M" button on the Chart A Tab
     *  
     */
    @FXML
    void doConfirmedCaseChart(ActionEvent event) {
    	// get input
    	ObservableList<String> list = checkComboBoxA2.getCheckModel().getCheckedItems();
    	LocalDate StartingDate = StartDatePickerA2.getValue();
    	LocalDate EndingDate = EndDatePickerA2.getValue();
    	String dataset = textfieldDataset.getText();
    	int duration = (int) (EndingDate.toEpochDay()-StartingDate.toEpochDay()) + 1;
    	
    	// not selected any country
    	if (list.isEmpty()) {
    		textAreaConsole.setText("Please select country of interest!");
    		return;
    	}
    		    	
    	String oReport = TaskA.generateChartA2(dataset, list, StartingDate, EndingDate);
    	textAreaConsole.setText(oReport);
    	
    	ObservableList<CountryA2> ChartList = FXCollections.observableArrayList();
    	ChartList.add(new CountryA2(dataset, "", StartingDate, StartingDate, duration));
		for (String obj: list) {
			ChartList.add(new CountryA2(dataset, obj, StartingDate, EndingDate, duration));
    	}

		try {		
			ChartA2Controller chartA2Controller = new ChartA2Controller(ChartList, duration);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/ChartA2.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Chart A2");
			loader.setController(chartA2Controller);
			stage.setScene(new Scene((VBox) loader.load()));
			stage.show();
		} catch(Exception e) {
			return;
		}
    }
    
    /**
     *  Task A Commendable Features
     *  To be triggered by the "Relation between test and confirmed percentage" button on the Table A Tab
     *  
     */
    @FXML
    void doCommendableFeaturesA(ActionEvent event) {
    	// get input
    	LocalDate intersetedDate = DatePickerA1.getValue();
    	String dataset = textfieldDataset.getText();
    		    	
    	String oReport = TaskA.generateComFeatureA(dataset, intersetedDate);
    	textAreaConsole.setText(oReport);

    	ComFeatureA ChartList = new ComFeatureA(dataset, intersetedDate);

		try {		
			ComFeatureAController Controller = new ComFeatureAController(ChartList, ChartList.data.size());
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FeatureA.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Commendable Feature of Task A");
			loader.setController(Controller);
			stage.setScene(new Scene((VBox) loader.load()));
			stage.show();
		} catch(Exception e) {
			return;
		}
    }
    
}

