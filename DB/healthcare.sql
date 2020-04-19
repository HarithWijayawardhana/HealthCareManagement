-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2020 at 01:41 PM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `healthcare`
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

-- --------------------------------------------------------

--
-- Table structure for table `hospital_t`
--

CREATE TABLE `hospital_t` (
  `hosID` int(10) NOT NULL,
  `hosName` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `webAddress` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hospital_t`
--

INSERT INTO `hospital_t` (`hosID`, `hosName`, `password`, `address`, `mobile`, `email`, `webAddress`) VALUES
(100, 'Western Hospital', 'WesternHospital', '218 Cotta Rd, Colombo 00800', '0117392260', 'westernhospital@gmail.com', 'http://westernhospital.lk/'),
(101, 'Dr. Neville Fernando Teaching Hospital', 'NevilleFernando', '406B, Church Road, Weliwita, Malabe 10115', '0112 407 6', 'nevillefernandothospital@gmail.com', 'http://www.nfth.lk/'),
(102, 'Lanka Hospitals', 'LankaHospitals', ' 578 Elvitigala Mawatha, Colombo 00500', '0115430000', 'lankahospital@gmail.com', 'http://www.lankahospitals.com/'),
(103, 'Royal Hospital', 'RoyalHospital', 'No 62 W. A. Silva Mawatha, Colombo 00600', '0112586581', 'royalhospital@gmail.com', 'http://www.royalhospitals.com/'),
(104, 'Asiri Medical Hospital', 'AsiriHospital', '181 Kirula Rd, Colombo 00500', '0114523300', 'asiri@gmail.com', 'http://www.asirihealth.com/'),
(105, 'Hemas Hospital', 'HemasHospital', '389 Negombo-Colombo Main Rd, Wattala 11300', '0117888888', 'hemas@gmail.com', 'http://www.hemashospitals.com/'),
(106, 'Asia Hospitals HL (Pvt) Ltd', 'AsiaHospitals', '110 High Level Rd, Maharagama 10280', '0115232222', 'asiahospital@gmail.com', 'http://www.asiahospital.lk/');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userId` int(10) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `userName`, `password`, `mobile`, `email`, `address`) VALUES
(8, 'asd', '', 'sad', 'asd', 'as'),
(13, 'Pasan', '1234', '0717371868', 'pasan@gmail.com', '13/A'),
(14, 'Shenal', '1234', '0717371868', 'pasan@gmail.com', '13/A'),
(15, 'Shenal', '1234', '0717371868', 'pasan@gmail.com', '13/A');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`docId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `docId` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
