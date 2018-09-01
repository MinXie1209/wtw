package top.whattowatch.wtw.webmagic;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import top.whattowatch.wtw.po.Movie;
import top.whattowatch.wtw.utils.CommonUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author 江南小俊
 * @create 2018-07-26 11:24
 * @desc 爬虫入口
 **/
public class MoviePageProcessor implements PageProcessor {

    private Site site = Site.me().setTimeOut(10000).
            setRetryTimes(3).setSleepTime(100).setDomain("http://www.dytt8.net").
            setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36");
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
        if(title!=null){
           // 《忧郁症/惊悚末日》
            title=StringUtils.substringBetween(title, "《", "》");
        }
        introduction = page.getHtml().xpath("//*[@id='Zoom']/span/tidyText()").get();
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
        /**
         * 1.获取类型
         * 2.优化简介
         */
        if (introduction != null) {
            types = CommonUtils.getTypes(introduction);
            String newIntroduction=StringUtils.substringBetween(introduction.trim(), "", "【下载地址】");
            if(newIntroduction!=null){
                introduction= newIntroduction;
            }
            introduction = CommonUtils.deleteCRLF(introduction);
        }
        if (types != null && title != null && resources != null && resources.length() < 5000) {
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
            /**
             * 过滤爬取链接
             */
            if (!oldUrls.contains(newUrl) && newUrl.matches("http://www.dytt8.net/(.*).html") && !newUrl.matches("http://www.dytt8.net/html/game/(.*).html") && !newUrl.matches("http://www.dytt8.net/html/tv/(.*).html") && !newUrl.matches("http://www.dytt8.net/html/2009zongyi/(.*).html") && !newUrl.matches("http://www.dytt8.net/html/zongyi2013/(.*).html") && !newUrl.matches("http://www.dytt8.net/html/dongman/(.*).html")) {
                page.addTargetRequest(new Request(newUrl));
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}
