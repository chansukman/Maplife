package com.example.maplife.controller;


import com.example.maplife.credentials.twilioKey;
import com.twilio.Twilio;
import com.twilio.rest.video.v1.Room;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class twilio {

    @RequestMapping (path="/test")
    public void test(){
        twilioKey Key= new twilioKey();
        Twilio.init(Key.get_SID(), Key.get_token());
//        Room rm = Room.fetcher("Jeff").fetch();
//        Room del = Room.updater(rm.getSid(), Room.RoomStatus.COMPLETED).update();
        Room room = Room.creator()
                .setStatusCallback(URI.create("http://example.org"))
                .setType(Room.RoomType.PEER_TO_PEER)
                .setUniqueName("Jeff")
                .create();

        System.out.println(room.getUrl());
    }
}
