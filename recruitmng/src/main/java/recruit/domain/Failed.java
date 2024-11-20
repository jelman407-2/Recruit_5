package recruit.domain;

import java.util.*;
import lombok.*;
import recruit.domain.*;
import recruit.infra.AbstractEvent;

@Data
@ToString
public class Failed extends AbstractEvent {

    
    private Long id;
    private String empNo;
    private String name;
    private String deptId;
    private String deptName;
    private String passYn;
    private String state;
}
