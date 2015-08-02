package com.mahesh.advance.utils;

public class BranchDetailss {
	
	public String Bname,Address1,Address2,Address3,Contact,location,lat,lang;
	
	public String getBname() {
		return Bname;
	}

	public String getAddress1() {
		return Address1;
	}

	public String getAddress2() {
		return Address2;
	}

	public String getAddress3() {
		return Address3;
	}

	public String getContact() {
		return Contact;
	}
	public String getlocation(){
		return location;
	}
	public String getlat() {
		return lat;
	}
	public String getlang() {
		return lang;
	}


	public BranchDetailss(String bn,String a1,String a2,String a3,String c,String la,String lan,String loc)
	{
		
		Bname=bn;
		Address1=a1;
		Address2=a2;
		Address3=a3;
		Contact=c;
		lat=la;
		lang=lan;
		location=loc;
				
	}

}