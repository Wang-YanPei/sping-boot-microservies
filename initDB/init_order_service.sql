CREATE TABLE `t_orders`
(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `order_number` varchar(255) DEFAULT NULL,
    `sku_code`  varchar(255),
    `price`    decimal(19, 2),
    `quantity` int(11),
    PRIMARY KEY (`id`)
);

INSERT INTO `t_orders` (`order_number`, `sku_code`, `price`, `quantity`)
VALUES ('ORD-001', 'cake', 50.00, 1),
       ('ORD-002', 'fruit', 75.00, 2);