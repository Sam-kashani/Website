-- SummerCamps
INSERT INTO summer_camp ( name, location, max_participants, price, description, type) VALUES
                                                                                             ( 'Avonturenkamp', 'Durbuy', 25, 250.00, '1–7 juli 2025. Klimmen, speurtochten, vlotten bouwen en kampvuur in de Ardennen.', 'Avontuurlijk'),
                                                                                             ( 'Knutselkamp', 'Leuven', 20, 180.00, '8–12 juli 2025. Kinderen maken kunst met verf, papier-maché en textiel, afsluitend met een expo.', 'Creatief'),
                                                                                             ( 'Natuurkamp', 'Maaseik', 15, 190.00, '15–20 juli 2025. Ontdek het bos, leer over dieren, bouw een hut en hou een natuurdagboek bij.', 'Avontuurlijk'),
                                                                                             ( 'Sportkamp', 'Antwerpen', 30, 210.00, '22–28 juli 2025. Dagelijks sport en spel: voetbal, turnen, atletiek en een mini-Olympische dag.', 'Avontuurlijk'),
                                                                                             ( 'Muziekkamp', 'Gent', 18, 220.00, '29 juli–3 aug 2025. Instrumenten ontdekken, samen muziek maken en optreden voor publiek.', 'Creatief'),
                                                                                             ( 'Talenkamp', 'Brugge', 22, 200.00, '5–10 aug 2025. Leer spelenderwijs Frans en Nederlands via theater, zang en leuke taalspellen.', 'Creatief'),
                                                                                             ( 'Watersportkamp', 'Oostende', 16, 230.00, '12–17 aug 2025. Kajakken, suppen, strandspelen en veilige begeleiding door monitoren.', 'Avontuurlijk'),
                                                                                             ( 'Theaterkamp', 'Kortrijk', 12, 175.00, '19–23 aug 2025. Improvisatie, script en expressie leiden tot een echte voorstelling.', 'Creatief'),
                                                                                             ( 'STEM-kamp', 'Hasselt', 24, 240.00, '26–31 aug 2025. Programmeer in Scratch en Python, bouw robots en doe proefjes.', 'Techniek'),
                                                                                             ( 'Dierenkamp', 'Mol', 14, 195.00, '19–24 aug 2025. Verzorg dieren, bezoek een boerderij en leer alles over hun gedrag.', 'Avontuurlijk');


-- Participants
INSERT INTO participant (name, email, age, username) VALUES
                                                             ('Lotte Janssen','lotte.j@example.com', 12, 'lotte'),
                                                             ('Arne Peeters','arne.p@example.com', 14, 'arne'),
                                                             ('Mila De Smet','mila.d@example.com', 13, 'mila'),
                                                             ('Jules Maes','jules.m@example.com', 11, 'jules'),
                                                             ('Nora Willems','nora.w@example.com', 15, 'nora'),
                                                             ('Seppe Goossens','seppe.g@example.com', 12, 'seppe'),
                                                             ('Emma Van Dijk','emma.v@example.com', 13, 'emma'),
                                                             ('Liam Verstraeten','liam.v@example.com', 14, 'liam'),
                                                             ('Zoë Hermans','zoe.h@example.com',  11, 'zoe'),
                                                             ('Finn Claes','finn.c@example.com', 13, 'finn');

-- Activities
INSERT INTO activity (id, name, description, summer_camp_id) VALUES
                                                                 (1, 'Vlot bouwen', 'Samen een vlot bouwen en testen op het water', 1),
                                                                 (2, 'Kampvuur', 'Verhalen en liedjes rond het kampvuur', 1),
                                                                 (3, 'Schilderatelier', 'Creatieve schilderactiviteit', 2),
                                                                 (4, 'Boomklimmen', 'Klimactiviteit in het bos', 3),
                                                                 (5, 'Voetbaltoernooi', 'Wedstrijdjes voetbal', 4),
                                                                 (6, 'Muziekworkshop', 'Instrumenten leren bespelen', 5),
                                                                 (7, 'Taalspelletjes', 'Interactieve taaloefeningen', 6),
                                                                 (8, 'Zeekajak', 'Kajakken op zee', 7),
                                                                 (9, 'Improvisatietheater', 'Toneel spelen zonder script', 8),
                                                                 (10, 'Robot bouwen', 'Techniekactiviteit met robotjes', 9),
                                                                 (11, 'Speurtocht in het bos', 'Een interactieve zoektocht met opdrachten en raadsels in het woud.', 1),
                                                                 (12, 'Touwenparcours', 'Uitdagend parcours tussen bomen met touwen en netten.', 1),
                                                                 (13, 'Nachtspel', 'Spannende avondactiviteit met zaklampen en teamwork.', 1),

                                                                 (14, 'Papier-maché maken', 'Een creatief project met lijm en krantenpapier.', 2),
                                                                 (15, 'Knutselhoek met recyclagemateriaal', 'Knutselen met herbruikbare materialen, goed voor het milieu.', 2),
                                                                 (16, 'Textielkunst', 'Ontwerpen van een stoffen tas of vlag met textielverf.', 2),

                                                                 (17, 'Insectensafari', 'Op zoek naar kleine beestjes met loep en vergrootglas.', 3),
                                                                 (18, 'Schuilhut bouwen', 'Met takken en bladeren een beschutting maken.', 3),
                                                                 (19, 'Natuurdagboek', 'Dagelijks bijhouden van observaties in de natuur.', 3),

                                                                 (20, 'Estafettewedstrijd', 'Teamspel met snelheid en coördinatie.', 4),
                                                                 (21, 'Turnparcours', 'Behendigheidsparcours met klimrekken en springmatten.', 4),
                                                                 (22, 'Basketbalclinic', 'Training en wedstrijdjes met technieken en spelinzicht.', 4),

                                                                 (23, 'Zangworkshop', 'Leren zingen in groep en solo met stemcoaching.', 5),
                                                                 (24, 'Percussiesessie', 'Ritmegevoel ontwikkelen met djembe en cajón.', 5),
                                                                 (25, 'Eigen liedje schrijven', 'Individueel of in groep een nieuw nummer bedenken.', 5),

                                                                 (26, 'Stripverhaal maken', 'Franstalige en Nederlandstalige strip creëren met tekstballonnen.', 6),
                                                                 (27, 'Taalbingo', 'Spelvorm om nieuwe woorden en zinnen te oefenen.', 6),
                                                                 (28, 'Mini-theater', 'Sketches voorbereiden en opvoeren in twee talen.', 6),

                                                                 (29, 'Suppen', 'Balans houden en peddelen op een surfplank.', 7),
                                                                 (30, 'Strandspelen', 'Teamactiviteiten zoals zandkastelenwedstrijd of strandvoetbal.', 7),
                                                                 (31, 'Zee-schattenjacht', 'Zoektocht naar verborgen voorwerpen op het strand en in de duinen.', 7),

                                                                 (32, 'Kostuums maken', 'Zelf kostuums ontwerpen en knutselen voor de voorstelling.', 8),
                                                                 (33, 'Stem- en ademhalingstraining', 'Oefeningen om duidelijk en expressief te spreken.', 8),
                                                                 (34, 'Toneeltechniek', 'Werken met rekwisieten, licht en geluid.', 8),

                                                                 (35, 'Programmeren met Scratch', 'Visueel leren programmeren via blokjes en logica.', 9),
                                                                 (36, 'Wetenschappelijk experiment', 'Veilig chemisch proefje zoals slijm maken of vulkaanuitbarsting.', 9),
                                                                 (37, 'Brug bouwen', 'Met spaghetti of karton een stevige constructie maken.', 9),

                                                                 (38, 'Dieren voederen', 'Meehelpen met het verzorgen en voederen van dieren.', 10),
                                                                 (39, 'Hondenwandeling', 'Samen wandelen met hondjes van het dierenasiel.', 10),
                                                                 (40, 'Dierenquiz', 'Educatieve quiz over dierenkennis en leefomgevingen.', 10);


-- Registrations (zonder ID, wordt automatisch gegenereerd)
INSERT INTO registration (participant_id, camp_id, registration_date, registration_time) VALUES
                                                                                             (1, 1, '2025-03-20', '10:00:00'),
                                                                                             (2, 2, '2025-03-21', '11:00:00'),
                                                                                             (3, 3, '2025-03-22', '09:30:00'),
                                                                                             (4, 4, '2025-03-23', '14:15:00'),
                                                                                             (5, 5, '2025-03-24', '13:00:00'),
                                                                                             (6, 6, '2025-03-25', '15:00:00'),
                                                                                             (7, 7, '2025-03-26', '12:45:00'),
                                                                                             (8, 8, '2025-03-27', '16:00:00'),
                                                                                             (9, 9, '2025-03-28', '10:30:00'),
                                                                                             (10, 10, '2025-03-29', '11:45:00');

-- Admin user
INSERT INTO users (username, password, enabled)
VALUES ('admin', '$2a$10$r.f5amuel/u71uXHNCGdbetrwgzbGvM8YOhnqghLoi2/ZLmnn1gty', true);
INSERT INTO authorities (username, authority)
VALUES ('admin', 'ROLE_ADMIN');

-- Test user
INSERT INTO users (username, password, enabled)
VALUES ('user', '$2a$10$rR7c3KQS1SeqsHLAd2QIieh7pqyJ2nh1xlluEStUxh1v02zkG7Aby', true);
INSERT INTO authorities (username, authority)
VALUES ('user', 'ROLE_USER');

-- Gebruikers gekoppeld aan participants
INSERT INTO users (username, password, enabled) VALUES
                                                    ('lotte', '$2a$10$rR7c3KQS1SeqsHLAd2QIieh7pqyJ2nh1xlluEStUxh1v02zkG7Aby', true),
                                                    ('arne',  '$2a$10$rR7c3KQS1SeqsHLAd2QIieh7pqyJ2nh1xlluEStUxh1v02zkG7Aby', true),
                                                    ('mila',  '$2a$10$rR7c3KQS1SeqsHLAd2QIieh7pqyJ2nh1xlluEStUxh1v02zkG7Aby', true),
                                                    ('jules', '$2a$10$rR7c3KQS1SeqsHLAd2QIieh7pqyJ2nh1xlluEStUxh1v02zkG7Aby', true),
                                                    ('nora',  '$2a$10$rR7c3KQS1SeqsHLAd2QIieh7pqyJ2nh1xlluEStUxh1v02zkG7Aby', true),
                                                    ('seppe', '$2a$10$rR7c3KQS1SeqsHLAd2QIieh7pqyJ2nh1xlluEStUxh1v02zkG7Aby', true),
                                                    ('emma',  '$2a$10$rR7c3KQS1SeqsHLAd2QIieh7pqyJ2nh1xlluEStUxh1v02zkG7Aby', true),
                                                    ('liam',  '$2a$10$rR7c3KQS1SeqsHLAd2QIieh7pqyJ2nh1xlluEStUxh1v02zkG7Aby', true),
                                                    ('zoe',   '$2a$10$rR7c3KQS1SeqsHLAd2QIieh7pqyJ2nh1xlluEStUxh1v02zkG7Aby', true),
                                                    ('finn',  '$2a$10$rR7c3KQS1SeqsHLAd2QIieh7pqyJ2nh1xlluEStUxh1v02zkG7Aby', true);

INSERT INTO authorities (username, authority) VALUES
                                                  ('lotte', 'ROLE_USER'),
                                                  ('arne', 'ROLE_USER'),
                                                  ('mila', 'ROLE_USER'),
                                                  ('jules', 'ROLE_USER'),
                                                  ('nora', 'ROLE_USER'),
                                                  ('seppe', 'ROLE_USER'),
                                                  ('emma', 'ROLE_USER'),
                                                  ('liam', 'ROLE_USER'),
                                                  ('zoe', 'ROLE_USER'),
                                                  ('finn', 'ROLE_USER');
