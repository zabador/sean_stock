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

    public DownloadCSV(String header, String searchTerms) {

        this.searchTerms = searchTerms;
        this.header = header;
    }

    public void download() {
        try {
            URL website = new URL("http://download.finance.yahoo.com/d/quotes.csv?s=GOOG+AAPL&f="+ searchTerms +"&e=.csv");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("stockInfo.csv");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            prepend();
        }catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

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
