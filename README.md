# Recipe Management System - Backend

[Project Description]

## User Stories
User story writing pattern: As a [persona], I [want to], [so that].

1. As a user I want to be able to create an account
2. As a user I want to be able to login and logout
3. As a user I want to add and modify my recipes
4. As a user I want to be able to search for other users' recipes
5. As a user I want to be able to upload media related to my recipe
6. As an admin I want to be able to approve recipes
7. As a user I want to be able to comment on other people's recipes
8. As a user I want to be able to like/dislike other people's recipes
9. As a user I would like to follow other users
10. As a user I want to be able to rate other people's recipes
11. As a user I want to be able to see the average rating of a recipe
12. As a user I want to be able to filter my searches
13. As a user I want to be able to share my recipe on social media
14. As a user I want to be able to download the recipe
15. As a user I want to be able to use instacart to purchase my recipe's ingredients
16. As an admin I want to be able to (un)ban users
17. As a user I want to be able to sort search results
18. As a user I want to be able to form a group with other users
19. As a user I want to be able to moderate a group
20. As a moderator I want to be able to appoint more moderators
21. As a group member I want to be able to poll members
22. As a group member I want to be able to chat with the other members
23. As a user I want my recipes to display ingredient information
24. As a user I want to see all the recipes I've made
25. As a user I want to see who I'm following
26. As a user I want to see who is following me
27. As a user I want to get a notification when a user I'm following creates or modifies a recipe

### MVP User Stories

1. As a user I want to be able to create an account
2. As a user I want to be able to login and logout
3. As a user I want to add and modify my recipes
4. As a user I want to see all the recipes I've made
5. As an admin I want to be able to approve recipes
6. As an admin I want to be able to (un)ban users
7. As a user I want my recipes to display ingredient information
8. As a user I want to be able to search for other users' recipes
9. As a user I want to be able to upload media related to my recipe
10. As a user I want to be able to share my recipe on social media

### Planned Goals

1. As a user I want to be able to sort search results
2. As a user I want to be able to filter my searches
3. As a user I want to be able to download the recipe
4. As a user I want to be able to rate other people's recipes
5. As a user I want to be able to comment on other people's recipes
6. As a user I want to be able to see the average rating of a recipe

### Stretch Goals

1. As a user I want to follow other users
2. As a user I want to see who I'm following
3. As a user I want to see who is following me
4. As a user I want to be able to like/dislike other people's recipes
5. As a user I want to get a notification when a user I'm following creates or modifies a recipe
6. As a user I want to be able to form a group with other users
7. As a user I want to be able to moderate a group
8. As a user I want to be able to form a group with other users
9. As a moderator I want to be able to appoint more moderators
10. As a group member I want to be able to chat with the other members
11. As a group member I want to be able to poll members
12. As a user I want to be able to stream myself cooking my recipe
13. As a user I want to be able to use instacart to purchase my recipe's ingredients

---

## Front End Data Requests



### Endpoints
 * ~/login/
 * ~/register/
 * ~/recipes/
 * ~/recipes/{id}
 * ~/search/{recipe_substring}
 * ~/users/
 * ~/users/{id}

The following describes data requests between front and back:
#### /login/
Two scenarios:
 * User does not authenticate:
   * Status code: 401 + message: "No account found."
   * Status code: 401 + message: "User has been banned."
 * User does authenticate:
   * User is admin:
     * Account information
     * All Recipes
     * All Users
   * User is not admin:
     * Account information
     * Recipes' title, description, thumbnail, and id (React manages this)

#### /register/
 * On success same as /login/
 * On failure, relevant status code + message
   * For example username is already taken, we can return "Username already exists".

#### /recipes/
This endpoint takes GET and POST requests.
 * POST: used to create new recipes, takes json for a post
 * GET used to get all recipes (only sent by admin accounts)

#### /recipes/{id}
Takes PUT, DELETE, and GET.
 * GET is used by recipe page to view recipe details
 * PUT is used to update a recipe that is being viewed by its creator (or admin approving it)
 * DELETE is used to delete the recipe

#### /search/{recipe_substring}
Only serves GET requests
 * Returns json array of recipes that have been filtered to have a named that contains recipe_substring

#### /users/
Only serves GET and POST requests
 * POST used to create new users
 * GET used to get all users (only sent by admin accounts)

#### /users/{id}
Takes PUT and GET requests.
 * PUT is used to update account information
 * GET is used to get account information (possibly only admins use this)


---
# Notes
On admin page, add "Pending Approval" section for recipes that are awaiting approval.
On admin page, have Users section for searching, banning, and unbanning users.