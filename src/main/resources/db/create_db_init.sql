CREATE TYPE rack_status_enum AS ENUM ('ACTIVE', 'RETURNED', 'REPAIR', 'OUTDATED', 'BRICKED');

CREATE TABLE T_TEAM
(
    id   BIGINT DEFAULT random() PRIMARY KEY,
    name varchar(255) NOT NULL,
    product varchar(20) NOT NULL,
    default_location varchar(20) NOT NULL,
    created_at DATE,
    modified_at DATE

);
CREATE SEQUENCE IF NOT EXISTS SEQ_TEAM_ID;

CREATE TABLE T_RACK
(
    id                  BIGINT DEFAULT random() PRIMARY KEY,
    serial_number       varchar(20)             NOT NULL UNIQUE,
    status              text                    ,
    team_id             BIGINT                  NOT NULL REFERENCES T_TEAM (id),
    default_location    varchar(20)             NOT NULL,
    assembled_at        DATE,
    created_at          DATE,
    modified_at         DATE
);
CREATE SEQUENCE IF NOT EXISTS SEQ_RACK_ID;


CREATE TABLE T_TEAM_MEMBER
(
    id            BIGINT           DEFAULT random() PRIMARY KEY,
    team_id       BIGINT           NOT NULL REFERENCES T_TEAM (id),
    ctw_id        varchar(10)      NOT NULL UNIQUE,
    name          varchar(255)     NOT NULL,
    created_at    DATE,
    modified_at   DATE
);
CREATE SEQUENCE IF NOT EXISTS SEQ_TEAM_MEMBER_ID;

CREATE TABLE T_RACK_ASSET
(
    id            BIGINT           DEFAULT random() PRIMARY KEY,
    rack_id       BIGINT           NOT NULL REFERENCES T_RACK (id),
    asset_tag     varchar(50)      NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS SEQ_RACK_ASSET_ID;

CREATE TABLE T_BOOKING
(
    id                  BIGINT           DEFAULT random() PRIMARY KEY,
    rack_id             BIGINT           NOT NULL REFERENCES T_RACK(id),
    requester_id        BIGINT           NOT NULL REFERENCES T_TEAM_MEMBER (id),
    book_from           DATE,
    book_to             DATE,
    created_at          DATE,
    modified_at         DATE
);
CREATE SEQUENCE IF NOT EXISTS SEQ_BOOKING_ID;


