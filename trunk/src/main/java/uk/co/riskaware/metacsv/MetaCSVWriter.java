package uk.co.riskaware.metacsv;

import java.io.IOException;
import java.util.List;

public interface MetaCSVWriter {

    void appendDataRow(DataRow entries);

    void appendData(List<DataRow> entries);

    void close() throws IOException;
}
