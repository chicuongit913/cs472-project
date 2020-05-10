# CS472 - WAP - Project #

#### Project Name: Hotel management system
#### Professor:  Obinna Kalu
##### Team: Covid-333 
##### Member: 
- Chi Cuong Nguyen - 61111
- Phan Anh Nguyen - 611034
- The Vinh Trang - 611035

## Project Technology
| Name | version  | type  |
| ------- | --- | --- |
| Servlet | 1.2.2 | backend tech |
| jstl | 1.2 | jsp tag |
| mysql | 5.6 | database |
| Hibernate | 5.3.7 | ORM|
| Tomcat | 9.0.1 | server|

# How to installation project
### Install Docker
Follow this url to install docker desktop 
[https://docs.docker.com/docker-for-mac/install/](https://docs.docker.com/docker-for-mac/install/)
### Pull the code 
```sh
	git clone https://github.com/chicuongit913/cs472-project.git
```
### Running project
```sh
	cd pathTo/cs472-project
	docker-compose up -d --build
```
### Create Database
```sh
	docker exec -it project-mysql mysql -u root -p
	> admin 
	CREATE DATABASE hotel
```
