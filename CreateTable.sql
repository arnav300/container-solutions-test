CREATE TABLE person  
( 
      survived boolean,     
      passenger_class integer,
      name varchar(100),
      sex ENUM('male','female','other'),
      age integer,
      siblings_or_spouses_aboard varchar(100),
      parents_or_children_aboard varchar(100),
      fare DECIMAL(10,3),
      uuid varchar(100),
      primary key (uuid)
  );
