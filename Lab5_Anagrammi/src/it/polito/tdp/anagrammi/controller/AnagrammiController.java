package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Anagramma;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

		Model model ;
		
	    @FXML // ResourceBundle that was given to the FXMLLoader
	    private ResourceBundle resources;

	    @FXML // URL location of the FXML file that was given to the FXMLLoader
	    private URL location;

	    @FXML // fx:id="txtInput"
	    private TextField txtInput; // Value injected by FXMLLoader

	    @FXML // fx:id="btnCalcola"
	    private Button btnCalcola; // Value injected by FXMLLoader

	    @FXML // fx:id="txtCorretti"
	    private TextArea txtCorretti; // Value injected by FXMLLoader

	    @FXML // fx:id="txtErrati"
	    private TextArea txtErrati; // Value injected by FXMLLoader

	    @FXML // fx:id="btnReset"
	    private Button btnReset; // Value injected by FXMLLoader

	    @FXML
	    void doCalcola(ActionEvent event) {
	    	String daCercare = txtInput.getText() ;
	    	Set<Anagramma> tutti = model.cercaAnagramma(daCercare);
	    	for(Anagramma a : tutti){
	    		if(a.isCorrect())
	    			txtCorretti.appendText(a.toString()+"\n");
	    		else
	    			txtErrati.appendText(a.toString()+"\n");
	    	}
	    	
	    }
	    
	    // prova vommit

	    @FXML
	    void doReset(ActionEvent event) {
	    	txtErrati.clear() ;
	    	txtCorretti.clear() ;
	    	txtInput.clear() ;

	    }
	    
	    void setModel (Model m){
	    	this.model = m ;
	    }

	    @FXML // This method is called by the FXMLLoader when initialization is complete
	    void initialize() {
	        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Anagrammi.fxml'.";
	        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
	        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
	        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
	        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

	    }
	
}
