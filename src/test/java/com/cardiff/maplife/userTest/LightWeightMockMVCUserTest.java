package com.cardiff.maplife.userTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

//@WebMvcTest(UserController.class)
public class LightWeightMockMVCUserTest {
    @Autowired
    private MockMvc mockMvc;


    // Unit tests using a mock MVC without Spring Security
    //Testing the login page
    @Test
    public void getLoginPage() throws Exception {
        this.mockMvc.perform(get("/authform?button=login-button")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Login")));
    }
    //Testing the signUp page
    @Test
    public void getSignUpPage() throws Exception {
        this.mockMvc.perform(get("/authform?button=signup-button")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Sign Up")));
    }


    //Component test using a mock MVC but a test database with spring Security
    //Testing the profile page
    @Test
    public void getProfilePage() throws Exception {

         this.mockMvc.perform(get("/profile/shuwen")
                    .with(user("shuwen").password("123123123").roles("USER")))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(content().string(containsString("shuwen")));
    }

    //Testing the settings page
    @Test
    public void getSettingPage() throws Exception {

        this.mockMvc.perform(get("/settings")
                        .with(user("shuwen").password("123123123").roles("USER")))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Settings")));
    }

    //Testing the subscriptions page
    @Test
    public void getSubscriptionsPage() throws Exception {

        this.mockMvc.perform(get("/subscriptions")
                        .with(user("shuwen").password("123123123").roles("USER")))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("All following")));
    }




}
