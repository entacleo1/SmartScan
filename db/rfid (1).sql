-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2024 at 02:06 AM
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
  `time_in` time NOT NULL DEFAULT current_timestamp(),
  `time_out` time DEFAULT NULL,
  `date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `records`
--

INSERT INTO `records` (`id`, `reference_type`, `reference_id`, `tags`, `last`, `mid`, `name`, `pos`, `time_in`, `time_out`, `date`) VALUES
(118, 'stake', 1018, '0006505206', 'Entac', 'C', 'Jhon Leo Welliam', 'Admin', '03:29:04', '03:59:48', '2024-05-18'),
(119, 'student', 12312312, '0006538760', 'Sacayan', 'L', 'Jonas', 'BSHM', '03:29:09', '03:29:51', '2024-05-18'),
(120, 'student', 123122121, '0006537041', 'Pimentel', '', 'Matt', 'BSCRIM', '03:29:14', '03:30:01', '2024-05-18'),
(121, 'student', 12, '0006497184', 'Alidon', 'A', 'Juli Ann', 'HUMMS 11', '03:29:18', '04:11:39', '2024-05-18'),
(122, 'student', 123122121, '0006537041', 'Pimentel', '', 'Matt', 'BSCRIM', '03:42:12', '03:59:42', '2024-05-18'),
(123, 'student', 123122121, '0006537041', 'Pimentel', '', 'Matt', 'BSCRIM', '04:01:08', '04:07:40', '2024-05-18'),
(124, 'stake', 1018, '0006505206', 'Entac', 'C', 'Jhon Leo Welliam', 'Admin', '04:01:11', '04:07:33', '2024-05-18'),
(125, 'student', 12312312, '0006538760', 'Sacayan', 'L', 'Jonas', 'BSHM', '04:01:14', '04:07:47', '2024-05-18'),
(126, 'stake', 1018, '0006505206', 'Entac', 'C', 'Jhon Leo Welliam', 'Admin', '02:13:41', '21:31:16', '2024-05-20'),
(127, 'student', 12, '0006497184', 'Alidon', 'A', 'Juli Ann', 'HUMMS 11', '02:12:57', NULL, '2024-05-21'),
(128, 'stake', 1019, '0006507887', 'Entac', '', 'Berna', 'Staff', '05:14:51', '05:14:57', '2024-05-21'),
(129, 'stake', 1019, '0006497184', 'test', 'test', 'test', 'Admin', '09:30:56', '09:30:57', '2024-05-21'),
(130, 'stake', 1018, '0006505206', 'Entac', 'C', 'Jhon Leo Welliam', 'Super Admin', '09:37:39', '09:38:18', '2024-05-21'),
(131, 'student', 2001, '0006507887', 'Bustamante', '', 'Micheal John', 'BSIT 1', '10:03:17', '10:03:21', '2024-05-21'),
(132, 'stake', 1018, '0006505206', 'Entac', 'C', 'Jhon Leo Welliam', 'Super Admin', '10:27:45', '10:27:48', '2024-05-21'),
(133, 'stake', 1019, '0006497184', 'test', 'test', 'test', 'Admin', '10:27:52', '10:27:54', '2024-05-21'),
(134, 'student', 2001, '0006507887', 'Bustamante', '', 'Micheal John', 'BSIT 1', '10:27:57', '10:28:01', '2024-05-21'),
(135, 'stake', 1020, '0006458066', 'user', 'user', 'user', 'Staff', '10:28:04', '10:28:07', '2024-05-21'),
(136, 'student', 2001, '0006507887', 'Bustamante', '', 'Micheal John', 'BSIT 1', '00:34:30', '00:34:38', '2024-05-25'),
(137, 'student', 2002, '0006538760', 'Entac', 'A', 'Julie Ann', 'HUMSS', '00:55:45', '03:52:09', '2024-05-25'),
(138, 'student', 2002, '0006538760', 'Entac', 'A', 'Julie Ann', 'HUMSS', '04:14:01', '04:38:28', '2024-05-25'),
(139, 'student', 2002, '0006538760', 'Entac', 'A', 'Julie Ann', 'HUMSS', '05:08:16', '05:08:19', '2024-05-25'),
(140, 'student', 2002, '0006538760', 'Entac', 'A', 'Julie Ann', 'HUMSS', '06:04:06', '06:04:25', '2024-05-25'),
(141, 'stake', 1018, '0006505206', 'Entac', 'C', 'Jhon Leo Welliam', 'Super Admin', '06:04:10', '06:04:51', '2024-05-25'),
(142, 'student', 2002, '0006538760', 'Entac', 'A', 'Julie Ann', 'HUMSS', '06:04:49', NULL, '2024-05-25'),
(143, 'stake', 1018, '0006505206', 'Entac', 'C', 'Jhon Leo Welliam', 'Super Admin', '06:14:05', '06:14:12', '2024-05-25'),
(144, 'stake', 1018, '0006505206', 'Entac', 'C', 'Jhon Leo Welliam', 'Super Admin', '06:14:13', '06:26:31', '2024-05-25'),
(145, 'stake', 1018, '0006505206', 'Entac', 'C', 'Jhon Leo Welliam', 'Super Admin', '06:26:33', '07:12:34', '2024-05-25');

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
(1, 'BSIT 1', 'A'),
(14, 'HUMSS', 'A');

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
(1018, '0006505206', 'Jhon Leo Welliam', 'C', 'Entac', 'entacleo1@gmail', '2003-12-05', 'Male', 'Lower Calajo-an, Minglanilla, Cebu', 'entacleo1', '962ff817f414e19328c3e2034a6cb27b13b38dca', 'src/stakepic/QWERQWE.jpg', 'Active', 'Super Admin', 'Teacher'),
(1019, '0006497184', 'test', 'test', 'test', 'test', '2024-05-01', 'Female', 'test', '1019test', 'd033e22ae348aeb5660fc2140aec35850c4da997', 'src/stakepic/kale.jpg', 'Active', 'Admin', 'Program Head'),
(1020, '0006458066', 'user', 'user', 'user', 'user', '2024-05-02', 'Female', 'user', '1020user', 'd033e22ae348aeb5660fc2140aec35850c4da997', 'src/stakepic/eeeq.jpg', 'Active', 'Staff', 'Teacher');

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
(2001, '0006507887', 'Bustamante', '', 'Micheal John', 'A', 'BSIT 1', '2024-05-03', 'Male', 'test', 'test', 'test', 'src/studentpics/bus.jpg', 'Active'),
(2002, '0006538760', 'Entac', 'A', 'Julie Ann', 'A', 'HUMSS', '2006-09-04', 'Female', '09123456788', 'Bella/Mario Alidon', 'San Roque,Tulay,Minglanilla,Cebu', 'src/studentpics/ohaha.jpg', 'Active');

--
-- Indexes for dumped tables
--

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
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=146;

--
-- AUTO_INCREMENT for table `tbl_gradelvl`
--
ALTER TABLE `tbl_gradelvl`
  MODIFY `num` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `tbl_stake`
--
ALTER TABLE `tbl_stake`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1021;

--
-- AUTO_INCREMENT for table `tbl_students`
--
ALTER TABLE `tbl_students`
  MODIFY `s_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2003;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
