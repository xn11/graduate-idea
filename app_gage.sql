-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2017-04-16 01:56:18
-- 服务器版本： 5.6.21
-- PHP Version: 5.6.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `app_gage`
--

-- --------------------------------------------------------

--
-- 表的结构 `bidding`
--

CREATE TABLE IF NOT EXISTS `bidding` (
`id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `regulators_id` int(11) DEFAULT NULL,
  `fee` double DEFAULT NULL,
  `status` int(11) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `note` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `bidding_regulators`
--

CREATE TABLE IF NOT EXISTS `bidding_regulators` (
`id` int(11) NOT NULL,
  `bidding_id` int(11) NOT NULL,
  `regulators_id` int(11) NOT NULL,
  `fee` double DEFAULT NULL,
  `status` int(11) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `note` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `blog`
--

CREATE TABLE IF NOT EXISTS `blog` (
`id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `date` varchar(50) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `blog`
--

INSERT INTO `blog` (`id`, `title`, `date`, `timestamp`) VALUES
(1, ' 【error】tomcat一直报错找不到类或者方法 ', '2017-04-09 17:44', '2017-04-09 10:14:50'),
(2, ' 【error】tomcat一直报错找不到类或者方法 ', '2017-04-09 17:44', '2017-04-09 10:14:50'),
(3, ' 清除浏览器js和css缓存 ', '2017-04-06 00:13', '2017-04-09 10:14:55'),
(4, ' 清除浏览器js和css缓存 ', '2017-04-06 00:13', '2017-04-09 10:14:55'),
(5, ' 【error】jQuery ajax请求错误返回status 0和错误error的问题 ', '2017-04-05 11:31', '2017-04-09 10:15:01'),
(6, ' 【error】jQuery ajax请求错误返回status 0和错误error的问题 ', '2017-04-05 11:31', '2017-04-09 10:15:01'),
(7, ' 【error】Tomcat启动报错com.mchange.v2.async.ThreadPoolAsynchronousRunner$DeadlockDetector ', '2017-04-04 21:03', '2017-04-09 10:15:06'),
(8, ' 【error】Tomcat启动报错com.mchange.v2.async.ThreadPoolAsynchronousRunner$DeadlockDetector ', '2017-04-04 21:03', '2017-04-09 10:15:06'),
(9, ' 在JSP中如何使用JSTL（EL表达式）格式化日期 ', '2017-04-04 11:39', '2017-04-09 10:15:11'),
(10, ' 在JSP中如何使用JSTL（EL表达式）格式化日期 ', '2017-04-04 11:39', '2017-04-09 10:15:11'),
(11, ' SpringMVC controller重定向传值 ', '2017-03-30 01:15', '2017-04-09 10:15:17'),
(12, ' SpringMVC controller重定向传值 ', '2017-03-30 01:15', '2017-04-09 10:15:17'),
(13, ' JSP隐含变量和Spring中Model在EL表达式中的读取顺序 ', '2017-03-29 21:13', '2017-04-09 10:15:22'),
(14, ' JSP隐含变量和Spring中Model在EL表达式中的读取顺序 ', '2017-03-29 21:13', '2017-04-09 10:15:23'),
(15, ' Hibernate HQL详解 ', '2017-03-23 19:08', '2017-04-09 10:15:28'),
(16, ' Hibernate HQL详解 ', '2017-03-23 19:08', '2017-04-09 10:15:29'),
(17, ' 【git】git push免用户名密码，用公钥 ', '2017-03-21 02:35', '2017-04-09 10:15:34'),
(18, ' 【git】git push免用户名密码，用公钥 ', '2017-03-21 02:35', '2017-04-09 10:15:34'),
(19, ' 【转】Git图形化界面客户端大汇总 ', '2017-03-19 01:23', '2017-04-09 10:15:41'),
(20, ' 【转】Git图形化界面客户端大汇总 ', '2017-03-19 01:23', '2017-04-09 10:15:42'),
(21, ' 【git】git分支branch和标签tag之增删改查 ', '2017-03-18 01:12', '2017-04-09 10:15:46'),
(22, ' 【git】git分支branch和标签tag之增删改查 ', '2017-03-18 01:12', '2017-04-09 10:15:47'),
(23, ' slf4j-log4j日志框架配置+错误处理 ', '2017-03-16 02:34', '2017-04-09 10:15:52'),
(24, ' slf4j-log4j日志框架配置+错误处理 ', '2017-03-16 02:34', '2017-04-09 10:15:53'),
(25, ' Log日志框架 ', '2017-03-16 02:11', '2017-04-09 10:15:59'),
(26, ' Log日志框架 ', '2017-03-16 02:11', '2017-04-09 10:16:00'),
(27, ' 根据时间生成唯一ID ', '2017-03-16 00:57', '2017-04-09 10:16:04'),
(28, ' 根据时间生成唯一ID ', '2017-03-16 00:57', '2017-04-09 10:16:05');

-- --------------------------------------------------------

--
-- 表的结构 `contract_gage`
--

CREATE TABLE IF NOT EXISTS `contract_gage` (
`id` int(11) NOT NULL,
  `contract_id` int(11) NOT NULL,
  `gage_id` int(11) NOT NULL,
  `quantity` double NOT NULL,
  `specification` varchar(50) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `note` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `ex_company`
--

CREATE TABLE IF NOT EXISTS `ex_company` (
`id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `type` int(11) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `note` text
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ex_company`
--

INSERT INTO `ex_company` (`id`, `name`, `type`, `address`, `contact`, `telephone`, `score`, `note`) VALUES
(1, '天武金属制造有限公司', 4, NULL, NULL, NULL, 0, NULL),
(2, '景泰陶瓷加工厂', 4, NULL, NULL, NULL, 3, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `ex_contract`
--

CREATE TABLE IF NOT EXISTS `ex_contract` (
  `id` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `account_manager_id` int(11) NOT NULL,
  `co_manager_id` int(11) NOT NULL,
  `from_date` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `to_date` timestamp NOT NULL,
  `loan` double NOT NULL,
  `status` int(11) NOT NULL,
  `note` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ex_contract`
--

INSERT INTO `ex_contract` (`id`, `type`, `company_id`, `account_manager_id`, `co_manager_id`, `from_date`, `to_date`, `loan`, `status`, `note`) VALUES
(1170300001, 0, 1, 2010060000, 2015060002, '2017-03-23 17:56:08', '2017-06-27 16:00:00', 10000000, 0, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `ex_staff`
--

CREATE TABLE IF NOT EXISTS `ex_staff` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `id_card` varchar(100) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `hire_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `level` int(11) NOT NULL,
  `post` varchar(50) NOT NULL,
  `department_id` int(11) NOT NULL,
  `note` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ex_staff`
--

INSERT INTO `ex_staff` (`id`, `name`, `id_card`, `telephone`, `hire_date`, `level`, `post`, `department_id`, `note`) VALUES
(2010060000, '刘珊珊', NULL, NULL, '2010-06-04 16:00:00', 12, '普通员工', 1, NULL),
(2015060002, '齐思远', NULL, NULL, '2015-06-04 16:00:00', 14, '普通员工', 1, NULL),
(2017030014, '钱天', NULL, NULL, '2017-03-21 17:36:51', 14, '普通员工', 1, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `gage`
--

CREATE TABLE IF NOT EXISTS `gage` (
`id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `type` int(11) NOT NULL,
  `max_pledge_rate` double NOT NULL,
  `warning_line` double NOT NULL,
  `dispose_line` double NOT NULL,
  `note` text
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `gage`
--

INSERT INTO `gage` (`id`, `name`, `type`, `max_pledge_rate`, `warning_line`, `dispose_line`, `note`) VALUES
(1, '特钢', 0, 0.6, 0.8, 0.9, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `gage_price`
--

CREATE TABLE IF NOT EXISTS `gage_price` (
`id` int(11) NOT NULL,
  `gage_id` int(11) NOT NULL,
  `price` double NOT NULL,
  `unit` varchar(20) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `source` varchar(200) NOT NULL,
  `note` text
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `gage_price`
--

INSERT INTO `gage_price` (`id`, `gage_id`, `price`, `unit`, `timestamp`, `source`, `note`) VALUES
(1, 1, 111.2, '元/吨', '2017-03-23 13:48:47', 'http://index.mysteel.com/xpic/detail.ms?tabName=tegang', NULL);

-- --------------------------------------------------------

--
-- 表的结构 `mail`
--

CREATE TABLE IF NOT EXISTS `mail` (
`id` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `content` text,
  `from_uid` int(11) NOT NULL,
  `to_uid` varchar(200) DEFAULT NULL,
  `send_time` timestamp NOT NULL,
  `urgency` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `note` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `mysteel`
--

CREATE TABLE IF NOT EXISTS `mysteel` (
`id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `time` varchar(50) NOT NULL,
  `price` double NOT NULL,
  `url` varchar(200) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `mysteel`
--

INSERT INTO `mysteel` (`id`, `name`, `time`, `price`, `url`, `timestamp`) VALUES
(1, '铜', '2017年04月07日 16:30', 47570, 'http://www.100ppi.com/sf/792.html', '2017-04-09 22:34:14'),
(2, '螺纹钢', '2017年04月07日 16:30', 3519.38, 'http://www.100ppi.com/sf/927.html', '2017-04-09 22:34:14'),
(3, '锌', '2017年04月07日 16:30', 23100, 'http://www.100ppi.com/sf/826.html', '2017-04-09 22:34:14'),
(4, '铝', '2017年04月07日 16:30', 13840, 'http://www.100ppi.com/sf/827.html', '2017-04-09 22:34:14'),
(5, '黄金', '2017年04月07日 16:30', 283.28, 'http://www.100ppi.com/sf/551.html', '2017-04-09 22:34:14'),
(6, '线材', '2017年04月07日 16:30', 3704.29, 'http://www.100ppi.com/sf/740.html', '2017-04-09 22:34:14'),
(7, '燃料油', '2017年04月07日 16:30', 3370, 'http://www.100ppi.com/sf/387.html', '2017-04-09 22:34:14'),
(8, '天然橡胶', '2017年04月07日 16:30', 14783.33, 'http://www.100ppi.com/sf/586.html', '2017-04-09 22:34:14'),
(9, '铅', '2017年04月07日 16:30', 17450, 'http://www.100ppi.com/sf/825.html', '2017-04-09 22:34:14'),
(10, '白银', '2017年04月07日 16:30', 4183.67, 'http://www.100ppi.com/sf/544.html', '2017-04-09 22:34:14'),
(11, '石油沥青', '2017年04月07日 16:30', 2848.47, 'http://www.100ppi.com/sf/1022.html', '2017-04-09 22:34:14'),
(12, '热轧卷板', '2017年04月07日 16:30', 3305.33, 'http://www.100ppi.com/sf/195.html', '2017-04-09 22:34:14'),
(13, '镍', '2017年04月07日 16:30', 83850, 'http://www.100ppi.com/sf/1182.html', '2017-04-09 22:34:14'),
(14, '锡', '2017年04月07日 16:30', 145500, 'http://www.100ppi.com/sf/1181.html', '2017-04-09 22:34:15'),
(15, 'PTA', '2017年04月07日 16:30', 4996.36, 'http://www.100ppi.com/sf/356.html', '2017-04-09 22:34:15'),
(16, '白糖', '2017年04月07日 16:30', 6652, 'http://www.100ppi.com/sf/1076.html', '2017-04-09 22:34:15'),
(17, '棉花', '2017年04月07日 16:30', 15847.43, 'http://www.100ppi.com/sf/344.html', '2017-04-09 22:34:15'),
(18, '普麦', '2017年04月07日 16:30', 2490, 'http://www.100ppi.com/sf/349.html', '2017-04-09 22:34:15'),
(19, '菜籽油OI', '2017年04月07日 16:30', 6275, 'http://www.100ppi.com/sf/1085.html', '2017-04-09 22:34:15'),
(20, '早籼稻RI', '2017年04月07日 16:30', 2644, 'http://www.100ppi.com/sf/1082.html', '2017-04-09 22:34:15'),
(21, '玻璃', '2017年04月07日 16:30', 15.79, 'http://www.100ppi.com/sf/959.html', '2017-04-09 22:34:15'),
(22, '菜籽粕', '2017年04月07日 16:30', 2467.14, 'http://www.100ppi.com/sf/1088.html', '2017-04-09 22:34:15'),
(23, '油菜籽', '2017年04月07日 16:30', 5112.5, 'http://www.100ppi.com/sf/1087.html', '2017-04-09 22:34:15'),
(24, '粳稻', '2017年04月07日 16:30', 2988, 'http://www.100ppi.com/sf/1083.html', '2017-04-09 22:34:15'),
(25, '晚籼稻', '2017年04月07日 16:30', 2703, 'http://www.100ppi.com/sf/1096.html', '2017-04-09 22:34:15'),
(26, '硅铁', '2017年04月07日 16:30', 5645, 'http://www.100ppi.com/sf/1154.html', '2017-04-09 22:34:15'),
(27, '锰硅', '2017年04月07日 16:30', 6918.75, 'http://www.100ppi.com/sf/1155.html', '2017-04-09 22:34:15'),
(28, '甲醇MA', '2017年04月07日 16:30', 2705, 'http://www.100ppi.com/sf/817.html', '2017-04-09 22:34:15'),
(29, '动力煤ZC', '2017年04月07日 16:30', 604, 'http://www.100ppi.com/sf/369.html', '2017-04-09 22:34:15'),
(30, '棕榈油', '2017年04月07日 16:30', 5865, 'http://www.100ppi.com/sf/1084.html', '2017-04-09 22:34:15'),
(31, '聚氯乙烯', '2017年04月07日 16:30', 5975, 'http://www.100ppi.com/sf/821.html', '2017-04-09 22:34:15'),
(32, '聚乙烯', '2017年04月07日 16:30', 9480, 'http://www.100ppi.com/sf/435.html', '2017-04-09 22:34:15'),
(33, '豆一', '2017年04月07日 16:30', 3790, 'http://www.100ppi.com/sf/1080.html', '2017-04-09 22:34:15'),
(34, '豆粕', '2017年04月07日 16:30', 2933.33, 'http://www.100ppi.com/sf/1078.html', '2017-04-09 22:34:15'),
(35, '豆油', '2017年04月07日 16:30', 6023.33, 'http://www.100ppi.com/sf/1079.html', '2017-04-09 22:34:15'),
(36, '玉米', '2017年04月07日 16:30', 1581.67, 'http://www.100ppi.com/sf/1077.html', '2017-04-09 22:34:15'),
(37, '焦炭', '2017年04月07日 16:30', 1763.33, 'http://www.100ppi.com/sf/617.html', '2017-04-09 22:34:15'),
(38, '焦煤', '2017年04月07日 16:30', 1346, 'http://www.100ppi.com/sf/978.html', '2017-04-09 22:34:15'),
(39, '铁矿石', '2017年04月07日 16:30', 629.44, 'http://www.100ppi.com/sf/961.html', '2017-04-09 22:34:16'),
(40, '鸡蛋', '2017年04月07日 16:30', 4.83, 'http://www.100ppi.com/sf/1086.html', '2017-04-09 22:34:16');

-- --------------------------------------------------------

--
-- 表的结构 `notice`
--

CREATE TABLE IF NOT EXISTS `notice` (
`id` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `contract_id` int(11) NOT NULL,
  `director_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `check_time` int(11) DEFAULT NULL,
  `attach_path` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `notice_gage`
--

CREATE TABLE IF NOT EXISTS `notice_gage` (
`id` int(11) NOT NULL,
  `notice_id` int(11) NOT NULL,
  `gage_id` int(11) NOT NULL,
  `quantity` double NOT NULL,
  `note` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `regulate_account`
--

CREATE TABLE IF NOT EXISTS `regulate_account` (
`id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `gage_id` int(11) NOT NULL,
  `quantity` double NOT NULL,
  `timestamp` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `note` text
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `regulators`
--

CREATE TABLE IF NOT EXISTS `regulators` (
`id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `contact` varchar(50) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `score` double NOT NULL,
  `note` text
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `regulators`
--

INSERT INTO `regulators` (`id`, `name`, `address`, `contact`, `telephone`, `email`, `score`, `note`) VALUES
(1, '信业监管公司', '南京市', '周康', '13802138722', 'ee@aa.cn', 9.5, ''),
(2, '鑫诚监管公司', '无锡市', '沈晓敏', '18922131252', '', 9, ''),
(3, '惠友监管公司', NULL, '金婷婷', '17830662941', NULL, 8.8, NULL),
(5, '金蝶监管公司', NULL, '蔡琳', '15021873217', NULL, 9.2, NULL),
(6, '金宝股份有限公司', '无锡市', '刘琦', '12873672899', 'lq@qq.com', 9, '');

-- --------------------------------------------------------

--
-- 表的结构 `regulators_company`
--

CREATE TABLE IF NOT EXISTS `regulators_company` (
  `id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `regulators_id` int(11) NOT NULL,
  `from_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `to_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fee` double NOT NULL,
  `status` int(11) NOT NULL,
  `note` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `regulators_company`
--

INSERT INTO `regulators_company` (`id`, `company_id`, `regulators_id`, `from_date`, `to_date`, `fee`, `status`, `note`) VALUES
(10010050, 1, 5, '2016-12-31 16:00:00', '2017-06-30 16:00:00', 0.002, 0, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `role_view`
--

CREATE TABLE IF NOT EXISTS `role_view` (
`id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `view_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='暂时用常量';

-- --------------------------------------------------------

--
-- 表的结构 `st_department`
--

CREATE TABLE IF NOT EXISTS `st_department` (
`id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `organization_id` int(11) NOT NULL,
  `note` text
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `st_department`
--

INSERT INTO `st_department` (`id`, `name`, `organization_id`, `note`) VALUES
(1, '公司部', 5, NULL),
(2, '公司部', 4, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `st_organization`
--

CREATE TABLE IF NOT EXISTS `st_organization` (
`id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `level` int(11) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `note` text
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `st_organization`
--

INSERT INTO `st_organization` (`id`, `name`, `level`, `address`, `phone`, `parent_id`, `note`) VALUES
(4, '总行', 0, '北京市', '010-8372649', NULL, NULL),
(5, '南京省行', 1, '南京市新街口', NULL, 4, NULL),
(6, '无锡分行', 2, '无锡市滨湖区', NULL, 5, NULL),
(7, '南长支行', 3, '无锡市南长区春生路234号', '0510-82133277', 6, NULL),
(8, '常州分行', 2, '常州市', NULL, 5, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
`id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL COMMENT '（员工s+id，监管机构r+id，监管员=客户企业c+id）',
  `role_id` int(11) NOT NULL,
  `password` varchar(50) NOT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `register_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(11) DEFAULT NULL COMMENT '登录状态',
  `last_login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_change_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `note` text
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `name`, `role_id`, `password`, `telephone`, `register_time`, `status`, `last_login_time`, `last_change_time`, `note`) VALUES
(1, 'a', 1, 'a', '123', '2017-03-09 08:34:08', 0, '2017-03-09 08:34:08', '2017-03-18 20:37:39', ''),
(8, 'c', 1, 'c', '223333', '2017-03-09 09:20:51', 0, '2017-03-09 09:20:51', '2017-03-09 09:20:51', ''),
(9, 'q', 0, 'q', '111', '2017-03-09 14:37:25', 1, '2017-03-09 14:37:25', '2017-03-09 14:37:25', ''),
(14, 'w', 0, 'w', '0510-85231198', '2017-03-11 06:30:54', 0, '2017-03-11 06:30:54', '2017-03-11 06:30:54', ''),
(26, '33', 0, '33', NULL, '2017-03-12 22:37:58', 0, '2017-03-12 22:37:58', '2017-03-12 22:37:58', NULL),
(28, 'try2', 6, 't', '12312312312', '2017-03-14 09:15:29', 0, '2017-03-14 09:15:29', '2017-03-14 09:15:29', 'note'),
(33, 's2314', 1, '8888', '123456324487', '2017-04-03 04:18:26', 0, '2017-04-03 04:18:26', '2017-04-03 04:18:26', ''),
(34, 's7206460', 5, 's', '15023521732', '2017-04-03 10:09:55', 0, '2017-04-03 10:09:55', '2017-04-03 10:09:55', ''),
(35, 's23459887', 6, '8888', '', '2017-04-06 16:01:32', 0, '2017-04-06 16:01:32', '2017-04-06 16:01:32', '');

-- --------------------------------------------------------

--
-- 表的结构 `warehouse_list`
--

CREATE TABLE IF NOT EXISTS `warehouse_list` (
`id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `gage_id` int(11) NOT NULL,
  `quantity` double NOT NULL,
  `specification` varchar(50) DEFAULT NULL,
  `owner` int(11) DEFAULT NULL,
  `timestamp` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `submitter_id` int(11) DEFAULT NULL,
  `note` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `warning`
--

CREATE TABLE IF NOT EXISTS `warning` (
`id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `type` int(11) NOT NULL COMMENT '数量、价值、监管预警',
  `from_id` int(11) NOT NULL,
  `severity` int(11) NOT NULL,
  `status` int(11) NOT NULL COMMENT '未处理、处理中、已处理',
  `handle_id` int(11) DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `note` text
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `warning`
--

INSERT INTO `warning` (`id`, `company_id`, `type`, `from_id`, `severity`, `status`, `handle_id`, `timestamp`, `note`) VALUES
(1, 1, 0, 1, 0, 2, 14, '2017-04-06 14:20:59', '清收处理'),
(2, 2, 2, 14, 2, 3, NULL, '2017-04-07 13:06:04', '解除');

-- --------------------------------------------------------

--
-- 表的结构 `warning_user`
--

CREATE TABLE IF NOT EXISTS `warning_user` (
  `warning_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `warning_user`
--

INSERT INTO `warning_user` (`warning_id`, `user_id`) VALUES
(2, 1),
(1, 8),
(2, 8),
(1, 9),
(2, 9),
(1, 14),
(2, 14),
(2, 26),
(2, 28),
(2, 33),
(2, 34),
(2, 35);

-- --------------------------------------------------------

--
-- 表的结构 `_config`
--

CREATE TABLE IF NOT EXISTS `_config` (
`id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `value` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `_config`
--

INSERT INTO `_config` (`id`, `name`, `value`) VALUES
(1, 'key', 'value'),
(3, 'k', 'v');

-- --------------------------------------------------------

--
-- 表的结构 `_role`
--

CREATE TABLE IF NOT EXISTS `_role` (
`id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `view` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `_view`
--

CREATE TABLE IF NOT EXISTS `_view` (
`id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `parent_name` varchar(50) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `url` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='暂时enum代替';

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bidding`
--
ALTER TABLE `bidding`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bidding_regulators`
--
ALTER TABLE `bidding_regulators`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `bidding_id` (`bidding_id`,`regulators_id`), ADD KEY `regulators_id` (`regulators_id`);

--
-- Indexes for table `blog`
--
ALTER TABLE `blog`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `contract_gage`
--
ALTER TABLE `contract_gage`
 ADD PRIMARY KEY (`id`), ADD KEY `contract_id` (`contract_id`), ADD KEY `gage_id` (`gage_id`);

--
-- Indexes for table `ex_company`
--
ALTER TABLE `ex_company`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ex_contract`
--
ALTER TABLE `ex_contract`
 ADD PRIMARY KEY (`id`), ADD KEY `company_id` (`company_id`), ADD KEY `account_manager_id` (`account_manager_id`), ADD KEY `co_manager_id` (`co_manager_id`);

--
-- Indexes for table `ex_staff`
--
ALTER TABLE `ex_staff`
 ADD PRIMARY KEY (`id`), ADD KEY `department_id` (`department_id`);

--
-- Indexes for table `gage`
--
ALTER TABLE `gage`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `gage_price`
--
ALTER TABLE `gage_price`
 ADD PRIMARY KEY (`id`), ADD KEY `gage_id` (`gage_id`);

--
-- Indexes for table `mail`
--
ALTER TABLE `mail`
 ADD PRIMARY KEY (`id`), ADD KEY `from_id` (`from_uid`);

--
-- Indexes for table `mysteel`
--
ALTER TABLE `mysteel`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `name` (`name`,`time`);

--
-- Indexes for table `notice`
--
ALTER TABLE `notice`
 ADD PRIMARY KEY (`id`), ADD KEY `account_manager_id` (`contract_id`), ADD KEY `director_id` (`director_id`);

--
-- Indexes for table `notice_gage`
--
ALTER TABLE `notice_gage`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `notice_id` (`notice_id`,`gage_id`), ADD KEY `gage_id` (`gage_id`);

--
-- Indexes for table `regulate_account`
--
ALTER TABLE `regulate_account`
 ADD PRIMARY KEY (`id`), ADD KEY `company_id` (`company_id`), ADD KEY `gage_id` (`gage_id`);

--
-- Indexes for table `regulators`
--
ALTER TABLE `regulators`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `regulators_company`
--
ALTER TABLE `regulators_company`
 ADD PRIMARY KEY (`id`), ADD KEY `company_id` (`company_id`), ADD KEY `regulators_id` (`regulators_id`);

--
-- Indexes for table `role_view`
--
ALTER TABLE `role_view`
 ADD PRIMARY KEY (`id`), ADD KEY `role_id` (`role_id`), ADD KEY `view_id` (`view_id`);

--
-- Indexes for table `st_department`
--
ALTER TABLE `st_department`
 ADD PRIMARY KEY (`id`), ADD KEY `organization_id` (`organization_id`);

--
-- Indexes for table `st_organization`
--
ALTER TABLE `st_organization`
 ADD PRIMARY KEY (`id`), ADD KEY `parent_id` (`parent_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `uname` (`name`);

--
-- Indexes for table `warehouse_list`
--
ALTER TABLE `warehouse_list`
 ADD PRIMARY KEY (`id`), ADD KEY `submitter_id` (`submitter_id`), ADD KEY `gage_id` (`gage_id`), ADD KEY `company_id` (`company_id`);

--
-- Indexes for table `warning`
--
ALTER TABLE `warning`
 ADD PRIMARY KEY (`id`), ADD KEY `company_id` (`company_id`), ADD KEY `from_id` (`from_id`), ADD KEY `handle_id` (`handle_id`);

--
-- Indexes for table `warning_user`
--
ALTER TABLE `warning_user`
 ADD PRIMARY KEY (`warning_id`,`user_id`), ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `_config`
--
ALTER TABLE `_config`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `_role`
--
ALTER TABLE `_role`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `_view`
--
ALTER TABLE `_view`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bidding`
--
ALTER TABLE `bidding`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `bidding_regulators`
--
ALTER TABLE `bidding_regulators`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `blog`
--
ALTER TABLE `blog`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `contract_gage`
--
ALTER TABLE `contract_gage`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `ex_company`
--
ALTER TABLE `ex_company`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `gage`
--
ALTER TABLE `gage`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `gage_price`
--
ALTER TABLE `gage_price`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `mail`
--
ALTER TABLE `mail`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `mysteel`
--
ALTER TABLE `mysteel`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT for table `notice`
--
ALTER TABLE `notice`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `notice_gage`
--
ALTER TABLE `notice_gage`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `regulate_account`
--
ALTER TABLE `regulate_account`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `regulators`
--
ALTER TABLE `regulators`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `role_view`
--
ALTER TABLE `role_view`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `st_department`
--
ALTER TABLE `st_department`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `st_organization`
--
ALTER TABLE `st_organization`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `warehouse_list`
--
ALTER TABLE `warehouse_list`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `warning`
--
ALTER TABLE `warning`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `_config`
--
ALTER TABLE `_config`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `_role`
--
ALTER TABLE `_role`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `_view`
--
ALTER TABLE `_view`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- 限制导出的表
--

--
-- 限制表 `bidding_regulators`
--
ALTER TABLE `bidding_regulators`
ADD CONSTRAINT `bidding_regulators_ibfk_1` FOREIGN KEY (`bidding_id`) REFERENCES `bidding` (`id`),
ADD CONSTRAINT `bidding_regulators_ibfk_2` FOREIGN KEY (`regulators_id`) REFERENCES `regulators` (`id`);

--
-- 限制表 `contract_gage`
--
ALTER TABLE `contract_gage`
ADD CONSTRAINT `contract_gage_ibfk_1` FOREIGN KEY (`contract_id`) REFERENCES `ex_contract` (`id`),
ADD CONSTRAINT `contract_gage_ibfk_3` FOREIGN KEY (`gage_id`) REFERENCES `gage` (`id`);

--
-- 限制表 `ex_contract`
--
ALTER TABLE `ex_contract`
ADD CONSTRAINT `ex_contract_ibfk_2` FOREIGN KEY (`account_manager_id`) REFERENCES `ex_staff` (`id`),
ADD CONSTRAINT `ex_contract_ibfk_3` FOREIGN KEY (`co_manager_id`) REFERENCES `ex_staff` (`id`),
ADD CONSTRAINT `ex_contract_ibfk_4` FOREIGN KEY (`company_id`) REFERENCES `ex_company` (`id`);

--
-- 限制表 `ex_staff`
--
ALTER TABLE `ex_staff`
ADD CONSTRAINT `ex_staff_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `st_department` (`id`);

--
-- 限制表 `gage_price`
--
ALTER TABLE `gage_price`
ADD CONSTRAINT `gage_price_ibfk_1` FOREIGN KEY (`gage_id`) REFERENCES `gage` (`id`);

--
-- 限制表 `mail`
--
ALTER TABLE `mail`
ADD CONSTRAINT `mail_ibfk_1` FOREIGN KEY (`from_uid`) REFERENCES `user` (`id`);

--
-- 限制表 `notice`
--
ALTER TABLE `notice`
ADD CONSTRAINT `notice_ibfk_2` FOREIGN KEY (`director_id`) REFERENCES `user` (`id`),
ADD CONSTRAINT `notice_ibfk_5` FOREIGN KEY (`contract_id`) REFERENCES `ex_contract` (`id`);

--
-- 限制表 `notice_gage`
--
ALTER TABLE `notice_gage`
ADD CONSTRAINT `notice_gage_ibfk_1` FOREIGN KEY (`notice_id`) REFERENCES `notice` (`id`),
ADD CONSTRAINT `notice_gage_ibfk_2` FOREIGN KEY (`gage_id`) REFERENCES `gage` (`id`);

--
-- 限制表 `regulate_account`
--
ALTER TABLE `regulate_account`
ADD CONSTRAINT `regulate_account_ibfk_2` FOREIGN KEY (`gage_id`) REFERENCES `gage` (`id`),
ADD CONSTRAINT `regulate_account_ibfk_3` FOREIGN KEY (`company_id`) REFERENCES `ex_company` (`id`);

--
-- 限制表 `regulators_company`
--
ALTER TABLE `regulators_company`
ADD CONSTRAINT `regulators_company_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `ex_company` (`id`),
ADD CONSTRAINT `regulators_company_ibfk_2` FOREIGN KEY (`regulators_id`) REFERENCES `regulators` (`id`);

--
-- 限制表 `role_view`
--
ALTER TABLE `role_view`
ADD CONSTRAINT `role_view_ibfk_1` FOREIGN KEY (`view_id`) REFERENCES `_view` (`id`),
ADD CONSTRAINT `role_view_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `_role` (`id`);

--
-- 限制表 `st_department`
--
ALTER TABLE `st_department`
ADD CONSTRAINT `st_department_ibfk_1` FOREIGN KEY (`organization_id`) REFERENCES `st_organization` (`id`);

--
-- 限制表 `st_organization`
--
ALTER TABLE `st_organization`
ADD CONSTRAINT `st_organization_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `st_organization` (`id`);

--
-- 限制表 `warehouse_list`
--
ALTER TABLE `warehouse_list`
ADD CONSTRAINT `warehouse_list_ibfk_1` FOREIGN KEY (`gage_id`) REFERENCES `gage` (`id`),
ADD CONSTRAINT `warehouse_list_ibfk_2` FOREIGN KEY (`submitter_id`) REFERENCES `user` (`id`),
ADD CONSTRAINT `warehouse_list_ibfk_3` FOREIGN KEY (`company_id`) REFERENCES `ex_company` (`id`);

--
-- 限制表 `warning`
--
ALTER TABLE `warning`
ADD CONSTRAINT `warning_ibfk_3` FOREIGN KEY (`from_id`) REFERENCES `user` (`id`),
ADD CONSTRAINT `warning_ibfk_4` FOREIGN KEY (`handle_id`) REFERENCES `user` (`id`),
ADD CONSTRAINT `warning_ibfk_5` FOREIGN KEY (`company_id`) REFERENCES `ex_company` (`id`);

--
-- 限制表 `warning_user`
--
ALTER TABLE `warning_user`
ADD CONSTRAINT `warning_user_ibfk_1` FOREIGN KEY (`warning_id`) REFERENCES `warning` (`id`),
ADD CONSTRAINT `warning_user_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
