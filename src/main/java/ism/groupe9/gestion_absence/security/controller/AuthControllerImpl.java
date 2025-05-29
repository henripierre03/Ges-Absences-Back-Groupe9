package ism.groupe9.gestion_absence.security.controller;


import ism.groupe9.gestion_absence.data.entities.User;
import ism.groupe9.gestion_absence.mobile.dto.request.LoginRequest;
import ism.groupe9.gestion_absence.mobile.dto.response.LoginResponse;
import ism.groupe9.gestion_absence.security.entity.UserAuth;
import ism.groupe9.gestion_absence.security.services.JwtTokenUtil;
import ism.groupe9.gestion_absence.security.services.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserAuthService userAuthService;

    @Override
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(),
                loginRequest.getPassword()
            )
        );

        UserAuth userAuth = (UserAuth) authentication.getPrincipal();
        String token = jwtTokenUtil.generateToken(userAuth);
        User user = userAuth.getUser();

        return ResponseEntity.ok(new LoginResponse(
            token,
            user.getEmail(),
            user.getRole(),
            "Bearer"
        ));
    }
}
