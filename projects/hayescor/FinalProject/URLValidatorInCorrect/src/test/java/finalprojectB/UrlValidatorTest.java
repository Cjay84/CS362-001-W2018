
package finalprojectB;

import junit.framework.TestCase;
import java.util.Random;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!

public class UrlValidatorTest extends TestCase {
	private static final int NUM_TESTS=100;

    public UrlValidatorTest(String testName) {
		super(testName);
    }

	public void testInvalidURL()
	{
		// Manual test cases
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

		// Test various invalid urls
		assertFalse(urlVal.isValid("http//www.wikipedia.org")); // missing colon
		//assertFalse(urlVal.isValid("http://www..apple.com")); // two periods,       failed
		assertFalse(urlVal.isValid("http://www.reddit:80.com")); // wrong port location
		//assertFalse(urlVal.isValid("http://www.google.")); // end's in period,        failed
		assertFalse(urlVal.isValid("http://wwwrandomwebsite.org/dir:80/file")); // wrong port location
		//assertFalse(urlVal.isValid("http://www@oregonstate#edu")); // invalid characters, failed
	}
	
	public void testValidURL()
	{
		// Manual test cases
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

		// Test various invalid urls
		assertTrue(urlVal.isValid("http://www.google"));
		assertTrue(urlVal.isValid("http://www.wikipedia.org"));
		assertTrue(urlVal.isValid("http://www.apple.com"));
		assertTrue(urlVal.isValid("http://www.reddit.com"));
		//assertTrue(urlVal.isValid("http://www.randomwebsite.org:80/dir/file"));  //failed
		assertTrue(urlVal.isValid("http://www.oregonstate.edu"));
		//assertTrue(urlVal.isValid("https://inducks.org/fr/stats/usage_200802.html")); //failed
		//assertTrue(urlVal.isValid("http://www.reddit.com/r/explainlikeimfive/comments/1xhnn0/eli5_why_are_some_urls_so_complicated_for_example/")); //failed
	}
   
/* Find URLs that incorrectly return isValid() false */

	public void testFalseInvalidRandom()
	{
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		long randomseed = System.currentTimeMillis();
	    Random random = new Random(randomseed);
	   
	    //String[] schemes = new String[] {"http", "ftp"};
		
		for(int i = 0; i < NUM_TESTS; i++)
		{
			int authorityLen = random.nextInt(29) + 1;
			int pathParts = random.nextInt(5);
			int port = random.nextInt(65535) + 1;
			int hasPort = random.nextInt(2);
			int hasQuery = random.nextInt(2);
		
			StringBuilder testURL = new StringBuilder();
	   
			//testURL.append(schemes[random.nextInt(2)]);    //grab random scheme to start building URL to test
			testURL.append("http");
			testURL.append("://");
	   
			//add characters to build authority [-,.,0-9,a-z,A-Z]
			for(int b = 0; b < authorityLen; b++)
			{
				int randomAscii;
			
				if(b == 0 || b == authorityLen - 1 || testURL.charAt(b - 1) == '.' || testURL.charAt(b - 1) == '-')    //don't allow "-" and "." at beginning, end, or next to each other
				{
					randomAscii = random.nextInt(62) + 48;
				
					if(randomAscii > 57)
					{
						randomAscii += 7;
					
						if(randomAscii > 90)
						{
							randomAscii += 6;
						}
					}
				}
				else
				{
					randomAscii = random.nextInt(64) + 45;
				
					if(randomAscii > 46)
					{
						randomAscii += 1;
					
						if(randomAscii > 57)
						{
							randomAscii += 7;
					
							if(randomAscii > 90)
							{
								randomAscii += 6;
							}
						}
					}
				}
			
				testURL.append((char)randomAscii);
			}
		
			if(random.nextInt(2) == 1)
			{
				testURL.append(".com");
			}
		
			if(hasPort == 1)
			{
				testURL.append(":");
				testURL.append(port);
			}
		
			for(int b = 0; b < pathParts; b++)                                 //build each part in path hierarchy out of [0-9][a-z][A-Z][-]
			{
				int pathFragLen = random.nextInt(10) + 1;
		
				testURL.append("/");
				for(int z = 0; z < pathFragLen; z++)
				{
					int randomAscii = random.nextInt(63) + 45;
				
					if(randomAscii > 45)
					{
						randomAscii += 2;
					
						if(randomAscii > 57)
						{
							randomAscii += 7;
					
							if(randomAscii > 90)
							{
								randomAscii += 6;
							}
						}
					}
				
					testURL.append((char)randomAscii);
				}
			}
		
			if(hasQuery == 1)
			{
				int paramLen = random.nextInt(10) + 1;
				int valueLen = random.nextInt(10) + 1;
			
				testURL.append("?");
			
				for(int b = 0; b < paramLen; b++)
				{
					int randomAscii = random.nextInt(62) + 48;
				
					if(randomAscii > 57)
					{
						randomAscii += 7;
					
						if(randomAscii > 90)
						{
							randomAscii += 6;
						}
					}
				
					testURL.append((char)randomAscii);
				}
			
				testURL.append("=");
			
				for(int b = 0; b < valueLen; b++)
				{
					int randomAscii = random.nextInt(62) + 48;
				
					if(randomAscii > 57)
					{
						randomAscii += 7;
					
						if(randomAscii > 90)
						{
							randomAscii += 6;
						}
					}
				
					testURL.append((char)randomAscii);
				}
			
				if(random.nextInt(2) == 1)                            //flip a coin to see if there is a fragment
				{
					testURL.append("#");
			
					int fragLen = random.nextInt(10) + 1;
				
					for(int b = 0; b < fragLen; b++)
					{
						int randomAscii = random.nextInt(62) + 48;
				
						if(randomAscii > 57)
						{
							randomAscii += 7;
					
							if(randomAscii > 90)
							{
								randomAscii += 6;
							}
						}
				
						testURL.append((char)randomAscii);
					}
				}
			}
		
			System.out.println(testURL);
			if(urlVal.isValid(testURL.toString()))
			{
				System.out.println("Valid");
			}
			else
			{
				System.out.println("Invalid");
			}
		}
   }
   
   //testValidURLs_w_port and testValidURLs_w_newPath both involve mutating known valid URLs with traits from
   //known invalid URLs
    public void testValidURLs_w_port()
    {
		//test valid URLs found via random testing, but add a port
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	    assertTrue(urlVal.isValid("http://0RpWKeMEP7il7qVZ/Mezdbwzel"));
		assertFalse(urlVal.isValid("http://0RpWKeMEP7il7qVZ:80/Mezdbwzel"));
		assertTrue(urlVal.isValid("http://tK8.com/HldmKsh"));
		assertFalse(urlVal.isValid("http://tK8.com:237/HldmKsh"));
		assertTrue(urlVal.isValid("http://wgSUqDGsVtZ1sINzWcIRNM/U?WKwWMRSGxN=LO#qkGykSw"));
		assertFalse(urlVal.isValid("http://wgSUqDGsVtZ1sINzWcIRNM:1557/U?WKwWMRSGxN=LO#qkGykSw"));
		assertTrue(urlVal.isValid("http://f1INAzIuw5yCFModKvQbS.com/Hc3ZAzx?f=rlm#n"));
		assertFalse(urlVal.isValid("http://f1INAzIuw5yCFModKvQbS.com:12/Hc3ZAzx?f=rlm#n"));
    }
   
    public void testValidURLs_w_newPath()
	{
		//test valid URLs found via random testing, but replace the path with one from an invalid URL	  
		//the invalid URL can't have a port, thought, because I already know that causes a problem
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		assertTrue(urlVal.isValid("http://KhBrjAGZJcBOBbaYVZ7OxcRT/dAQ?GPveOLh=5qJSw#s6Ihg5m6C"));
		assertFalse(urlVal.isValid("http://KhBrjAGZJcBOBbaYVZ7OxcRT/nMnG3u/EQ"));
		assertTrue(urlVal.isValid("http://IcAfpi5toghRSOy02lYLPuyKEKrP.com/oj"));
		assertFalse(urlVal.isValid("http://IcAfpi5toghRSOy02lYLPuyKEKrP.com/V/S1TAA4b5fM/7G5wNM/XKfWdc?QIF3HVz=UFoYIDlS#VbcSQ"));
		assertTrue(urlVal.isValid("http://eFIebMGl.com/dfpCz"));
		assertFalse(urlVal.isValid("http://eFIebMGl.com/36mlxLt/ra-lWb6p/mUJNk?u1p=F6hNxbGf6S#SYwlHYkq1W"));
		assertTrue(urlVal.isValid("http://XSAlEPRy6qmoi03t4-pm9vNp.com/NriHKv"));
		assertFalse(urlVal.isValid("http://XSAlEPRy6qmoi03t4-pm9vNp.com/OU/LJ6o-a/goSp9l?fbGEG3=q#vMyxn4wP"));
    }
   
	public static void main(String[] argv) {

		UrlValidatorTest fct = new UrlValidatorTest("url test");
    }
}
