package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final int NUM_TESTS=1000;
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void randomAddApptCheck()  throws Throwable  {
		  
		  //create Gregorian Calendar day for today
		  long randomseed =System.currentTimeMillis();
		  Calendar rightnow = Calendar.getInstance();
		  int thisYear = rightnow.get(Calendar.YEAR);
		  int thisMonth = rightnow.get(Calendar.MONTH)+1;
		  int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		  GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		  
		  CalDay curDay = new CalDay(today);
		  
		  //create 100 appts to add to curDay
		  for(int i = 0; i < NUM_TESTS; i++){
				Random random = new Random(randomseed);
				
				int startHour=ValuesGenerator.getRandomIntBetween(random, -10, 30);
				int startMinute=ValuesGenerator.getRandomIntBetween(random, -10, 65);
				int startDay=ValuesGenerator.getRandomIntBetween(random, -10, 40);
				int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
				int startYear=ValuesGenerator.getRandomIntBetween(random, -1000, 3000);
				String title=(String) ValuesGenerator.getString(random);
				String description=(String) ValuesGenerator.getString(random);
				
				Appt appt = new Appt(startHour,
				        startMinute ,
				        startDay ,
				        startMonth ,
				        startYear ,
				        title,
						description);
						
				curDay.addAppt(appt);
		  }
	 }
}
