-- --------------------------------------------------------
-- DATABASES CREATION
-- --------------------------------------------------------
-- Create database
CREATE DATABASE IF NOT EXISTS `robogames`;

-- --------------------------------------------------------
-- USERS CREATION
-- --------------------------------------------------------
CREATE USER 'insta_rg'@'%' IDENTIFIED BY 'passw0rd';
CREATE USER 'insta_rg'@'localhost' IDENTIFIED BY 'passw0rd';

-- --------------------------------------------------------
-- USERS PRIVILEGES RESET
-- --------------------------------------------------------
GRANT USAGE ON `robogames`.* TO 'insta_rg'@'%';
GRANT USAGE ON `robogames`.* TO 'insta_rg'@'localhost';

-- --------------------------------------------------------
-- USERS PRIVILEGES
-- --------------------------------------------------------
GRANT ALL ON `robogames`.* TO 'insta_rg'@'%';
GRANT ALL ON `robogames`.* TO 'insta_rg'@'localhost' WITH GRANT OPTION;

FLUSH PRIVILEGES;