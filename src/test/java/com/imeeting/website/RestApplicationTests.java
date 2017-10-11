package com.imeeting.website;

import com.imeeting.website.domain.User;
import com.imeeting.website.service.implement.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestApplicationTests {

	@Autowired
	private UserServiceImpl userService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getAll(){
		System.out.println(userService.getAll());
	}

	@Test
	public void saveData(){
		User user = new User();
		user.setEmail("matius.prastowo@iconpln.co.id");
		user.setPassword("123456");
		user.setNama("matius apry pratsowo");
		System.out.println(userService.save(user));
		System.out.println(userService.getAll());
	}

}
