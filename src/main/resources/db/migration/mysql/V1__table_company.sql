CREATE TABLE `point`.`company` (
	`id` BIGINT(20) NOT NULL,
	`name` VARCHAR(255) NOT NULL,
	`cnpj` VARCHAR(20) NOT NULL,
	`date_created` DATETIME NOT NULL,
	`date_updated` DATETIME NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `point`.`company` ADD PRIMARY KEY (`id`);

ALTER TABLE `point`.`company` MODIFY `id` BIGINT(20) NOT NULL AUTO_INCREMENT;