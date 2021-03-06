create table table_users(
    idusers varchar(255) not null,
    name varchar(255) not null,
    username varchar(255)not null unique,
    email varchar(255) not null unique,
    password varchar(255) not null,
    activated boolean default true,
    activationkey varchar(255) null,
    resetpasswordkey varchar(255) null,

    CONSTRAINT pk_users_idusers PRIMARY KEY (idusers)
);


create table table_roles(
    idroles varchar(255) not null,
    name varchar(255) not null,
    description varchar(255) not null,

    CONSTRAINT pk_roles_idroles PRIMARY KEY (idroles)
);


create table table_users_roles(
    idusers varchar(255) not null,
    idroles varchar(255) not null,

    CONSTRAINT fk_usr_rl_idusers FOREIGN KEY (idusers)
    REFERENCES table_users(idusers),
    CONSTRAINT fk_usr_rl_idroles FOREIGN KEY (idroles)
    REFERENCES table_roles(idroles)
);

create table oauth_client_details (
    client_id VARCHAR(256) PRIMARY KEY,
    resource_ids VARCHAR(256),
    client_secret VARCHAR(256),
    scope VARCHAR(256),
    authorized_grant_types VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities VARCHAR(256),
    access_token_validity INTEGER,
    refresh_token_validity INTEGER,
    additional_information VARCHAR(4096),
    autoapprove VARCHAR(256)
);


CREATE TABLE oauth_access_token (
  token_id VARCHAR(256) DEFAULT NULL,
  token BLOB,
  authentication_id VARCHAR(256) DEFAULT NULL,
  user_name VARCHAR(256) DEFAULT NULL,
  client_id VARCHAR(256) DEFAULT NULL,
  authentication BLOB,
  refresh_token VARCHAR(256) DEFAULT NULL
);

CREATE TABLE oauth_refresh_token (
  token_id VARCHAR(256) DEFAULT NULL,
  token BLOB,
  authentication BLOB
);