insert into wheels_size (size_name)
values ('R15'),
       ('R16'),
       ('R17');

insert into wheels (stock, wheels_size_id)
values (100, 1),
       (50, 2),
       (25, 3);

insert into bodies_type (type_name)
values ('sedan'),
       ('hatchback');

insert into bodies (stock, type_id)
values (100, 1),
       (50, 2);
