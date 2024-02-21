package com.example.demo;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.confige.AppConstance;
import com.example.demo.entites.Roles;
import com.example.demo.repository.RoleRepo;

@SpringBootApplication
public class BlogAppApiApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApiApplication.class, args);
	}

	@Bean
	ModelMapper modelMaper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.passwordEncoder.encode("admin@123"));

		try {

			Roles role1 = new Roles();
			role1.setId(AppConstance.Admin_User);
			role1.setName("ROLE_ADMIN");

			Roles role2 = new Roles();
			role2.setId(AppConstance.Normal_User);
			role2.setName("ROLE_NORMAL");

			List<Roles> role = List.of(role1, role2);

			List<Roles> saveAll = this.roleRepo.saveAll(role);

			saveAll.forEach(e -> {
				System.out.println(e.getName());
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
