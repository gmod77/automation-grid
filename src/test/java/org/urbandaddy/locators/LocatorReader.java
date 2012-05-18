package org.urbandaddy.locators;

import java.io.File;
//import java.io.InputStream;
import java.net.URL;
//import java.util.Iterator;
//import java.util.List;

//import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
//import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class LocatorReader {

	private Document doc;

	public LocatorReader(String xmlName) {
		SAXReader reader = new SAXReader();
		try {
			URL url = getClass().getResource(xmlName);
			File file = new File(url.getFile());
			doc = reader.read(file);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getLocator(String locator){
		return doc.selectSingleNode("//" + locator.replace('.', '/')).getText();
		
	}
}
