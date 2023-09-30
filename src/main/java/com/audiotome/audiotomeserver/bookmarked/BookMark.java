package com.audiotome.audiotomeserver.bookmarked;
<<<<<<< HEAD
import com.audiotome.audiotomeserver.user.User;
=======

>>>>>>> 17faaac ( new server hosting)
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bookmark")
@Data
public class BookMark {
    @Id
<<<<<<< HEAD
    @GeneratedValue(strategy= GenerationType.IDENTITY)
=======
    @GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> 17faaac ( new server hosting)
    public Long b_id;
    public int userId;
    public int audioBookId;
}
