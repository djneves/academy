package com.ctw.workstation.team.boundary;

import com.ctw.workstation.team.resource.TeamResource;
import com.ctw.workstation.team.service.TeamRepository;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;


@QuarkusTest
@TestHTTPEndpoint(TeamResource.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TeamResourceTest {

    @Inject
    TeamRepository teamRepository;

    @Test
    @DisplayName("Creating Team test")
    @Order(1)
    void create_team(){

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body("""
                        
                        {
                          "name": "string",
                          "product": "string",
                          "defaultLocation": "string",
                          "createdAt": "2022-03-10",
                          "modifiedAt": "2022-03-10"
                        }
                        """)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .assertThat()
                .body("id", Matchers.notNullValue());
    }

    @Test
    @DisplayName("Getting all teams test")
    @Order(2)
    void get_all_teams(){

        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("size()", Matchers.equalTo(1));
    }

    @Test
    @DisplayName("Getting by id test")
    @Order(3)
    void get_team_by_id(){

        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("{id}", 1)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("id", Matchers.equalTo(1));
    }

    @Test
    @DisplayName("Updating a team test")
    @Order(4)
    void update_team(){
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body("""
                        {
                          "name": "string",
                          "product": "string"
                        }
                        """)
                .when()
                .put("{id}", 1)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("id", Matchers.equalTo(1))
                .body("name", Matchers.equalTo("string"))
                .body("product", Matchers.equalTo("string"));
    }

    @Test
    @DisplayName("Deleting a team test")
    @Order(5)
    void delete_team(){
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .delete("{id}", 1)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NO_CONTENT);

        Assertions.assertThat(teamRepository.findByIdOptional(Long.valueOf(1)).isEmpty());
    }
}