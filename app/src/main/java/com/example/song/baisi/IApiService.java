package com.example.song.baisi;

import com.example.song.baisi.jinghua.CommentListEntity;
import com.example.song.baisi.jinghua.QuanBuEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.example.song.baisi.IApiService.TUIJIAN_COMMENT_URL;

/**
 * Created by 11355 on 2016/11/28.
 */

public interface IApiService {
    //0-20.json
    public static final String COM_PATH = "budejie-android-6.5.7/0-{json}.json?market=tencentyingyongbao&udid=864394010748616&appname=baisibudejie&os=4.4.2&client=android&visiting=&mac=08%3A00%3A27%3A00%3A48%3A0D&ver=6.5.7";
    /**
     * 推荐页面URL
     */
    public static final String TJ_PATH = "http://s.budejie.com/topic/list/jingxuan/1/";

    @GET(IApiService.COM_PATH)
    Call<QuanBuEntity> getTuijian(@Path("json") String json);

    @GET(IApiService.NEW_COM_PATH)
    Call<QuanBuEntity> getNewQuanBu(@Path("json") String json);

    @GET(TUIJIAN_COMMENT_URL)
    Call<String> getCommentTuiJian(@Path("id") String id);

    /**
     * 视频页面URL
     */
    public static final String SP_PATH = "http://s.budejie.com/topic/list/jingxuan/41/";
    /**
     * 图片页面URL
     */
    public static final String TP_PATH = "http://s.budejie.com/topic/list/jingxuan/10/";
    /**
     * 段子页面URL
     */
    public static final String DZ_PATH = "http://s.budejie.com/topic/tag-topic/64/hot/";
    /**
     * 网红页面URL
     */
    public static final String WH_PATH = "http://s.budejie.com/topic/tag-topic/3096/hot/";
    /**
     * 排行页面URL
     */
    public static final String PH_PATH = "http://s.budejie.com/topic/list/remen/1/";
    /**
     * 社会页面URL
     */
    public static final String SH_PATH = "http://s.budejie.com/topic/tag-topic/473/hot/";
    /**
     * 美女页面URL
     */
    public static final String MN_PATH = "http://s.budejie.com/topic/tag-topic/117/hot/";
    /**
     * 冷知识页面URL
     */
    public static final String LZS_PATH = "http://s.budejie.com/topic/tag-topic/3176/hot/";
    /**
     * 游戏页面URL
     */
    public static final String YX_PATH = "http://s.budejie.com/topic/tag-topic/164/hot/";


    //最新
    public static final String NEW_COM_PATH = "budejie-android-6.6.1/0-{json}.json?market=baidu&ver=6.6.1&visiting=&os=5.1&appname=baisibudejie&client=android&udid=000000000000000&mac=08%3A00%3A27%3A6a%3Aff%3Acf";
    public static final String NEW_ZX_PATH = "http://s.budejie.com/topic/list/zuixin/1/";
    //视频
    public static final String NEW_SP_PATH = " http://s.budejie.com/topic/list/zuixin/41/";
    //  图片
    public static final String NEW_TP_PATH = "http://s.budejie.com/topic/list/zuixin/10/";
    //    段子
    public static final String NEW_DZ_PATH = "http://s.budejie.com/topic/list/zuixin/29/";
    //美女
    public static final String NEW_MN_PATH = "http://s.budejie.com/topic/tag-topic/117/new/";
    //    冷知识
    public static final String NEW_LZS_PATH = "http://s.budejie.com/topic/tag-topic/3176/new/";
    //    游戏
    public static final String NEW_YX_PATH = "http://s.budejie.com/topic/tag-topic/164/new/";
    //    声音
    // http://s.budejie.com/topic/list/zuixin/31/budejie-android-6.6.1/0-20.json?market=baidu&ver=6.6.1&visiting=&os=5.0&appname=baisibudejie&client=android&udid=000000000000000&mac=08%3A00%3A27%3Aec%3A7d%3Aef
    //网红
    public static final String NEW_WH_PATH = "http://s.budejie.com/topic/tag-topic/3096/new/";
    // http://c.api.budejie.com/topic/comment_list/22455798/0/budejie-android-6.6.1/0-20.json?
//评论baseUrl
    public static final String COMMENT_BASE_URL = "http://c.api.budejie.com/";
    //推荐评论
    public static final String TUIJIAN_COMMENT_URL = "topic/comment_list/{id}/0/budejie-android-6.6.1/0-20.json?";


    /**
     * 我的圆形选项
     */
    public static final String MINE_OPTION = "http://s.budejie.com/op/square2/budejie-android-6.5.8/tencentyingyongbao/0-100.json?market=tencentyingyongbao&udid=864394010216507&appname=baisibudejie&os=4.4.2&client=android&visiting=&mac=D8%3A50%3AE6%3AA4%3A16%3AD7&ver=6.5.8";


    public static final String MINE_OPTIONMENU = "http://d.api.budejie.com/tag/subscribe/budejie-android-6.5.8.json";

}
