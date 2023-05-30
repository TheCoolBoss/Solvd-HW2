insert into institutions (name) values ("The Collection");
insert into labs (name, institutionId) values ("The Lab", 0), ("The Lab 2", 0);
insert into scientists (firstName, lastName) values ("Scientist", "1"), ("Scientist", "2"), ("Scientist", "3");
insert into assistants (firstName, lastName) values ("Ast", "1"), ("Ast", "2"), ("Ast", "3");
insert into experimentTypes (name) values ("Chemistry"), ("Physics"), ("Biology"), ("Engineering"), ("????");
insert into reports (name, link) values ("Chemistry Report", "chem.com"), ("Physics Report", "physics.com"), ("Bio Report", "bio.com"), ("Engineer's Report", "engineers.com");
insert into locations (country, city) values ("USA", "Washington"), ("UK", "London"), ("Japan", "Tokyo"), ("South Africa", "Pretoria"), ("Brazil", "Rio"), ("To delete", "Mute City");
insert into degrees (name, numOfYears) values ("Associate's", 2), ("Bachelor's", 4), ("Master's", 8), ("Fake", 2), ("Fake2", 1);
insert into clientTypes (type) values ("Commercial"), ("Individual"), ("Military");
insert into clients (name) values ("Naked Snake"), ("US Army"), ("A Business");
insert into investments (amount, bank) values (10000, "Anon Bank"), (50000, "Secret Bank");
insert into experiments (name, status, typeId, reportId) values ("Exp 1", "In progress", 0, 0), ("Exp 2", "In progress", 1, 1), ("Exp 3", "In progress", 2, 2);

#Should probably use a select instead of hardcoding
update clients set name = "Big Boss" where name = "Naked Snake";
update experiments set labId = 1;
update experiments set labId = 0 where name = "Exp 1";
update labs set institutionId = 0;
update labs set locationId = 0;
update labs set locationId = 1 where name = "The Lab 2";
update investments set clientId = 1 where amount = 50000;
update assistants set labId = 0 where lastName != "3";

delete from degrees where numOfYears % 2 != 0;
delete from degrees where name = "Fake";
delete from locations where city = "Mute City";
delete from labs where institutionId = null;
delete from experimentTypes where name = "????";
delete from scientists where lastName = "Some value that doesn't exist";
delete from institutions where name like "%{$another fake val}%";
delete from assistants where lastName like "%{$3}";

alter table scientists add title varchar(45);
alter table experiments add isSuccess tinyint;
alter table reports modify link varchar(1000);
alter table investments drop column bank;
alter table labs add isClassified tinyint;


select * from institutions cross join labs cross join locations cross join scientists cross join degrees cross join assistants cross join clients cross join clientTypes cross join experiments cross join experimentTypes cross join investments cross join reports cross join experimentGroups;

select institutions.id, labs.id from institutions inner join labs on institutions.id = labs.institutionId;
select clients.name, investments.amount from clients inner join investments on client.id = investments.clientId;
select experiments.name, reports.name from experiments left join reports on experiments.reportId = reports.id;
select assistants.lastName from assistants right join scientists on assistants.scientistId = scientists.id;
#select clients.name, clientTypes.name from clients full outer join clientTypes on clientTypes.id = clients.typeId;

select avg(amount) investAmount from investments group by id;
select experimentTypes.name, count(*) from experiments, experimentTypes where experiments.id = experimentTypes.id group by experiment.name;
select clients.name, count(clientTypes.type) from (clients inner join clientTypes on clients.id = clientTypes.id) group by name;
select id, json_arrayagg(name) as names from experimentTypes group by id;
select name, group_concat(status) from experiments group by name;

select count(name), numOfYears from degrees group by name having count(name) > 0;
select count(labId) from scientists group by lastName having labId < 1;
select name, count(numOfYears) from degrees group by name having numOfYears % 2 = 0;
select count(link) from reports group by name having link = "Some nonexistent value";

