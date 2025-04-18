DROP TABLE IF EXISTS schedule;
DROP TABLE IF EXISTS adherence;

SET TIME ZONE 'America/Los_Angeles';


CREATE TABLE schedule ( id SERIAL PRIMARY KEY,
                        dose_time TIME NOT NULL
                           
);
CREATE TABLE adherence ( date DATE NOT NULL,
                        dose_time TIME NOT NULL,
                        open_time TIME,
                        status TEXT CHECK (status IN ('Taken', 'Missed', 'Improper Dose')),
                        PRIMARY KEY(date, dose_time)
                           
);

--Testing
INSERT INTO schedule (dose_time) VALUES
  ('06:00:00'),
  ('10:00:00'),
  ('15:30:00'),
  ('22:00:00'),
  ('19:00:00');
