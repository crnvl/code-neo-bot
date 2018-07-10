package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class help implements runinterface {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        event.getTextChannel().sendMessage(
                new EmbedBuilder().setColor(Color.BLACK)
                        .setTitle("Code:Neo Command List")
                        .setDescription("__**BOT RELATED**__\n``cn:help``, ``cn:github``, ``cn:servercount``, ``cn:usercount``, ``cn:bugreport``\n\n" +
                                        "__**MODERATION**__\n``cn:kick``, ``cn:ban``\n\n" +
                                        "__**SERVER**__\n``cn:serverinfo``\n\n" +
                                        "__**FUN**__\n``cn:say``")
                        .setFooter("Created by " + event.getJDA().getUserById("265849018662387712").getName(), event.getJDA().getUserById("265849018662387712").getAvatarUrl())
                        .build()).queue();

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
