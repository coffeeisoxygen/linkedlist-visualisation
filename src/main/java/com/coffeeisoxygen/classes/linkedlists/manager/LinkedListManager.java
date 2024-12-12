package com.coffeeisoxygen.classes.linkedlists.manager;

import com.coffeeisoxygen.classes.linkedlists.category.CircularDoublyLinkedList;
import com.coffeeisoxygen.classes.linkedlists.category.CircularSingleLinkedList;
import com.coffeeisoxygen.classes.linkedlists.category.DoublyLinkedList;
import com.coffeeisoxygen.classes.linkedlists.category.SingleLinkedList;
import com.coffeeisoxygen.classes.linkedlists.LinkedList;
import com.coffeeisoxygen.classes.mahasiswa.Mahasiswa;
import com.coffeeisoxygen.classes.nodes.BaseNode;

public class LinkedListManager {

    private SingleLinkedList<Mahasiswa> singleLinkedList;
    private DoublyLinkedList<Mahasiswa> doublyLinkedList;
    private CircularSingleLinkedList<Mahasiswa> circularSingleLinkedList;
    private CircularDoublyLinkedList<Mahasiswa> circularDoublyLinkedList;

    public LinkedListManager() {
        singleLinkedList = new SingleLinkedList<>();
        doublyLinkedList = new DoublyLinkedList<>();
        circularSingleLinkedList = new CircularSingleLinkedList<>();
        circularDoublyLinkedList = new CircularDoublyLinkedList<>();
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        singleLinkedList.add(mahasiswa);
        doublyLinkedList.add(mahasiswa);
        circularSingleLinkedList.add(mahasiswa);
        circularDoublyLinkedList.add(mahasiswa);
    }

    public void addMahasiswaByPosition(Mahasiswa mahasiswa, String position) {
        if (position.equalsIgnoreCase("first")) {
            singleLinkedList.addFirst(mahasiswa);
            doublyLinkedList.addFirst(mahasiswa);
            circularSingleLinkedList.addFirst(mahasiswa);
            circularDoublyLinkedList.addFirst(mahasiswa);
        } else {
            addMahasiswa(mahasiswa);
        }
    }

    public void deleteMahasiswaByNim(Long nim) {
        removeMahasiswaByNim(singleLinkedList, nim);
        removeMahasiswaByNim(doublyLinkedList, nim);
        removeMahasiswaByNim(circularSingleLinkedList, nim);
        removeMahasiswaByNim(circularDoublyLinkedList, nim);
    }

    private void removeMahasiswaByNim(LinkedList<Mahasiswa> list, Long nim) {
        BaseNode<Mahasiswa> current = list.getHead();
        while (current != null) {
            if (current.getData().getNim().equals(nim)) {
                list.remove(current.getData());
                return;
            }
            current = current.getNext();
        }
    }

    public Mahasiswa findMahasiswaByNim(Long nim) {
        return findMahasiswaByNim(singleLinkedList, nim);
    }

    private Mahasiswa findMahasiswaByNim(LinkedList<Mahasiswa> list, Long nim) {
        BaseNode<Mahasiswa> current = list.getHead();
        while (current != null) {
            if (current.getData().getNim().equals(nim)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public void updateMahasiswaByNim(Long nim, Mahasiswa updatedMahasiswa) {
        deleteMahasiswaByNim(nim);
        addMahasiswa(updatedMahasiswa);
    }

    public void displayMahasiswa() {
        System.out.println("Single Linked List with Mahasiswa data:");
        singleLinkedList.display();

        System.out.println("Doubly Linked List with Mahasiswa data:");
        doublyLinkedList.display();

        System.out.println("Circular Single Linked List with Mahasiswa data:");
        circularSingleLinkedList.displayCircular(3);

        System.out.println("Circular Doubly Linked List with Mahasiswa data:");
        circularDoublyLinkedList.displayCircular(3);
    }

    public void clear() {
        singleLinkedList.clear();
        doublyLinkedList.clear();
        circularSingleLinkedList.clear();
        circularDoublyLinkedList.clear();
    }
}
