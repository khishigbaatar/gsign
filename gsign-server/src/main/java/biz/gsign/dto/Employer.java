package biz.gsign.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employer {
    private long id;
    private String empCode;
    private String firstName;
    private String lastName;
}
