package com.example.campus_server.utils;

public enum ResultType {
    SUCCESS(0),
    ERROR(1),
    WARNING(2),
    INFORMATION(3),
    ACTION(4);

    private final int value;

    ResultType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ResultType getTypeOfValue(int value) throws Exception {
        return switch (value) {
            case 0 -> SUCCESS;
            case 1 -> ERROR;
            case 2 -> WARNING;
            case 3 -> INFORMATION;
            case 4 -> ACTION;
            default -> throw new Exception("No such value");
        };
    }
}
