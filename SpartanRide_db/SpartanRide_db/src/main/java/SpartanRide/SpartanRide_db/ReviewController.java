package SpartanRide.SpartanRide_db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired ReviewService reviewService;

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
    public List<Review> getReviewsbyDriver(@PathVariable int driverId) {
        return reviewService.getReviewsbySub(driverId);
    }

    @GetMapping("/rider/{riderId}")
    public List<Review> getReviewsbyRider(@PathVariable int riderId) {
        return reviewService.getReviewsbyAuth(riderId);
    }

    @DeleteMapping("/delete/{reviewId}")
    public List<Review> deleteAnimalById(@PathVariable int reviewId) {

        reviewService.deleteReviewById(reviewId);
        return reviewService.getAllReviews();
    }














}
