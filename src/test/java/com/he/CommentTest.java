package com.he;


import com.he.service.ICommentService;
import jakarta.annotation.Resource;

import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CommentTest {
    @Resource
    private ICommentService commentService;

//    @Test
//    public void test1(){
//        AddCommentDto commentDto = new AddCommentDto();
//        commentDto.setUserId(2);
//        commentDto.setVideoId(1);
//        commentDto.setContent("作者做的视频不错,我也已经点赞了！");
//        int result = commentService.addComment(commentDto);
//        System.out.println(result);
//    }
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
