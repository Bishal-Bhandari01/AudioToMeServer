package com.audiotome.audiotomeserver.Notes;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "notes")
@Data
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long n_id;
    public String title;
    @Column(length = 665555)
    public String noteDesc;
    public Long userId;
    public String noteDate;
}
