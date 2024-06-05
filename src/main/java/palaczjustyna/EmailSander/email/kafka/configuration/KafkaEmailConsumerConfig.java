package palaczjustyna.EmailSander.email.kafka.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import palaczjustyna.EmailSander.email.domain.Email;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaEmailConsumerConfig {

    @Value(value = "${kafka.server}")
    private String bootstrapServer;

    @Value(value = "${kafka.groupId}")
    private String groupId;

    @Bean
    public DefaultKafkaConsumerFactory consumerFactory() {
        JsonDeserializer<Email> deserializer = new JsonDeserializer<>(Email.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);

        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return new DefaultKafkaConsumerFactory<>(props, new LongDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Email> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Email> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
