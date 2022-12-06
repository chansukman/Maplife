package com.cardiff.maplife.userTest;
import com.cardiff.maplife.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class userUnitTest {
    private static User user;
    @BeforeEach
    void before(){
        user = new User(1l,"shuwen","12345678","chens100@cardiff.ac.uk",false,0,0,"default-icon.png","ROLE_USER","//www.youtube.com/embed/4xZSmquUe28?wmode=transparent",null,null,null,null,null);
    }

    @Test
    void getUserIdTest(){
        assertEquals(1l,user.getUser_id());
    }
    @Test
    void getUserNameTest(){
        assertEquals("shuwen",user.getUsername());
    }
    @Test
    void getUserPasswordTest(){
        assertEquals("12345678",user.getPassword());
    }
    @Test
    void getUserEmailTest(){
        assertEquals("chens100@cardiff.ac.uk",user.getEmail());
    }

    @Test
    void getUserIconTest(){
        assertEquals("default-icon.png",user.getIcon());
    }
    @Test
    void getUserVideoTest(){
        assertEquals("//www.youtube.com/embed/4xZSmquUe28?wmode=transparent",user.getVideo());
    }
}
