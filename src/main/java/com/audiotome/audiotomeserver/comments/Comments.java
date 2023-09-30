package com.audiotome.audiotomeserver.comments;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "comments")
@Data
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long c_id;

    public String commentContent;

    public int userId;
    public int a_id;

    public int c_likes;
}
