
package finalprojectB;

import junit.framework.TestCase;
import java.util.Random;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing	   
	   
   }
   
/* Find URLs that incorrectly return isValid() false */
   public void testFalseInvalidRandom()
   {
	   long randomseed =System.currentTimeMillis();
	   Random random = new Random(randomseed);
	   
	   private static final int NUM_TESTS=1000;
	   String[] schemes = new String[] {"http", "https", "ftp"};
	   int authorityLen = random.nextInt(29) + 1;
	   int pathParts = random.nextInt(5);
	   int port = random.nextInt(65536);
	   StringBuilder testURL = new StringBuilder();
	   
	   testURL.append(schemes[random.nextInt(3)]);    //grab random scheme to start building URL to test
	   
	   for(int i = 0; i < authorityLen; i++)
	   {
		   
	   }
   }
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   

   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
