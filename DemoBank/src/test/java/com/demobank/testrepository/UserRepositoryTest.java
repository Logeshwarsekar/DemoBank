package com.demobank.testrepository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.main.DemoBankApplication;
import com.main.model.User;
import com.main.repository.UserRepositoryIntf;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoBankApplication.class)
public class UserRepositoryTest {

	
	TestEntityManager entityManager;
	
	
	UserRepositoryIntf userRepo;
	
	@Test
    public void it_should_save_user() {
		User user = new User();
        user.setFname("test user");

        user = entityManager.persistAndFlush(user);

        assertThat(userRepo.findById(user.getId()).get()).isEqualTo(user);
    }
}