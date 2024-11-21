package recruit.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import recruit.domain.*;
import recruit.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RecruitCancelled extends AbstractEvent {

    private Long id;
    private String email;
    private String jobId;
    private Date regDate;
    private String contents;
    private String state;

    public RecruitCancelled(Recruit aggregate) {
        super(aggregate);
    }

    public RecruitCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
