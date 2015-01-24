package logic;

import java.util.Calendar;
import java.util.Date;

import static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class CalenderUtilTest {

	@Test(dataProvider ="testGetTimeAddedDateDataProvider")
	public void testGetTimeAddedDate(Calendar d , Calendar t){
		
		Date date = d.getTime();
		Date time = t.getTime();
		
		
		assertNull(CalenderUtil.getTimeAddedDate(null, time));
		assertNull(CalenderUtil.getTimeAddedDate(date, null));
		assertNull(CalenderUtil.getTimeAddedDate(null, null));
		assertNotNull(CalenderUtil.getTimeAddedDate(date, time));
		
		Calendar c3 = Calendar.getInstance();
		c3.setTime(CalenderUtil.getTimeAddedDate(date, time));
		
		assertEquals(d.get(Calendar.MONTH), c3.get(Calendar.MONTH));
		assertEquals(d.get(Calendar.YEAR), c3.get(Calendar.YEAR));
		assertEquals(d.get(Calendar.DATE), c3.get(Calendar.DATE));
		assertEquals(t.get(Calendar.MINUTE), c3.get(Calendar.MINUTE));
		assertEquals(t.get(Calendar.SECOND), c3.get(Calendar.SECOND));
		assertEquals(t.get(Calendar.HOUR_OF_DAY), c3.get(Calendar.HOUR_OF_DAY));
		
	}
	
	
	@DataProvider(name="testGetTimeAddedDateDataProvider")
	public static Object[][] testGetTimeAddedDateDataProvider(){
		
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.MONTH, Calendar.MARCH);
		c1.set(Calendar.YEAR, 2014);
		c1.set(Calendar.DATE, 14);

		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.MINUTE, 25);
		c2.set(Calendar.SECOND, 30);
		c2.set(Calendar.HOUR_OF_DAY,10);
		
		
		Calendar c3 = Calendar.getInstance();
		c1.set(Calendar.MONTH, Calendar.DECEMBER);
		c1.set(Calendar.YEAR, 2014);
		c1.set(Calendar.DATE, 5);

		Calendar c4 = Calendar.getInstance();
		c2.set(Calendar.MINUTE, 15);
		c2.set(Calendar.SECOND, 30);
		c2.set(Calendar.HOUR_OF_DAY,21);

		Calendar c5 = Calendar.getInstance();
		c1.set(Calendar.MONTH, Calendar.JANUARY);
		c1.set(Calendar.YEAR, 2000);
		c1.set(Calendar.DATE, 1);

		Calendar c6 = Calendar.getInstance();
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 0);
		c2.set(Calendar.HOUR_OF_DAY,0);
		
		Object[][] dp = new Object[][]{{c1,c2},{c3,c4},{c5,c6}};
		return dp;
	}
	
	
	
	
	
}
