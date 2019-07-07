CREATE TABLE user
(
    user_id  int unsigned not null auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    role     varchar(45)  not null,
    unique index username_unique (username asc),
    primary key (user_id)
);

CREATE TABLE customer
(
    user_id int unsigned not null,
    name    text,
    phone   text,
    email   text,
    primary key (user_id)
);

/*==============================================================*/
/* Book                                                         */
/*==============================================================*/

CREATE TABLE book
(
    book_id          int unsigned  not null auto_increment,
    book_name        varchar(255)  not null,
    book_author      varchar(255)  not null,
    book_publisher   varchar(255)  not null,
    book_description text,
    book_published   date,
    book_isbn        char(13),
    book_price       decimal(9, 2) not null,
    primary key (book_id)
);

/*==============================================================*/
/* Image                                                        */
/*==============================================================*/

CREATE TABLE image
(
    image_id      int unsigned not null auto_increment,
    image_content blob         not null,
    primary key (image_id)
);

CREATE TABLE book_image
(
    book_id  int unsigned not null,
    image_id int unsigned not null,
    sequence int unsigned not null,
    index book_index (image_id asc),
    primary key (book_id, image_id)
);

/*==============================================================*/
/* Tag                                                          */
/*==============================================================*/
CREATE TABLE tag
(
    tag_name    varchar(255) not null,
    tag_content text,
    primary key (tag_name)
);

CREATE TABLE book_tag
(
    book_id  int unsigned not null,
    tag_name varchar(255) not null,
    index book_index (book_id asc),
    index tag_index (tag_name asc),
    primary key (book_id, tag_name)
);

/*==============================================================*/
/* Cart                                                         */
/*==============================================================*/
CREATE TABLE customer_cart
(
    cart_id      int unsigned not null auto_increment,
    user_id      int unsigned not null,
    cart_address text         not null,
    cart_phone   text         not null,
    index user_index (user_id asc),
    primary key (cart_id)
);

CREATE TABLE cart_book
(
    cart_id     int unsigned not null,
    book_id     int unsigned not null,
    book_number int,
    index cart_index (cart_id asc),
    primary key (cart_id, book_id)
);

/*==============================================================*/
/* Order                                                        */
/*==============================================================*/
CREATE TABLE customer_order
(
    order_id      int unsigned not null auto_increment,
    user_id       int unsigned not null,
    order_address text,
    order_time    datetime,
    order_price   decimal(9, 2),
    order_state   bool,
    index user_index (user_id asc),
    index order_index (order_id asc),
    primary key (user_id, order_id)
);

CREATE TABLE order_book
(
    order_id    int unsigned not null,
    book_id     int unsigned not null,
    book_number int,
    index order_index (order_id asc),
    index book_index (book_id asc),
    primary key (order_id, book_id)
);

/*==============================================================*/
/* Comment                                                      */
/*==============================================================*/
CREATE TABLE comment
(
    commentId      char(20) not null,
    id             int,
    bookId         char(10),
    commentContent char(255),
    commentTime    date,
    primary key (commentId)
);

CREATE TABLE reply
(
    replyId      char(20) not null,
    id           int,
    commentId    char(20),
    replyContent char(255),
    replyTime    date,
    primary key (replyId)
);

/*==============================================================*/
/* Store                                                        */
/*==============================================================*/
CREATE TABLE store
(
    storeId       char(20) not null,
    id            int,
    storeName     char(40),
    storePhoneNum char(20),
    primary key (storeId)
);


CREATE TABLE store_book
(
    book_id  int unsigned,
    store_id int unsigned,
    primary key (book_id, store_id)
);

/*==============================================================*/
/* Log                                                          */
/*==============================================================*/
CREATE TABLE log
(
    date    varchar(255),
    time    varchar(255),
    ip      varchar(255),
    uri     text,
    header  text,
    body    text,
    user_id int unsigned
);


CREATE TABLE weighted_record
(
    user_id int unsigned not null,
    book_id int unsigned not null,
    weight  int
);

