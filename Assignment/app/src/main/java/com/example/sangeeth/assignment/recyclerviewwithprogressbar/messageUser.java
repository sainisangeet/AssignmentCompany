package com.example.sangeeth.assignment.recyclerviewwithprogressbar;

/**
 * Created by sangeeth on 14/2/17.
 */

public class messageUser {



        public int getHttp_code() {
            return http_code;
        }

        public void setHttp_code(int http_code) {
            this.http_code = http_code;
        }

        public message getMessage() {
            return message;
        }

        public void setMessage(message message) {
            this.message = message;
        }

        private int http_code;
        private message message;

}
