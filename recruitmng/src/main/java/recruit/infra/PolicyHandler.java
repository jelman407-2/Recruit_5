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
    RecruitRepository recruitRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='HrStarted'"
    )
    public void wheneverHrStarted_RecruitStateUpdated(
        @Payload HrStarted hrStarted
    ) {
        HrStarted event = hrStarted;
        System.out.println(
            "\n\n##### listener RecruitStateUpdated : " + hrStarted + "\n\n"
        );

        // Sample Logic //
        Recruit.recruitStateUpdated(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Passed'"
    )
    public void wheneverPassed_RecruitStateUpdated(@Payload Passed passed) {
        Passed event = passed;
        System.out.println(
            "\n\n##### listener RecruitStateUpdated : " + passed + "\n\n"
        );

        // Sample Logic //
        Recruit.recruitStateUpdated(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Failed'"
    )
    public void wheneverFailed_RecruitStateUpdated(@Payload Failed failed) {
        Failed event = failed;
        System.out.println(
            "\n\n##### listener RecruitStateUpdated : " + failed + "\n\n"
        );

        // Sample Logic //
        Recruit.recruitStateUpdated(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
