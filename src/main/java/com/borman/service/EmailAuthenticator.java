package com.borman.service;

import javax.mail.PasswordAuthentication;

public class EmailAuthenticator extends javax.mail.Authenticator
{
    private final String login   ;
    private final String password;
    public EmailAuthenticator (final String login, final String password)
    {
        this.login    = login;
        this.password = password;
    }
    public PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication(login, password);
    }
}
