#!/bin/bash
wget http://repo.mysql.com/mysql-community-release-el7-5.noarch.rpm
sudo rpm -ivh mysql-community-release-el7-5.noarch.rpm
sudo yum install mysql-server
sudo systemctl start mysqld
sudo mysql_secure_installation
mysql -u root -p

#GRANTS FOR USER CREATION
#create database testdb;
#create user 'testuser'@'localhost' identified by 'password';
#grant all on testdb.* to 'testuser' identified by 'password';
#update user SET PASSWORD=PASSWORD("password") WHERE USER='root';
#flush privileges;
#Testing New User
mysql -u testuser -p
#Manage MySQL Deamon
sudo /usr/bin/systemctl enable mysqld
sudo /usr/bin/systemctl start mysqld
sudo systemctl stop mysqld
sudo mysqld_safe --skip-grant-tables &
vi /var/log/mysql.log
