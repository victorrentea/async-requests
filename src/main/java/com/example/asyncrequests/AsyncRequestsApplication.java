package com.example.asyncrequests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class AsyncRequestsApplication {

   public static void main(String[] args) {
      SpringApplication.run(AsyncRequestsApplication.class, args);
   }

}
