package com.he;

import com.he.domin.dto.AddCommentReplyDto;
import com.he.domin.entity.mysql.CommentReply;
import com.he.service.ICommentReplyService;
import com.he.service.ICommentService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentReplyTest {
    @Resource
    private ICommentReplyService commentReplyService;

    @Test
    public void test1(){
        for (int i= 2 ;i<10;i++){
            AddCommentReplyDto commentReply = new AddCommentReplyDto();
            commentReply.setCommentId(i);
            commentReply.setUserId(2);
            commentReply.setReplyUserId(1);
            commentReply.setContent("确实！");
            commentReplyService.addComment(commentReply);
        }
    }
}
