package org.sendmail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Custoauthen extends Authenticator {

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(mailconstant.SENDER,"kgqnkhmaphaqbgtf");
    }
}
