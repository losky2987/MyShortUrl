package losky2987.myshorturl.db;

import java.util.ArrayList;
import java.util.List;

public class dumyLCC {
    public static List<LinkConvertColumn> getDumyLCC(){
        List<LinkConvertColumn> dumyLCC = new ArrayList<LinkConvertColumn>();
        dumyLCC.add(new LinkConvertColumn("Google", "google", "https://google.com"));
        dumyLCC.add(new LinkConvertColumn("Facebook", "facebook", "https://facebook.com"));
        dumyLCC.add(new LinkConvertColumn("Twitter", "twitter", "https://twitter.com"));
        dumyLCC.add(new LinkConvertColumn("Yahoo", "yahoo", "https://yahoo.com"));
        dumyLCC.add(new LinkConvertColumn("Huawei", "huawei", "https://customer.huawei.com"));
        dumyLCC.add(new LinkConvertColumn("Xiaomi", "xiaomi", "https://mi.com"));
        dumyLCC.add(new LinkConvertColumn("QQ", "qqim", "https://im.qq.com"));
        dumyLCC.add(new LinkConvertColumn("淘宝", "taobao", "https://taobao.com"));
        return dumyLCC;
    }
}
