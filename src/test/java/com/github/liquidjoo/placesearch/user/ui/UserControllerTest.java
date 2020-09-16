package com.github.liquidjoo.placesearch.user.ui;

import com.github.liquidjoo.placesearch.user.application.UserRequest;
import com.github.liquidjoo.placesearch.user.application.UserResponse;
import com.github.liquidjoo.placesearch.user.application.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@Import(HttpEncodingAutoConfiguration.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("user create api")
    void create() throws Exception {

        given(userService.create(any(UserRequest.class)))
                .willReturn(new UserResponse("tjdwn"));

        final ResultActions resultActions = mockMvc.perform(post("/user/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userId\": \"tjdwn\", \"password\":\"1231\"}")
        );

        resultActions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").isString());

    }
}
