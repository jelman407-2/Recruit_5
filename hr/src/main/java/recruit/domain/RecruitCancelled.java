package recruit.domain;

import java.util.*;
import lombok.*;
import recruit.domain.*;
import recruit.infra.AbstractEvent;

@Data
@ToString
public class RecruitCancelled extends AbstractEvent {

    private Long id;
    private String email;
    private String jobId;
    private Date regDate;
    private String contents;
    private String state;
}
