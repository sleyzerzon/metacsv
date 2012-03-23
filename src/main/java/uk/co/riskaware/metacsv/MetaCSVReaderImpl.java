package uk.co.riskaware.metacsv;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Implementation of basic CSV file reader that also reads metadata from the top of the CSV file
 * @author s_darwin
 *
 */
public class MetaCSVReaderImpl implements MetaCSVReader {

    private CSVReader delegate;
    private Metadata metadata = new Metadata();
    private List<DataRow> data = new ArrayList<DataRow>();
    private boolean fileRead = false;

    public MetaCSVReaderImpl(InputStreamReader inputStreamReader) {
        delegate = new CSVReader(inputStreamReader);
    }

    public MetaCSVReaderImpl(InputStream inputStream) {
        this(new InputStreamReader(inputStream));
    }

    public Metadata getMetadata() throws IOException {
        if (!fileRead) {
            readData();
        }
        return metadata;
    }
    
    public List<DataRow> getData() throws IOException {
        if (!fileRead) {
            readData();
        }
        return data;
    }

    private void readData() throws IOException {
        List<String[]> allEntries = delegate.readAll();
        for (String[] lineArray : allEntries) {
            if (lineIsMetadata(lineArray)) {
                String[] keyVal = lineArray[0].split("=");
                String key = keyVal[0].trim();
                String value = keyVal[1].trim();
                metadata.put(key, value);
            } else {
                data.add(new DataRow(lineArray));
            }
        }
        fileRead = true;
    }

    private boolean lineIsMetadata(String[] line) {
        return (line.length == 1) && line[0].contains("=")
                && !line[0].contains("" + CSVReader.DEFAULT_SKIP_LINES);
    }

	@Override
	public void close() throws IOException {
		delegate.close();		
	}
}
