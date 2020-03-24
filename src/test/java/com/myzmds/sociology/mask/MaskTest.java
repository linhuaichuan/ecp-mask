package com.myzmds.sociology.mask;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.myzmds.sociology.mask.common.FlagConfig;
import com.myzmds.sociology.mask.entity.Dot;
import com.myzmds.sociology.mask.service.ConfigService;
import com.myzmds.sociology.mask.service.PeopleRegService;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
@ContextConfiguration(locations = {"classpath*:/spring/applicationContext-common.xml"})
public class MaskTest {
    
    @Autowired
    ConfigService configService;
    
    @Autowired
    PeopleRegService peopleRegService;
    
    public void getDots() {
        List<Dot> dots = configService.getDots();
        for (Dot dot : dots) {
            System.out.println(dot.toString());
        }
    }
    @Test
    public void getHistory() {
        System.out.println(FlagConfig.dots.size());
        System.out.println(FlagConfig.blacklist.size());
        System.out.println("----------------");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----------------");
        System.out.println(FlagConfig.dots.size());
    }
}
