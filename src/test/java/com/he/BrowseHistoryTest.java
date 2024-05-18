package com.he;

import com.he.service.IBrowseHistoryService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BrowseHistoryTest {

    @Resource
    private IBrowseHistoryService browseHistoryService;


    @Test
    public void test1(){
        System.out.println(browseHistoryService.getBrowseHistoryByUserIdAndVideoId(1,1));
    }
}
