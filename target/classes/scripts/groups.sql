-- -----------------------------------------------------
-- Root groups with all privileges
-- A users member of one of these grups,can do any thing in the appropriate tables.
-- -----------------------------------------------------
INSERT INTO `group`(name) VALUES ('ORGANIZATION');
INSERT INTO `group`(name) VALUES ('DEPARTMENT');
INSERT INTO `group`(name) VALUES ('TEAM');


INSERT INTO group_privilege (group_id,privilege_id) VALUES (1,1);
INSERT INTO group_privilege (group_id,privilege_id) VALUES (1,2);
INSERT INTO group_privilege (group_id,privilege_id) VALUES (1,3);
INSERT INTO group_privilege (group_id,privilege_id) VALUES (1,4);

INSERT INTO group_privilege (group_id,privilege_id) VALUES (2,1);
INSERT INTO group_privilege (group_id,privilege_id) VALUES (2,2);
INSERT INTO group_privilege (group_id,privilege_id) VALUES (2,3);
INSERT INTO group_privilege (group_id,privilege_id) VALUES (2,4);

INSERT INTO group_privilege (group_id,privilege_id) VALUES (3,1);
INSERT INTO group_privilege (group_id,privilege_id) VALUES (3,2);
INSERT INTO group_privilege (group_id,privilege_id) VALUES (3,3);
INSERT INTO group_privilege (group_id,privilege_id) VALUES (3,4);

