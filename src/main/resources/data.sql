INSERT INTO venues(name, capacity, address_line1, city, state, postal_code)
    VALUES ('Kresge Auditorium', 3917, '4000 M-37', 'Interlochen', 'MI', '49643');

INSERT INTO venues(name, capacity, address_line1, city, state, postal_code)
    VALUES ('Orchestra Hall', 2522, '220 S Michigan Ave', 'Chicago', 'IL', '60604');

INSERT INTO venues(name, capacity, address_line1, city, state, postal_code)
    VALUES ('Richard Rogers Theatre', 1319, '226 W 46th Street', 'New York', 'NY', '10036');

INSERT INTO venues(name, capacity, address_line1, city, state, postal_code)
    VALUES ('Pritzker Pavillion', 11000, '201 E Randolph Street', 'Chicago', 'IL', '60601');

INSERT INTO venues(name, capacity, address_line1, city, state, postal_code)
    VALUES ('Gillette Stadium', 64628, '1 Patriot Place', 'Foxborough', 'MA', '02035');

INSERT INTO venues(name, capacity, address_line1, city, state, postal_code)
    VALUES ('Acrisure Arena', 11000, '75702 Varner Rd', 'Palm Desert', 'CA', '92211');

INSERT INTO venues(name, capacity, address_line1, city, state, postal_code)
    VALUES ('Lumen Field', 68740, '800 Occidental Ave S', 'Seattle', 'WA', '98134');

INSERT INTO venues(name, capacity, address_line1, city, state, postal_code)
    VALUES ('Capital One Arena', 20000, '601 F Street NW', 'Washington', 'DC', '20004');

-- Update for marketing test
-- @Author Suhwan Kim
-- test Accounts
INSERT INTO accounts(email, password, phone_number, created_date)
    VALUES ('shkim901101@naver.com', '0000', '1234567890', CURRENT_DATE);

INSERT INTO accounts(email, password, phone_number, created_date)
    VALUES ('shkim901101@gmail.com', '1111', '1234567890', CURRENT_DATE);

INSERT INTO accounts(email, password, phone_number, created_date)
    VALUES ('suhwankim1101@gmail.com', '2222', '1234567890', CURRENT_DATE);

-- test events
INSERT INTO events(name, artist, datetime, venue_id)
    VALUES ('Test Event 1', 'Test Artist 1', CURRENT_TIMESTAMP, 2);

INSERT INTO events(name, artist, datetime, venue_id)
    VALUES ('Test Event 2', 'Test Artist 2', CURRENT_TIMESTAMP, 3);

INSERT INTO events(name, artist, datetime, venue_id)
    VALUES ('Test Event 3', 'Test Artist 3', CURRENT_TIMESTAMP, 4);

-- test ticket
INSERT INTO tickets(event_id, account_id, seat_number, price)
    VALUES (3, 1, '9C', 2999);

INSERT INTO tickets(event_id, account_id, seat_number, price)
    VALUES (2, 2, '9C', 3999);

INSERT INTO tickets(event_id, account_id, seat_number, price)
    VALUES (1, 3, '9C', 4999);
