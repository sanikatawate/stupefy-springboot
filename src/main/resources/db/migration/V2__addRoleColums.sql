CREATE TYPE role AS ENUM('USER', 'ADMIN');
ALTER TABLE if exists users
       add column user_role role;