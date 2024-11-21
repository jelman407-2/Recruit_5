package recruit.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import recruit.HrApplication;
import recruit.domain.HrStarted;

@Entity
@Table(name = "Hr_table")
@Data
//<<< DDD / Aggregate Root
public class Hr {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String jobId;

    private String name;

    private String empId;

    private String contents;

    private String state;

    @PostPersist
    public void onPostPersist() {
        HrStarted hrStarted = new HrStarted(this);
        hrStarted.publishAfterCommit();
    }

    public static HrRepository repository() {
        HrRepository hrRepository = HrApplication.applicationContext.getBean(
            HrRepository.class
        );
        return hrRepository;
    }

    //<<< Clean Arch / Port Method
    public static void hrStart(RecruitRegistered recruitRegistered) {
        //implement business logic here:

        System.out.println(
            "\n\n##### listener hrStart recruitRegistered : " + recruitRegistered + "\n\n"
        );

        /** Example 1:  new item  */
        Hr hr = new Hr();

        hr.setEmpId(String.valueOf(recruitRegistered.getId()));
        hr.setEmail(recruitRegistered.getEmail());
        hr.setName(recruitRegistered.getName());
        hr.setState(recruitRegistered.getState());
        hr.setContents(recruitRegistered.getContents());

        repository().save(hr);

        /** Example 2:  finding and process
        
        repository().findById(recruitRegistered.get???()).ifPresent(hr->{
            
            hr // do something
            repository().save(hr);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void hrStateUpdate(Passed passed) {
        //implement business logic here:

        /** Example 1:  new item 
        Hr hr = new Hr();
        repository().save(hr);

        */

        /** Example 2:  finding and process
        
        repository().findById(passed.get???()).ifPresent(hr->{
            
            hr // do something
            repository().save(hr);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void hrStateUpdate(Failed failed) {
        //implement business logic here:

        /** Example 1:  new item 
        Hr hr = new Hr();
        repository().save(hr);

        */

        /** Example 2:  finding and process
        
        repository().findById(failed.get???()).ifPresent(hr->{
            
            hr // do something
            repository().save(hr);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void hrStateUpdate(RecruitCancelled recruitCancelled) {
        //implement business logic here:

        System.out.println(
            "\n\n##### listener hrStateUpdate recruitCancelled : " + recruitCancelled + "\n\n"
        );

        repository().findById(Long.valueOf(recruitCancelled.getId())).ifPresent(hr->{
            
            //hr.setStock(hr.getStock() + hr.getQty()); 
            hr.setState("CANCEL");
            repository().save(hr);


         });

        /** Example 1:  new item 
        Hr hr = new Hr();
        repository().save(hr);

        */

        /** Example 2:  finding and process
        
        repository().findById(recruitCancelled.get???()).ifPresent(hr->{
            
            hr // do something
            repository().save(hr);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
