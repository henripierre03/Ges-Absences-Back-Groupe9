package ism.groupe9.gestion_absence.web.dto.response.mobile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class RestResponse {

  public static Map<String, Object> response(HttpStatus status, Object result, Object type) {
    Map<String, Object> response = new HashMap<String, Object>();

    response.put("status", status.value());
    response.put("result", result);
    response.put("type", type);

    return response;
  }

  public static Map<String, Object> responsePaginate(HttpStatus status, Object result, String type, Object pages,
      Object curentPage,
      Object totalPage, Object totalItems, Boolean first, Boolean last) {
    Map<String, Object> response = new HashMap<String, Object>();

    response.put("status", status.value());
    response.put("result", result);
    response.put("type", type);
    response.put("pages", pages);
    response.put("curentPage", curentPage);
    response.put("totalPage", totalPage);
    response.put("totalItems", totalItems);
    response.put("first", first);
    response.put("last", last);

    return response;
  }

  public static Map<String, String> responseError(BindingResult bindingResult) {

    Map<String, String> errors = new HashMap<>();
    List<FieldError> fields = bindingResult.getFieldErrors();
    fields.forEach(field -> errors.put(field.getField(), field.getDefaultMessage()));
    return errors;
  }
}
