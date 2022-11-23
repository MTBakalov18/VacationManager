/* INSERT INTO Users(ID, username, password, FirstName, LastName, role, team)
VALUES (1, 'MTBakalov18','goshko123', 'Martin', 'Bakalov', 'CEO', 'team1');

INSERT INTO Teams(TeamID, TeamName, CurrentProject, Developers, TeamLead)
VALUES (1, 'team1', 'project1', 'MTBakalov18', 'MTBakalov18');

INSERT INTO Project(ProjectID, ProjectName, Description, CurrentTeam)
VALUES (1, 'project1', 'working on things', 'team1');

INSERT INTO Dismission(DismissionID, DateFrom, DateTo, DateofDismissionCreation, HalfaDayDismission, Approved, Applicant)
VALUES (1, '11/14', '11/20', '11/10', 'false', 'true', 'Petio');