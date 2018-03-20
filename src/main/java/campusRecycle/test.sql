create table items(
  id int,
  title varchar(255),
  desc varchar(255),
  imagepath varchar(255),
  cataname varchar(255),
  price int,
  itemname varchar(255),
  dateposted date,
  seller varchar(255),
  buyer varchar(255),
  foreign key(category) REFERENCES categories(name),
  foreign key(state) REFERENCES itemstates(name),
  foreign key(seller) REFERENCES people(username),
  foreign key(buyer) REFERENCES people(username)
  );

