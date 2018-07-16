package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class mute implements runinterface {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (event.getGuild().getMember(event.getMessage().getAuthor()).hasPermission(Permission.MANAGE_SERVER)) {
<<<<<<< HEAD
            if(args.length < 1) {
                event.getTextChannel().sendMessage(
                        new EmbedBuilder().setColor(Color.RED)
                                .setTitle("ERROR")
                                .setDescription("Please mention a user!").build()).queue();
            }else if(event.getMessage().getMentionedMembers().get(0) != null){
                event.getTextChannel().createPermissionOverride(event.getMessage().getMentionedMembers().get(0)).setDeny(Permission.MESSAGE_WRITE).queue();
                event.getTextChannel().sendMessage(
                        new EmbedBuilder().setColor(Color.BLACK)
                                .setTitle("User muted")
                                .setDescription(event.getMessage().getMentionedMembers().get(0).getEffectiveName() + " has been muted!").build()).queue();
            }else {
                event.getMessage().getTextChannel().sendMessage("Sorry, I can't find that user!").queue();
            }
        }else{
            event.getMessage().getTextChannel().sendMessage("You don't have the permission to do that!").queue();
=======
        if(args.length < 1) {
            event.getTextChannel().sendMessage(
                    new EmbedBuilder().setColor(Color.RED)
                            .setTitle("ERROR")
                            .setDescription("Please mention a user!").build()).queue();
        }else {
            event.getTextChannel().createPermissionOverride(event.getMessage().getMentionedMembers().get(0)).setDeny(Permission.MESSAGE_WRITE).queue();
            event.getTextChannel().sendMessage(
                    new EmbedBuilder().setColor(Color.BLACK)
                            .setTitle("User muted")
                            .setDescription(event.getMessage().getMentionedMembers().get(0).getEffectiveName() + " has been muted!").build()).queue();
>>>>>>> 7b26200d74144a0ce12fc50422c9c7bcb4b92847
        }
          }else{
                event.getMessage().getTextChannel().sendMessage("You don't have the permission to do that!").queue();
            }
}

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}