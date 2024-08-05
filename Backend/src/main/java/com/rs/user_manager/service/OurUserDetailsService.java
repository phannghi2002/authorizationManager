package com.rs.user_manager.service;

import com.rs.user_manager.entity.OurUsers;
import com.rs.user_manager.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OurUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepo usersRepo;

    public OurUserDetailsService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        OurUsers user = usersRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        System.out.println("Loaded User: " + user);
        System.out.println("Authorities: " + user.getAuthorities());
        return usersRepo.findByEmail(username).orElseThrow();
    }
}
