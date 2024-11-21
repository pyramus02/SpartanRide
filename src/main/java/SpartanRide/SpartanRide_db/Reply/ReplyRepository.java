package SpartanRide.SpartanRide_db.Reply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    @Query(value = "SELECT * FROM reply WHERE subject_id = ?1", nativeQuery = true)
    List<Reply> getRepliesBySub(int subjectId);

    @Query(value = "SELECT * FROM reply WHERE author_id = ?1", nativeQuery = true)
    List<Reply> getRepliesByAuth(int authorId);
}