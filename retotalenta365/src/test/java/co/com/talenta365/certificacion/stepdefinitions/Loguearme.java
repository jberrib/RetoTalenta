package co.com.talenta365.certificacion.stepdefinitions;

import co.com.talenta365.certificacion.GeneralStepDefinitions;
import co.com.talenta365.certificacion.questions.VerificarLogueo;
import co.com.talenta365.certificacion.tasks.LoguearmeEnPagina;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import java.util.Map;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Loguearme extends GeneralStepDefinitions {


    @Given("^Despues de ingresar a la url$")
    public void despuesDeIngresarALaUrl() {
        setUp();
    }


    @When("^procedo a ingresar usuario y clave$")
    public void procedoAIngresarUsuarioYClave(List<Map<String,String>> listaParamatrosDeIngreso) {
        theActorInTheSpotlight().attemptsTo(
             LoguearmeEnPagina.conLaSigueienteCredenciales(
                listaParamatrosDeIngreso.get(0).get("usuario"),
                listaParamatrosDeIngreso.get(0).get("clave")));
    }

    @Then("^verifico que estoy logueado en la pagina$")
    public void verificoQueEstoyLogueadoEnLaPagina() {
        theActorInTheSpotlight().should(seeThat(VerificarLogueo.conUsuario(theActorInTheSpotlight().recall("Usuario"))));
    }
}
