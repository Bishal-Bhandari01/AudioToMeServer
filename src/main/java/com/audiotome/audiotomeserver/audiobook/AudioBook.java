package com.audiotome.audiotomeserver.audiobook;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "audiobook")
public class AudioBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long aId;
    public String aBookName;
    public String aBookAuthor;
    public String aBookAudio;
    @Column(length = 665555)
    public String aBookImage;

    public String aDescription;
    public LocalDate aUploadDate;
    public Status status;
    public int listen;
}
