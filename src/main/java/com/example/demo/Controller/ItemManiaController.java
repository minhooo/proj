package com.example.demo.Controller;

import com.example.demo.entity.Board;
import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.slf4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.rmi.server.ExportException;

@Controller
public class ItemManiaController {
    private static final Logger log =
            LoggerFactory.getLogger(ItemManiaController.class);
    @Autowired
    private ItemService service;

    @GetMapping("/getItemRegister")
    public String getRegister(Item item, Model model)
            throws Exception {
        log.info("getItemRegister()");

        return "item/register";
    }

    @PostMapping("/postItemRegister")
    public String postRegister(Item item, Model model)
            throws Exception {
        log.info("postItemRegister()");

        service.register(item);

        model.addAttribute(
                "msg",
                "Register Success");

        return "item/success";
    }

    @GetMapping("/itemlist")
    public String list(Model model) throws Exception{
        log.info("itemlist()");
        model.addAttribute(
                "list",
                service.list());

        return "item/list";
    }
    @GetMapping("/itemread")
    public String read(Integer id, Model model) throws Exception {
        log. info("read()");

        model.addAttribute(service.read(id));

        return "item/read";
    }

    @PostMapping("/itemremove")
    public String remove(int Id, Model model)
            throws Exception{
        log.info("itemremove()");

        service.remove(Id);

        model.addAttribute("msg", "Success Delete!");

        return "item/success";
    }

    @GetMapping("/getitemModify")
    public String modify(int Id, Model model)
            throws Exception{

        log.info("getitemModify()");

        model.addAttribute(service.read(Id));

        return "board/modify";
    }

    @PostMapping("/postitemModify")
    public String modify(Item item, Model model)
            throws Exception{

        log.info("postitemModify()");

        service.modify(item);

        model.addAttribute("msg", "Modify Success");

        return "board/success";
    }

}
