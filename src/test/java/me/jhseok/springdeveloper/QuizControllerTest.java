package me.jhseok.springdeveloper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class QuizControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("GET /quiz?code=1 => 응답 코드는 201, 응답 본문은 Created!를 리턴")
    @Test
    public void getQuiz() throws Exception {
        // 준비
        final String url = "/quiz";

        // 실행
        final ResultActions result = mockMvc.perform(
                get(url).param("code", "1")
        );

        // 검증
        result.andExpect(status().isCreated())
                .andExpect(content().string("Created!"));
    }

    @DisplayName("POST /quiz 요청, 요청 바디에 {'value':2}이면 응답 코드는 200, 응답 본문은 OK!")
    @Test
    public void postQuiz() throws Exception {
        final String url = "/quiz";

        final ResultActions result = mockMvc.perform(
                post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"value\":2}")
        );

        result.andExpect(status().isOk())
                .andExpect(content().string("OK!"));
    }

}