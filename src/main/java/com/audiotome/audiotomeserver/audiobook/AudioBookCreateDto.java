package com.audiotome.audiotomeserver.audiobook;

import lombok.Data;

@Data
public class AudioBookCreateDto {

    private String aBookName;
    private String aBookAuthor;
    private String aBookAudio;
    private String aBookImage;
    private String aDescription;
    private String aUploadDate;
    private Status status;
    private int likeCounter;
}
