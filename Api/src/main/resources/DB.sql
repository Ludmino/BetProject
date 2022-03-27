CREATE TABLE public."BetList"
(
    "idBet" bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    bet character varying(256) COLLATE pg_catalog."default",
    option character varying(256) COLLATE pg_catalog."default",
    etat bigint,
    CONSTRAINT "Bets_pkey" PRIMARY KEY ("idBet")
)

TABLESPACE pg_default;

ALTER TABLE public."BetList"
    OWNER to postgres;

CREATE TABLE public."user"
(
    "idUser" bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    "user" character varying(256) COLLATE pg_catalog."default",
    points bigint DEFAULT 100,
    CONSTRAINT "User_pkey" PRIMARY KEY ("idUser")
)

TABLESPACE pg_default;

ALTER TABLE public."user"
    OWNER to postgres;

CREATE TABLE public."Bets"
(
    choice bigint,
    amount bigint,
    "betId" bigint,
    "userId" bigint,
    CONSTRAINT "betKey" FOREIGN KEY ("betId")
        REFERENCES public."BetList" ("idBet") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT "userKey" FOREIGN KEY ("userId")
        REFERENCES public."User" ("idUser") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public."Bets"
    OWNER to postgres;
-- Index: fki_userKey

-- DROP INDEX public."fki_userKey";

CREATE INDEX "fki_userKey"
    ON public."Bets" USING btree
    ("userId" ASC NULLS LAST)
    TABLESPACE pg_default;