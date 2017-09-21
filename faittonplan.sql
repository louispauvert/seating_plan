-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 21 Septembre 2017 à 08:48
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `faittonplan`
--

-- --------------------------------------------------------

--
-- Structure de la table `avoir`
--

CREATE TABLE `avoir` (
  `id_plan` int(8) NOT NULL,
  `id_bureau` int(8) NOT NULL,
  `abs` int(4) NOT NULL,
  `ord` int(4) NOT NULL,
  `sens` binary(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `batiment`
--

CREATE TABLE `batiment` (
  `id` int(8) NOT NULL,
  `libelle` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `batiment`
--

INSERT INTO `batiment` (`id`, `libelle`) VALUES
(1, 'batiment 1'),
(2, 'test'),
(4, 'testo'),
(5, 'testo'),
(6, 'test5'),
(7, 'test5'),
(8, 'test5');

-- --------------------------------------------------------

--
-- Structure de la table `bureau`
--

CREATE TABLE `bureau` (
  `id` int(8) NOT NULL,
  `id_collab` int(8) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `bureau`
--

INSERT INTO `bureau` (`id`, `id_collab`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `collaborateur`
--

CREATE TABLE `collaborateur` (
  `id` int(8) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `date_arrive` date DEFAULT NULL,
  `date_depart` date DEFAULT NULL,
  `email` varchar(150) NOT NULL,
  `mdp` varchar(128) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `collaborateur`
--

INSERT INTO `collaborateur` (`id`, `nom`, `prenom`, `date_arrive`, `date_depart`, `email`, `mdp`) VALUES
(1, 'pauvert', 'louis', NULL, NULL, 'pauvert.louis@gmail.com', NULL),
(2, 'secly', 'eliott', NULL, NULL, 'eliott.secly@viacesi.fr', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `contenir`
--

CREATE TABLE `contenir` (
  `id_bureau` int(8) NOT NULL,
  `id_four` int(8) NOT NULL,
  `num_interne` int(10) DEFAULT NULL,
  `num_externe` int(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `contenir`
--

INSERT INTO `contenir` (`id_bureau`, `id_four`, `num_interne`, `num_externe`) VALUES
(1, 1, 3301, 316245268),
(2, 6, 3301, 325696854),
(1, 3, NULL, NULL),
(1, 4, NULL, NULL),
(1, 2, NULL, NULL),
(2, 5, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `etage`
--

CREATE TABLE `etage` (
  `id` int(8) NOT NULL,
  `libelle` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `materiel`
--

CREATE TABLE `materiel` (
  `id` int(8) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  `id_type` int(8) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `materiel`
--

INSERT INTO `materiel` (`id`, `libelle`, `id_type`) VALUES
(1, 'telephone fixe', 1),
(2, 'pc', 2),
(3, 'crayon bleu', 3),
(4, 'crayon rouge', 3),
(5, 'pc', 2),
(6, 'telephone', 1);

-- --------------------------------------------------------

--
-- Structure de la table `partie`
--

CREATE TABLE `partie` (
  `id` int(8) NOT NULL,
  `libelle` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `plan`
--

CREATE TABLE `plan` (
  `id` int(8) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  `version` int(3) NOT NULL DEFAULT '1'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

CREATE TABLE `type` (
  `id` int(8) NOT NULL,
  `libelle` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `type`
--

INSERT INTO `type` (`id`, `libelle`) VALUES
(1, 'telephone'),
(2, 'pc'),
(3, 'crayon');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `avoir`
--
ALTER TABLE `avoir`
  ADD PRIMARY KEY (`id_plan`,`id_bureau`),
  ADD KEY `Avoir_fk1` (`id_bureau`);

--
-- Index pour la table `batiment`
--
ALTER TABLE `batiment`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `bureau`
--
ALTER TABLE `bureau`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Bureau_fk0` (`id_collab`);

--
-- Index pour la table `collaborateur`
--
ALTER TABLE `collaborateur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `contenir`
--
ALTER TABLE `contenir`
  ADD PRIMARY KEY (`id_bureau`,`id_four`),
  ADD KEY `Contenir_fk1` (`id_four`);

--
-- Index pour la table `etage`
--
ALTER TABLE `etage`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `materiel`
--
ALTER TABLE `materiel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Materiel_fk0` (`id_type`);

--
-- Index pour la table `partie`
--
ALTER TABLE `partie`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `plan`
--
ALTER TABLE `plan`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `batiment`
--
ALTER TABLE `batiment`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `bureau`
--
ALTER TABLE `bureau`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `collaborateur`
--
ALTER TABLE `collaborateur`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `etage`
--
ALTER TABLE `etage`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `materiel`
--
ALTER TABLE `materiel`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `partie`
--
ALTER TABLE `partie`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `plan`
--
ALTER TABLE `plan`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `type`
--
ALTER TABLE `type`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
