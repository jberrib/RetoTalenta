package co.com.talenta365.certificacion.stepdefinitions;

import co.com.talenta365.certificacion.GeneralStepDefinitions;
import co.com.talenta365.certificacion.tasks.AgregarProductoAlCarrito;
import co.com.talenta365.certificacion.tasks.LoguearmeEnPagina;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AgregarProducto extends GeneralStepDefinitions {

    @Given("^Despues de encontrarme logueado en la pagina de advantageonlineshopping$")
    public void despuesDeEncontrarmeLogueadoEnLaPaginaDeAdvantageonlineshopping(List<Map<String,String>> listaParamatrosDeIngreso) {
        setUp();
        theActorInTheSpotlight().attemptsTo(
                LoguearmeEnPagina.conLaSigueienteCredenciales(
                        listaParamatrosDeIngreso.get(0).get("usuario"),
                        listaParamatrosDeIngreso.get(0).get("clave")));
    }


    @When("^procedo a buscar el producto y lo agrego al carrito de compras$")
    public void procedoABuscarElProductoYLoAgregoAlCarritoDeCompras() {
        theActorInTheSpotlight().attemptsTo(AgregarProductoAlCarrito.lapTop());
    }

    @Then("^se visualiza que fue agregado exitosamente$")
    public void seVisualizaQueFueAgregadoExitosamente() {

    }


}
