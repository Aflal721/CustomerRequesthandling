-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 13, 2021 at 05:48 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lab`
--

-- --------------------------------------------------------

--
-- Table structure for table `customerdetails`
--

CREATE TABLE `customerdetails` (
  `customerID` int(10) NOT NULL,
  `customerName` varchar(20) NOT NULL,
  `customerEmail` varchar(20) NOT NULL,
  `customerPhone` varchar(10) NOT NULL,
  `projecttype` varchar(200) NOT NULL,
  `Description` varchar(200) NOT NULL,
  `Duration` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customerdetails`
--

INSERT INTO `customerdetails` (`customerID`, `customerName`, `customerEmail`, `customerPhone`, `projecttype`, `Description`, `Duration`) VALUES
(23, 'seyon', 'abinath34@gmail.com', '07712345', 'uxdesign', 'fullstack', '2month'),
(28, 'williamson', 'williamson@gmail.com', '0765432', 'none', 'ghui', '1month'),
(29, 'vimal', 'vimal@gmail.com', '0998765', 'js', 'done', '1 month'),
(30, 'vimal', 'vimal@gmail.com', '0998765', 'js', 'done', '1 month'),
(36, 'jasee', 'jasee@gmail.com', '0987675', 'js', 'frontend and backend', '2month'),
(39, 'miller', 'vimal@gmail.com', '0998765', 'js', 'done', '2month');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customerdetails`
--
ALTER TABLE `customerdetails`
  ADD PRIMARY KEY (`customerID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customerdetails`
--
ALTER TABLE `customerdetails`
  MODIFY `customerID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
