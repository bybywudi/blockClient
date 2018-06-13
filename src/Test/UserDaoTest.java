package Test;

import Dao.UserDaoImpl;
import Domain.User;
import org.junit.Test;

import java.util.Date;

public class UserDaoTest {
	
	@Test
	public void tesAdd() {
		User user = new User();
		user.setBirthday(new Date());
		user.setEmail("baibai@163.com");
		user.setId("233333");
		user.setNikename("��ɵ��");
		user.setPassword("123");
		user.setUsername("aaa");
		
		UserDaoImpl dao = new UserDaoImpl();
		dao.add(user);
	}
	
	@Test
	public void testFind() {
		UserDaoImpl dao = new UserDaoImpl();
		System.out.println(dao.find("aaaa"));
	}
	
	@Test
	public void testFindByUsername() {
		UserDaoImpl dao = new UserDaoImpl();
		System.out.println(dao.find("aaa"));
	}

	@Test
	public void testFindResIndex() {
		UserDaoImpl dao = new UserDaoImpl();
		System.out.println(dao.findResIndex("1"));
	}

	@Test
	public void testGetUserIp() {
		UserDaoImpl dao = new UserDaoImpl();
		System.out.println(dao.getUserIp());
	}

    @Test
    public void testAddNewTestBolck() {
        UserDaoImpl.addNewTestBolck("33333","22222","1","12");
    }
}
