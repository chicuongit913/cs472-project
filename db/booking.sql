DROP TABLE IF EXISTS `booking`;

CREATE TABLE `booking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roomNumber` varchar(255) DEFAULT NULL,
  `guestID` varchar(255) DEFAULT NULL,
  `checkIn` DATETIME DEFAULT NULL,
  `checkOut` DATETIME DEFAULT NULL,
  `numberOfNight` int(11) DEFAULT NULL,
  `totalPrice` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;