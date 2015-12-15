## Introduction ##
metacsv is a wrapper for [opencsv](http://opencsv.sourceforge.net/) to allow extra metadata to be read and written alongside conventional csv files.

For example, if you want to write a csv file which represents data at a given timestep, 123, the file may look like this:

```
time=123
0,0,1,2,1,0
0,0,1,3,1,0
0,1,2,4,2,1
```

Other formats may be offered in the future (for example, the metadata may instead be written to an external file, or perhaps a different worksheet in an excel file), however, this library can provide a consistent interface for both reading and writing.