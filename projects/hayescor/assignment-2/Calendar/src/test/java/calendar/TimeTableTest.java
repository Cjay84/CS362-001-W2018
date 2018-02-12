package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {
	/** 
	 * Create instance of CalDay and two appts, then test if TimeTable returns
	 * proper list of CalDays
	 */
	 @Test
	  public void test01()  throws Throwable  {
		int startHour=21;
		int startMinute=30;
		int startDay=1;
		int startMonth=2;
		int startYear=2018;
		String title="Test 2a";
		String description="This is test 1a.";
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
		startDay=1;
		startMonth=2;
		startYear=2018;
		title="Test 2b";
		description="This is test 1b.";
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
		  
		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt1);
		appts.add(appt2);
		  
		Calendar rightnow = Calendar.getInstance();
    	int thisMonth = rightnow.get(Calendar.MONTH)+1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		//Construct new CalDay object
		CalDay day = new CalDay(today);
		day.addAppt(appt1);
		day.addAppt(appt2);
		TimeTable timeTable = new TimeTable();
	//assertions
		assertTrue(day.isValid());
		assertEquals(2, day.getSizeAppts());                                      //check for two appts added
		assertEquals(1, timeTable.getApptRange(appts, today, tomorrow).size());   //should return the CalDay between the two dates
	 }
	 /** 
	 * Test for deletion of an appt
	 */
	 /*
	 @Test
	  public void test02()  throws Throwable  {
		int startHour=21;
		int startMinute=30;
		int startDay=1;
		int startMonth=2;
		int startYear=2018;
		String title="Test 2";
		String description="This is test 2.";
		 //Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt1);
		
		TimeTable timeTable = new TimeTable();
		timeTable.deleteAppt(appts, appt1);                           //delete target appt
	//assertions
		assertEquals(0, appts.size());                               //then check size of list
	 }
	 */
//add more unit tests as you needed
}
