package com.zabador.stocks;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;

import java.net.MalformedURLException;
import java.net.URL;

import java.nio.charset.Charset;

public class SearchSymbol {

    private JSONObject jsonFeed;
    private String symbol;
    private String query;

    public SearchSymbol(String query) {

        this.query = query;
    }

    public String getSymbol() {
        jsonFeed = readJsonFromUrl("http://d.yimg.com/autoc.finance.yahoo.com/autoc?query="+ query +"&callback=YAHOO.Finance.SymbolSuggest.ssCallback");
        JSONObject resultSet = jsonFeed.getJSONObject("ResultSet");
        JSONArray result = resultSet.getJSONArray("Result");
        JSONObject company = result.getJSONObject(0);
        return company.getString("symbol")+"  -   "+company.getString("name");
    }

    private String readAll(Reader rd) {
        StringBuilder sb = new StringBuilder();
        int cp;
        try{
            while ((cp = rd.read()) != -1) {
              sb.append((char) cp);
            }
        }catch(IOException ioe){
            ioe.getMessage();
        }
        return sb.toString();
    }

    public JSONObject readJsonFromUrl(String url) {
        JSONObject json = null;
        InputStream is = null;
        try{
            is = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            json = new JSONObject(jsonText.substring(jsonText.indexOf('{')));
        }catch(MalformedURLException mue) {
            mue.getMessage();
        }catch (IOException ioe){
            ioe.getMessage(); 
        }finally {
            try{
                is.close();
            }catch(IOException ioe){
                ioe.getMessage();
            }
        }
        return json;
    }
}
