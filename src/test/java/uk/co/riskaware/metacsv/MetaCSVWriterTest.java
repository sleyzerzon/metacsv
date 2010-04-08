package uk.co.riskaware.metacsv;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.Assert;
import org.junit.Test;


public class MetaCSVWriterTest {
    
    @Test
    public void testWriteAProperty() throws IOException {
        StringWriter stringWriter = new StringWriter();
        Metadata metadata = new Metadata();
        metadata.put("key", "value");
        
        MetaCSVWriter writer = new MetaCSVWriterImpl(stringWriter, metadata);
        writer.close();
        
        Assert.assertEquals("key=value", stringWriter.toString().trim());
    }
    
    @Test
    public void testWriteData() throws IOException {
        StringWriter stringWriter = new StringWriter();
       
        MetaCSVWriter writer = new MetaCSVWriterImpl(stringWriter, new Metadata());
        writer.appendDataRow(new DataRow("1", "2"));
        writer.close();
        
        Assert.assertEquals("1,2", stringWriter.toString().trim());
    }
    
    @Test
    public void testWriteNumericData() throws IOException {
        StringWriter stringWriter = new StringWriter();
       
        MetaCSVWriter writer = new MetaCSVWriterImpl(stringWriter, new Metadata());
        writer.appendDataRow(new DataRow(1,2));
        writer.close();
        
        Assert.assertEquals("1,2", stringWriter.toString().trim());
    }
    
    @Test
    public void testWriteMultipleData() throws IOException {
        StringWriter stringWriter = new StringWriter();
       
        MetaCSVWriter writer = new MetaCSVWriterImpl(stringWriter, new Metadata());
        writer.appendDataRow(new DataRow("1", "2"));
        writer.appendDataRow(new DataRow("3", "4"));
        writer.close();
        
        Assert.assertEquals("1,2\n3,4", stringWriter.toString().trim());
    }
    
    @Test
    public void testWriteDataAndMetadata() throws IOException {
        StringWriter stringWriter = new StringWriter();
        Metadata metadata = new Metadata();
        metadata.put("key", "value");
        MetaCSVWriter writer = new MetaCSVWriterImpl(stringWriter, metadata);
        writer.appendDataRow(new DataRow("1", "2"));
        writer.appendDataRow(new DataRow("3", "4"));
        writer.close();
        
        Assert.assertEquals("key=value\n1,2\n3,4", stringWriter.toString().trim());
    }
}
