package com.audiotome.audiotomeserver.constant;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DateTime {

    private int daily;
    private int weekly;
    private int monthly;
    private int yearly;
    private int totally;

}
