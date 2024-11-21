package recruit.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import recruit.RecruitmngApplication;
import recruit.domain.RecruitCancelled;
import recruit.domain.RecruitRegistered;

@Entity
@Table(name = "Recruit_table")
@Data
//<<< DDD / Aggregate Root
public class Recruit {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String jobId;

    private Date regDate;

    private String contents;

    private String state;

    @PostPersist
    public void onPostPersist() {
        RecruitRegistered recruitRegistered = new RecruitRegistered(this);
        recruitRegistered.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        RecruitCancelled recruitCancelled = new RecruitCancelled(this);
        recruitCancelled.publishAfterCommit();
    }

    public static RecruitRepository repository() {
        RecruitRepository recruitRepository = RecruitmngApplication.applicationContext.getBean(
            RecruitRepository.class
        );
        return recruitRepository;
    }

    //<<< Clean Arch / Port Method
    public static void recruitStateUpdated(HrStarted hrStarted) {
        //implement business logic here:

        /** Example 1:  new item 
        Recruit recruit = new Recruit();
        repository().save(recruit);

        */

        /** Example 2:  finding and process
        
        repository().findById(hrStarted.get???()).ifPresent(recruit->{
            
            recruit // do something
            repository().save(recruit);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void recruitStateUpdated(Passed passed) {
        //implement business logic here:

        /** Example 1:  new item 
        Recruit recruit = new Recruit();
        repository().save(recruit);

        */

        /** Example 2:  finding and process
        
        repository().findById(passed.get???()).ifPresent(recruit->{
            
            recruit // do something
            repository().save(recruit);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void recruitStateUpdated(Failed failed) {
        //implement business logic here:

        /** Example 1:  new item 
        Recruit recruit = new Recruit();
        repository().save(recruit);

        */

        /** Example 2:  finding and process
        
        repository().findById(failed.get???()).ifPresent(recruit->{
            
            recruit // do something
            repository().save(recruit);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
