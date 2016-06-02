CREATE TABLE `pizza` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categorie` varchar(50) NOT NULL DEFAULT 'SANS_VIANDE',
  `code` varchar(3) DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prix` decimal(10,2) NOT NULL,
  `url_image` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_uwl42bkm53vnwm0ncklemrij` (`code`)
);