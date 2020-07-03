package com.example.asyncrequests;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

// emulam un serviciu [web] extern, care dureaza timp
@Service
public class Barman {
   private static final Logger log = LoggerFactory.getLogger(Barman.class);
   @Async
   @SneakyThrows
   public CompletableFuture<Bere> toarnaBere() {
      log.info("Torn Bere");
      Thread.sleep(1000);
      log.info("Am turnat Bere");
      return CompletableFuture.completedFuture(new Bere());
   }
   @Async
   @SneakyThrows
   public CompletableFuture<Vodka> toarnaVodka() {
      log.info("Torn Vodka");
      Thread.sleep(1000);
      log.info("Am turnat Vodka");
      return CompletableFuture.completedFuture(new Vodka());
   }
}
