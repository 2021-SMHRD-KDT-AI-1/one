create table ggame (
	name varchar(50),
	Q1 Number(10),
	Q2 Number(10),
	Q3 Number(10),
	feedback varchar(100)
	);
	
create table  artc (
	name varchar(50),
	Q1 Number(10),
	Q2 Number(10),
	Q3 Number(10),
	Q4 Number(10),
	Q5 Number(10),
	Q6 Number(10),
	Q7 Number(10)
	);	
	
		
ALTER TABLE artc CONVERT TO CHARACTER SET utf8;
ALTER TABLE artc CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER DATABASE artc DEFAULT CHARACTER SET utf8;
select * from ggame;

select * from artc;

delete from GGAME where name='qw';

ALTER TABLE artc ADD FEEDBACK varchar(1000);

ALTER TABLE GGAME DROP COLUMN FEEDBACK;

insert into ggame 
	values('kkk', '8','3','9', 'There is too long');
	
update ggame set Q1=3, Q2=4, Q3=9  where name='54';
update ggame set q1=6 where name=dvds;

insert into ggame 

	values('abc', '','','', '');
	
insert into ggame 
	values('qwer','','','','');
	
	
	