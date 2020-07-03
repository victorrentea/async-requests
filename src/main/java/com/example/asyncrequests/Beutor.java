package com.example.asyncrequests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@RestController
public class Beutor {
   private static final Logger log = LoggerFactory.getLogger(Beutor.class);

//   static ExecutorService barmani = Executors.newFixedThreadPool(2);

   private final Barman barman;

   public Beutor(Barman barman) {
      this.barman = barman;
   }

   @GetMapping
   public String bea() throws ExecutionException, InterruptedException {
      log.info("Vin la bar");


      CompletableFuture<Bere> futureBere = CompletableFuture.supplyAsync(barman::toarnaBere);
      CompletableFuture<Vodka> futureVodka = CompletableFuture.supplyAsync(barman::toarnaVodka);


//      CompletableFuture.allOf(futureBere, futureVodka).thenRun(() -> System.out.println("Sunt gata bauturile"));

      log.info("A plecat fata cu comanda");






      Bere bere = futureBere.get();
      // pana aici main doarme 1 sec <--- problema
      Vodka vodka = futureVodka.get(); // lina asta o executa instantaneu, pentru ca deja e gata vodka, ca dureaza tot 1 sec sa o toarne

      DillyDilly dilly = new DillyDilly(bere, vodka);

      log.info("Threadul HTTP requestului este eliberat aici si se intoarce langa fratii lui in pool");
      return "Savurez " +dilly;
   }
}

class DillyDilly {
   private static final Logger log = LoggerFactory.getLogger(DillyDilly.class);
   private final Bere bere;
   private final Vodka vodka;

   DillyDilly(Bere bere, Vodka vodka) throws InterruptedException {
      Thread.sleep(1000);
      log.info("Amestec cocktail");
      this.bere = bere;
      this.vodka = vodka;
   }
}