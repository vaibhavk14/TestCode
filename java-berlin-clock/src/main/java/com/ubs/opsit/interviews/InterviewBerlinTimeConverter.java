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
		StringBuilder retVal = new StringBuilder();
		int statusFirstRow = getFirstRowStatus(hours);
		 return retVal.append(getBerlinClockRedLightsForHours(4, statusFirstRow)).append(getBerlinClockNoLightsForHours(4, statusFirstRow)).toString() ;
	}

	public String getSecondRowHours(Integer hours) {
		// TODO Auto-generated method stub
		StringBuilder retVal = new StringBuilder();
		int statusSecondRow = getSecondRowHoursStatus(hours);
		return retVal.append(getBerlinClockRedLightsForHours(4, statusSecondRow)).append(getBerlinClockNoLightsForHours(4, statusSecondRow)).toString() ;
	}
	
	public int getSecondRowHoursStatus(Integer hours) {
		// TODO Auto-generated method stub
		return Math.floorMod(hours, 5);
	}

	

	public Integer getFirstRowStatus(Integer hours) {
		// TODO Auto-generated method stub
		
		return Math.floorDiv(hours, 5) ;
	        
	}
	
	public String getBerlinClockRedLightsForHours(int numLight, int status) {
        StringBuilder retVal = new StringBuilder();
        for (int x = 0; x < status; x++) {
        	retVal.append("R");
        }
        
        return retVal.toString();
	}
	
	public String getBerlinClockNoLightsForHours(int numLight, int status) {
		StringBuilder retVal = new StringBuilder();
		int remiander = numLight - status ;
		for (int y = 0; y < remiander; y++) {
			retVal.append("O");
        }
		return retVal.toString();
	}

	
	public String getSecondRowMinutes(int min) {
		StringBuilder retVal = new StringBuilder() ;
		int minutes = Math.floorMod(min, 5);
		return retVal.append(getBerlinClockYellowLightsForMins(4, minutes)).append(getBerlinClockNoLightsForMins(4, minutes)).toString();
        
    }
	
	public String getBerlinClockYellowLightsForMins(int numLight, int status) {
		

        StringBuilder retVal = new StringBuilder();
        for (int x = 0; x < status; x++) {
        	retVal.append("Y");
        } 
        return retVal.toString();
	}
	
	public String getBerlinClockNoLightsForMins(int numLight, int status) {
		

        StringBuilder retVal = new StringBuilder();
        int remiander = numLight - status;
        for (int y = 0; y < remiander; y++) {
        	retVal.append("O");
        }
        return retVal.toString();
	}
	
	 public String getFirstRowMinutes(int mins) {
		 StringBuilder retVal = new StringBuilder() ;
		 int minutes = getFirstRowStatus(mins) ;
		  return retVal.append(getBerlinClockYellowLightsForMins(11, minutes)).append(getBerlinClockNoLightsForMins(11, minutes)).toString();
	    }

	 public String getBerlinClockLightsForSeconds(int sec) {
		 String retVal = "O" ;
		 int k = Math.floorMod(sec, 2);
		 switch (k) {
			 case 0 : 
				 retVal = "Y" ;
				 break ;
			 default :
				 retVal = "O" ;
		 }
		 
		 return retVal ;
	        
	    }
	
	
	
	

}
