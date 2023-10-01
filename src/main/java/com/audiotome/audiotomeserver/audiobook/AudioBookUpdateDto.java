package com.audiotome.audiotomeserver.audiobook;

import lombok.Data;

@Data
public class AudioBookUpdateDto extends AudioBookCreateDto {
    private Long aId;
}
