DROP TABLE IF EXISTS tickets CASCADE;
DROP TABLE IF EXISTS events CASCADE;
DROP TABLE IF EXISTS accounts CASCADE;
DROP TABLE IF EXISTS venues CASCADE;

CREATE TABLE accounts (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    email VARCHAR(254) UNIQUE NOT NULL,
    password varchar(256), -- should be hashed
    phone_number VARCHAR(20), -- what type?
    created_date DATE NOT NULL
);

CREATE TABLE venues (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(20) NOT NULL, -- what type?
    email VARCHAR(254) NOT NULL,
    capacity INT NOT NULL,
    address_line1 VARCHAR(100) NOT NULL,
    address_line2 VARCHAR(100),
    city VARCHAR(50) NOT NULL,
    state CHAR(2) NOT NULL,
    postal_code VARCHAR(50) NOT NULL,
    description TEXT
);


CREATE TABLE events (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE, -- event name (tour name?)
    artist VARCHAR(50) NOT NULL,
    datetime TIMESTAMP NOT NULL,
    venue_id INT NOT NULL,
    foreign key (venue_id) REFERENCES venues(id)
);


CREATE TABLE tickets (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    event_id INT NOT NULL,
    account_id INT, -- account id can be null when the ticket is not yet bought by anyone (?)
    seat_number varchar(255) NOT NULL,
    price INT NOT NULL, -- in cents
    foreign key (event_id) REFERENCES events(id),
    foreign key (account_id) REFERENCES accounts(id)
);
