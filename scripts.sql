insert into institutions (institutionName) values ("The Collection");
insert into labs (labName, institutionId) values ("The Lab", 1), ("The Lab 2", 1);
insert into scientists (firstName, lastName) values ("Gottlieb", "Kiesel"), ("Donald", "Anderson"), ("???", "Clark");
insert into assistants (firstName, lastName) values ("Ast", "1"), ("Ast", "2"), ("Ast", "3");
insert into experimentTypes (expTypeName) values ("Chemistry"), ("Physics"), ("Biology"), ("Engineering"), ("????");
insert into reports (reportName, link) values ("Chemistry Report", "chem.com"), ("Physics Report", "physics.com"), ("Bio Report", "bio.com"), ("Engineer's Report", "engineers.com");
insert into locations (country, city) values ("USA", "Washington"), ("UK", "London"), ("Japan", "Tokyo"), ("South Africa", "Pretoria"), ("Brazil", "Rio"), ("To delete", "Mute City");
insert into degrees (degreeName, numOfYears) values ("Associate's", 2), ("Bachelor's", 4), ("Master's", 8), ("Fake", 2), ("Fake2", 1);
insert into clientTypes (clientTypeName) values ("Commercial"), ("Individual"), ("Military");
insert into clients (clientName, clientTypeId) values ("Naked Snake", 2), ("US Army", 3), ("A Business", 1), ("Serious Sam", 2);
insert into investments (amount, bank) values (10000, "Anon Bank"), (50000, "Secret Bank");
insert into experiments (experimentName, status, experimentTypeId, reportId) values ("Exp 1", "In progress", 1, 1), ("Exp 2", "In progress", 1, 2), ("Exp 3", "In progress", 2, 3);

#Should probably use a select instead of hardcoding
update clients set clientName = "Big Boss" where clientName = "Naked Snake";
update experiments set labId = 1;
update experiments set labId = 2 where experimentName = "Exp 1";
update labs set institutionId = 1;
update labs set locationId = 2;
update labs set locationId = 1 where labName = "The Lab 2";
update investments set clientId = 1 where amount = 50000;
update assistants set assisteeId = 2 where lastName != "3";
update scientists set degreeId = 2 where lastName = "1";
update scientists set degreeId = 4 where lastName = "2";
update scientists set degreeId = 3 where lastName = "3";
update experiments set investmentId = 1;

delete from degrees where numOfYears % 2 != 0;
delete from degrees where degreeName = "Fake";
delete from locations where city = "Mute City";
delete from labs where institutionId = null;
delete from experimentTypes where expTypeName = "????";
delete from scientists where lastName = "Some value that doesn't exist";
delete from institutions where institutionName like "%{$another fake val}%";
delete from assistants where lastName like "%{$3}";

alter table scientists add title varchar(45);
alter table experiments add isSuccess tinyint;
alter table reports modify link varchar(1000);
alter table investments drop column bank;
alter table labs add isClassified tinyint;


select * from institutions cross join labs cross join locations cross join scientists cross join degrees cross join assistants cross join clients cross join clientTypes cross join experiments cross join experimentTypes cross join investments cross join reports cross join experimentGroups;

select institutions.institutionId, labs.labId from institutions inner join labs on institutions.institutionId = labs.institutionId;
select clients.clientName, investments.amount from clients inner join investments on clients.clientId = investments.clientId;
select experiments.experimentName, reports.reportName from experiments left join reports on experiments.reportId = reports.reportId;
select assistants.lastName, scientists.lastName from assistants right join scientists on assistants.assisteeId = scientists.scientistId;
#select clients.name, clientTypes.name from clients full outer join clientTypes on clientTypes.id = clients.typeId;

select avg(amount) averageInvestAmount from investments;
select experimentName, count(*) from experiments group by experimentName;
select clients.clientName, count(clientTypes.clientTypeName) from (clients inner join clientTypes on clients.clientId = clientTypes.clientTypeId) group by clientName;
select expTypeId, json_arrayagg(expTypeName) as names from experimentTypes group by expTypeId;
select experimentName, group_concat(status) from experiments group by experimentName;

select count(degreeName) from degrees group by degreeName having count(degreeName) > 0;
select lastName, count(lastName) from scientists group by lastName having count(lastName) = 1;
select degrees.degreeName, degrees.numOfYears, count(numOfYears) from degrees group by degreeName, numOfYears having count(numOfYears) % 2 = 1;
select min(link) from reports group by reportName having min(link) != 10;
select max(amount) from investments group by investmentId having max(amount) != 50000;

