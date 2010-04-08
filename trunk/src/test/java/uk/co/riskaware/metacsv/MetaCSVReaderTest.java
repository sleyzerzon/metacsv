package uk.co.riskaware.metacsv;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class MetaCSVReaderTest {
    @Test
    public void testReaderExtractsAProperty() throws IOException {
        InputStream input = new ByteArrayInputStream("key=val".getBytes());
        MetaCSVReader reader = new MetaCSVReaderImpl(input);
        Metadata metadata = reader.getMetadata();
        Assert.assertEquals("val", metadata.get("key"));
    }
    
    @Test
    public void testReaderExtractsTwoProperties() throws IOException {
        InputStream input = new ByteArrayInputStream("key=val\nnewKey=newVal".getBytes());
        MetaCSVReader reader = new MetaCSVReaderImpl(input);
        Metadata metadata = reader.getMetadata();
        Assert.assertEquals("val", metadata.get("key"));
        Assert.assertEquals("newVal", metadata.get("newKey"));
    }
    
    @Test
    public void testReaderExtractsData() throws IOException {
        InputStream input = new ByteArrayInputStream("1,2\n3,4".getBytes());
        MetaCSVReader reader = new MetaCSVReaderImpl(input);
        List<DataRow> entries = reader.getData();
        Assert.assertEquals("1", entries.get(0).get(0));
        Assert.assertEquals("2", entries.get(0).get(1));
        Assert.assertEquals("3", entries.get(1).get(0));
        Assert.assertEquals("4", entries.get(1).get(1));
    }
}
