-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 02, 2024 at 08:54 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rfid`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_gradelvl`
--

CREATE TABLE `tbl_gradelvl` (
  `lvl` varchar(20) NOT NULL,
  `section` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_stake`
--

CREATE TABLE `tbl_stake` (
  `id` int(20) NOT NULL,
  `tag` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `last` varchar(50) NOT NULL,
  `user` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_stake`
--

INSERT INTO `tbl_stake` (`id`, `tag`, `name`, `last`, `user`, `pass`) VALUES
(1001, '0006505206', 'Leo', 'Entac', 'qwer', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_students`
--

CREATE TABLE `tbl_students` (
  `s_id` int(20) NOT NULL,
  `s_tag` varchar(20) NOT NULL,
  `s_last` varchar(50) NOT NULL,
  `s_mi` varchar(5) NOT NULL,
  `s_name` varchar(50) NOT NULL,
  `s_section` varchar(50) NOT NULL,
  `s_grade` varchar(50) NOT NULL,
  `s_bday` date NOT NULL,
  `s_gender` varchar(50) NOT NULL,
  `s_mobile` varchar(20) NOT NULL,
  `s_guard` varchar(50) NOT NULL,
  `s_add` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_students`
--

INSERT INTO `tbl_students` (`s_id`, `s_tag`, `s_last`, `s_mi`, `s_name`, `s_section`, `s_grade`, `s_bday`, `s_gender`, `s_mobile`, `s_guard`, `s_add`) VALUES
(12, '1000', 'Alidon', 'A', 'Juli Ann', '1', 'HUMSS 11', '2007-09-04', 'Female', '09610549908', 'Mario', 'Tulay,Minglanilla,Cebu'),
(200, '456789', 'Bustamante', 'M', 'Mike', 'B', 'BSIT', '2000-05-05', 'Male', '1234567890', 'Bus', 'Lipata'),
(1001, '12346', 'Entac', 'C', 'Jhon Leo Welliam', 'A', 'BSIT 2', '2024-04-02', 'Male', '09266911314', 'Leo', 'Lower Calajo an Minglanilla cebu'),
(312312, '213213', 'wqeqds', 'add', 'adasas', 'A', 'BSEDUC', '2000-02-02', 'Malew', 'eqweqw', 'ewqeqw', 'eqweq');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_stake`
--
ALTER TABLE `tbl_stake`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_students`
--
ALTER TABLE `tbl_students`
  ADD PRIMARY KEY (`s_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_stake`
--
ALTER TABLE `tbl_stake`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1004;

--
-- AUTO_INCREMENT for table `tbl_students`
--
ALTER TABLE `tbl_students`
  MODIFY `s_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=312313;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
