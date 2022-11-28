package com.example.vacationmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class JPAProjectTeamUserController {

    @Autowired
    com.example.vacationmanager.dao.JPAProjectTeamUserRepository JPAProjectTeamUserRepository;


}