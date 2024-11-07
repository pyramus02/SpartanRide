package SpartanRide.SpartanRide_db;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private Rider author;


    private String reviewText;


    Review(String review) {
        this.reviewText = review;
    }

    public int getId() {
        return this.id;
    }

    public String getReview() {
        return this.reviewText;
    }

    public void setReview(String newReview) {
        this.reviewText = newReview;
    }

    public Rider getAuthor() {
        return this.author;
    }

    public void setAuthor(Rider reviewer) {
        this.author = reviewer;
    }



}
