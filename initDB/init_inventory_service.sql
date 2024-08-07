CREATE TABLE `t_inventory`
(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `sku_code`  varchar(255) DEFAULT NULL,
    `quantity` int(11)      DEFAULT NULL,
    PRIMARY KEY (`id`)
);

insert into `t_inventory` (quantity, sku_code)
values (100, 'cake'),
       (100, 'fruit'),
       (100, 'beer'),
       (100, 'soda');