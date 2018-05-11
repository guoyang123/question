package com.neuedu;

import com.neuedu.dao.UserMapper;
import com.neuedu.entity.Quser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	UserMapper mapper;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testInsert(){
		Quser user = new Quser();
		user.setUsername("张三");

		mapper.save(user);
		System.out.println("插入用户信息"+user.getUsername());
	}
}
