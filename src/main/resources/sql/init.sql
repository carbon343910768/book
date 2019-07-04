CREATE TABLE `user` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC));
);

/*==============================================================*/
/* Table: Book                                                  */
/*==============================================================*/
create table Book
(
   bookId               char(10) not null,
   bookName             char(20),
   bookContent          char(255),
   bookAuthor           char(20),
   bookPublisher        char(20),
   bookPublished        date,
   bookPages            int,
   bookISBN             char(20),
   bookPrice            int,
   primary key (bookId)
);

/*==============================================================*/
/* Table: BookInStore                                           */
/*==============================================================*/
create table BookInStore
(
   bookId               char(10) not null,
   storeId              char(20) not null,
   primary key (bookId, storeId)
);

/*==============================================================*/
/* Table: BookTag                                               */
/*==============================================================*/
create table BookTag
(
   bookId               char(10) not null,
   tagName              char(10) not null,
   primary key (bookId, tagName)
);

/*==============================================================*/
/* Table: Log                                                   */
/*==============================================================*/
create table Log
(
   ip                   char(200),
   url                  char(200),
   uniqueId             char(200),
   HTTPMethod           char(20),
   result               char(255)
);

/*==============================================================*/
/* Table: OrderBook                                             */
/*==============================================================*/
create table OrderBook
(
   orderId              char(10) not null,
   bookId               char(10) not null,
   orderBookState       bool,
   primary key (orderId, bookId)
);

/*==============================================================*/
/* Table: Ordered                                               */
/*==============================================================*/
create table Ordered
(
   id                   int not null,
   orderId              char(10) not null,
   primary key (id, orderId)
);

/*==============================================================*/
/* Table: Store                                                 */
/*==============================================================*/
create table Store
(
   storeId              char(20) not null,
   id                   int,
   storeName            char(40),
   storePhoneNum        char(20),
   primary key (storeId)
);

/*==============================================================*/
/* Table: comment                                               */
/*==============================================================*/
create table comment
(
   commentId            char(20) not null,

   id                   int,
   bookId               char(10),
   commentContent       char(255),
   commentTime          date,
   primary key (commentId)
);

/*==============================================================*/
/* Table: orderr                                                */
/*==============================================================*/
create table orderr
(
   orderId              char(10) not null,
   orderOwner           char(10),
   orderTime            date,
   orderState           bool,
   primary key (orderId)
);

/*==============================================================*/
/* Table: reply                                                 */
/*==============================================================*/
create table reply
(
   replyId              char(20) not null,
   id                   int,
   commentId            char(20),
   replyContent         char(255),
   replyTime            date,
   primary key (replyId)
);

/*==============================================================*/
/* Table: tag                                                   */
/*==============================================================*/
create table tag
(
   tagName              char(10) not null,
   tagContent           char(255),
   primary key (tagName)
);