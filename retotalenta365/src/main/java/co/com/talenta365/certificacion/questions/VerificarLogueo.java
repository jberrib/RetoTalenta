package co.com.talenta365.certificacion.questions;

import co.com.talenta365.certificacion.userinterface.PaginaInicial;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class VerificarLogueo implements Question<Boolean> {

    private String nombreuser;

    public VerificarLogueo(String nombreuser) {
        this.nombreuser = nombreuser;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Text.of(PaginaInicial.LBL_NOMBRE_USUARIO).viewedBy(actor).asString().equals(nombreuser);
    }

    public static VerificarLogueo conUsuario(String nombreuser) {
        return new VerificarLogueo(nombreuser);
    }
}
