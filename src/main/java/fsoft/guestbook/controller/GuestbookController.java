package fsoft.guestbook.controller;

import fsoft.guestbook.entity.Guestbook;
import fsoft.guestbook.repository.GuestbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GuestbookController {

    @Autowired
    GuestbookRepository guestbookEntryRepository;

    @GetMapping("/")
    public String guestbook(Model model) {
        Iterable<Guestbook> entries = guestbookEntryRepository.findAll();
        model.addAttribute("guestBookEntries", entries);
        return "guestbook";
    }

    @PostMapping("/register")
    public RedirectView register(HttpServletRequest request) {
        String name = request.getParameter("name");
        Guestbook guestbook = new Guestbook();
        guestbook.setName(name);
        guestbookEntryRepository.save(guestbook);
        return new RedirectView("/");
    }
}
