CREATE DATABASE thc;
CREATE TABLE locations (
id serial PRIMARY KEY,
name varchar(255) NOT NULL,
address varchar(255) NOT NULL,
phone varchar(255) NOT NULL,
status varchar(255) NOT NULL
);

CREATE TABLE menus (
id serial PRIMARY KEY,
name varchar(255) NOT NULL,
type varchar(255) NOT NULL,
price float8 NOT NULL,
ingredients varchar(255) NOT NULL
);

CREATE TABLE interceptors (
id serial PRIMARY KEY,
execution_time bigint NOT NULL,
url varchar(255) NOT NULL,
url_dates varchar(255) NOT NULL
);

CREATE TABLE customers (
id serial PRIMARY KEY,
customer_name varchar(255) NOT NULL,
email_id varchar(255) NOT NULL,
phone varchar(255) NOT NULL
);

CREATE TABLE reservations (
id serial PRIMARY KEY,
date date NOT NULL,
time varchar(255) NOT NULL,
event_name varchar(255) NOT NULL,
guests int NOT NULL,
customer_id bigint NOT NULL,
location_id bigint NOT NULL
);

CREATE TABLE open_hours (
id serial PRIMARY KEY,
day varchar(255) NOT NULL,
start_time varchar(255) NOT NULL,
end_time varchar(255) NOT NULL,
status varchar(255) NOT NULL,
location_id bigint NOT NULL
);
