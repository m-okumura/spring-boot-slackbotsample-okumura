package service;

import controller.RestaurantController;
import dto.RestaurantDataDto;
import org.riversun.slacklet.SlackletRequest;

/**
 * Created by m-okumura on 2017/07/12.
 */
public class SlackDMService {

    public static String getReplyMessage(SlackletRequest req){

        String replyMessage = "";
        // メッセージを送信したユーザーのメンションを取得する
        String mention = req.getUserDisp();

        String content = req.getContent();
        // TODO メッセージ内容に従い処理する実装を
        if (content.matches(".*" + "ランチ" + ".*")) {
            RestaurantDataDto data = RestaurantController.getReccomendRestaurant();

            replyMessage = mention
                    + "、今日のおすすめは\n「"
                    + data.getName() + "」である。心して味わうが良い。\n"
                    + data.getUrl();
        } else if (content.matches(".*" + "座席" + ".*")) {

            replyMessage = "https://docs.google.com/spreadsheets/d/1KFpZaBVKA6EKsLE3K-12z_SnrsD1EkU5kyI0bGnvvH8/edit#gid=640691184";
        }

        return (replyMessage);

    }

}
