package databaseController;

import java.util.ArrayList;

import application.Phone;

public class PhoneController {
	
	ArrayList <Phone> PhoneList = new ArrayList <Phone>();
	
	
	public void savePhone(Phone phone) {
		
		
		PhoneList.add(phone); //Phone saved locally
		
		System.out.println(getPhones());
		
		
		//Add to database
		
		
		
		
		
	}
	
	
	
	public ArrayList getPhones() {
		
		
		
		
		return PhoneList; 
		
	}
	
	

}
