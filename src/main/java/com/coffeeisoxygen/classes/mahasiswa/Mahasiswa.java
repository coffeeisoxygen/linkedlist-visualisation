package com.coffeeisoxygen.classes.mahasiswa;

public class Mahasiswa {
    private String name;
    private Long nim;
    private int nilai;

    public Mahasiswa(String name, Long nim, int nilai) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (nim == null || nim <= 0) {
            throw new IllegalArgumentException("NIM must be a positive number");
        }
        if (nilai < 0 || nilai > 100) {
            throw new IllegalArgumentException("Nilai must be between 0 and 100");
        }
        this.name = name;
        this.nim = nim;
        this.nilai = nilai;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNim() {
        return nim;
    }

    public void setNim(Long nim) {
        this.nim = nim;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" +
                "name='" + name + 
                ", nim=" + nim +
                ", nilai=" + nilai +
                '}';
    }
}
