-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 24 Février 2017 à 13:14
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
(25, 'EquipeTest');

-- --------------------------------------------------------

--
-- Structure de la table `competition`
--

CREATE TABLE `competition` (
  `id_comp` int(11) NOT NULL,
  `c_nom` varchar(255) NOT NULL,
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
(25, 'test', 'tTEST@gmail.com');

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
  MODIFY `id_c` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT pour la table `competition`
--
ALTER TABLE `competition`
  MODIFY `id_comp` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
