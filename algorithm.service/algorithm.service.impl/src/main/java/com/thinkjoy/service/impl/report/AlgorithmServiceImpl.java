package com.thinkjoy.service.impl.report;

import com.thinkjoy.common.CalculationHelp;
import com.thinkjoy.common.EnumHelp;
import com.thinkjoy.report.dao.ZgkUniversityAvgStdMapper;
import com.thinkjoy.report.dao.ZgkUniversityEnrollingAlgorithmMapper;
import com.thinkjoy.report.entity.ZgkUniversityAvgStd;
import com.thinkjoy.report.entity.ZgkUniversityEnrollingAlgorithm;
import com.thinkjoy.report.view.AreaView;
import com.thinkjoy.report.view.ReportAlgorithmRank;
import com.thinkjoy.report.view.StdView;
import com.thinkjoy.report.view.UpdateRankView;
import com.thinkjoy.service.api.report.AlgorithmService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by douzy on 17/2/7.
 */
@Service
public class AlgorithmServiceImpl implements AlgorithmService {
    @Resource
    ZgkUniversityEnrollingAlgorithmMapper zgkUniversityEnrollingAlgorithmMapper;
    @Resource
    ZgkUniversityAvgStdMapper zgkUniversityAvgStdMapper;

    @Override
    public ZgkUniversityEnrollingAlgorithm selectModel(Map map){
         return zgkUniversityEnrollingAlgorithmMapper.selectModel(map);
    }

    /**
     * 计算标准排名
     *
     * @return
     */
    @Override
    public boolean algorithmStandardRank() {
        System.out.println(".....................计算最高分排名 Start.....................");
        Object[] areaArr = CalculationHelp.converListArr(this.getEnrollingArea()),
//                batchArr = CalculationHelp.converListArr(this.getEnrollBatch()),
                yearArr = CalculationHelp.converListArr(this.getEnrollYear()),
                majorTypeArr = CalculationHelp.converListArr(this.getMajorType());

        print(areaArr,"省份参数");
//        print(batchArr,"批次参数");
        print(yearArr,"年份参数");
        print(majorTypeArr,"文理参数");

        Object[][] strArr = {areaArr, yearArr, majorTypeArr};
//
        List<String> strs = CalculationHelp.getList(strArr);
        System.out.println(".....................参数集合组合["+strs.size()+"].....................");
        for (String s : strs) {
            String[] searchWhere = s.split("\\|");
            String area = searchWhere[0],
//                    batch = searchWhere[1],
                    year = searchWhere[1],
                    major = searchWhere[2];
            System.out.println("省份:"+area);
//            System.out.println("批次:"+batch);
            System.out.println("年份:"+year);
            System.out.println("文理:"+major);
            Map map = new HashMap();
            map.put("enrollArea", area);
            map.put("enrollYear", year);
//            map.put("enrollBatch", batch);
            map.put("majorType", major);
            map.put("order","high_score desc");

            List<ZgkUniversityEnrollingAlgorithm> zgkUniversityEnrollingAlgorithms = zgkUniversityEnrollingAlgorithmMapper.selectList(map);
            System.out.println(".....................当前组合共["+zgkUniversityEnrollingAlgorithms.size()+"]条数据");
            enrollingAlgorithmsRank(zgkUniversityEnrollingAlgorithms);
        }
        System.out.println(".....................计算最高分排名 End.....................");
        return true;
    }
    private void print(Object[] areaArr,String desc) {
        System.out.println("....................." + desc + " Start");
        for (Object object : areaArr) {
            System.out.println(object.toString());
        }
        System.out.println("....................." + desc + " End");
    }
    /**
     * 设置排名.
     * @param EnrollingAlgorithms
     * @return
     */
    private  boolean enrollingAlgorithmsRank(List<ZgkUniversityEnrollingAlgorithm> EnrollingAlgorithms) {
        System.out.println(".....................[最高分]进行排名操作 Start.....................");
        if (EnrollingAlgorithms == null || EnrollingAlgorithms.size() <= 0)
            return false;

        String prevScore = null;

        List<UpdateRankView> updateRankViews=new ArrayList<>();

        for (int i = 0; i < EnrollingAlgorithms.size(); i++) {

            ZgkUniversityEnrollingAlgorithm zgkUniversityEnrollingAlgorithm = EnrollingAlgorithms.get(i);

            if (StringUtils.isBlank(zgkUniversityEnrollingAlgorithm.getHighScore()))
                continue;

            UpdateRankView updateRankView=new UpdateRankView();
            updateRankView.setKey("high_rank");

            Integer rank = i == 0 ? (i + 1) : EnrollingAlgorithms.get(i - 1).getHighRank() + 1;

            if (zgkUniversityEnrollingAlgorithm.getHighScore().equals(prevScore))
                rank = rank - 1;

            zgkUniversityEnrollingAlgorithm.setHighRank(rank);
            System.out.println("当前分数["+prevScore+"]排名为:"+rank);
            updateRankView.setValue(rank+"");

            updateRankView.setId(zgkUniversityEnrollingAlgorithm.getId());

            prevScore = zgkUniversityEnrollingAlgorithm.getHighScore();

            updateRankViews.add(updateRankView);
        }
        boolean flag=updateRank(updateRankViews);
        System.out.println("排名更新DB结果:"+flag);
        System.out.println(".....................[最高分]进行排名操作 End.....................");
        return flag;
    }


    /**
     * =============LowScore
     * @return
     */
    @Override
    public boolean algorithmStandardLowScoreRank() {
        System.out.println(".....................计算最低分排名 Start.....................");
        Object[] areaArr = CalculationHelp.converListArr(this.getEnrollingArea()),
//                batchArr = CalculationHelp.converListArr(this.getEnrollBatch()),
                yearArr = CalculationHelp.converListArr(this.getEnrollYear()),
                majorTypeArr = CalculationHelp.converListArr(this.getMajorType());

        Object[][] strArr = {areaArr, yearArr, majorTypeArr};

        print(areaArr,"省份参数");
        print(yearArr,"年份参数");
        print(majorTypeArr,"文理参数");

        List<String> strs = CalculationHelp.getList(strArr);
        System.out.println(".....................参数集合组合["+strs.size()+"].....................");
        for (String s : strs) {
            String[] searchWhere = s.split("\\|");
            String area = searchWhere[0],
                    year = searchWhere[1],
                    major = searchWhere[2];
            System.out.println("省份:"+area);
//            System.out.println("批次:"+batch);
            System.out.println("年份:"+year);
            System.out.println("文理:"+major);
            Map map = new HashMap();
            map.put("enrollArea", area);
            map.put("enrollYear", year);
            map.put("majorType", major);
            map.put("order","low_score desc");

            List<ZgkUniversityEnrollingAlgorithm> zgkUniversityEnrollingAlgorithms = zgkUniversityEnrollingAlgorithmMapper.selectList(map);

            enrollingAlgorithmsLowRank(zgkUniversityEnrollingAlgorithms);
        }
        System.out.println(".....................计算最低分排名 End.....................");
        return true;
    }
    /**
     * 设置排名.
     * @param EnrollingAlgorithms
     * @return
     */
    private  boolean enrollingAlgorithmsLowRank(List<ZgkUniversityEnrollingAlgorithm> EnrollingAlgorithms) {
        System.out.println(".....................[最低分]进行排名操作 Start.....................");
        if (EnrollingAlgorithms == null || EnrollingAlgorithms.size() <= 0)
            return false;

        String prevScore = null;

        List<UpdateRankView> updateRankViews=new ArrayList<>();

        for (int i = 0; i < EnrollingAlgorithms.size(); i++) {

            ZgkUniversityEnrollingAlgorithm zgkUniversityEnrollingAlgorithm = EnrollingAlgorithms.get(i);

            if (StringUtils.isBlank(zgkUniversityEnrollingAlgorithm.getLowScore()))
                continue;

            UpdateRankView updateRankView=new UpdateRankView();
            updateRankView.setKey("low_rank");

            Integer rank = i == 0 ? (i + 1) : EnrollingAlgorithms.get(i - 1).getLowRank() + 1;

            if (zgkUniversityEnrollingAlgorithm.getLowScore().equals(prevScore))
                rank = rank - 1;

            updateRankView.setValue(rank+"");

            System.out.println("当前分数["+prevScore+"]排名为:"+rank);

            zgkUniversityEnrollingAlgorithm.setLowRank(rank);

            updateRankView.setId(zgkUniversityEnrollingAlgorithm.getId());

            prevScore = zgkUniversityEnrollingAlgorithm.getLowScore();

            updateRankViews.add(updateRankView);
        }
        boolean flag=updateRank(updateRankViews);
        System.out.println("排名更新DB结果:"+flag);
        System.out.println(".....................[最低分]进行排名操作 End.....................");
        return flag;
    }
    /**
     * =============AvgScore
     * @return
     */
    @Override
    public boolean algorithmStandardAvgScoreRank() {
        System.out.println(".....................计算平均分排名 Start.....................");
        Object[] areaArr = CalculationHelp.converListArr(this.getEnrollingArea()),
//                batchArr = CalculationHelp.converListArr(this.getEnrollBatch()),
                yearArr = CalculationHelp.converListArr(this.getEnrollYear()),
                majorTypeArr = CalculationHelp.converListArr(this.getMajorType());

        Object[][] strArr = {areaArr, yearArr, majorTypeArr};
        print(areaArr,"省份参数");
        print(yearArr,"年份参数");
        print(majorTypeArr,"文理参数");
        List<String> strs = CalculationHelp.getList(strArr);
        System.out.println(".....................参数集合组合["+strs.size()+"].....................");
        for (String s : strs) {
            String[] searchWhere = s.split("\\|");
            String area = searchWhere[0],
//                    batch = searchWhere[1],
                    year = searchWhere[1],
                    major = searchWhere[2];
            System.out.println("省份:"+area);
//            System.out.println("批次:"+batch);
            System.out.println("年份:"+year);
            System.out.println("文理:"+major);
            Map map = new HashMap();
            map.put("enrollArea", area);
            map.put("enrollYear", year);
//            map.put("enrollBatch", batch);
            map.put("majorType", major);
            map.put("order","avg_score desc");

            List<ZgkUniversityEnrollingAlgorithm> zgkUniversityEnrollingAlgorithms = zgkUniversityEnrollingAlgorithmMapper.selectList(map);

            enrollingAlgorithmsAvgRank(zgkUniversityEnrollingAlgorithms);
        }
        System.out.println(".....................计算平均分排名 End.....................");
        return true;
    }
    /**
     * 设置排名.
     * @param EnrollingAlgorithms
     * @return
     */
    private  boolean enrollingAlgorithmsAvgRank(List<ZgkUniversityEnrollingAlgorithm> EnrollingAlgorithms) {
        System.out.println(".....................[平均分]进行排名操作 Start.....................");
        if (EnrollingAlgorithms == null || EnrollingAlgorithms.size() <= 0)
            return false;

        String prevScore = null;

        List<UpdateRankView> updateRankViews = new ArrayList<>();

        for (int i = 0; i < EnrollingAlgorithms.size(); i++) {

            ZgkUniversityEnrollingAlgorithm zgkUniversityEnrollingAlgorithm = EnrollingAlgorithms.get(i);

            if (StringUtils.isBlank(zgkUniversityEnrollingAlgorithm.getAvgScore()))
                continue;

            UpdateRankView updateRankView = new UpdateRankView();
            updateRankView.setKey("avg_rank");

            Integer rank = i == 0 ? (i + 1) : EnrollingAlgorithms.get(i - 1).getAvgRank() + 1;

            if (zgkUniversityEnrollingAlgorithm.getAvgScore().equals(prevScore))
                rank = rank - 1;

            System.out.println("当前分数["+prevScore+"]排名为:"+rank);

            zgkUniversityEnrollingAlgorithm.setAvgRank(rank);

            updateRankView.setValue(rank + "");

            updateRankView.setId(zgkUniversityEnrollingAlgorithm.getId());

            prevScore = zgkUniversityEnrollingAlgorithm.getAvgScore();

            updateRankViews.add(updateRankView);
        }
        boolean flag = updateRank(updateRankViews);
        System.out.print("排名更新DB结果:"+flag);
        System.out.print(".....................[平均分]进行排名操作 End.....................");
        return flag;
    }


    /**
     * 获取
     * @return
     */
    @Override
    public boolean algorithmStandardRankByScoreRank() {
        System.out.println(".....................计算最高分标准排名 Start.....................");
        boolean flag=false;

        Object[] areaArr = CalculationHelp.converListArr(this.getEnrollingArea()),
                yearArr = CalculationHelp.converListArr(this.getEnrollYear()),
                majorTypeArr = CalculationHelp.converListArr(this.getMajorType());

        Object[][] strArr = {areaArr, yearArr, majorTypeArr};

        print(areaArr,"省份参数");
        print(yearArr,"年份参数");
        print(majorTypeArr,"文理参数");

        List<String> strs = CalculationHelp.getList(strArr);

        System.out.println(".....................参数集合组合["+strs.size()+"].....................");

        double pow = Math.pow(10, 6);


        for (String s : strs) {
            String[] searchWhere = s.split("\\|");
            String area = searchWhere[0],
//                    batch = searchWhere[1],
                    year = searchWhere[1],
                    major = searchWhere[2];
            System.out.println("省份:" + area);
//            System.out.println("批次:"+batch);
            System.out.println("年份:" + year);
            System.out.println("文理:" + major);
            Map map = new HashMap();
            map.put("enrollArea", area);
            map.put("enrollYear", year);
            map.put("majorType", major);



            Integer realEnrollingSum = zgkUniversityEnrollingAlgorithmMapper.selectRealEnrollSum(map);

            if (realEnrollingSum == null || realEnrollingSum < 0)
                continue;

            List<ZgkUniversityEnrollingAlgorithm> zgkUniversityEnrollingAlgorithms = zgkUniversityEnrollingAlgorithmMapper.selectList(map);

            List<ZgkUniversityEnrollingAlgorithm> algorithms = new ArrayList<>();
            for (int i = 0; i < zgkUniversityEnrollingAlgorithms.size(); i++) {

                ZgkUniversityEnrollingAlgorithm zgkUniversityEnrollingAlgorithm = zgkUniversityEnrollingAlgorithms.get(i);

                if (zgkUniversityEnrollingAlgorithm == null)
                    continue;

                if (zgkUniversityEnrollingAlgorithm.getHighRank() == null ||
                        zgkUniversityEnrollingAlgorithm.getLowRank() == null ||
                        zgkUniversityEnrollingAlgorithm.getAvgRank() == null)
                    continue;

                Float highRank = Float.valueOf(zgkUniversityEnrollingAlgorithm.getHighRank()),
                        lowRank = Float.valueOf(zgkUniversityEnrollingAlgorithm.getLowRank()),
                        avgRank = Float.valueOf(zgkUniversityEnrollingAlgorithm.getAvgRank());


                Double stdHighRank = highRank / Float.valueOf(realEnrollingSum) * pow;
                Double stdLowRank = lowRank / Float.valueOf(realEnrollingSum) * pow;
                Double stdAvgRank = avgRank / Float.valueOf(realEnrollingSum) * pow;

                System.out.println("最高分标准化排名:" + stdHighRank);
                System.out.println("最低分标准化排名:" + stdLowRank);
                System.out.println("平均分标准化排名:" + stdAvgRank);

                zgkUniversityEnrollingAlgorithm.setStdHighRank(stdHighRank.intValue());
                zgkUniversityEnrollingAlgorithm.setStdLowRank(stdLowRank.intValue());
                zgkUniversityEnrollingAlgorithm.setStdAvgRank(stdAvgRank.intValue());
                algorithms.add(zgkUniversityEnrollingAlgorithm);
            }
            if (algorithms == null||algorithms.size()<=0)
                continue;

            Integer res = zgkUniversityEnrollingAlgorithmMapper.updateStdRank(algorithms);
            flag = res > 0;
        }
        System.out.print("排名更新DB结果:"+flag);
        System.out.println(".....................计算最高分标准排名 Start.....................");
        return flag;

    }

    public List<String> getTeacherList() {
        String[] arr = {"2294", "2295", "2296", "2297", "2298", "2299", "2300", "2301", "2302", "2303", "2304", "2305", "2306", "2307", "2308", "2309", "2310", "2311", "2313", "2314", "2315", "2316", "2317", "2318", "2319", "2320", "2321", "2322", "2323", "2324", "2325", "2326", "2327", "2328", "2329", "2331", "2332", "2333", "2334", "2337", "2338", "2339", "2341", "2342", "2343", "2344", "2345", "2346", "2347", "2348", "2349", "2350", "2351", "2352", "2353", "2354", "2355", "2356", "2357", "2358", "2359", "2360", "2361", "2362", "2363", "2364", "2365", "2368", "2369", "2370", "2371", "2372", "2373", "2374", "2375", "2376", "2377", "2378", "2379", "2380", "2381", "2382", "2383", "2384", "2385", "2386", "2387", "2388", "2389", "2390", "2391", "2392", "2393", "2394", "2395", "2396", "2397", "2398", "2399", "2400", "2401", "2402", "2403", "2404", "2405", "2406", "2407", "2408", "2409", "2410", "2411", "2412", "2413", "2414", "2415", "2416", "2417", "2418", "2419", "2420", "2421", "2422", "2423", "2424", "2425", "2426", "2427", "2428", "2429", "2430", "2431", "2432", "2433", "2434", "2435", "2436", "2437", "2438", "2439", "2440", "2441", "2442", "2443", "2444", "2445", "2446", "2447", "2448", "2449", "2451", "2452", "2453", "2454", "2455", "2456", "2457", "2458", "2459", "2460", "2461", "2462", "2463", "2464", "2465", "2466", "2467", "2468", "2469", "2470", "2471", "2472", "2473", "2474", "2475", "2476", "2477", "2480", "2481", "2482", "2483", "2484", "2485", "2486", "2487", "2488", "2489", "2490", "2491", "2492", "2493", "2494", "2495", "2496", "2497", "2498", "2499", "2500", "2501", "2502", "2503", "2504", "2505", "2506", "2507", "2508", "2509", "2510", "2511", "2512", "2513", "2514", "2515", "2516", "2517", "2518", "2519", "2520", "2521", "2522", "2523", "2524", "2525", "2526", "2527", "2528", "2529", "2530", "2531", "2532", "2533", "2534", "2535", "2536", "2537", "2538", "2539", "2540", "2541", "2542", "2543", "2544", "2545", "2546", "2548", "2549", "2550", "2551", "2552", "2553", "2554", "2555", "2557", "2558", "2559", "2560", "2561", "2562", "2563", "2564", "2565", "2566", "2567", "2568", "2569", "2571", "2572", "2573", "2574", "2575", "2576", "2577", "2578", "2579", "2580", "2581", "2582", "2583", "2584", "2585", "2586", "2587", "2588", "2589", "2590", "2591", "2597", "2599", "2600", "2601", "2602", "2605", "2607", "2609", "2612", "2614", "2617", "2618", "2619", "2620", "2621", "2622", "2624", "2625", "2626", "2627", "2628", "2629", "2630", "2631", "2632", "2633", "2634", "2635", "2636", "2637", "2638", "2640", "2641", "2642", "2643", "2644", "2645", "2647", "2648", "2649", "2650", "2651", "2652", "2653", "2654", "2655", "2656", "2657", "2658", "2659", "2660", "2661", "2662", "2664", "2665", "2666", "2667", "2668", "2716"};

        return Arrays.asList(arr);
    }
    private Map getAlgorithmValueByUid(Integer uid){
        Map resutMap=new HashMap();
        Map map=new HashMap();
        map.put("universityId",uid);
        List<AreaView> areaViews=zgkUniversityEnrollingAlgorithmMapper.selectEnrollYearCountByUid(map);

        for(AreaView areaView:areaViews){
            resutMap.put(areaView.getArea(),areaView.getCount());
        }
        return resutMap;
    }

    private Map getStdValueByUid(Integer uid){
        Map resutMap=new HashMap();
        Map map=new HashMap();
        map.put("universityId",uid);
        List<StdView> areaViews=zgkUniversityEnrollingAlgorithmMapper.selectHistorySumRankByUid(map);

        for(StdView stdView:areaViews){
            ReportAlgorithmRank reportAlgorithmRank=new ReportAlgorithmRank();
            reportAlgorithmRank.setSumHigh(stdView.getSumHigh());
            reportAlgorithmRank.setSumLow(stdView.getSumLow());
            reportAlgorithmRank.setSumAvgR(stdView.getSumAvgR());
            reportAlgorithmRank.setStdHigh(stdView.getStdHigh());
            reportAlgorithmRank.setStdLow(stdView.getStdLow());
            reportAlgorithmRank.setStdAvgR(stdView.getStdAvgR());
            resutMap.put(stdView.getSearchKey(),reportAlgorithmRank);
        }
        return resutMap;
    }
    /**
     * 计算均值与标准差
     * @return
     */
    @Override
    public boolean algotithmAvgAndDiff() {
        System.out.println(".....................计算均值与标准差 Start.....................");
        boolean flag = false;

//        List<String> universityIds = zgkUniversityEnrollingAlgorithmMapper.selectUniversityIdGroup();
        List<String> universityIds =getTeacherList();
        if (universityIds == null || universityIds.size() <= 0)
            return flag;

        for (String str : universityIds) {
            Integer uid = Integer.valueOf(str);
            if (uid <= 0)
                continue;
            System.out.println("院校ID:" + uid);

            Object[] areaArr = CalculationHelp.converListArr(this.getEnrollingArea()),
                    majorTypeArr = CalculationHelp.converListArr(this.getMajorType());
            Object[][] strArr = {areaArr, majorTypeArr};
            print(areaArr, "省份参数");
            print(majorTypeArr, "文理参数");
            List<String> strs = CalculationHelp.getList(strArr);
            System.out.println(".....................参数集合组合[" + strs.size() + "].....................");
            Map map = new HashMap();
            map.put("universityId", uid);

            Map areaMap=getAlgorithmValueByUid(uid);

            Map stdMap=getStdValueByUid(uid);
            List<ZgkUniversityAvgStd> zgkUniversityAvgStds = new ArrayList<>();
            for (String s : strs) {
                String[] searchWhere = s.split("\\|");
                String area = searchWhere[0],
                        major = searchWhere[1];

                System.out.println("省份:" + area);
                System.out.println("文理:" + major);

                map.put("enrollArea", area);
                map.put("majorType", major);

//                Integer yearCount = zgkUniversityEnrollingAlgorithmMapper.selectEnrollYearCount(map);
                String searchKey=area+"-"+major;
                Integer s1=0;
                if(area.equals("230000"))
                            s1=1;

                if(!areaMap.containsKey(searchKey))
                    continue;

                Integer yearCount= Integer.valueOf(areaMap.get(searchKey).toString());

                if (yearCount <= 0) continue;

//                ReportAlgorithmRank reportAlgorithmSumRank = zgkUniversityEnrollingAlgorithmMapper.selectHistorySumRank(map);
                ReportAlgorithmRank reportAlgorithmSumRank=(ReportAlgorithmRank)stdMap.get(searchKey);

//                boolean sumHighF=
//
//                if (reportAlgorithmSumRank.getSumHigh() == null||reportAlgorithmSumRank.getSumLow()
//                        ||reportAlgorithmSumRank.getSumAvgR()||reportAlgorithmSumRank.getStdHigh()) continue;

                ZgkUniversityAvgStd zgkUniversityAvgStd = new ZgkUniversityAvgStd();
                zgkUniversityAvgStd.setUniversityId(uid);
                zgkUniversityAvgStd.setEnrollArea(Integer.valueOf(area));
                zgkUniversityAvgStd.setMajorType(Integer.valueOf(major));
                zgkUniversityAvgStd.setYearCount(yearCount);
                zgkUniversityAvgStd.setAvgHighValue(reportAlgorithmSumRank.getSumHigh() / yearCount);
                zgkUniversityAvgStd.setAvgLowValue(reportAlgorithmSumRank.getSumLow() / yearCount);
                zgkUniversityAvgStd.setAvgAvgValue(reportAlgorithmSumRank.getSumAvgR() / yearCount);
                zgkUniversityAvgStd.setStdHighDiff(reportAlgorithmSumRank.getStdHigh());
                zgkUniversityAvgStd.setStdLowDiff(reportAlgorithmSumRank.getStdLow());
                zgkUniversityAvgStd.setStdAvgDiff(reportAlgorithmSumRank.getStdAvgR());
                zgkUniversityAvgStds.add(zgkUniversityAvgStd);
            }
            if(zgkUniversityAvgStds==null||zgkUniversityAvgStds.size()<=0)
                continue;
            Integer re = zgkUniversityAvgStdMapper.addStds(zgkUniversityAvgStds);
            flag = re > 0;

            System.out.println("result:" + flag);
            if (!flag) return false;
        }
        System.out.println(".....................计算均值与标准差 Start.....................");

        return flag;
    }


    /**
     * 更新排名情况
     * @param updateRankViews
     */
    public boolean updateRank(List<UpdateRankView> updateRankViews) {
        if (updateRankViews == null || updateRankViews.size() <= 0)
            return false;
        return zgkUniversityEnrollingAlgorithmMapper.updateRank(updateRankViews) > 0;
    }

    /**
     * 获取历年年份集
     *
     * @return
     */
    @Override
    public List<String> getEnrollYear() {
        return zgkUniversityEnrollingAlgorithmMapper.selectGroupEnrollingYear();
    }

    /**
     * 获取分组区域信息
     *
     * @return
     */
    @Override
    public List<String> getEnrollingArea() {
        return zgkUniversityEnrollingAlgorithmMapper.selectGroupEnrollingArea();
    }

    /**
     *  更新排名
     * @param model
     * @return
     */
    @Override
    public boolean updateAlgorithmRank(ZgkUniversityEnrollingAlgorithm model) {
        return zgkUniversityEnrollingAlgorithmMapper.updateByPrimaryKeySelective(model) > 0;
    }
    /**
     * 获取分组批次信息
     *
     * @return
     */
    @Override
    public List<String> getEnrollBatch() {
        return EnumHelp.getBatch();
    }

    /**
     * 获取分组文理科信息
     *
     * @return
     */
    @Override
    public List<String> getMajorType() {
        return EnumHelp.getMajorType();
    }



}
