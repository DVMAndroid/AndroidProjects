package com.mahesh.advance.XmlHandler;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

import com.mahesh.advance.utils.BranchDetailss;



public class HanldlerImple  extends DefaultHandler
{ 
	public List<BranchDetailss> bDetails=new ArrayList<BranchDetailss>();
	
	public List<BranchDetailss> getsDetails() {
		return bDetails;
	}



	public String Bname,Address1,Address2,Address3,Contact,lat,lang,location;
	
	private boolean in_Branches = false;
	private boolean in_Branch= false;
	private boolean in_Bname = false;
	private boolean in_Address1 = false;
	private boolean in_Address2 = false;
	private boolean in_Address3= false;
	private boolean in_Contact = false;
	private boolean in_location=false;
	private boolean in_lat=false;
	private boolean in_lang=false;


	
	
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
		if (localName.equals("Branches")) {
			this.in_Branches = true;
			
		}
		else if (localName.equals("Branch")) {
			this.in_Branch = true;
		}
		else if (localName.equals("Bname")) {
//			Log.v("student",""+sno);
//			Log.v("Data From Attribute",attributes.getValue("name"));
			this.in_Bname = true;
		}else if (localName.equals("Address1")) {
			this.in_Address1= true;
		}else if (localName.equals("Address2")) {
			this.in_Address2 = true;			
		}	
		else if (localName.equals("Address3")) {
			this.in_Address3= true;			
		}	
		else if (localName.equals("Contact")) {
			this.in_Contact = true;			
		}	
		else if (localName.equals("location")) {
			this.in_location = true;			
		}	
		else if (localName.equals("lat")) {
			this.in_lat= true;			
		}
		else if (localName.equals("lang")) {
			this.in_lang = true;			
		}	
	}	

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(this.in_Bname){
    		
			Bname=new String(ch, start, length);
			//item.add(new String(ch, start, length));
	    	}
		else if(this.in_Address1){
			Address1=new String(ch, start, length);
		//	item.add(new String(ch, start, length));
			
		
		}
		  else if(this.in_Address2){
			  Address2=new String(ch, start, length);
			  
			 // item.add(new String(ch, start, length));
			  
		  }	

	         else if(this.in_Address3){
	        	 
	        	 Address3=new String(ch, start, length);
	        	 //item.add(new String(ch, start, length));
	        	 
	        	 
	         }			
		
	         else if(this.in_Contact){
	        	 
	        	 Contact=new String(ch, start, length);
	        	 //item.add(new String(ch, start, length));
	        	 
	         }
             else if(this.in_location){
	        	 
	        	 Contact=new String(ch, start, length);
	        	 //item.add(new String(ch, start, length));
	        	 
	         }
            else if(this.in_lat){
	 
	 lat=new String(ch, start, length);
	 //item.add(new String(ch, start, length));
	 
 }
         else if(this.in_lang){
	 
	 lang=new String(ch, start, length);
	 //item.add(new String(ch, start, length));
	 
 }
	         }
	
	

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		if (localName.equals("Branches")) {
			this.in_Branches = false;
			
		}
		else if (localName.equals("Branch")) {
			this.in_Branch = false;
			
			Log.v("Branches", ""+Bname);

			
			BranchDetailss data=new BranchDetailss(Bname, Address1,Address2, Address3, Contact, location, lat,location);
			bDetails.add(data);
		}
		else if (localName.equals("Bname")) {
			this.in_Bname = false;
		}else if (localName.equals("Address1")) {
			this.in_Address1= false;
		}else if (localName.equals("Address2")) {
			this.in_Address2= false;		
		}	
		else if (localName.equals("Address3")) {
			this.in_Address3 = false;			
		}	
		else if (localName.equals("Contact")) {
			this.in_Contact = false;			
		}	
		else if (localName.equals("location")) {
			this.in_location = false;			
		}	
		else if (localName.equals("lat")) {
			this.in_lat = false;			
		}	
		else if (localName.equals("lang")) {
			this.in_lang= false;			
		}	
	}	
	         }
		
	
	

