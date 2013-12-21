package com.bqdropbook.data;

public class Book {

	private String name;
	//private String title;
	private String modificationDate;
	
	public Book(String name, String modificationDate){
		this.name = name;
		this.modificationDate = modificationDate;
	}
	
	public String getName(){
		return this.name;		
	}
	
	public String getModificationDate(){
		return this.modificationDate;
	}
	
}
