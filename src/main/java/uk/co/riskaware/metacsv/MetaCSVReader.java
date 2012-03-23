package uk.co.riskaware.metacsv;

import java.io.IOException;
import java.util.List;

/**
 * Interface for reading CSV files with metadata
 * @author s_darwin
 *
 */
public interface MetaCSVReader {

    Metadata getMetadata() throws IOException;
    
    List<DataRow> getData() throws IOException;
    
    void close() throws IOException;

}
