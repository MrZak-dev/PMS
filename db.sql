CREATE TABLE Fonctions(
    FonctionId int(10) PRIMARY KEY,
    FonctionNom VARCHAR(25)
);

CREATE TABLE Services(
    ServiceId INT(10) PRIMARY KEY,
    ServiceNom VARCHAR(25)
);

Create TABLE Employes(
    EmployeId int(10) PRIMARY KEY,
    Nom varchar(25),
    Prenom varchar(25),
    DateNai DATE,
    DateEmb DATE,
    UserName varchar(25),
    UserPassword varchar(25),
    FonctionId int(10),
    ServiceId int(10),
    CongeId int(10),
    CONSTRAINT emp_fonc FOREIGN KEY (FonctionId) REFERENCES Fonctions(FonctionId),
    CONSTRAINT emp_serv FOREIGN KEY (ServiceId) REFERENCES Services(ServiceId)
);

CREATE TABLE Conges(
    CongeId INT(10) PRIMARY KEY,
    DateDeb DATE,
    DateFin DATE,
    EmployeId int(10),
    CONSTRAINT cong_emp FOREIGN KEY (EmployeId) REFERENCES Employes(EmployeId)
);

CREATE TABLE Salaires(
    SalaireId INT(10),
    Montant float,
    EmployeId int(10),
    CONSTRAINT sal_emp FOREIGN KEY (EmployeId) REFERENCES Employes(EmployeId)
);

