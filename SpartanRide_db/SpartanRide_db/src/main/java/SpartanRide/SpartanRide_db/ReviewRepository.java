package SpartanRide.SpartanRide_db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query(value = "SELECT * FROM review WHERE subject_id = ?1", nativeQuery = true)
    List<Review> getReviewsbySub(int subjectId);

    @Query(value = "SELECT * FROM review WHERE author_id = ?1", nativeQuery = true)
    List<Review> getReviewsbyAuth(int authorId);
}