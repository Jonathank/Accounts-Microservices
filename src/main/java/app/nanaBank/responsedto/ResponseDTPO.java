package app.nanaBank.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTPO {

    private String statusCode;
    private String statusMessage;
}
