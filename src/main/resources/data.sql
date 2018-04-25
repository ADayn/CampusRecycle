INSERT INTO categories (id, name) VALUES
  (1, 'Electronics'),
  (2, 'Bikes');
INSERT  INTO users (id, email, username, password) VALUES
  (1, 'a@a.a', 'u', 'p'),
  (2, 'si@si', 'si', 'si');
INSERT INTO admins(id, email, username, password) VALUES
  (1, 'admin@admin', 'admin', 'admin');

INSERT INTO `item` (`id`,`date_posted`,`description`,`image`,`price`,`state`,`title`,`buyer_id`,`category_id`,`seller_id`) VALUES (2,'2018-04-24','a laptop',NULL,200,'PENDING','a laptio',NULL,1,2);
INSERT INTO `item` (`id`,`date_posted`,`description`,`image`,`price`,`state`,`title`,`buyer_id`,`category_id`,`seller_id`) VALUES (3,'2018-04-24','mountain bike',NULL,30,'PENDING','book',NULL,2,2);
INSERT INTO `item` (`id`,`date_posted`,`description`,`image`,`price`,`state`,`title`,`buyer_id`,`category_id`,`seller_id`) VALUES (4,'2018-04-24','a laptop',NULL,300,'ACTIVE','a laptop',NULL,1,2);
INSERT INTO `item` (`id`,`date_posted`,`description`,`image`,`price`,`state`,`title`,`buyer_id`,`category_id`,`seller_id`) VALUES (5,'2018-04-24','mountain bike',NULL,30,'ACTIVE','book',NULL,2,2);
  