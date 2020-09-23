start:
	@export CLIENT_URL=http://localhost:8000 && ./gradlew bootRun -x test

reset_db:
	@./bin/db_resetter.sh gsigndb

empcon_tests:
	@./bin/make_json.sh && \
	export DATABASE_URL=jdbc:postgresql://localhost/gsigndb && \
	source ~/workspace/gsign/env && \
	./gradlew clean build gsignTest -x test
