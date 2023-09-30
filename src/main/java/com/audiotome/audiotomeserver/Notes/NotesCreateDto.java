package com.audiotome.audiotomeserver.Notes;

import lombok.Data;

@Data
public class NotesCreateDto {
    private Long userId;
    private String title;
    private String noteDesc;
    private String noteDate;
}
