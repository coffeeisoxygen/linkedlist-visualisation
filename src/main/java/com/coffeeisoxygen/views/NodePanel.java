package com.coffeeisoxygen.views;

import javax.swing.*;
import java.awt.*;

public class NodePanel extends JPanel {

    private int id;

    public NodePanel(int id) {
        this.id = id;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(new BorderLayout());

        JLabel label = new JLabel("IDNODE: " + id);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);
    }

    public int getId() {
        return id;
    }
}
