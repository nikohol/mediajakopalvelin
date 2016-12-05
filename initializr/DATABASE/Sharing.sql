-- phpMyAdmin SQL Dump
-- version 4.4.15.8
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 05, 2016 at 09:39 AM
-- Server version: 5.5.50-MariaDB
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Sharing`
--

-- --------------------------------------------------------

--
-- Table structure for table `Comments`
--

CREATE TABLE IF NOT EXISTS `Comments` (
  `comid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `comment` varchar(255) NOT NULL,
  `uid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Content`
--

CREATE TABLE IF NOT EXISTS `Content` (
  `cid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `title` varchar(75) NOT NULL,
  `location` varchar(250) NOT NULL,
  `dop` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `restriction` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Content`
--

INSERT INTO `Content` (`cid`, `uid`, `title`, `location`, `dop`, `restriction`) VALUES
(1, 1, 'Random ow screenshot', 'C:\\Users\\Miikka\\Documents\\GitHub\\mediajakopalvelin\\initializr\\img\\screenei\\Ow', '2016-12-05 09:07:00', 0),
(2, 2, 'Rallycar :O', 'C:\\Users\\Miikka\\Documents\\GitHub\\mediajakopalvelin\\initializr\\img\\screenei\\upload1', '2016-12-05 09:10:07', 0),
(3, 2, 'Get chainsaw', 'C:\\Users\\Miikka\\Documents\\GitHub\\mediajakopalvelin\\initializr\\img\\screenei\\upload2', '2016-12-05 09:11:36', 0);

-- --------------------------------------------------------

--
-- Table structure for table `ContentTags`
--

CREATE TABLE IF NOT EXISTS `ContentTags` (
  `tagid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `tag` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Friends`
--

CREATE TABLE IF NOT EXISTS `Friends` (
  `fid` int(11) NOT NULL,
  `ownerid` int(11) NOT NULL,
  `friendid` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Friends`
--

INSERT INTO `Friends` (`fid`, `ownerid`, `friendid`) VALUES
(1, 1, 2),
(2, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Likes`
--

CREATE TABLE IF NOT EXISTS `Likes` (
  `lid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `cid` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Likes`
--

INSERT INTO `Likes` (`lid`, `uid`, `cid`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 1, 2),
(4, 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `ReportContent`
--

CREATE TABLE IF NOT EXISTS `ReportContent` (
  `rid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `report` varchar(255) NOT NULL,
  `uid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `uid` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `pword` varchar(25) NOT NULL,
  `admin` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`uid`, `username`, `pword`, `admin`) VALUES
(1, 'Miikka', 'miikka', 1),
(2, 'Niko', 'niko', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Comments`
--
ALTER TABLE `Comments`
  ADD PRIMARY KEY (`comid`),
  ADD KEY `cid` (`cid`),
  ADD KEY `uid` (`uid`);

--
-- Indexes for table `Content`
--
ALTER TABLE `Content`
  ADD PRIMARY KEY (`cid`),
  ADD KEY `uid` (`uid`);

--
-- Indexes for table `ContentTags`
--
ALTER TABLE `ContentTags`
  ADD PRIMARY KEY (`tagid`),
  ADD KEY `cid` (`cid`);

--
-- Indexes for table `Friends`
--
ALTER TABLE `Friends`
  ADD PRIMARY KEY (`fid`),
  ADD KEY `ownerid` (`ownerid`),
  ADD KEY `friendid` (`friendid`);

--
-- Indexes for table `Likes`
--
ALTER TABLE `Likes`
  ADD PRIMARY KEY (`lid`),
  ADD KEY `uid` (`uid`),
  ADD KEY `cid` (`cid`);

--
-- Indexes for table `ReportContent`
--
ALTER TABLE `ReportContent`
  ADD PRIMARY KEY (`rid`),
  ADD KEY `cid` (`cid`),
  ADD KEY `uid` (`uid`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Comments`
--
ALTER TABLE `Comments`
  MODIFY `comid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Content`
--
ALTER TABLE `Content`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `ContentTags`
--
ALTER TABLE `ContentTags`
  MODIFY `tagid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Friends`
--
ALTER TABLE `Friends`
  MODIFY `fid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `Likes`
--
ALTER TABLE `Likes`
  MODIFY `lid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `ReportContent`
--
ALTER TABLE `ReportContent`
  MODIFY `rid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `User`
--
ALTER TABLE `User`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Comments`
--
ALTER TABLE `Comments`
  ADD CONSTRAINT `Comments_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `Content` (`cid`),
  ADD CONSTRAINT `Comments_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `User` (`uid`);

--
-- Constraints for table `Content`
--
ALTER TABLE `Content`
  ADD CONSTRAINT `Content_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `User` (`uid`);

--
-- Constraints for table `ContentTags`
--
ALTER TABLE `ContentTags`
  ADD CONSTRAINT `ContentTags_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `Content` (`cid`);

--
-- Constraints for table `Friends`
--
ALTER TABLE `Friends`
  ADD CONSTRAINT `Friends_ibfk_2` FOREIGN KEY (`friendid`) REFERENCES `User` (`uid`),
  ADD CONSTRAINT `Friends_ibfk_1` FOREIGN KEY (`ownerid`) REFERENCES `User` (`uid`);

--
-- Constraints for table `Likes`
--
ALTER TABLE `Likes`
  ADD CONSTRAINT `Likes_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `Content` (`cid`),
  ADD CONSTRAINT `Likes_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `User` (`uid`);

--
-- Constraints for table `ReportContent`
--
ALTER TABLE `ReportContent`
  ADD CONSTRAINT `ReportContent_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `Content` (`cid`),
  ADD CONSTRAINT `ReportContent_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `User` (`uid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
