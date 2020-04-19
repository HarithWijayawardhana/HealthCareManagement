-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2020 at 09:37 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital_mgt`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `docId` int(4) NOT NULL,
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `Specialization` varchar(30) NOT NULL,
  `Gender` varchar(12) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `ContactNo` varchar(12) NOT NULL,
  `StandardFees` decimal(7,2) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`docId`, `FirstName`, `LastName`, `Specialization`, `Gender`, `Email`, `ContactNo`, `StandardFees`, `Password`) VALUES
(1, 'Anura', 'Welagedara', 'Neurologist', 'Male', 'anura@gmail.com', '94776437998', '2000.00', 'anura321'),
(2, 'Vikum', 'Perera', 'Cardiologist', 'Male', 'vikuma@gmail.com', '94777865498', '3500.00', 'vikum98'),
(3, 'Kavya', 'Ashen', 'Psychiatrist', 'Female', 'kavyaa@gmail.com', '94712278857', '2500.00', 'kavya199'),
(4, 'Isuri', 'Wijerathna', 'Dermatalogist', 'Female', 'isuri@gmail.com', '94551123454', '1500.00', 'isurid1'),
(6, 'Kasun', 'Madawa', 'Dentist', 'Male', 'kasunm@gmail.com', '94778819384', '1500.00', '123kasun');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`docId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `docId` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
