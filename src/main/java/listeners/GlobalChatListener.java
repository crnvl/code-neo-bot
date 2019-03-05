package listeners;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GlobalChatListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getTextChannel().getId().contains("523561706841047064")) {
            if(event.getMessage().getContentRaw().startsWith(".about")) {
                event.getTextChannel().sendMessage("**Code:Neo** is the first Bot which got implemented into Kazuma's Global Chat\n" +
                                                        "The Bot is currently on version 1.0 and still in development.\n" +
                                                        "Get your own Bot registered [here](https://discord.gg/fyJ6PFj)\n").queue();
            }
        }
    }
}
