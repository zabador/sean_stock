package com.zabador.stocks;

import java.io.IOException;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadCSV {

    private String searchTerms;

    public DownloadCSV(String searchTerms) {

        this.searchTerms = searchTerms;
    }

    public void download() {
        try {
            URL website = new URL("http://download.finance.yahoo.com/d/quotes.csv?s=GOOG&f="+ searchTerms +"&e=.csv");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("stockInfo.csv");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
