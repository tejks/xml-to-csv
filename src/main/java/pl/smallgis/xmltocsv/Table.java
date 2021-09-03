package pl.smallgis.xmltocsv;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "pl.smallgis.xmltocsv")
public class Table {
	private String initialData;
	private String name;

	public String getInitialData() {
		return initialData;
	}

	@XmlElement(name = "initial-data")
	public void setInitialData(String initialData) {
		this.initialData = initialData;
	}
	
	public String getName() {
		return name;
	}
	
	@XmlAttribute(name = "name")
	public void setName(String name) {
		this.name = name;
	}
}
