package uk.co.riskaware.metacsv;

import java.io.IOException;
import java.util.List;

/**
 * Interface for writing CSV files
 * @author s_darwin
 *
 */
public interface MetaCSVWriter {

    void appendDataRow(DataRow entries);

    void appendData(List<DataRow> entries);

    void close() throws IOException;
}
