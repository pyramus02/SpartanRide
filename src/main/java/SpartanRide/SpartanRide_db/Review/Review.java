package SpartanRide.SpartanRide_db.Review;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "review")
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "reviewText", nullable = false)
    private String reviewText;


    @Column(name = "authorId", nullable = false)
    private int authorId;

    @Column(name = "subjectId", nullable = false)
    private int subjectId;



    @Column(name = "reported")
    private Boolean reported;




    public Review(String reviewText, int authorId, int subjectId) {

        this.subjectId = subjectId;
        this.authorId = authorId;
        this.reviewText = reviewText;
    }

    public Review() {}

    public int getId() {
        return this.id;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public String getReviewText() {
        return this.reviewText;
    }

    public void setReviewText(String newReview) {
        this.reviewText = newReview;
    }


    public int getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(int subject) {
        this.subjectId = subject;
    }


    public int getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(int author) {
        this.authorId = author;
    }


    public Boolean getReported() {return this.reported;}

    public void setReported(Boolean report) {this.reported = report;}



}