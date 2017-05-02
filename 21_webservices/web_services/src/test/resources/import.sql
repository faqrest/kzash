INSERT INTO role (role_name) VALUES ('user');
INSERT INTO role (role_name) VALUES ('admin');
INSERT INTO role (role_name) VALUES ('librarian');

INSERT INTO address (region, city, street, building, flat, postal_code) VALUES ('Kharkiv','Kharkiv','Sumska','21','40','61057');
INSERT INTO address (region, city, street, building, flat, postal_code) VALUES ('Kharkiv','Chuguev','Volonterska','3','7','63500');
INSERT INTO address (region, city, street, building, flat, postal_code) VALUES ('Kiev','Boyarka','Ushakova','114', '3','66002');
INSERT INTO address (region, city, street, building, flat, postal_code) VALUES ('Kharkiv','Kharkiv','Chichibabina','23','228','61044');

INSERT INTO author (first_name, last_name) VALUES ('Stephen','King');
INSERT INTO author (first_name, last_name) VALUES ('Teodor','Drayzer');
INSERT INTO author (first_name, last_name) VALUES ('Joanne','Rowling');

INSERT INTO place (shelf_code) VALUES ('A001');
INSERT INTO place (shelf_code) VALUES ('A002');
INSERT INTO place (shelf_code) VALUES ('B001');

INSERT INTO language (language) VALUES ('English');
INSERT INTO language (language) VALUES ('French');
INSERT INTO language (language) VALUES ('Spanish');
INSERT INTO language (language) VALUES ('Italian');
INSERT INTO language (language) VALUES ('Ukrainian');
INSERT INTO language (language) VALUES ('Russian');

INSERT INTO genre (name) VALUES ('Comedy');
INSERT INTO genre (name) VALUES ('Drama');
INSERT INTO genre (name) VALUES ('Horror');
INSERT INTO genre (name) VALUES ('Tragedy');
INSERT INTO genre (name) VALUES ('Fantasy');
INSERT INTO genre (name) VALUES ('Fiction');

INSERT INTO publishing_house (house) VALUES ('Folio');
INSERT INTO publishing_house (house) VALUES ('a-ba-ba-ga-la-ma-ga');
INSERT INTO publishing_house (house) VALUES ('laurus');

INSERT INTO order_type (type_name) VALUES ('home order');

INSERT INTO book (name, author_id, publishing_house_id, genre_id, total_count, current_count, description, place_id, read_count, language_id) VALUES ('Mysery','1','1','3', '7','7', 'bla', '1', '2', '1');
INSERT INTO book (name, author_id, publishing_house_id, genre_id, total_count, current_count, description, place_id, read_count, language_id) VALUES ('Financier','2','2','4','4','4','bla', '2', '2', '3');
INSERT INTO book (name, author_id, publishing_house_id, genre_id, total_count, current_count, description, place_id, read_count, language_id) VALUES ('Harry Potter and the philosopher`s stone','3','1','5', '9','9','bla', '2', '13', '2');
INSERT INTO book (name, author_id, publishing_house_id, genre_id, total_count, current_count, description, place_id, read_count, language_id) VALUES ('Harry Potter and room of Secrets','3','1','5', '9','9','bla', '2', '19', '2');

INSERT INTO rate (book_id, rate) VALUES ('1', '2');
INSERT INTO rate (book_id, rate) VALUES ('1', '7');
INSERT INTO rate (book_id, rate) VALUES ('2', '6');
INSERT INTO rate (book_id, rate) VALUES ('2', '10');
INSERT INTO rate (book_id, rate) VALUES ('3', '10');

INSERT INTO user (first_name, last_name, role_id, password, e_mail, phone, address_id, document) VALUES ('Vas', 'Ivanov', '2', 'vas1', 'vasyok@gmail.com', '+380500500112', 1, true);
INSERT INTO user (first_name, last_name, role_id, password, e_mail, phone, address_id, document) VALUES ('Ivan', 'Vasiliev', '2', 'qwerty', 'vanyok1212@gmail.com', '+380671111111', 2, false);
INSERT INTO user (first_name, last_name, role_id, password, e_mail, phone, address_id, document) VALUES ('Arsentiy', 'Medvedev', '3', 'boss123', 'boss-admin@gmail.com', '+380677777777', 3, true);
INSERT INTO user (first_name, last_name, role_id, password, e_mail, phone, address_id, document) VALUES ('Vasiliy', 'Ivanov', '2', 'Uuuu23', 'vasiliy@gmail.com', '+380667778899', 4, true);

INSERT INTO orders (actual_return_date, book_id, user_id, order_date, expected_return_date, order_type_id) VALUES ('2017-12-12', '1', '1', '2016-12-12', '2017-12-12', 1);
INSERT INTO orders (actual_return_date, book_id, user_id, order_date, expected_return_date, order_type_id) VALUES ('2017-12-12', '2', '4', '2016-11-15', '2017-12-11', 1);

UPDATE book SET avarage_rate = SELECT AVG (rate) FROM rate WHERE book_id='2' WHERE book_id = 2;

UPDATE book SET avarage_rate = SELECT AVG (rate) FROM rate WHERE book_id='1' WHERE book_id = 1;

UPDATE orders SET comment = 'door-key 567' WHERE orders_id = 1;

UPDATE user SET reputation = reputation + 1.2 WHERE document = true;

DELETE FROM language WHERE language_id = 4;