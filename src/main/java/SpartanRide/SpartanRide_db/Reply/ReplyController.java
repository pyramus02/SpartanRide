package SpartanRide.SpartanRide_db.Reply;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @PostMapping("/new")
    public Reply replyNewReply(@RequestBody Reply reply) {
        replyService.addReply(reply);
        return reply;
    }

    @GetMapping("/all")
    public List<Reply> getAllReplies() {
        return replyService.getAllReplies();
    }

    @GetMapping("/driver/{driverId}")
    public List<Reply> getRepliesByDriver(@PathVariable int driverId) {
        return replyService.getRepliesBySub(driverId);
    }

    @GetMapping("/rider/{riderId}")
    public List<Reply> getRepliesByRider(@PathVariable int riderId) {
        return replyService.getRepliesByAuth(riderId);
    }

    @DeleteMapping("/delete/{replyId}")
    public List<Reply> deleteReplyById(@PathVariable int replyId) {

        replyService.deleteReplyById(replyId);
        return replyService.getAllReplies();
    }

}
