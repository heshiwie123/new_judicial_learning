package com.he;

import com.he.domin.dto.UpdateDanmuDto;
import com.he.domin.entity.mysql.Danmu;
import com.he.service.IDanmuService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootTest
public class DanmuTest {
    @Resource
    private IDanmuService danmuService;

    @Test
    public void test1(){
        Danmu danmu = new Danmu();
        danmu.setVideoId(1)
                .setColor("红")
                .setContent("太牛逼啦!!!!芜湖")
                .setIsHot(0)
                .setIsDeleted(0)
                .setPictureUrl("url111")
                .setPublishTime(LocalDateTime.now())
                .setSumLike(51)
                .setTimeStamp(20)
                .setUserId(2);
        int result = danmuService.addDanmuByUserIdAndVideoId(danmu);
        System.out.println(result
        );
    }

    @Test
    public void test2(){
        UpdateDanmuDto updateDanmuDto = new UpdateDanmuDto();
        updateDanmuDto.setDanmuId(4);
        updateDanmuDto.setColor("黑");
        //设置删除弹幕
        updateDanmuDto.setIsDeleted(1);
        updateDanmuDto.setSumLike(87);

        int result = danmuService.updateDanmuInfo(updateDanmuDto);

        System.out.println(result);
    }

    @Test
    public void test3(){
        ArrayList<Danmu> danmuList = danmuService.getDanmuListByVideoId(1);
        danmuList.forEach(System.out::println);
    }
}
