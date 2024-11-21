package SpartanRide.SpartanRide_db.Review;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review addReview(Review newRev) {

        reviewRepository.save(newRev);
        return newRev;
    }
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> getReviewsByAuth(int searchId) {
        return reviewRepository.getReviewsByAuth(searchId);
    }


    public List<Review> getReviewsBySub(int searchId) {
        return reviewRepository.getReviewsBySub(searchId);
    }

    public Review getReviewOfSubByAuth(int subId, int authorId) {

        return reviewRepository.getReviewOfSubByAuth(subId, authorId);

    }

    public void deleteReviewById(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }




}
