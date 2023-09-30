package com.audiotome.audiotomeserver.Notes;

import lombok.Data;

import java.util.List;

@Data
public class NotesListResponseDto {
    private List<NoteResponseDto> response;
    private int total;
}
