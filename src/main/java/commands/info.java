package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class info implements runinterface {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(
                new EmbedBuilder().setColor(Color.BLACK)
                        .setTitle("Code:Neo information")
                        .addField("Support Server", "[Join](https://discord.gg/zF8zCXF)", true)
                        .addField("Add bot", "[Invite](https://bit.ly/CodeNeoBot)", true)
                        .addField("Social Media", "[Twitter](https://twitter.com/CodeNeoBot)", true)
                        .build()).queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
