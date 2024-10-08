package com.guriani.health_index.model;

/**
 * Enum représentant les différentes pathologies avec leur multiple associé.
 */
public enum Pathology {
    CARDIOLOGY("Cardiologie", 3),
    TRAUMATOLOGY("Traumatologie", 5);

    private final String displayName;
    private final int multiple;

    Pathology(String displayName, int multiple) {
        this.displayName = displayName;
        this.multiple = multiple;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getMultiple() {
        return multiple;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
