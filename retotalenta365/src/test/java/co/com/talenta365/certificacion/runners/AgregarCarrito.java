package co.com.talenta365.certificacion.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/agregar_carrito.feature",
        glue = "co.com.talenta365.certificacion.stepdefinitions",
        snippets = SnippetType.CAMELCASE)
public class AgregarCarrito {
}
