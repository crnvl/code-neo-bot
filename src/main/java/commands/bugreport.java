package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class bugreport implements runinterface {

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

        if (msg.length() == 0) {
            event.getTextChannel().sendMessage(
                    new EmbedBuilder().setColor(Color.RED)
                            .setTitle("ERROR")
                            .setDescription("Please describe your problem!").build()).queue();
        }else {

            event.getJDA().getGuildById("464170434745860116").getTextChannelById("465274820050026500").sendMessage(
                    new EmbedBuilder().setColor(Color.BLACK)
                            .setTitle("BUG | GUILD: " + event.getMessage().getTextChannel().getGuild().getName())
                            .setDescription("Message:\n" + msg)
                            .setFooter("User: " + event.getMessage().getAuthor().getName() + " | ", event.getMessage().getTextChannel().getGuild().getIconUrl())
                            .setTimestamp(event.getMessage().getCreationTime())
                            .build()).queue();
            event.getMessage().getTextChannel().sendMessage(":white_check_mark: _Your bug has been reported!_").queue();
    }
    event.getMessage().delete().queue();
    }

}
