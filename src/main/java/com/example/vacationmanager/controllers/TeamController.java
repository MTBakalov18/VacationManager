package com.example.vacationmanager.controllers;

import com.example.vacationmanager.dao.TeamRepository;
import com.example.vacationmanager.dao.JPAProjectTeamUserRepository;
import com.example.vacationmanager.tables.Team;
import com.example.vacationmanager.tables.User;
import com.example.vacationmanager.tables.JPAProjectTeamUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeamController{

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    JPAProjectTeamUserRepository JPAProjectTeamUserRepository;
    @Autowired
    UserController userController = UserController.getInstance();

    @GetMapping("/goToTeamsInfoPage")
    public String teamsInfoPage() {
        return "teamsInfo";
    }

    @GetMapping("/goToCreateTeamPage")
    public String createTeamPage() {
        return "createTeam";
    }

    @PostMapping("/joinTeam")
    public String joinTeam(@ModelAttribute Team team, Model model, JPAProjectTeamUser JPAProjectTeamUser) {

        User updatedUser = userController.loggedUser;
        updatedUser.setRole("Developer");
        userController.userRepo.save(updatedUser);
        model.addAttribute("getLoggedUser", updatedUser);

        JPAProjectTeamUserRepository.save(JPAProjectTeamUser);
        JPAProjectTeamUser updatedUserTeamProject = JPAProjectTeamUserRepository.findById(JPAProjectTeamUser.getId()).get();
        updatedUserTeamProject.setTeam(team);
        updatedUserTeamProject.setUser(userController.loggedUser);
        JPAProjectTeamUserRepository.save(updatedUserTeamProject);
        return "unassignedPage";
    }

    @PostMapping("/createTeam")
    public String createTeam(@ModelAttribute Team team, Model model, JPAProjectTeamUser JPAProjectTeamUser) {
        teamRepository.saveAndFlush(team);
        Team updatedTeam = teamRepository.findById(team.getTeamId()).get();
        updatedTeam.setTeamLeaderId(userController.loggedUser.getUserId());
        teamRepository.saveAndFlush(updatedTeam);
        User updatedUser = userController.loggedUser;
        updatedUser.setRole("Team Leader");
        userController.userRepo.saveAndFlush(updatedUser);
        model.addAttribute("getLoggedUser", updatedUser);
        JPAProjectTeamUserRepository.saveAndFlush(JPAProjectTeamUser);
        JPAProjectTeamUser updatedUserTeamProject = JPAProjectTeamUserRepository.findById(JPAProjectTeamUser.getId()).get();
        updatedUserTeamProject.setTeam(team);
        updatedUserTeamProject.setUser(userController.loggedUser);
        JPAProjectTeamUserRepository.saveAndFlush(updatedUserTeamProject);
        return "unassignedPage";
    }

    @RequestMapping(value = "/joinTeamPage")
    public String joinTeam(Model model) {
        model.addAttribute("teams", JPAProjectTeamUserRepository.findAll());
        return "joinTeam";
    }

    @RequestMapping(value = "/teamsInfo")
    public String getAllTeams(Model model) {
        model.addAttribute("teams", JPAProjectTeamUserRepository.findAll());
        return "teamsInfo";
    }


}