create table worker (
ID SERIAL primary key,
NAME VARCHAR(1000) not null check ((CHAR_LENGTH(NAME) between 2 and 1000)),
BIRTHDAY DATE check (extract (year from BIRTHDAY)>1900),
LEVEL VARCHAR(10) not null check (level in ('Trainee','Junior','Middle','Senior')),
SALARY INTEGER not null check (SALARY between 100 and 100000)
);

create table client (
ID SERIAL primary key,
NAME VARCHAR(1000) not null check (CHAR_LENGTH(NAME) between 2 and 1000)
);

create table project (
ID SERIAL primary key,
CLIENT_ID bigint,
START_DATE DATE,
FINISH_DATE DATE
);



ALTER TABLE project
ADD CONSTRAINT fk_client_id FOREIGN KEY (CLIENT_ID) REFERENCES client(ID);

ALTER TABLE project ADD CONSTRAINT unique_client_id UNIQUE (CLIENT_ID);

create table project_worker (
PROJECT_ID bigint,
WORKER_ID bigint,
foreign key (PROJECT_ID) references project(ID),
foreign key (WORKER_ID) references worker(ID),
primary key (PROJECT_ID, WORKER_ID)
);