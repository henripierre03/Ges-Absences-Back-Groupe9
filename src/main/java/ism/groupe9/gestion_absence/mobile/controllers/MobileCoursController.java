package ism.groupe9.gestion_absence.mobile.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ism.groupe9.gestion_absence.mobile.dto.request.CourCreateRequest;

@RequestMapping("api/mobile/cours")
public interface MobileCoursController {

  @PostMapping("")
  public ResponseEntity<Map<String, Object>> create(@RequestBody CourCreateRequest request);
}
