package com.ubs.opsit.interviews;

import java.util.ArrayList;
import java.util.List;

public class InterviewBerlinTimeConverter implements TimeConverter {

	
	@Override
	public String convertTime(String aTime) {
		// TODO Auto-generated method stub
		List<Integer> listComponents = new ArrayList<Integer>();
		String splitTime[] = aTime.split(":") ;
    	for (String comp : splitTime) {
    		listComponents.add(Integer.parseInt(comp));
    	}
    	StringBuilder sbTime = new StringBuilder();
    	return sbTime.append(getBerlinClockLightsForSeconds(listComponents.get(2)))
    			.append(getFirstRowHours(listComponents.get(0)))
    			.append(getSecondRowHours(listComponents.get(0)))
    			.append(getFirstRowMinutes(listComponents.get(1)))
    			.append(getSecondRowMinutes(listComponents.get(1))).toString();
    	
	}

	public String getFirstRowHours(Integer hours) {
		// TODO Auto-generated method stub
		String retVal = null ;
		int statusFirstRow = getFirstRowStatus(hours);
		 retVal = getBerlinClockLightsForHours(4, statusFirstRow) ;
		return retVal ;
	}

	public String getSecondRowHours(Integer hours) {
		// TODO Auto-generated method stub
		String retVal = null ;
		int statusSecondRow = getSecondRowHoursStatus(hours);
		retVal = getBerlinClockLightsForHours(4, statusSecondRow) ;
		return retVal ;
	}
	
	public int getSecondRowHoursStatus(Integer hours) {
		// TODO Auto-generated method stub
		return (hours % 5);
	}

	

	public Integer getFirstRowStatus(Integer hours) {
		// TODO Auto-generated method stub
		
		Integer hoursLights = hours - (hours % 5) ;
		return hoursLights / 5 ;
	        
	}
	
	public String getBerlinClockLightsForHours(int numLight, int status) {
		String flag = "R" ;

        String retVal = "";
        for (int x = 0; x < status; x++) {
        	retVal += flag;
        }
        int remainder = numLight - status ;
        for (int y = 0; y < remainder; y++) {
        	retVal += "O";
        }
        return retVal;
    
	
	}
	
	
	
	public String getSecondRowMinutes(int min) {
		String retVal = null ;
		int minutes = min % 5 ;
		retVal = getBerlinClockLightsForMins(4, minutes);
		return  retVal ;
        
    }
	
	public String getBerlinClockLightsForMins(int numLight, int status) {
		String flag = "Y" ;

        String retVal = "";
        for (int x = 0; x < status; x++) {
        	retVal += flag;
        }
        int remainder = numLight - status ;
        for (int y = 0; y < remainder; y++) {
        	retVal += "O";
        }
        return retVal;
	}
	
	 public String getFirstRowMinutes(int mins) {
		 String retVal = null ;
		 int minutes = getFirstRowStatus(mins) ;
		  retVal = getBerlinClockLightsForMins(11, minutes);
	        return retVal ;
	    }

	 public String getBerlinClockLightsForSeconds(int sec) {
		 String retVal = "O" ;
		 int seconds = sec % 2 ;
		 if(seconds == 0) {
			 retVal = "Y" ;
		 }
	        return retVal ;
	    }
	
	
	
	

}
