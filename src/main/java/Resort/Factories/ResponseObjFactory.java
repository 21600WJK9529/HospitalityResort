package Resort.Factories;

import Resort.Domain.ResponseObj;

public class ResponseObjFactory {
    public static ResponseObj buildGenericResponseObj(String responseCode, String responseDescription) {
        return new ResponseObj(responseCode, responseDescription);
    }
}
