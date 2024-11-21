package SpartanRide.SpartanRide_db.Reply;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "reply")
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "replyText", nullable = false)
    private String replyText;


    @Column(name = "authorId", nullable = true)
    private int authorId;

    @Column(name = "subjectId", nullable = true)
    private int subjectId;



    public Reply(String replyText, int authorId, int subjectId) {

        this.subjectId = subjectId;
        this.authorId = authorId;
        this.replyText = replyText;
    }

    public Reply() {}

    public int getId() {
        return this.id;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public String getReviewText() {
        return this.replyText;
    }

    public void setReviewText(String newReview) {
        this.replyText = newReview;
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


}