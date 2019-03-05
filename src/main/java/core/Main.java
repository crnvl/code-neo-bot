package core;


;
import config.settings;
import listeners.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;
import java.util.HashMap;


public class Main {

    public static JDABuilder builder;
    public static HashMap REGBOTS = new HashMap();
    public static HashMap PBIO = new HashMap();
    public static HashMap LEVEL = new HashMap();

    public static void main(String[] Args) throws LoginException, InterruptedException {
        builder = new JDABuilder(AccountType.BOT);

        //Important
        builder.setToken(settings.TOKEN);
        builder.setAutoReconnect(true);
        builder.setAudioEnabled(true);

        //Status
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setGame(Game.streaming("betatesting mode", "https://www.twitch.tv/shinixsensei"));

        //Listeners
        builder.addEventListener(new GlobalChatListener());
        //builder.addEventListener(new commandlistener());
        //builder.addEventListener(new GuildsChannelListener());
        //builder.addEventListener(new YuriBotListener());
        //builder.addEventListener(new LevelListener());

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

        /**CommandHandler.commands.put("ping", new ping());

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

        CommandHandler.commands.put("m", new music());
        CommandHandler.commands.put("music", new music());

        //NEW

        CommandHandler.commands.put("cuddle", new cuddle());

       CommandHandler.commands.put("google", new google());

       CommandHandler.commands.put("kiss", new kiss());

       CommandHandler.commands.put("profile", new profile());
       CommandHandler.commands.put("userinfo", new profile());


       //TEST

        CommandHandler.commands.put("test", new test());
        CommandHandler.commands.put("emoji", new EmoteTracker());
        CommandHandler.commands.put("gcregister", new registerCommand());
        CommandHandler.commands.put("bioset", new biosetcmd());
        CommandHandler.commands.put("profilecard", new profilecard());
        CommandHandler.commands.put("emoteone", new animojione());
        CommandHandler.commands.put("fakeuser", new FakeUserCommand());**/

    }
}
