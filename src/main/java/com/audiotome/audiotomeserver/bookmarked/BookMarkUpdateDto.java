package com.audiotome.audiotomeserver.bookmarked;

import lombok.Data;

@Data
public class BookMarkUpdateDto extends BookMarkCreateDto {
    private Long b_id;
}
