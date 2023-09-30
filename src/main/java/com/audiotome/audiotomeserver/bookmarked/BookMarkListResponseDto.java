package com.audiotome.audiotomeserver.bookmarked;

import lombok.Data;

import java.util.List;

@Data
public class BookMarkListResponseDto {
    private List<BookMarkResponseDto> responseDtoList;
    private int total;
}
