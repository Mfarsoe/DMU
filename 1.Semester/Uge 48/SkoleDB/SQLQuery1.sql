-- SKOLEDB --

USE master;

--Sletter database SkoleDB hvis den findes og opretter den på ny
If DB_ID('SkoleDB') IS NOT NULL 
		DROP DATABASE SkoleDB;

CREATE DATABASE SkoleDB;
GO -- Udfør alt tidligere frem til dette GO. Bruges til at "flushe" query, da sql gerne udfører alt på en gang. Giver mening at gøre nu, da vi skal bruge den oprettede database.

USE SkoleDB;

--Student Tabel --

CREATE TABLE student (
	id int IDENTITY(100, 1) NOT NULL, -- IDENTITY er auto-increment. Starter fra 100 og increaser med 1
	lastname nvarchar(20) NOT NULL, --nvarchar - Variable width Unicode string
	firstname nvarchar(30) NOT NULL,
	semester_no int,

	PRIMARY KEY(id)
);

INSERT INTO student VALUES('Jensen','Trine',1),('Farsø','Martin',1),('Nøhr','Morten',1);


CREATE TABLE teacher (
	id int IDENTITY,
	navn nvarchar(4) UNIQUE NOT NULL,

	PRIMARY KEY(id)
);