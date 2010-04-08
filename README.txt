= metacsv =

metacsv is a wrapper for [http://opencsv.sourceforge.net/ opencsv] to allow extra metadata to be read and written alongside conventional csv files.

For example, if you want to write a csv file which represents data at a given timestep, 123, the file may look like this:

{{{
time=123
0,0,1,2,1,0
}}}

Additional formats may be added in the future (for example, the metadata may instead be written to an external file, or perhaps a different worksheet in an excel file), however, this should not be of your concern so long as you use this library for both reading and writing.

== Example Writer ==
{{{
Metadata metadata = new Metadata();
metadata.put("Time", 123);
MetaCSVWriter metaCSVWriter = new MetaCSVWriterImpl(new FileWriter("example.csv"), metadata);

DataRow row = new DataRow(0,0,1,2,1,0);
metaCSVWriter.appendDataRow(row);

metaCSVWriter.close();
}}}

== Example Reader ==
{{{
MetaCSVReader reader = new MetaCSVReaderImpl(new FileReader("example.csv"));
Metadata metadata = reader.getMetadata();
int time = Integer.parseInt(metadata.get("time"));

List<DataRow> entries = reader.getData();
DataRow firstRow = entries.get(0);
String firstEntry = firstRow.get(0);
}}}