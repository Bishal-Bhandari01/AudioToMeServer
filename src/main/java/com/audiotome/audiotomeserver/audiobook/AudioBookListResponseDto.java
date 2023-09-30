package com.audiotome.audiotomeserver.audiobook;

import lombok.Data;

import java.util.List;

@Data
public class AudioBookListResponseDto {

    private List<AudioBookResponseDto> response;
    private int total;
}
