package commands;

import commands.runinterface;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zekro on 12.04.2017 / 11:05
 * supremeBot/commands
 * © zekro 2017
 */

public class say implements runinterface {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        List argsList = Arrays.asList(args);
        StringBuilder sb = new StringBuilder();
        argsList.forEach(s -> sb.append(s + " "));
        send(sb.toString(), event);

    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }


    private void send(String msg, MessageReceivedEvent event) {

        event.getMessage().delete().queue();
        event.getTextChannel().sendMessage(msg).queue();
    }
}