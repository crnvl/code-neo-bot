package listeners;

import config.settings;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import worker.CommandHandler;
import java.util.Objects;

public class commandlistener extends ListenerAdapter{

        public void onMessageReceived(MessageReceivedEvent event) {
            if(event.getMessage().getAuthor().isBot()) {

            }else
                if (event.getMessage().getContentRaw().startsWith(settings.PREFIX)
                        && !Objects.equals(event.getMessage().getAuthor().getId(), event.getJDA().getSelfUser().getId())
                        && !event.getMessage().getAuthor().isBot()) {
                    CommandHandler.handleCommand(CommandHandler.parse.parser(event.getMessage().getContentRaw(), event, settings.PREFIX));
                }
        }

    }
