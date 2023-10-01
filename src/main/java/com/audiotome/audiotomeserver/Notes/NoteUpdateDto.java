package com.audiotome.audiotomeserver.Notes;

import lombok.Data;

@Data
public class NoteUpdateDto extends NotesCreateDto {
    private Long n_id;
}
