package com.coffeeisoxygen.views;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.coffeeisoxygen.classes.mahasiswa.Mahasiswa;
import com.coffeeisoxygen.classes.nodes.BaseNode;

public class LinkedListGUI {

    private JFrame frame;
    private JPanel visualizationPanel;
    private ArrayList<NodePanel> nodes;
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton clearButton;

    public LinkedListGUI() {
        nodes = new ArrayList<>();
        setupGUI();
    }

    private void setupGUI() {
        frame = new JFrame("Linked List Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLayout(new BorderLayout());

        // Panel visualisasi
        visualizationPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawArrows((Graphics2D) g);
            }
        };
        visualizationPanel.setLayout(null);
        visualizationPanel.setBackground(Color.WHITE);

        // Panel kontrol
        JPanel controlPanel = new JPanel();
        addButton = new JButton("Add Node");
        deleteButton = new JButton("Delete Node");
        updateButton = new JButton("Update Node");
        clearButton = new JButton("Clear All");
        controlPanel.add(addButton);
        controlPanel.add(deleteButton);
        controlPanel.add(updateButton);
        controlPanel.add(clearButton);

        frame.add(visualizationPanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public void setAddNodeAction(ActionListener action) {
        addButton.addActionListener(action);
    }

    public void setDeleteNodeAction(ActionListener action) {
        deleteButton.addActionListener(action);
    }

    public void setUpdateNodeAction(ActionListener action) {
        updateButton.addActionListener(action);
    }

    public void setClearAction(ActionListener action) {
        clearButton.addActionListener(action);
    }

    public void addNode(BaseNode<?> node) {
        NodePanel nodePanel = new NodePanel(node);
        nodes.add(nodePanel);
        visualizationPanel.add(nodePanel);
        updateNodePositions();
        visualizationPanel.repaint();
    }

    public void removeNode(long nim) {
        nodes.removeIf(node -> node.getNim() == nim);
        updateNodePositions();
        visualizationPanel.repaint();
    }

    public void updateNode(BaseNode<?> node) {
        for (NodePanel nodePanel : nodes) {
            if (nodePanel.getId() == node.getId()) {
                nodePanel.setName(((Mahasiswa) node.getData()).getName());
                nodePanel.setNilai(((Mahasiswa) node.getData()).getNilai());
                break;
            }
        }
        visualizationPanel.repaint();
    }

    public void clearNodes() {
        nodes.clear();
        visualizationPanel.removeAll();
        visualizationPanel.repaint();
    }

    private void updateNodePositions() {
        int x = 50;
        int y = 200;
        int spacing = 150;

        for (NodePanel node : nodes) {
            node.setBounds(x, y, 140, 50);
            x += spacing;
        }
    }

    private void drawArrows(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(2));

        for (int i = 0; i < nodes.size() - 1; i++) {
            NodePanel current = nodes.get(i);
            NodePanel next = nodes.get(i + 1);

            int x1 = current.getX() + current.getWidth();
            int y1 = current.getY() + current.getHeight() / 2;
            int x2 = next.getX();
            int y2 = next.getY() + next.getHeight() / 2;

            g.drawLine(x1, y1, x2, y2);
            VisualizationUtils.drawArrowHead(g, x1, y1, x2, y2);
        }
    }
}
