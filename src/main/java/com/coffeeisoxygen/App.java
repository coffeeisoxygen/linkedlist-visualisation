package com.coffeeisoxygen;

import com.coffeeisoxygen.classes.linkedlists.manager.LinkedListManager;
import com.coffeeisoxygen.classes.mahasiswa.Mahasiswa;

public class App {

    public static void main(String[] args) {
        LinkedListManager manager = new LinkedListManager();

        // Add Mahasiswa
        manager.addMahasiswa(new Mahasiswa("Alice", 123456L, 85));
        manager.addMahasiswa(new Mahasiswa("Bob", 234567L, 90));
        manager.addMahasiswa(new Mahasiswa("Charlie", 345678L, 95));

        // Display Mahasiswa
        manager.displayMahasiswa();

        // Update Mahasiswa
        manager.updateMahasiswaByNim(234567L, new Mahasiswa("Bob Updated", 234567L, 95));

        // Display Mahasiswa after update
        manager.displayMahasiswa();

        // Delete Mahasiswa
        manager.deleteMahasiswaByNim(123456L);

        // Display Mahasiswa after delete
        manager.displayMahasiswa();

        // Clear all Mahasiswa
        manager.clear();

        // Display Mahasiswa after clear
        manager.displayMahasiswa();
    }
}
