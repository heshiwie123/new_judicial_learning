package com.he;


import com.he.domin.dto.AddCommentDto;
import com.he.service.ICommentService;
import jakarta.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CommentTest {
    @Resource
    private ICommentService commentService;

    @Test
    public void test1(){
        for( int i=0;i<20;i++){
            AddCommentDto commentDto = new AddCommentDto();
            commentDto.setUserId(1);
            commentDto.setVideoId(1);
            commentDto.setContent("作者666啊，第"+i+"号水军报道！");
            int result = commentService.addComment(commentDto);

        }
    }
//
//    @Test
//    public void test2(){
//        ArrayList<Comment> commentList= commentService.getCommentListByVideoId(1);
//        commentList.forEach(System.out::println);
//    }
//    @Test
//    public void test3(){
//        Integer i = commentService.deleteComment(6);
//        System.out.println(i);
//    }
}
