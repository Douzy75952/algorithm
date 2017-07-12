package cn.thinkjoy.report.spider;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.thinkjoy.common.HttpRequest;
import com.thinkjoy.report.entity.ZgkUniversity;
import com.thinkjoy.report.entity.ZgkUniversityEnrolling;
import com.thinkjoy.service.api.report.ZgkUniversityEnrollingService;
import com.thinkjoy.service.api.report.ZgkUniversityService;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by douzy on 17/5/2.
 */
public class SpiderMain {

    protected static String loginUser="18710921677",loginPass="123123",loginUrl="/ajaxpro/Zero.Web.Pc.AjaxServices.Users.UserAuthService,Zero.Web.Pc.ashx";

    protected static ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring-base.xml"});

    protected static String baseScoreUrl="http://www.youzy.cn/college/%s/cfraction.html";

    static ZgkUniversityEnrolling universityEnrolling(Integer uid,String batch,String enrollingnumber,
                                                      String highScore,String lowScore,String avgScore) {
        ZgkUniversityEnrolling zgkUniversityEnrolling = new ZgkUniversityEnrolling();
        zgkUniversityEnrolling.setAreaid("320000");
        zgkUniversityEnrolling.setYear(2015);
        zgkUniversityEnrolling.setMajortype("2");
        zgkUniversityEnrolling.setUniversityid((long) uid);
        zgkUniversityEnrolling.setBatch(batch);
        zgkUniversityEnrolling.setRealenrollingnumber(enrollingnumber);
        zgkUniversityEnrolling.setHighestscore(highScore);
        zgkUniversityEnrolling.setLowestscore(lowScore);
        zgkUniversityEnrolling.setAveragescore(avgScore);
        zgkUniversityEnrolling.setPlanenrollingnumber(0);

        return zgkUniversityEnrolling;
    }

    public static void main(String[] args) throws Exception {

//        loginHtml("www.youzy.cn",80,loginUrl,loginUser,loginPass);


        List<ZgkUniversity> zgkUniversities = getUniversitys();

        if (zgkUniversities == null)
            return;

        List<ZgkUniversityEnrolling> zgkUniversityEnrollings=new ArrayList<>();

        for (ZgkUniversity zgkUniversity : zgkUniversities) {
            System.out.println(zgkUniversity.getName());
            Integer universityId = getUniversityId(zgkUniversity.getName());
            System.out.println(universityId);

            String scoreUrl=String.format(baseScoreUrl,universityId);

            String strHtml=htmlUnitPickData(scoreUrl);

             analyzeHTMLByString(strHtml);

//            ZgkUniversityEnrolling  zgkUniversityEnrolling=universityEnrolling(zgkUniversity.getId(),);
        }

    }

    /**
     * 构造院校录取对象
     * @return
     */
    private static boolean insertUniversityEnrolling(List<ZgkUniversityEnrolling> zgkUniversityEnrollings) {
        ZgkUniversityEnrollingService zgkUniversityEnrollingService = (ZgkUniversityEnrollingService) ac.getBean("ZgkUniversityEnrollingServiceImpl");

        Integer result = zgkUniversityEnrollingService.insertUniversityEnrollingList(zgkUniversityEnrollings);

        return result > 0;
    }


    /**
     * 获取院校列表
     * @return
     */
    private static List<ZgkUniversity> getUniversitys() {
        ZgkUniversityService universityService = (ZgkUniversityService) ac.getBean("zgkUniversityServiceImpl");
        List<ZgkUniversity> zgkUniversities = universityService.selectZgkUniversitys(null);
        return zgkUniversities;
    }


    /**
     * 获取优志愿院校ID
     * @param universityName
     * @return
     */
    private static Integer getUniversityId(String universityName) {

        Gson gson = new GsonBuilder().enableComplexMapKeySerialization()
                .create();

        Integer universityId = 0;

        String startUrl = "http://www.youzy.cn/ScoreLines/AjaxServices/SuggestSearchColleges.ashx",
                params = "wd=" + universityName + "&functionName=";

        String universionJson = HttpRequest.sendGet(startUrl, params);

        List<Map<String,String>> maps= gson.fromJson(universionJson,new TypeToken<List<Map<String,String>>>() {
        }.getType());

        for(Map map:maps) {
            if (map.get("data").equals(universityName)) {
                universityId = Integer.valueOf(map.get("id").toString());
                break;
            }
        }
        return universityId;
    }





//    private static String[] loginHtml(String LOGON_SITE, int LOGON_PORT, String
//            login_Action, String... params) throws Exception {
//        String[] result = null;
//        HttpClient client = new HttpClient();
//        client.getHostConfiguration().setHost(LOGON_SITE, LOGON_PORT);
//// 模拟登录页面
//        PostMethod post = new PostMethod(login_Action);
//        NameValuePair userName = new NameValuePair("Username", params[0]);
//        NameValuePair password = new NameValuePair("Password", params[1]);
//        post.setRequestBody(new NameValuePair[]{userName, password});
//        client.executeMethod(post);
//        String response = post.getResponseBodyAsString();
//
//        System.out.println(response);
//        System.out.println("执行状态：" + client.getState());
//        post.releaseConnection();
//// 查看 cookie 信息
//        CookieSpec cookiespec = CookiePolicy.getDefaultSpec();
//        Cookie[] cookies = cookiespec.match(LOGON_SITE, LOGON_PORT, "/", false,
//                client.getState().getCookies());
//        if (cookies != null)
//            if (cookies.length == 0) {
//                System.out.println("Cookies is not Exists ");
//            } else {
//                for (int i = 0; i < cookies.length; i++) {
//                    System.out.println("----------------------------------------------------");
//                    System.out.println(cookies[i].toString());
//                    result = cookies[i].toString().split("=");
//                    System.out.println("----------------------------------------------------");
//                }
//            }
//
//        return result;
//    }
    // GET
//    public static String httpClientFetch(String url, String charset) throws Exception {
//        HttpClient httpClient = new HttpClient();
//        httpClient.getParams().setContentCharset(charset);
//        HttpMethod method = new GetMethod(url);
//        httpClient.executeMethod(method);
//        return method.getResponseBodyAsString();
//    }
    /*
    * 爬取网页信息
    */
    private static String pickData(String url) {


        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(url);
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                // 打印响应状态
                if (entity != null) {
                    return EntityUtils.toString(entity);
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    private static String htmlUnitPickData(String url) throws IOException, InterruptedException {
        final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38);

        webClient.getOptions().setThrowExceptionOnScriptError(false); //此行必须要加
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.setCookieManager(new CookieManager());
        //启动ajax代理
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setTimeout(300000);

        HtmlPage page =  webClient.getPage(url);

        HtmlAnchor anchor = (HtmlAnchor) page.getElementById("aLogin");

        if (anchor == null)
            analyzeHTMLByString("");
        else {

            Thread.sleep(10000);

            HtmlPage page2=anchor.click();

            String text=page2.asXml();

            HtmlInput usernameInput= page2.getElementByName("username");
            usernameInput.type(loginUser);
            HtmlInput passwordInput= page2.getElementByName("password");
            passwordInput.type(loginPass);

            HtmlButton btnSubmit=null;

            DomNodeList<DomElement> domElements=page2.getElementsByTagName("button");

            for(DomElement temp:domElements){

                if(temp.getAttribute("class").equals("btn btn-primary btn-block btn-lg")){

                    btnSubmit= (HtmlButton) temp;

                }

            }

//            HtmlButton submit = (HtmlButton) page2.("loginBtn");
            HtmlPage nextPage = btnSubmit.click();
            Thread.sleep(100000);
            System.out.println(nextPage.asXml());
            Integer a=0;
        }
        return "";
    }

    private static void analyzeHTMLByString(String html){
        String solarDate,lunarDate,chineseAra,should,avoid=" ";
        Document document = Jsoup.parse(html);
        System.out.println(document.getElementsByClass("table-th-gray"));
//        //公历时间
//        solarDate=getSolarDate();
//        //农历时间
//        Element eLunarDate=document.getElementById("info_nong");
//        lunarDate=eLunarDate.child(0).html().substring(1,3)+eLunarDate.html().substring(11);
//        //天干地支纪年法
//        Element eChineseAra=document.getElementById("info_chang");
//        chineseAra=eChineseAra.text().toString();
//        //宜
//        should=getSuggestion(document,"yi");
//        //忌
//        avoid=getSuggestion(document,"ji");
//        Almanac almanac=new Almanac(solarDate,lunarDate,chineseAra,should,avoid);
//        return almanac;
    }

}
