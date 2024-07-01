
create table if not exists tbl_user (
                          username varchar(50) not null,
                          enabled boolean not null,
                          fullname varchar(50),
                          last_update timestamp(6),
                          password varchar(255),
                          rolle varchar(255),
                          primary key (username)
);

INSERT INTO tbl_user (username,fullname,rolle,password, enabled)
values ('user','Hersteller','USER','$2a$10$I3Xgy0uT58HdnI5Y58FfQuZXUGKRgGNxqW7AiY74DqLF1I5656G3y',TRUE);
INSERT INTO tbl_user (username,fullname,rolle,password, enabled) values
('fritz','Hersteller','GUEST','$2a$10$OiXOEDV4bV7gxTPNlg3pZOq/H8jmlnCS7DdDcVXSDdvfax/7pWbVa',TRUE);

INSERT INTO tbl_role (user_username,role) values ('user','USER');
INSERT INTO tbl_role (user_username,role) values ('user','ADMIN');
INSERT INTO tbl_role (user_username,role) values ('user','GUEST');


INSERT INTO tbl_role (user_username,role) values ('fritz','GUEST');