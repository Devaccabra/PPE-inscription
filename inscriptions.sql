-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 24, 2017 at 03:12 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `inscriptions`
--

-- --------------------------------------------------------

--
-- Table structure for table `candidat`
--

CREATE TABLE IF NOT EXISTS `candidat` (
  `id_c` int(11) NOT NULL AUTO_INCREMENT,
  `nom_c` varchar(255) NOT NULL,
  PRIMARY KEY (`id_c`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=963 ;

--
-- Dumping data for table `candidat`
--

INSERT INTO `candidat` (`id_c`, `nom_c`) VALUES
(914, 'Equipe'),
(925, 'MrReYz'),
(926, 'SuceurDeQueue'),
(945, 'Nom'),
(946, 'Nom2'),
(948, 'Nom4'),
(950, 'Nom6'),
(951, 'Nom7'),
(952, 'Nom8'),
(953, 'Nom9'),
(958, 'Nom3'),
(960, 'SuceurDeQueue');

-- --------------------------------------------------------

--
-- Table structure for table `competition`
--

CREATE TABLE IF NOT EXISTS `competition` (
  `id_comp` int(11) NOT NULL AUTO_INCREMENT,
  `nom_comp` varchar(255) NOT NULL,
  `date_cloture` date NOT NULL,
  `en_equipe` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_comp`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1184 ;

--
-- Dumping data for table `competition`
--

INSERT INTO `competition` (`id_comp`, `nom_comp`, `date_cloture`, `en_equipe`) VALUES
(1178, 'aze', '0000-00-00', 1),
(1181, 'Nom', '0000-00-00', 0),
(1183, 'LaComp', '2017-03-31', 1);

-- --------------------------------------------------------

--
-- Table structure for table `composer_equipe`
--

CREATE TABLE IF NOT EXISTS `composer_equipe` (
  `id_equipe` int(11) NOT NULL,
  `id_p` int(11) NOT NULL,
  PRIMARY KEY (`id_equipe`,`id_p`),
  KEY `id_p` (`id_p`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `composer_equipe`
--

INSERT INTO `composer_equipe` (`id_equipe`, `id_p`) VALUES
(0, 0),
(911, 911),
(911, 912),
(911, 913),
(914, 953),
(914, 958);

-- --------------------------------------------------------

--
-- Table structure for table `participer`
--

CREATE TABLE IF NOT EXISTS `participer` (
  `id_c` int(11) NOT NULL,
  `id_comp` int(11) NOT NULL,
  KEY `id_c` (`id_c`),
  KEY `id_comp` (`id_comp`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `participer`
--

INSERT INTO `participer` (`id_c`, `id_comp`) VALUES
(945, 1182),
(951, 1181);

-- --------------------------------------------------------

--
-- Table structure for table `personne`
--

CREATE TABLE IF NOT EXISTS `personne` (
  `id_p` int(11) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL,
  PRIMARY KEY (`id_p`),
  KEY `id_p` (`id_p`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

--
-- Dumping data for table `personne`
--

INSERT INTO `personne` (`id_p`, `prenom`, `mail`) VALUES
(945, 'Prenom', 'Mail'),
(946, 'Prenom2', 'Mail2'),
(948, 'Prenom4', 'Mail4'),
(950, 'Prenom6', 'Mail6'),
(951, 'Prenom7', 'Mail7'),
(952, 'Prenom8', 'Mail8'),
(953, 'Prenom9', 'Mail9'),
(958, 'Prenom3', 'Mail3');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
