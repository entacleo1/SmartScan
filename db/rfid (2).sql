-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2024 at 03:17 AM
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
-- Table structure for table `act_logs`
--

CREATE TABLE `act_logs` (
  `date` date NOT NULL DEFAULT current_timestamp(),
  `time` time NOT NULL DEFAULT current_timestamp(),
  `stake_id` int(20) NOT NULL,
  `action` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `act_logs`
--

INSERT INTO `act_logs` (`date`, `time`, `stake_id`, `action`) VALUES
('2024-05-27', '02:24:58', 0, 'null Restored2003'),
('2024-05-27', '05:25:22', 1018, 'Jhon Leo Welliam  Updated2004'),
('2024-05-27', '05:25:38', 1018, 'Jhon Leo Welliam  Updated2003'),
('2024-05-27', '05:25:44', 1018, 'Jhon Leo Welliam  Updated2003'),
('2024-05-27', '22:46:38', 1018, 'Jhon Leo Welliam Archived 1018'),
('2024-05-27', '22:46:46', 1018, 'Jhon Leo Welliam Archived 1020'),
('2024-05-27', '22:49:07', 0, 'null Archived 1019'),
('2024-05-27', '22:50:18', 1018, 'Jhon Leo Welliam Archived 2001'),
('2024-05-27', '22:50:22', 1018, 'Jhon Leo Welliam Archived 2002'),
('2024-05-27', '22:50:25', 1018, 'Jhon Leo Welliam Archived 2004'),
('2024-05-27', '22:50:27', 1018, 'Jhon Leo Welliam Archived 2003'),
('2024-05-27', '22:50:32', 1018, 'Jhon Leo Welliam Restored 2001'),
('2024-05-27', '22:50:35', 1018, 'Jhon Leo Welliam Deleted 2002'),
('2024-05-27', '22:50:39', 1018, 'Jhon Leo Welliam Deleted 2004'),
('2024-05-27', '22:50:43', 1018, 'Jhon Leo Welliam Deleted 2003'),
('2024-05-27', '23:49:33', 1018, 'Jhon Leo Welliam Archived 2001'),
('2024-05-27', '23:49:39', 1018, 'Jhon Leo Welliam Deleted 2001'),
('2024-05-27', '23:57:29', 1018, 'Jhon Leo Welliam  Deleted BSIT 1 Section A'),
('2024-05-27', '23:57:35', 1018, 'Jhon Leo Welliam  Deleted HUMSS Section A'),
('2024-05-27', '23:58:37', 1018, 'Jhon Leo Welliam Added a Grade Level BSIT 1'),
('2024-05-27', '23:58:41', 1018, 'Jhon Leo Welliam Added a Grade Level BSIT 2'),
('2024-05-27', '23:58:45', 1018, 'Jhon Leo Welliam Added a Grade Level BSIT 3'),
('2024-05-27', '23:58:49', 1018, 'Jhon Leo Welliam Added a Grade Level BSIT 4'),
('2024-05-27', '23:59:09', 1018, 'Jhon Leo Welliam Added a Grade Level EDUC ENG-1'),
('2024-05-27', '23:59:13', 1018, 'Jhon Leo Welliam Added a Grade Level EDUC ENG-2'),
('2024-05-27', '23:59:18', 1018, 'Jhon Leo Welliam Added a Grade Level EDUC ENG-3'),
('2024-05-27', '23:59:21', 1018, 'Jhon Leo Welliam Added a Grade Level EDUC ENG-4'),
('2024-05-27', '23:59:55', 1018, 'Jhon Leo Welliam Added a Grade Level EDUC MATH-1'),
('2024-05-27', '23:59:58', 1018, 'Jhon Leo Welliam Added a Grade Level EDUC MATH-2'),
('2024-05-28', '00:00:03', 1018, 'Jhon Leo Welliam Added a Grade Level EDUC MATH-3'),
('2024-05-28', '00:00:07', 1018, 'Jhon Leo Welliam Added a Grade Level EDUC MATH-4'),
('2024-05-28', '00:00:20', 1018, 'Jhon Leo Welliam Added a Grade Level BEED 1'),
('2024-05-28', '00:00:23', 1018, 'Jhon Leo Welliam Added a Grade Level BEED 2'),
('2024-05-28', '00:00:27', 1018, 'Jhon Leo Welliam Added a Grade Level BEED 3'),
('2024-05-28', '00:00:30', 1018, 'Jhon Leo Welliam Added a Grade Level BEED 4'),
('2024-05-28', '00:00:42', 1018, 'Jhon Leo Welliam Added a Grade Level BSHM 1'),
('2024-05-28', '00:00:46', 1018, 'Jhon Leo Welliam Added a Grade Level BSHM 2'),
('2024-05-28', '00:00:49', 1018, 'Jhon Leo Welliam Added a Grade Level BSHM 3'),
('2024-05-28', '00:00:55', 1018, 'Jhon Leo Welliam Added a Grade Level BSHM 4'),
('2024-05-28', '00:06:19', 1018, 'Jhon Leo Welliam Added A new Admin'),
('2024-05-28', '00:09:10', 1019, 'Admin  Added A new Student'),
('2024-05-28', '00:09:49', 1018, 'Jhon Leo Welliam  Updated2001'),
('2024-05-28', '00:11:41', 1018, 'Jhon Leo Welliam Updated 1018');

-- --------------------------------------------------------

--
-- Table structure for table `records`
--

CREATE TABLE `records` (
  `id` int(20) NOT NULL,
  `reference_type` enum('student','stake') NOT NULL,
  `reference_id` int(50) NOT NULL,
  `tags` varchar(50) NOT NULL,
  `last` varchar(50) NOT NULL,
  `mid` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `pos` varchar(50) NOT NULL,
  `pos_type` varchar(50) NOT NULL,
  `time_in` time NOT NULL DEFAULT current_timestamp(),
  `time_out` time DEFAULT NULL,
  `date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `records`
--

INSERT INTO `records` (`id`, `reference_type`, `reference_id`, `tags`, `last`, `mid`, `name`, `pos`, `pos_type`, `time_in`, `time_out`, `date`) VALUES
(297, 'stake', 1018, '0006505206', 'Entac', 'C', 'Jhon Leo Welliam', 'Super Admin', 'Head', '06:32:07', '06:32:14', '2024-05-01'),
(298, 'stake', 1019, '0006537041', 'Test ', '', 'Admin', 'Admin', 'BSIT Program Head', '06:32:12', '06:32:18', '2024-05-28'),
(299, 'stake', 1020, '0006496207', 'teste', 'test', 'test', 'Staff', '', '08:23:42', NULL, '2024-05-28'),
(300, 'stake', 1018, '0006505206', 'Entac', 'C', 'Jhon Leo Welliam', 'Super Admin', 'Head', '08:23:48', NULL, '2024-05-28'),
(301, 'stake', 1019, '0006537041', 'Test ', '', 'Admin', 'Admin', 'BSIT Program Head', '08:23:51', NULL, '2024-05-28'),
(302, 'student', 2001, '0006494324', 'Quinanola', 'Boyax', 'Jose Ralph Audrey', 'BSIT 1', 'A', '08:23:54', '08:23:58', '2024-05-28');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_gradelvl`
--

CREATE TABLE `tbl_gradelvl` (
  `num` int(20) NOT NULL,
  `lvl` varchar(20) NOT NULL,
  `section` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_gradelvl`
--

INSERT INTO `tbl_gradelvl` (`num`, `lvl`, `section`) VALUES
(15, 'BSIT 1', 'A'),
(16, 'BSIT 2', 'A'),
(17, 'BSIT 3', 'A'),
(18, 'BSIT 4', 'A'),
(19, 'EDUC ENG-1', 'A'),
(20, 'EDUC ENG-2', 'A'),
(21, 'EDUC ENG-3', 'A'),
(22, 'EDUC ENG-4', 'A'),
(23, 'EDUC MATH-1', 'A'),
(24, 'EDUC MATH-2', 'A'),
(25, 'EDUC MATH-3', 'A'),
(26, 'EDUC MATH-4', 'A'),
(27, 'BEED 1', 'A'),
(28, 'BEED 2', 'A'),
(29, 'BEED 3', 'A'),
(30, 'BEED 4', 'A'),
(31, 'BSHM 1', 'A'),
(32, 'BSHM 2', 'A'),
(33, 'BSHM 3', 'A'),
(34, 'BSHM 4', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_stake`
--

CREATE TABLE `tbl_stake` (
  `id` int(50) NOT NULL,
  `tag` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `mid` varchar(20) NOT NULL,
  `last` varchar(50) NOT NULL,
  `email` varchar(20) NOT NULL,
  `bod` date NOT NULL,
  `gender` varchar(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  `user` varchar(50) NOT NULL,
  `pass` varchar(100) NOT NULL,
  `pic` varchar(100) NOT NULL,
  `status` varchar(20) NOT NULL,
  `position` varchar(20) NOT NULL,
  `pos_type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_stake`
--

INSERT INTO `tbl_stake` (`id`, `tag`, `name`, `mid`, `last`, `email`, `bod`, `gender`, `address`, `user`, `pass`, `pic`, `status`, `position`, `pos_type`) VALUES
(1018, '0006505206', 'Jhon Leo Welliam', 'C', 'Entac', 'entacleo1@gmail', '2003-12-05', 'Male', 'Lower Calajo-an, Minglanilla, Cebu', 'entacleo1', '962ff817f414e19328c3e2034a6cb27b13b38dca', 'src/stakepic/QWERQWE.jpg', 'Active', 'Super Admin', 'Head'),
(1019, '0006537041', 'Admin', '', 'Test ', 'test', '2024-05-03', 'Female', 'test', '1019Test ', 'd033e22ae348aeb5660fc2140aec35850c4da997', 'src/stakepic/lis.png', 'Active', 'Admin', 'BSIT Program Head'),
(1020, '0006496207', 'test', 'test', 'teste', 'rews', '2024-03-08', 'Male', 'tes', '1020teste', 'd033e22ae348aeb5660fc2140aec35850c4da997', 'src/stakepic/kale.jpg', 'Active', 'Staff', '');

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
  `s_add` varchar(50) NOT NULL,
  `s_pic` varchar(50) NOT NULL,
  `s_stat` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_students`
--

INSERT INTO `tbl_students` (`s_id`, `s_tag`, `s_last`, `s_mi`, `s_name`, `s_section`, `s_grade`, `s_bday`, `s_gender`, `s_mobile`, `s_guard`, `s_add`, `s_pic`, `s_stat`) VALUES
(2000, '', '', '', '', '', '', '0000-00-00', '', '', '', '', '', ''),
(2001, '0006494324', 'Quinanola', 'Boyax', 'Jose Ralph Audrey', 'A', 'BSIT 1', '2003-03-19', 'Male', '09123456789', 'Angel Casas', 'Poblacion Ward 2, Minglanilla, Cebu', 'src/studentpics/HAHA.jpg', 'Active');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `act_logs`
--
ALTER TABLE `act_logs`
  ADD KEY `fkstake_id` (`stake_id`);

--
-- Indexes for table `records`
--
ALTER TABLE `records`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_gradelvl`
--
ALTER TABLE `tbl_gradelvl`
  ADD PRIMARY KEY (`num`);

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
-- AUTO_INCREMENT for table `records`
--
ALTER TABLE `records`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=303;

--
-- AUTO_INCREMENT for table `tbl_gradelvl`
--
ALTER TABLE `tbl_gradelvl`
  MODIFY `num` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `tbl_stake`
--
ALTER TABLE `tbl_stake`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1021;

--
-- AUTO_INCREMENT for table `tbl_students`
--
ALTER TABLE `tbl_students`
  MODIFY `s_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2002;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
