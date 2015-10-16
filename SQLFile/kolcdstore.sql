/*
Navicat MySQL Data Transfer

Source Server         : Michelle
Source Server Version : 50517
Source Host           : localhost:3306
Source Database       : kolcdstore

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2015-10-16 10:31:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `addrid` bigint(20) NOT NULL AUTO_INCREMENT,
  `addrline1` varchar(255) DEFAULT NULL,
  `addrline2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `province` varchar(255) NOT NULL,
  `zipcode` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL DEFAULT 'Canada',
  `phone` varchar(255) NOT NULL,
  `userid` bigint(20) NOT NULL,
  PRIMARY KEY (`addrid`),
  KEY `userid` (`userid`),
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `customer` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------

-- ----------------------------
-- Table structure for `bill`
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `billid` bigint(20) NOT NULL AUTO_INCREMENT,
  `Addrline1` varchar(255) NOT NULL,
  `Addrline2` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `province` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL DEFAULT '',
  `zipcode` varchar(255) NOT NULL,
  `userid` bigint(20) NOT NULL,
  PRIMARY KEY (`billid`),
  KEY `customer` (`userid`),
  CONSTRAINT `customer` FOREIGN KEY (`userid`) REFERENCES `customer` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bill
-- ----------------------------

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cateid` bigint(20) NOT NULL AUTO_INCREMENT,
  `catename` varchar(255) NOT NULL,
  PRIMARY KEY (`cateid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'Pop');
INSERT INTO `category` VALUES ('2', 'Jazz');
INSERT INTO `category` VALUES ('3', 'Country');
INSERT INTO `category` VALUES ('4', 'Blues');
INSERT INTO `category` VALUES ('5', 'Hip-Hop');
INSERT INTO `category` VALUES ('6', 'Rock');
INSERT INTO `category` VALUES ('7', 'Dance');
INSERT INTO `category` VALUES ('8', 'R&B');

-- ----------------------------
-- Table structure for `cd`
-- ----------------------------
DROP TABLE IF EXISTS `cd`;
CREATE TABLE `cd` (
  `cdid` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `artist` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `intro` text,
  `price` float NOT NULL,
  `stock` int(11) NOT NULL,
  `imgurl` varchar(255) NOT NULL,
  `cateid` bigint(20) NOT NULL,
  PRIMARY KEY (`cdid`),
  KEY `cateid` (`cateid`),
  CONSTRAINT `cateid` FOREIGN KEY (`cateid`) REFERENCES `category` (`cateid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cd
-- ----------------------------
INSERT INTO `cd` VALUES ('1', 'revival', 'Selena Gomez', '2015-10-09', 'Revival is the second solo studio album by American singer Selena Gomez. It was released on October 9, 2015, through Interscope and Polydor Records as a follow-up to Stars Dance (2013). It is her first project released under her new recording contract with the labels, after completing her contractual obligations with previous label, Hollywood Records, with the compilation album For You and the single \"The Heart Wants What It Wants\", in 2014. Gomez has cited artists such as Janet Jackson and Christina Aguilera as influences on the record, which has been described as a mixture of pop and electronic, and features lyrical themes of love, heartbreak, and confidence.', '49', '28', 'images/cdcover/1.png', '1');
INSERT INTO `cd` VALUES ('2', 'hands of love', 'Miley Cyrus', '2015-09-16', 'This is miley cyrus first album to love.', '46', '15', 'images/cdcover/c2.jpg', '1');
INSERT INTO `cd` VALUES ('3', 'STORYTELLER', 'Carrier Underwood', '2015-10-23', 'For this album Underwood worked with frequent collaborators such as Hillary Lindsey, Ashley Gorley, Chris DeStefano, David Hodges, Brett James. and Mark Bright, however Underwood also worked with new collaborators such as Liz Rose, Zach Crowell, and Jay Joyce.[5] Joyce produced the albums lead single \"Smoke Break\", the song was written by Underwood, Chris DeStefano and Hillary Lindsay and was inspired by their experience during the recording, when writing the album the songwriters kept taking breaks because they were stuck on one of the albums tracks \"were writing and kept taking breaks to go outside because we were getting a little stuck on a song we were already working on. It was so beautiful outside that we had a hard time focusing, so we decided to write a song about taking breaks! \'Smoke Break\' seemed like a great title, so we ran with it!\".', '58', '10', 'images/cdcover/c3.jpg', '3');
INSERT INTO `cd` VALUES ('4', 'MUSIC TO WATCH BOYS TO', 'Lana Del Rey', '2015-09-11', 'Del Rey first mentioned the song as a potential title for the whole album in late June 2014. On January 2, 2015, Del Rey opened up a little more on the song, elaborating on how she wrote it in a visual, noirish way saying \"the title (of the song) lends itself to a visual of shadows of men passing by, this girl\'s eyes, her face. I can definitely see things.\"[1] The song was originally eyed as the lead single for the album.', '32', '38', 'images/cdcover/c4.jpg', '2');
INSERT INTO `cd` VALUES ('5', 'THE HILLS', 'The Weekends', '2015-05-27', '\"The Hills\" received positive reviews for its return to form for the singer after his pop-oriented \"Earned It\", and was a commercial success. In the singer\'s native Canada, the song peaked at number 5. In the United States, it reached number 1 on the Billboard Hot 100, replacing his own \"Can\'t Feel My Face\", which was released later. The song also made the top 20 in Australia, Denmark, Ireland, and Sweden while reaching the top 40 in the Netherlands, New Zealand, Norway, Switzerland, and United Kingdom. At the height of the song\'s popularity, two remixes featuring rappers Eminem and Nicki Minaj were released.', '19', '29', 'images/cdcover/c5.jpg', '8');
INSERT INTO `cd` VALUES ('6', '1989', 'Taylor Swift', '2014-10-27', '1989 is the fifth studio album by American singer-songwriter Taylor Swift. It was released on October 27, 2014, through Big Machine Records. Swift began preparing for the album during the same year that Red was released, and during a significant amount of media scrutiny. Over the course of the two-year songwriting period, she primarily collaborated with producers Max Martin and Shellback—Martin served as the album\'s executive producer alongside Swift. The album\'s title was inspired by the pop-music scene of the 1980s, particularly Swift\'s birth year.', '45', '58', 'images/cdcover/2-.jpg', '1');
INSERT INTO `cd` VALUES ('7', 'WHAT DO YOU MEAN?', 'Justin Bibber', '2015-07-28', '\"What Do You Mean?\" is a song recorded by Canadian singer Justin Bieber for his upcoming fourth studio album Purpose. The song was announced on July 28, 2015, on On Air with Ryan Seacrest, and released on August 28, 2015, as the album\'s lead single.[2] It was well received by music critics. The track was also a commercial success, it topped the charts in 17 countries and became Bieber\'s first number one single on the US Billboard Hot 100 for a single week, debuting in the position with first-week sales of 337,000 copies.', '48', '18', 'images/cdcover/c6.jpg', '4');
INSERT INTO `cd` VALUES ('8', 'HOTLINE BLING', 'Dreke', '2015-07-31', '\"Hotline Bling\" is a song by Canadian hip hop recording artist Drake, released as a single digitally on July 31, 2015.[1] Produced by Nineteen85, the song\'s instrumental heavily samples R&B singer Timmy Thomas\' 1972 song \"Why Can\'t We Live Together\".[2] The song is going to act as the lead single to Drake\'s upcoming fourth studio album Views from the 6. Upon release, it received various comparisons to \"Cha Cha\" by American rapper D.R.A.M., which Drake had expressed interest in remixing, with Rap-Up calling it a \"quasi-cover\" of D.R.A.M.\'s song.[3] Drake leaked the song along with \"Back to Back\" on his blog. The song has been covered by English DJ duo Disclosure and English recording artist Sam Smith together in the BBC Radio 1 Live Lounge.', '34', '30', 'images/cdcover/c8.jpg', '7');
INSERT INTO `cd` VALUES ('9', 'PHOTOGRAPH', 'Ed Sheeran', '2015-05-11', '\"Photograph\" is a song recorded by English singer-songwriter Ed Sheeran for his second studio album, x (2014). Sheeran co-wrote the song with Snow Patrol member Johnny McDaid, who had a piano loop upon which the composition developed. After recording several versions with other producers, Sheeran eventually solicited help from Jeff Bhasker; the collaboration generated a version that Bhasker further enhanced for months. The ballad derives its music primarily from an acoustic guitar, piano and programmed drums. With visually descriptive lyrics, the song discusses a long-distance relationship inspired by Sheeran\'s own experience of being away from his then-girlfriend while he was on tour. It received generally positive commentary from critics who noted the lyrics and Sheeran\'s use of imagery.\r\n\r\n\"Photograph\" is a song recorded by English singer-songwriter Ed Sheeran for his second studio album, x (2014). Sheeran co-wrote the song with Snow Patrol member Johnny McDaid, who had a piano loop upon which the composition developed. After recording several versions with other producers, Sheeran eventually solicited help from Jeff Bhasker; the collaboration generated a version that Bhasker further enhanced for months. The ballad derives its music primarily from an acoustic guitar, piano and programmed drums. With visually descriptive lyrics, the song discusses a long-distance relationship inspired by Sheeran\'s own experience of being away from his then-girlfriend while he was on tour. It received generally positive commentary from critics who noted the lyrics and Sheeran\'s use of imagery.', '40', '24', 'images/cdcover/c9.jpg', '8');
INSERT INTO `cd` VALUES ('10', 'DOWNTOWN', 'Macklemore & Ryan Lewis', '2015-08-27', '\"Downtown\" is a song by American hip hop duo Macklemore & Ryan Lewis featuring Eric Nally, Melle Mel, Kool Moe Dee, and Grandmaster Caz. The song was officially released as a single on August 27, 2015. A music video for the song was uploaded to Ryan Lewis\' own YouTube channel on the day of the song\'s release.', '55', '15', 'images/cdcover/c10.jpg', '6');
INSERT INTO `cd` VALUES ('11', 'COOL FOR THE SUMMER', 'Demi Lovato', '2015-07-01', '\"Cool for the Summer\" is a song by American singer Demi Lovato. It serves as the lead single from her fifth studio album Confident.[2][3] The song was released on July 1, 2015, by Hollywood, and Island Records, and made its radio premiere on the same date via Republic Records.[4][5] It was written by Lovato, Max Martin, Ali Payami, Alexander Erik Kronlund and Savan Kotecha.[6] The song has received attention for its bi-curious insinuations and sexually suggestive lyrics.', '40', '38', 'images/cdcover/c11.jpg', '5');
INSERT INTO `cd` VALUES ('12', 'DRAG ME DOWN', 'One Direction', '2015-07-31', '\"Drag Me Down\" is a song recorded by British-Irish boy band One Direction for their fifth studio album, Made in the A.M. (2015).[2] The song was released worldwide on 31 July 2015. Written by Jamie Scott, John Ryan and Julian Bunetta, the song is produced by the latter two.[1] The track marked their first single since Zayn Malik\'s departure in March 2015. \"Drag Me Down\" debuted at the top of the charts in the UK, Ireland, France, Austria, Australia, and New Zealand upon its release. It became the group\'s first number one single in France and Australia, as well as their fourth number one in New Zealand and the UK. It debuted at number three on the Billboard Hot 100 chart.', '45', '47', 'images/cdcover/c12.jpg', '1');

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '123', 'zhang', 'zhibo', 'zhibo_zhang@yahoo.com', 'female');
INSERT INTO `customer` VALUES ('2', '123', 'wenqian', 'wang', 'wenqianwang@yahoo.com', 'male');

-- ----------------------------
-- Table structure for `items`
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `itemsid` bigint(20) NOT NULL AUTO_INCREMENT,
  `count` int(11) NOT NULL,
  `orderid` bigint(20) NOT NULL,
  `cdid` bigint(20) NOT NULL,
  PRIMARY KEY (`itemsid`),
  KEY `order_item` (`orderid`),
  KEY `cd_item` (`cdid`),
  CONSTRAINT `cd_item` FOREIGN KEY (`cdid`) REFERENCES `cd` (`cdid`),
  CONSTRAINT `order_item` FOREIGN KEY (`orderid`) REFERENCES `order` (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of items
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderid` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `status` char(255) NOT NULL,
  `total` float NOT NULL,
  `userid` bigint(20) NOT NULL,
  `addrid` bigint(20) NOT NULL,
  `shipid` bigint(20) NOT NULL,
  `taxid` bigint(20) NOT NULL,
  PRIMARY KEY (`orderid`),
  KEY `user_cus` (`userid`),
  KEY `add_cus` (`addrid`),
  KEY `ship_cus` (`shipid`),
  KEY `tax_cus` (`taxid`),
  CONSTRAINT `add_cus` FOREIGN KEY (`addrid`) REFERENCES `address` (`addrid`),
  CONSTRAINT `ship_cus` FOREIGN KEY (`shipid`) REFERENCES `shipping` (`shipid`),
  CONSTRAINT `tax_cus` FOREIGN KEY (`taxid`) REFERENCES `tax` (`taxid`),
  CONSTRAINT `user_cus` FOREIGN KEY (`userid`) REFERENCES `customer` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `shipping`
-- ----------------------------
DROP TABLE IF EXISTS `shipping`;
CREATE TABLE `shipping` (
  `shipid` bigint(20) NOT NULL AUTO_INCREMENT,
  `method` varchar(255) NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`shipid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shipping
-- ----------------------------

-- ----------------------------
-- Table structure for `tax`
-- ----------------------------
DROP TABLE IF EXISTS `tax`;
CREATE TABLE `tax` (
  `taxid` bigint(20) NOT NULL AUTO_INCREMENT,
  `taxname` varchar(255) NOT NULL,
  `taxrate` float(255,0) NOT NULL,
  PRIMARY KEY (`taxid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tax
-- ----------------------------
