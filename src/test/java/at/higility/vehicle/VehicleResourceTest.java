package at.higility.vehicle;

import io.quarkus.test.junit.QuarkusTest;
import net.higility.vehicle.business.vehicle.entity.VehicleDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class VehicleResourceTest {
    @Test
    public void testHelloEndpoint(){
        final List<VehicleDto> expectedVehicles = List.of(
                new VehicleDto(2L, "VW", "Käfer"),
                new VehicleDto(1L, "Opel", "Kadett")
        );

        final List<VehicleDto> actualVehicles = given()
                .when().get("/vehicle")
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getList(".", VehicleDto.class);

        assertThat(actualVehicles)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .ignoringCollectionOrder()
                .isEqualTo(expectedVehicles);
    }
}
