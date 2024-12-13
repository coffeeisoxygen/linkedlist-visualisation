package com.coffeeisoxygen.controllers;

import javax.swing.JOptionPane;

import com.coffeeisoxygen.classes.linkedlists.manager.LinkedListManager;
import com.coffeeisoxygen.classes.mahasiswa.Mahasiswa;
import com.coffeeisoxygen.classes.nodes.BaseNode;
import com.coffeeisoxygen.views.LinkedListGUI;

public class LinkedListController {

    private LinkedListManager manager;
    private LinkedListGUI view;

    public LinkedListController(LinkedListManager manager, LinkedListGUI view) {
        this.manager = manager;
        this.view = view;
        initView();
    }

    private void initView() {
        view.setAddNodeAction(e -> addNode(e));
        view.setDeleteNodeAction(e -> deleteNode(e));
        view.setUpdateNodeAction(e -> updateNode(e));
        view.setClearAction(e -> clearNodes(e));
    }

    private void addNode(java.awt.event.ActionEvent e) {
        String name = JOptionPane.showInputDialog("Enter name of the student:");
        String nimStr = JOptionPane.showInputDialog("Enter NIM of the student:");
        String scoreStr = JOptionPane.showInputDialog("Enter score of the student:");
        if (name != null && nimStr != null && scoreStr != null) {
            long nim = Long.parseLong(nimStr);
            int score = Integer.parseInt(scoreStr);
            Mahasiswa mahasiswa = new Mahasiswa(name, nim, score);
            manager.addMahasiswa(mahasiswa);
            BaseNode<Mahasiswa> node = manager.findMahasiswaByNim(nim);
            view.addNode(node);
        }
    }

    private void deleteNode(java.awt.event.ActionEvent e) {
        String nimStr = JOptionPane.showInputDialog("Enter NIM of the student to delete:");
        if (nimStr != null) {
            long nim = Long.parseLong(nimStr);
            manager.deleteMahasiswaByNim(nim);
            view.removeNode(nim);
        }
    }

    private void updateNode(java.awt.event.ActionEvent e) {
        String nimStr = JOptionPane.showInputDialog("Enter NIM of the student to update:");
        if (nimStr != null) {
            long nim = Long.parseLong(nimStr);
            String name = JOptionPane.showInputDialog("Enter new name:");
            String scoreStr = JOptionPane.showInputDialog("Enter new score:");
            if (name != null && scoreStr != null) {
                int score = Integer.parseInt(scoreStr);
                Mahasiswa updatedMahasiswa = new Mahasiswa(name, nim, score);
                manager.updateMahasiswaByNim(nim, updatedMahasiswa);
                BaseNode<Mahasiswa> node = manager.findMahasiswaByNim(nim);
                view.updateNode(node);
            }
        }
    }

    private void clearNodes(java.awt.event.ActionEvent e) {
        manager.clear();
        view.clearNodes();
    }

    public static void main(String[] args) {
        LinkedListManager manager = new LinkedListManager();
        LinkedListGUI view = new LinkedListGUI();
        new LinkedListController(manager, view);
    }
}
