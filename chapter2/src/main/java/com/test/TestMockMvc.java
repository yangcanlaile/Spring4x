package com.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(locations = {"classpath*:smart-context.xml","file:C:\\ideaPro\\Spring4x\\chapter2\\src\\main\\webapp\\WEB-INF\\smart-servlet.xml"})
public class TestMockMvc {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    @Test
    public void test() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                .get("/login.html")
                .contentType(MediaType.ALL);
        MvcResult mvcResult = mockMvc.perform(builder).andExpect(status().isOk()).andReturn();
        String httpResponseString = mvcResult.getResponse().getContentAsString();
        System.out.println(httpResponseString);

    }

}
