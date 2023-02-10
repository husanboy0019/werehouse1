package uz.com.appwarehouse.dto.file;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductFileDTO {

    private Integer id;

    private boolean active;

    private String name;

    private String originalName;

    private Long size;

    private String mimeType;

}
