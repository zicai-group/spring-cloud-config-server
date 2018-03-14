DROP TABLE IF EXISTS `app_props`;

CREATE TABLE `app_props`(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `prop_key` VARCHAR(255) NOT NULL ,
  `prop_value` VARCHAR(255) ,
  `app_name` VARCHAR(255) NOT NULL ,
  `app_env` VARCHAR(255) NOT NULL ,
  `app_label` VARCHAR(255) ,
  PRIMARY KEY (`id`)
);

INSERT INTO `app_props` (`prop_key`, `prop_value`, `app_name`, `app_env`, `app_label`) VALUES ('k_a', 'k_a_1', 'config-sample', 'test', 'master');
INSERT INTO `app_props` (`prop_key`, `prop_value`, `app_name`, `app_env`, `app_label`) VALUES ('k_b', 'k_b_1', 'config-sample', 'test', 'master');

DROP TABLE IF EXISTS `published`;

CREATE TABLE `published`(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `app_name` VARCHAR(255) NOT NULL ,
  `publish_time` DATETIME NOT NULL ,
  PRIMARY KEY (`id`)
);

INSERT INTO `published` (`app_name`, `publish_time`) VALUES ('config-sample', now());
