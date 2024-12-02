package losky2987.myshorturl.controller;

import losky2987.myshorturl.db.LinkConvertColumn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static losky2987.myshorturl.db.dumyLCC.getDumyLCC;

@Controller
public class MgrController {
    @GetMapping("/")
    public String index(Model model) throws Exception{
        model.addAttribute("version", "0.0.0.3 Alpha");
        List<LinkConvertColumn> dumy = getDumyLCC();
        model.addAttribute("linksData", dumy);
        model.addAttribute("numberOfLinks", dumy.size());
        model.addAttribute("isMultipleLinks", dumy.size() == 1 ? "link" : "links");
        return "mgr";
    }

    @PostMapping("/links/modify/{sn}")
    public String modifyLink(@PathVariable("sn") String sn, Model model) throws Exception{
        System.out.println(sn + " modified");
        model.addAttribute("toBeModified", sn);
        return "redirect:/modify/" + sn;
    }

    @PostMapping("/links/delete/{sn}")
    public String deleteLink(@PathVariable("sn") String sn, Model model) throws Exception{
        System.out.println(sn + " deleted");
        model.addAttribute("toBeDeleted", sn);
        return "mgr";
    }
}
