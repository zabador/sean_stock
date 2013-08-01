package com.zabador.stocks;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadCSV {

    private String searchTerms;
    private String header;
    private String searchSymbol;

    public DownloadCSV(String header, String searchSymbol, String searchTerms) {

        this.searchTerms = searchTerms; // options that the user selected to be downloaded
        this.header = header; // column names
        this.searchSymbol = searchSymbol; // company stock symbol
    }

    public void download() {
        try {
            URL website = new URL("http://download.finance.yahoo.com/d/quotes.csv?s="+ searchSymbol +"&f="+ searchTerms +"&e=.csv");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("stockInfo.csv");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            prepend();
        }catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    /**
     * Prepend the header to the CSV file so user knows what the columns are
     *
     */
    public void prepend() {
        try {
            RandomAccessFile file = new RandomAccessFile("stockInfo.csv","rws");
            byte[] text = new byte[(int) file.length()];
            file.readFully(text);
            file.seek(0);
            file.writeBytes(header);
            file.write(text);
            file.close();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
