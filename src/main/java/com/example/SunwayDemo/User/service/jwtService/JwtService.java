package com.example.SunwayDemo.User.service.jwtService;

import com.example.SunwayDemo.User.dto.StaffDto;
import com.example.SunwayDemo.User.entity.jwtReauest.JwtRequest;
import com.example.SunwayDemo.User.entity.jwtReauest.JwtResponse;
import com.example.SunwayDemo.User.entity.staff.Staff;
import com.example.SunwayDemo.User.repository.staff.StaffRepo;
import com.example.SunwayDemo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private StaffRepo staffRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;


    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(userName, userPassword);

       final UserDetails userDetails = loadUserByUsername(userName);

       String newGeneratedToken = jwtUtil.generateToken(userDetails);
       Staff staff = staffRepo.findByName(userName);

       return new JwtResponse(staff, newGeneratedToken);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Staff staff = staffRepo.findByName(username);

        if(staff != null){
            return new User(staff.getName(), staff.getPassword(),getAuthorities(staff));
        }else {
            throw new UsernameNotFoundException("User name is not valid");
        }
    }


    private Set getAuthorities(Staff staff){
        Set authorities = new HashSet();
        staff.getRolls().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRollName()));
        });

        return authorities;
    }

    private void authenticate (String userName, String userPassword) throws Exception {

        try{
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,userPassword));
        }catch (DisabledException e){
            throw  new Exception("User is disabled");
        }catch (BadCredentialsException e){
            throw new Exception(("Bad Credentials Exceptions"));
        }
    }
}
