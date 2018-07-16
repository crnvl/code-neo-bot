package core;

import commands.*;
import config.settings;
import listeners.commandlistener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import worker.CommandHandler;

import javax.security.auth.login.LoginException;


public class Main {

    public static JDABuilder builder;

    public static void main(String[] Args) throws LoginException, InterruptedException {
        builder = new JDABuilder(AccountType.BOT);

        //Important
        builder.setToken(settings.TOKEN);
        builder.setAutoReconnect(true);

        //Status
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setGame(Game.playing("cn:help | Twitter: @CodeNeoBot"));

        //Listeners
        builder.addEventListener(new commandlistener());

        addCommands();


        try {
            JDA jda = builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
            builder.setStatus(OnlineStatus.IDLE);
            builder.setGame(Game.playing("low processing mode!"));
        }

    }

    public static void addCommands() {

        CommandHandler.commands.put("ping", new ping());

        CommandHandler.commands.put("help", new help());

        CommandHandler.commands.put("github", new github());

        CommandHandler.commands.put("servercount", new servercount());

        CommandHandler.commands.put("usercount", new usercount());

        CommandHandler.commands.put("say", new say());

        CommandHandler.commands.put("kick", new kick());

        CommandHandler.commands.put("serverinfo", new serverinfo());

        CommandHandler.commands.put("ban", new ban());

        CommandHandler.commands.put("bugreport", new bugreport());

        CommandHandler.commands.put("mute", new mute());

        CommandHandler.commands.put("unmute", new unmute());

        CommandHandler.commands.put("info", new info());

        CommandHandler.commands.put("p", new paladinsprofile());
        CommandHandler.commands.put("paladins", new paladinsprofile());

    }
}
