package com.zabador.stocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainView implements ActionListener {

    private Map<String, String> map;
    private ArrayList<JCheckBox> checkboxes = new ArrayList<JCheckBox>();
    private JButton submit;
    private JButton add, addSearchBtn;
    private JButton remove, searchBtn;
    private JFrame frame;
    private JTextField symbolTxt, searchTxt;
    private JList symbols, searchList;
    private DefaultListModel listModel, searchModel;
    private JPanel userInputPanel, buttonPanel, symbolPanel, searchPanel, search_symbolPanel, checkboxPanel;
    private JLabel searchLbl, searchResult, orLbl;
    private JLabel enterSymbolLbl;
    private JScrollPane jScrollPanel, symbolPane, jScrollList;

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
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        listModel = new DefaultListModel();
        searchModel = new DefaultListModel();
        userInputPanel = new javax.swing.JPanel();
        enterSymbolLbl = new javax.swing.JLabel();
        orLbl = new javax.swing.JLabel();
        searchLbl = new javax.swing.JLabel();
        symbolTxt = new javax.swing.JTextField();
        searchTxt = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        jScrollList = new javax.swing.JScrollPane();
        searchList = new javax.swing.JList();
        jScrollPanel = new javax.swing.JScrollPane();
        checkboxPanel = new javax.swing.JPanel();
        symbolPane = new javax.swing.JScrollPane();
        symbols = new javax.swing.JList();
        remove = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        addSearchBtn = new JButton();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userInputPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        enterSymbolLbl.setText("Enter Company's Symbol:");

        orLbl.setText("Or");

        searchLbl.setText("Search for Company's Symbols:");

        add.setText("Add -->");

        searchBtn.setText("Search");

        searchList.setBackground(new java.awt.Color(238, 238, 238));
        searchList.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Search Results"));
        searchList.setModel(searchModel);

        jScrollList.setViewportView(searchList);

        javax.swing.GroupLayout userInputPanelLayout = new javax.swing.GroupLayout(userInputPanel);
        userInputPanel.setLayout(userInputPanelLayout);
        userInputPanelLayout.setHorizontalGroup(
                userInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(userInputPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(userInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(userInputPanelLayout.createSequentialGroup()
                            .addComponent(orLbl)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(userInputPanelLayout.createSequentialGroup()
                            .addComponent(enterSymbolLbl)
                            .addGap(63, 63, 63)
                            .addComponent(symbolTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                            .addComponent(add)
                            .addGap(25, 25, 25))
                        .addGroup(userInputPanelLayout.createSequentialGroup()
                            .addComponent(searchLbl)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(userInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollList, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                .addComponent(searchTxt))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchBtn)
                            .addGap(27, 27, 27))))
                            );
        userInputPanelLayout.setVerticalGroup(
                userInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(userInputPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(userInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(enterSymbolLbl)
                        .addComponent(symbolTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(add))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(orLbl)
                    .addGap(18, 18, 18)
                    .addGroup(userInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchLbl)
                        .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchBtn))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollList, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addContainerGap())
                );

        jScrollPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Select Your Options"));

        javax.swing.GroupLayout checkboxPanelLayout = new javax.swing.GroupLayout(checkboxPanel);
        checkboxPanel.setLayout(checkboxPanelLayout);
        checkboxPanelLayout.setHorizontalGroup(
                checkboxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 623, Short.MAX_VALUE)
                );
        checkboxPanelLayout.setVerticalGroup(
                checkboxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 343, Short.MAX_VALUE)
                );

        checkboxPanel.setLayout(new GridLayout(0,2));
        /*
         *
         * add the checkboxes
         *
         */
        for(JCheckBox cb : checkboxes) {
            checkboxPanel.add(cb);
        }

        jScrollPanel.setViewportView(checkboxPanel);

        symbols.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Symbols"));
        symbols.setModel(listModel);
        symbolPane.setViewportView(symbols);

        remove.setText("<-- Remove");

        submit.setText("Submit");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(userInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(9, 9, 9)
                    .addComponent(remove)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(symbolPane, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                    .addComponent(submit)
                    .addContainerGap())
                );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(userInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(submit)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(remove)
                                    .addGap(187, 187, 187))
                                .addComponent(symbolPane, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap())
                );


        submit.addActionListener(this);
        add.addActionListener(this);
        remove.addActionListener(this);
        searchBtn.addActionListener(this);

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

            // if user does not select any options pass in name and symbol
            if(searchTerms.length()==0) {
                header = "Name,Symbol\n";
                searchTerms = "ns";
            }

            header = header.replaceAll(",$","\n");// remove last comma from header
            String searchSymbol = symbols.getModel().toString().replace("[", "").replace("]","").replaceAll(",","+").replaceAll(" ","");
            System.out.println(searchSymbol);
            DownloadCSV download = new DownloadCSV(header, searchSymbol, searchTerms);
            download.download();
            JOptionPane.showMessageDialog(frame, "File finished downloading");
        }
        // add symbol to the List
        else if(e.getSource() == add) {

            if(!symbolTxt.getText().isEmpty()) {
                listModel.addElement(symbolTxt.getText());
                symbols.setModel(listModel);
                symbolTxt.setText("");
            }
        }

        // remove item from the list
        else if(e.getSource() == remove) {

            if(!symbols.isSelectionEmpty()) {
                listModel.remove(symbols.getSelectedIndex());
                symbols.setModel(listModel);
            }
        }

        else if(e.getSource() == searchBtn) {

            SearchSymbol company = new SearchSymbol(searchModel, searchTxt.getText().replaceAll(" ","+"));
            searchList.setModel(company.getModel());
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
