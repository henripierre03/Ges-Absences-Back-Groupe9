// package ism.groupe9.security.controller;

// import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Authentication;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.web.bind.annotation.RestController;

// import ism.groupe9.gestion_absence.data.entities.User;
// import ism.groupe9.gestion_absence.mobile.dto.request.LoginRequest;
// import ism.groupe9.gestion_absence.services.EtudiantService;
// import ism.groupe9.security.services.JwtTokenUtil;
// import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor

// @RestController
// public class AuthControllerImpl implements AuthController {

//   private final AuthenticationManager authenticationManager;
//     private final JwtTokenUtil jwtTokenUtil;
//     private final EtudiantService etudiantService;

//   @Override
//   public ResponseEntity<?> login(LoginRequest loginRequest) {

//     Authentication authentication = authenticationManager.authenticate(
//             new UsernamePasswordAuthenticationToken(
//                 loginRequest.getEmail(),
//                 loginRequest.getPassword()
//             )
//         );
    
//         UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//         String token = jwtTokenUtil.generateToken(userDetails);
//         User user = etudiantService.findByEmail(loginRequest.getEmail());

//         return ResponseEntity.ok(new LoginResponse(
//             token,
//             "Bearer",
//             user.getEmail(),
//             user.getRole().name()
//         ));
    
    
//   }
  
// }
