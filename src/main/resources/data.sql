-- SummerCamps
INSERT INTO summer_camp (id, name, location, max_participants, price, description, type) VALUES
                                                                                             (1, 'Avonturenkamp', 'Durbuy', 25, 250.00, 'Kamp vol avontuur en natuur.', 'Avontuurlijk'),
                                                                                             (2, 'Knutselkamp', 'Leuven', 20, 180.00, 'Creatief kamp met schilderen en knutselen.', 'Creatief'),
                                                                                             (3, 'Natuurkamp', 'Maaseik', 15, 190.00, 'Ontdekkingskamp in het bos.', 'Avontuurlijk'),
                                                                                             (4, 'Sportkamp', 'Antwerpen', 30, 210.00, 'Sport en spel voor actieve jongeren.', 'Avontuurlijk'),
                                                                                             (5, 'Muziekkamp', 'Gent', 18, 220.00, 'Samen muziek maken en optreden.', 'Creatief'),
                                                                                             (6, 'Talenkamp', 'Brugge', 22, 200.00, 'Nederlands en Frans op een speelse manier.', 'Creatief'),
                                                                                             (7, 'Watersportkamp', 'Oostende', 16, 230.00, 'Zee, kajakken, suppen en plezier.', 'Avontuurlijk'),
                                                                                             (8, 'Theaterkamp', 'Kortrijk', 12, 175.00, 'Toneel, improvisatie en optreden.', 'Creatief'),
                                                                                             (9, 'STEM-kamp', 'Hasselt', 24, 240.00, 'Programmeren en technische opdrachten.', 'Techniek'),
                                                                                             (10, 'Dierenkamp', 'Mol', 14, 195.00, 'Verzorgen van dieren en leren over natuur.', 'Avontuurlijk');


-- Participants
INSERT INTO participant (name, email, age) VALUES
                                                   ('Lotte Janssen', 'lotte.j@example.com', 12),
                                                   ('Arne Peeters', 'arne.p@example.com', 14),
                                                   ('Mila De Smet', 'mila.d@example.com', 13),
                                                   ('Jules Maes', 'jules.m@example.com', 11),
                                                   ('Nora Willems', 'nora.w@example.com', 15),
                                                   ('Seppe Goossens', 'seppe.g@example.com', 12),
                                                   ('Emma Van Dijk', 'emma.v@example.com', 13),
                                                   ('Liam Verstraeten', 'liam.v@example.com', 14),
                                                   ('Zoë Hermans', 'zoe.h@example.com', 11),
                                                   ('Finn Claes', 'finn.c@example.com', 13);

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
                                                                 (10, 'Robot bouwen', 'Techniekactiviteit met robotjes', 9);

-- Registrations (ID wordt automatisch gegenereerd)
INSERT INTO registration (participant_id, summer_camp_id, registration_date, registration_time) VALUES
                                                                                                    (1, 1, '2025-03-20', '10:00:00'),
                                                                                                    (2, 2, '2025-03-21', '11:00:00'),
                                                                                                    (3, 3, '2025-03-22', '09:30:00'),
                                                                                                    (4, 4, '2025-03-23', '14:15:00'),
                                                                                                    (5, 5, '2025-03-24', '13:00:00'),
                                                                                                    (6, 6, '2025-03-25', '15:00:00'),
                                                                                                    (7, 7, '2025-03-26', '12:45:00'),
                                                                                                    (8, 8, '2025-03-27', '16:00:00'),
                                                                                                    (9, 9, '2025-03-28', '10:30:00'),
                                                                                                    (10,10,'2025-03-29', '11:45:00');
