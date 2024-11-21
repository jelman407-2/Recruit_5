package recruit.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import recruit.config.kafka.KafkaProcessor;
import recruit.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    HrRepository hrRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RecruitRegistered'"
    )
    public void wheneverRecruitRegistered_HrStart(
        @Payload RecruitRegistered recruitRegistered
    ) {
        RecruitRegistered event = recruitRegistered;
        System.out.println(
            "\n\n##### listener HrStart : " + recruitRegistered.toString() + "\n\n"
        );

        // Sample Logic //
        Hr.hrStart(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Passed'"
    )
    public void wheneverPassed_HrStateUpdate(@Payload Passed passed) {
        Passed event = passed;
        System.out.println(
            "\n\n##### listener HrStateUpdate : " + passed + "\n\n"
        );

        // Sample Logic //
        Hr.hrStateUpdate(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Failed'"
    )
    public void wheneverFailed_HrStateUpdate(@Payload Failed failed) {
        Failed event = failed;
        System.out.println(
            "\n\n##### listener HrStateUpdate : " + failed + "\n\n"
        );

        // Sample Logic //
        Hr.hrStateUpdate(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RecruitCancelled'"
    )
    public void wheneverRecruitCancelled_HrStateUpdate(
        @Payload RecruitCancelled recruitCancelled
    ) {
        RecruitCancelled event = recruitCancelled;
        System.out.println(
            "\n\n##### listener HrStateUpdate : " + recruitCancelled + "\n\n"
        );

        // Sample Logic //
        Hr.hrStateUpdate(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
