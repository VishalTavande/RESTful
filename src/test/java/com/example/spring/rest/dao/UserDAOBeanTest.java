package com.example.spring.rest.dao;

import com.example.spring.rest.model.User;
import com.example.spring.rest.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * UserDAOBean Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Aug 29, 2022</pre>
 */
@RunWith(MockitoJUnitRunner.class)
public class UserDAOBeanTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserDAOBean userDAOBean;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getUsers()
     */
    @Test
    public void testGetUsers() throws Exception {
        when(userRepository.findAll()).thenReturn(Collections.emptyList());
        List<User> users = userDAOBean.getUsers();
        assertNotNull(users);
        assertTrue(users.isEmpty());
    }

    /**
     * Method: getUser(Integer id)
     */
    @Test
    public void testGetUser() throws Exception {

    }

    /**
     * Method: saveUser(User user)
     */
    @Test
    public void testSaveUser() throws Exception {

    }

    /**
     * Method: removeUser(Integer id)
     */
    @Test
    public void testRemoveUser() throws Exception {

    }

    /**
     * Method: updateUser(User user)
     */
    @Test
    public void testUpdateUser() throws Exception {

    }
} 
