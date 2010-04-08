package uk.co.riskaware.metacsv;

import java.io.IOException;
import java.util.List;

public interface MetaCSVReader {

    Metadata getMetadata() throws IOException;
    List<DataRow> getData() throws IOException;

}
