INSERT INTO hotel.users (id, email, gender, name, password, image) VALUES(1, 'ttrang@miu.edu', 'MALE', 'The Vinh Trang', 'e10adc3949ba59abbe56e057f20f883e', NULL);
INSERT INTO hotel.users (id, email, gender, name, password, image) VALUES(2, 'pha.nguyen@miu.edu', 'MALE', 'Phan Anh Nguyen', '5febda3d0ef90737a60de2fd7c6d7728', NULL);
INSERT INTO hotel.users (id, email, gender, name, password, image) VALUES(3, 'ch.nguyen@miu.edu', 'MALE', 'Chi Cuong Nguyen', 'cf4d87e50be6390ee9bd8ad6e7498cae', NULL);

INSERT INTO hotel.rooms (id, `number`, `type`, price, description, image) VALUES(1, '1001', 'SINGLE', 100, NULL, NULL);
INSERT INTO hotel.rooms (id, `number`, `type`, price, description, image) VALUES(2, '1002', 'SINGLE', 100, NULL, NULL);
INSERT INTO hotel.rooms (id, `number`, `type`, price, description, image) VALUES(3, '2001', 'DOUBLE', 150, NULL, NULL);
INSERT INTO hotel.rooms (id, `number`, `type`, price, description, image) VALUES(4, '2002', 'DOUBLE', 150, NULL, NULL);
INSERT INTO hotel.rooms (id, `number`, `type`, price, description, image) VALUES(5, '3001', 'SUITE', 300, NULL, NULL);
INSERT INTO hotel.rooms (id, `number`, `type`, price, description, image) VALUES(6, '3002', 'SUITE', 300, NULL, NULL);

INSERT INTO hotel.guest (id, firstName, lastName, address, email, phoneNumber, dob) VALUES(1, 'Phan Anh', 'Nguyen', '1000 N 4TH ST, Fairfield, Iowa, US', 'pha.nguyen@miu.edu', '611034', '1990-10-18');
INSERT INTO hotel.guest (id, firstName, lastName, address, email, phoneNumber, dob) VALUES(2, 'Chi Cuong', 'Nguyen', '', 'ch.nguyen@miu.edu', '611111', '1989-11-11');
INSERT INTO hotel.guest (id, firstName, lastName, address, email, phoneNumber, dob) VALUES(3, 'The Vinh', 'Trang', '', 'ttrang@miu.edu', '611035', '1988-12-12');

INSERT INTO hotel.booking (id, roomNumber, guestID, checkIn, checkOut, numberOfNight, totalPrice) VALUES(1, '1001', '1', '2020-05-13 00:00:00.0', '2020-05-14 00:00:00.0', 1, 100);
INSERT INTO hotel.booking (id, roomNumber, guestID, checkIn, checkOut, numberOfNight, totalPrice) VALUES(2, '1002', '2', '2020-05-13 00:00:00.0', '2020-05-14 00:00:00.0', 1, 100);
INSERT INTO hotel.booking (id, roomNumber, guestID, checkIn, checkOut, numberOfNight, totalPrice) VALUES(3, '2001', '3', '2020-05-13 00:00:00.0', '2020-05-14 00:00:00.0', 1, 150);
