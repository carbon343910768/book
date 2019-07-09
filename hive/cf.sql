load data local infile '/root/item_cf.csv' into table `book_recommend` character set utf8 fields terminated by ',' enclosed by '"' lines terminated by '\n';
load data local infile '/root/user_cf.csv' into table `user_recommend` character set utf8 fields terminated by ',' enclosed by '"' lines terminated by '\n';
