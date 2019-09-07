package com.neverend.blog.contoller.color;

import com.google.gson.Gson;
import com.neverend.blog.moudel.Code;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.util.email.FenCIUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@ApiIgnore
@Controller
public class color {


    @RequestMapping("/bl/map2/tuxig/msg1")
    @ResponseBody
    public Msg bolckmap2txmsg(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "jw", required = false) String jw) {
        Msg msg = new Msg();


        String str = jw.replaceAll("[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]", "");
        int length = str.length();
        int jige = length / 2;
        if (jige >= 6) {
            String[] strings = new String[6];
            strings[0] = "横轴11";
            strings[1] = "横轴12";
            strings[2] = "横轴13";
            strings[3] = "横轴14";
            strings[4] = "横轴15";
            strings[5] = "横轴16";
            int[] strings1 = new int[6];
            strings1[0] = Integer.valueOf(str.substring(0, 2))+1;
            strings1[1] = Integer.valueOf(str.substring(2, 4))+1;
            strings1[2] = Integer.parseInt(str.substring(4, 6)+1);
            strings1[3] = Integer.parseInt(str.substring(6, 8)+1);
            strings1[4] = Integer.parseInt(str.substring(8, 10)+1);
            strings1[5] = Integer.parseInt(str.substring(10, 12)+1);
            testmap testmap = new testmap();
            testmap.setStrings(strings);
            testmap.setStrings1(strings1);
            msg.setData(testmap);
            msg.setMsg(name+"图形一");
            msg.setCode(Code.sucess);
            return msg;
        } else {
            msg.setCode(Code.error);
            return msg;
        }
    }

    @RequestMapping("/bl/map2/tuxig/msg2")
    @ResponseBody
    public Msg bolckmap2txmsg2(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "jw", required = false) String jw) {
        Msg msg = new Msg();


        String str = jw.replaceAll("[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]", "");
        int length = str.length();
        int jige = length / 2;
        if (jige >= 6) {
            String[] strings = new String[6];
            strings[0] = "横轴21";
            strings[1] = "横轴22";
            strings[2] = "横轴23";
            strings[3] = "横轴24";
            strings[4] = "横轴25";
            strings[5] = "横轴26";
            int[] strings1 = new int[6];
            strings1[0] = Integer.parseInt(str.substring(0, 2)+2);
            strings1[1] = Integer.parseInt(str.substring(2, 4)+2);
            strings1[2] = Integer.parseInt(str.substring(4, 6)+2);
            strings1[3] = Integer.parseInt(str.substring(6, 8)+2);
            strings1[4] = Integer.parseInt(str.substring(8, 10)+2);
            strings1[5] = Integer.parseInt(str.substring(10, 12)+2);
            testmap testmap = new testmap();
            testmap.setStrings(strings);
            testmap.setStrings1(strings1);
            msg.setMsg(name+"图形二");
            msg.setData(testmap);
            msg.setCode(Code.sucess);
            return msg;
        } else {
            msg.setCode(Code.error);
            return msg;
        }
    }
    @RequestMapping("/bl/map2/tuxig/msg3")
    @ResponseBody
    public Msg bolckmap2txmsg3(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "jw", required = false) String jw) {
        Msg msg = new Msg();


        String str = jw.replaceAll("[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]", "");
        int length = str.length();
        int jige = length / 2;
        if (jige >= 6) {
            String[] strings = new String[6];
            strings[0] = "横轴31";
            strings[1] = "横轴32";
            strings[2] = "横轴33";
            strings[3] = "横轴34";
            strings[4] = "横轴35";
            strings[5] = "横轴36";
            int[] strings1 = new int[6];
            strings1[0] = Integer.parseInt(str.substring(0, 2)+3);
            strings1[1] = Integer.parseInt(str.substring(2, 4)+3);
            strings1[2] = Integer.parseInt(str.substring(4, 6)+3);
            strings1[3] = Integer.parseInt(str.substring(6, 8)+3);
            strings1[4] = Integer.parseInt(str.substring(8, 10)+3);
            strings1[5] = Integer.parseInt(str.substring(10, 12)+3);
            testmap testmap = new testmap();
            testmap.setStrings(strings);
            testmap.setStrings1(strings1);
            msg.setData(testmap);
            msg.setMsg(name+"图形三");
            msg.setCode(Code.sucess);
            return msg;
        } else {
            msg.setCode(Code.error);
            return msg;
        }
    }

    @RequestMapping("/bl/map2/tuxig/msg4")
    @ResponseBody
    public Msg bolckmap2txmsg4(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "jw", required = false) String jw) {
        Msg msg = new Msg();


        String str = jw.replaceAll("[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]", "");
        int length = str.length();
        int jige = length / 2;
        if (jige >= 6) {
            String[] strings = new String[6];
            strings[0] = "横轴41";
            strings[1] = "横轴42";
            strings[2] = "横轴43";
            strings[3] = "横轴44";
            strings[4] = "横轴45";
            strings[5] = "横轴46";
            int[] strings1 = new int[6];
            strings1[0] = Integer.parseInt(str.substring(0, 2)+4);
            strings1[1] = Integer.parseInt(str.substring(2, 4)+4);
            strings1[2] = Integer.parseInt(str.substring(4, 6)+4);
            strings1[3] = Integer.parseInt(str.substring(6, 8)+4);
            strings1[4] = Integer.parseInt(str.substring(8, 10)+4);
            strings1[5] = Integer.parseInt(str.substring(10, 12)+4);
            testmap testmap = new testmap();
            testmap.setStrings(strings);
            testmap.setStrings1(strings1);
            msg.setMsg(name+"图形四");
            msg.setData(testmap);
            msg.setCode(Code.sucess);
            return msg;
        } else {
            msg.setCode(Code.error);
            return msg;
        }
    }
    @RequestMapping("/bl/map2")
    public String bolckmap2() {
        return "admin/map/map2";
    }

    @RequestMapping("/bl/map")
    public String bolckmap() {
        return "admin/map/map";
    }

    @RequestMapping("/bl")
    public String bolck() {
        return "admin/color/bol/index";
    }


    @RequestMapping("/admin")
    public String zblogin() {
        return "admin/color/login";
    }

    @RequestMapping("/map/demo")
    public String map() {
        return "admin/color/bol/map";
    }

    @RequestMapping("/test/table/demo1")
    @ResponseBody
    public String bolckjson(@RequestParam(required = false, defaultValue = "1", name = "page") String page,
                            @RequestParam(required = false, defaultValue = "2", name = "limit") String limit) {
        User user1 = new User("1", "23", "34", "4", "45", "45", "45", "45", "er", new Date());
        User user2 = new User("2", "23", "34", "459", "45", "45", "45", "45", "er", new Date());
        User user3 = new User("3", "23", "34", "345", "45", "45", "45", "45", "er", new Date());
        User user4 = new User("4", "23", "34", "45", "45", "45", "45", "45", "er", new Date());
        User user5 = new User("5", "23", "34", "55", "45", "45", "45", "45", "er", new Date());
        User user6 = new User("6", "23", "34", "15", "45", "45", "45", "45", "er", new Date());
        User user7 = new User("7", "23", "34", "40", "45", "45", "45", "45", "er", new Date());
        User user8 = new User("8", "23", "34", "49", "45", "45", "45", "45", "er", new Date());
        User user9 = new User("9", "23", "34", "40", "45", "45", "45", "45", "er", new Date());
        User user10 = new User("10", "23", "34", "49", "45", "45", "45", "45", "er", new Date());
        User user11 = new User("11", "23", "34", "40", "45", "45", "45", "45", "er", new Date());
        User user12 = new User("12", "23", "34", "49", "45", "45", "45", "45", "er", new Date());
        User user13 = new User("13", "23", "34", "40", "45", "45", "45", "45", "er", new Date());
        User user14 = new User("14", "23", "34", "49", "45", "45", "45", "45", "er", new Date());
        List<User> users = new ArrayList<>();
        if (limit.equals("10")) {
            if (page.equals("1")) {
                users.add(user1);
                users.add(user2);
                users.add(user3);
                users.add(user4);
                users.add(user5);
                users.add(user6);
                users.add(user7);
                users.add(user8);
                users.add(user9);
                users.add(user10);
            } else if (page.equals("2")) {
                users.add(user11);
                users.add(user12);
                users.add(user13);
                users.add(user14);
            } else {

            }
        } else {
            if (page.equals("1")) {
                users.add(user1);
                users.add(user2);
                users.add(user3);
                users.add(user4);
                users.add(user5);
                users.add(user6);
                users.add(user7);
                users.add(user8);
                users.add(user9);
                users.add(user10);
                users.add(user11);
                users.add(user12);
                users.add(user13);
                users.add(user14);
            } else {
            }
        }


        test test = new test(0, "", 14, users);
        Gson gson = new Gson();
        return gson.toJson(test);

    }

    @RequestMapping("/gree")
    public String gree() {
        return "admin/color/gr/index";
    }

    @RequestMapping("/gree/cyan")
    public String greecyan() {
        return "admin/color/grcyan/index";
    }

    @RequestMapping("/cyan")
    public String cgray() {
        return "admin/color/cyan/index";
    }

    @RequestMapping("/blue")
    public String blue() {
        return "admin/color/blue/index";
    }

    @RequestMapping("/blue/left")
    public String blueleft() {
        return "admin/color/blueleft/index";
    }


    class testmap {
        String[] strings;
        int[] strings1;

        public String[] getStrings() {
            return strings;
        }

        public void setStrings(String[] strings) {
            this.strings = strings;
        }

        public int[] getStrings1() {
            return strings1;
        }

        public void setStrings1(int[] strings1) {
            this.strings1 = strings1;
        }

        @Override
        public String toString() {
            return "testmap{" +
                    "strings=" + Arrays.toString(strings) +
                    ", strings1=" + Arrays.toString(strings1) +
                    '}';
        }
    }
}
