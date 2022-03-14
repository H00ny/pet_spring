INSERT INTO usr(active, password, username) 
VALUES (
    true, 
    '$2a$10$tA.HgVVTcR7J5rn515LA2OGobd0tGRLRAzIROD8z0fPZJMG/n2vBO',
    'admin'
);

INSERT INTO user_role(user_id, roles) 
VALUES
( 
    (SELECT Id FROM usr WHERE username='admin'),
    'USER'
);

DROP SCHEMA public CASCADE;
CREATE SCHEMA public;
DROP SCHEMA dict CASCADE;
CREATE SCHEMA dict;