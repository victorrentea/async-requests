package com.example.asyncrequests;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

// emulam un serviciu [web] extern, care dureaza timp
@Service
public class Barman {
   private static final Logger log = LoggerFactory.getLogger(Barman.class);
   @SneakyThrows
   public Bere toarnaBere() {
      log.info("Torn Bere");
      Thread.sleep(1000);
      log.info("Am turnat Bere");
      return new Bere();
   }
   @SneakyThrows
   public Vodka toarnaVodka() {
      log.info("Torn Vodka");
      Thread.sleep(1000);
      log.info("Am turnat Vodka");
      return new Vodka();
   }
}
