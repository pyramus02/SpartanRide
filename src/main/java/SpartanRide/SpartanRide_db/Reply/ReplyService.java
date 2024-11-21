package SpartanRide.SpartanRide_db.Reply;


import SpartanRide.SpartanRide_db.Review.Review;
import SpartanRide.SpartanRide_db.Review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    public Reply addReply(Reply newRep) {

        replyRepository.save(newRep);
        return newRep;
    }


    public List<Reply> getAllReplies() {
        return replyRepository.findAll();
    }


    public List<Reply> getRepliesByAuth(int searchId) {
        return replyRepository.getRepliesByAuth(searchId);
    }


    public List<Reply> getRepliesBySub(int searchId) {
        return replyRepository.getRepliesBySub(searchId);
    }

    public void deleteReplyById(int reviewId) {
        replyRepository.deleteById(reviewId);
    }




}
