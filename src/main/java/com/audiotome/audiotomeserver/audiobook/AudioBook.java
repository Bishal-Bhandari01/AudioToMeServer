package com.audiotome.audiotomeserver.audiobook;
<<<<<<< HEAD
=======

>>>>>>> 17faaac ( new server hosting)
import jakarta.persistence.*;
import lombok.Data;

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

<<<<<<< HEAD
    @Column(length=665555)
=======
    @Column(length = 665555)
>>>>>>> 17faaac ( new server hosting)
    public String aBookImage;

    public String aDescription;
    public String aUploadDate;
    public Status status;
    public int likeCounter;
}
