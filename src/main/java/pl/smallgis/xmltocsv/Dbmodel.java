package pl.smallgis.xmltocsv;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "listOfInitialData" })
public class Dbmodel {

	private ArrayList<Table> listOfInitialData;

	public ArrayList<Table> getListOfInitialData() {
		return listOfInitialData;
	}

	@XmlElement(name = "table")
	public void setListOfInitialData(ArrayList<Table> listOfInitialData) {
		this.listOfInitialData = listOfInitialData;
	}
}
