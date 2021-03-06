PGDMP     0    +        	        y            test2    13.3    13.3 !    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    24685    test2    DATABASE     i   CREATE DATABASE test2 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE test2;
                postgres    false            ?            1259    24686    games    TABLE        CREATE TABLE public.games (
    id integer NOT NULL,
    name character varying(20) NOT NULL,
    group_id integer NOT NULL
);
    DROP TABLE public.games;
       public         heap    postgres    false            ?            1259    24689    games_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.games_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.games_id_seq;
       public          postgres    false    200            ?           0    0    games_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.games_id_seq OWNED BY public.games.id;
          public          postgres    false    201            ?            1259    24691    groups    TABLE     a   CREATE TABLE public.groups (
    id integer NOT NULL,
    name character varying(20) NOT NULL
);
    DROP TABLE public.groups;
       public         heap    postgres    false            ?            1259    24694    groups_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.groups_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.groups_id_seq;
       public          postgres    false    202            ?           0    0    groups_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.groups_id_seq OWNED BY public.groups.id;
          public          postgres    false    203            ?            1259    24696    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?            1259    24698    users    TABLE     ?   CREATE TABLE public.users (
    id integer NOT NULL,
    name character varying(20) NOT NULL,
    email character varying(20),
    phone character varying(20),
    avatar character varying(20),
    password character varying(20)
);
    DROP TABLE public.users;
       public         heap    postgres    false            ?            1259    24707    users_games    TABLE     `   CREATE TABLE public.users_games (
    user_id integer NOT NULL,
    game_id integer NOT NULL
);
    DROP TABLE public.users_games;
       public         heap    postgres    false            ?            1259    24710    users_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public          postgres    false    205            ?           0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
          public          postgres    false    207            4           2604    24712    games id    DEFAULT     d   ALTER TABLE ONLY public.games ALTER COLUMN id SET DEFAULT nextval('public.games_id_seq'::regclass);
 7   ALTER TABLE public.games ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    201    200            5           2604    24713 	   groups id    DEFAULT     f   ALTER TABLE ONLY public.groups ALTER COLUMN id SET DEFAULT nextval('public.groups_id_seq'::regclass);
 8   ALTER TABLE public.groups ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202            6           2604    24714    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    207    205            ?          0    24686    games 
   TABLE DATA           3   COPY public.games (id, name, group_id) FROM stdin;
    public          postgres    false    200   P"       ?          0    24691    groups 
   TABLE DATA           *   COPY public.groups (id, name) FROM stdin;
    public          postgres    false    202   ?"       ?          0    24698    users 
   TABLE DATA           I   COPY public.users (id, name, email, phone, avatar, password) FROM stdin;
    public          postgres    false    205   ?"       ?          0    24707    users_games 
   TABLE DATA           7   COPY public.users_games (user_id, game_id) FROM stdin;
    public          postgres    false    206   #       ?           0    0    games_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.games_id_seq', 4, true);
          public          postgres    false    201            ?           0    0    groups_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.groups_id_seq', 2, true);
          public          postgres    false    203            ?           0    0    hibernate_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hibernate_sequence', 5, true);
          public          postgres    false    204            ?           0    0    users_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.users_id_seq', 7, true);
          public          postgres    false    207            8           2606    24716    games games_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.games
    ADD CONSTRAINT games_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.games DROP CONSTRAINT games_pkey;
       public            postgres    false    200            :           2606    24718    groups groups_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.groups
    ADD CONSTRAINT groups_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.groups DROP CONSTRAINT groups_pkey;
       public            postgres    false    202            <           2606    24722    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    205            >           2606    24724 !   users_games users_play_games_pkey 
   CONSTRAINT     m   ALTER TABLE ONLY public.users_games
    ADD CONSTRAINT users_play_games_pkey PRIMARY KEY (user_id, game_id);
 K   ALTER TABLE ONLY public.users_games DROP CONSTRAINT users_play_games_pkey;
       public            postgres    false    206    206            @           2606    24725 '   users_games fkj02ehjgkwhp5dqqe8iskk6f8t    FK CONSTRAINT     ?   ALTER TABLE ONLY public.users_games
    ADD CONSTRAINT fkj02ehjgkwhp5dqqe8iskk6f8t FOREIGN KEY (game_id) REFERENCES public.games(id);
 Q   ALTER TABLE ONLY public.users_games DROP CONSTRAINT fkj02ehjgkwhp5dqqe8iskk6f8t;
       public          postgres    false    2872    206    200            A           2606    24730 '   users_games fkk70xanxxbjs1yuum23xcmvohi    FK CONSTRAINT     ?   ALTER TABLE ONLY public.users_games
    ADD CONSTRAINT fkk70xanxxbjs1yuum23xcmvohi FOREIGN KEY (user_id) REFERENCES public.users(id);
 Q   ALTER TABLE ONLY public.users_games DROP CONSTRAINT fkk70xanxxbjs1yuum23xcmvohi;
       public          postgres    false    205    2876    206            ?           2606    24735    games games_group_id_fkey    FK CONSTRAINT     z   ALTER TABLE ONLY public.games
    ADD CONSTRAINT games_group_id_fkey FOREIGN KEY (group_id) REFERENCES public.groups(id);
 C   ALTER TABLE ONLY public.games DROP CONSTRAINT games_group_id_fkey;
       public          postgres    false    200    202    2874            ?   <   x?3?,I???,?4?2?,.?????K?4?2?L??/IJ??rL8?S?%?y@u1z\\\ ???      ?      x?3???K??/?2??/-I2b???? S?Z      ?   6   x?3?,??/ʫ,J?,N????#.S΢??Ĝ?|QCμ?ܒs?=... W?A      ?      x?3?4?2?4?2?4?????? p     