-- =============================================================================
-- Diagram Name: 数据库设计
-- Created on: 2012/3/17 11:07:11
-- Diagram Version: 
-- =============================================================================
SET FOREIGN_KEY_CHECKS=0;

-- Drop table member
DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(12) NOT NULL COMMENT '学号，登陆账号',
  `name` varchar(8) NOT NULL,
  `password` varchar(32) NOT NULL,
  `state` int(11) COMMENT '表示在职，退出',
  `role` int(11) COMMENT '角色',
  `type` int(11) NOT NULL COMMENT '表示老师，学生，毕业',
  `is_public` tinyint(4) NOT NULL COMMENT '是否对外公开',
  PRIMARY KEY(`id`),
  UNIQUE INDEX `student_id`(`student_id`)
)
ENGINE=MYISAM
COMMENT = '成员\201\2'
ROW_FORMAT=default
CHARACTER SET utf8 
COLLATE utf8_bin ;

-- Drop table project
DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `detail` varchar(500),
  `state_date` date,
  `end_date` date,
  `state` int(11) COMMENT '表示正在进行，结题',
  `is_public` tinyint(4) NOT NULL COMMENT '是否对外公开',
  `department_id` int(11),
  PRIMARY KEY(`id`)
)
ENGINE=MYISAM
COMMENT = '项目'
ROW_FORMAT=default;

-- Drop table department
DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `detail` varchar(500),
  PRIMARY KEY(`id`)
)
ENGINE=MYISAM
COMMENT = '部门'
ROW_FORMAT=default
CHARACTER SET utf8 
COLLATE utf8_bin ;

-- Drop table meeting
DROP TABLE IF EXISTS `meeting`;

CREATE TABLE `meeting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `state` int(11) COMMENT '是否删除',
  PRIMARY KEY(`id`)
)
ENGINE=MYISAM
COMMENT = '会议'
ROW_FORMAT=default
CHARACTER SET utf8 
COLLATE utf8_bin ;

-- Drop table project_member
DROP TABLE IF EXISTS `project_member`;

CREATE TABLE `project_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `job` varchar(100) COMMENT '职责',
  `type` int(11) NOT NULL COMMENT '表示成员或组长',
  PRIMARY KEY(`id`),
  UNIQUE INDEX `key`(`project_id`, `member_id`)
)
ENGINE=MYISAM
COMMENT = '项目成员'
ROW_FORMAT=default
CHARACTER SET utf8 
COLLATE utf8_bin ;

-- Drop table department_member
DROP TABLE IF EXISTS `department_member`;

CREATE TABLE `department_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `type` int(11) NOT NULL COMMENT '表示成员或负责人',
  PRIMARY KEY(`id`),
  UNIQUE INDEX `key`(`department_id`, `member_id`)
)
ENGINE=MYISAM
COMMENT = '部门成员'
ROW_FORMAT=default
CHARACTER SET utf8 
COLLATE utf8_bin ;

-- Drop table attendance
DROP TABLE IF EXISTS `attendance`;

CREATE TABLE `attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `meeting_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `state` int(11) NOT NULL COMMENT '出席状态',
  `reason` varchar(100),
  `is_attend` int(11) COMMENT '是否参加',
  PRIMARY KEY(`id`),
  UNIQUE INDEX `key`(`meeting_id`, `member_id`)
)
ENGINE=MYISAM
COMMENT = '考勤'
ROW_FORMAT=default
CHARACTER SET utf8 
COLLATE utf8_bin ;

-- Drop table report
DROP TABLE IF EXISTS `report`;

CREATE TABLE `report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `meeting_id` int(11) NOT NULL,
  `comment` varchar(500) COMMENT '汇报记录',
  `is_report` int(11) COMMENT '是否参与汇报',
  PRIMARY KEY(`id`),
  UNIQUE INDEX `key`(`project_id`, `meeting_id`)
)
ENGINE=MYISAM
COMMENT = '项目汇报'
ROW_FORMAT=default
CHARACTER SET utf8 
COLLATE utf8_bin ;

-- Drop table member_extend
DROP TABLE IF EXISTS `member_extend`;

CREATE TABLE `member_extend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11),
  `sex` tinyint(4) NOT NULL,
  `familyaddress` varchar(256),
  `nativeplace` varchar(128),
  `folk` varchar(32),
  `card_id` varchar(18),
  `homepage` varchar(256),
  `birthday` date,
  `email` varchar(128),
  `mobile` varchar(13),
  `mobileshort` varchar(6),
  `grade` int(11),
  `academy` varchar(32),
  `major` varchar(32),
  PRIMARY KEY(`id`),
  UNIQUE INDEX `member_id`(`member_id`)
)
ENGINE=MYISAM
COMMENT = '成员详细资料'
ROW_FORMAT=default
CHARACTER SET utf8 
COLLATE utf8_bin ;

-- Drop table message
DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL COMMENT '信息类型',
  `content` text,
  `date` date NOT NULL,
  `member_id` int(11) NOT NULL,
  PRIMARY KEY(`id`)
)
ENGINE=MYISAM
COMMENT = '消息'
ROW_FORMAT=default
CHARACTER SET utf8 
COLLATE utf8_bin ;

-- Drop table member_message
DROP TABLE IF EXISTS `member_message`;

CREATE TABLE `member_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) NOT NULL,
  `message_id` int(11) NOT NULL,
  `state` int(11) NOT NULL COMMENT '表示读否',
  `read_time` timestamp,
  `reply` varchar(512) COMMENT '信息回复',
  `type` int(11) COMMENT '信息类型',
  PRIMARY KEY(`id`),
  UNIQUE INDEX `key`(`member_id`, `message_id`)
)
ENGINE=MYISAM
COMMENT = '成员消息'
ROW_FORMAT=default
CHARACTER SET utf8 
COLLATE utf8_bin ;

-- Drop table file
DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(128),
  `name` varchar(128),
  `suffix` varchar(32),
  `time` timestamp,
  `is_public` tinyint(4),
  PRIMARY KEY(`id`)
)
ENGINE=MYISAM
COMMENT = '文件'
ROW_FORMAT=default
CHARACTER SET utf8 
COLLATE utf8_bin ;

-- Drop table report_file
DROP TABLE IF EXISTS `report_file`;

CREATE TABLE `report_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `report_id` int(11) NOT NULL,
  `file_id` int(11) NOT NULL,
  PRIMARY KEY(`id`),
  INDEX `key`(`report_id`, `file_id`)
)
ENGINE=MYISAM
COMMENT = '汇报文件'
ROW_FORMAT=default
CHARACTER SET utf8 
COLLATE utf8_bin ;

-- Drop table report_member
DROP TABLE IF EXISTS `report_member`;

CREATE TABLE `report_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) NOT NULL,
  `report_id` int(11) NOT NULL,
  PRIMARY KEY(`id`),
  UNIQUE INDEX `key`(`member_id`, `report_id`)
)
ENGINE=MYISAM
ROW_FORMAT=default
CHARACTER SET utf8 
COLLATE utf8_bin ;


ALTER TABLE `project` ADD
  CONSTRAINT `Ref_23` FOREIGN KEY (`department_id`)
    REFERENCES `department`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `project_member` ADD
  CONSTRAINT `Ref_01` FOREIGN KEY (`member_id`)
    REFERENCES `member`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `project_member` ADD
  CONSTRAINT `Ref_02` FOREIGN KEY (`project_id`)
    REFERENCES `project`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `department_member` ADD
  CONSTRAINT `Ref_03` FOREIGN KEY (`member_id`)
    REFERENCES `member`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `department_member` ADD
  CONSTRAINT `Ref_04` FOREIGN KEY (`department_id`)
    REFERENCES `department`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `attendance` ADD
  CONSTRAINT `Ref_07` FOREIGN KEY (`member_id`)
    REFERENCES `member`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `attendance` ADD
  CONSTRAINT `Ref_08` FOREIGN KEY (`meeting_id`)
    REFERENCES `meeting`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `report` ADD
  CONSTRAINT `Ref_09` FOREIGN KEY (`project_id`)
    REFERENCES `project`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `report` ADD
  CONSTRAINT `Ref_10` FOREIGN KEY (`meeting_id`)
    REFERENCES `meeting`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `member_extend` ADD
  CONSTRAINT `Ref_12` FOREIGN KEY (`member_id`)
    REFERENCES `member`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `message` ADD
  CONSTRAINT `Ref_16` FOREIGN KEY (`member_id`)
    REFERENCES `member`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `member_message` ADD
  CONSTRAINT `Ref_14` FOREIGN KEY (`member_id`)
    REFERENCES `member`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `member_message` ADD
  CONSTRAINT `Ref_15` FOREIGN KEY (`message_id`)
    REFERENCES `message`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `report_file` ADD
  CONSTRAINT `Ref_17` FOREIGN KEY (`report_id`)
    REFERENCES `report`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `report_file` ADD
  CONSTRAINT `Ref_18` FOREIGN KEY (`file_id`)
    REFERENCES `file`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `report_member` ADD
  CONSTRAINT `Ref_26` FOREIGN KEY (`report_id`)
    REFERENCES `report`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `report_member` ADD
  CONSTRAINT `Ref_27` FOREIGN KEY (`member_id`)
    REFERENCES `member`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

SET FOREIGN_KEY_CHECKS=1;
