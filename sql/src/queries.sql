SET TIME ZONE 'America/Los_Angeles';
SELECT * FROM adherence WHERE date = CURRENT_DATE AND status = 'Taken';
