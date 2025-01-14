create table events
(
    dtype      varchar(31) not null,
    event_id   bigint      not null
        primary key,
    event_type varchar(255)
        constraint events_event_type_check
            check ((event_type)::text = ANY
                   ((ARRAY ['TRANSACTION_CREATE'::character varying, 'CLIENT_CREATE'::character varying, 'ACCOUNT_CREATE'::character varying])::text[])),
    payload    jsonb,
    timestamp  timestamp(6)
);

alter table events owner to postgres;

create table account
(
    account_id bigint not null
        primary key,
    balance    bigint,
    client_id  bigint
);

alter table account
    owner to postgres;

create table client
(
    client_id          bigint not null
        primary key,
    name               varchar(255),
    password           varchar(255),
    username           varchar(255),
    account_account_id bigint
        constraint ukjcf7qcgf4stg1kww2u2rwihji
            unique
        constraint fk91weic00shpbsfrkhwqrqxk0y
            references account
);

alter table client
    owner to postgres;

create table transaction
(
    transaction_id  bigint not null
        primary key,
    amount          bigint,
    created_at      timestamp(6),
    description     varchar(255),
    status          smallint
        constraint transaction_status_check
            check ((status >= 0) AND (status <= '-1'::integer)),
    from_account_id bigint
        constraint fkrff4jlxetafju1e5cks5mfcnk
            references account,
    to_account_id   bigint
        constraint fkluqt8k2pa8d4gmggx4rhl5vgv
            references account
);

alter table transaction
    owner to postgres;


