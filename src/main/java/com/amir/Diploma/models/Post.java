package com.amir.Diploma.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;



    private String description;

    @Column(name = "post_date")
    private Timestamp postDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private User author;


    public Post(long l, String no_title, String no_content, Timestamp timestamp, Object o, User user) {
    }
}
