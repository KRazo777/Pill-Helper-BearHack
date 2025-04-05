DB_CONTAINER = pill-db
DB_USER = psql
DB_PASSWORD = psql
DB_NAME = pill-db
DB_PORT = 5432

SQL_DIR = ali_worklol/sql/src

# ==========================

# MAKE COMMANDS FOR DOCKER DATABASE SETUP

# Create database container using postgres image
create-db:
	docker run --name $(DB_CONTAINER) \
	-e POSTGRES_USER=$(DB_USER) \
	-e POSTGRES_PASSWORD=$(DB_PASSWORD) \
	-e POSTGRES_DB=$(DB_NAME) \
	-p $(DB_PORT):5432 -d postgres

load-db:
	@docker exec -i pill-db psql -U psql -d pill-db < $(SQL_DIR)/create_tablesBH.sql
	@docker exec -i pill-db psql -U psql -d pill-db < $(SQL_DIR)/load_dataBH.sql

# Stop the database container
stop-db:
	docker stop $(DB_CONTAINER)

# Start a stopped container
start-db:
	docker start $(DB_CONTAINER)

# Remove the container (force stop + remove)
remove-db:
	docker rm -f $(DB_CONTAINER)

# Reset the DB (delete + re-run fresh)
reset-db: remove-db create-db

view-db:
	docker exec -it $(DB_CONTAINER) psql -U $(DB_USER) -d $(DB_NAME)

# =================================================

CONNECT_STRING = postgresql://localhost:$(DB_PORT)/$(DB_NAME)
JAVA_DIR = ali_worklol/java


# MAKE COMMANDS FOR JAVA APP

build:
	javac -d $(JAVA_DIR)/classes $(JAVA_DIR)/src/pill_box.java

run: load-db
	java -cp $(JAVA_DIR)/classes:$(JAVA_DIR)/lib/postgresql-42.7.5.jar pill_box \
	$(CONNECT_STRING) $(DB_USER) $(DB_PASSWORD)


