INSERT INTO `S_USER` (id, version, name, mobile, password, enable, deleted, create_date)
VALUES (1, 1, 'libing', '18980571201', 'ef48ec6d4db66b0abf0e9a2e569b386a', 1, 0, '2017-08-10 14:18:14');
INSERT INTO `S_USER` (id, version, name, mobile, password, enable, deleted, create_date)
VALUES (2, 1, 'Archer', '18980571202', '62eb59e15e1a4b5a4609c7c50619a783', 1, 0, '2017-08-10 14:18:14');
INSERT INTO `S_USER` (id, version, name, mobile, password, enable, deleted, create_date)
VALUES (3, 1, 'toby', '17088843234', 'ef48ec6d4db66b0abf0e9a2e569b386a', 1, 0, '2017-08-10 14:18:14');

INSERT INTO `K_ROLE` (id, version, role, category, description, enable, deleted, create_date)
VALUES (1, 1, 'SERVICE', 'SERVICE', '后台管理', 1, 0, '2017-08-10 14:18:14');
INSERT INTO `K_ROLE` (id, version, role, category, description, enable, deleted, create_date)
VALUES (2, 1, 'SECRETARY', 'SECRETARY', '支部书记', 1, 0, '2017-08-10 14:18:14');
INSERT INTO `K_ROLE` (id, version, role, category, description, enable, deleted, create_date)
VALUES (3, 1, 'SOLDIER', 'SOLDIER', '普通官兵', 1, 0, '2017-08-10 14:18:14');

INSERT INTO `K_RESOURCE` (id, version, CODE, name,type,url, enable, deleted, create_date)
VALUES (1, 1, 'ROLE_SERVICE', '操作员', 'PAGE','', 1, 0, '2017-08-10 14:18:14');

INSERT INTO `K_RESOURCE` (id, version, CODE, name,type,url, enable, deleted, create_date)
VALUES (2, 1, 'ROLE_SECRETARY', '书记', 'PAGE','', 1, 0, '2017-08-10 14:18:14');

INSERT INTO `K_RESOURCE` (id, version, CODE, name,type,url, enable, deleted, create_date)
VALUES (3, 1, 'ROLE_SOLDIER', '官兵', 'PAGE','', 1, 0, '2017-08-10 14:18:14');

INSERT INTO `K_ROLE_RESOURCE` (role_id, resource_id) VALUES (1, 1);
INSERT INTO `K_ROLE_RESOURCE` (role_id, resource_id) VALUES (2, 2);
INSERT INTO `K_ROLE_RESOURCE` (role_id, resource_id) VALUES (3, 3);

INSERT INTO `K_USER_ROLE` (account_id, role_id) VALUES (1, 1);
INSERT INTO `K_USER_ROLE` (account_id, role_id) VALUES (2, 2);
INSERT INTO `K_USER_ROLE` (account_id, role_id) VALUES (3, 3);