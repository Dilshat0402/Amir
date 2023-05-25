package com.amir.Diploma.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "doctors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String username;

        private String description;

        private String email;

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

        @Override
        public String toString() {
                return "Ваш врач "+username;
        }
    }


