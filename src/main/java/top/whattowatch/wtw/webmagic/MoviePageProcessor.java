package top.whattowatch.wtw.webmagic;


import org.apache.commons.lang3.StringUtils;
import top.whattowatch.wtw.po.Movie;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 江南小俊
 * @create 2018-07-26 11:24
 * @desc 爬虫入口
 **/
public class MoviePageProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(0).setUserAgent(
            "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36").setTimeOut(2000);
    private static volatile ArrayList<String> oldUrls = new ArrayList<String>();
    static long num = 0;
    static long queueNum = 0;
    private static volatile ArrayList<Movie> movieList = new ArrayList<Movie>();

    public ArrayList<Movie> main() {
        Spider.create(new MoviePageProcessor()).addUrl("http://www.dytt8.net")
                .thread(200).run();
        return movieList;
    }

    @Override
    public void process(Page page) {
        String url = null;
        String title = null;
        String introduction = null;
        String cover = null;
        String resources = null;
        String types = null;
        url = page.getUrl().toString();
        List<String> resourcesList = null;
        oldUrls.add(url);
        title = page.getHtml().$(".title_all >h1 >font", "text").toString();
        introduction = page.getHtml().$("#Zoom >span >p", "text").toString();
        cover = page.getHtml().$("div#Zoom img[src]", "abs:src").toString();
        resourcesList = page.getHtml().$("a[href^=ftp]", "href").all();
        if (resourcesList != null && resourcesList.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : resourcesList) {
                if (stringBuilder.length() != 0 && stringBuilder.toString() != "") {
                    stringBuilder = stringBuilder.append(";" + s);
                } else {
                    stringBuilder.append(s);
                }
            }
            resources = stringBuilder.toString();

        } else {
            resources = null;
        }
        if (introduction != null) {
            types = StringUtils.substringBetween(introduction.trim().replace("　", "").replace(" ", ""), "◎类别", "◎");

        }

        if (title != null && resources != null) {
            Movie movie;
            movie = new Movie();
            movie.setUrl(url);
            movie.setTitle(title);
            if (introduction != null) {
                movie.setIntroduction(introduction.replace("◎", "\n◎"));
            }
            movie.setCover(cover);
            movie.setResources(resources);
            movie.setTypes(types);
            movieList.add(movie);
        }
        for (String newUrl : page.getHtml().links().all()) {
            if (!oldUrls.contains(newUrl) && newUrl.matches("http://www.dytt8.net/(.*).html") && movieList.size() < 300) {
                page.addTargetRequest(new Request(newUrl));
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}
