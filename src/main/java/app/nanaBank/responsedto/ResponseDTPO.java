package app.nanaBank.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTPO {

    private String statusCode;
    private String statusMessage;
   // private Object data;
}
