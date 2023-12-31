package com.audiotome.audiotomeserver.audiobook;

public enum Status {
    DRAFT("DRAFT"), PUBLISHED("PUBLISHED");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
