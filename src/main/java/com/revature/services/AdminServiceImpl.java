package com.revature.services;

import com.revature.models.Recipe;
import com.revature.models.User;
import com.revature.repositories.RecipeRepository;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public boolean banUser(User user) {
        user.setBanned(true);
        User usr = userRepository.save(user);

        return user.isBanned() == usr.isBanned();
    }

    @Override
    public boolean unbanUser(User user) {
        user.setBanned(false);
        User usr = userRepository.save(user);

        return user.isBanned() == usr.isBanned();
    }

    @Override
    public boolean approveRecipe(Recipe recipe) {
        return false;
    }

    @Override
    public boolean disapproveRecipe(Recipe recipe) {
        return false;
    }
}
