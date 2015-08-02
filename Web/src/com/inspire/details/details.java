package com.inspire.details;

import java.util.ArrayList;


public class details 
{
	public ArrayList<details> mCompleteAbbrDetails = new ArrayList<details>();

	public String sno,name,desg,email;

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public details(String s,String n,String d)
	{
		this.sno=s;
		this.name=n;
		this.desg=d;
	//	email=e;
	}
	
	public void CommitAnAbbr()
	{
		mCompleteAbbrDetails.add(new details(sno,
				name,desg));
	}
	
}
