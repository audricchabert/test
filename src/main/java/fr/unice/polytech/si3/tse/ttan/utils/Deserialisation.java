package utils;


import jardin.Tuile;

import java.io.File;
import java.io.IOException;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
/**
 * Cette classe sert a créé le plateau a partir du fichier XML
 * @author fauconni
 *
 */

public class Deserialisation {

	
	private String nom = "plateau.xml";
	private Tuile[][] plateau ;
	
	public Deserialisation(){
		plateau = new Tuile[16][16];
	}
	
	public Tuile[][] creationPlateau(){
		try {
		 DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	     DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	     Document doc = docBuilder.parse (new File(nom));

	    
	     NodeList listOfTuiles = doc.getElementsByTagName("tuile");
	     
	     
	     for(int s=0; s<listOfTuiles.getLength() ; s++){
	    	 Node tuileNode = listOfTuiles.item(s);
	    	 if(tuileNode.getNodeType() == Node.ELEMENT_NODE){
	    		 
	    		 Element tuileElement = (Element)tuileNode;
	    		 
	    		 int x = Integer.parseInt(tuileElement.getAttribute("x"));
	    		 int y = Integer.parseInt(tuileElement.getAttribute("y"));
	    		 String type =tuileElement.getAttribute("type");
	    		 Boolean joueur2 =Boolean.parseBoolean(tuileElement.getAttribute("joueur2"));
	    		 Boolean joueur3 =Boolean.parseBoolean(tuileElement.getAttribute("joueur3"));
	    	   
	    		Tuile tuile = new Tuile(x,y,type,joueur2,joueur3);
	    		
	    		 plateau[x][y]= tuile;
	    	  }
	    	 
	         }
		
	     } catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plateau;
	}
	
			
}
