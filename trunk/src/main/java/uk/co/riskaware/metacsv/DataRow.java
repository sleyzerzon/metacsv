package uk.co.riskaware.metacsv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.text.StrBuilder;

public class DataRow extends ArrayList<Object> implements List<Object> {

    private static final long serialVersionUID = 1L;

    public DataRow(Object... entries) {
        addAll(Arrays.asList(entries));
    }
    
    public DataRow(String... entries) {
        addAll(Arrays.asList(entries));
    }

    public String toString() {
        StrBuilder sbr = new StrBuilder();
        sbr.appendWithSeparators(this, ",");

        return sbr.toString();
    }
    

    public String[] toStringArray() {
        List<String> stringList = new ArrayList<String>();
        for (Object entry : this) {
            stringList.add(entry.toString());
        }
        return stringList.toArray(new String[0]);
    }
}
