package co.com.talenta365.certificacion.tasks;

import co.com.talenta365.certificacion.questions.VerificarLogueo;
import co.com.talenta365.certificacion.userinterface.PaginaInicial;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarProductoAlCarrito implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        theActorInTheSpotlight().should(seeThat(VerificarLogueo.conUsuario(theActorInTheSpotlight().recall("Usuario"))));
        actor.attemptsTo(Scroll.to(PaginaInicial.SELECCIONAR_PRODUCTO),
                Click.on(PaginaInicial.PRODUCTO),
                WaitUntil.the(PaginaInicial.NOMBRE_PRODUCTO, isVisible()),
                Click.on(PaginaInicial.BTN_AGREGAR));

        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.getMessage();
        }
    }

    public static AgregarProductoAlCarrito lapTop(){
        return Tasks.instrumented(AgregarProductoAlCarrito.class);
    }
}
