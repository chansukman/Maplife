package com.cardiff.maplife.mapTest;

import com.cardiff.maplife.controllers.MainController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MainController.class)
public class LightWeightMapTest {
    @Autowired
    private MockMvc mockMvc;

    // Simple Unit tests using a mockMVC - no change here from container testing as no access to database
    @Test
    public void isMapPageHasClearAll() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Clear All")));
    }
}
