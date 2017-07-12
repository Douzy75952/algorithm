package cn.thinkjoy.report.spider;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.thinkjoy.base.utils.ConstantKit;
import com.thinkjoy.base.utils.StringUtil;
import com.thinkjoy.report.entity.ZgkUniversity;
import com.thinkjoy.report.entity.ZgkUniversityMajorEnrolling;
import com.thinkjoy.service.api.report.ZgkUniversityMajorEnrollingService;
import com.thinkjoy.service.api.report.ZgkUniversityService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by wangcheng on 17/6/12.
 */
public class ZjSpiderMain {

    public static final Logger logger = Logger.getLogger("MyTest");


    protected static List<Map<String,String>> maps = new ArrayList<>();
    protected static Map<String,String > errorJson = new LinkedHashMap<>();
    protected static Map<String,String > noDataUniversitys = new LinkedHashMap<>();
    protected static Map<String,String > pageDataError = new LinkedHashMap<>();

    protected static List<String> uname = new ArrayList<>();


    //protected static String url="http://z.youzy.cn/college/%s/pfraction.html";
    protected static String url="http://z.youzy.cn/college/pfraction?Id=%s&courseType=0";
    protected static String loginurl="http://www.youzy.cn";

    protected static ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring-base.xml"});

    //账号信息,切换账号时更换
    protected static String loginUser = "13572965806";
    protected static String loginPass = "jiajing";
    protected static String zone = "浙江";

    protected static final WebClient webClient;


    static {
        webClient = new WebClient(BrowserVersion.CHROME);

        webClient.getOptions().setThrowExceptionOnScriptError(false); //此行必须要加
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.setCookieManager(new CookieManager());
        //启动ajax代理
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setTimeout(300000);
        //webClient.setJavaScriptEngine(new MyJavaScriptEngine(webClient));//自定义JavaScript引擎，有js错误不打印
    }

    static {
        uname.add("石家庄医学高等专科学校");
//        uname.add("重庆工商职业学院");
//        uname.add("天津财经大学");
//        uname.add("山西医科大学");
//        uname.add("东北大学");
//        uname.add("辽宁科技大学");
//        uname.add("辽宁石油化工大学");
//        uname.add("沈阳化工大学");
//        uname.add("河海大学");
//        uname.add("南京医科大学");
//        uname.add("宜春学院");
//        uname.add("湖南大学");
//        uname.add("中南大学");
//        uname.add("长沙理工大学城南学院");
//        uname.add("西南财经大学");
//        uname.add("云南农业大学");
//        uname.add("华北电力大学");
    }


    //处理遗漏的学校时使用
    public static List<ZgkUniversity> generalZgkUnversity(){

        List<ZgkUniversity> zgkUniversityList = new ArrayList<>();

        for (int i= 0; i<uname.size(); i++){
            ZgkUniversity zgkUniversity = new ZgkUniversity();
            zgkUniversity.setName(uname.get(i));
            zgkUniversityList.add(zgkUniversity);
        }

        return zgkUniversityList;
    }


    public static void main(String[] args) {

        String name = null;
        int count = 1;
        //获取学校信息
        List<ZgkUniversity> universitys = getUniversitys();
        //List<ZgkUniversity> universitys = generalZgkUnversity();

        for (ZgkUniversity z : universitys) {
            name = z.getName();

            Integer universityId = getUniversityId(name);

            System.out.println("第" + count + "个学校,正在抓取========" + name + "====id为=="+ universityId +"==的数据");

            if (universityId == null || universityId == 0){
                continue;
            }

            String targetUrl = String.format(url, universityId);
            String dataPage = null;

            try {
                dataPage = getDataPage(targetUrl, z, universityId);
                if (dataPage!=null){
                    pageDataError.put(name, dataPage);
                }
            }catch (Exception e) {
                pageDataError.put(name+"Exception", e.getMessage());
                e.printStackTrace();
            }

            count++;
        }

        System.out.println("退出循环了=====count==" + count);

        System.out.println(errorJson.size() + "=错误或无法获取的学校Json数据=====" + errorJson.toString());
        System.out.println(noDataUniversitys.size() + "=没有成绩数据的学校=====" + noDataUniversitys.toString());
        System.out.println(pageDataError.size() + "=没有成功拿到成绩数据页面的学校=====" + pageDataError.toString());

//        单校测试
//        try {
//            getSingleUnversity();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static void getSingleUnversity() throws Exception {

        String targetUrl = "http://www.youzy.cn/college/1735/pfraction.html";

        ZgkUniversity zgkUniversity = new ZgkUniversity();
        zgkUniversity.setAreaid("000000");
        zgkUniversity.setId((long)2716);
        zgkUniversity.setName("山西华奥");

        getDataPage(targetUrl, zgkUniversity, 123);
    }


    public static String getDataPage(String url, ZgkUniversity z, Integer uid) throws Exception {

        //获取数据页面,第一次的话需要登录
        HtmlPage page =  webClient.getPage(url);
        //webClient.waitForBackgroundJavaScript(2000);
        HtmlAnchor anchor = null;

        if (page==null){
            System.out.println("数据页面为空!!!page ==null");
            return ConstantKit.Spider.GET_NULL_PAGE;
        }

        try {
            anchor = page.getAnchorByText("登录");

        }catch (Exception e){
            System.out.println("非第一次,这里无法获取VIP登录登录按钮(正常情况,登陆后不会再次显示此按钮)!");
        }finally {
            if (anchor == null)
                pickData(page, z, uid);
            else {

                webClient.waitForBackgroundJavaScript(5000);

                HtmlPage page2=anchor.click();

                webClient.waitForBackgroundJavaScript(2000);

                String text=page2.asXml();

                HtmlInput usernameInput= page2.getElementByName("username");
                HtmlInput passwordInput= page2.getElementByName("password");


                try {
                    usernameInput.type(loginUser);
                    passwordInput.type(loginPass);
                } catch (IOException e) {
                    System.out.println("没有获取username和password!");
                    e.printStackTrace();
                    return ConstantKit.Spider.GET_INPUT_ELE_ERROR;
                }

                HtmlButton btnSubmit=null;

                DomNodeList<DomElement> domElements=page2.getElementsByTagName("button");

                for(DomElement temp:domElements){

                    if(temp.getAttribute("class").equals("btn btn-primary btn-block btn-lg")
                            &&temp.getAttribute("type").equals("submit")){

                        btnSubmit= (HtmlButton) temp;
                        break;
                    }

                }

                HtmlPage nextPage = btnSubmit.click();

                webClient.waitForBackgroundJavaScript(10000);
                //nextPage = btnSubmit.click();

                //System.out.println(nextPage.asXml());
                HtmlPage p = webClient.getPage(url);
                pickData(p, z, uid);

            }
        }

        return null;
    }

    public static void pickData(HtmlPage page, ZgkUniversity zgkUniversity, Integer uid) throws Exception {

//        System.out.println(page.asXml());

        //数据页面
        Document parse = Jsoup.parse(page.asXml());

        //获取最外层table标签
        Elements aClass = parse.
                getElementsByAttributeValue("class", "table table-hover table-bordered table-th-gray");

        Document table = Jsoup.parse(aClass.toString());

        //获取内层3个tbody
        Elements tbody = table.getElementsByTag("tbody");
        //数据默认在第2个里放着
        Element element = tbody.get(1);

        Elements tr = element.getElementsByTag("tr");

        //但也有可能该学校没有历年数据
        if (tr.isEmpty()||tr == null){
            noDataUniversitys.put(zgkUniversity.getId().toString(),zgkUniversity.getName());
            return;
        }

        ListIterator<Element> elementListIterator = tr.listIterator();
        List<String> list = new ArrayList();

        List<ZgkUniversityMajorEnrolling> enrollingsList = new ArrayList<>();

        while (elementListIterator.hasNext()){

            Element tds = elementListIterator.next();

            Elements children = tds.children();

            ListIterator<Element> tdIterator = children.listIterator();

            while (tdIterator.hasNext()){
                Element td = tdIterator.next();
                String text = td.text();
                list.add(text);
            }

            if (!list.isEmpty()){
                ZgkUniversityMajorEnrolling zgkUniversityEnrolling = universityEnrolling(list, zgkUniversity, uid);
                enrollingsList.add(zgkUniversityEnrolling);
            }else {
                throw new Exception("成绩数据未找到!");
            }

            list.clear();
        }

        boolean b = insertUniversityMajorEnrolling(enrollingsList);
        if (!b){
            throw new Exception("数据插入失败!");
        }
    }


    static ZgkUniversityMajorEnrolling universityEnrolling(List<String> data, ZgkUniversity zgkUniversity, Integer uid) {

        //年份
        int year = Integer.parseInt(data.get(0));
        //专业
        String majorName = data.get(1);
        //招生批次
        String b = data.get(2);
        String[] split = b.split(" ");
        //批次
        String batch = split[0];
        //文理科
        String majorType = split[1];
        //最高分
        String highScore = data.get(3);
        //最低分
        String lowScore = data.get(4);
        //平均分
        String avgScore = data.get(5);
        //录取数
        String enrollingnumber = data.get(6);
        //最低位次
        String lowestprecedence = data.get(7);

        boolean b1 = StringUtil.checkData(lowestprecedence);
        if (!b1){
            lowestprecedence = "-1";
        }

        ZgkUniversityMajorEnrolling zgkUniversityMajorEnrolling = new ZgkUniversityMajorEnrolling();
        zgkUniversityMajorEnrolling.setAreaid(zgkUniversity.getAreaid());//学校的区域编码
        zgkUniversityMajorEnrolling.setYear(year);
        zgkUniversityMajorEnrolling.setMajortype(majorType);
        zgkUniversityMajorEnrolling.setUniversityid(zgkUniversity.getId());//这里为库里的学校id,而不是优志愿的学校id
        zgkUniversityMajorEnrolling.setMajorname(majorName);
        zgkUniversityMajorEnrolling.setUniversityname(zgkUniversity.getName());
        zgkUniversityMajorEnrolling.setBatch(batch);
        zgkUniversityMajorEnrolling.setRealenrollingnumber(enrollingnumber);
        zgkUniversityMajorEnrolling.setHighestscore(highScore);
        zgkUniversityMajorEnrolling.setLowestscore(lowScore);
        zgkUniversityMajorEnrolling.setAveragescore(avgScore);
        zgkUniversityMajorEnrolling.setPlanenrollingnumber(0);
        zgkUniversityMajorEnrolling.setLowestprecedence(Integer.valueOf(lowestprecedence));
        zgkUniversityMajorEnrolling.setYzyuniversityid(uid);//优志愿的学校id
        zgkUniversityMajorEnrolling.setDataareaname(zone);

        return zgkUniversityMajorEnrolling;
    }



    /**
     * 构造院校录取对象
     * @return
     */
    private static boolean insertUniversityMajorEnrolling(List<ZgkUniversityMajorEnrolling> zgkUniversityEnrollings) {
        ZgkUniversityMajorEnrollingService zgkUniversityEnrollingService = (ZgkUniversityMajorEnrollingService) ac.getBean("zgkUniversityMajorEnrollingServiceImpl");

        if (CollectionUtils.isEmpty(zgkUniversityEnrollings)){
            return false;
        }
        Integer result = zgkUniversityEnrollingService.insertUniversityMajorEnrollingList(zgkUniversityEnrollings);

        //Integer result = zgkUniversityEnrollingService.insert(zgkUniversityEnrollings.get(0));
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
        Integer universityId = null;

        Gson gson = new GsonBuilder().enableComplexMapKeySerialization()
                .create();

        String startUrl = "http://www.youzy.cn/ScoreLines/AjaxServices/SuggestSearchColleges.ashx" + "?" + "wd=" + universityName + "&functionName=";

        HttpGet httpGet = new HttpGet(startUrl);
        String universionJson = null;
        // 获取当前客户端对象
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = null;
        HttpEntity entity =null;
        // 通过请求对象获取响应对象
        try {
            response = httpClient.execute(httpGet);
            entity = response.getEntity();
            universionJson = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            maps= gson.fromJson(universionJson,new TypeToken<List<Map<String,String>>>() {
            }.getType());
        }catch (Exception e){
            //无法解析的json
            errorJson.put(universityName+"-Exception",e.getMessage());
        }finally {
            //当maps为空的时候,意味着优志愿无此学校
            if (maps.isEmpty()){
                errorJson.put(universityName,universionJson);
                return ConstantKit.Spider.CANNOT_FIND_UID;
            }
            for(Map map:maps) {
                if (map.get("data").equals(universityName)) {
                    universityId = Integer.valueOf(map.get("id").toString());
                    break;
                }
            }
            //清空本次数据,供下次使用
            maps.clear();
        }

        return universityId;
    }

}