package uk.co.riskaware.metacsv;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

public class MetaCSVWriterImpl implements MetaCSVWriter {

    private CSVWriter delegate;
    
    public MetaCSVWriterImpl(Writer writer, Metadata metadata) {
        this(writer, metadata, CSVWriter.NO_QUOTE_CHARACTER);
    }
    
    public MetaCSVWriterImpl(Writer writer, Metadata metadata, char quoteChar) {
        delegate = new CSVWriter(writer, ',', quoteChar);
        writeMetadata(metadata);
    }
    
    private void writeMetadata(Metadata metadata) {
        for (String key : metadata.keySet()) {
            String[] line = new String[1];
            line[0] = key + "=" + metadata.get(key);
            delegate.writeNext(line);
        }
    }
    
    @Override
    public void close() throws IOException {
        delegate.close();
    }

    @Override
    public void appendDataRow(DataRow dataRow) {
        delegate.writeNext(dataRow.toStringArray());
    }
    
    @Override
    public void appendData(List<DataRow> data) {
        for (DataRow row : data) {
            appendDataRow(row);
        }
    }
    
}
