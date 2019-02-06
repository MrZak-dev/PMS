-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 06, 2019 at 11:25 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `personalmgmt`
--
CREATE DATABASE IF NOT EXISTS `personalmgmt` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `personalmgmt`;

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `AdminId` int(10) NOT NULL,
  `AdminFullName` varchar(25) DEFAULT NULL,
  `AdminUserName` varchar(25) DEFAULT NULL,
  `AdminPassword` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`AdminId`, `AdminFullName`, `AdminUserName`, `AdminPassword`) VALUES
(1, 'Zakaria Guenna', 'zakaria', '123456'),
(2, 'nehemie', 'nehemie', 'nehemie');

-- --------------------------------------------------------

--
-- Table structure for table `conges`
--

CREATE TABLE `conges` (
  `CongeId` int(10) NOT NULL,
  `DateDeb` date DEFAULT NULL,
  `DateFin` date DEFAULT NULL,
  `EmployeId` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `conges`
--

INSERT INTO `conges` (`CongeId`, `DateDeb`, `DateFin`, `EmployeId`) VALUES
(1, '2019-02-06', '2019-02-16', 1),
(2, '2019-02-06', '2019-02-28', 2),
(3, '2019-02-06', '2019-02-12', 3),
(4, '2019-02-07', '2019-02-21', 6),
(5, '2019-02-07', '2019-02-21', 7),
(6, '2019-02-07', '2019-02-21', 1),
(7, '2019-02-07', '2019-02-26', 5),
(8, '2019-02-10', '2019-03-02', 10),
(9, '2019-02-02', '2019-02-26', 6);

-- --------------------------------------------------------

--
-- Table structure for table `employes`
--

CREATE TABLE `employes` (
  `EmployeId` int(10) NOT NULL,
  `Nom` varchar(25) DEFAULT NULL,
  `Prenom` varchar(25) DEFAULT NULL,
  `DateNai` date DEFAULT NULL,
  `DateEmb` date DEFAULT NULL,
  `FonctionId` int(10) DEFAULT NULL,
  `ServiceId` int(10) DEFAULT NULL,
  `CongeId` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employes`
--

INSERT INTO `employes` (`EmployeId`, `Nom`, `Prenom`, `DateNai`, `DateEmb`, `FonctionId`, `ServiceId`, `CongeId`) VALUES
(1, 'Guenna', 'Zakaria', '1996-02-05', '2011-02-04', 1, 3, NULL),
(2, 'Tchembella', 'Nehemie', '1990-02-04', '2012-02-04', 1, 2, NULL),
(3, 'Kadir', 'Mohammed', '2000-02-04', '2010-02-04', 3, 1, NULL),
(4, 'Carle', 'Max', '1970-02-04', '2002-02-24', 4, 3, NULL),
(5, 'Nahiri', 'Achraf', '1996-05-22', '2010-05-12', 4, 3, NULL),
(6, 'Salmi', 'Yassin', '1990-05-05', '2000-02-02', 3, 1, NULL),
(7, 'Emie', 'Salma', '1990-05-03', '2002-05-13', 2, 1, NULL),
(8, 'Hadi', 'Hafid', '1990-05-22', '2010-05-06', 3, 4, NULL),
(9, 'Naji', 'Souhail', '1950-06-06', '1999-09-09', 4, 4, NULL),
(10, 'Bahi', 'Mohammed', '1990-02-20', '2010-05-05', 5, 3, NULL),
(11, 'Ruhi', 'Nadia', '1990-02-02', '2002-02-03', 1, 1, NULL),
(12, 'Salmi', 'loubna', '1990-02-02', '2002-02-03', 2, 1, NULL),
(13, 'Rarr', 'lal', '1960-02-10', '2002-02-03', 2, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `fonctions`
--

CREATE TABLE `fonctions` (
  `FonctionId` int(10) NOT NULL,
  `FonctionNom` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fonctions`
--

INSERT INTO `fonctions` (`FonctionId`, `FonctionNom`) VALUES
(1, 'Directeur Général'),
(2, 'Directeur'),
(3, 'Sous Directeur'),
(4, 'Employé'),
(5, 'GRH'),
(6, 'FonctionTest'),
(7, 'Fonction3');

-- --------------------------------------------------------

--
-- Table structure for table `salaires`
--

CREATE TABLE `salaires` (
  `SalaireId` int(10) NOT NULL,
  `Montant` float DEFAULT NULL,
  `EmployeId` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salaires`
--

INSERT INTO `salaires` (`SalaireId`, `Montant`, `EmployeId`) VALUES
(1, 5000, 6),
(2, 4000, 7),
(3, 4900, 8),
(4, 4000, 9),
(5, 5000, 10),
(6, 10000, 11),
(7, 10000, 12),
(8, 10000, 13);

-- --------------------------------------------------------

--
-- Table structure for table `services`
--

CREATE TABLE `services` (
  `ServiceId` int(10) NOT NULL,
  `ServiceNom` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `services`
--

INSERT INTO `services` (`ServiceId`, `ServiceNom`) VALUES
(1, 'Livraison'),
(2, 'Payment'),
(3, 'Maintenance'),
(4, 'Securité'),
(5, ''),
(6, ''),
(7, 'Ser2'),
(8, '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`AdminId`);

--
-- Indexes for table `conges`
--
ALTER TABLE `conges`
  ADD PRIMARY KEY (`CongeId`),
  ADD KEY `cong_emp` (`EmployeId`);

--
-- Indexes for table `employes`
--
ALTER TABLE `employes`
  ADD PRIMARY KEY (`EmployeId`),
  ADD KEY `emp_fonc` (`FonctionId`),
  ADD KEY `emp_serv` (`ServiceId`);

--
-- Indexes for table `fonctions`
--
ALTER TABLE `fonctions`
  ADD PRIMARY KEY (`FonctionId`);

--
-- Indexes for table `salaires`
--
ALTER TABLE `salaires`
  ADD PRIMARY KEY (`SalaireId`),
  ADD KEY `sal_emp` (`EmployeId`);

--
-- Indexes for table `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`ServiceId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `AdminId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `conges`
--
ALTER TABLE `conges`
  MODIFY `CongeId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `employes`
--
ALTER TABLE `employes`
  MODIFY `EmployeId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `fonctions`
--
ALTER TABLE `fonctions`
  MODIFY `FonctionId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `salaires`
--
ALTER TABLE `salaires`
  MODIFY `SalaireId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `services`
--
ALTER TABLE `services`
  MODIFY `ServiceId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `conges`
--
ALTER TABLE `conges`
  ADD CONSTRAINT `cong_emp` FOREIGN KEY (`EmployeId`) REFERENCES `employes` (`EmployeId`);

--
-- Constraints for table `employes`
--
ALTER TABLE `employes`
  ADD CONSTRAINT `emp_fonc` FOREIGN KEY (`FonctionId`) REFERENCES `fonctions` (`FonctionId`),
  ADD CONSTRAINT `emp_serv` FOREIGN KEY (`ServiceId`) REFERENCES `services` (`ServiceId`);

--
-- Constraints for table `salaires`
--
ALTER TABLE `salaires`
  ADD CONSTRAINT `sal_emp` FOREIGN KEY (`EmployeId`) REFERENCES `employes` (`EmployeId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
