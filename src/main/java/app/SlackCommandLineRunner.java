package app;

import config.SlackConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.riversun.slacklet.SlackletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.riversun.slacklet.Slacklet;
import org.riversun.slacklet.SlackletRequest;
import org.riversun.slacklet.SlackletResponse;
import service.SlackDMService;

import java.io.IOException;

@Component
@Slf4j
public class SlackCommandLineRunner implements CommandLineRunner {

    @Autowired
    private ApplicationArguments appArgs;
    //@Autowired
    //private SlackConfiguration slackConfiguration;

    @Override
    public void run(String... args) throws Exception {

        //SlackletService slackService = new SlackletService(slackConfiguration.getToken());
        SlackletService slackService = new SlackletService("xoxb-207374748755-OXphxEBx0TvpS5FtrbDGqCRr");

        slackService.addSlacklet(new Slacklet() {

            @Override
            public void onDirectMessagePosted(SlackletRequest req, SlackletResponse resp) {
                // BOT宛のダイレクトメッセージがポストされた

                SlackDMService slackDMService = new SlackDMService();

                resp.reply(slackDMService.getReplyMessage(req));
            }

            @Override
            public void onMentionedMessagePosted(SlackletRequest req, SlackletResponse resp) {
                // あるチャンネルでこのBOTへのメンション付きメッセージがポストされた(例　「@smilebot おはよう」）

                String content = req.getContent();

                String mention = req.getUserDisp();
                resp.reply("こんにちは、" + mention + "さん。「" + content + "」って言いましたね。");
            }

        });

        try {
            slackService.start();
        } catch(IOException e) {

        }
    }
}
