package com.audiotome.audiotomeserver.audiobook;

public enum Status {
    DRAFT("DRAFT"), PUBLISHED("PUBLISHED");

    private final String value;

<<<<<<< HEAD
    Status(String value){this.value = value;}
=======
    Status(String value) {
        this.value = value;
    }
>>>>>>> 17faaac ( new server hosting)

    @Override
    public String toString() {
        return value;
    }
}
