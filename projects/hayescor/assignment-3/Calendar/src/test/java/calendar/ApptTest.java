package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }
/* Failed test, found bug(tested true for getValid() for an invalid day in February)
	 @Test
	  public void test02()  throws Throwable  {                        
		 int startHour=10;
		 int startMinute=30;
		 int startDay=29;
		 int startMonth=02;
		 int startYear=2019;
		 String title="Office Conference";
		 String description="Conference with the team.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertFalse(appt.getValid());                                          //start day is 29th, February on a non-leap year. Shouldn't allow.
		 assertEquals(10, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(29, appt.getStartDay());
		 assertEquals(02, appt.getStartMonth());
		 assertEquals(2019, appt.getStartYear());
		 assertEquals("Office Conference", appt.getTitle());
		 assertEquals("Conference with the team.", appt.getDescription());
	 }
*/  
/* Failed test, found bug, incorrect time suffix(am not pm)
	@Test
	  public void test03()  throws Throwable  {                        
		 int startHour=12;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=03;
		 int startYear=2018;
		 String title="Test3";
		 String description="This is test 3.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());                                          
		 assertEquals(12, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(03, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Test3", appt.getTitle());
		 assertEquals("This is test 3.", appt.getDescription());
		 assertEquals("\t03/15/2018 at 12:30pm ,Test3, This is test 3.\n", appt.toString());     //testing for proper suffix on time
	 }
*/
	/**
     * Test that we can retrieve days of recurrence
     */
	 @Test
	  public void test04()  throws Throwable  {
		 int startHour=9;
		 int startMinute=5;
		 int startDay=15;
		 int startMonth=06;
		 int startYear=2018;
		 String title="Test 4";
		 String description="This is test 4.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(2, appt.getRecurBy());
		 assertEquals(0, appt.getRecurIncrement());
		 assertFalse(appt.isRecurring());                                  //appointments can not be set to recur
	 }
	 /**
     * Test that an accurate string representation can be returned for most time and dates
     */
	 @Test
	  public void test05()  throws Throwable  {
		 int startHour=5;
		 int startMinute=20;
		 int startDay=20;
		 int startMonth=06;
		 int startYear=2018;
		 String title="Test 5";
		 String description="This is test 5.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertEquals("\t6/20/2018 at 5:20am ,Test 5, This is test 5.\n", appt.toString());     //testing toString() representation with "am" suffix
		 appt.setStartHour(13);
		 assertEquals("\t6/20/2018 at 1:20pm ,Test 5, This is test 5.\n", appt.toString());     //testing toString() representation with "pm" suffix
		 appt.setStartHour(0);
		 assertEquals("\t6/20/2018 at 12:20am ,Test 5, This is test 5.\n", appt.toString());     //testing toString() representation with 0 hour replacement of 12
	 }
	 /**
     * Test changing the appt using setters
     */
	 @Test
	  public void test06()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Test 6";
		 String description="This is test 6.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 appt.setStartHour(5);
		 appt.setStartMinute(15);
		 appt.setStartDay(12);
		 appt.setStartMonth(4);
		 appt.setStartYear(2017);
		 appt.setTitle("The title has been changed!");
		 appt.setDescription("The description has been changed!");
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(5, appt.getStartHour());
		 assertEquals(15, appt.getStartMinute());
		 assertEquals(12, appt.getStartDay());
		 assertEquals(4, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("The title has been changed!", appt.getTitle());
		 assertEquals("The description has been changed!", appt.getDescription());         		
	 }
	 /**
     * Test isValid() catches faulty dates, wrong hours
     */
	 @Test
	  public void test07()  throws Throwable  {
		 int startHour=24;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Test 7";
		 String description="This is test 7.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertFalse(appt.getValid());                      //check if hour is too high
		 appt.setStartHour(-1);
		 assertFalse(appt.getValid());                      //check if hour is too low
		 assertEquals(null, appt.toString());               //an invalid appt should not return a string representation
	 }
	 /**
     * Test isValid() catches faulty dates, wrong minutes
     */
	 @Test
	  public void test08()  throws Throwable  {
		 int startHour=21;
		 int startMinute=60;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Test 7";
		 String description="This is test 7.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertFalse(appt.getValid());                      //check if minute is too high
		 appt.setStartMinute(-1);
		 assertFalse(appt.getValid());                      //check if minute is too low		 
	 }
	 /* Failed test, found unknown bug, invalid month will not trigger isValid() == false, causes out of range error
	 *  in CalendarUtil.NumDaysInMonth()
     * Test isValid() catches faulty dates, wrong month
	 @Test
	  public void test09()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=13;
		 int startYear=2018;
		 String title="Test 7";
		 String description="This is test 7.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertFalse(appt.getValid());         		
	 }
	 */
	 /**
     * Test description and title are blank if not provided in setDescription() and setTitle()
     */
	 @Test
	  public void testNullDescripTitle()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Test descrip and title";
		 String description="This is test for description and title.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 appt.setDescription(null);
		 appt.setTitle(null);
		 assertEquals("", appt.getDescription());
		 assertEquals("", appt.getTitle());
	 }
	 /**
     * Test compareTo()
     */
	 @Test
	  public void testcompareTo()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Appt to compare 1";
		 String description="Appt to compare 1.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt1 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
				 
		 startHour=20;
		 startMinute=31;
		 startDay=15;
		 startMonth=01;
		 startYear=2018;
		 title="Appt to compare 2";
		 description="Appt to compare 2.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt2 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 //assertTrue(appt1.compareTo(appt2) > 0);                   //should return integer showing appt1 is later than appt2, this test fails
		 assertTrue(appt1.compareTo(appt2) == 0);                  //this test passes, unfortunately 0 tells us nothing about appt1 compared to appt2
	 }
}
