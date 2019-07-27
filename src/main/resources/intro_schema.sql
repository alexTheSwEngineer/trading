
DROP TABLE IF EXISTS instrument_event, price_event, hot_instrument_event, instrument_hotness_change_event;

CREATE TABLE instrument_event (
  id           INT         NOT NULL PRIMARY KEY auto_increment,
  isin        VARCHAR(50)  not null,
  description VARCHAR(250) NULL,
  action      varchar(250) not null
);
CREATE INDEX index_event_isin on instrument_event (isin);

CREATE TABLE price_event (
  id    INT         NOT NULL PRIMARY KEY auto_increment,
  price double  NOT null,
  isin  VARCHAR(50) NOT NULL,
  timestamp TIMESTAMP NOT NULL,
  year int not null,
  month int not null,
  day int not null,
  hour int not null,
  minute int not null
);

CREATE INDEX price_event_isin on price_event (isin);
CREATE INDEX price_event_timestamp on price_event (timestamp);
CREATE INDEX price_event_year on price_event (year);
CREATE INDEX price_event_month on price_event (month);
CREATE INDEX price_event_day on price_event (day);
CREATE INDEX price_event_hour on price_event (hour);
CREATE INDEX price_event_minute on price_event (minute);

CREATE TABLE instrument_hotness_change_event (
  id    INT         NOT NULL PRIMARY KEY auto_increment,
  isin  VARCHAR(50) NOT NULL,
  hot   BOOLEAN     NOT NULL,
  timestamp timestamp not null
);

CREATE INDEX instrument_hotness_change_event_isin on instrument_hotness_change_event (isin);
CREATE INDEX instrument_hotness_change_event_timestamp on instrument_hotness_change_event (timestamp);





--select "PUBLIC"."INSTRUMENT_EVENT"."ID",
--       "PUBLIC"."INSTRUMENT_EVENT"."ISIN",
--       "PUBLIC"."INSTRUMENT_EVENT"."DESCRIPTION",
--       "PUBLIC"."INSTRUMENT_EVENT"."ACTION",
--       "latest_instrument_events"."max",
--       "latest_instrument_events"."ISIN",
--       "latest_price_events"."max",
--       "latest_price_events"."ISIN"
--from "PUBLIC"."INSTRUMENT_EVENT"
--join ( select max("PUBLIC"."INSTRUMENT_EVENT"."ID"),
--             "PUBLIC"."INSTRUMENT_EVENT"."ISIN"
--        from "PUBLIC"."INSTRUMENT_EVENT"
--        group by "PUBLIC"."INSTRUMENT_EVENT"."ISIN") "latest_instrument_events"
--  on "PUBLIC"."INSTRUMENT_EVENT"."ISIN" = cast(? as varchar)
--left outer join (select max("PUBLIC"."PRICE_EVENT"."ID"),
--                        "PUBLIC"."PRICE_EVENT"."ISIN"
--                 from "PUBLIC"."PRICE_EVENT"
--                 group by "PUBLIC"."PRICE_EVENT"."ISIN") "latest_price_events"
--             on "PUBLIC"."INSTRUMENT_EVENT"."ISIN" = cast(? as varchar)
--where "PUBLIC"."INSTRUMENT_EVENT"."ACTION" <> cast(? as varchar)];
--
--Column "latest_instrument_events.max" not found; SQL statement: select "PUBLIC"."INSTRUMENT_EVENT"."ID", "PUBLIC"."INSTRUMENT_EVENT"."ISIN", "PUBLIC"."INSTRUMENT_EVENT"."DESCRIPTION", "PUBLIC"."INSTRUMENT_EVENT"."ACTION", "latest_instrument_events"."max", "latest_instrument_events"."ISIN", "latest_price_events"."max", "latest_price_events"."ISIN" from "PUBLIC"."INSTRUMENT_EVENT" join (select max("PUBLIC"."INSTRUMENT_EVENT"."ID"), "PUBLIC"."INSTRUMENT_EVENT"."ISIN" from "PUBLIC"."INSTRUMENT_EVENT" group by "PUBLIC"."INSTRUMENT_EVENT"."ISIN") "latest_instrument_events" on "PUBLIC"."INSTRUMENT_EVENT"."ISIN" = cast(? as varchar) left outer join (select max("PUBLIC"."PRICE_EVENT"."ID"), "PUBLIC"."PRICE_EVENT"."ISIN" from "PUBLIC"."PRICE_EVENT" group by "PUBLIC"."PRICE_EVENT"."ISIN") "latest_price_events" on "PUBLIC"."INSTRUMENT_EVENT"."ISIN" = cast(? as varchar) where "PUBLIC"."INSTRUMENT_EVENT"."ACTION" <> cast(? as varchar)