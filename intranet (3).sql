-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 14 Mars 2017 à 08:28
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `intranet`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE `adresse` (
  `id_a` int(11) NOT NULL,
  `ville` varchar(255) NOT NULL,
  `rue` varchar(255) NOT NULL,
  `num_rue` int(11) NOT NULL,
  `code_postal` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

CREATE TABLE `formation` (
  `id_f` int(11) NOT NULL,
  `titre` varchar(255) NOT NULL,
  `duree` int(11) NOT NULL,
  `cout` int(11) NOT NULL,
  `date_debut` date NOT NULL,
  `nb_place` int(11) NOT NULL,
  `contenu` text NOT NULL,
  `lieu` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `formation`
--

INSERT INTO `formation` (`id_f`, `titre`, `duree`, `cout`, `date_debut`, `nb_place`, `contenu`, `lieu`, `image`) VALUES
(1, 'Canoë/Kayak', 5, 350, '2017-01-19', 20, 'Apprenez à réaliser des pages web en langages HTML et CSS de façon totalement autonome, sans éditeur ni tableaux de mise en page.', 'paris', 'html_css.png'),
(2, 'Canoë/Kayak', 4, 500, '2017-02-22', 15, 'Cours javascript complet', 'Lyon', 'kayak.jpg'),
(3, 'Parachute', 3, 600, '2017-03-23', 5, 'La PAC est la méthode moderne et rapide permettant de pratiquer le parachutisme, de découvrir la chute libre et d\'atteindre l\'autonomie en chute et parachute ouvert.\r\n\r\nLes moniteurs sont tous des professionnels diplômés d\'Etat ayant au minimum 1 500 sauts à leur actif.\r\nLa formation s\'effectue en principe sur une semaine. Attention vous serez dépendant de la météo, il est bien évident que pour des questions de sécurité personne ne saute quand il pleut ou que le vent est trop fort.', 'Montpellier', 'parachute.jpg'),
(4, 'Kitesurf', 3, 550, '2017-04-19', 8, 'Venez découvrir le kitesurf en Nord Pas de Calais. On vous encadre sur les meilleurs spots au cœur de la Côte d’Opale.\r\nVous apprécierez particulièrement la baie de Wissant pour son panorama unique, la plage d\'Equihen dans l\'enfilade vers Hardelot.', 'Nord pas de Calais', 'kitesurf.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `formation_suivi`
--

CREATE TABLE `formation_suivi` (
  `id_f` int(11) NOT NULL,
  `id_s` int(11) NOT NULL,
  `valide` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `formation_suivi`
--

INSERT INTO `formation_suivi` (`id_f`, `id_s`, `valide`) VALUES
(1, 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `prestation`
--

CREATE TABLE `prestation` (
  `id_p` int(11) NOT NULL,
  `raison_sociale` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `situer`
--

CREATE TABLE `situer` (
  `id_a` int(11) NOT NULL,
  `id_f` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `type_formation`
--

CREATE TABLE `type_formation` (
  `id_t` int(11) NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id_s` int(11) NOT NULL,
  `id_chef` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `identifiant` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `credit` int(11) NOT NULL,
  `nbr_jour` int(11) NOT NULL,
  `chef` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id_s`, `id_chef`, `nom`, `prenom`, `email`, `identifiant`, `mdp`, `credit`, `nbr_jour`, `chef`) VALUES
(1, 0, 'toto', 'titi', 'toto.titi@gmail.com', 'toto65', '1234', 5000, 15, 0),
(2, 0, 'cloarec', 'jeremy', 'cloarec.j95@gmail.com', 'jeje', '1234', 5000, 15, 1);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `adresse`
--
ALTER TABLE `adresse`
  ADD PRIMARY KEY (`id_a`);

--
-- Index pour la table `formation`
--
ALTER TABLE `formation`
  ADD PRIMARY KEY (`id_f`);

--
-- Index pour la table `formation_suivi`
--
ALTER TABLE `formation_suivi`
  ADD KEY `id_f` (`id_f`),
  ADD KEY `id_s` (`id_s`);

--
-- Index pour la table `prestation`
--
ALTER TABLE `prestation`
  ADD PRIMARY KEY (`id_p`);

--
-- Index pour la table `situer`
--
ALTER TABLE `situer`
  ADD KEY `id_a` (`id_a`),
  ADD KEY `id_f` (`id_f`);

--
-- Index pour la table `type_formation`
--
ALTER TABLE `type_formation`
  ADD PRIMARY KEY (`id_t`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_s`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `formation`
--
ALTER TABLE `formation`
  MODIFY `id_f` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id_s` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
