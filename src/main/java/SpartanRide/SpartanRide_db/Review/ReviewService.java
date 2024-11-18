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


    public List<Review> getReviewsbyAuth(int searchId) {
        return reviewRepository.getReviewsbyAuth(searchId);
    }


    public List<Review> getReviewsbySub(int searchId) {
        return reviewRepository.getReviewsbySub(searchId);
    }

    public void deleteReviewById(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }




}
