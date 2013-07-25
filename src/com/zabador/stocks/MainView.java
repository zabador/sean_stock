package com.zabador.stocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainView implements ActionListener {

    private Map<String, String> map;
    private ArrayList<JCheckBox> checkboxes = new ArrayList<JCheckBox>();
    private JButton submit;

    public MainView() {
        fillMap();
        mapCheckboxes();
        init();
    }

    public void fillMap() {
        map = new HashMap<String, String>();
        map.put("Symbol", "s");
        map.put("Name", "n");
        map.put("Last Trade (Price Only)", "l1");
        map.put("Change in Percent", "p2");
        
    }

    public void mapCheckboxes() {
        for(String key: map.keySet()) {
            JCheckBox c = new JCheckBox(key);
            checkboxes.add(c);
        }
    }

    public void init() {
        JFrame frame = new JFrame("Stock Info Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,200);
        frame.setLayout(new GridLayout());
        for(JCheckBox cb : checkboxes) {
            frame.getContentPane().add(cb);
        }

        submit = new JButton("Submit");
        submit.addActionListener(this);
        frame.getContentPane().add(submit);
        
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit) {
            for(JCheckBox cb : checkboxes) {
                if(cb.isSelected())
                    System.out.println(cb.getText());
            }
        }
    }
}
