INSERT INTO users (user_id, banned, admin, date_of_birth, email, first_name, lasT_name, password, phone, registration_date, username) VALUES
(default, false, false, 0, 'email@gmail.com', 'first', 'last', 'password', '555-5555', 0, 'username');

INSERT INTO recipes (recipe_id, approved, disapproved, cook_time, description, likes, dislikes, name, servings, user_id) VALUES
(default, true, false, '1.5 hrs', 'my recipe is tasty', 0, 0, 'recipe', 4, 1),
(default, true, false, '2.5 hrs', 'other recipe', 0, 0, 'recipe2', 4, 1);

INSERT INTO instructions VALUES
(default, 1, 'do this thing', 1),
(default, 1, 'do this other thing', 2);

INSERT INTO foodstuff VALUES (default, 'apple'), (default, 'coffee');
INSERT INTO ingredients VALUES (default, 1, 1, 1), (default, 2, 2, 1);