package com.audiotome.audiotomeserver.bookmarked;

import lombok.Data;

@Data
public class BookMarkCreateDto {
    private int userId;
    private int audioBookId;
}
