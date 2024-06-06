DROP TABLE IF EXISTS tickets CASCADE;
DROP TABLE IF EXISTS events CASCADE;
DROP TABLE IF EXISTS accounts CASCADE;
DROP TABLE IF EXISTS venues CASCADE;
DROP TABLE IF EXISTS purchases CASCADE;

CREATE TABLE accounts (
    user_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    email_address VARCHAR(254) UNIQUE NOT NULL,
    password varchar(256), -- should be hashed
    phone_number VARCHAR(20), -- what type?
    creation_date DATE NOT NULL
);

CREATE TABLE venues (
    venue_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    venue_name VARCHAR(50) NOT NULL,
--     phone_number VARCHAR(20) NOT NULL, -- what type?
--     email VARCHAR(254) NOT NULL,
    seating_capacity INT NOT NULL,
    address_line1 VARCHAR(127) NOT NULL,
    address_line2 VARCHAR(127),
    city VARCHAR(63) NOT NULL,
    state CHAR(2) NOT NULL,
    postal_code VARCHAR(16) NOT NULL,
    description TEXT
);


CREATE TABLE events (
    event_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    event_name VARCHAR(50) NOT NULL UNIQUE, -- event name (tour name?)
    artist_id VARCHAR(50) NOT NULL,
    date_time TIMESTAMP NOT NULL,
    venue_id BIGINT NOT NULL,
    foreign key (venue_id) REFERENCES venues(venue_id)
);


CREATE TABLE tickets (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    event_id BIGINT NOT NULL,
    account_id BIGINT, -- account id can be null when the ticket is not yet bought by anyone (?)
    seat_number INT NOT NULL,
    price INT NOT NULL, -- in cents
    foreign key (event_id) REFERENCES events(event_id),
    foreign key (account_id) REFERENCES accounts(user_id)
);

CREATE TABLE purchases (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    ticket_id BIGINT NOT NULL,
    event_id BIGINT NOT NULL,
    venue_id BIGINT NOT NULL,
    account_id BIGINT NOT NULL,
    foreign key (ticket_id) references tickets(id),
    foreign key (event_id) references events(event_id),
    foreign key (venue_id) references venues(venue_id),
    foreign key (account_id) references accounts(user_id)
);

CREATE TABLE bands (
    band_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    band_name VARCHAR(50) NOT NULL,
    genre VARCHAR(50) NOT NULL,
    description TEXT
);

CREATE TABLE band_members (
    member_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    band_id BIGINT NOT NULL,
    member_name VARCHAR(50) NOT NULL,
    foreign key (band_id) references bands(band_id)
);
