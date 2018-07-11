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
        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}