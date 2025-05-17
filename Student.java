package com.mycompany.roombooking;

/**
 * Represents an IIUM student with booking eligibility checks
 */
public class Student {
    private String matricNo;
    private String name;
    private String kuliyyah; // e.g., "KICT", "KOE"
    private int semester;
    private boolean isInternational;

    public Student(String matricNo, String name, String kuliyyah, int semester, boolean isInternational) {
        this.matricNo = matricNo;
        this.name = name;
        this.kuliyyah = kuliyyah;
        this.semester = semester;
        this.isInternational = isInternational;
    }

    // Getters
    public String getMatricNo() { return matricNo; }
    public String getName() { return name; }
    public String getKuliyyah() { return kuliyyah; }
    public int getSemester() { return semester; }
    public boolean isInternational() { return isInternational; }

    /**
     * IIUM-specific eligibility rules:
     * - Premium rooms: Minimum 3rd semester
     * - Deluxe rooms: Minimum 2nd semester
     */
    public boolean isEligibleForPremium() {
        return semester >= 3;
    }

    public boolean isEligibleForDeluxe() {
        return semester >= 2;
    }

    @Override
    public String toString() {
        return matricNo + " - " + name + " (" + kuliyyah + ", Semester " + semester + ")";
    }
}
