package comp3111.covid;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import org.controlsfx.control.CheckComboBox;
import javafx.scene.control.ComboBox;
import org.controlsfx.control.CheckListView;
import javafx.collections.ListChangeListener;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.impl.entity.LaxContentLengthStrategy;
import edu.duke.FileResource;
import java.net.URL;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.io.IOException;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

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
	    @FXML
	    private ComboBox<String> ContinentB1;
	    
	    @FXML
	    private DatePicker DatePickerB1;
	    
	    @FXML
	    private ListView<String> DisplayCountryB1;
	    
	    @FXML
	    private CheckListView<String> SelectCountryB1;

	    @FXML
	    private Button GenerateTableB1;
	    
	    
	    @FXML
	    private ComboBox<String> ContinentB2;
	    
	    @FXML
	    private DatePicker DatePickerStartB2;
	    
	    @FXML
	    private DatePicker DatePickerEndB2;
	    
	    @FXML
	    private ListView<String> DisplayCountryB2;
	    
	    @FXML
	    private CheckListView<String> SelectCountryB2;

	    @FXML
	    private Button GenerateChartB2;	    
	
    // Task C controller
	    @FXML
	    private DatePicker DatePickerC1;
	    
	    @FXML
	    private DatePicker DatePickerEndC2;
	    
	    @FXML
	    private DatePicker DatePickerStartC2;
	    
	    @FXML
	    private Button GenerateChartC2;
	    
	    @FXML
	    private Button GenerateTableC1;
	    
	    @FXML
	    private ListView<String> ListCountrySelectedC1;

	    @FXML
	    private ListView<String> ListCountrySelectedC2;
	    
	    @FXML
	    private ComboBox<String> SelectContinentC1;

	    @FXML
	    private ComboBox<String> SelectContinentC2;
	    
	    @FXML
	    private CheckListView<String> SelectCountryC1;

	    @FXML
	    private CheckListView<String> SelectCountryC2;
	    
	    
	    
	
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
			// create a country-by-continent list
				final ObservableList<String> ContinentList = FXCollections.observableArrayList();
				final ObservableList<String> ContinentFirstCountryList = FXCollections.observableArrayList();
				final ObservableList<ObservableList<String>> CountryByContinentList = FXCollections.observableArrayList();
				
				for (CSVRecord rec : fr.getCSVParser(true)) {
					String continent = rec.get("continent");
					String location = rec.get("location");
					// special case handling: when location is continent
					if (continent == "") {
						continent = rec.get("location");
					}
					
					if (!ContinentList.contains(continent)) {
						ContinentList.add(continent);
						ContinentB1.getItems().add(continent);
						ContinentB2.getItems().add(continent);
						
						final ObservableList<String> row = FXCollections.<String>observableArrayList();
						row.add(location);
						CountryByContinentList.add(row);
						
						ContinentFirstCountryList.add(location);
					}
					else {
						int i = ContinentList.indexOf(continent);
						if (!CountryByContinentList.get(i).contains(location)) {
							CountryByContinentList.get(i).add(location);
						}
						
					}
				}
				
				for (int i = 0; i < ContinentList.size(); i++) {
					SelectCountryB1.getItems().addAll(CountryByContinentList.get(i));
					SelectCountryB2.getItems().addAll(CountryByContinentList.get(i));
				}
				
				ContinentB1.setOnAction((e)->{
					String continent = ContinentB1.getValue();
					int i = ContinentList.indexOf(continent);
					String FirstCountry = ContinentFirstCountryList.get(i);
			    	SelectCountryB1.scrollTo(FirstCountry);
				});
				
				ContinentB2.setOnAction((e)->{
					String continent = ContinentB2.getValue();
					int i = ContinentList.indexOf(continent);
					String FirstCountry = ContinentFirstCountryList.get(i);
			    	SelectCountryB2.scrollTo(FirstCountry);
				});
				
				//Display countries selected
				SelectCountryB1.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
				    @Override
				    public void onChanged(ListChangeListener.Change<? extends String> c) {
				        c.next();
				        if(c.wasAdded()) {
				        	DisplayCountryB1.getItems().add(c.getAddedSubList().get(0));
				        } else if (c.wasRemoved()) {
				        	DisplayCountryB1.getItems().remove(c.getRemoved().get(0));
				        }
				    }				    
				});
				
				SelectCountryB2.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
				    @Override
				    public void onChanged(ListChangeListener.Change<? extends String> c) {
				        c.next();
				        if(c.wasAdded()) {
				        	DisplayCountryB2.getItems().add(c.getAddedSubList().get(0));
				        } else if (c.wasRemoved()) {
				        	DisplayCountryB2.getItems().remove(c.getRemoved().get(0));
				        }
				    }
				});
				
				//DatePicker
				//Initialize for Task B1
				DatePickerB1.setDayCellFactory(d ->
				           new DateCell() {
				               @Override public void updateItem(LocalDate item, boolean empty) {
				                   super.updateItem(item, empty);
				                   setDisable(item.isAfter(maxDate) || item.isBefore(minDate));
				               }});
				
				//Initialize for Task B2
				DatePickerStartB2.setDayCellFactory(d ->
		           new DateCell() {
		               @Override public void updateItem(LocalDate item, boolean empty) {
		                   super.updateItem(item, empty);
		                   setDisable(item.isAfter(maxDate) || item.isBefore(minDate));

		               }});
				DatePickerEndB2.setDayCellFactory(d ->
		           new DateCell() {
		               @Override public void updateItem(LocalDate item, boolean empty) {
		                   super.updateItem(item, empty);
		                   setDisable(item.isAfter(maxDate) || item.isBefore(minDate));
		               }});
				//Update minDate & maxDate
				DatePickerStartB2.setOnAction((e)->{
					DatePickerEndB2.setDayCellFactory(d ->
			           new DateCell() {
			               @Override public void updateItem(LocalDate item, boolean empty) {
			                   super.updateItem(item, empty);
			                   setDisable(item.isAfter(maxDate) || item.isBefore(DatePickerStartB2.getValue()));
			               }});
				});
				DatePickerEndB2.setOnAction((e)->{
					DatePickerStartB2.setDayCellFactory(d ->
			           new DateCell() {
			               @Override public void updateItem(LocalDate item, boolean empty) {
			                   super.updateItem(item, empty);
			                   setDisable(item.isAfter(DatePickerEndB2.getValue()) || item.isBefore(minDate));
			               }});
				});
				
				
				
		// Task C init
				// Initialize DatePicker for Task C1 and C2
				// Set date range available for selection
				DatePickerC1.setDayCellFactory(d ->
					new DateCell() {
						@Override
						public void updateItem(LocalDate item, boolean empty) {
							super.updateItem(item, empty);
							setDisable(item.isAfter(maxDate) || item.isBefore(minDate));
						}
					}
				);
				
				DatePickerStartC2.setDayCellFactory(d ->
					new DateCell() {
						@Override
						public void updateItem(LocalDate item, boolean empty) {
							super.updateItem(item, empty);
							setDisable(item.isAfter(maxDate) || item.isBefore(minDate));
						}
					}
				);
				
				DatePickerEndC2.setDayCellFactory(d ->
					new DateCell() {
						@Override
						public void updateItem(LocalDate item, boolean empty) {
							super.updateItem(item, empty);
							setDisable(item.isAfter(maxDate) || item.isBefore(minDate));
						}
					}
				);
				
				// Update available dates such that minDate <= macDate
				DatePickerStartC2.setOnAction((e)->{
					DatePickerEndC2.setDayCellFactory(d ->
			        	new DateCell() {
			        		@Override public void updateItem(LocalDate item, boolean empty) {
			        			super.updateItem(item, empty);
			        			setDisable(item.isAfter(maxDate) || item.isBefore(DatePickerStartC2.getValue()));
			        		}
			        	}
					);
				});
				
				DatePickerEndC2.setOnAction((e)->{
					DatePickerStartC2.setDayCellFactory(d ->
			          	new DateCell() {
			          		@Override public void updateItem(LocalDate item, boolean empty) {
			          			super.updateItem(item, empty);
			          			setDisable(item.isAfter(DatePickerEndC2.getValue()) || item.isBefore(minDate));
			          		}
			          	}
					);
				});
				
				// Set Country list
				SelectCountryC1.getItems().addAll(CountryList);
				SelectCountryC2.getItems().addAll(CountryList);
				
				// Display selected countries
				SelectCountryC1.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
				    @Override
				    public void onChanged(ListChangeListener.Change<? extends String> c) {
				        c.next();
				        if(c.wasAdded()) {
				        	ListCountrySelectedC1.getItems().add(c.getAddedSubList().get(0));
				        } else if (c.wasRemoved()) {
				        	ListCountrySelectedC1.getItems().remove(c.getRemoved().get(0));
				        }
				    }				    
				});
				
				SelectCountryC2.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
				    @Override
				    public void onChanged(ListChangeListener.Change<? extends String> c) {
				        c.next();
				        if(c.wasAdded()) {
				        	ListCountrySelectedC2.getItems().add(c.getAddedSubList().get(0));
				        } else if (c.wasRemoved()) {
				        	ListCountrySelectedC2.getItems().remove(c.getRemoved().get(0));
				        }
				    }
				});
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
    
    /**
     * Task B1
     * 
     */
    @FXML
    void doTableB1(ActionEvent event) {
    	String iDataset = textfieldDataset.getText();
    	ObservableList<String> country = FXCollections.observableArrayList();
    	
    	country = SelectCountryB1.getCheckModel().getCheckedItems();
    	LocalDate date = DatePickerB1.getValue();
    	
    	if (date == null || country.size() == 0) {
    		textAreaConsole.setText("Please select a valid date and at least one country.");
    	}
    	else {
    	
	    	ObservableList<DeathsDataB1> DataList = FXCollections.observableArrayList();
	    	for(String item : country) {
	    		DeathsDataB1 data = new DeathsDataB1(iDataset, item, date);
	    		DataList.add(data);
	    	}
    	
    	
	    	try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("/TableB1.fxml"));
	            Parent root = loader.load();   
	
	            TableB1Controller TableB1 = loader.getController();
	            TableB1.showTable(DataList, date.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
	    
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root));
	            stage.setTitle("Table B: Confirmed COVID-19 Deaths");
	            stage.show();
	    
	        } catch (IOException e) {
	            e.printStackTrace();
	        } 	
    	}
    	
    	
    }
    /**
     * Task B2
     * 
     */
    @FXML
    void doChartB2(ActionEvent event) {
    	String iDataset = textfieldDataset.getText();
    	ObservableList<String> countryList = FXCollections.observableArrayList();
    	
    	countryList = SelectCountryB2.getCheckModel().getCheckedItems();
    	LocalDate StartDate = DatePickerStartB2.getValue();
    	LocalDate EndDate = DatePickerEndB2.getValue();
    	
    	if (StartDate == null || EndDate == null || countryList.size() == 0) {
    		textAreaConsole.setText("Please select a valid period and at least one country.");
    	}
    	else {
    		
	    	DeathsDataB2 data = new DeathsDataB2();
	        ObservableList<XYChart.Series<String, Double>> series = data.Data(iDataset, countryList, StartDate, EndDate);
	        String text = data.getText();
	    	try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ChartB2.fxml"));
	            Parent root = loader.load();   
	
	            ChartB2Controller ChartB2 = loader.getController();
	            ChartB2.showChart(series, text);
	    
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root));
	            stage.setTitle("Chart B: Confirmed COVID-19 Deaths (per 1M)");
	            stage.show(); 
	        } catch (IOException e) {
	            e.printStackTrace();
	        } 	
    	}
    	
    }
    
    /**
     * Task C1
     * 
     */
    @FXML
    void doTableC1(ActionEvent event) {
    	String iDataset = textfieldDataset.getText();
    	ObservableList<String> countryList = FXCollections.observableArrayList();
    	
    	countryList = SelectCountryC1.getCheckModel().getCheckedItems();
    	LocalDate date = DatePickerC1.getValue();
    	
    	if (date == null || countryList.size() == 0) {
    		textAreaConsole.setText("Please select a valid date and at least one country.");
    	}
    	else {
    	
	    	ObservableList<VaccinationRate> DataList = FXCollections.observableArrayList();
	    	for(String country : countryList) {
	    		VaccinationRate data = new VaccinationRate();
	    		data.update(iDataset, country, date);
	    		DataList.add(data);
	    	}
    	
    	
	    	try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("/TableC1.fxml"));
	            Parent root = loader.load();   
	
	            TableC1Controller TableC1 = loader.getController();
	            TableC1.showTable(DataList, date.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
	    
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root));
	            stage.setTitle("Table C: Rate of Vaccination against COVID-19");
	            stage.show();
	    
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
    	}    	
    }
    
    /**
     * Task C2
     * 
     */
    @FXML
    void doChartC2(ActionEvent event) {
    	String iDataset = textfieldDataset.getText();
    	ObservableList<String> countryList = FXCollections.observableArrayList();
    	
    	countryList = SelectCountryC2.getCheckModel().getCheckedItems();
    	LocalDate StartDate = DatePickerStartC2.getValue();
    	LocalDate EndDate = DatePickerEndC2.getValue();
    	
    	if (StartDate == null || EndDate == null || countryList.size() == 0) {
    		textAreaConsole.setText("Please select a valid period and at least one country.");
    	}
    	else {
    		ObservableList<XYChart.Series<String, Double>> series = FXCollections.observableArrayList();
    		VaccinationRate data = new VaccinationRate();
    		
    		for (String country : countryList) {
    			XYChart.Series<String, Double> seriesItem = new XYChart.Series<String, Double>();
    			seriesItem.setName(country);
    			for (LocalDate date = StartDate; date.compareTo(EndDate) <= 0; date = date.plusDays(1)) {
    				data.update(iDataset, country, date);
    				if (data.getFormattedDate() != "" && data.getPeopleVaccinatedPer100() != "N/A")
    					seriesItem.getData().add(new XYChart.Data<String, Double>(data.getFormattedDate(), Double.parseDouble(data.getPeopleVaccinatedPer100())));
    				else if (data.getPeopleVaccinatedPer100() != "N/A")
    					seriesItem.getData().add(new XYChart.Data<String, Double>(date.format(DateTimeFormatter.ofPattern("M/d/yyyy")), Double.parseDouble(data.getPeopleVaccinatedPer100())));
    				else seriesItem.getData().add(new XYChart.Data<String, Double>(date.format(DateTimeFormatter.ofPattern("M/d/yyyy")), 0.0));
    			}
    			series.add(seriesItem);
    		}
	    	
	        try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ChartC2.fxml"));
	            Parent root = loader.load();   
	
	            ChartC2Controller ChartC2 = loader.getController();
	            ChartC2.showChart(series);
	    
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root));
	            stage.setTitle("Chart C: Cumulative Rate of Vaccination against COVID-19");
	            stage.show(); 
	        } catch (IOException e) {
	            e.printStackTrace();
	        } 	
    	}
    	
    }
    
}



