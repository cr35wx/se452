-- run this file as your default postgres user, usually named just "postgres"
-- try typing "psql postgres" into your terminal after installing postgresql
-- \i <path-to-this-file>

-- Create database
CREATE DATABASE ticketselling;

-- Create user
CREATE USER tsadmin WITH PASSWORD 'secret!';

-- Grant privileges to the user on the database
GRANT ALL PRIVILEGES ON DATABASE ticketselling TO tsadmin;
ALTER DATABASE ticketselling OWNER TO tsadmin;


-- you can now log in to the database directly with the following cli command
-- psql -d ticketselling -U tsadmin

