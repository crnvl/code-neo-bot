package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class ban implements runinterface {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        List argsList = Arrays.asList(args);
        StringBuilder sb = new StringBuilder();
        argsList.forEach(s -> sb.append(s + " "));
        send(args, event);

    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    public static boolean isMention(String toCheck){
        return toCheck.matches("<@(!)?\\d{18}>");
    }

    private void send(String[] args, MessageReceivedEvent event) {
        if (event.getGuild().getMember(event.getMessage().getAuthor()).hasPermission(Permission.BAN_MEMBERS)) {
            if (args.length != 1) {
                event.getTextChannel().sendMessage(
                        new EmbedBuilder().setColor(Color.RED)
                                .setTitle("ERROR")
                                .setDescription("Please enter a user id or mention a user!").build()).queue();
            } else {
                if (isMention(args[0])) {
                    event.getGuild().getController().ban(event.getMessage().getMentionedMembers().get(0), 0).queue();
                    event.getTextChannel().sendMessage(
                            new EmbedBuilder().setColor(Color.BLACK)
                                    .setTitle("Ban")
                                    .setDescription("**" + event.getMessage().getMentionedMembers().get(0).getAsMention() + "** _has been banned!_").build()).queue();
                } else if (event.getGuild().getMemberById(args[0]) != null) {
                    event.getGuild().getController().ban(event.getGuild().getMemberById(args[0]), 0).queue();
                    event.getTextChannel().sendMessage(
                            new EmbedBuilder().setColor(Color.BLACK)
                                    .setTitle("Ban")
                                    .setDescription("**" + event.getGuild().getMemberById(args[0]).getAsMention() + "** _has been banned!_").build()).queue();
                } else {
                    event.getMessage().getTextChannel().sendMessage("Sorry, I can't find that user!").queue();
                }
            }
        }else{
            event.getMessage().getTextChannel().sendMessage("You don't have the permission to do that!").queue();
        }
    }
}
