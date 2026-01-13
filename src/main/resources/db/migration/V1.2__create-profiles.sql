CREATE TABLE profiles
(
    id         INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    firstname  VARCHAR(255)        NOT NULL,
    lastname   VARCHAR(255)        NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL,
    civility   VARCHAR(10)         NOT NULL,
    password   TEXT                NOT NULL,
    address_id INTEGER REFERENCES addresses (id)
);