-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 01:04 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `acc` varchar(100) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `dob` varchar(45) DEFAULT NULL,
  `pin` int(11) DEFAULT NULL,
  `acc_type` varchar(45) DEFAULT NULL,
  `nationality` varchar(45) DEFAULT NULL,
  `caste` varchar(45) DEFAULT NULL,
  `micr_no` int(11) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `mobile` bigint(20) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `sec_q` varchar(45) DEFAULT NULL,
  `sec_a` varchar(45) DEFAULT NULL,
  `balance` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `acc`, `name`, `dob`, `pin`, `acc_type`, `nationality`, `caste`, `micr_no`, `gender`, `mobile`, `address`, `sec_q`, `sec_a`, `balance`) VALUES
(6, '888285', 'Abdulla al jaber', 'Wed May 06 02:21:34 BDT 2020', 777560, 'Select', 'Bangladesh', 'don\'t know', 2362, ' Male', 1890345, 'Dagonbhuiyan,Feni', 'What\'s your name', 'Majed', 200),
(8, '404769', 'Abdulla al jaber', 'Wed May 06 02:21:34 BDT 2020', 335675, 'Current', 'Bangladesh', '166353', 7489, ' MaleMaleMaleMaleMaleMaleMaleMaleMale', 1890345, 'Dagonbhuiyan,Feni', 'What\'s your name', 'Majed', 1244);

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `ausername` varchar(40) DEFAULT NULL,
  `apassword` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `ausername`, `apassword`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `balances`
--

CREATE TABLE `balances` (
  `acc_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `acc` int(11) NOT NULL,
  `micr_no` int(11) NOT NULL,
  `balance` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `trans`
--

CREATE TABLE `trans` (
  `id` int(11) NOT NULL,
  `acc` varchar(40) DEFAULT NULL,
  `date` varchar(40) DEFAULT NULL,
  `deposit` int(200) DEFAULT NULL,
  `withdraw` int(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trans`
--

INSERT INTO `trans` (`id`, `acc`, `date`, `deposit`, `withdraw`) VALUES
(1, 'majed', NULL, 50, NULL),
(2, 'majed', 'null', 50, NULL),
(3, 'majed', 'Mon May 04 23:43:04 BDT 2020', 50, NULL),
(4, 'majed', 'Mon May 04 23:46:18 BDT 2020', 20, NULL),
(5, 'majed', 'Mon May 04 23:47:04 BDT 2020', NULL, 50),
(6, 'majed', 'Mon May 04 23:48:29 BDT 2020', NULL, -1500),
(7, 'abdulla al jaber', 'Tue May 05 00:34:30 BDT 2020', 500, NULL),
(8, 'abdulla al jaber', 'Tue May 05 00:34:44 BDT 2020', NULL, -50),
(9, 'abdulla al jaber', 'Tue May 05 00:34:57 BDT 2020', 50, NULL),
(10, 'majed', 'Tue May 05 04:17:38 BDT 2020', 100, NULL),
(11, 'majed', 'Tue May 05 05:11:56 BDT 2020', 500, NULL),
(12, 'majed', 'Tue May 05 05:12:05 BDT 2020', 800, NULL),
(13, 'majed', 'Tue May 05 05:12:26 BDT 2020', NULL, -1408),
(14, 'majed', 'Tue May 05 05:12:41 BDT 2020', 1500, NULL),
(15, 'majed', 'Wed May 06 01:30:52 BDT 2020', 500, NULL),
(16, 'majed', 'Wed May 06 01:50:28 BDT 2020', 50, NULL),
(17, 'majed', 'Wed May 06 01:51:54 BDT 2020', 50, NULL),
(18, 'majed', 'Wed May 06 01:52:03 BDT 2020', NULL, -50),
(19, 'majed', 'Wed May 06 01:54:39 BDT 2020', 50, NULL),
(20, 'majed', 'Wed May 06 01:54:49 BDT 2020', NULL, -50),
(21, 'majed', 'Wed May 06 01:55:03 BDT 2020', 50, NULL),
(22, 'majed', 'Wed May 06 01:55:16 BDT 2020', 50, NULL),
(23, 'majed', 'Wed May 06 01:55:42 BDT 2020', NULL, -50),
(24, 'majed', 'Wed May 06 01:56:00 BDT 2020', NULL, -50),
(25, 'majed', 'Wed May 06 01:56:54 BDT 2020', 21, NULL),
(26, 'majed', 'Wed May 06 01:57:01 BDT 2020', NULL, -80),
(27, 'majed', 'Wed May 06 01:58:05 BDT 2020', 80, NULL),
(28, 'majed', 'Wed May 06 01:58:55 BDT 2020', 50, NULL),
(29, 'majed', 'Wed May 06 02:01:37 BDT 2020', 50, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `balances`
--
ALTER TABLE `balances`
  ADD PRIMARY KEY (`acc_id`);

--
-- Indexes for table `trans`
--
ALTER TABLE `trans`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `trans`
--
ALTER TABLE `trans`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
