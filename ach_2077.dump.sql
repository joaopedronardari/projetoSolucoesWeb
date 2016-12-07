-- MySQL dump 10.13  Distrib 5.6.31, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: ACH_2077
-- ------------------------------------------------------
-- Server version	5.6.31-0ubuntu0.15.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `favoritos`
--

DROP TABLE IF EXISTS `favoritos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `favoritos` (
  `id_usuario` int(10) unsigned NOT NULL,
  `id_imovel` int(10) unsigned NOT NULL,
  `id_favorito` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_favorito`),
  KEY `fk_favoritos_id_usuario_idx` (`id_usuario`),
  KEY `fk_favoritos_id_imovel_idx` (`id_imovel`),
  CONSTRAINT `fk_favoritos_1` FOREIGN KEY (`id_imovel`) REFERENCES `imoveis` (`id_imovel`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_favoritos_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favoritos`
--

LOCK TABLES `favoritos` WRITE;
/*!40000 ALTER TABLE `favoritos` DISABLE KEYS */;
INSERT INTO `favoritos` VALUES (1,19,1),(1,20,2),(2,21,4),(2,19,5),(2,19,6);
/*!40000 ALTER TABLE `favoritos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fotos_imovel`
--

DROP TABLE IF EXISTS `fotos_imovel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fotos_imovel` (
  `id_foto` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_imovel` int(10) unsigned NOT NULL,
  `url` varchar(500) NOT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_foto`),
  KEY `fk_fotos_imovel_id_imovel_idx` (`id_imovel`),
  CONSTRAINT `fk_fotos_imovel_1` FOREIGN KEY (`id_imovel`) REFERENCES `imoveis` (`id_imovel`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fotos_imovel`
--

LOCK TABLES `fotos_imovel` WRITE;
/*!40000 ALTER TABLE `fotos_imovel` DISABLE KEYS */;
INSERT INTO `fotos_imovel` VALUES (5,19,'http://digitalspyuk.cdnds.net/16/38/768x403/gallery-1474472774-yoda-008.jpg','yoda 1'),(6,19,'http://img.lum.dolimg.com/v1/images/ep3_ia_89377_r_bb46f7c6.jpeg?region=500%2C313%2C2925%2C1462&width=480','yoda 2'),(7,20,'https://cdn.sagaentretenimento.com.br/uploads/2016/06/22113456521528-668x376.jpg','vader 1'),(8,20,'http://i.imgur.com/roBqqW2.jpg','vader 2'),(9,21,'http://screencrush.com/442/files/2014/07/star-wars-episode-7-set-photos-skellig-island-luke-skywalker.jpg?w=720&cdnnode=1','luke 1'),(10,21,'http://img.lum.dolimg.com/v1/images/Luke-Skywalker_dd9c9f9b.jpeg?region=0%2C0%2C1536%2C864&width=768','luke 2');
/*!40000 ALTER TABLE `fotos_imovel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imoveis`
--

DROP TABLE IF EXISTS `imoveis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imoveis` (
  `id_imovel` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_usuario` int(10) unsigned DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `descricao` mediumtext,
  `preco_venda` decimal(18,2) DEFAULT NULL,
  `preco_aluguel` decimal(18,2) DEFAULT NULL,
  `preco_condominio` decimal(18,2) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` int(10) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `tipo` enum('APARTAMENTO','CASA','COBERTURA') DEFAULT NULL,
  `data_anuncio` datetime DEFAULT NULL,
  `area` int(10) DEFAULT NULL,
  `quartos` int(10) DEFAULT NULL,
  `vagas` int(10) DEFAULT NULL,
  `suites` int(10) DEFAULT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  `visitas` int(10) NOT NULL,
  PRIMARY KEY (`id_imovel`),
  KEY `fk_imoveis_1_idx` (`id_usuario`),
  CONSTRAINT `fk_imoveis_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imoveis`
--

LOCK TABLES `imoveis` WRITE;
/*!40000 ALTER TABLE `imoveis` DISABLE KEYS */;
INSERT INTO `imoveis` VALUES (19,2,'Imóvel 1 ','descrição do imóvel 1 atualizada!!!',1000.00,100.00,10.00,'Rua Arlindo Béttio, 1000 ',NULL,NULL,'São Paulo','São Paulo','APARTAMENTO',NULL,555,5,5,5,NULL,NULL,103),(20,2,'Imovel 2','Descrição do imovel 2',2000.00,200.00,20.00,'Rua Arlindo Béttio, 1000 ',NULL,NULL,'São Paulo','São Paulo','CASA','2016-12-06 17:46:32',777,7,7,7,NULL,NULL,4),(21,2,'Imovel 3','Descricao do imovel 3',3000.00,300.00,30.00,'Rua Arlindo Béttio, 1000 ',NULL,NULL,'São Paulo','São Paulo','COBERTURA','2016-12-06 17:48:00',222,2,2,2,NULL,NULL,3);
/*!40000 ALTER TABLE `imoveis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imovel_opcionais`
--

DROP TABLE IF EXISTS `imovel_opcionais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imovel_opcionais` (
  `id_imovel` int(10) unsigned NOT NULL,
  `opcional` enum('PISCINA','CHURRASQUEIRA','VARANDA','ESCRITORIO','PLAYGROUND') DEFAULT NULL,
  KEY `fk_imovel_opcionais_1_idx` (`id_imovel`),
  CONSTRAINT `fk_imovel_opcionais_1` FOREIGN KEY (`id_imovel`) REFERENCES `imoveis` (`id_imovel`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imovel_opcionais`
--

LOCK TABLES `imovel_opcionais` WRITE;
/*!40000 ALTER TABLE `imovel_opcionais` DISABLE KEYS */;
/*!40000 ALTER TABLE `imovel_opcionais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensagem`
--

DROP TABLE IF EXISTS `mensagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mensagem` (
  `id_mensagem` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_usuario_remetente` int(10) unsigned NOT NULL,
  `id_usuario_destinatario` int(10) unsigned NOT NULL,
  `mensagem` text NOT NULL,
  `data_envio` datetime NOT NULL,
  PRIMARY KEY (`id_mensagem`),
  KEY `fk_mensagem_1_idx1` (`id_usuario_destinatario`),
  KEY `fk_mensagem_1_idx` (`id_usuario_remetente`),
  CONSTRAINT `fk_mensagem_1` FOREIGN KEY (`id_usuario_remetente`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_mensagem_2` FOREIGN KEY (`id_usuario_destinatario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensagem`
--

LOCK TABLES `mensagem` WRITE;
/*!40000 ALTER TABLE `mensagem` DISABLE KEYS */;
INSERT INTO `mensagem` VALUES (1,1,2,'Funcionaaaaaaaaaa','2016-12-07 14:56:40'),(2,2,1,'Mensageeeeeem','2016-12-07 15:01:40'),(3,2,1,'teste','2016-12-07 15:03:46'),(4,1,2,'Mensagem com alert','2016-12-07 15:11:23'),(5,1,2,'Boaaaaaaaa','2016-12-07 15:13:10'),(11,1,2,'testeeeeeeeee','2016-12-07 17:38:39');
/*!40000 ALTER TABLE `mensagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id_usuario` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `admin` varchar(255) NOT NULL DEFAULT '0',
  `telefone` varchar(255) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','admin@admin.com','admin','1','9999999'),(2,'Guilherme','guilherme.mt21@gmail.com','1234abcd','0','11991176997');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-07 17:42:56
