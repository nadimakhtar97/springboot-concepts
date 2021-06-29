package com.nadim.springsecurityjwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class WebController {

    @Autowired
    private Utils jwtTokenUtils;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @GetMapping("/user")
    public String user() {
        return " <h1> Hello User </h1> ";
    }


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public AuthenticationResponse createAuthenticationResponse(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("incorrect username or password ", e);
        }

        final UserDetails userDetails = myUserDetailsService
                .loadUserByUsername(authenticationRequest.getUserName());

        final String jwt = jwtTokenUtils.generateToken(userDetails);

        return new AuthenticationResponse(jwt);

    }

}
