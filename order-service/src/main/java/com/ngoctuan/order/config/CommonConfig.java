package com.ngoctuan.order.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ngoctuan.data.entity.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.kafka.dsl.Kafka;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.messaging.MessageChannel;

import java.time.LocalDateTime;

@Configuration
public class CommonConfig {

    @Bean
    public Gson gson() {
        return new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter()).create();
    }

    @Bean
    public MessageChannel messageChannel() {
        DirectChannel directChannel = new DirectChannel();
        directChannel.setDatatypes(Order.class);
        return directChannel;
    }

    @Bean
    public IntegrationFlow sendToCapturePaymentTopicFlow(
            ProducerFactory<?, ?> producerFactory,
            MessageChannel messageChannel
    ) {
        return IntegrationFlow.from(messageChannel)
                .handle(Kafka.outboundChannelAdapter(producerFactory)
                        .topic("order"))
                .get();
    }

}