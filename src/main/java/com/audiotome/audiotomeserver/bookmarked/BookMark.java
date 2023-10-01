package com.audiotome.audiotomeserver.bookmarked;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bookmark")
@Data
public class BookMark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long b_id;
    public int userId;
    public int audioBookId;
}
