package com.nowcoder;

import com.nowcoder.service.LikeService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 杨文鑫 on 2017/12/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ToutiaoApplication.class)
public class LikeServiceTests {
    @Autowired
    LikeService likeService;

    @Test
    public void testLike() {
        likeService.like(123, 1, 1);
        Assert.assertEquals(1, likeService.getLikeStatus(123, 1, 1));

        likeService.disLike(123, 1, 1);
        Assert.assertEquals(-1, likeService.getLikeStatus(123, 1, 1));
    }

    @Test
    public void testLikeB() {
        System.out.println("testLikeB");
    }

    @Before
    public void setUp() {
        System.out.println("setUp");
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }
}
