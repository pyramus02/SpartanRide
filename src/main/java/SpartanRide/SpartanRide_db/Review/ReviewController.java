package SpartanRide.SpartanRide_db.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired ReviewService reviewService;


    /**
     *
     * {"reviewText": An interesting review}
     */
    @PostMapping("/new")
    public Review newReview( @RequestBody Review review) {
        reviewService.addReview(review);
        return review;
    }

    @GetMapping("/all")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/driver/{driverId}")
    public List<Review> getReviewsByDriver(@PathVariable int driverId) {
        return reviewService.getReviewsBySub(driverId);
    }

    @GetMapping("/rider/{riderId}")
    public List<Review> getReviewsByRider(@PathVariable int riderId) {
        return reviewService.getReviewsByAuth(riderId);
    }

    @DeleteMapping("/delete/{reviewId}")
    public List<Review> deleteReviewById(@PathVariable int reviewId) {

        reviewService.deleteReviewById(reviewId);
        return reviewService.getAllReviews();
    }

}
