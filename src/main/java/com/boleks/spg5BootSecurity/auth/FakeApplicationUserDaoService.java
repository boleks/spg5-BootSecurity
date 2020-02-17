package com.boleks.spg5BootSecurity.auth;

import com.boleks.spg5BootSecurity.security.ApplicationUserRole;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.boleks.spg5BootSecurity.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
          new ApplicationUser(
                  "boleks",
                  passwordEncoder.encode("boleks"),
                  ADMIN.getGrantedAuthorities(),
                  true,
                  true,
                  true,
                  true
                  ),
            new ApplicationUser(
                "zora",
                passwordEncoder.encode("zora"),
                ADMINTRAINEE.getGrantedAuthorities(),
                true,
                true,
                true,
                true
                ),
                new ApplicationUser(
                "student",
                passwordEncoder.encode("student"),
                STUDENT.getGrantedAuthorities(),
                true,
                true,
                true,
                true
                ));
        return applicationUsers;
    }
}
