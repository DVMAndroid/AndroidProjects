package com.inspire.handler;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.inspire.details.details;

public class Handle extends DefaultHandler
{

	public List<details>d=new ArrayList<details>();
	public List<details> getd()
	{
		return d;
	}

	private String sno1, name1,desg1,email1;

	private boolean students=false;
	private boolean student=false;
	private boolean sno=false;
	private boolean name=false;
	private boolean desg=false;
	private boolean email=false;
	
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if(localName.equals("results"))
		{
			this.students=false;
		}
		else if(localName.equals("result"))
		{
			this.student=false;
		}
		else if(localName.equals("term"))
		{
			this.sno=false;
		}
		else if(localName.equals("definition"))
		{
			this.name=false;
		}
		else if(localName.equals("category"))
		{
			this.desg=false;
		}
//		else if(localName.equals("email"))
//		{
//			this.email=false;
//		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		
		if(this.sno)
		{
			sno1=new String(ch, start, length);
		}
		else if(this.name)
		{
			name1=new String(ch, start, length);
		}
		else if(this.desg)
		{
			desg1=new String(ch, start, length);
		}
//		else if(this.email)
//		{
//			email1=new String(ch,start,length);
//		}
	}

	

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		if(localName.equals("results"))
		{
			this.students=true;
		
		}
		else if(localName.equals("result"))
		{
			this.student=true;
	
		
		}
		else if(localName.equals("term"))
		{
			this.sno=true;
			details data=new details(sno1, name1, desg1);
			d.add(data);
			
			
		}
		else if(localName.equals("definition"))
		{
			this.name=true;
		}
		else if(localName.equals("category"))
		{
			this.desg=true;
		}
//		else if(localName.equals("email"))
//		{
//			this.email=true;
//		}
	}


	

}
