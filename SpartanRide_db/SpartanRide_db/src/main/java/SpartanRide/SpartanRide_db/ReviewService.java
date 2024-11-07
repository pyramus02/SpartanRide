package SpartanRide.SpartanRide_db;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
