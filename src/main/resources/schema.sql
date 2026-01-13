--- Generate schema of the tables
--- Drop tables
drop table  if exists profiles;
drop table  if exists addresses;

--- Create new tables

CREATE TABLE addresses (
                           id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                           zip VARCHAR(10),
                           street VARCHAR(255),
                           city VARCHAR(50)
);

CREATE TABLE profiles (
                          id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                          firstname VARCHAR(255) NOT NULL,
                          lastname VARCHAR(255) NOT NULL,
                          email VARCHAR(255) UNIQUE NOT NULL,
                          civility VARCHAR(10) NOT NULL,
                          password TEXT NOT NULL,
                          address_id INTEGER REFERENCES addresses(id)
);
