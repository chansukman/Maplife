package com.cardiff.maplife.mapTest;

import com.cardiff.maplife.controllers.MainController;
import com.cardiff.maplife.entities.Event;
import com.cardiff.maplife.services.EventService;
import com.cardiff.maplife.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
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
    @MockBean
    private UserService userService;
    @MockBean
    private EventService eventService;

    // Simple Unit tests using a mockMVC - no change here from container testing as no access to database
    @Test
    public void isMapPageHasClearAll() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Clear All")));
    }
    //  Component test using a mockMVC but mocking the repository response (Note the @MockBean)
    //  This only tests the controller and the view layers
    @Test
    public void isEventOnMapTest() throws Exception {
        Date eventDate = new Date();
        Timestamp datetime = new Timestamp(System.currentTimeMillis());
        Event event = new Event(1L,1L,"test event",0,0,false,eventDate,"test event dis",true);
        // This will return what the service would have returned - a list of events called method in the repo
        given(this.eventService.findCustom(datetime)).willReturn(List.of(event));
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("test event")));
    }


}
