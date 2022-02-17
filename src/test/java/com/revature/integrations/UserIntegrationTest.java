package com.revature.integrations;

import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest(classes = com.revature.driver.Application.class)
@Transactional
public class UserIntegrationTest {
}
