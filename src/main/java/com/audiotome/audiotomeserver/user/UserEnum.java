package com.audiotome.audiotomeserver.user;

public enum UserEnum {
    USER("USER"), ADMIN("ADMIN");

    private final String value;

    UserEnum(String value){this.value = value;}

    @Override
    public String toString() {
        return value;
    }

}
