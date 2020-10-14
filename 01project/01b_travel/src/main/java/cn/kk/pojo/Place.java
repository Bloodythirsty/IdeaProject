package cn.kk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Place {
    private Integer id ;
    private String name ;
    private String picpath ;

    // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hottime  ;
    // private LocalDate hottime  ;
    private Float hotticket ;
    private Float dimticket ;
    private String placedes ;

    private Integer p_province;
}
