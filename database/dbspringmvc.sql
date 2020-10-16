CREATE DATABASE `dbspringmvc`;

USE `dbspringmvc`;

INSERT INTO `roles` (`code`, `name`) VALUES ('ROLE_ADMIN', 'Quản trị');
INSERT INTO `roles` (`code`, `name`) VALUES ('ROLE_USER', 'Người dùng');

INSERT INTO `users` (`username`, `password`, `fullname`, `status`)
VALUES ('admin','$2a$10$/B2R.xYKQfS6VLYXb.CV3.P9HJ7GEzVLFU/w5XKiV2zX9/yBjCO42','Nguyễn Hữu Nghĩa',1);
INSERT INTO `users` (`username`, `password`, `fullname`, `status`)
VALUES ('nhnghia','$2a$10$/B2R.xYKQfS6VLYXb.CV3.P9HJ7GEzVLFU/w5XKiV2zX9/yBjCO42','Nghĩa Nguyễn',1);

INSERT INTO `user_role` (`userid`, `roleid`) VALUES (1, 1);
INSERT INTO `user_role` (`userid`, `roleid`) VALUES (2, 2);

INSERT INTO `categories` (`name`, `code`) 
VALUES ('Thể thao','the-thao'),
		('Sức khỏe','suc-khoe'),
		('Giáo dục','giao-duc'),
        ('Nhịp sống','nhip-song'),
		('Thế giới','the-gioi');