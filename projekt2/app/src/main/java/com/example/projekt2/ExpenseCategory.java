package com.example.projekt2;

public enum ExpenseCategory {

    FOOD("Jedzenie"), ENTERTAINMENT("Rozrywka"), HYGIENE("Higiena"), OTHER("Inne");

    private String name;

    ExpenseCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
