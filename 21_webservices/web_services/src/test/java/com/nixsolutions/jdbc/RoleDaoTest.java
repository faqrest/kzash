package com.nixsolutions.jdbc;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.nixsolutions.entity.Role;
import com.nixsolutions.dao.DAOApi.RoleDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("spring_test.xml")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("data-before-role.xml")
public class RoleDaoTest {
	
	@Autowired
	private RoleDAO dao;
	
	@Test
	@ExpectedDatabase("data-create.xml")
	public void testShouldSaveBook() throws Exception {	
		dao.save(new Role(1, "User"));
	}

	@Test
	public void testShouldGetAllData() throws Exception {
		
		List<Role> roles = dao.getAll();
		Assert.assertEquals(3, roles.size());
	}
	
	@Test
	public void testShouldGetRecordByID() throws Exception {
		Role roleById = dao.getById(1);

		Assert.assertEquals(roleById.getName(), "user");
	}

	
	@Test
	@ExpectedDatabase("data-delete.xml")
	public void testShouldDeleteDataByID() throws Exception {
		Role role = new Role(5, "User");
		dao.save(role);
		dao.delete(5);
	}

	@Test
	@ExpectedDatabase("data-update.xml")
	public void testShouldUpdateDataByID() throws Exception {
		Role user = new Role(1, "User");
		dao.update(user);
	}
}

