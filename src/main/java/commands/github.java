package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class github implements runinterface {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        event.getTextChannel().sendMessage(
                new EmbedBuilder().setColor(Color.BLACK)
                        .setTitle("Code:Neo GitHub repository")
                        .setDescription("[GitHub repository](https://github.com/shinixsensei-dev/code-neo-bot)").build()).queue();

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
