package uk.co.riskaware.metacsv;

import org.junit.Assert;
import org.junit.Test;


public class DataRowTest {

    @Test
    public void testBigNumbersHaveNoComma() {
        DataRow row = new DataRow();
        row.add(123123123);
        Assert.assertEquals("123123123", row.toString());
    }
    
    @Test
    public void testToString() {
        DataRow row = new DataRow("1", "2");
        Assert.assertEquals("1,2", row.toString());
    }
    
    @Test
    public void testToStringOnEmptyRow() {
        DataRow row = new DataRow();
        Assert.assertEquals("", row.toString());
    }
    
    @Test
    public void testAddDouble() {
        DataRow row = new DataRow("1");
        double d = 1.23;
        row.add(d);
        Assert.assertEquals("1,1.23", row.toString());
    }
    
    @Test
    public void testRowCanBeCreatedWithMultipleDoubles() {
        DataRow row = new DataRow(1, 2.3, 4.5);
        Assert.assertEquals("1,2.3,4.5", row.toString());
    }
    
    @Test
    public void testStringRowCanBeConvertedToStringArray() {
        DataRow row = new DataRow("a", "b", "c");
        String[] expectedArray = new String[] {"a", "b", "c"};
        
        for (int i = 0 ; i < row.size() ; i++) {
            Assert.assertEquals(expectedArray[i], row.toStringArray()[i]);
        }
    }
    
    @Test
    public void testNumericRowCanBeConvertedToStringArray() {
        DataRow row = new DataRow(1, 2.3, 4);
        String[] expectedArray = new String[] {"1", "2.3", "4"};
        
        for (int i = 0 ; i < row.size() ; i++) {
            Assert.assertEquals(expectedArray[i], row.toStringArray()[i]);
        }
    }
}
