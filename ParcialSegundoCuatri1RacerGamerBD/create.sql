--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.2

-- Started on 2022-10-28 13:41:26

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 210 (class 1259 OID 116618)
-- Name: country; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.country (
    countryid bigint NOT NULL,
    name character varying NOT NULL
);
ALTER TABLE ONLY public.country ALTER COLUMN countryid SET STATISTICS 0;
ALTER TABLE ONLY public.country ALTER COLUMN name SET STATISTICS 0;


ALTER TABLE public.country OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 116617)
-- Name: country_country_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.country_country_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.country_country_seq OWNER TO postgres;

--
-- TOC entry 3324 (class 0 OID 0)
-- Dependencies: 209
-- Name: country_country_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.country_country_seq OWNED BY public.country.countryid;


--
-- TOC entry 212 (class 1259 OID 116627)
-- Name: player; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.player (
    playerid bigint NOT NULL,
    nickname character varying(25) NOT NULL,
    level character(1) NOT NULL,
    playedgames integer NOT NULL,
    wongames integer NOT NULL,
    questions integer NOT NULL,
    questionsok integer NOT NULL,
    movesdone integer NOT NULL,
    countryid bigint NOT NULL
);
ALTER TABLE ONLY public.player ALTER COLUMN playerid SET STATISTICS 0;
ALTER TABLE ONLY public.player ALTER COLUMN level SET STATISTICS 0;
ALTER TABLE ONLY public.player ALTER COLUMN playedgames SET STATISTICS 0;


ALTER TABLE public.player OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 116626)
-- Name: player_player_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.player_player_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.player_player_seq OWNER TO postgres;

--
-- TOC entry 3325 (class 0 OID 0)
-- Dependencies: 211
-- Name: player_player_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.player_player_seq OWNED BY public.player.playerid;


--
-- TOC entry 3169 (class 2604 OID 116621)
-- Name: country countryid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.country ALTER COLUMN countryid SET DEFAULT nextval('public.country_country_seq'::regclass);


--
-- TOC entry 3170 (class 2604 OID 116630)
-- Name: player playerid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.player ALTER COLUMN playerid SET DEFAULT nextval('public.player_player_seq'::regclass);


--
-- TOC entry 3316 (class 0 OID 116618)
-- Dependencies: 210
-- Data for Name: country; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.country (countryid, name) VALUES (1, 'Argentina');
INSERT INTO public.country (countryid, name) VALUES (2, 'Brasil');
INSERT INTO public.country (countryid, name) VALUES (3, 'Uruguay');
INSERT INTO public.country (countryid, name) VALUES (4, 'España');
INSERT INTO public.country (countryid, name) VALUES (5, 'Alemania');


--
-- TOC entry 3318 (class 0 OID 116627)
-- Dependencies: 212
-- Data for Name: player; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.player (playerid, nickname, level, playedgames, wongames, questions, questionsok, movesdone, countryid) VALUES (1, 'the best', 'E', 10, 2, 100, 80, 250, 5);
INSERT INTO public.player (playerid, nickname, level, playedgames, wongames, questions, questionsok, movesdone, countryid) VALUES (2, 'el genio', 'N', 5, 0, 200, 50, 150, 1);
INSERT INTO public.player (playerid, nickname, level, playedgames, wongames, questions, questionsok, movesdone, countryid) VALUES (3, 'twinpick', 'N', 30, 5, 400, 300, 990, 3);
INSERT INTO public.player (playerid, nickname, level, playedgames, wongames, questions, questionsok, movesdone, countryid) VALUES (4, 'mary pop', 'E', 60, 20, 500, 350, 1380, 1);
INSERT INTO public.player (playerid, nickname, level, playedgames, wongames, questions, questionsok, movesdone, countryid) VALUES (5, 'intrepid', 'E', 20, 1, 220, 80, 760, 2);


--
-- TOC entry 3326 (class 0 OID 0)
-- Dependencies: 209
-- Name: country_country_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.country_country_seq', 5, true);


--
-- TOC entry 3327 (class 0 OID 0)
-- Dependencies: 211
-- Name: player_player_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.player_player_seq', 5, true);


--
-- TOC entry 3172 (class 2606 OID 116625)
-- Name: country country_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.country
    ADD CONSTRAINT country_pkey PRIMARY KEY (countryid);


--
-- TOC entry 3174 (class 2606 OID 116632)
-- Name: player player_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.player
    ADD CONSTRAINT player_pkey PRIMARY KEY (playerid);


--
-- TOC entry 3175 (class 2606 OID 116638)
-- Name: player player_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.player
    ADD CONSTRAINT player_fk FOREIGN KEY (countryid) REFERENCES public.country(countryid) ON UPDATE CASCADE ON DELETE CASCADE;


-- Completed on 2022-10-28 13:41:27

--
-- PostgreSQL database dump complete
--

