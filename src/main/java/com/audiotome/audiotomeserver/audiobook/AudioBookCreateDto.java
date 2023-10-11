package com.audiotome.audiotomeserver.audiobook;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AudioBookCreateDto {

    private String aBookName;
    private String aBookAuthor;
    private String aBookAudio;
    private String aBookImage;
    private String aDescription;
    private LocalDate aUploadDate;
    private Status status;
    private int listen;
}
