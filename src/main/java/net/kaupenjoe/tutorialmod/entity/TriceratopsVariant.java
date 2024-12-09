package net.kaupenjoe.tutorialmod.entity;

import java.util.Arrays;
import java.util.Comparator;

public enum TriceratopsVariant {
    GRAY(0),
    GREEN(1);

    private static final TriceratopsVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(TriceratopsVariant::getId)).toArray(TriceratopsVariant[]::new);
    private final int id;

    TriceratopsVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static TriceratopsVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
