package com.example.sangeeth.assignment.data;

/**
 * Created by sangeeth on 25/1/17.
 */

public class AddressUser {


    public int getHttp_code() {
        return http_code;
    }

    public void setHttp_code(int http_code) {
        this.http_code = http_code;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    private int http_code;
        private Message message;

}
