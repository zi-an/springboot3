create table if not exists user
(
    id   integer primary key,
    name text,
    pwd  text
);
insert or ignore into  user values (1,'xie','haiyang');

