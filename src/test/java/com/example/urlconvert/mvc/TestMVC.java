package com.example.urlconvert.mvc;

import com.example.urlconvert.services.ConvertUrlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@WebMvcTest(TestMVC.class)
@ComponentScan(basePackages = "com.example")
public class TestMVC {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConvertUrlService convertUrlService;

    /**
     * Testing the operation of the main logic of the MVC layer application - converting a long link into a short one
     */
    @Test
    void convertUrl() throws Exception {
        Mockito.when(convertUrlService.getConvertUrl("netology.ru"))
                .thenReturn("-1454289302");

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post(
                "/api/url/get-convert-url/netology.ru");

        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.is("-1454289302")))
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * Testing getting a long link
     */
    @Test
    void longUrl() throws Exception {
        Mockito.when(convertUrlService.getLongUrl("-1454289302")).thenReturn("netology.ru");

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get(
                "/api/url/get-long-url/-1454289302");

        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.is("netology.ru")))
                .andDo(MockMvcResultHandlers.print());
    }
}
