package com.home.thc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@AutoConfigurationPackage
@SpringBootTest
class ThcApplicationTests {

    protected MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    protected void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
}
