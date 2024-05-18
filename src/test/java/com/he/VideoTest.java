package com.he;

import com.he.domin.entity.mysql.Video;
import com.he.mapper.VideoMapper;
import com.he.utill.DateFormatUtill;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.ArrayList;


@SpringBootTest
public class VideoTest {
    @Resource
    private VideoMapper videoMapper;

    @Test
    public void test1() throws ParseException {
        Video video = new Video();
        video.setVideoUp("成都案例学校");
        video.setDuration(3600 * 2 + 60 * 30+5*60);
        video.setVideoUrl("http://localhost:1315/videotest/show.mp4");
        video.setPaymentType(Boolean.TRUE);
        video.setBriefIntro("本视频用于测试");
        video.setCoverImgUrl("http://localhost:1315/file/show.jpg");
        video.setPublishTime(DateFormatUtill.myLocalDateParse(2012,5,16));
        video.setTitle("测试视频-合同法");
        video.setSumComment(0);
        video.setSumLike(0);
        video.setSumCollect(0);
        video.setSumDanMu(1);
        video.setSumShare(10);

        Video video1 = new Video();
        video1.setVideoUp("成都案例学校");
        video1.setDuration(3600 * 2 + 60 * 30+5*60);
        video1.setVideoUrl("http://localhost:1315/videotest/show.mp4");
        video1.setPaymentType(Boolean.TRUE);
        video1.setBriefIntro("本视频用于测试");
        video1.setCoverImgUrl("http://localhost:1315/file/show.jpg");
        video1.setPublishTime(DateFormatUtill.myLocalDateParse(2012,5,16));
        video1.setTitle("测试视频-合同法");
        video1.setSumComment(38);
        video1.setSumLike(40);
        video1.setSumCollect(50);
        video1.setSumDanMu(21);
        video1.setSumShare(8);

        Video video2 = new Video();
        video2.setVideoUp("成都案例学校");
        video2.setDuration(3600 * 2 + 60 * 30+5*60);
        video2.setVideoUrl("http://localhost:1315/videotest/show.mp4");
        video2.setPaymentType(Boolean.TRUE);
        video2.setBriefIntro("本视频用于测试");
        video2.setCoverImgUrl("http://localhost:1315/file/show.jpg");
        video2.setPublishTime(DateFormatUtill.myLocalDateParse(2012,5,16));
        video2.setTitle("测试视频-合同法");
        video2.setSumComment(68);
        video2.setSumLike(50);
        video2.setSumCollect(56);
        video2.setSumDanMu(29);
        video2.setSumShare(88);

        videoMapper.insert(video);
        videoMapper.insert(video1);
        videoMapper.insert(video2);
    }

    @Test
    public void test2(){
        ArrayList<Video> videoLis = videoMapper.getVideoListByScreen(4, true, "合同法",3,3);
        videoLis.forEach(System.out::println);
    }
}
