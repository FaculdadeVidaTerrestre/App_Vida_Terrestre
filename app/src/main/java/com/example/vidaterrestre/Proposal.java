package com.example.vidaterrestre;

public class Proposal {
    private final String title;
    private final String briefDescription; // Descrição breve
    private final String detailedDescription; // Descrição detalhada

    public Proposal(String title, String briefDescription, String detailedDescription) {
        this.title = title;
        this.briefDescription = briefDescription;
        this.detailedDescription = detailedDescription;
    }

    public String getTitle() {
        return title;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }
}
