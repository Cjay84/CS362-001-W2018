package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.LinkedList;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final int NUM_TESTS=50;
	private static final int NUM_APPTS=500;
	
	//create Gregorian Calendar day for today
	Calendar rightnow = Calendar.getInstance();
	int thisYear = rightnow.get(Calendar.YEAR);
	
	TimeTable timeTable = new TimeTable();
	
	long randomseed =System.currentTimeMillis();
	Random random = new Random(randomseed);
	
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void randomGetApptRangeTest()  throws Throwable  {
		//this will run for NUM_TESTS x NUM_APPTS
		//test two calendar days varying by up to 20 days apart for appts that could occur in the same date range
		for(int i = 0; i < NUM_TESTS; i++){
			LinkedList<Appt> appts = new LinkedList<Appt>();
			int thisMonth = 1;
			int thisDay = 1;
			GregorianCalendar firstDay = new GregorianCalendar(thisYear, thisMonth, thisDay);

			GregorianCalendar lastDay = (GregorianCalendar)firstDay.clone();
			lastDay.add(Calendar.DAY_OF_MONTH, (ValuesGenerator.getRandomIntBetween(random, 1, 20)));        //create a day between tomorrow and 20 days in the future
			
			//create list of appts to check
			for(int b = 0; b < NUM_APPTS; b++){
				int startHour=ValuesGenerator.getRandomIntBetween(random, -10, 30);
				int startMinute=ValuesGenerator.getRandomIntBetween(random, -10, 65);
				int startDay=ValuesGenerator.getRandomIntBetween(random, -10, 40);
				int startMonth=1;                                                             //create appts for this month only
				int startYear=thisYear;
				String title=(String) ValuesGenerator.getString(random);
				String description=(String) ValuesGenerator.getString(random);
				
				Appt appt = new Appt(startHour,
				        startMinute ,
				        startDay ,
				        startMonth ,
				        startYear ,
				        title,
						description);
						
				appts.add(appt);
			}
			
			timeTable.getApptRange(appts, firstDay, lastDay);
		}
	 }

	@Test
	  public void randomDeleteApptTest()  throws Throwable  {
		  
		for(int i = 0; i < NUM_TESTS; i++){  
			int numAppts = ValuesGenerator.getRandomIntBetween(random, 0, 20);
			LinkedList<Appt> appts = new LinkedList<Appt>();                                     //list of appts to be deleted from
		
			//populate list of appts to delete
			for(int b = 0; b < numAppts; b++){
					int startHour=ValuesGenerator.getRandomIntBetween(random, -1, 1);
					int startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 5);
					int startDay=ValuesGenerator.getRandomIntBetween(random, -1, 3);
					int startMonth=1;                                                             //create appts for this month only to ensure a comparable range of appts
					int startYear=thisYear;
					String title=(String) ValuesGenerator.getString(random);
					String description=(String) ValuesGenerator.getString(random);
				
					Appt appt = new Appt(startHour,
							startMinute ,
							startDay ,
							startMonth ,
							startYear ,
							title,
							description);
					
					appts.add(appt);
			}
		
			//delete random elements from appts
			for(int b = numAppts - 1; b >= 0; b--){
				if(ValuesGenerator.getBoolean((float)0.5, random));
					timeTable.deleteAppt(appts, appts.get(b));
			}	
		}
	}
	
}
