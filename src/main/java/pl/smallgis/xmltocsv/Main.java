package pl.smallgis.xmltocsv;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Main {
	private static Scanner ii;
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		if (args.length != 1)
			throw new RuntimeException("File path is empty");
		String filePath = args[0];

		try {
			JAXBContext context = JAXBContext.newInstance(Dbmodel.class);

			Unmarshaller unmarshaller = context.createUnmarshaller();

			File XMLfile = new File(filePath);

			int startValue = filePath.lastIndexOf("\\");
			int endValue = filePath.lastIndexOf(".");
			String value = XMLfile.toString().substring(startValue, endValue);

			String user = System.getProperty("user.name");
			Files.createDirectory(Paths.get("C:\\Users\\" + user + "\\Desktop\\" + value));

			Dbmodel dbmodel = (Dbmodel) unmarshaller.unmarshal(XMLfile);

			ArrayList<Table> listOfInitialData = dbmodel.getListOfInitialData();

			for (Table table : listOfInitialData) {
				String allInitialData = table.getInitialData();
				if (allInitialData != null) {
					
					
					String replaceInitialData = "";
					String replaceInitial = "";
					
					ii = new Scanner(allInitialData.toString().trim());
					
					while (ii.hasNextLine()) {
						replaceInitial = ii.nextLine().trim(); 
						replaceInitialData += "\"" + replaceInitial.replace("•", "\",\"").replace("⸣", "\"")  + "\n";
					}
				
					PrintWriter save = new PrintWriter(
							"C:\\Users\\" + user + "\\Desktop\\" + value + "\\" + table.getName() + ".csv");
					save.println(replaceInitialData.trim().concat("\""));
					save.close();
				}
			}
			System.out.println("Successful");

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
