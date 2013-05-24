# Entries schema

# --- !Ups

CREATE SEQUENCE entry_id_seq;
CREATE TABLE entry (
  id integer NOT NULL DEFAULT nextval('entry_id_seq'),
  timestamp bigint
);

# --- !Downs

DROP TABLE entry;
DROP SEQUENCE entry_id_seq;
