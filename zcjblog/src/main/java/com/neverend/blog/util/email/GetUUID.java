package com.neverend.blog.util.email;

import java.util.UUID;

public class GetUUID {
    public static String uuid(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }
}
