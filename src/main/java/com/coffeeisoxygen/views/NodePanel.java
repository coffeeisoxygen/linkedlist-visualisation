package com.coffeeisoxygen.views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.coffeeisoxygen.classes.mahasiswa.Mahasiswa;
import com.coffeeisoxygen.classes.nodes.BaseNode;

public class NodePanel extends JPanel {

    private BaseNode<?> node;

    public NodePanel(BaseNode<?> node) {
        this.node = node;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(new BorderLayout());

        JLabel label = new JLabel("ID: " + node.getId() + ", Data: " + node.getData().toString());
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);
    }

    public int getId() {
        return node.getId();
    }

    public long getNim() {
        if (node.getData() instanceof Mahasiswa mahasiswa) {
            return mahasiswa.getNim();
        }
        return -1;
    }

    @Override

    public void setName(String name) {
        if (node.getData() instanceof Mahasiswa mahasiswa) {
            mahasiswa.setName(name);
        }
    }

    public void setNilai(int nilai) {
        if (node.getData() instanceof Mahasiswa mahasiswa) {
            mahasiswa.setNilai(nilai);
        }
    }
}
