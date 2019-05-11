package com.singleton.tradeproducer.controller;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import stock.Trade;

@RestController
@AllArgsConstructor
public class TradeController {

  private final Producer<Long, Trade> tradeProducer;

  @PostMapping("trades")
  public void produceTrade(@RequestBody final Trade trade) {
    final var record = new ProducerRecord<>(
        "trades",
        trade.getAccount(),
        trade
    );
    tradeProducer.send(record);
  }
}
