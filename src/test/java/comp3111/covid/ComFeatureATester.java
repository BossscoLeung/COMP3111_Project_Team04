package comp3111.covid;

import org.junit.Before;
import org.junit.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.MoveTo;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.fxml.FXMLLoader;
import java.time.LocalDate;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;
public class ComFeatureATester {
	String iDataset = "COVID_Dataset_v1.0.csv"; 
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCorrectNoOfDataPoint() {
		LocalDate date = LocalDate.parse("2020-03-18");
		ComFeatureA test = new ComFeatureA(iDataset, date);
		assertEquals(test.data.size(), 53);
	}
	
	@Test
	public void testCorrectData() {
		LocalDate date = LocalDate.parse("2021-06-29");
		ComFeatureA test = new ComFeatureA(iDataset, date);
		double[] Xdata = {24.8046,39.8649,80.5273,608.5121,36.8909,294.7256,3.9899,131.85750000000002,15.6043,31.367700000000003,45.510000000000005,8.0865,97.2535,86.7736,38.8596,24.1982,2.6806,52.2158,45.1422,921.6759,609.0733,15.733600000000001,8.4277,115.5346,2.4890999999999996,22.640700000000002,98.5322,145.0676,101.6397,8.8113,58.69349999999999,124.2646,29.575200000000002,4.8354,29.0183,199.7902,118.08800000000001,12.3196,76.9125,34.7198,69.3503,4.0521,150.9027,134.43900000000002,143.1138,492.76300000000003,0.776,1.3889,44.7193,188.83710000000002,222.6881,5.5195,31.0022,98.66810000000001,17.035800000000002,1.906,5.0109,20.825,11.4527,47.2555,113.30199999999999,6.5652,69.0722,21.2866,12.912700000000001,44.843599999999995,130.2653,74.9986,43.3082,102.5404,12.5176,62.912099999999995,3.4294,64.7515,734.3957,64.8163,22.0252,20.3609,18.8665,91.1494,5.6793,12.1723,4.3729,16.4892,71.804,2.9153,24.735599999999998,580.698,306.44899999999996,141.8915,80.338,10.1329,4.3254};
		double[] Ydata = {9.8409659,7.591941800000001,0.1200084,7.2210095,3.3134944,15.6115217,0.5491769,9.3579459,3.7490097999999996,6.2485693,6.0697178,0.29460549999999996,3.7693076000000003,8.128044599999999,8.279943399999999,7.1879232,0.1828853,8.762789699999999,1.6600104,8.4944342,5.0785858,2.9901076,2.5930252,9.8774329,0.2401082,0.4622709,1.7215638999999998,9.1514662,4.047076000000001,1.6336296000000001,8.3648729,1.9484249,2.2001994,0.7884017,3.3279978000000003,9.7219342,7.0443338,0.6313309,7.359361900000001,5.553417,8.3092323,0.0290012,7.280715399999999,7.9555288,10.2386556,11.293564,0.1524213,0.1876481,2.3039704000000003,13.627063200000002,6.9343818,1.9492053,6.3627009,3.4539937,1.4374884,0.2426074,0.28615619999999997,3.4101482000000005,2.1859498,0.05688239999999999,2.4171028999999997,0.4334107,9.330304700000001,5.9107918,1.2849462,7.609166,8.602728299999999,7.7038659,5.6178286,3.7201364000000003,0.2949149,1.3962999,0.2565527,10.5290307,7.172795,12.3759219,3.2954125,0.3061508,1.2012422,8.1213868,0.0619227,0.3646348,0.1676705,2.3242736,6.4266255,0.1736604,5.256943499999999,6.3815417000000005,7.0583445000000005,10.1666414,10.5989331,0.8271125,0.32653730000000003};
		boolean allSame = true;
		
		for (int i =0; i<Xdata.length;i++) {
			if(test.data.get(i).getXValue()!=Xdata[i]) {
				allSame = false;
				break;
			}
			if(test.data.get(i).getYValue()!=Ydata[i]) {
				allSame = false;
				break;
			}
		}
		
		assertTrue(allSame);
	}
	
}