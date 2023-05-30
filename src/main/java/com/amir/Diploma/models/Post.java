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

    private int totalRating;
    private int ratingCount;

    public double getAverageRating() {
        if (ratingCount == 0) {
            return 0;
        }
        return (double) totalRating / ratingCount;
    }

    public void addRating(int rating) {
        totalRating += rating;
        ratingCount++;
    }


    @Column(name = "post_date")
    private Timestamp postDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private User author;


    public Post(long l, String no_title, String no_content, Timestamp timestamp, Object o, User user) {
    }
}
