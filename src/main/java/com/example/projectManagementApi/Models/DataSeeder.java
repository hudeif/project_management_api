package com.example.projectManagementApi.Models;

import com.example.projectManagementApi.Interfaces.IUser;
import com.example.projectManagementApi.Interfaces.IUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private IUser userRepository;

    @Autowired
    private IUserRole userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        seedRoles();
        seedUsers();
    }

    private void seedRoles() {
        // Check if roles already exist
        if (userRoleRepository.count() == 0) {
            UserRole adminRole = new UserRole();
            adminRole.setRoleName("Admin");

            UserRole memberRole = new UserRole();
            memberRole.setRoleName("Member");

            UserRole clientRole = new UserRole();
            clientRole.setRoleName("Client");

            userRoleRepository.saveAll(Arrays.asList(adminRole, memberRole, clientRole));
            System.out.println("Roles seeded successfully!");
        }
    }

    private void seedUsers() {
        // Check if users already exist
        if (userRepository.count() == 0) {
            List<UserRole> roles = userRoleRepository.findAll();
            
            UserRole adminRole = roles.stream().filter(r -> r.getRoleName().equals("Admin")).findFirst().orElse(null);
            UserRole memberRole = roles.stream().filter(r -> r.getRoleName().equals("Member")).findFirst().orElse(null);
            UserRole clientRole = roles.stream().filter(r -> r.getRoleName().equals("Client")).findFirst().orElse(null);

            // Admin user
            User admin = new User();
            admin.setFirstName("Omar");
            admin.setLastName("Nour");
            admin.setEmail("admin@example.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setUserRole(adminRole);
            admin.setType("Admin");
            admin.setStatus("online");

            // Member user
            User member = new User();
            member.setFirstName("Hudeifa");
            member.setLastName("Mahamud");
            member.setEmail("member@example.com");
            member.setPassword(passwordEncoder.encode("member123"));
            member.setUserRole(memberRole);
            member.setType("Member");
            member.setStatus("online");

            // Client user
            User client = new User();
            client.setFirstName("M.Ali");
            client.setLastName("Client");
            client.setEmail("client@example.com");
            client.setPassword(passwordEncoder.encode("client123"));
            client.setUserRole(clientRole);
            client.setType("Client");
            client.setStatus("online");

            userRepository.saveAll(Arrays.asList(admin, member, client));
            System.out.println("Users seeded successfully!");
        }
    }
}
