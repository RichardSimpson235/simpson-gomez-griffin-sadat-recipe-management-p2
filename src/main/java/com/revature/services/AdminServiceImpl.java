package com.revature.services;

import com.revature.repositories.RecipeRepository;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminServiceImpl implements AdminService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public boolean banUser(int id) {
        return false;
    }

    @Override
    public boolean unbanUser(int id) {
        return false;
    }

    @Override
    public boolean approveRecipe(int id) {
        return false;
    }

    @Override
    public boolean disapproveRecipe(int id) {
        return false;
    }
}
