package com.example.maplife.credentials;

import com.twilio.jwt.accesstoken.AccessToken;
import com.twilio.jwt.accesstoken.VideoGrant;

public class twilioKey {

    private static final String account_SID = "AC4f1b3c945710a74853766fd59071a9aa";
    private static final String api_key = "SK77d0e7f064cc1a3c5d8fdd73cf1bf22d";
    private static final String api_secret = "OH4sRv0f2d6UXj32ZY8biCI1QNCSnKdx";
    private static final String token ="32378018f4a80f106e6f4a2727b9066b";
    public twilioKey(){
//        String id ="Jeff";
//        VideoGrant grant = new VideoGrant().setRoom("Jeff room");
//        AccessToken token = new AccessToken.Builder(
//                account_SID,
//                api_key,
//                api_secret
//        ).identity(id).grant(grant).build();

    }
    public String get_SID(){
        return account_SID;
    }
    public String get_token(){
        return token;
    }

}
