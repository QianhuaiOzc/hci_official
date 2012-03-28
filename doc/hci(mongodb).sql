-- =============================================================================
-- Diagram Name: 数据库设计（mongodb）
-- Created on: 2012/3/4 11:04:58
-- Diagram Version: 
-- =============================================================================
SET FOREIGN_KEY_CHECKS=0;

-- Drop table api
DROP TABLE IF EXISTS `api`;

CREATE TABLE `api` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(16) NOT NULL,
  `note` varchar(1024),
  `state` int(11) NOT NULL,
  `time` timestamp,
  PRIMARY KEY(`id`),
  UNIQUE INDEX `key`(`key`)
)
ENGINE=MYISAM
COMMENT = 'API'
ROW_FORMAT=default
CHARACTER SET utf8 
COLLATE utf8_bin ;

-- Drop table text
DROP TABLE IF EXISTS `text`;

CREATE TABLE `text` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(256),
  `content` text NOT NULL,
  `member_id` int(11) NOT NULL,
  `create_time` timestamp NOT NULL,
  `update_time` timestamp,
  PRIMARY KEY(`id`)
)
ENGINE=MYISAM
COMMENT = '文本'
ROW_FORMAT=default
CHARACTER SET utf8 
COLLATE utf8_bin ;

-- Drop table interview
DROP TABLE IF EXISTS `interview`;

CREATE TABLE `interview` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(12) NOT NULL,
  `name` varchar(8) NOT NULL,
  `grade` int(11) NOT NULL,
  `academy` varchar(32),
  `major` varchar(32) NOT NULL,
  `class` int(11),
  `content` varchar(1024),
  `date` date NOT NULL,
  PRIMARY KEY(`id`)
)
ENGINE=MYISAM
COMMENT = '面试记录'
ROW_FORMAT=default
CHARACTER SET utf8 
COLLATE utf8_bin ;

-- Drop table log
DROP TABLE IF EXISTS `log`;

CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) NOT NULL,
  `ip` varchar(32) NOT NULL,
  `agent` varchar(512),
  `time` timestamp NOT NULL,
  `content` varchar(2048),
  `response_time` int(11),
  PRIMARY KEY(`id`)
)
ENGINE=MYISAM
COMMENT = '日志'
ROW_FORMAT=default
CHARACTER SET utf8 
COLLATE utf8_bin ;

-- Drop table interviewer
DROP TABLE IF EXISTS `interviewer`;

CREATE TABLE `interviewer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) NOT NULL,
  `interview_id` int(11) NOT NULL,
  PRIMARY KEY(`id`),
  UNIQUE INDEX `key`(`member_id`, `interview_id`)
)
ENGINE=MYISAM
COMMENT = '面试参与人员'
ROW_FORMAT=default
CHARACTER SET utf8 
COLLATE utf8_bin ;

-- Drop table api_log
DROP TABLE IF EXISTS `api_log`;

CREATE TABLE `api_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `api_id` int(11) NOT NULL,
  `time` timestamp NOT NULL,
  `response_time` int(11),
  `content` int(11),
  PRIMARY KEY(`id`)
)
ENGINE=MYISAM
COMMENT = 'API 调用日志'
ROW_FORMAT=default;

-- Drop table note
DROP TABLE IF EXISTS `note`;

CREATE TABLE `note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text_id` int(11) NOT NULL,
  PRIMARY KEY(`id`)
)
ENGINE=MYISAM
COMMENT = '记事本，笔记'
ROW_FORMAT=default;

-- Drop table article
DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text_id` int(11) NOT NULL,
  `state` int(11),
  PRIMARY KEY(`id`)
)
ENGINE=MYISAM
COMMENT = '文章'
ROW_FORMAT=default
CHARACTER SET utf8 
COLLATE utf8_bin ;

SET FOREIGN_KEY_CHECKS=1;
