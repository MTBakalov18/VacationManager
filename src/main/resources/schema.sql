/* CREATE TABLE Users (
                       ID INTEGER NOT NULL,
                       username NVARCHAR(50) NOT NULL,
                       password NVARCHAR(50) NOT NULL,
                       FirstName NVARCHAR(50) NOT NULL,
                       LastName NVARCHAR(50) NOT NULL,
                       role NVARCHAR(50) NOT NULL,
                       team NVARCHAR(50) NOT NULL,
                       PRIMARY KEY (ID)
);
CREATE TABLE Teams (
                       TeamID INTEGER NOT NULL,
                       TeamName NVARCHAR(50) NOT NULL,
                       CurrentProject NVARCHAR(50) NOT NULL,
                       Developers NVARCHAR(50) NOT NULL,
                       TeamLead NVARCHAR(50) NOT NULL,
                       PRIMARY KEY (TeamID)
);
CREATE TABLE Project (
                         ProjectID INTEGER NOT NULL,
                         ProjectName NVARCHAR(50) NOT NULL,
                         Description NVARCHAR(50) NOT NULL,
                         CurrentTeam NVARCHAR(50) NOT NULL,
                         PRIMARY KEY (ProjectID)
);
CREATE TABLE Dismission (
                            DismissionID INTEGER NOT NULL,
                            DateFrom NVARCHAR(50) NOT NULL,
                            DateTo NVARCHAR(50) NOT NULL,
                            DateofDismissionCreation NVARCHAR(50) NOT NULL,
                            HalfaDayDismission BOOLEAN NOT NULL,
                            Approved BOOLEAN NOT NULL,
                            Applicant NVARCHAR(50) NOT NULL,
                            PRIMARY KEY (DismissionID)

)

 */