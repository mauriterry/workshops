#!/bin/bash
sudo yum clean all
sudo yum -y install httpd php
sudo rm -f /etc/httpd/conf.d/welcome.conf
sudo vi /etc/httpd/conf/httpd.conf
cat /var/www/html/index.html

#Firewall Policy
sudo firewall-cmd --permanent --add-port=80/tcp
sudo firewall-cmd --permanent --add-port=443/tcp
sudo firewall-cmd --reload
#Daemon Control
sudo systemctl start httpd
sudo systemctl enable httpd
sudo systemctl status httpd
sudo systemctl stop httpd
