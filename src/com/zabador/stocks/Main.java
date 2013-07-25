package com.zabador.stocks;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, String> map;
    private static ArrayList<JCheckBox> checkboxes = new ArrayList<JCheckBox>();

    public static void main(String[] args) {
        fillMap();
        mapCheckboxes();
        init();
    }

    public static void fillMap() {
        map = new HashMap<String, String>();
        map.put("Symbol", "s");
        map.put("Name", "n");
        map.put("Last Trade (Price Only)", "l1");
        map.put("Change in Percent", "p2");
        
    }

    public static void mapCheckboxes() {
        for(String key: map.keySet()) {
            JCheckBox c = new JCheckBox(key);
            checkboxes.add(c);
        }
    }

    public static void init() {
        JFrame frame = new JFrame("Stock Info Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,200);
        frame.setLayout(new GridLayout());
        for(JCheckBox cb : checkboxes) {
            frame.getContentPane().add(cb);
        }
        
        frame.pack();
        frame.setVisible(true);
    }
}
