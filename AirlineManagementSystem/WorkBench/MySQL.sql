create database airlinemanagementsystem;
use airlinemanagementsystem;
create table login(username varchar(20), password varchar(20));
insert into login values("majidali","majid");
create table passenger (name varchar(20), nationality varchar(20), cnic varchar(20),address varchar(50),phone varchar(20), email varchar(50),gender varchar(20));
select*from passenger;
create table flight(f_code varchar(20),f_name varchar(20), source varchar(40), destination varchar(40));
CREATE TABLE flight (
    f_code VARCHAR(10),
    f_name VARCHAR(50),
    src VARCHAR(50),
    dst VARCHAR(50)
);
INSERT INTO flight  VALUES ("PK301", "PIA", "ISLAMABAD", "KARACHI");
INSERT INTO flight  VALUES ("PK301", "PIA", "ISLAMABAD", "UK");
INSERT INTO flight  VALUES ("PK302", "PIA", "KARACHI", "AMERICA");
INSERT INTO flight  VALUES('PK303', 'PIA', 'LAHORE', 'S KOREA');
INSERT INTO flight  VALUES('PK304', 'PIA', 'KARACHI', 'CHINA');
INSERT INTO flight  VALUES('PK305', 'PIA', 'PESHAWAR', 'JAPAN');
INSERT INTO flight  VALUES('PK306', 'PIA', 'ISLAMABAD', 'UAE');
INSERT INTO flight  VALUES('PK307', 'PIA', 'QUETTA', 'SAUDI ARABIA');
INSERT INTO flight  VALUES('PK308', 'PIA', 'KARACHI', 'RUSSIA');
INSERT INTO flight  VALUES('PK309', 'PIA', 'MULTAN', 'TURKEY');
INSERT INTO flight  VALUES('PK310', 'PIA', 'LAHORE', 'YEMEN');
select*from passenger;
select*from flight;
create table reservation (PNR varchar(15),TICKET varchar(20), nic varchar(20), name varchar(20),nationality varchar(30), fname varchar(15), fcode varchar(20),scr varchar(30),des varchar(30),date varchar(30));
select*from reservation;
create table cancel(pnr varchar(20), name varchar(40), cancelno varchar(20), fcode varchar(20), date varchar(30));
select*from cancel;