-- seed tables

INSERT INTO addresses(city, street, zip)
VALUES ('Orlando', 'Vander Beer Place', '392'),
       ('Drytown', 'Ingraham Street', '498');

INSERT INTO profiles(civility, email, firstname, lastname, password, address_id)
VALUES ('M', 'john.doe@example.com', 'John', 'Doe', 'hashed_password_here', 1);
