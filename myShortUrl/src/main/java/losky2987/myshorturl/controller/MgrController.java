package losky2987.myshorturl.controller;

import losky2987.myshorturl.db.mockList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MgrController {
    List<mockList> muby = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("username", "mockuser");

        muby.add(new mockList("Google", "google", "https://google.com", 0));
        muby.add(new mockList("Facebook", "facebook", "https://facebook.com", 0));
        muby.add(new mockList("Twitter", "twitter", "https://twitter.com", 0));
        muby.add(new mockList("Yahoo", "yahoo", "https://yahoo.com", 0));
        muby.add(new mockList("Huawei", "huawei", "https://customer.huawei.com", 0));
        muby.add(new mockList("Xiaomi", "xiaomi", "https://mi.com", 0));
        muby.add(new mockList("QQ", "qqim", "https://im.qq.com", 0));
        muby.add(new mockList("淘宝", "taobao", "https://taobao.com", 0));

        model.addAttribute("linksData", muby);

        model.addAttribute("numberOfLinks", muby.size());
        if(model.getAttribute("numberOfLinks") instanceof  Integer) {
            int numberOfLinks = (Integer)model.getAttribute("numberOfLinks");
            if(numberOfLinks == 1) {
                model.addAttribute("isMultipleLinks", "link");
            }else{
                model.addAttribute("isMultipleLinks", "links");
            }
        }
        return "mgr";
    }
}
