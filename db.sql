CREATE TABLE Fonctions(
    FonctionId int(10) PRIMARY KEY AUTO_INCREMENT,
    FonctionNom VARCHAR(25)
);

CREATE TABLE Services(
    ServiceId INT(10) PRIMARY KEY AUTO_INCREMENT,
    ServiceNom VARCHAR(25)
);

Create TABLE Employes(
    EmployeId int(10) PRIMARY KEY AUTO_INCREMENT,
    Nom varchar(25),
    Prenom varchar(25),
    DateNai DATE,
    DateEmb DATE,
    FonctionId int(10),
    ServiceId int(10),
    CONSTRAINT emp_fonc FOREIGN KEY (FonctionId) REFERENCES Fonctions(FonctionId),
    CONSTRAINT emp_serv FOREIGN KEY (ServiceId) REFERENCES Services(ServiceId)
);

CREATE TABLE Conges(
    CongeId INT(10) PRIMARY KEY AUTO_INCREMENT,
    DateDeb DATE,
    DateFin DATE,
    EmployeId int(10),
    CONSTRAINT cong_emp FOREIGN KEY (EmployeId) REFERENCES Employes(EmployeId)
);

CREATE TABLE Salaires(
    SalaireId INT(10) PRIMARY KEY AUTO_INCREMENT,
    Montant float,
    EmployeId int(10),
    CONSTRAINT sal_emp FOREIGN KEY (EmployeId) REFERENCES Employes(EmployeId)
);

/**** Separated table ***/

CREATE TABLE Admins(
    AdminId INT(10) PRIMARY KEY AUTO_INCREMENT,
    AdminFullName varchar(25),
    AdminUserName VARCHAR(25),
    AdminPassword VARCHAR(25)
);
