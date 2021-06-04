package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveJobAdvertDto {


    private String employerName;
    private String jobTitle;
    private int openJobNumber;
    private LocalDate createdDate;
    private LocalDate applicationDeadline;

}
