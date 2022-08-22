/*
Navicat MySQL Data Transfer

Source Server         : web
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : provis6_travel

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2022-07-27 11:46:01
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `kdCustomer` varchar(10) NOT NULL,
  `customer` varchar(50) NOT NULL,
  `jk` enum('L','P') NOT NULL,
  `alamat` text DEFAULT NULL,
  `no_telp` varchar(13) NOT NULL,
  PRIMARY KEY (`kdCustomer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('C001', 'Joni Subana', 'L', 'Jl Pistol 12', '089763826493');
INSERT INTO `customer` VALUES ('C002', 'Hamid Malik', 'L', 'Jl Granat 6', '081273946241');
INSERT INTO `customer` VALUES ('C003', 'Sony Ericson', 'L', 'Jl Rudal 25', '081627384927');
INSERT INTO `customer` VALUES ('C004', 'Sonya Talitha', 'P', 'Jl Jauhari 13', '081729362526');
INSERT INTO `customer` VALUES ('C005', 'Rossa Melinda', 'P', 'Jl Dipatiukur 9', '082736472819');
INSERT INTO `customer` VALUES ('C006', 'Intan Permata', 'P', 'Jl Pistol 19', '0893628372536');
INSERT INTO `customer` VALUES ('C007', 'Tian Sutomo', 'L', 'Jl Granat 1', '089735263748');
INSERT INTO `customer` VALUES ('C008', 'Kevin Erlangga', 'L', 'Jl Rudal 56', '089635273894');
INSERT INTO `customer` VALUES ('C009', 'Yulia Sari', 'P', 'Jl Jauhari 6', '085372638476');
INSERT INTO `customer` VALUES ('C010', 'Justin Xavier', 'L', 'Jl Dipatiukur 1', '089637482514');
INSERT INTO `customer` VALUES ('C011', 'Thomas Shelby', 'L', 'Jl Pistol 2', '089573846241');
INSERT INTO `customer` VALUES ('C012', 'Jay Gatsby', 'L', 'Jl Granat 9', '089642536475');
INSERT INTO `customer` VALUES ('C013', 'Danny Ocean', 'L', 'Jl Rudal 8', '089724364758');
INSERT INTO `customer` VALUES ('C014', 'Mustafa', 'L', 'Jl Jauhari 10', '089652739152');
INSERT INTO `customer` VALUES ('C015', 'Simon Basset', 'L', 'Jl Dipatiukur 4', '089253614283');
INSERT INTO `customer` VALUES ('C016', 'Rusty Ryan', 'L', 'Jl Pistol 23', '089583624163');
INSERT INTO `customer` VALUES ('C017', 'Casey Cooke', 'P', 'Jl Granat 31', '089684637254');
INSERT INTO `customer` VALUES ('C018', 'Edna Mode', 'P', 'Jl Rudal 8', '089724364758');
INSERT INTO `customer` VALUES ('C019', 'Maddy Perez', 'P', 'Jl Jauhari 15', '089694625374');
INSERT INTO `customer` VALUES ('C020', 'Brendon Urie', 'L', 'Jl Dipatiukur 24', '089207382517');
INSERT INTO `customer` VALUES ('C021', 'Taylor Swift', 'P', 'Jl Pistol 27', '089504627152');
INSERT INTO `customer` VALUES ('C022', 'Nicole Zefanya', 'P', 'Jl Granat 1', '089694637251');
INSERT INTO `customer` VALUES ('C023', 'Perrie Edwards', 'P', 'Jl Rudal 18', '089784536291');
INSERT INTO `customer` VALUES ('C024', 'Calum Hood', 'L', 'Jl Jauhari 25', '089695736142');
INSERT INTO `customer` VALUES ('C025', 'Dominic Fike', 'L', 'Jl Dipatiukur 7', '089295725194');

-- ----------------------------
-- Table structure for `detail_transaksi`
-- ----------------------------
DROP TABLE IF EXISTS `detail_transaksi`;
CREATE TABLE `detail_transaksi` (
  `kdBooking` varchar(10) NOT NULL,
  `kdCustomer` varchar(10) NOT NULL,
  `noKursi` int(11) NOT NULL,
  KEY `booking1` (`kdBooking`),
  KEY `customer2` (`kdCustomer`),
  CONSTRAINT `booking1` FOREIGN KEY (`kdBooking`) REFERENCES `transaksi` (`kdBooking`),
  CONSTRAINT `customer2` FOREIGN KEY (`kdCustomer`) REFERENCES `customer` (`kdCustomer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of detail_transaksi
-- ----------------------------
INSERT INTO `detail_transaksi` VALUES ('BK001', 'C001', '1');
INSERT INTO `detail_transaksi` VALUES ('BK002', 'C002', '2');
INSERT INTO `detail_transaksi` VALUES ('BK003', 'C003', '3');
INSERT INTO `detail_transaksi` VALUES ('BK004', 'C004', '4');
INSERT INTO `detail_transaksi` VALUES ('BK005', 'C005', '5');
INSERT INTO `detail_transaksi` VALUES ('BK006', 'C006', '6');
INSERT INTO `detail_transaksi` VALUES ('BK007', 'C007', '7');
INSERT INTO `detail_transaksi` VALUES ('BK008', 'C008', '8');
INSERT INTO `detail_transaksi` VALUES ('BK009', 'C009', '1');
INSERT INTO `detail_transaksi` VALUES ('BK010', 'C010', '2');
INSERT INTO `detail_transaksi` VALUES ('BK011', 'C011', '3');
INSERT INTO `detail_transaksi` VALUES ('BK012', 'C012', '4');
INSERT INTO `detail_transaksi` VALUES ('BK013', 'C013', '5');
INSERT INTO `detail_transaksi` VALUES ('BK014', 'C014', '6');
INSERT INTO `detail_transaksi` VALUES ('BK015', 'C015', '7');
INSERT INTO `detail_transaksi` VALUES ('BK016', 'C016', '8');
INSERT INTO `detail_transaksi` VALUES ('BK017', 'C017', '1');
INSERT INTO `detail_transaksi` VALUES ('BK018', 'C018', '2');
INSERT INTO `detail_transaksi` VALUES ('BK019', 'C019', '3');
INSERT INTO `detail_transaksi` VALUES ('BK020', 'C020', '4');
INSERT INTO `detail_transaksi` VALUES ('BK021', 'C021', '5');
INSERT INTO `detail_transaksi` VALUES ('BK022', 'C022', '6');
INSERT INTO `detail_transaksi` VALUES ('BK023', 'C023', '7');
INSERT INTO `detail_transaksi` VALUES ('BK024', 'C024', '8');
INSERT INTO `detail_transaksi` VALUES ('BK025', 'C025', '1');
INSERT INTO `detail_transaksi` VALUES ('BK026', 'C001', '1');
INSERT INTO `detail_transaksi` VALUES ('BK026', 'C001', '2');
INSERT INTO `detail_transaksi` VALUES ('BK027', 'C004', '1');
INSERT INTO `detail_transaksi` VALUES ('BK027', 'C004', '2');
INSERT INTO `detail_transaksi` VALUES ('BK027', 'C004', '3');
INSERT INTO `detail_transaksi` VALUES ('BK028', 'C025', '1');
INSERT INTO `detail_transaksi` VALUES ('BK028', 'C025', '2');
INSERT INTO `detail_transaksi` VALUES ('BK028', 'C025', '3');
INSERT INTO `detail_transaksi` VALUES ('BK028', 'C025', '4');
INSERT INTO `detail_transaksi` VALUES ('BK028', 'C025', '5');
INSERT INTO `detail_transaksi` VALUES ('BK028', 'C025', '6');
INSERT INTO `detail_transaksi` VALUES ('BK028', 'C025', '7');
INSERT INTO `detail_transaksi` VALUES ('BK028', 'C025', '8');
INSERT INTO `detail_transaksi` VALUES ('BK029', 'C002', '1');
INSERT INTO `detail_transaksi` VALUES ('BK029', 'C002', '2');
INSERT INTO `detail_transaksi` VALUES ('BK030', 'C015', '1');
INSERT INTO `detail_transaksi` VALUES ('BK030', 'C015', '4');
INSERT INTO `detail_transaksi` VALUES ('BK030', 'C015', '7');
INSERT INTO `detail_transaksi` VALUES ('BK031', 'C001', '1');
INSERT INTO `detail_transaksi` VALUES ('BK031', 'C001', '2');

-- ----------------------------
-- Table structure for `keberangkatan`
-- ----------------------------
DROP TABLE IF EXISTS `keberangkatan`;
CREATE TABLE `keberangkatan` (
  `kdKeberangkatan` varchar(10) NOT NULL,
  `keberangkatan` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  PRIMARY KEY (`kdKeberangkatan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of keberangkatan
-- ----------------------------
INSERT INTO `keberangkatan` VALUES ('KB001', 'Di Jonggol', 'Jln. Jonggol NO 21');
INSERT INTO `keberangkatan` VALUES ('KB002', 'Di Jonggol II', 'Jln. Jonggol NO 22');
INSERT INTO `keberangkatan` VALUES ('KB003', 'Di Jonggol III', 'Jln. Jonggol NO 23');
INSERT INTO `keberangkatan` VALUES ('KB004', 'Di Jonggol IV', 'Jln. Jonggol NO 24');
INSERT INTO `keberangkatan` VALUES ('KB005', 'Di Jonggol V', 'Jln. Jonggol NO 25');
INSERT INTO `keberangkatan` VALUES ('KB006', 'Di Jonggol VI', 'Jln. Jonggol NO 26');
INSERT INTO `keberangkatan` VALUES ('KB007', 'Di Jonggol VII', 'Jln. Jonggol NO 27');
INSERT INTO `keberangkatan` VALUES ('KB008', 'Di Jonggol VIII', 'Jln. Jonggol NO 28');
INSERT INTO `keberangkatan` VALUES ('KB009', 'Di Jonggol IX', 'Jln. Jonggol NO 29');
INSERT INTO `keberangkatan` VALUES ('KB010', 'Di Jonggol X', 'Jln. Jonggol NO 30');
INSERT INTO `keberangkatan` VALUES ('KB011', 'Di Jonggol XI', 'Jln. Jonggol NO 31');
INSERT INTO `keberangkatan` VALUES ('KB012', 'Di Jonggol XII', 'Jln. Jonggol NO 32');
INSERT INTO `keberangkatan` VALUES ('KB013', 'Di Jonggol XIII', 'Jln. Jonggol NO 33');
INSERT INTO `keberangkatan` VALUES ('KB014', 'Di Jonggol XIV', 'Jln. Jonggol NO 34');
INSERT INTO `keberangkatan` VALUES ('KB015', 'Di Jonggol XV', 'Jln. Jonggol NO 34');
INSERT INTO `keberangkatan` VALUES ('KB016', 'Di Jonggol XVI', 'Jln. Jonggol NO 36');
INSERT INTO `keberangkatan` VALUES ('KB017', 'Di Jonggol XVII', 'Jln. Jonggol NO 37');
INSERT INTO `keberangkatan` VALUES ('KB018', 'Di Jonggol XVIII', 'Jln. Jonggol NO 38');
INSERT INTO `keberangkatan` VALUES ('KB019', 'Di Jonggol XIX', 'Jln. Jonggol NO 39');
INSERT INTO `keberangkatan` VALUES ('KB020', 'Di Jonggol XX', 'Jln. Jonggol NO 40');
INSERT INTO `keberangkatan` VALUES ('KB021', 'Di Jonggol XXI', 'Jln. Jonggol NO 41');
INSERT INTO `keberangkatan` VALUES ('KB022', 'Di Jonggol XXII', 'Jln. Jonggol NO 42');
INSERT INTO `keberangkatan` VALUES ('KB023', 'Di Jonggol XXIII', 'Jln. Jonggol NO 43');
INSERT INTO `keberangkatan` VALUES ('KB024', 'Di Jonggol XXIX', 'Jln. Jonggol NO 44');
INSERT INTO `keberangkatan` VALUES ('KB025', 'Di Jonggol XXX', 'Jln. Jonggol NO 45');
INSERT INTO `keberangkatan` VALUES ('KB026', 'Dipatiukur ', 'Jln. Dipatiukur Kota Bandung');

-- ----------------------------
-- Table structure for `petugas`
-- ----------------------------
DROP TABLE IF EXISTS `petugas`;
CREATE TABLE `petugas` (
  `kdPetugas` varchar(10) NOT NULL,
  `petugas` varchar(50) NOT NULL,
  `jk` enum('L','P') NOT NULL,
  `no_telp` varchar(13) NOT NULL,
  `alamat` text NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`kdPetugas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of petugas
-- ----------------------------
INSERT INTO `petugas` VALUES ('KP001', 'Alexander The Great', 'L', '082118714500', 'Jln Romawi NO. 1', '*00C9B8C6E6D40EED324CABFD8A5C49489FBB4D15');
INSERT INTO `petugas` VALUES ('KP002', 'Alexander The Great II', 'L', '082118714501', 'Jln Romawi NO. 2', '*C17863F74BE78D7119B69BC4AB75919412A2DDE9');
INSERT INTO `petugas` VALUES ('KP003', 'Alexander The Great III', 'L', '082118714502', 'Jln Romawi NO. 3', '*3EFAE80297DF45E8B9FEA78A813646814F9ED7D5');
INSERT INTO `petugas` VALUES ('KP004', 'Alexander The Great IV', 'L', '082118714503', 'Jln Romawi NO. 4', '*B2B6A1074C591BB81702A119E7F8B23D5903C87B');
INSERT INTO `petugas` VALUES ('KP005', 'Alexander The Great V', 'L', '082118714504', 'Jln Romawi NO. 5', '*1D0864CFAD9809A9BDC9F4093AA45BD72BC33BE2');
INSERT INTO `petugas` VALUES ('KP006', 'Alexander The Great VI', 'L', '082118714505', 'Jln Romawi NO. 6', '*5603CD1B711185E24F0ADB27AF81F035D9053068');
INSERT INTO `petugas` VALUES ('KP007', 'Alexander The Great VII', 'L', '082118714506', 'Jln Romawi NO. 7', '*FBBBB42A5DCF2FB51C325F0F79D29971C67F744A');
INSERT INTO `petugas` VALUES ('KP008', 'Alexander The Great VIII', 'L', '082118714507', 'Jln Romawi NO. 8', '*DA573B0C9A929E4151C7E1C70E028282217C60E2');
INSERT INTO `petugas` VALUES ('KP009', 'Alexander The Great IX', 'L', '082118714508', 'Jln Romawi NO. 9', '*06F4ECFDC71CBF1795A216824F5ECF6842C4A622');
INSERT INTO `petugas` VALUES ('KP010', 'Alexander The Great X', 'L', '082118714509', 'Jln Romawi NO. 10', '*A05F270DE64D334D215F5637A0A2779FE8A00F94');
INSERT INTO `petugas` VALUES ('KP011', 'Alexander The Great XI', 'L', '082118714510', 'Jln Romawi NO. 11', '*C2DEEE2104D31D28195D38D5506D5B0EC7C7B1EF');
INSERT INTO `petugas` VALUES ('KP012', 'Alexander The Great XII', 'L', '082118714511', 'Jln Romawi NO. 12', '*4A62F8F637B5B184F79EAABACF5D8566302D45B8');
INSERT INTO `petugas` VALUES ('KP013', 'Alexander The Great XIII', 'L', '082118714512', 'Jln Romawi NO. 13', '*3283A2DA3A92C96FBE9662174FB8AD5867CABF3E');
INSERT INTO `petugas` VALUES ('KP014', 'Alexander The Great XIV', 'L', '082118714513', 'Jln Romawi NO. 14', '*89C1D4EAB9FDC785BEEE6B24C863029B8DCDE26F');
INSERT INTO `petugas` VALUES ('KP015', 'Alexander The Great XV', 'L', '082118714514', 'Jln Romawi NO. 15', '*00B894B8D0AF9DB3EEB4156387509B34AD87804B');
INSERT INTO `petugas` VALUES ('KP016', 'Monalisa The Painting', 'P', '082118714515', 'Jln Romawi NO. 16', '*7279B172BB4E953A70F2FA6771D74F69E9CB4C9E');
INSERT INTO `petugas` VALUES ('KP017', 'Monalisa The Painting II', 'P', '082118714516', 'Jln Romawi NO. 17', '*687421808A73C31430D3CBC8A7B0F09025D69743');
INSERT INTO `petugas` VALUES ('KP018', 'Monalisa The Painting III', 'P', '082118714517', 'Jln Romawi NO. 18', '*81BEFFF70D7E7A900D52986FAE790C8B7D67D240');
INSERT INTO `petugas` VALUES ('KP019', 'Monalisa The Painting IV', 'P', '082118714518', 'Jln Romawi NO. 19', '*52FB1B27858486D2259C5AC312381951ADD8C69B');
INSERT INTO `petugas` VALUES ('KP020', 'Monalisa The Painting V', 'P', '082118714519', 'Jln Romawi NO. 20', '*FC2FF2C069325A14A5D80361107B62ADBCE0DD81');
INSERT INTO `petugas` VALUES ('KP021', 'Monalisa The Painting VI', 'P', '082118714520', 'Jln Romawi NO. 21', '*5BEAB2225CC24074F3AFAE535AD224D3110E774C');
INSERT INTO `petugas` VALUES ('KP022', 'Monalisa The Painting VII', 'P', '082118714521', 'Jln Romawi NO. 22', '*23C4351257F48F17AA16C19EF0CB269ACC43D9BA');
INSERT INTO `petugas` VALUES ('KP023', 'Monalisa The Painting VIII', 'P', '082118714522', 'Jln Romawi NO. 23', '*4A2111305C495B2117A3256E273F36F70E1EFB80');
INSERT INTO `petugas` VALUES ('KP024', 'Monalisa The Painting IX', 'P', '082118714523', 'Jln Romawi NO. 24', '*248C5A762690E5992DD351FD3FA5E1E82EED2F7C');
INSERT INTO `petugas` VALUES ('KP025', 'Monalisa The Painting X', 'P', '082118714524', 'Jln Romawi NO. 25', '*76598F2869E1C90A4CFF3AD904FC69FC529BFDDF');

-- ----------------------------
-- Table structure for `transaksi`
-- ----------------------------
DROP TABLE IF EXISTS `transaksi`;
CREATE TABLE `transaksi` (
  `kdBooking` varchar(10) NOT NULL,
  `kdPetugas` varchar(10) NOT NULL,
  `tglTerbit` datetime NOT NULL,
  `kdCustomer` varchar(10) NOT NULL,
  `kdKeberangkatan` varchar(10) NOT NULL,
  `kdTujuan` varchar(10) NOT NULL,
  `tglPergi` datetime NOT NULL,
  `totalBayar` double NOT NULL,
  PRIMARY KEY (`kdBooking`),
  KEY `petugas1` (`kdPetugas`),
  KEY `customer1` (`kdCustomer`),
  KEY `tujuan1` (`kdTujuan`),
  KEY `keberangkatan1` (`kdKeberangkatan`),
  CONSTRAINT `customer1` FOREIGN KEY (`kdCustomer`) REFERENCES `customer` (`kdCustomer`),
  CONSTRAINT `keberangkatan1` FOREIGN KEY (`kdKeberangkatan`) REFERENCES `keberangkatan` (`kdKeberangkatan`),
  CONSTRAINT `petugas1` FOREIGN KEY (`kdPetugas`) REFERENCES `petugas` (`kdPetugas`),
  CONSTRAINT `tujuan1` FOREIGN KEY (`kdTujuan`) REFERENCES `tujuan` (`kdTujuan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of transaksi
-- ----------------------------
INSERT INTO `transaksi` VALUES ('BK001', 'KP001', '2022-07-07 19:30:00', 'C001', 'KB001', 'T001', '2022-07-08 19:30:00', '50000');
INSERT INTO `transaksi` VALUES ('BK002', 'KP002', '2022-07-08 18:20:00', 'C002', 'KB002', 'T002', '2022-07-08 19:30:00', '55000');
INSERT INTO `transaksi` VALUES ('BK003', 'KP003', '2022-07-07 17:30:00', 'C003', 'KB003', 'T003', '2022-07-08 17:30:00', '50500');
INSERT INTO `transaksi` VALUES ('BK004', 'KP004', '2022-07-07 16:30:00', 'C004', 'KB004', 'T004', '2022-07-08 16:30:00', '51500');
INSERT INTO `transaksi` VALUES ('BK005', 'KP005', '2022-07-07 15:30:00', 'C005', 'KB005', 'T005', '2022-07-08 15:30:00', '52000');
INSERT INTO `transaksi` VALUES ('BK006', 'KP006', '2022-07-07 14:30:00', 'C006', 'KB006', 'T006', '2022-07-08 14:30:00', '50500');
INSERT INTO `transaksi` VALUES ('BK007', 'KP007', '2022-07-07 13:30:00', 'C007', 'KB007', 'T007', '2022-07-08 13:30:00', '52500');
INSERT INTO `transaksi` VALUES ('BK008', 'KP008', '2022-07-07 12:30:00', 'C008', 'KB008', 'T008', '2022-07-08 12:30:00', '50000');
INSERT INTO `transaksi` VALUES ('BK009', 'KP009', '2022-07-07 11:30:00', 'C009', 'KB009', 'T009', '2022-07-08 11:30:00', '51000');
INSERT INTO `transaksi` VALUES ('BK010', 'KP010', '2022-07-07 10:30:00', 'C010', 'KB010', 'T010', '2022-07-08 10:30:00', '50000');
INSERT INTO `transaksi` VALUES ('BK011', 'KP011', '2022-07-07 09:30:00', 'C011', 'KB011', 'T011', '2022-07-08 09:30:00', '51000');
INSERT INTO `transaksi` VALUES ('BK012', 'KP012', '2022-07-07 08:30:00', 'C012', 'KB012', 'T012', '2022-07-08 08:30:00', '51000');
INSERT INTO `transaksi` VALUES ('BK013', 'KP013', '2022-07-07 07:30:00', 'C013', 'KB013', 'T013', '2022-07-08 07:30:00', '54000');
INSERT INTO `transaksi` VALUES ('BK014', 'KP014', '2022-07-07 06:30:00', 'C014', 'KB014', 'T014', '2022-07-08 06:30:00', '51000');
INSERT INTO `transaksi` VALUES ('BK015', 'KP015', '2022-07-07 05:30:00', 'C015', 'KB015', 'T015', '2022-07-08 05:30:00', '50500');
INSERT INTO `transaksi` VALUES ('BK016', 'KP016', '2022-07-07 04:30:00', 'C016', 'KB016', 'T016', '2022-07-08 04:30:00', '52500');
INSERT INTO `transaksi` VALUES ('BK017', 'KP017', '2022-07-07 03:30:00', 'C017', 'KB017', 'T017', '2022-07-08 03:30:00', '52500');
INSERT INTO `transaksi` VALUES ('BK018', 'KP018', '2022-07-07 02:30:00', 'C018', 'KB018', 'T018', '2022-07-08 02:30:00', '65000');
INSERT INTO `transaksi` VALUES ('BK019', 'KP019', '2022-07-07 01:30:00', 'C019', 'KB019', 'T019', '2022-07-08 01:30:00', '70000');
INSERT INTO `transaksi` VALUES ('BK020', 'KP020', '2022-07-07 00:30:00', 'C020', 'KB020', 'T020', '2022-07-08 00:30:00', '55500');
INSERT INTO `transaksi` VALUES ('BK021', 'KP021', '2022-07-07 23:30:00', 'C021', 'KB021', 'T021', '2022-07-08 23:30:00', '80000');
INSERT INTO `transaksi` VALUES ('BK022', 'KP022', '2022-07-07 22:30:00', 'C022', 'KB022', 'T022', '2022-07-08 22:30:00', '60000');
INSERT INTO `transaksi` VALUES ('BK023', 'KP023', '2022-07-07 21:30:00', 'C023', 'KB023', 'T023', '2022-07-08 21:30:00', '65000');
INSERT INTO `transaksi` VALUES ('BK024', 'KP024', '2022-07-07 20:30:00', 'C024', 'KB024', 'T024', '2022-07-08 20:30:00', '70000');
INSERT INTO `transaksi` VALUES ('BK025', 'KP025', '2022-07-09 20:30:00', 'C025', 'KB025', 'T025', '2022-07-09 20:30:00', '50000');
INSERT INTO `transaksi` VALUES ('BK026', 'KP001', '2022-07-16 22:46:00', 'C001', 'KB001', 'T001', '2022-07-17 22:46:00', '100000');
INSERT INTO `transaksi` VALUES ('BK027', 'KP003', '2022-07-15 22:47:00', 'C004', 'KB002', 'T003', '2022-07-17 22:47:00', '151500');
INSERT INTO `transaksi` VALUES ('BK028', 'KP020', '2022-07-18 02:04:00', 'C025', 'KB026', 'T019', '2022-07-19 02:04:00', '560000');
INSERT INTO `transaksi` VALUES ('BK029', 'KP016', '2022-07-01 02:44:00', 'C002', 'KB010', 'T022', '2022-07-03 02:44:00', '120000');
INSERT INTO `transaksi` VALUES ('BK030', 'KP018', '2022-07-17 02:51:00', 'C015', 'KB007', 'T019', '2022-07-18 02:51:00', '210000');
INSERT INTO `transaksi` VALUES ('BK031', 'KP001', '2022-07-18 11:03:00', 'C001', 'KB001', 'T001', '2022-07-19 11:03:00', '100000');

-- ----------------------------
-- Table structure for `tujuan`
-- ----------------------------
DROP TABLE IF EXISTS `tujuan`;
CREATE TABLE `tujuan` (
  `kdTujuan` varchar(10) NOT NULL,
  `tujuan` varchar(50) NOT NULL,
  `harga` double NOT NULL,
  PRIMARY KEY (`kdTujuan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tujuan
-- ----------------------------
INSERT INTO `tujuan` VALUES ('T001', 'Bandung', '50000');
INSERT INTO `tujuan` VALUES ('T002', 'Jakarta', '55000');
INSERT INTO `tujuan` VALUES ('T003', 'Bekasi', '50500');
INSERT INTO `tujuan` VALUES ('T004', 'Garut', '51500');
INSERT INTO `tujuan` VALUES ('T005', 'Tasikmalaya', '52000');
INSERT INTO `tujuan` VALUES ('T006', 'Sumedang', '50500');
INSERT INTO `tujuan` VALUES ('T007', 'Bandung Barat', '52500');
INSERT INTO `tujuan` VALUES ('T008', 'Cianjur', '50000');
INSERT INTO `tujuan` VALUES ('T009', 'Cirebon', '51000');
INSERT INTO `tujuan` VALUES ('T010', 'Cimahi', '50000');
INSERT INTO `tujuan` VALUES ('T011', 'Depok', '51000');
INSERT INTO `tujuan` VALUES ('T012', 'Bogor', '51000');
INSERT INTO `tujuan` VALUES ('T013', 'Citayem', '54000');
INSERT INTO `tujuan` VALUES ('T014', 'Ciamis', '51000');
INSERT INTO `tujuan` VALUES ('T015', 'Majalengka', '50500');
INSERT INTO `tujuan` VALUES ('T016', 'Sukabumi', '52500');
INSERT INTO `tujuan` VALUES ('T017', 'Kuningan', '52500');
INSERT INTO `tujuan` VALUES ('T018', 'Semarang', '65000');
INSERT INTO `tujuan` VALUES ('T019', 'Surabaya', '70000');
INSERT INTO `tujuan` VALUES ('T020', 'Serang', '55500');
INSERT INTO `tujuan` VALUES ('T021', 'Padang', '80000');
INSERT INTO `tujuan` VALUES ('T022', 'Sampang', '60000');
INSERT INTO `tujuan` VALUES ('T023', 'Denpasar', '65000');
INSERT INTO `tujuan` VALUES ('T024', 'Banjarmasin', '70000');
INSERT INTO `tujuan` VALUES ('T025', 'Jonggol', '50000');
