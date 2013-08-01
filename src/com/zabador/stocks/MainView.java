package com.zabador.stocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainView implements ActionListener {

    private Map<String, String> map;
    private ArrayList<JCheckBox> checkboxes = new ArrayList<JCheckBox>();
    private JButton submit;
    private JFrame frame;
    private JTextField symbol;

    public MainView() {
        fillMap();
        mapCheckboxes();
        init();
    }

    public void mapCheckboxes() {
        for(String key: map.keySet()) {
            JCheckBox c = new JCheckBox(key);
            checkboxes.add(c);
        }
    }

    public void init() {
        frame = new JFrame("Stock Info Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,200);
        frame.setLayout(new BorderLayout(0,5));
        JPanel checkboxPanel = new JPanel(new GridLayout(0,4));
        JPanel inputPanel = new JPanel();

        for(JCheckBox cb : checkboxes) {
            checkboxPanel.add(cb);
        }

        JLabel askForInput = new JLabel("Enter a stock symbol:   ");
        inputPanel.add(askForInput);

        symbol = new JTextField(20);

        submit = new JButton("Submit");
        submit.addActionListener(this);

        inputPanel.add(askForInput);
        inputPanel.add(symbol);
        inputPanel.add(submit);

        frame.getContentPane().add(checkboxPanel,BorderLayout.NORTH);
        frame.getContentPane().add(inputPanel,BorderLayout.SOUTH);
        
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit) {
            //this will be passed to the DowloadCSV and be put in the url to download what the user selected
            String searchTerms = "";
            //header for top row of so user knows what the columns are
            String header = "";

            for(JCheckBox cb : checkboxes) {
                if(cb.isSelected()) {
                    String key = cb.getText();
                    header += key+","; // add comma for csv 
                    searchTerms += map.get(key);
                }
            }

            header = header.replaceAll(",$","\n");// remove last comma from header
            String searchSymbol = symbol.getText();
            DownloadCSV download = new DownloadCSV(header, searchSymbol, searchTerms);
            download.download();
            SearchSymbol company = new SearchSymbol(symbol.getText());
            company.getSymbol();
            JOptionPane.showMessageDialog(frame, "File finished downloading");
        }
    }

    public void fillMap() {
        map = Collections.synchronizedMap(new LinkedHashMap<String, String>());
        map.put("Symbol","s");
        map.put("Name","n");
        map.put("Last Trade (With Time)","l");
        map.put("Last Trade (Price Only)","l1");
        map.put("Last Trade Date","d1");
        map.put("Last Trade Time","t1");
        map.put("Last Trade Size","k3");
        map.put("Change and Percent Change","c");
        map.put("Change","c1");
        map.put("Change in Percent","p2");
        map.put("Ticker Trend","t7");
        map.put("Volume","v");
        map.put("Average Daily Volume","a2");
        map.put("More Info","i");
        map.put("Trade Links","t6");
        map.put("Bid","b");
        map.put("Bid Size","b6");
        map.put("Ask","a");
        map.put("Ask Size","a5");
        map.put("Previous Close","p");
        map.put("Open","o");
        map.put("Day's Range","m");
        map.put("52-week Range","w");
        map.put("Change From 52-wk Low","j5");
        map.put("Pct Chg From 52-wk Low","j6");
        map.put("Change From 52-wk High","k4");
        map.put("Pct Chg From 52-wk High","k5");
        map.put("Earnings/Share","e");
        map.put("P/E Ratio","r");
        map.put("Short Ratio","s7");
        map.put("Dividend Pay Date","r1");
        map.put("Ex-Dividend Date","q");
        map.put("Dividend/Share","d");
        map.put("Dividend Yield","y");
        map.put("Float Shares","f6");
        map.put("Market Capitalization","j1");
        map.put("1yr Target Price","t8");
        map.put("EPS Est. Current Yr","e7");
        map.put("EPS Est. Next Year","e8");
        map.put("EPS Est. Next Quarter","e9");
        map.put("Price/EPS Est. Current Yr","r6");
        map.put("Price/EPS Est. Next Yr","r7");
        map.put("PEG Ratio","r5");
        map.put("Book Value","b4");
        map.put("Price/Book","p6");
        map.put("Price/Sales","p5");
        map.put("EBITDA","j4");
        map.put("50-day Moving Avg","m3");
        map.put("Change From 50-day Moving Avg","m7");
        map.put("Pct Chg From 50-day Moving Avg","m8");
        map.put("200-day Moving Avg","m4");
        map.put("Change From 200-day Moving Avg","m5");
        map.put("Pct Chg From 200-day Moving Avg","m6");
        map.put("Shares Owned","s1");
        map.put("Price Paid","p1");
        map.put("Commission","c3");
        map.put("Holdings Value","v1");
        map.put("Day's Value Change","w1,");
        map.put("Holdings Gain Percent","g1");
        map.put("Holdings Gain","g4");
        map.put("Trade Date","d2");
        map.put("Annualized Gain","g3");
        map.put("High Limit","l2");
        map.put("Low Limit","l3");
        map.put("Notes","n4");
        map.put("Last Trade (Real-time) with Time","k1");
        map.put("Bid (Real-time)","b3");
        map.put("Ask (Real-time)","b2");
        map.put("Change Percent (Real-time)","k2");
        map.put("Change (Real-time)","c6");
        map.put("Holdings Value (Real-time)","v7");
        map.put("Day's Value Change (Real-time)","w4");
        map.put("Holdings Gain Pct (Real-time)","g5");
        map.put("Holdings Gain (Real-time)","g6");
        map.put("Day's Range (Real-time)","m2");
        map.put("Market Cap (Real-time)","j3");
        map.put("P/E (Real-time)","r2");
        map.put("After Hours Change (Real-time)","c8");
        map.put("Order Book (Real-time)","i5");
        map.put("Stock Exchange","x");
    }

}
