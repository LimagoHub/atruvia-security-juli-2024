
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
values ('user','Hersteller','USER','$2a$10$ky2RBGxWzAt89UUyQRTTqeft4Bj5gg2yfNoR3mdIvWEGfXUycbDfW',TRUE);


INSERT INTO tbl_user (username,fullname,rolle,password, enabled) values ('fritz','Hersteller','GUEST','$2a$10$zn7gAhL4sj8GwTat.HUxAe2gHm12DYLsJCk7F9v4dtkjnQI7/xXIW',TRUE);