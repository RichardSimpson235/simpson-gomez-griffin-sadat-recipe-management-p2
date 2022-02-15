package com.revature.services;

import com.revature.models.Recipe;
import com.revature.models.User;
import com.revature.repositories.RecipeRepository;
import com.revature.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = com.revature.driver.Application.class)
public class AdminServiceTest {

    @Autowired
    AdminService adminService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private RecipeRepository recipeRepository;

    @Test
    public void testBanUser() {
        User userIn = new User();
        User userOut = new User();

        userIn.setBanned(false);
        userOut.setBanned(true);

        when(userRepository.save(userIn)).thenReturn(userOut);

        assertTrue(adminService.banUser(userIn));
    }

    @Test
    public void testUnbanUser() {
        User userIn = new User();
        User userOut = new User();

        userIn.setBanned(true);
        userOut.setBanned(false);

        when(userRepository.save(userIn)).thenReturn(userOut);

        assertTrue(adminService.unbanUser(userIn));
    }

    @Test
    public void testApproveRecipe() {
        Recipe recipeIn = new Recipe();
        Recipe recipeOut = new Recipe();
        recipeIn.setApproved(false);
        recipeOut.setApproved(true);

        when(recipeRepository.save(recipeIn)).thenReturn(recipeOut);

        assertTrue(adminService.approveRecipe(recipeIn));
    }

    @Test
    public void testDisapproveRecipe() {
        Recipe recipeIn = new Recipe();
        Recipe recipeOut = new Recipe();
        recipeIn.setDisapproved(false);
        recipeOut.setDisapproved(true);

        when(recipeRepository.save(recipeIn)).thenReturn(recipeOut);

        assertTrue(adminService.disapproveRecipe(recipeIn));
    }
}
