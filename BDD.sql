-- phpMyAdmin SQL Dump
-- version 4.9.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jun 04, 2020 at 02:41 PM
-- Server version: 5.7.26
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: Ok
--

-- --------------------------------------------------------

--
-- Table structure for table cours
--

CREATE TABLE cours (
  ID int(11) NOT NULL,
  NOM text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table cours
--

INSERT INTO cours (ID, NOM) VALUES
(1, 'Mathematiques'),
(2, 'Physique\r\n'),
(3, 'Electronique'),
(4, 'Informatique'),
(5, 'Anglais'),
(6, 'Théorie des graphes'),
(7, 'Analyse \r\n'),
(8, 'PSTE'),
(9, 'Arabe'),
(10, 'Droit du travail\r\n');

-- --------------------------------------------------------

--
-- Table structure for table enseignant
--

CREATE TABLE enseignant (
  ID_UTILISATEUR int(11) NOT NULL,
  ID_COURS int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table enseignant
--

INSERT INTO enseignant (ID_UTILISATEUR, ID_COURS) VALUES
(2, 1),
(3, 2),
(10, 3),
(11, 7),
(12, 1),
(13, 6),
(14, 5),
(15, 8),
(87, 9),
(88, 10);

-- --------------------------------------------------------

--
-- Table structure for table etudiant
--

CREATE TABLE etudiant (
  ID_UTILISATEUR int(11) NOT NULL,
  NUMERO text NOT NULL,
  ID_GROUPE int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table etudiant
--

INSERT INTO etudiant (ID_UTILISATEUR, NUMERO, ID_GROUPE) VALUES
(1, '1', 1),
(4, '4', 1),
(5, '5', 1),
(6, '6', 1),
(7, '7', 1),
(8, '8', 2),
(9, '9', 2),
(17, '17', 2),
(18, '18', 2),
(19, '19', 2),
(19, '19', 3),
(20, '20', 3),
(21, '21', 3),
(22, '22', 3),
(23, '23', 3),
(26, '26', 4),
(27, '27', 4),
(28, '28', 4),
(29, '29', 4),
(30, '30', 4),
(31, '31', 5),
(32, '32', 5),
(33, '33', 5),
(34, '34', 5),
(35, '35', 5),
(36, '36', 6),
(37, '37', 6),
(38, '38', 6),
(39, '39', 6),
(40, '40', 6),
(41, '41', 7),
(42, '42', 7),
(43, '43', 7),
(44, '44', 7),
(45, '45', 7),
(46, '46', 8),
(47, '47', 8),
(48, '48', 8),
(49, '49', 8),
(50, '50', 8),
(51, '51', 9),
(52, '52', 9),
(53, '53', 9),
(54, '54', 9),
(55, '55', 9),
(56, '56', 10),
(57, '57', 10),
(58, '58', 10),
(62, '62', 10),
(61, '61', 10),
(59, '59', 11),
(60, '60', 11),
(63, '63', 11),
(64, '64', 11),
(65, '65', 11),
(66, '66', 12),
(67, '67', 12),
(68, '68', 12),
(69, '69', 12),
(70, '70', 12),
(71, '71', 13),
(72, '72', 13),
(73, '73', 13),
(74, '74', 13),
(75, '75', 13),
(76, '76', 14),
(77, '77', 14),
(78, '78', 14),
(79, '79', 14),
(80, '80', 14),
(81, '81', 15),
(82, '82', 15),
(83, '83', 15),
(84, '84', 15),
(85, '85', 15);

-- --------------------------------------------------------

--
-- Table structure for table groupe
--

CREATE TABLE groupe (
  ID int(11) NOT NULL,
  NOM text NOT NULL,
  ID_PROMOTION int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table groupe
--

INSERT INTO groupe (ID, NOM, ID_PROMOTION) VALUES
(1, 'TD 1', 1),
(2, 'TD 2', 1),
(3, 'TD 3', 1),
(4, 'TD 1', 2),
(5, 'TD 2', 2),
(6, 'TD 3', 2),
(7, 'TD 1', 3),
(8, 'TD 2', 3),
(9, 'TD 3', 3),
(10, 'TD 1', 4),
(11, 'TD 2', 4),
(12, 'TD 3', 4),
(13, 'TD 1', 5),
(14, 'TD 2', 5),
(15, 'TD 3', 5);

-- --------------------------------------------------------

--
-- Table structure for table promotion
--

CREATE TABLE promotion (
  ID int(11) NOT NULL,
  NOM text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table promotion
--

INSERT INTO promotion (ID, NOM) VALUES
(1, 'Promo 2022'),
(2, 'Promo 2023'),
(3, 'Promo 2024'),
(4, 'Promo 2025'),
(5, 'Promo 2026');

-- --------------------------------------------------------

--
-- Table structure for table salle
--

CREATE TABLE salle (
  ID int(11) NOT NULL,
  NOM text NOT NULL,
  CAPACITE int(11) NOT NULL,
  ID_SITE int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table salle
--

INSERT INTO salle (ID, NOM, CAPACITE, ID_SITE) VALUES
(1, 'Salle 201', 60, 1),
(2, 'Salle 206', 50, 1),
(3, 'Salle 207', 70, 1),
(4, 'Salle 208', 60, 1),
(5, 'Salle 311', 75, 1),
(6, 'Salle 302', 40, 1),
(7, 'Salle 304\r\n', 50, 1),
(8, 'Salle 304', 75, 2),
(9, 'Salle 305', 75, 2),
(10, 'Salle 315', 25, 2),
(11, 'Salle 405', 75, 2),
(12, 'Salle 440', 70, 2),
(13, 'Salle 445', 70, 2),
(14, 'Sc 105', 40, 3),
(15, 'Sc 208', 40, 3),
(16, 'EM 09', 40, 3),
(17, 'EM 07', 50, 3),
(18, 'EM 08', 150, 3),
(19, 'EM 312', 40, 3),
(20, 'EM 315', 40, 3),
(21, 'SC 318', 40, 3),
(22, 'CNAM AMPHITHEATRE', 150, 6);

-- --------------------------------------------------------

--
-- Table structure for table seance
--

CREATE TABLE seance (
  ID int(11) NOT NULL,
  SEMAINE int(11) NOT NULL,
  DATE date NOT NULL,
  HEURE_DEBUT time NOT NULL,
  HEURE_FIN time NOT NULL,
  ETAT int(11) NOT NULL,
  ID_COURS int(11) NOT NULL,
  ID_TYPE int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table seance
--

INSERT INTO seance (ID, SEMAINE, DATE, HEURE_DEBUT, HEURE_FIN, ETAT, ID_COURS, ID_TYPE) VALUES
(1, 23, '2020-06-01', '08:00:00', '10:00:00', 0, 1, 1),
(2, 23, '2020-06-01', '11:00:00', '13:00:00', 0, 2, 1),
(3, 23, '2020-06-01', '15:00:00', '17:00:00', 0, 3, 1),
(4, 23, '2020-06-01', '17:30:00', '19:00:00', 0, 4, 1),
(5, 23, '2020-06-02', '08:00:00', '10:00:00', 0, 5, 1),
(6, 23, '2020-06-02', '13:00:00', '15:00:00', 0, 6, 1),
(7, 23, '2020-06-03', '09:00:00', '11:00:00', 0, 2, 1),
(8, 23, '2020-06-03', '13:00:00', '15:00:00', 0, 8, 1),
(9, 23, '2020-06-03', '17:00:00', '19:00:00', 0, 10, 1),
(10, 23, '2020-06-04', '10:00:00', '12:00:00', 0, 1, 2),
(11, 23, '2020-06-04', '17:00:00', '19:00:00', 0, 3, 3),
(12, 23, '2020-06-05', '09:00:00', '11:00:00', 0, 9, 1),
(13, 23, '2020-06-05', '13:00:00', '15:00:00', 0, 6, 1),
(14, 23, '2020-06-05', '16:00:00', '17:00:00', 0, 7, 1),
(15, 23, '2020-06-01', '08:00:00', '10:00:00', 0, 2, 1),
(16, 23, '2020-06-01', '11:00:00', '13:00:00', 0, 1, 1),
(17, 23, '2020-06-01', '15:00:00', '17:00:00', 0, 4, 1),
(18, 23, '2020-06-01', '17:30:00', '19:00:00', 0, 3, 1),
(19, 23, '2020-06-02', '08:00:00', '10:00:00', 0, 6, 1),
(20, 23, '2020-06-02', '13:00:00', '15:00:00', 0, 5, 1),
(21, 23, '2020-06-03', '09:00:00', '11:00:00', 0, 8, 1),
(22, 23, '2020-06-03', '13:00:00', '15:00:00', 0, 2, 1),
(23, 23, '2020-06-03', '17:00:00', '19:00:00', 0, 1, 1),
(24, 23, '2020-06-04', '10:00:00', '12:00:00', 0, 10, 2),
(25, 23, '2020-06-04', '17:00:00', '19:00:00', 0, 9, 3),
(26, 23, '2020-06-05', '09:00:00', '11:00:00', 0, 3, 1),
(27, 23, '2020-06-05', '13:00:00', '15:00:00', 0, 7, 1),
(28, 23, '2020-06-05', '16:00:00', '17:00:00', 0, 6, 1),
(29, 23, '2020-06-01', '08:00:00', '10:00:00', 0, 6, 1),
(30, 23, '2020-06-01', '11:00:00', '13:00:00', 0, 7, 1),
(31, 23, '2020-06-01', '15:00:00', '17:00:00', 0, 9, 1),
(32, 23, '2020-06-01', '17:30:00', '19:00:00', 0, 8, 1),
(33, 23, '2020-06-02', '08:00:00', '10:00:00', 0, 1, 1),
(34, 23, '2020-06-02', '13:00:00', '15:00:00', 0, 2, 1),
(35, 23, '2020-06-03', '09:00:00', '11:00:00', 0, 10, 1),
(36, 23, '2020-06-03', '13:00:00', '15:00:00', 0, 1, 1),
(37, 23, '2020-06-03', '17:00:00', '19:00:00', 0, 9, 1),
(38, 23, '2020-06-04', '10:00:00', '12:00:00', 0, 3, 2),
(39, 23, '2020-06-04', '17:00:00', '19:00:00', 0, 7, 3),
(40, 23, '2020-06-05', '09:00:00', '11:00:00', 0, 6, 1),
(41, 23, '2020-06-05', '13:00:00', '15:00:00', 0, 3, 1),
(42, 23, '2020-06-05', '16:00:00', '17:00:00', 0, 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table seance_enseignants
--

CREATE TABLE seance_enseignants (
  ID_SEANCE int(11) NOT NULL,
  ID_ENSEIGNANT int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table seance_enseignants
--

INSERT INTO seance_enseignants (ID_SEANCE, ID_ENSEIGNANT) VALUES
(1, 1),
(2, 2),
(3, 10),
(4, 13),
(5, 14),
(6, 13),
(7, 3),
(8, 15),
(9, 88),
(10, 2),
(11, 10),
(12, 87),
(13, 13),
(14, 11),
(15, 3),
(16, 2),
(17, 13),
(18, 10),
(19, 13),
(20, 14),
(21, 15),
(22, 3),
(23, 2),
(24, 88),
(25, 87),
(26, 10),
(27, 11),
(28, 13),
(29, 13),
(30, 11),
(31, 87),
(32, 15),
(33, 2),
(34, 3),
(35, 88),
(36, 2),
(37, 87),
(38, 10),
(39, 11),
(40, 13),
(41, 10),
(42, 13);

-- --------------------------------------------------------

--
-- Table structure for table seance_groupes
--

CREATE TABLE seance_groupes (
  ID_SEANCE int(11) NOT NULL,
  ID_GROUPE int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table seance_groupes
--

INSERT INTO seance_groupes (ID_SEANCE, ID_GROUPE) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(11, 1),
(12, 1),
(13, 1),
(14, 1),
(15, 2),
(16, 3),
(17, 4),
(18, 5),
(19, 6),
(20, 7),
(21, 8),
(22, 9),
(23, 10),
(24, 11),
(25, 12),
(26, 13),
(27, 14),
(28, 15),
(29, 2),
(30, 3),
(31, 4),
(32, 5),
(33, 6),
(34, 7),
(35, 8),
(36, 9),
(37, 10),
(38, 11),
(39, 12),
(40, 13),
(41, 14),
(42, 15);

-- --------------------------------------------------------

--
-- Table structure for table seance_salles
--

CREATE TABLE seance_salles (
  ID_SEANCE int(11) NOT NULL,
  ID_SALLE int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table seance_salles
--

INSERT INTO seance_salles (ID_SEANCE, ID_SALLE) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(5, 3),
(6, 3),
(7, 4),
(8, 4),
(9, 5),
(10, 5),
(11, 6),
(12, 6),
(13, 7),
(14, 7),
(15, 8),
(16, 9),
(17, 9),
(18, 10),
(19, 10),
(20, 11),
(21, 11),
(22, 12),
(23, 12),
(24, 13),
(25, 13),
(26, 14),
(27, 14),
(28, 15),
(29, 15),
(30, 16),
(31, 16),
(32, 17),
(33, 17),
(34, 18),
(35, 18),
(36, 19),
(37, 19),
(38, 20),
(39, 20),
(40, 21),
(41, 21),
(42, 22);

-- --------------------------------------------------------

--
-- Table structure for table site
--

CREATE TABLE site (
  ID int(11) NOT NULL,
  NOM text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table site
--

INSERT INTO site (ID, NOM) VALUES
(1, 'Eiffel 3\r\n'),
(2, 'Eiffel 2'),
(3, 'Eiffel 1\r\n\r\n'),
(4, 'Eiffel 4'),
(5, 'Eiffel 5'),
(6, 'Cnam');

-- --------------------------------------------------------

--
-- Table structure for table type_cours
--

CREATE TABLE type_cours (
  ID int(11) NOT NULL,
  NOM text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table type_cours
--

INSERT INTO type_cours (ID, NOM) VALUES
(1, 'COURS'),
(2, 'TD'),
(3, 'EXAMEN');

-- --------------------------------------------------------

--
-- Table structure for table utilisateur
--

CREATE TABLE utilisateur (
  ID int(11) NOT NULL,
  EMAIL text NOT NULL,
  PASSWD text NOT NULL,
  NOM text NOT NULL,
  PRENOM text NOT NULL,
  DROIT int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table utilisateur
--

INSERT INTO utilisateur (ID, EMAIL, PASSWD, NOM, PRENOM, DROIT) VALUES
(1, 'vivien.detournay@edu.ece.fr', 'vivien', 'DETOURNAY', 'Vivien', 4),
(2, 'fabienne.coudray@edu.ece.fr', 'fabienne', 'COUDRAY', 'Fabienne', 2),
(3, 'm.richaud@edu.ece.fr', 'm', 'RICHAUD', 'M', 3),
(4, 'baptiste.rondard@edu.ece.fr', 'br2007', 'RONDARD', 'Baptiste', 4),
(5, 'clemency.jldm@edu.ece.fr', 'cl2090', 'JLDM', 'Clemence', 4),
(6, 'larys.quistin@edu.ece.fr', 'larys233', 'QUISTIN', 'Larys', 4),
(7, 'robin.labrot@edu.ece.fr', 'lieeeeee', 'LABROT', 'Robin', 4),
(8, 'Evan.kermorgant@edu.ece.fr', 'kermorgant', 'KERMORGANT', 'Evan', 4),
(9, 'ramzy.mouhtadi@edu.ece.fr', 'ramzy998', 'MOUHTADI', 'Ramzy', 4),
(10, 'mokhber@edu.ece.fr', 'mokhberrrr', 'MOKHBER', 'A', 3),
(11, 'laurent.delisle@edu.ece.fr', 'okokok', 'DELISLE', 'Laurent', 3),
(12, 'luc.lecor@edu.ece.fr', 'lecorlecor', 'LE COR', 'Luc', 3),
(13, 'elisabeth.rendler@edu.ece.fr', 'mdprendler', 'RENDLER', 'Elisabeth', 3),
(14, 'James.reese@edu.ece.fr', 'reeseatl', 'REESE', 'James', 3),
(15, 'djoudi@edu.ece.fr', 'djoudi', 'DJOUDI', 'Aghiles', 3),
(16, 'Angelique.petillon@edu.ece.fr', 'petillon87', 'PETILLON', 'Angelique', 2),
(17, 'Thibault.devin@edu.ece.fr', 'eduece', 'DEVIN', 'Thibaut', 4),
(18, 'olivier.gomes@edu.ece.fr', 'doitit', 'GOMES', 'Olivier', 4),
(19, 'maylinh.grand@edu.ece.fr', 'maylinh', 'GRAND', 'Mailinh', 4),
(20, 'Tim.dubois@edu.ece.fr', 'Tim', 'BOIS', 'Timothy', 4),
(21, 'marine.m@edu.ece.fr', 'marine', 'MMM', 'Marine', 4),
(22, 'Charles.pyrex@edu.ece.fr', 'pyrex', 'PYREX', 'Charles', 4),
(23, 'Cam.laruel@edu.ece.fr', 'laruellll', 'LARUEL', 'Camille', 4),
(24, 'rania.laouar@edu.ece.fr', 'laouar3', 'LAOUAR', 'Rania', 4),
(25, 'dany.tdrs@edu.ece.fr', 'tdrs122', 'TDRS', 'Dany', 4),
(26, 'Colin.ferret@edu.ece.fr', 'ferrets', 'FERRET', 'Colin', 4),
(27, 'Celia.chaouat@edu.ece.fr', 'celia', 'CHAOUAT', 'Celia', 4),
(28, 'simon.zhang@edu.ece.fr', 'zhang22', 'ZHANG', 'Simon', 4),
(29, 'justine.reynaud@edu.ece.fr', 'reynaud', 'REYNAUD', 'Justine', 4),
(30, 'jasmine.malan@edu.ece.fr', 'malan23', 'MALAN', 'Jasmine', 4),
(31, 'Elia.levy@edu.ece.Fr', 'elielia', 'LEVY', 'Elia', 4),
(32, 'valentin.boucher@edu.ece.fr', 'boucher', 'BOUCHER', 'Valentin', 4),
(33, 'Axel.hunter@edu.ece.fr', 'hunterjuicy', 'HUNTER', 'Axel', 4),
(34, 'Riyad.liyaa@edu.ece.fr', 'liyaa', 'LIYAA', 'Riyad', 4),
(35, 'illyas.elg@edu.ece.fr', 'elg12', 'ELG', 'Illyas', 4),
(36, 'Sovann.quaglieri@edu.ece.fr', 'sovann8', 'QUAGLIERI', 'Sovann', 4),
(37, 'carl.badaoui@edu.ece.fr', 'badoui8', 'BADAOUI', 'Carl', 4),
(38, 'louishenrioulat@edu.ece.fr', 'oulatkart', 'OULAT', 'Louis Henri', 4),
(39, 'lea.guignochaud@edu.ece.fr', 'leagui', 'GUIGNOCHAUD', 'Lea', 4),
(40, 'anneclaire.laisney@edu.ece.fr', 'dubai', 'LAISNEY', 'Anne Claire', 4),
(41, 'Antoine.rossi@edu.ece.fr', 'monaco', 'ROSSI', 'Antoine', 4),
(42, 'Quentin.bonnard@edu.ece.fr', 'RS3', 'BONNARD', 'Quentin', 4),
(43, 'dominik.carbon@edu.ece.fr', 'Dom', 'CARBON', 'Dominik', 4),
(44, 'meriem.dhiab@edu.ece.fr', 'london', 'DHIAB', 'Meriem', 4),
(45, 'rayan.perrin@edu.ece.fr', 'perrin', 'PERRIN', 'Rayan', 4),
(46, 'matthias.nguyen@edu.ece.fr', 'appen2', 'NGUYEN', 'Matthias', 4),
(47, 'jean.bellet@edu.ece.fr', 'natation', 'BELLET', 'Jean', 4),
(48, 'tanguy.couffon@edu.ece.fr', 'macmahon', 'COUFFON', 'Tanguy', 4),
(49, 'Alex.touze@edu.ece.fr', 'touze', 'TOUZE', 'Alex', 4),
(50, 'Etienne.tourillon@edu.ece.fr', 'esiee', 'TOURILLON', 'Etienne', 4),
(51, 'Alex.gabis@edu.ece.fr', 'toronto', 'GABIS', 'Alex', 4),
(52, 'Hugo.guenand@edu.ece.fr', 'tours', 'GUENAND', 'Hugo', 4),
(53, 'Matteo.gamby@edu.ece.fr', 'gambyparis', 'GAMBY', 'Matteo', 4),
(54, 'tanguy.dubois@edu.ece.fr', 'parisparis', 'DUBOIS', 'Tanguy', 4),
(55, 'Ahmad.sow@edu.ece.fr', 'password', 'SOW', 'Ahmad', 4),
(56, 'Thomas.dangas@edu.ece.fr', 'hongkong', 'DANGAS', 'Thomas', 4),
(57, 'Lucille.villa@edu.ece.fr', 'arabianranches', 'VILLA', 'Lucille', 4),
(58, 'Ralph.charaf@edu.ece.fr', 'california', 'CHARAF', 'Ralph', 4),
(59, 'rose.barbier@edu.ece.fr', 'barbier', 'BARBIER', 'Rose', 4),
(60, 'yann.tawamba@edu.ece.fr', 'londonlondon', 'TAWAMBA', 'Yann', 4),
(61, 'nabil.zok@edu.ece.fr', 'ZOKZOK', 'ZOK', 'Nabil', 4),
(62, 'gaia.rondard@edu.ece.fr', 'rondard2', 'RONDARD', 'Gaia', 4),
(63, 'rassem.zok@edu.ece.fr', 'rassemzok', 'ZOK', 'Rassem', 4),
(64, 'jad.elhoss@edu.ece.fr', 'elhoss', 'EL HOSS', 'Jad', 4),
(65, 'Amaury.nordin@edu.ece.fr', 'nordine', 'NORDIN', 'Amaury', 4),
(66, 'Youssef.tantawi@edu.ece.fr', 'tantaw', 'TANTAWI', 'Youssef', 4),
(67, 'Charles.costes@edu.ece.fr', 'costes23', 'COSTES', 'Charles', 4),
(68, 'Lisa.paitschin@edu.ece.fr', 'paitschinece', 'PAITSCHIN', 'Lisa', 4),
(69, 'Emma.lucas@edu.ece.fr', 'password1', 'LUCAS', 'Emma', 4),
(70, 'Henri.georges@edu.ece.fr', 'georgeshenri', 'GEORGES', 'Henri', 4),
(71, 'Rachel.assaker@edu.ece.fr', 'finance', 'ASSAKER', 'Rachel', 4),
(72, 'jawad.korkomaz@edu.ece.fr', 'lfigp', 'KORKOMAZ', 'Jawad', 4),
(73, 'Alexandre.denis@edu.ece.fr', 'lgpdubai', 'DENIS', 'Alexandre', 4),
(74, 'Paul.coutiere@edu.ece.fr', 'coutierelfigp', 'COUTIERE', 'Paul', 4),
(75, 'Charles.duthu@edu.Ece.fr', 'duthudubai', 'DUTHU', 'Charles', 4),
(76, 'mathilde.lefftz@edu.ece.fr', 'allemagne', 'LEFFTZ', 'Mathilde', 4),
(77, 'Gabriel.attal@edu.ece.fr', 'attalece', 'ATTAL', 'Gabriel', 4),
(78, 'thibault.dangas@edu.ece.fr', 'dangaslfigp', 'DANGAS', 'Thibault', 4),
(79, 'Hugo.klmn@edu.ece.fr', 'chanel', 'KLMN', 'Hugo', 4),
(80, 'yahya.beto@edu.ece.fr', 'BETO', 'BETO', 'Yahya', 4),
(81, 'Brandon.anoh@edu.ece.fr', 'anohanoh', 'ANOH', 'Brandon', 4),
(82, 'Hugo.praet@edu.ece.fr', 'praet', 'PRAET', 'Hugo', 4),
(83, 'karim.nahas@edu.ece.fr', 'nahasece', 'NAHAS', 'Karim', 4),
(84, 'Miriam.benallou@edu.ece.fr', 'mimi', 'BENALLOU', 'Miriam', 4),
(85, 'Omar.taha@edu.ece.fe', 'tahaomar', 'TAHA', 'Omar', 4),
(86, 'administrateur@edu.ece.fr', 'admin', 'ADMIN', 'Admin', 1),
(87, 'maupile@edu.ece.fr', 'maupile', 'MAUPILE', 'M', 3),
(88, 'benhassan@edu.ece.fr', 'benhassan', 'BENHASSAN', 'F', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table cours
--
ALTER TABLE cours
  ADD PRIMARY KEY (ID);

--
-- Indexes for table enseignant
--
ALTER TABLE enseignant
  ADD PRIMARY KEY (ID_UTILISATEUR,`ID_COURS`);

--
-- Indexes for table groupe
--
ALTER TABLE groupe
  ADD PRIMARY KEY (ID);

--
-- Indexes for table promotion
--
ALTER TABLE promotion
  ADD PRIMARY KEY (ID);

--
-- Indexes for table salle
--
ALTER TABLE salle
  ADD PRIMARY KEY (ID);

--
-- Indexes for table seance
--
ALTER TABLE seance
  ADD PRIMARY KEY (ID);

--
-- Indexes for table seance_enseignants
--
ALTER TABLE seance_enseignants
  ADD PRIMARY KEY (ID_SEANCE);

--
-- Indexes for table seance_groupes
--
ALTER TABLE seance_groupes
  ADD PRIMARY KEY (ID_SEANCE);

--
-- Indexes for table seance_salles
--
ALTER TABLE seance_salles
  ADD PRIMARY KEY (ID_SEANCE);

--
-- Indexes for table site
--
ALTER TABLE site
  ADD PRIMARY KEY (ID);

--
-- Indexes for table type_cours
--
ALTER TABLE type_cours
  ADD PRIMARY KEY (ID);

--
-- Indexes for table utilisateur
--
ALTER TABLE utilisateur
  ADD PRIMARY KEY (ID);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table cours
--
ALTER TABLE cours
  MODIFY ID int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table groupe
--
ALTER TABLE groupe
  MODIFY ID int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table promotion
--
ALTER TABLE promotion
  MODIFY ID int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table salle
--
ALTER TABLE salle
  MODIFY ID int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table seance
--
ALTER TABLE seance
  MODIFY ID int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table site
--
ALTER TABLE site
  MODIFY ID int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table type_cours
--
ALTER TABLE type_cours
  MODIFY ID int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table utilisateur
--
ALTER TABLE utilisateur
  MODIFY ID int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=89;