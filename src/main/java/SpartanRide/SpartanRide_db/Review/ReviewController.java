package SpartanRide.SpartanRide_db.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired ReviewService reviewService;

    @Autowired ReviewRepository reviewRepository;


    /**
     *
     * {"reviewText": An interesting review}
     */
    @GetMapping("/new")
    public String newReview(Review review) {
        reviewService.addReview(review);
        return "redirect:rider/riderHome/" + review.getAuthorId();
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

    @GetMapping("/report/{driverId}/{reviewId}")
    public RedirectView report(@PathVariable Integer driverId, @PathVariable Integer reviewId) {


        Review thisReview = reviewService.getReviewById(reviewId);
        thisReview.setReported(true);

        reviewRepository.save(thisReview);






        return new RedirectView("/driver/driverProfile/" + driverId);


    }

}
