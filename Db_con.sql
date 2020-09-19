-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 19, 2020 at 01:36 PM
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `java`
--

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE IF NOT EXISTS `test` (
  `Id` int(25) NOT NULL AUTO_INCREMENT,
  `url` varchar(25) NOT NULL,
  `localpath` varchar(25) NOT NULL,
  `status` varchar(25) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`Id`, `url`, `localpath`, `status`) VALUES
(1, 'www.fb.com', 'location/desktop', 'download'),
(2, 'www.fb.com', 'E:\\Downloads', 'Download'),
(3, 'www.fb.com', 'location/desktop', 'download'),
(6, 'www.fb.com', 'location/desktop', ''),
(7, 'www.fb.com', 'location/desktop', ''),
(8, 'www.fb.com', 'location/desktop', ''),
(9, 'www.fb.com', 'location/desktop', '');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
