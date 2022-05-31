CREATE TABLE IF NOT EXISTS sample_user (
    uuid     char(50),
    name     char(100) NOT NULL,
    password char(100) NOT NULL,
    PRIMARY KEY  ( uuid )
);

INSERT INTO sample_user (uuid, name, password) VALUES
  ('1a4f65f5-dc89-4b2f-8766-8092c812047f', 'John Doe',  '1234'),
  ('3b7d8a78-30ec-4a53-9994-4e595acb7a26', 'Jeane Doe', 'abce');
