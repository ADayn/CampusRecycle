INSERT INTO categories (id, name) VALUES
  (1, 'Electronics'),
  (2, 'Bikes'),
  (3, 'Books'),
  (4, 'Others');
INSERT  INTO users (id, email, username, password, deleted) VALUES
  (1, 'a@a.a', 'u', 'p', false),
  (2, 'si@si', 'si', 'si',false);
INSERT INTO admins(id, email, username, password) VALUES
  (1, 'admin@admin', 'admin', 'admin');

INSERT INTO `item` (`id`,`date_posted`,`description`,`image`,`price`,`state`,`title`,`buyer_id`,`category_id`,`seller_id`,`is_rated`,`rate_value`) VALUES (2,'2018-04-24','a laptop',NULL,200,'PENDING','a laptop bought in 2015',NULL,1,2,0,0);
INSERT INTO `item` (`id`,`date_posted`,`description`,`image`,`price`,`state`,`title`,`buyer_id`,`category_id`,`seller_id`,`is_rated`,`rate_value`) VALUES (3,'2018-04-24','mountain bike',NULL,30,'PENDING','good mountain bike, bought in 2014',NULL,2,2,0,0);
INSERT INTO `item` (`id`,`date_posted`,`description`,`image`,`price`,`state`,`title`,`buyer_id`,`category_id`,`seller_id`,`is_rated`,`rate_value`) VALUES (4,'2018-04-24','a laptop',NULL,300,'ACTIVE','a DELL laptop',NULL,1,2,0,0);
INSERT INTO `item` (`id`,`date_posted`,`description`,`image`,`price`,`state`,`title`,`buyer_id`,`category_id`,`seller_id`,`is_rated`,`rate_value`) VALUES (5,'2018-04-24','mountain bike',NULL,30,'ACTIVE','bike',NULL,2,2,0,0);
INSERT INTO `item` (`id`,`date_posted`,`description`,`image`,`price`,`rate_value`,`is_rated`,`state`,`title`,`buyer_id`,`category_id`,`seller_id`) VALUES (6,'2018-04-24','an ipad',NULL,300,0,0,'SOLD','an ipad',1,1,2);
INSERT INTO `item` (`id`,`date_posted`,`description`,`image`,`price`,`rate_value`,`is_rated`,`state`,`title`,`buyer_id`,`category_id`,`seller_id`) VALUES (7,'2018-04-24','city bike',NULL,30,0,0,'SOLD','bike',1,2,2);
INSERT INTO `item` (`id`,`date_posted`,`description`,`image`,`price`,`state`,`title`,`buyer_id`,`category_id`,`seller_id`,`is_rated`,`rate_value`) VALUES (8,'2018-04-24','mountain bike2',NULL,20,'ACTIVE','bike',NULL,2,1,0,0);
INSERT INTO `item` (`id`,`date_posted`,`description`,`image`,`price`,`state`,`title`,`buyer_id`,`category_id`,`seller_id`,`is_rated`,`rate_value`) VALUES (9,'2018-04-23','mountain bike',NULL,80,'ACTIVE','bike',NULL,2,1,0,0);
INSERT INTO `item` (`id`,`date_posted`,`description`,`image`,`price`,`state`,`title`,`buyer_id`,`category_id`,`seller_id`,`is_rated`,`rate_value`) VALUES (10,'2018-04-22','mountain bike2',NULL,10,'ACTIVE','bike',NULL,2,1,0,0);
INSERT INTO `item` (`id`,`date_posted`,`description`,`image`,`price`,`state`,`title`,`buyer_id`,`category_id`,`seller_id`,`is_rated`,`rate_value`) VALUES (11,'2018-04-21','mountain bike2',NULL,70,'ACTIVE','bike',NULL,2,1,0,0);
INSERT INTO `item` (`id`,`date_posted`,`description`,`image`,`price`,`state`,`title`,`buyer_id`,`category_id`,`seller_id`,`is_rated`,`rate_value`) VALUES (12,'2018-04-20','mountain bike2',NULL,60,'ACTIVE','bike',NULL,2,1,0,0);
INSERT INTO `item` (`id`,`date_posted`,`description`,`image`,`price`,`state`,`title`,`buyer_id`,`category_id`,`seller_id`,`is_rated`,`rate_value`) VALUES (13,'2018-04-19','mountain bike2',NULL,30,'ACTIVE','bike',NULL,2,1,0,0);
INSERT INTO `item` (`id`,`date_posted`,`description`,`image`,`price`,`state`,`title`,`buyer_id`,`category_id`,`seller_id`,`is_rated`,`rate_value`) VALUES (14,'2018-04-18','mountain bike2',NULL,40,'ACTIVE','bike',NULL,2,1,0,0);
INSERT INTO `item` (`id`,`date_posted`,`description`,`image`,`price`,`state`,`title`,`buyer_id`,`category_id`,`seller_id`,`is_rated`,`rate_value`) VALUES (15,'2018-04-17','mountain bike2',NULL,50,'ACTIVE','bike',NULL,2,1,0,0);


