create table contact_forms
(
    id              int8         not null,
    created_at      timestamp,
    name            varchar(255) not null,
    surname         varchar(255) not null,
    policy_number   varchar(255) not null,
    request_text    varchar(255) not null,
    kind_of_request int8         not null,
    primary key (id)
);

create table request_kinds
(
    id              int8         not null,
    kind_of_request varchar(255) not null,
    primary key (id)
);

alter table if exists contact_forms
    drop constraint if exists UK_sakga6m0mjqo4c30cbbqjnvp3;
alter table if exists contact_forms
    add constraint UK_sakga6m0mjqo4c30cbbqjnvp3 unique (policy_number);
alter table if exists request_kinds
    drop constraint if exists UK_es1fw3fm8la5fmikug221hdvt;
alter table if exists request_kinds
    add constraint UK_es1fw3fm8la5fmikug221hdvt unique (kind_of_request);
create sequence hibernate_sequence start 1 increment 1;
alter table if exists contact_forms
    add constraint FKsevf5gukry1rin5vfqvx1402n foreign key (kind_of_request) references request_kinds;