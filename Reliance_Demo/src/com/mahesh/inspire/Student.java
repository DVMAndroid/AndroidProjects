package com.mahesh.inspire;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



import android.util.Log;

public class Student  extends DefaultHandler
{ 
	public static  List<AreaDetails> sDetails=new ArrayList<AreaDetails>();
	
	
	public List<AreaDetails> getSDetails() {
		return sDetails;
	}


	public String area,city;
	
	private boolean in_maps = false;
	private boolean in_map= false;
	private boolean in_area = false;
	private boolean in_city = false;
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		sDetails.clear();
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (localName.equals("maps")) {
			this.in_maps = true;
			
		}
		else if (localName.equals("map")) {
			this.in_map = true;
		}
		else if (localName.equals("area")) {
//			Log.v("student",""+sno);
//			Log.v("Data From Attribute",attributes.getValue("name"));
			this.in_area = true;
		}else if (localName.equals("city")) {
			this.in_city= true;
		}
	}	

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(this.in_area){
    		
			area=new String(ch, start, length);
			//item.add(new String(ch, start, length));
	    	}
		else if(this.in_city){
			city=new String(ch, start, length);
		//	item.add(new String(ch, start, length));
			
		
		}
		  
	         }
	
	

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		if (localName.equals("maps")) {
			this.in_maps = false;
			
		}
		else if (localName.equals("map")) {
			this.in_map = false;
			AreaDetails a=new AreaDetails(area, city);
			sDetails.add(a);
		}
		else if (localName.equals("area")) {
			this.in_area = false;
		}else if (localName.equals("city")) {
			this.in_city= false;
		}
		
		
	}	
	         }
		
	
	

