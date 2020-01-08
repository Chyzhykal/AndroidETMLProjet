-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Дек 22 2019 г., 18:15
-- Версия сервера: 5.7.11
-- Версия PHP: 7.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

GRANT ALL PRIVILEGES ON *.* TO 'Buris'@'%' IDENTIFIED BY "root";

CREATE DATABASE db_meetapp;
USE db_meetapp;



--
-- База данных: `db_meetapp`
--

-- --------------------------------------------------------

--
-- Структура таблицы `participates`
--

CREATE TABLE `participates` (
  `fkEvent` int(11) NOT NULL,
  `fkUser` int(11) NOT NULL,
  `parChance` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Структура таблицы `t_evcategory`
--

CREATE TABLE `t_evcategory` (
  `idCategory` int(11) NOT NULL,
  `catName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `t_evcategory`
--

INSERT INTO `t_evcategory` (`idCategory`, `catName`) VALUES
(1, 'testCategory1'),
(2, 'testCategory2');

-- --------------------------------------------------------

--
-- Структура таблицы `t_event`
--

CREATE TABLE `t_event` (
  `idEvent` int(11) NOT NULL,
  `eveName` varchar(255) NOT NULL,
  `eveDescription` varchar(1024) NOT NULL,
  `evePicture` varchar(255) NOT NULL,
  `eveStartDatetime` date NOT NULL,
  `eveEndDatetime` date NOT NULL,
  `eveLocation` varchar(255) NOT NULL,
  `evePromoted` tinyint(1) NOT NULL,
  `evePrivate` tinyint(1) NOT NULL,
  `eveMaxUsers` int(11) NOT NULL,
  `fkUser` int(11) NOT NULL,
  `fkCategory` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `t_event`
--

INSERT INTO `t_event` (`idEvent`, `eveName`, `eveDescription`, `evePicture`, `eveStartDatetime`, `eveEndDatetime`, `eveLocation`, `evePromoted`, `evePrivate`, `eveMaxUsers`, `fkUser`, `fkCategory`) VALUES
(1, 'TestName', 'TestDescription', 'TestPicture', '2019-11-06', '2019-11-23', 'TestLocation', 1, 1, 100, 1, 1),
(2, 'TestName2', 'TestDescription2', 'TestPicture2', '2019-11-10', '2019-11-26', 'TestLocation2', 0, 1, 120, 1, 1),
(4, 'Noel', 'Noel', 'ooleg', '1970-01-01', '1970-01-01', 'Lausanne', 0, 0, 5, 4, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `t_user`
--

CREATE TABLE `t_user` (
  `idUser` int(11) NOT NULL,
  `useName` varchar(255) NOT NULL,
  `usePhoneNumber` varchar(255) NOT NULL,
  `usePwd` varchar(255) NOT NULL,
  `usePhoto` varchar(255) NOT NULL,
  `useBirthDate` date NOT NULL,
  `useJoinDate` date NOT NULL,
  `useKudos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `t_user`
--

INSERT INTO `t_user` (`idUser`, `useName`, `usePhoneNumber`, `usePwd`, `usePhoto`, `useBirthDate`, `useJoinDate`, `useKudos`) VALUES
(1, 'Buris', '07912341', '140PWD', '140Photo', '2019-11-14', '2019-11-22', 12),
(2, 'ddd', '21313', 'dsadasd', 'ooleg', '1970-01-01', '2019-12-11', 1),
(3, 'eeqweqwe', '792132', '213123123', 'ooleg', '1970-01-01', '2019-12-11', 1),
(4, 'test', '123', 'test', 'ooleg', '1970-01-01', '2019-12-18', 1),
(5, 'aleg', '23123', 'test', 'ooleg', '1970-01-01', '2019-12-18', 1),
(6, 'Buris2', '1234', 'test', 'ooleg', '1970-01-01', '2019-12-18', 1),
(7, 'test3', '123123', 'test', 'Not Implement yet', '1992-12-12', '2019-12-18', 1),
(8, 'testuser', '0795291178', 'testpassword', 'Not implemented yet', '2018-06-03', '2019-12-23', 10);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `participates`
--
ALTER TABLE `participates`
  ADD PRIMARY KEY (`fkUser`,`fkEvent`),
  ADD UNIQUE KEY `ID_Participates_IND` (`fkUser`,`fkEvent`),
  ADD KEY `FKPar_t_e_IND` (`fkEvent`);

--
-- Индексы таблицы `t_evcategory`
--
ALTER TABLE `t_evcategory`
  ADD PRIMARY KEY (`idCategory`),
  ADD UNIQUE KEY `ID_t_evCategory_IND` (`idCategory`);

--
-- Индексы таблицы `t_event`
--
ALTER TABLE `t_event`
  ADD PRIMARY KEY (`idEvent`),
  ADD UNIQUE KEY `ID_t_event_IND` (`idEvent`),
  ADD KEY `FKCreated_IND` (`fkUser`),
  ADD KEY `FKBelongs_IND` (`fkCategory`);

--
-- Индексы таблицы `t_user`
--
ALTER TABLE `t_user`
  ADD PRIMARY KEY (`idUser`),
  ADD UNIQUE KEY `ID_t_user_IND` (`idUser`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `t_evcategory`
--
ALTER TABLE `t_evcategory`
  MODIFY `idCategory` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `t_event`
--
ALTER TABLE `t_event`
  MODIFY `idEvent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT для таблицы `t_user`
--
ALTER TABLE `t_user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `participates`
--
ALTER TABLE `participates`
  ADD CONSTRAINT `FKPar_t_e_FK` FOREIGN KEY (`fkEvent`) REFERENCES `t_event` (`idEvent`),
  ADD CONSTRAINT `FKPar_t_u` FOREIGN KEY (`fkUser`) REFERENCES `t_user` (`idUser`);

--
-- Ограничения внешнего ключа таблицы `t_event`
--
ALTER TABLE `t_event`
  ADD CONSTRAINT `FKBelongs_FK` FOREIGN KEY (`fkCategory`) REFERENCES `t_evcategory` (`idCategory`),
  ADD CONSTRAINT `FKCreated_FK` FOREIGN KEY (`fkUser`) REFERENCES `t_user` (`idUser`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
