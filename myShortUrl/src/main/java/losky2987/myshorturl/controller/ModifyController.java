package losky2987.myshorturl.controller;

import losky2987.myshorturl.db.LinkConvertColumn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static losky2987.myshorturl.db.dumyLCC.getDumyLCC;

import java.util.List;
import java.util.Map;

@Controller
public class ModifyController {
    private List<LinkConvertColumn> dumy = getDumyLCC();

    @GetMapping("/modify/{sn}")
    public String modify(@PathVariable String sn, Model model) {
        model.addAttribute("version", "0.0.0.3 Alpha");
        model.addAttribute("sn", sn);

        for(LinkConvertColumn linkConvertColumn : dumy) {
            if(linkConvertColumn.findShortName(sn)){
                Map<String, String> map = linkConvertColumn.getOtherFromShortName(sn);
                model.addAttribute("oldRemark", map.get("remark"));
                model.addAttribute("oldShortName", map.get("shortName"));
                model.addAttribute("oldOriginalLink", map.get("originalLink"));
                break;
            }
        }
        model.addAttribute("result", false);
        model.addAttribute("resultMsg", "");
        return "modify";
    }

    @PostMapping("/modify/{sn}/submitt")
    public String submit(@PathVariable String sn, Model model,
                         @RequestParam("newR") String newRemark,
                         @RequestParam("newSN") String newShortName,
                         @RequestParam("newOL") String newOriginalLink) {
        model.addAttribute("version", "0.0.0.3 Alpha");
        model.addAttribute("sn", sn);
        boolean opreatorResult = false;
        LinkConvertColumn newLCC = new LinkConvertColumn(newRemark, newShortName, newOriginalLink);
        dumy.add(newLCC);
        for(LinkConvertColumn linkConvertColumn : dumy) {
            if(linkConvertColumn.findShortName(sn)){
                dumy.remove(linkConvertColumn);
                opreatorResult = true;
                break;
            }
        }
        model.addAttribute("result", opreatorResult);
        model.addAttribute("resultMsg", opreatorResult ? "Modify successful" : "Modify failed");
        return "redirect:/modify/" + newShortName;
    }
}
