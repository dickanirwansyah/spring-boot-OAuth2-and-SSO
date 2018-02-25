insert into table_roles(idroles, name, description)
values ('role-001', 'ROLE_ADMIN', 'ADMIN ACCESS PERMISSION');

insert into table_roles(idroles, name, description)
values ('role-002', 'ROLE_STAFF', 'STAFF ACCESS PERMISSION');

insert into table_roles(idroles, name, description)
values ('role-003', 'ROLE_USER', 'USER ACCESS PERMISSION');

insert into table_users(idusers, name, username, email, password, activated)
values ('usr-001', 'Muhammad Dicka Nirwansyah', 'dickanirwansyah', 'dickanirwansyah@gmail.com',
'$2a$10$epYzM2vJVX/fVkq8R5GtYeBP0kwAlYrlQpwG2k/yIu7ZlNk03fQEG', true);

insert into table_users(idusers, name, username, email, password, activated)
values ('usr-002', 'Sita sinthya', 'sitasinthya', 'sitasinthya@gmail.com',
'$2a$10$epYzM2vJVX/fVkq8R5GtYeBP0kwAlYrlQpwG2k/yIu7ZlNk03fQEG', true);

INSERT INTO oauth_client_details
    (client_id, client_secret, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity,
    refresh_token_validity, additional_information, autoapprove)
VALUES
    ('clientGojekApp', 'mysecret', 'read,write',
    'password,authorization_code,refresh_token', null, null, 36000, 36000, null, true);


INSERT INTO oauth_client_details
    (client_id, client_secret, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity,
    refresh_token_validity, additional_information, autoapprove)
VALUES
    ('clientBukalapakApp', 'mysecret', 'read,write',
    'password,authorization_code,refresh_token', null, null, 36000, 36000, null, true);