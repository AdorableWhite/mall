package com.taizilibai.mall.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Author: zxx
 * @Date: 2021/1/22 11:10
 */
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Junit5单元测试")
public class MockTest {

    @Nested
    class OrderTestClz {
        @Test
        @DisplayName("取消订单")
        void cancleOrder() {
            int status = -1;
            System.out.println("取消订单，订单状态为：" + status);
            Assertions.assertNotNull("");
        }
    }

}
