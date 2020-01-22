package co.com.talenta365.certificacion.tasks;

import co.com.talenta365.certificacion.userinterface.PaginaInicial;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoguearmeEnPagina implements Task {

    private String user;
    private  String clave;

    public LoguearmeEnPagina(String user, String clave) {
        this.user = user;
        this.clave = clave;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
       actor.attemptsTo(WaitUntil.the(PaginaInicial.CONTENEDOR, isVisible()),
               Click.on(PaginaInicial.BTN_LOGUEO),
               Enter.theValue(user).into(PaginaInicial.TXT_USUARIO),
               Enter.theValue(clave).into(PaginaInicial.TXT_CLAVE),
               Click.on(PaginaInicial.BTN_INGRESAR),
               WaitUntil.the(PaginaInicial.LBL_NOMBRE_USUARIO, isVisible()));
       actor.remember("Usuario",user);
    }

    public static LoguearmeEnPagina conLaSigueienteCredenciales(String user, String clave){
        return Tasks.instrumented(LoguearmeEnPagina.class,user,clave);
    }
}
