CREATE TABLE `pizza` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categorie` varchar(50) NOT NULL DEFAULT 'SANS_VIANDE', -- remarque: utilise varchar, car H2 ne reconnait pas le type enum
  `code` varchar(3) DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prix` decimal(10,2) NOT NULL,
  `url_image` varchar(500) DEFAULT NULL

);