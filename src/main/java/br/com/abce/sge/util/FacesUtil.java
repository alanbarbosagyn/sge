package br.com.abce.sge.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {

    public static void sendMsg(final String titulo, final String mensagem, FacesMessage.Severity level) {

        FacesContext.getCurrentInstance().addMessage(
                null, new FacesMessage(level, titulo, mensagem));

    }
}
