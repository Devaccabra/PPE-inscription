-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 24 Février 2017 à 13:43
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `inscriptions`
--

-- --------------------------------------------------------

--
-- Structure de la table `candidat`
--

CREATE TABLE `candidat` (
  `id_c` int(11) NOT NULL,
  `nom_c` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `candidat`
--

INSERT INTO `candidat` (`id_c`, `nom_c`) VALUES
(3, ''),
(4, 'EquipeTest'),
(5, ''),
(6, 'EquipeTest'),
(7, 'EquipeTest'),
(8, 'EquipeTest'),
(9, 'EquipeTest'),
(10, 'EquipeTest'),
(11, 'EquipeTest'),
(12, 'EquipeTest'),
(13, 'EquipeTest'),
(14, ''),
(15, ''),
(16, 'EquipeTest'),
(17, ''),
(18, 'EquipeTest'),
(19, 'EquipeTest'),
(20, 'EquipeTest'),
(21, 'EquipeTest'),
(22, 'EquipeTest'),
(23, 'EquipeTest'),
(24, 'EquipeTest'),
(25, 'EquipeTest'),
(26, 'EquipeTest'),
(27, ''),
(28, 'EquipeTest'),
(29, 'EquipeTest'),
(30, 'EquipeTest'),
(31, 'EquipeTest'),
(32, 'EquipeTest'),
(33, 'EquipeTest'),
(34, 'EquipeTest'),
(35, 'EquipeTest'),
(36, ''),
(37, 'EquipeTest'),
(38, ''),
(39, 'EquipeTest'),
(40, 'EquipeTest'),
(41, 'EquipeTest'),
(42, 'EquipeTest'),
(43, 'EquipeTest'),
(44, 'EquipeTest'),
(45, 'EquipeTest'),
(46, 'EquipeTest'),
(47, ''),
(48, 'EquipeTest'),
(49, ''),
(50, 'EquipeTest'),
(51, 'EquipeTest'),
(52, 'EquipeTest'),
(53, 'EquipeTest'),
(54, 'EquipeTest'),
(55, 'EquipeTest'),
(56, 'EquipeTest'),
(57, 'EquipeTest'),
(58, ''),
(59, 'EquipeTest'),
(60, ''),
(61, 'EquipeTest'),
(62, 'EquipeTest'),
(63, 'EquipeTest'),
(64, 'EquipeTest'),
(65, 'EquipeTest'),
(66, 'EquipeTest'),
(67, 'EquipeTest'),
(68, 'EquipeTest'),
(69, ''),
(70, 'EquipeTest'),
(71, ''),
(72, 'EquipeTest'),
(73, 'EquipeTest'),
(74, 'EquipeTest'),
(75, 'EquipeTest'),
(76, 'EquipeTest'),
(77, 'EquipeTest'),
(78, 'EquipeTest'),
(79, 'EquipeTest'),
(80, ''),
(81, 'EquipeTest'),
(82, ''),
(83, 'EquipeTest'),
(84, 'EquipeTest'),
(85, 'EquipeTest'),
(86, 'EquipeTest'),
(87, 'EquipeTest'),
(88, 'EquipeTest'),
(89, 'EquipeTest'),
(90, 'EquipeTest'),
(91, ''),
(92, 'EquipeTest'),
(93, ''),
(94, 'EquipeTest'),
(95, 'EquipeTest'),
(96, 'EquipeTest'),
(97, 'EquipeTest'),
(98, 'EquipeTest'),
(99, 'EquipeTest'),
(100, 'EquipeTest'),
(101, 'EquipeTest'),
(102, ''),
(103, 'EquipeTest'),
(104, ''),
(105, 'EquipeTest'),
(106, 'EquipeTest'),
(107, 'EquipeTest'),
(108, 'EquipeTest'),
(109, 'EquipeTest'),
(110, 'EquipeTest'),
(111, 'EquipeTest'),
(112, 'EquipeTest'),
(113, '');

-- --------------------------------------------------------

--
-- Structure de la table `competition`
--

CREATE TABLE `competition` (
  `id_comp` int(11) NOT NULL,
  `nom_comp` varchar(255) NOT NULL,
  `date_cloture` date NOT NULL,
  `en_equipe` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `composer_equipe`
--

CREATE TABLE `composer_equipe` (
  `id_equipe` int(11) NOT NULL,
  `id_p` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `participer`
--

CREATE TABLE `participer` (
  `id_c` int(11) NOT NULL,
  `id_comp` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `id_p` int(11) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`id_p`, `prenom`, `mail`) VALUES
(0, 'test', 'tTEST@gmail.com'),
(4, 'test', 'tTEST@gmail.com'),
(6, 'test', 'tTEST@gmail.com'),
(7, 'test', 'tTEST@gmail.com'),
(8, 'test', 'tTEST@gmail.com'),
(9, 'test', 'tTEST@gmail.com'),
(10, 'test', 'tTEST@gmail.com'),
(11, 'test', 'tTEST@gmail.com'),
(12, 'test', 'tTEST@gmail.com'),
(13, 'test', 'tTEST@gmail.com'),
(14, 'test', 'tTEST@gmail.com'),
(16, 'test', 'tTEST@gmail.com'),
(18, 'test', 'tTEST@gmail.com'),
(19, 'test', 'tTEST@gmail.com'),
(20, 'test', 'tTEST@gmail.com'),
(21, 'test', 'tTEST@gmail.com'),
(22, 'test', 'tTEST@gmail.com'),
(23, 'test', 'tTEST@gmail.com'),
(24, 'test', 'tTEST@gmail.com'),
(25, 'test', 'tTEST@gmail.com'),
(26, 'test', 'tTEST@gmail.com'),
(28, 'test', 'tTEST@gmail.com'),
(29, 'test', 'tTEST@gmail.com'),
(30, 'test', 'tTEST@gmail.com'),
(31, 'test', 'tTEST@gmail.com'),
(32, 'test', 'tTEST@gmail.com'),
(33, 'test', 'tTEST@gmail.com'),
(34, 'test', 'tTEST@gmail.com'),
(35, 'test', 'tTEST@gmail.com'),
(36, 'test', 'tTEST@gmail.com'),
(37, 'test', 'tTEST@gmail.com'),
(39, 'test', 'tTEST@gmail.com'),
(40, 'test', 'tTEST@gmail.com'),
(41, 'test', 'tTEST@gmail.com'),
(42, 'test', 'tTEST@gmail.com'),
(43, 'test', 'tTEST@gmail.com'),
(44, 'test', 'tTEST@gmail.com'),
(45, 'test', 'tTEST@gmail.com'),
(46, 'test', 'tTEST@gmail.com'),
(47, 'test', 'tTEST@gmail.com'),
(48, 'test', 'tTEST@gmail.com'),
(50, 'test', 'tTEST@gmail.com'),
(51, 'test', 'tTEST@gmail.com'),
(52, 'test', 'tTEST@gmail.com'),
(53, 'test', 'tTEST@gmail.com'),
(54, 'test', 'tTEST@gmail.com'),
(55, 'test', 'tTEST@gmail.com'),
(56, 'test', 'tTEST@gmail.com'),
(57, 'test', 'tTEST@gmail.com'),
(58, 'test', 'tTEST@gmail.com'),
(59, 'test', 'tTEST@gmail.com'),
(61, 'test', 'tTEST@gmail.com'),
(62, 'test', 'tTEST@gmail.com'),
(63, 'test', 'tTEST@gmail.com'),
(64, 'test', 'tTEST@gmail.com'),
(65, 'test', 'tTEST@gmail.com'),
(66, 'test', 'tTEST@gmail.com'),
(67, 'test', 'tTEST@gmail.com'),
(68, 'test', 'tTEST@gmail.com'),
(69, 'test', 'tTEST@gmail.com'),
(70, 'test', 'tTEST@gmail.com'),
(72, 'test', 'tTEST@gmail.com'),
(73, 'test', 'tTEST@gmail.com'),
(74, 'test', 'tTEST@gmail.com'),
(75, 'test', 'tTEST@gmail.com'),
(76, 'test', 'tTEST@gmail.com'),
(77, 'test', 'tTEST@gmail.com'),
(78, 'test', 'tTEST@gmail.com'),
(79, 'test', 'tTEST@gmail.com'),
(80, 'test', 'tTEST@gmail.com'),
(81, 'test', 'tTEST@gmail.com'),
(83, 'test', 'tTEST@gmail.com'),
(84, 'test', 'tTEST@gmail.com'),
(85, 'test', 'tTEST@gmail.com'),
(86, 'test', 'tTEST@gmail.com'),
(87, 'test', 'tTEST@gmail.com'),
(88, 'test', 'tTEST@gmail.com'),
(89, 'test', 'tTEST@gmail.com'),
(90, 'test', 'tTEST@gmail.com'),
(91, 'test', 'tTEST@gmail.com'),
(92, 'test', 'tTEST@gmail.com'),
(94, 'test', 'tTEST@gmail.com'),
(95, 'test', 'tTEST@gmail.com'),
(96, 'test', 'tTEST@gmail.com'),
(97, 'test', 'tTEST@gmail.com'),
(98, 'test', 'tTEST@gmail.com'),
(99, 'test', 'tTEST@gmail.com'),
(100, 'test', 'tTEST@gmail.com'),
(101, 'test', 'tTEST@gmail.com'),
(102, 'test', 'tTEST@gmail.com'),
(103, 'test', 'tTEST@gmail.com'),
(105, 'test', 'tTEST@gmail.com'),
(106, 'test', 'tTEST@gmail.com'),
(107, 'test', 'tTEST@gmail.com'),
(108, 'test', 'tTEST@gmail.com'),
(109, 'test', 'tTEST@gmail.com'),
(110, 'test', 'tTEST@gmail.com'),
(111, 'test', 'tTEST@gmail.com'),
(112, 'test', 'tTEST@gmail.com'),
(113, 'test', 'tTEST@gmail.com');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `candidat`
--
ALTER TABLE `candidat`
  ADD PRIMARY KEY (`id_c`);

--
-- Index pour la table `competition`
--
ALTER TABLE `competition`
  ADD PRIMARY KEY (`id_comp`);

--
-- Index pour la table `composer_equipe`
--
ALTER TABLE `composer_equipe`
  ADD PRIMARY KEY (`id_equipe`,`id_p`),
  ADD KEY `id_p` (`id_p`);

--
-- Index pour la table `participer`
--
ALTER TABLE `participer`
  ADD KEY `id_c` (`id_c`),
  ADD KEY `id_comp` (`id_comp`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id_p`),
  ADD KEY `id_p` (`id_p`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `candidat`
--
ALTER TABLE `candidat`
  MODIFY `id_c` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=114;
--
-- AUTO_INCREMENT pour la table `competition`
--
ALTER TABLE `competition`
  MODIFY `id_comp` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
