package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class servercount implements runinterface {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        event.getTextChannel().sendMessage(
                new EmbedBuilder().setColor(Color.BLACK)
                        .setTitle("Code:Neo Servercount")
                        .setDescription(event.getJDA().getSelfUser().getAsMention() + " is running on " + event.getJDA().getGuilds().size() + " Guild(s)").build()).queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
