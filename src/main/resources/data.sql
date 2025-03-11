INSERT INTO summer_camp (id, name, location, max_participants, price, description, type)
VALUES (1, 'Avonturenkamp', 'Durbuy', 25, 250.00, 'Kamp vol avontuur en natuur.', 'Avontuur'),
       (2, 'Knutselkamp', 'Leuven', 20, 180.00, 'Creatief kamp met schilderen en knutselen.', 'Creatief'),
       (3, 'Natuurkamp', 'Maaseik', 15, 190.00, 'Ontdekkingskamp in het bos.', 'Avontuur'),
       (4, 'Sportkamp', 'Antwerpen', 30, 210.00, 'Sport en spel voor actieve jongeren.', 'Avontuur'),
       (5, 'Muziekkamp', 'Gent', 18, 220.00, 'Samen muziek maken en optreden.', 'Creatief'),
       (6, 'Talenkamp', 'Brugge', 22, 200.00, 'Nederlands en Frans op een speelse manier.', 'Creatief'),
       (7, 'Watersportkamp', 'Oostende', 16, 230.00, 'Zee, kajakken, suppen en plezier.', 'Avontuur'),
       (8, 'Theaterkamp', 'Kortrijk', 12, 175.00, 'Toneel, improvisatie en optreden.', 'Creatief'),
       (9, 'STEM-kamp', 'Hasselt', 24, 240.00, 'Programmeren en technische opdrachten.', 'Techniek'),
       (10, 'Dierenkamp', 'Mol', 14, 195.00, 'Verzorgen van dieren en leren over natuur.', 'Avontuur');

INSERT INTO activity (id, name, description, summer_camp_id)
VALUES (1, 'Kampvuur', 'Avondactiviteit rond het vuur', 1),
       (2, 'Boogschieten', 'Leer schieten als een pro', 2),
       (3, 'Speurtocht', 'Zoektocht door het bos', 3),
       (4, 'Knutselsessie', 'Knutselen met papier en verf', 4),
       (5, 'Zwemmen', 'Waterplezier in het zwembad', 5),
       (6, 'Improvisatietheater', 'Acteren zonder script', 6),
       (7, 'Fietstocht', 'Verken de omgeving per fiets', 7),
       (8, 'Dansworkshop', 'Leer dansen met vrienden', 8),
       (9, 'Touwparcours', 'Spannend hindernissenparcours', 9),
       (10, 'Levend Stratego', 'Teamspel in het bos', 10);
