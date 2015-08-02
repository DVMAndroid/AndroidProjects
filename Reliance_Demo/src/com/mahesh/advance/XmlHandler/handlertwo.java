package com.mahesh.advance.XmlHandler;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

import com.mahesh.advance.utils.BranchDetailss;
import com.mahesh.advance.utils.NewsDetailss;



public class handlertwo extends DefaultHandler
{ 
	public List<NewsDetailss> nDetails=new ArrayList<NewsDetailss>();
	
	public List<NewsDetailss> getnDetails() {
		return nDetails;
	}



	public String Nproduct,Info;
	
	private boolean in_Newss = false;
	private boolean in_news= false;
	private boolean in_Nproduct = false;
	private boolean in_info = false;
	


	
	
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (localName.equals("Newss")) {
			this.in_Newss = true;
			
		}
		else if (localName.equals("news")) {
			this.in_news = true;
		}
		else if (localName.equals("Nproduct")) {
//			Log.v("student",""+sno);
//			Log.v("Data From Attribute",attributes.getValue("name"));
			this.in_Nproduct = true;
		}else if (localName.equals("Info")) {
			this.in_info= true;
		}
	}	

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(this.in_Nproduct){
    		
			Nproduct=new String(ch, start, length);
			//item.add(new String(ch, start, length));
	    	}
		else if(this.in_info){
			Info=new String(ch, start, length);
		//	item.add(new String(ch, start, length));
			
		
		}
		  
	         }
	
	

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		if (localName.equals("Newss")) {
			this.in_Newss = false;
			
		}
		else if (localName.equals("news")) {
			this.in_news = false;
			
			Log.v("Newss", ""+Nproduct);

			
			NewsDetailss data=new NewsDetailss(Nproduct,Info);
			nDetails.add(data);
		}
		else if (localName.equals("Nproduct")) {
			this.in_Nproduct = false;
		}else if (localName.equals("Info")) {
			this.in_info= false;
		}
	}	
	         }
		