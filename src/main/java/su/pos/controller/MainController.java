package su.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;


import su.pos.domain.User;
import su.pos.sevice.UserDAO;


import java.util.List;

@Controller
public class MainController {

    @Autowired
    public UserDAO userDaoImpl;

    //Привязываем обработку запроса "/" к этому методу. Метод кладет в модель аттрибут "user" для поиска юзера по имени
    @RequestMapping("/")
    public String home(Model model)
    {
        model.addAttribute("user", new User());

        return "mainPage";
    }
    // Метод обрабатывает постраничный (по 10 записей на страницу) вывод списка юзеров
    @RequestMapping(value="/ListUsers")
    public String listUsers(@RequestParam("page") int page,  Model model)
    {
        List<User> list=userDaoImpl.getUsers(page,10);
        model.addAttribute("allUsersListSize", userDaoImpl.getAll().size());
        model.addAttribute("listOfUsers",list);
        return "userList";
    }
    //отрисовка формы для редактирования данных юзера и передача аттрибуту edituser параметров редактируемого юзера
    @RequestMapping(value="/edit/{id}/", method=RequestMethod.GET)
    public String editUser(@PathVariable("id") int id, Model model)
    {
        User user=userDaoImpl.getUser(id);
        model.addAttribute("editeduser",user);
        return "editpage";
    }
    // Метод отправки данных формы и изменения данных выбранного юзера
        @RequestMapping(value="/edit/{id}/", method=RequestMethod.POST)
    public String editedUser(@ModelAttribute("editeduser") User user, @PathVariable("id") int id)
    {
        userDaoImpl.editUser(user);
        return "redirect:/";
    }
    // метод удаления юзера по его id
    @RequestMapping(value="/remove/{id}/")
    public String removeUser(@PathVariable("id") int id)
    {
        userDaoImpl.removeUser(userDaoImpl.getUser(id));
        return "redirect:/ListUsers?page=1&count=10";
    }
    //отрисовка формы добавления юзера и передача в атрибут newUser параметров нового юзера
    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
        model.addAttribute("newUser", new User());
        return "addpage";
    }
    // проверка на нулевое имя (правильнее использовать @Valid , но пусть это будет вер.1.0) и добавление пользователя в базу
    @RequestMapping(value= "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        if (user.getName()==null || user.getName().length()==0)
            return "addpage";
        else {
            userDaoImpl.setUser(user);
        return "redirect:/";
        }
    }
    // Поиск юзера (списка юзеров) по имени и отрисовка таблицы
    @RequestMapping(value="/user/")
    public String findByName(@RequestParam("name") String name, @RequestParam(value = "page", required = false) Integer page,
                             @RequestParam(value = "count", required = false) Integer count, Model model)
    {
        if (name==null || name.length()==0)
        {
            return "redirect:/";
        }
        if (page==null) page=1;
        if (count==null) count=10;
        model.addAttribute("namedUsersSize",userDaoImpl.findByName(name).size());
        model.addAttribute("listOfNamedUsers",userDaoImpl.findPagedByName(name,page,count));

        return "findByName";
    }
}
