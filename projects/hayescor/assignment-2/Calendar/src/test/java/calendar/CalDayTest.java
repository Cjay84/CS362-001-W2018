package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {
	/**
     * Test creating an instance of CalDay
     */
	 @Test
	  public void test01()  throws Throwable  {
		Calendar rightnow = Calendar.getInstance();
    	int thisMonth = rightnow.get(Calendar.MONTH)+1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		//Construct new CalDay object
		CalDay day = new CalDay(today); 
	//assertions
		assertTrue(day.isValid());
		assertEquals(2, day.getMonth());
		assertEquals(2018, day.getYear());
		assertEquals(1, day.getDay());
	 }
	 /**
     * Test setting and retrieving appts for a CalDay
     */
	 @Test
	  public void test02()  throws Throwable  {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Test 2a";
		String description="This is test 2a.";
		 //Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
				 
		startHour=8;
		startMinute=15;
		startDay=20;
		startMonth=01;
		startYear=2018;
		title="Test 2b";
		description="This is test 2b.";
		 //Construct a new Appointment object with the initial data	 
		Appt appt2 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
				 
	// assertions
		assertTrue(appt1.getValid());
		assertTrue(appt2.getValid());
		  
		Calendar rightnow = Calendar.getInstance();
    	int thisMonth = rightnow.get(Calendar.MONTH)+1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		//Construct new CalDay object
		CalDay day = new CalDay(today);
		day.addAppt(appt1);
		day.addAppt(appt2);
	//assertions
		assertTrue(day.isValid());
		assertEquals(2, day.getSizeAppts());                                   //check for two appts added	
	 }
	 /**
     * Test string representation CalDay
     */
	 /*
	 @Test
	  public void test03()  throws Throwable  {
		Calendar rightnow = Calendar.getInstance();
    	int thisMonth = rightnow.get(Calendar.MONTH)+1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		//Construct new CalDay object
		CalDay day = new CalDay(today); 
	//assertions
		assertTrue(day.isValid());
		assertEquals("\t --- 2/1/2018 --- \n", day.toString());
	 }
	 */
//add more unit tests as you needed	
}
