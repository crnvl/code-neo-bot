package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class serverinfo implements runinterface {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(
                new EmbedBuilder().setColor(Color.BLACK)
                        .setTitle(event.getMessage().getTextChannel().getGuild().getName() + " serverinfo")
                        .setDescription("**ID**: ``" + event.getMessage().getTextChannel().getGuild().getId() + "``\n" +
                                        "**REGION**: ``" + event.getMessage().getTextChannel().getGuild().getRegionRaw() + "``\n" +
                                        "**OWNER**: ``" + event.getMessage().getTextChannel().getGuild().getOwner().getEffectiveName() + "``\n" +
                                        "**MEMBERCOUNT**: ``" + event.getMessage().getTextChannel().getGuild().getMembers().size() + "``\n" +
                                        "**NOTIFICATION LEVEL**: ``" + event.getMessage().getTextChannel().getGuild().getDefaultNotificationLevel() + "``\n" +
                                        "**VERIFICATION LEVEL**: ``"  + event.getMessage().getTextChannel().getGuild().getVerificationLevel() + "``\n" +
                                        "**TEXTCHANNELS**: ``" +  event.getMessage().getTextChannel().getGuild().getTextChannels().size() + "``\n" +
                                        "**VOICECHANNELS**: ``" +  event.getMessage().getTextChannel().getGuild().getVoiceChannels().size() + "``\n" +
                                        "**CATEGORIES**: ``" + event.getMessage().getTextChannel().getGuild().getCategories().size() + "``\n" +
                                        "**ROLES**: ``" + event.getMessage().getTextChannel().getGuild().getRoles().size() + "``").build()).queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
