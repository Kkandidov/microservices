package org.astashonok.security.rest;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.astashonok.security.model.AuthForm;
import org.astashonok.security.model.User;
import org.astashonok.security.security.JwtTokenProvider;
import org.astashonok.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationRestControllerV1 {

  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private UserService userService;
  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @PostMapping("/login")
  private ResponseEntity<?> authenticate(@RequestBody AuthForm requestDTO) {
    try {
      String email = requestDTO.getEmail();
      String password = requestDTO.getPassword();
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
      User user = userService.findByEmail(email).orElseThrow(
          () -> new UsernameNotFoundException("User doesn't exist"));
      String token = jwtTokenProvider.createToken(email, user.getRole().name());
      Map<Object, Object> response = new HashMap<>();
      response.put("email", email);
      response.put("token", token);

      return ResponseEntity.ok(response);
    } catch (AuthenticationException e) {
      return new ResponseEntity<>("Invalid email/password combination", HttpStatus.FORBIDDEN);
    }
  }

  @PostMapping("/logout")
  private void logout(HttpServletRequest request, HttpServletResponse response) {
    SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
    securityContextLogoutHandler.logout(request, response, null);
  }
}
