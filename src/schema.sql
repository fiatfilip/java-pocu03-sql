create table customers(
    id uuid,
    name character varying(20),
    PRIMARY KEY(id)
);

insert into customers values
    ('6f156179-449f-4dd8-be4a-dc4158781313', 'Bruce Willis'),
    ('bf70db84-9652-4d46-86b2-7ae69e501551', 'Chuck Norris'),
    ('1cb77b77-c80c-4220-951c-6b37b9fe5e7a', 'Bruce Lee');

create table products(
    product_id uuid,
    product_name character varying(20),
    PRIMARY KEY(product_id)
);

insert into products values
    ('affec13a-b0fe-4325-998f-2ed0c7e80cbb', 'TV'),
    ('4b20c2fb-962b-4291-a926-dcd8628c1815', 'Stereo'),
    ('90051912-7899-4e18-a28a-933f3c98e186', 'PS5'),
    ('407eb624-fdd9-4448-8cdd-d2a6b83e0630', 'Laptop'),
    ('bc2494eb-abec-4029-9cbe-603ae1d7a7dc', 'Wii');

create table orders(
    id uuid,
    customer_id uuid,
    date timestamp,
    PRIMARY KEY (id),
    FOREIGN KEY(customer_id) REFERENCES customers(id)
);

create table orders_products(
    id uuid,
    order_id uuid,
    product_id uuid,
    PRIMARY KEY (id),
    FOREIGN KEY(order_id) REFERENCES orders(id),
    FOREIGN KEY(product_id) REFERENCES products(product_id)
);