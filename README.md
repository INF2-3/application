# INF2-3 application repo

Financing application

## Set up

Rename the file 'example.env' to '.env' in the the api and application repository.
The 'example.env' file can be found in the resources folder of both repositories.
Make sure that the parser and api will run on the right ports;
 * parser: 9091
 * api: 8080

To run the api you'll need to start the docker containers with the docker-compose.yaml file found in the api repository in the Docker folder.
Just simply run 'docker-compose up' in the Docker folder to start the containers.

To use the api you'll need to import the file postgres.sql into the postgres database.
You can do that via the browser on localhost:8085.
Here you'll need to set the server to PostgreSQL and then enter the server, username, password and database name.
These will be the following when not changing the docker-compose file;
  * server: postgres
  * username: root
  * password: changeme
  * database: postgres

When logged in click import and import the postgres.sql file. The file can be found in the api repository in the folder Database.





