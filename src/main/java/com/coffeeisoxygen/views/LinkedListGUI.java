package com.coffeeisoxygen.views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LinkedListGUI {

    private JFrame frame;
    private JPanel visualizationPanel;
    private ArrayList<NodePanel> nodes;

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
        JButton addButton = new JButton("Add Node");
        JButton deleteButton = new JButton("Delete Node");
        controlPanel.add(addButton);
        controlPanel.add(deleteButton);

        // Action listeners
        addButton.addActionListener(e -> addNode());
        deleteButton.addActionListener(e -> removeNode());

        frame.add(visualizationPanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void addNode() {
        int id = nodes.size() + 1;
        NodePanel node = new NodePanel(id);
        nodes.add(node);
        visualizationPanel.add(node);
        updateNodePositions();
        visualizationPanel.repaint();
    }

    private void removeNode() {
        if (!nodes.isEmpty()) {
            NodePanel lastNode = nodes.remove(nodes.size() - 1);
            visualizationPanel.remove(lastNode);
            updateNodePositions();
            visualizationPanel.repaint();
        }
    }

    private void updateNodePositions() {
        int x = 50;
        int y = 200;
        int spacing = 150;

        for (NodePanel node : nodes) {
            node.setBounds(x, y, 100, 50);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LinkedListGUI::new);
    }
}
